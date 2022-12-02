public class Day2 extends Day
{
    @Override
    protected Object part1()
    {
        int points = 0;
        for (String s : input)
        {
            int enemy = "ABC".indexOf(s.split(" ")[0]);
            int own = "XYZ".indexOf(s.split(" ")[1]);
            points += own + 1 + new int[]{3, 6, 0}[(own - enemy + 3)%3];
        }
        return points;
    }

    @Override
    protected Object part2()
    {
        int points = 0;
        for (String s : input)
        {
            int enemy = "ABC".indexOf(s.split(" ")[0]);
            int own = "XYZ".indexOf(s.split(" ")[1]);
            points += own * 3 + (enemy + own + 2) % 3 + 1;
        }
        return points;
    }
}
