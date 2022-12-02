import java.util.ArrayList;

public class Day2 extends Day
{
    @Override
    protected void compute(ArrayList<String> input)
    {
        int points = 0;
        for (String s : input)
        {
            int enemy = "ABC".indexOf(s.split(" ")[0]);
            int own = "XYZ".indexOf(s.split(" ")[1]);
            //points += own + 1 + new int[]{3, 6, 0}[(own - enemy + 3)%3];  //a
            points += own * 3 + (enemy + own + 2) % 3 + 1;                  //b
        }
        System.out.println(points);
    }
}
