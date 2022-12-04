public class Day4 extends Day
{
    @Override
    protected Object part1()
    {
        int result = 0;
        for (String s : input)
        {
            String e0 = s.split(",")[0];
            String e1 = s.split(",")[1];
            int e0Start = Integer.parseInt(e0.split("-")[0]);
            int e0End = Integer.parseInt(e0.split("-")[1]);
            int e1Start = Integer.parseInt(e1.split("-")[0]);
            int e1End = Integer.parseInt(e1.split("-")[1]);

            if(e0Start <= e1Start && e0End >= e1End || e0Start >= e1Start && e0End <= e1End)
                result++;
        }
        return result;
    }

    @Override
    protected Object part2()
    {
        int result = 0;
        for (String s : input)
        {
            String e0 = s.split(",")[0];
            String e1 = s.split(",")[1];
            int e0Start = Integer.parseInt(e0.split("-")[0]);
            int e0End = Integer.parseInt(e0.split("-")[1]);
            int e1Start = Integer.parseInt(e1.split("-")[0]);
            int e1End = Integer.parseInt(e1.split("-")[1]);

            if(e0Start >= e1Start && e0Start <= e1End || e1Start >= e0Start && e1Start <= e0End)
                result++;
        }
        return result;
    }
}
