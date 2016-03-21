package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class quicksort {

    private static int  partition(int[] ar ,int low,int high){





return 5;


    }

    public static  int[] sort(int[] ar ,int low,int high){

        return ar;

    }

    public static void main(String[] args) {
        System.out.print(" test, sentence= catsdog   dic= cats cat dog sdog catsd" );
        fun.DefaultDictionary.add("cat");
        fun.DefaultDictionary.add("cats");
        fun.DefaultDictionary.add("catsd");
        fun.DefaultDictionary.add("dog");
        fun.DefaultDictionary.add("sdog");

        fun funny=new fun();
        ArrayList<ArrayList<String>> results= funny.getAllParses("catsdog",null);
        System.out.println(results.size());
            for (List<String> line : results){
                System.out.println("|");

                for (String word : line){
                    System.out.print(" " + word);
                }
            }




        HashMap<String,Integer> j=new HashMap<String, Integer>();
        int t=j.get("fiu");
        System.out.println(t);

    }
}
