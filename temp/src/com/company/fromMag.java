package com.company;


import java.util.HashMap;
import java.util.*;
class serial {

   static ArrayList<Integer> getWordLocations(String[] note, String[] magazine) {

        HashMap<String,Integer> words= new HashMap<String, Integer>();
        Integer temp;

        for (int i=0; i<note.length; i++) {
            temp=words.get(note[i]);

            if (temp !=null) {
                words.put(note[i], temp + 1);
            }
            else {
                words.put(note[i],1);
            }
        }


        int i=0;
        HashMap<String, ArrayList<Integer>> locations= new HashMap<String, ArrayList<Integer>>() ;
        ArrayList<Integer> tempLoc;
        while (i<magazine.length && words.size()>0) {
        temp=words.get(magazine[i]);
        if (temp!=null) {
            tempLoc=locations.get(magazine[i]);
            if (tempLoc==null) {
                tempLoc= new ArrayList<Integer>();;
            }
            tempLoc.add(i);
            locations.put(magazine[i],tempLoc);

        if ( temp==1) {
            words.remove(magazine[i]);
            }
        else {
            words.put(magazine[i],temp -1);
        }
        }
        i++;
        }

        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int j=0;j<note.length;j++) {
        tempLoc= locations.get(note[j]);
        if (tempLoc==null){
        results.add(-1);
        }

        results.add(tempLoc.get(tempLoc.size()-1));
        tempLoc.remove(tempLoc.size()-1);
        locations.put(note[j],tempLoc);
        }
        return results;
}
}
public class fromMag {

    public static void main(String[] args) {
        String[] Mag=new String[]{"a","b","a","a","c"};
        String[] note=new String[]{"c","a","a"};
        ArrayList<Integer> f=serial.getWordLocations(note,Mag);

        for (Integer word : f){
            System.out.print(" " + word);
        }

    }
}
