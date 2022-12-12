import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Day
{
    protected ArrayList<String> input;
    public Day()
    {
        input = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/input"));
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getSimpleName() + " part 1: " + part1());
        System.out.println(this.getClass().getSimpleName() + " part 2: " + part2());
    }
    protected abstract Object part1();
    protected abstract Object part2();

    public static void main(String[] args)
    {
        new Day12();
    }
}
