import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14 extends Day
{
    private Point[] getPointsBetween(Point p1, Point p2)
    {
        List<Point> between = new ArrayList<>();
        if (p1.y == p2.y)
            for (int i = Math.min(p1.x, p2.x); i <= Math.max(p1.x, p2.x); i++)
                between.add(new Point(i, p1.y));
        else if (p1.x == p2.x)
            for (int i = Math.min(p1.y, p2.y); i <= Math.max(p1.y, p2.y); i++)
                between.add(new Point(p1.x, i));
        else assert false;

        return between.toArray(new Point[]{});
    }

    public Material[][] parseInput(boolean part2)
    {
        int width = 0;
        int height = 0;
        for (String value : input)
            for (String s : value.split(" -> "))
            {
                width = Math.max(width, Integer.parseInt(s.split(",")[0]));
                height = Math.max(height, Integer.parseInt(s.split(",")[1]));
            }

        Material[][] cave = new Material[height + (part2 ? 3 : 1)][Math.max(width, 500) + (part2 ? height : 1)];
        for (Material[] row : cave)
            Arrays.fill(row, Material.AIR);
        if (part2) Arrays.fill(cave[cave.length - 1], Material.STONE);
        cave[0][500] = Material.SAND_GENERATOR;

        for (String s : input)
        {
            String[] coordinates = s.split(" -> ");
            for (int i = 1; i < coordinates.length; i++)
            {
                Point[] stones = getPointsBetween(
                        new Point(
                                Integer.parseInt(coordinates[i - 1].split(",")[0]),
                                Integer.parseInt(coordinates[i - 1].split(",")[1])
                        ),
                        new Point(
                                Integer.parseInt(coordinates[i].split(",")[0]),
                                Integer.parseInt(coordinates[i].split(",")[1])
                        ));
                for (Point stone : stones)
                {
                    cave[stone.y][stone.x] = Material.STONE;
                }
            }
        }

        return cave;
    }

    private boolean simulateSand(Material[][] cave, boolean part2)
    {
        Point gen = null;
        for (int i = 0; i < cave.length; i++)
            for (int j = 0; j < cave[i].length; j++)
            {
                switch (cave[i][j])
                {
                    case SAND_GENERATOR:
                        gen = new Point(j, i);
                    case SAND:
                        if (i + 1 >= cave.length) return true;
                        else if (cave[i + 1][j] == Material.AIR)
                        {
                            cave[i][j] = Material.AIR;
                            cave[i + 1][j] = Material.SAND;
                        }
                        else if (j - 1 < 0) return true;
                        else if (cave[i + 1][j - 1] == Material.AIR)
                        {
                            cave[i][j] = Material.AIR;
                            cave[i + 1][j - 1] = Material.SAND;
                        }
                        else if (j + 1 >= cave[i].length) return true;
                        else if (cave[i + 1][j + 1] == Material.AIR)
                        {
                            cave[i][j] = Material.AIR;
                            cave[i + 1][j + 1] = Material.SAND;
                        }
                        break;
                }
            }
        if (gen != null)
            cave[gen.y][gen.x] = Material.SAND_GENERATOR;
        return false;
    }

    private void printCave(int startX, Material[][] cave)
    {
        for (int i = 0; i < cave.length; i++)
        {
            for (int j = startX; j < cave[i].length; j++)
            {
                switch (cave[i][j])
                {
                    case SAND_GENERATOR -> System.out.print("+");
                    case SAND -> System.out.print("O");
                    case AIR -> System.out.print(".");
                    case STONE -> System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    @Override
    protected Object part1()
    {
        int result = 0;
        Material[][] cave = parseInput(false);

        int n = 0;
        while (true)
        {
            Material[][] next = new Material[cave.length][cave[0].length];
            for (int i = 0; i < next.length; i++)
                System.arraycopy(cave[i], 0, next[i], 0, next[i].length);

            if (simulateSand(cave, false) || Arrays.deepEquals(next, cave)) break;
            result++;
        }
        return result;
    }

    @Override
    protected Object part2()
    {
        int result = 1;
        Material[][] cave = parseInput(true);

        int n = 0;
        while (true)
        {
            Material[][] next = new Material[cave.length][cave[0].length];
            for (int i = 0; i < next.length; i++)
                System.arraycopy(cave[i], 0, next[i], 0, next[i].length);

            if (simulateSand(cave, true) || Arrays.deepEquals(next, cave)) break;
            result++;
        }
        return result;
    }

    enum Material
    {
        AIR,
        STONE,
        SAND,
        SAND_GENERATOR;
    }
}
