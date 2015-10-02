package com.statisticallyben;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class tester {

    static void  printList(List<String> lst) {
        for (Object o : lst)
            System.out.print(" " + o);
    }
public static class functions{

    Random rand;


    public static columnPair r1(int size) {
        Random rand= new Random();
        columnPair answer= new columnPair(size,true);
        for (Integer i=0;i<size;i++)
        {
            answer.numbers[i][0]= rand.nextDouble();
            answer.numbers[i][1]=rand.nextDouble();

        }


         return answer;

    }
    public static columnPair r2(int size) {
        Random rand= new Random();
        columnPair answer= new columnPair(size,true);
        for (Integer i=0;i<size;i++)
        {
            answer.numbers[i][0]= rand.nextDouble();
            answer.numbers[i][1]=Math.sin(10*rand.nextDouble());

        }


        return answer;

    }
    public static columnPair nr1(int size) {
        Random rand= new Random();
        columnPair answer= new columnPair(size,true);
        for (Integer i=0;i<size;i++)
        {

        Double val=rand.nextDouble();
            answer.numbers[i][0]=val ;
            answer.numbers[i][1]=val;

        }


        return answer;

    }

    public static columnPair nr2(int size) {
        Random rand= new Random();
        columnPair answer= new columnPair(size,true);
        for (Integer i=0;i<size;i++)
        {
            Double val=rand.nextDouble();

            answer.numbers[i][0]= val;
            answer.numbers[i][1]=Math.sin(15*val);

        }


        return answer;
}
}

        public static void main(String[] args) throws IOException  {
            System.out.println(" dsdasad");

        

            File f = new File("sowpods.txt");
        //    ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

            if (f.list()==null)
                System.out.println(" NULLL");
            System.out.println(f.canRead());
            System.out.println(f.getAbsolutePath());


        }
}

