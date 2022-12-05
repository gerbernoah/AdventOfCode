import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day3 extends Day
{
    @Override
    protected Object part1()
    {
        int result = 0;
        for (String s : input)
        {
            ArrayList<Character> a = new ArrayList<>();
            ArrayList<Character> b = new ArrayList<>();
            for (int i = 0; i < s.length()/2; i++)
                a.add(s.charAt(i));
            for (int i = s.length()/2; i < s.length(); i++)
                b.add(s.charAt(i));

            a.retainAll(b);
            for (Character character : a.stream().distinct().toList())
                result += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(character) + 1;

        }
        return result;
    }

    @Override
    protected Object part2()
    {
        int result = 0;
        for (int k = 0; k < input.size()/3; k++)
        {
            ArrayList<Character> a = new ArrayList<>();
            ArrayList<Character> b = new ArrayList<>();
            ArrayList<Character> c = new ArrayList<>();
            for (int i = 0; i < input.get(3*k).length(); i++)
                a.add(input.get(3*k).charAt(i));
            for (int i = 0; i < input.get(3*k + 1).length(); i++)
                b.add(input.get(3*k +1).charAt(i));
            for (int i = 0; i < input.get(3*k + 2).length(); i++)
                c.add(input.get(3*k+2).charAt(i));

            a.retainAll(b);
            a.retainAll(c);
            for (Character character : a.stream().distinct().toList())
                result += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(character) + 1;
        }
        return result;
    }
}
