import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day13 extends Day
{
    private boolean compare(String a, String b)
    {
        if (a.charAt(0) == b.charAt(0))
            return compare(a.substring(1), b.substring(1));
        else if (a.charAt(0) == ']')
            return true;
        else if (b.charAt(0) == ']')
            return false;
        else if (a.charAt(0) == '[')
            return compare(a.substring(1), b.charAt(0) + "]" + b.substring(1));
        else if (b.charAt(0) == '[')
            return compare(a.charAt(0) + "]" + a.substring(1), b.substring(1));
        else
            return a.charAt(0) < b.charAt(0);
    }

    @Override
    protected Object part1()
    {
        input.replaceAll(s -> s.replace("10", "A"));
        int result = 0;
        for (int i = 0; i < (input.size() + 1) / 3; i++)
        {
            String left = input.get(3 * i);
            String right = input.get(3 * i + 1);

            if (compare(left, right))
            {
                result += i + 1;
            }
        }
        return result;
    }

    @Override
    protected Object part2()
    {
        input.removeIf(String::isEmpty);
        List<String> toSort = List.of("[[2]]", "[[6]]");
        int[] place = new int[toSort.size()];
        Arrays.fill(place, 1);

        for (String s : input)
            for (int j = 0; j < toSort.size(); j++)
                if (compare(s, toSort.get(j)))
                    place[j]++;

        for (int i = 0; i < toSort.size(); i++)
            for (int j = 0; j < toSort.size(); j++)
                if (j != i && compare(toSort.get(j), toSort.get(i)))
                    place[i]++;

        int result = 1;
        for (int i : place) result *= i;
        return result;
    }
}
