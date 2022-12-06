import java.util.ArrayList;
import java.util.Arrays;

public class Day6 extends Day
{
    @Override
    protected Object part1()
    {
        char[] chars = input.get(0).toCharArray();
        ArrayList<Character> last = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            int d = 1 + last.lastIndexOf(chars[i]);
            while (d-->0) last.remove(d);
            last.add(chars[i]);
            if (last.size() == 4) return i+1;
        }
        return -1;
    }

    @Override
    protected Object part2()
    {
        char[] chars = input.get(0).toCharArray();
        ArrayList<Character> last = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            int d = 1 + last.lastIndexOf(chars[i]);
            while (d-->0) last.remove(d);
            last.add(chars[i]);
            if (last.size() == 14) return i+1;
        }
        return -1;
    }
}
