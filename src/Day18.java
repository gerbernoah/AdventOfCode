import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class Day18 extends Day
{
    @Override
    protected Object part1()
    {
        int result = 0;
        Set<Cube> cubes = new HashSet<>();
        for (String s : input)
        {
            Cube cur = new Cube(
                    Integer.parseInt(s.split(",")[0]),
                    Integer.parseInt(s.split(",")[1]),
                    Integer.parseInt(s.split(",")[2]));
            cubes.add(cur);

            result += 6;
            for (Cube neighbor : cur.neighbors())
                if (cubes.contains(neighbor)) result -= 2;
        }
        return result;
    }

    @Override
    protected Object part2()
    {
        int result = 0;
        Set<Cube> cubes = new HashSet<>();
        for (String s : input)
        {
            Cube cur = new Cube(
                    Integer.parseInt(s.split(",")[0]),
                    Integer.parseInt(s.split(",")[1]),
                    Integer.parseInt(s.split(",")[2]));

            cubes.add(cur);

            result += 6;
            for (Cube neighbor : cur.neighbors())
                if (cubes.contains(neighbor)) result -= 2;
        }
        Cube max = new Cube(0,0,0);
        for (Cube cube : cubes)
            max = new Cube(Math.max(max.x, cube.x), Math.max(max.y, cube.y), Math.max(max.z, cube.z));

        Set<Cube> interior = new HashSet<>();
        Set<Cube> checked = new HashSet<>();

        for (int x = 0; x < max.x; x++)
            for (int y = 0; y < max.y; y++)
                for (int z = 0; z < max.z; z++)
                {
                    Cube cur = new Cube(x, y, z);
                    if (cubes.contains(cur) || checked.contains(cur)) continue;

                    List<Cube> air = new ArrayList<>();
                    if (connectedAir(cubes, air, cur, max)) interior.addAll(air);
                    checked.addAll(air);
                }
        for (Cube point : interior)
            for (Cube neighbor : point.neighbors())
                if (cubes.contains(neighbor)) result--;

        return result;
    }

    private boolean connectedAir(Set<Cube> solid, List<Cube> checked, Cube start, Cube max)
    {
        Queue<Cube> queue = new LinkedTransferQueue<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            Cube cur = queue.poll();
            if (cur.x > max.x || cur.y > max.y || cur.z > max.z) return false;
            checked.add(cur);
            for (Cube neighbor : cur.neighbors().stream().filter(cube ->
                    !solid.contains(cube) && !checked.contains(cube) && !queue.contains(cube)).toList())
                    queue.offer(neighbor);
        }

        return true;
    }

    private class Cube
    {
        int x, y, z;
        public Cube(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString()
        {
            return x + "," + y + "," + z;
        }

        public Set<Cube> neighbors()
        {
            Set<Cube> neighbors = new HashSet<>();
            neighbors.add(new Cube(x + 1, y, z));
            neighbors.add(new Cube(x - 1, y, z));
            neighbors.add(new Cube(x, y + 1, z));
            neighbors.add(new Cube(x, y - 1, z));
            neighbors.add(new Cube(x, y, z + 1));
            neighbors.add(new Cube(x, y, z - 1));

            return neighbors;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Cube point = (Cube) o;

            if (x != point.x)
                return false;
            if (y != point.y)
                return false;
            return z == point.z;
        }

        @Override
        public int hashCode()
        {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }
}