package com.statisticallyben;

/**
 * Created by samsung on 4/30/15.
 */
import java.util.Arrays;
import java.util.Comparator;

public class columnPair {
    public Double[][] numbers;
    public Double[][][] SortedNumbers;
    boolean isSorted;
    boolean rand;
    public int size;


    public class twoDimensionalPartition{




        int partitionSizeX;
        int partitionSizeY;

        public Integer[][] existanceMap;


        public   oneDimensionalPartition(int numOfP,Integer axis){
            this.partitionSize=numOfP;
            this.axis=axis;
            int currentP=0;
            Double ratio= (double)size/ (double)numOfP;
            partitions= new Integer[partitionSize];
            for (int i=0;i<size;i++)
            {
                if (SortedNumbers[axis][i][axis]>(ratio*(currentP+1)+0.5))
                    currentP++;
                partitions[currentP]++;
            }

        }


    }

    public class oneDimensionalPartition{

        int partitionSize;
        Integer axis;
        public Integer[] partitions;





        public   oneDimensionalPartition(int numOfP,Integer axis){
            this.partitionSize=numOfP;
            this.axis=axis;
            int currentP=0;
            Double ratio= (double)size/ (double)numOfP;
            partitions= new Integer[partitionSize];
            for (int i=0;i<size;i++)
            {
                if (SortedNumbers[axis][i][axis]>(ratio*(currentP+1)+0.5))
                    currentP++;
                partitions[currentP]++;
            }

        }

            public   oneDimensionalPartition(int numOfP, Double[] seperators,Integer axis){
            this.partitionSize=numOfP;
            this.axis=axis;
            int currentP=0;
            partitions= new Integer[partitionSize];
            for (int i=0;i<size;i++)
            {
                if (SortedNumbers[axis][i][axis]>seperators[currentP])
                    currentP++;
                partitions[currentP]++;
            }
        }

        public Double shanonEntropy()
        {
            int i;
            double prob, logprob, entropy;


            entropy=0.0;
            for (i=0; i<partitionSize; i++)
            {



                prob = (double) partitions[i] / (double) size;
                if (prob != 0)
                {
                    logprob = Math.log(prob);
                    entropy+= entropy * logprob;
                }
            }
            return - entropy;
        }




    }

    public void sort(){

        SortedNumbers=new Double[2][][];
        SortedNumbers[0]=      numbers.clone();
        SortedNumbers[1]=      numbers.clone();

        Arrays.sort(SortedNumbers[0], new Comparator<Double[]>() {
            @Override
            public int compare(final Double[] entry1, final Double[] entry2) {
                final Double time1 = entry1[0];
                final Double time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        Arrays.sort(SortedNumbers[1], new Comparator<Double[]>() {
            @Override
            public int compare(final Double[] entry1, final Double[] entry2) {
                final Double time1 = entry1[1];
                final Double time2 = entry2[1];
                return time1.compareTo(time2);
            }
        });
        isSorted=true;
    }



    public columnPair(Integer size,boolean isRandom)
    {
        numbers= new Double[size][2];
        rand=isRandom;
        isSorted=false;
        this.size=size;
    }
    public void printList(){



    }


    }


