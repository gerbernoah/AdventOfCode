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
            String enemy = s.split(" ")[0];
            String hasTo = s.split(" ")[1];
            String own = "";
            switch (hasTo)
            {
                case "X":
                    switch (enemy)
                    {
                        case "A":
                            own = "Z";
                            break;
                        case "B":
                            own = "X";
                            break;
                        case "C":
                            own = "Y";
                            break;
                    }
                    break;
                case "Y":
                    switch (enemy)
                    {
                        case "A":
                            own = "X";
                            break;
                        case "B":
                            own = "Y";
                            break;
                        case "C":
                            own = "Z";
                            break;
                    }
                    break;
                case "Z":
                    switch (enemy)
                    {
                        case "A":
                            own = "Y";
                            break;
                        case "B":
                            own = "Z";
                            break;
                        case "C":
                            own = "X";
                            break;
                    }
                    break;
            }
            //calc points
            switch (own)
            {
                case "X":
                    points += 1;
                    switch (enemy)
                    {
                        case "A":
                            points += 3;
                            break;
                        case "B":
                            break;
                        case "C":
                            points += 6;
                            break;
                    }
                    break;
                case "Y":
                    points += 2;
                    switch (enemy)
                    {
                        case "A":
                            points += 6;
                            break;
                        case "B":
                            points += 3;
                            break;
                        case "C":
                            break;
                    }
                    break;
                case "Z":
                    points += 3;
                    switch (enemy)
                    {
                        case "A":
                            break;
                        case "B":
                            points += 6;
                            break;
                        case "C":
                            points += 3;
                            break;
                    }
                    break;
            }
        }
        System.out.println(points);
    }
}
