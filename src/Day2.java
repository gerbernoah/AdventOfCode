import java.util.ArrayList;
import java.util.Arrays;

public class Day2 extends Day
{
    @Override
    protected void compute(ArrayList<String> input)
    {
        int points = 0;
        for (String s : input)
        {
            int enemy = switch (s.split(" ")[0])
                    {
                        case "A" -> 0;  //rock
                        case "B" -> 1;  //paper
                        case "C" -> 2;  //cicors
                        default -> -1;
                    };
            int own = switch (s.split(" ")[1])
                    {
                        case "X" -> 0;  //rock      //lose  r->c, p->r, c->p
                        case "Y" -> 1;  //paper     //draw  r->r, p->p, c->c
                        case "Z" -> 2;  //cicors    //win   r->p, p->c, c->r
                        default -> -1;
                    };
            //a)
            //points += own + 1 + new int[]{3, 6, 0}[(own - enemy + 3)%3];

            //b)
            points += own * 3 + (enemy + own + 2) % 3 + 1;
        }
        System.out.println(points);
    }
}
