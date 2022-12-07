import java.util.ArrayList;
import java.util.Objects;

public class Day7Directory
{
    private String name;
    private ArrayList<Day7Directory> subDirs;
    private ArrayList<File> files;
    private Day7Directory parent;

    public Day7Directory(String name)
    {
        files = new ArrayList<>();
        subDirs = new ArrayList<>();
        this.name = name;
    }

    public Day7Directory(String name, Day7Directory parent)
    {
        this(name);
        this.parent = parent;
    }

    public Day7Directory getParent()
    {
        return parent;
    }

    public int sumDirs(int upperThreshold)
    {
        int sum = 0;
        if (getSize() <= upperThreshold)
            sum += getSize();
        for (Day7Directory subDir : subDirs)
            sum += subDir.sumDirs(upperThreshold);
        return sum;
    }

    public int smallestSubDirAbove(int lowerThreshold)
    {
        if(getSize() <= lowerThreshold)
            return Integer.MAX_VALUE;
        int min = getSize();
        for (Day7Directory subDir : subDirs)
            min = Math.min(subDir.smallestSubDirAbove(lowerThreshold), min);
        return min;
    }

    public File subFile(int size, String name)
    {
        File subFile = new File(size, name);
        for (File file : files)
            if(file.equals(subFile))
                return file;
        files.add(subFile);
        return subFile;
    }

    public Day7Directory subDirectory(Day7Directory subDir)
    {
        for (Day7Directory dir : subDirs)
            if(dir.equals(subDir))
                return dir;
        subDirs.add(subDir);
        return subDir;
    }

    public int getSize()
    {
        int size = 0;
        for (File file : files)
            size += file.getSize();
        for (Day7Directory subDir : subDirs)
            size += subDir.getSize();

        return size;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Day7Directory that = (Day7Directory) o;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode()
    {
        return subDirs != null ? subDirs.hashCode() : 0;
    }


    public class File
    {
        int size;
        String name;
        File(int size, String name)
        {
            this.size = size;
            this.name = name;
        }
        public int getSize()
        {
            return size;
        }

        public String getName()
        {
            return name;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            File file = (File) o;

            return Objects.equals(name, file.name);
        }

        @Override
        public int hashCode()
        {
            return name != null ? name.hashCode() : 0;
        }
    }
}
