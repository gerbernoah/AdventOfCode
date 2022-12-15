import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Day15 extends Day
{
    private int distance(Point p1, Point p2)
    {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    @Override
    protected Object part1()
    {
        Set<Point> noBeacons = new HashSet<>();
        Set<Point> structures = new HashSet<>();
        for (String s : input)
        {
            String[] words = s.split(" ");
            Point sensor = new Point(
                    Integer.parseInt(words[2].split("=")[1].replace(",", "")),
                    Integer.parseInt(words[3].split("=")[1].replace(":", ""))
            );
            Point beacon = new Point(
                    Integer.parseInt(words[8].split("=")[1].replace(",", "")),
                    Integer.parseInt(words[9].split("=")[1])
            );
            structures.add(sensor);
            structures.add(beacon);
            int row = 2000000;
            int xRange = distance(sensor, beacon) - Math.abs(sensor.y - row);
            for (int j = sensor.x - xRange; j <= sensor.x + xRange; j++)
                noBeacons.add(new Point(j, row));
        }
        noBeacons.removeAll(structures);
        return noBeacons.size();
    }

    @Override
    protected Object part2()
    {
        for (int i = 3000000; i < 4000000; i++)
        {
            for (int j = 0; j < 4000000; j++)
            {
                System.out.println("cur: " + i + " " + j);
                Point cur = new Point(j, i);
                boolean isBeacon = true;
                for (String s : input)
                {
                    String[] words = s.split(" ");
                    Point sensor = new Point(
                            Integer.parseInt(words[2].split("=")[1].replace(",", "")),
                            Integer.parseInt(words[3].split("=")[1].replace(":", ""))
                    );
                    Point beacon = new Point(
                            Integer.parseInt(words[8].split("=")[1].replace(",", "")),
                            Integer.parseInt(words[9].split("=")[1])
                    );

                    if (distance(sensor, beacon) > distance(sensor, cur))
                    {
                        isBeacon = false;
                        j = Math.max(j, sensor.x + distance(sensor, beacon) - Math.abs(sensor.y - i));
                        break;
                    }
                }
                if (isBeacon) return (long) (cur.x * 4000000L + cur.y);
            }
        }
        return null;
    }

}


