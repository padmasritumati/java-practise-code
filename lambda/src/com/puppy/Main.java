package com.puppy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<preson> presonlist = Arrays.asList(
                new preson("padmasri","tumati",23),
                new preson("neeraja","chava",22),
                new preson("navya","ch",50),
                new preson("manoj","tumati",24),
                new preson("sasank","tumati",26)
        );
        Collections.sort(presonlist, new Comparator<preson>() {
            @Override
            public int compare(preson o1, preson o2) {
                return o1.getLastname().compareTo(o2.getLastname());
            }
        });
        printall(presonlist);
        printcondition(presonlist,new Condition(){
                    @Override
                    public boolean test(preson p) {
                        return p.getLastname().startsWith("t");
                    }
                }

        );
    }
    public static void printall(List<preson> presonList){
        for (preson p:presonList)
              {
                  System.out.println(p);
        }
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