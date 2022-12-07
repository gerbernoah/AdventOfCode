import jdk.jshell.spi.ExecutionControl;

public class Day7 extends Day
{
    @Override
    protected Object part1()
    {
        Day7Directory root = new Day7Directory("root");
        Day7Directory currentDir = root;
        String lastCommand = "";
        for (String s : input)
        {
            String[] params = s.split(" ");
            if (params[0].equals("$"))
            {
                lastCommand = params[1];
                switch (params[1])
                {
                    case "cd" ->
                    {
                        if (params[2].equals("/"))
                            currentDir = root;
                        else if(params[2].equals(".."))
                        {
                            currentDir = currentDir.getParent();
                        }
                        else
                            currentDir = currentDir.subDirectory(new Day7Directory(params[2], currentDir));
                    }
                    case "ls" -> {}
                }
            }
            else
            {
                if (lastCommand.equals("ls"))
                {
                    if(params[0].equals("dir"))
                    {
                        currentDir.subDirectory(new Day7Directory(params[1], currentDir));
                    }
                    else
                        currentDir.subFile(Integer.parseInt(params[0]), params[1]);
                }
            }
        }
        return root.sumDirs(100000);
    }

    @Override
    protected Object part2()
    {
        Day7Directory root = new Day7Directory("root");
        Day7Directory currentDir = root;
        String lastCommand = "";
        for (String s : input)
        {
            String[] params = s.split(" ");
            if (params[0].equals("$"))
            {
                lastCommand = params[1];
                switch (params[1])
                {
                    case "cd" ->
                    {
                        if (params[2].equals("/"))
                            currentDir = root;
                        else if(params[2].equals(".."))
                        {
                            currentDir = currentDir.getParent();
                        }
                        else
                            currentDir = currentDir.subDirectory(new Day7Directory(params[2], currentDir));
                    }
                    case "ls" -> {}
                }
            }
            else
            {
                if (lastCommand.equals("ls"))
                {
                    if(params[0].equals("dir"))
                    {
                        currentDir.subDirectory(new Day7Directory(params[1], currentDir));
                    }
                    else
                        currentDir.subFile(Integer.parseInt(params[0]), params[1]);
                }
            }
        }
        int neededSpace = 30000000;
        int usedSpace = root.getSize();
        int freeSpace = 70000000 - usedSpace;
        int toDelete = neededSpace - freeSpace;

        return root.smallestSubDirAbove(toDelete);
    }
}
