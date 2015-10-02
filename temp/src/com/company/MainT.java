package com.company;

import java.util.*;

 class fun {

     ArrayList<ArrayList<String>> possibleParsings = new  ArrayList<ArrayList<String>>() ;

    static HashSet<String> DefaultDictionary=new HashSet<String>();
    HashSet<String> Dictionary;

     ArrayList<ArrayList<String>>  getAllParses(String sentence,HashSet<String> dictionary ) {
        if (dictionary==null)
        {
            Dictionary=DefaultDictionary;
        }
        else{

            Dictionary=dictionary;
        }
        sentence.replaceAll("[0-9]", "");
        addParseToList(sentence, new ArrayList<String>());
        return possibleParsings;
    }


    void addParseToList(String sentencePart,ArrayList<String> currentSentence) {
        if (sentencePart.length()==0) {
            possibleParsings.add(currentSentence);
        }
        String currentWord="";
        for (int i=0;i<sentencePart.length();i++) {
            currentWord=currentWord+ (sentencePart.charAt(i));
            if (Dictionary.contains(currentWord)) {
                ArrayList<String> tempsentence =(ArrayList<String>) currentSentence.clone();
                tempsentence.add(currentWord);
                System.out.print(i);
                System.out.println(currentWord);


                addParseToList(sentencePart.substring(i+1),tempsentence);
            }
        }
    }




}



public class MainT {


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
