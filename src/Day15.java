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
        Point[] scanners = new Point[input.size()];
        Point[] beacons = new Point[input.size()];
        for (int i = 0; i < input.size(); i++)
        {
            String[] words = input.get(i).split(" ");
            scanners[i] = new Point(
                    Integer.parseInt(words[2].split("=")[1].replace(",", "")),
                    Integer.parseInt(words[3].split("=")[1].replace(":", ""))
            );
            beacons[i] = new Point(
                    Integer.parseInt(words[8].split("=")[1].replace(",", "")),
                    Integer.parseInt(words[9].split("=")[1])
            );
        }

        for (int i = 0; i <= 4000000; i++)
        {
            for (int j = 0; j <= 4000000; j++)
            {
                Point cur = new Point(j, i);
                boolean isBeacon = true;
                for (int k = 0; k < scanners.length; k++)
                {
                    Point scanner = scanners[k];
                    Point beacon = beacons[k];
                    if (distance(scanner, beacon) > distance(scanner, cur))
                    {
                        isBeacon = false;
                        j = scanner.x + distance(scanner, beacon) - Math.abs(scanner.y - i);
                        break;
                    }
                }
                if (isBeacon) return (long) (cur.x * 4000000L + cur.y);
            }
        }
        return null;
    }

}


