import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Day9 extends Day
{
    @Override
    protected Object part1()
    {
        Point[] rope = new Point[2];
        rope[0] = new Point(0, 0);
        rope[1] = new Point(0, 0);
        ArrayList<Point> tailMoves = new ArrayList<>();

        for (String s : input)
        {
            String[] params = s.split(" ");
            int distance = Integer.parseInt(params[1]);
            while (distance-->0)
            {
                switch (params[0])
                {
                    case "R" -> rope[0].x++;
                    case "L" -> rope[0].x--;
                    case "U" -> rope[0].y--;
                    case "D" -> rope[0].y++;
                }

                if (rope[1].distanceSq(rope[0]) > 2)
                    rope[1].translate(
                            Integer.compare(rope[0].x - rope[1].x, 0),
                            Integer.compare(rope[0].y - rope[1].y, 0));

                if (!tailMoves.contains(rope[1]))
                    tailMoves.add(new Point(rope[1]));
            }
        }
        return tailMoves.size();
    }

    @Override
    protected Object part2()
    {
        ArrayList<Point> tailMoves = new ArrayList<>();
        Point[] rope = new Point[10];
        for (int i = 0; i < rope.length; i++)
            rope[i] = new Point(0, 0);

        for (String s : input)
        {
            String[] params = s.split(" ");
            int distance = Integer.parseInt(params[1]);
            while (distance-->0)
            {
                switch (params[0])
                {
                    case "R" -> rope[0].x++;
                    case "L" -> rope[0].x--;
                    case "U" -> rope[0].y--;
                    case "D" -> rope[0].y++;
                }

                for (int i = 1; i < rope.length; i++)
                    if (rope[i].distanceSq(rope[i-1]) > 2)
                        rope[i].translate(
                                Integer.compare(rope[i-1].x - rope[i].x, 0),
                                Integer.compare(rope[i-1].y - rope[i].y, 0)
                        );

                if (!tailMoves.contains(rope[9]))
                    tailMoves.add(new Point(rope[9]));
            }
        }
        return tailMoves.size();
    }
}
