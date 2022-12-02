public class Day1 extends Day
{
    @Override
    protected Object part1()
    {
        int cur = 0, max = 0;
        for (String s : input)
            if (s.isEmpty())
            {
                max = Math.max(cur, max);
                cur = 0;
            } else
                cur += Integer.parseInt(s);
        return max;
    }

    @Override
    protected Object part2()
    {
        int cur = 0, max = 0, max1 = 0, max2 = 0;
        for (String s : input)
        {
            if (s.isEmpty())
            {
                if (cur > max)
                {
                    max2 = max1;
                    max1 = max;
                    max = cur;
                } else if (cur > max1)
                {
                    max2 = max1;
                    max1 = cur;
                } else if (cur > max2)
                {
                    max2 = cur;
                }
                cur = 0;
            }
            else cur += Integer.parseInt(s);
        }
        return max + max1 + max2;
    }
}