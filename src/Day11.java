import java.util.Arrays;
import java.util.List;

public class Day11 extends Day
{
    @Override
    protected Object part1()
    {
        Day11Monkey[] monkeys = new Day11Monkey[(input.size()+1)/7];
        for (int i = 0; i < monkeys.length; i++)
            monkeys[i] = new Day11Monkey();

        for (int i = 0; i < monkeys.length; i++)
        {
            String[] items = input.get(7 * i + 1).split(" ");
            for (int j = 4; j < items.length; j++)
                monkeys[i].addItem(Long.parseLong(items[j].replace(",", "")));

            String[] operator = input.get(7 * i + 2).split(" ");
            monkeys[i].setOperator(old ->
            {
                Long value = switch (operator[7])
                        {
                            case "old" -> old;
                            default -> Long.parseLong(operator[7]);
                        };
                return switch (operator[6])
                        {
                            case "*" -> old * value;
                            case "+" -> old + value;
                            case "-" -> old - value;
                            case "/" -> old / value;
                            default -> -1L;
                        };
            });

            Long divisor = Long.parseLong(input.get(7 * i + 3).split(" ")[5]);
            int trueMonkey = Integer.parseInt(input.get(7 * i + 4).split(" ")[9]);
            int falseMonkey = Integer.parseInt(input.get(7 * i + 5).split(" ")[9]);

            monkeys[i].setTester(a -> a % divisor == 0 ? monkeys[trueMonkey] : monkeys[falseMonkey]);
            monkeys[i].setWorry(a -> a / 3);
        }

        for (int i = 0; i < 20; i++)
            for (Day11Monkey monkey : monkeys)
                monkey.throwItems();

        List<Long> monkeyBusiness = Arrays.stream(monkeys).map(Day11Monkey::getActivity).sorted().toList();

        return monkeyBusiness.get(monkeyBusiness.size() - 1) * monkeyBusiness.get(monkeyBusiness.size() - 2);
    }

    @Override
    protected Object part2()
    {
        Day11Monkey[] monkeys = new Day11Monkey[(input.size()+1)/7];
        for (int i = 0; i < monkeys.length; i++)
            monkeys[i] = new Day11Monkey();

        int shorten = 1;
        for (int i = 0; i < monkeys.length; i++)
        {
            String[] items = input.get(7 * i + 1).split(" ");
            for (int j = 4; j < items.length; j++)
                monkeys[i].addItem(Long.parseLong(items[j].replace(",", "")));

            String[] operator = input.get(7 * i + 2).split(" ");
            monkeys[i].setOperator(old ->
            {
                Long value = switch (operator[7])
                        {
                            case "old" -> old;
                            default -> Long.parseLong(operator[7]);
                        };
                return switch (operator[6])
                        {
                            case "*" -> old * value;
                            case "+" -> old + value;
                            case "-" -> old - value;
                            case "/" -> old / value;
                            default -> -1L;
                        };
            });

            Long divisor = Long.parseLong(input.get(7 * i + 3).split(" ")[5]);
            shorten *= divisor;
            int trueMonkey = Integer.parseInt(input.get(7 * i + 4).split(" ")[9]);
            int falseMonkey = Integer.parseInt(input.get(7 * i + 5).split(" ")[9]);

            monkeys[i].setTester(a -> a % divisor == 0 ? monkeys[trueMonkey] : monkeys[falseMonkey]);
        }
        for (int i = 0; i < monkeys.length; i++)
        {
            int finalShorten = shorten;
            monkeys[i].setWorry(a -> a % finalShorten);
        }
        for (int i = 0; i < 10000; i++)
            for (Day11Monkey monkey : monkeys)
                monkey.throwItems();

        List<Long> monkeyBusiness = Arrays.stream(monkeys).map(Day11Monkey::getActivity).sorted().toList();

        return monkeyBusiness.get(monkeyBusiness.size() - 1) * monkeyBusiness.get(monkeyBusiness.size() - 2);
    }
}
