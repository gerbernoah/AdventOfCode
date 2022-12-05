import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Day5 extends Day
{
    @Override
    protected Object part1()
    {
        StringBuilder result = new StringBuilder(" ");
        Stack<String>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++)
        {
            stacks[i] = new Stack<>();
        }
        stacks[0].push("W");
        stacks[0].push("D");
        stacks[0].push("G");
        stacks[0].push("B");
        stacks[0].push("H");
        stacks[0].push("R");
        stacks[0].push("V");

        stacks[1].push("J");
        stacks[1].push("N");
        stacks[1].push("G");
        stacks[1].push("C");
        stacks[1].push("R");
        stacks[1].push("F");

        stacks[2].push("L");
        stacks[2].push("S");
        stacks[2].push("F");
        stacks[2].push("H");
        stacks[2].push("D");
        stacks[2].push("N");
        stacks[2].push("J");

        stacks[3].push("J");
        stacks[3].push("D");
        stacks[3].push("S");
        stacks[3].push("V");

        stacks[4].push("S");
        stacks[4].push("H");
        stacks[4].push("D");
        stacks[4].push("R");
        stacks[4].push("Q");
        stacks[4].push("W");
        stacks[4].push("N");
        stacks[4].push("V");

        stacks[5].push("P");
        stacks[5].push("G");
        stacks[5].push("H");
        stacks[5].push("C");
        stacks[5].push("M");

        stacks[6].push("F");
        stacks[6].push("J");
        stacks[6].push("B");
        stacks[6].push("G");
        stacks[6].push("L");
        stacks[6].push("Z");
        stacks[6].push("H");
        stacks[6].push("C");

        stacks[7].push("S");
        stacks[7].push("J");
        stacks[7].push("R");

        stacks[8].push("L");
        stacks[8].push("G");
        stacks[8].push("S");
        stacks[8].push("R");
        stacks[8].push("B");
        stacks[8].push("N");
        stacks[8].push("V");
        stacks[8].push("M");

        for (int i = 10; i < input.size(); i++)
        {
            String[] instructions = input.get(i).split(" ");

            for (int j = 0; j < Integer.parseInt(instructions[1]); j++)
            {
                String crate = stacks[Integer.parseInt(instructions[3])-1].pop();
                stacks[Integer.parseInt(instructions[5])-1].push(crate);
            }
        }

        for (Stack<String> stack : stacks)
        {
            result.append(stack.peek());
        }
        return result.toString();
    }

    @Override
    protected Object part2()
    {
        StringBuilder result = new StringBuilder(" ");
        Stack<String>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++)
        {
            stacks[i] = new Stack<>();
        }
        stacks[0].push("W");
        stacks[0].push("D");
        stacks[0].push("G");
        stacks[0].push("B");
        stacks[0].push("H");
        stacks[0].push("R");
        stacks[0].push("V");

        stacks[1].push("J");
        stacks[1].push("N");
        stacks[1].push("G");
        stacks[1].push("C");
        stacks[1].push("R");
        stacks[1].push("F");

        stacks[2].push("L");
        stacks[2].push("S");
        stacks[2].push("F");
        stacks[2].push("H");
        stacks[2].push("D");
        stacks[2].push("N");
        stacks[2].push("J");

        stacks[3].push("J");
        stacks[3].push("D");
        stacks[3].push("S");
        stacks[3].push("V");

        stacks[4].push("S");
        stacks[4].push("H");
        stacks[4].push("D");
        stacks[4].push("R");
        stacks[4].push("Q");
        stacks[4].push("W");
        stacks[4].push("N");
        stacks[4].push("V");

        stacks[5].push("P");
        stacks[5].push("G");
        stacks[5].push("H");
        stacks[5].push("C");
        stacks[5].push("M");

        stacks[6].push("F");
        stacks[6].push("J");
        stacks[6].push("B");
        stacks[6].push("G");
        stacks[6].push("L");
        stacks[6].push("Z");
        stacks[6].push("H");
        stacks[6].push("C");

        stacks[7].push("S");
        stacks[7].push("J");
        stacks[7].push("R");

        stacks[8].push("L");
        stacks[8].push("G");
        stacks[8].push("S");
        stacks[8].push("R");
        stacks[8].push("B");
        stacks[8].push("N");
        stacks[8].push("V");
        stacks[8].push("M");

        for (int i = 10; i < input.size(); i++)
        {
            String[] instructions = input.get(i).split(" ");

            ArrayList<String> crane = new ArrayList<>();
            for (int j = 0; j < Integer.parseInt(instructions[1]); j++)
            {
                String crate = stacks[Integer.parseInt(instructions[3])-1].pop();
                crane.add(crate);
            }
            for (int j = crane.size()-1; j >= 0; j--)
            {
                stacks[Integer.parseInt(instructions[5])-1].push(crane.get(j));
            }
        }

        for (Stack<String> stack : stacks)
        {
            result.append(stack.peek());
        }
        return result.toString();
    }
}
