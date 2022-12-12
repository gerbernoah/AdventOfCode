import java.awt.*;
import java.util.Arrays;

public class Day12 extends Day
{
    private void calcDistance(int[][] height, int[][] cost, int srcCost, Point dst)
    {
        if (srcCost + 1 < cost[dst.y][dst.x])
        {
            cost[dst.y][dst.x] = srcCost + 1;
            if (dst.y + 1 < cost.length)
                calcDistance(height, cost, dst, new Point(dst.x, dst.y + 1));
            if (dst.y - 1 >= 0)
                calcDistance(height, cost, dst, new Point(dst.x, dst.y - 1));
            if (dst.x + 1 < cost[dst.y].length)
                calcDistance(height, cost, dst, new Point(dst.x + 1, dst.y));
            if (dst.x - 1 >= 0)
                calcDistance(height, cost, dst, new Point(dst.x - 1, dst.y));
        }
    }
    private void calcDistance(int[][] height, int[][] cost, Point src, Point dst)
    {
        if (height[src.y][src.x] + 1 < height[dst.y][dst.x])
        {
            if (src.equals(new Point(0,20)))
                System.out.println("src: " + src.y + "," + src.x + " dst: " + dst.y + "," + dst.x);
            return;
        }
        //possible move

        calcDistance(height, cost, cost[src.y][src.x], dst);
    }

    @Override
    protected Object part1()
    {
        System.out.println(input.size());
        System.out.println(input.get(0).length());
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Point start = new Point(-1, -1);
        Point end = new Point(-1, -1);
        int[][] height = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++)
        {
            String line = input.get(i);
            for (int j = 0; j < line.toCharArray().length; j++)
            {
                String cur = String.valueOf(line.charAt(j));
                if (cur.equals("S"))
                {
                    start = new Point(j, i);
                    height[i][j] = 0;
                }
                else if (cur.equals("E"))
                {
                    end = new Point(j, i);
                    height[i][j] = 25;
                }
                else height[i][j] = alphabet.indexOf(cur);
            }
        }

        System.out.println("Start: " + start.y + "," + start.x);
        System.out.println("End: " + end.y + "," + end.x);

        int[][] cost = new int[input.size()][input.get(0).length()];
        for (int[] ints : cost)
            Arrays.fill(ints, Integer.MAX_VALUE);

        calcDistance(height, cost, -1, start);

        return cost[end.y][end.x];
    }

    @Override
    protected Object part2()
    {
        System.out.println(input.size());
        System.out.println(input.get(0).length());
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Point start = new Point(-1, -1);
        Point end = new Point(-1, -1);
        int[][] height = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++)
        {
            String line = input.get(i);
            for (int j = 0; j < line.toCharArray().length; j++)
            {
                String cur = String.valueOf(line.charAt(j));
                if (cur.equals("S"))
                {
                    start = new Point(j, i);
                    height[i][j] = 0;
                }
                else if (cur.equals("E"))
                {
                    end = new Point(j, i);
                    height[i][j] = 25;
                }
                else height[i][j] = alphabet.indexOf(cur);
            }
        }

        System.out.println("Start: " + start.y + "," + start.x);
        System.out.println("End: " + end.y + "," + end.x);

        int[][] cost = new int[input.size()][input.get(0).length()];
        for (int[] ints : cost)
            Arrays.fill(ints, Integer.MAX_VALUE);

        for (int i = 0; i < height.length; i++)
            for (int j = 0; j < height[i].length; j++)
                if(height[i][j] == 0) calcDistance(height, cost, -1, new Point(j, i));

        return cost[end.y][end.x];
    }
}
