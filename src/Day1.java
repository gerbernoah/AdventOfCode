import java.util.ArrayList;

public class Day1 extends Day
{
    @Override
    protected void compute(ArrayList<String> input)
    {
        int cur = 0, max = 0, max1 = 0, max2 = 0, max3 = 0;
        for (String s : input)
        {
            if (s.isEmpty())
            {
                if (cur > max)
                {
                    max3 = max2;
                    max2 = max;
                    max = cur;
                } else if (cur > max2)
                {
                    max3 = max2;
                    max2 = cur;
                } else if (cur > max3)
                {
                    max3 = cur;
                }
                cur = 0;
            }
            else cur += Integer.parseInt(s);
        }
    }
}