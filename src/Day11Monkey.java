import java.util.ArrayList;

public class Day11Monkey
{
    private Long activity;
    private ArrayList<Long> items;
    private Operator operator;
    private Tester tester;
    private Worry worry;
    public Day11Monkey()
    {
        this.items = new ArrayList<>();
        activity = 0L;
    }

    public void throwItems()
    {
        while (!items.isEmpty())
        {
            activity++;
            Long item = worry.modify(operator.operate(items.remove(0)));
            tester.test(item).addItem(item);
        }
    }

    public void addItem(Long item)
    {
        items.add(item);
    }

    public Long getActivity()
    {
        return activity;
    }

    public void setOperator(Operator operator)
    {
        this.operator = operator;
    }

    public void setTester(Tester tester)
    {
        this.tester = tester;
    }

    public void setWorry(Worry worry)
    {
        this.worry = worry;
    }

    public interface Operator
    {
        public Long operate(Long a);
    }

    public interface Tester
    {
        public Day11Monkey test(Long a);
    }

    public interface Worry
    {
        public Long modify(Long a);
    }
}
