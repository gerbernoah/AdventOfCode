import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Day
{
    public Day()
    {
        ArrayList<String> input = new ArrayList<>();
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
        compute(input);
    }

    protected abstract void compute(ArrayList<String> input);

    public static void main(String[] args)
    {
        new Day2();
    }
}
