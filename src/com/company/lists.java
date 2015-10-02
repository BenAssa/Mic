package com.company;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class lists {

    static void  printList(List<String> lst) {
        for (Object o : lst)
            System.out.print(" " + o);
    }
public static class Word_list{

    private Set<String> word_list;

    public Integer size() {
        return word_list.size();

    }
    public void add(String item) {
         word_list.add(item);

    }
    public Word_list(){
         word_list= new HashSet<String>();
    }
    public Word_list(File file) throws IOException {
        word_list= new HashSet<String>();
        Scanner sc = new Scanner(file);

        while (sc.hasNext())
        {

            word_list.add(sc.nextLine());
        }
    }

    public void remove_word(String word){
        word_list.remove(word);



    }
    public boolean has(String word){
        return word_list.contains(word);
    }

    public void addWordList(Word_list words){
        for (String word : words.word_list)
        {

            word_list.add(word);
        }

    }



    public void print_list(){
        for (String word : word_list)
            System.out.print(" " + word);
    }


   public void subtract(Word_list list){



                word_list.removeAll(list.word_list);


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
            Word_list points= new  Word_list();
            points.add("aa");
            points.add("aa");
            System.out.println(points.size());
            Word_list points2= new Word_list();
            points2.add("bb");
            points2.add("bb");
            System.out.println(points2.size());
            System.out.println("   ");

            points2.print_list();
            System.out.println("   ");

            points2.addWordList(points);
            points2.print_list();

        }
}

