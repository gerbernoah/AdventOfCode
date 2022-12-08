import java.awt.*;
import java.util.Arrays;

public class Day8 extends Day
{
    int[][] trees;
    @Override
    protected Object part1()
    {
        trees = new int[input.size()][input.get(0).toCharArray().length];
        for (int i = 0; i < input.size(); i++)
        {
            char[] chars = input.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++)
                trees[i][j] = Integer.parseInt(String.valueOf(chars[j]));
        }

        int visible = 0;
        for (int i = 0; i < trees.length; i++)
            for (int j = 0; j < trees[i].length; j++)
            {
                boolean top = true;
                for (int k = 0; k < i; k++)
                    if(trees[k][j] >= trees[i][j])
                    {
                        top = false;
                        break;
                    }
                boolean bot = true;
                for (int k = i + 1; k < trees.length; k++)
                    if(trees[k][j] >= trees[i][j])
                    {
                        bot = false;
                        break;
                    }
                boolean left = true;
                for (int k = 0; k < j; k++)
                    if(trees[i][k] >= trees[i][j])
                    {
                        left = false;
                        break;
                    }
                boolean right = true;
                for (int k = j + 1; k < trees[i].length; k++)
                    if(trees[i][k] >= trees[i][j])
                    {
                        right = false;
                        break;
                    }
                if (bot || top || left || right) visible++;
            }
        return visible;
    }

    @Override
    protected Object part2()
    {
        int score = 0;
        for (int i = 1; i < trees.length - 1; i++)
            for (int j = 1; j < trees[i].length - 1; j++)
            {
                int left = 1;
                for (int k = j - 1; k > 0; k--)
                {
                    if (trees[i][k] >= trees[i][j]) break;
                    left++;
                }
                int right = 1;
                for (int k = j + 1; k < trees[i].length - 1; k++)
                {
                    if (trees[i][k] >= trees[i][j]) break;
                    right++;
                }
                int top = 1;
                for (int k = i - 1; k > 0; k--)
                {
                    if (trees[k][j] >= trees[i][j]) break;
                    top++;
                }
                int bot = 1;
                for (int k = i + 1; k < trees.length - 1; k++)
                {
                    if (trees[k][j] >= trees[i][j]) break;
                    bot++;
                }
                score = Math.max(score, left * right * top * bot);
            }
        return score;
    }
}
