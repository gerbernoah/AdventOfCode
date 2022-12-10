import java.util.ArrayList;
import java.util.Arrays;

public class Day6 extends Day
{
    @Override
    protected Object part1(){ return findFirstMarker(4);}

    @Override
    protected Object part2(){ return findFirstMarker(14);}

    private int findFirstMarker(int seq)
    {
        char[] chars = input.get(0).toCharArray();
        ArrayList<Character> last = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            int d = 1 + last.lastIndexOf(chars[i]);
            while (d-->0) last.remove(d);
            last.add(chars[i]);
            if (last.size() == seq) return i+1;
        }
        return -1;
    }
}
