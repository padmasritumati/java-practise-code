import com.puppy.preson;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {
        List<preson> presonlist = Arrays.asList(
                new preson("padmasri","tumati",23),
                new preson("neeraja","chava",22),
                new preson("navya","ch",50),
                new preson("manoj","tumati",24),
                new preson("sasank","tumati",26)
        );
        Collections.sort(presonlist,(p1,p2)-> {return p1.getLastname().compareTo(p2.getLastname());});

        printcondition(presonlist,p -> true);
        printcondition(presonlist,(preson p)-> {return p.getLastname().startsWith("t");});

    }
    public static void printcondition(List<preson> presonList,Condition condition ){
        for (preson p:presonList) {
            if(condition.test(p)){
                System.out.println(p);
            }
        }
    }
}
interface Condition{
    boolean test(preson p);
}

