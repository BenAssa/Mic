package com.statisticallyben;

import com.statisticallyben.columnPair;
import com.statisticallyben.tester;

/* ApproxOptimizeXAxis
        * Returns the map P: D -> {0, ...,k-1}. See Algorithm 2 in SOM.
        *
        * Parameters
        *   Dx (IN) : x-data sorted in increasing order by Dx-values
        *   Dy (IN) : y-data sorted in increasing order by Dx-values
        *   n (IN) : length of Dx and Dy
        *   Qm (IN) : the map Q computed by EquipartitionYAxis sorted
        *   in increasing order by Dx-values.
        *   q (IN) : number of clumps in Qm
        *   Pm (IN) : the map P computed by GetSuperclumpsPartition
        *   sorted in increasing order by Dx-values.
        *   p (IN) : number of clumps in Pm
        *   x (IN) : grid size on x-values
        *   I (OUT) : the normalized mutual information vector. It
        *   will contain I_{k,2}, ..., I_{k, x}. I must be a
        *   preallocated array of dimension x-1.
        */
        public class jMic{

    double HPQ2(int **N, int *np, int q, int p, int s, int t)
    {
        int i, j;
        int sum, tot;
        double prob, H;


        if (s == t)
            return 0.0;

        tot = 0 ;
        for (i=s; i<t; i++)
            tot += np[i];

        H = 0.0;
        for (i=0; i<q; i++)
        {
            sum = 0;
            for (j=s; j<t; j++)
                sum += N[i][j];

            prob = (double) sum / (double) tot;

            if (prob != 0)
                H += prob * log(prob);
        }

        return -H;
    }


    double HP3(columnPair.oneDimensionalPartition partition, int partiotionsize, int num1, int num2)
    {
        int i;
        int sum1, sum2, tot;
        double prob1, prob2, H;


        if (num1 == num2)
            return 0.0;

        sum1 = 0;
        for (i=0; i<num1; i++)
            sum1 += partition.partitions[i];

        sum2 = 0;
        for (i=num1; i<num2; i++)
            sum2 += partition.partitions[i];

        tot = sum1 + sum2;
        prob1 = (double) sum1 / (double) tot;
        prob2 = (double) sum2 / (double) tot;

        H = 0.0;

        if (prob1 != 0)
            H += prob1 * Math.log(prob1);

        if (prob2 != 0)
            H += prob2 * Math.log(prob2);

        return -H;
    }
    double HPQ3( int[][] matrix,columnPair.oneDimensionalPartition partition,  int secondPartitionSize,int partiotionsize, int num1, int num2)
    {
        int i, j;
        int sum1, sum2, tot;
        double prob1, prob2, H;


        tot = 0 ;
        for (i=0; i<num2; i++)
            tot += partition.partitions[i];

        H = 0.0;
        for (i=0; i<secondPartitionSize; i++)
        {
            sum1 = 0;
            for (j=0; j<num1; j++)
                sum1 += matrix[i][j];

            sum2 = 0;
            for (j=num1; j<num2; j++)
                sum2 += matrix[i][j];

            prob1 = (double) sum1 / (double) tot;
            prob2 = (double) sum2 / (double) tot;

            if (prob1 != 0)
                H += prob1 * Math.log(prob1);

            if (prob2 != 0)
                H += prob2 * Math.log(prob2);
        }

        return -H;
    }


    //columnPair N= tester.functions.nr2(100);

    //N.sort();

    //columnPair.oneDimensionalPartition Qm= N.new oneDimensionalPartition(q,0);


        Double[]  ApproxOptimizeXAxis(columnPair.oneDimensionalPartition equiPartition,columnPair.oneDimensionalPartition partition)
        {
            int x=equiPartition.partitions.length;

            int i, j, s, t, L;
        int[][] matrix ; /* contains the number of samples for each cell Q x P*/
        int[] c= new int[partition.partitionSize]; /* contains c_1, ..., c_k */
        double[][] IM= new double[partition.partitionSize+1][x]; /* mutual information matrix, I_t,l */
        double f, fmax, r1, r2;
        double hq;
        double[][] hpq2;
        final Double DBL_MAX=9999499.0;

    
	/* if p==1 return I=0 */

            for (i=0; i<n; i++)
            {
                matrix[Qm[i]][Pm[i]] += 1;
                np[Pm[i]] += 1;
            }

            c[0]=partition.partitions[0];
        for (i=0; i<=partition.partitionSize; i++)
        {
            if (i!=0&&i!=partition.partitionSize)
                c[i] = partition.partitions[i] + c[i-1];//累加序列
        }
        for (j=0; j<=x; j++)
            IM[i][j] = 0.0;
		/*for (j=0; j<=p; j++)
         hpq2[i][j] = 0.0;*/

    
	/* compute H(Q)*/
        hq = partition.shanonEntropy();
    
	/* Find the optimal partitions of size 2 */
	/* Algorithm 2 in SOM, lines 4-8 */
        for (t=2; t<=partition.partitionSize; t++)
        {
            fmax = -DBL_MAX;
            for (s=1; s<=t; s++)
            {
                f = HP3(partition, partition.partitionSize, s, t) - HPQ3(matrix, partition, equiPartition.partitionSize, partition.partitionSize, s, t);
                if (f > fmax)
                {
                    IM[t][2] = hq + f;
                    fmax = f;
                }
            }
        }


        for (t=3; t<=partition.partitionSize; t++)
            for (s=2; s<=t; s++)
                hpq2[s][t] = HPQ2(N, np, q, p, s, t);
    
	/* inductively build the rest of the table of optimal partitions */
	/* Algorithm 2 in SOM, lines 11-17 */
        for (L=3; L<=x; L++)
            for (t=L; t<=partition.partitionSize; t++)
            {
                fmax = -DBL_MAX;
                for (s=L-1; s<=t; s++)
                {
                    r1 = (double) c[s-1] / (double) c[t-1];
                    r2 = (double) (c[t-1] - c[s-1]) / (double) c[t-1];
                    f = (r1 * (IM[s][L-1] - hq)) - (r2 * hpq2[s][t]);

                    if (f > fmax)
                    {
                        IM[t][L] = hq + f;
                        fmax = f;
                    }
                }
            }
    
    /* Algorithm 2 in SOM, line 19 */
        if (x > partition.partitionSize)
        {
        for (i=partition.partitionSize+1; i<=x; i++)
        IM[partition.partitionSize][i] = IM[partition.partitionSize][partition.partitionSize];
        }
    
    /* fill I */
        for (i=2; i<=x; i++)
        I[i-2] = IM[partition.partitionSize][i] / Math.min(Math.log(i), Math.log(equiPartition.partitionSize));
    


        return;
        }}