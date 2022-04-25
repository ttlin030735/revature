package com.revature.Exercise;

import java.util.Iterator;
import java.util.TreeSet;

public class Week3Exercise3 {
    public static void main(String[] args) {
        TreeSet<String> testing = new TreeSet<>();
        TreeSet<String> reverse = new TreeSet<>();
        testing.add("testing");

        Exercise3 ex = new Exercise3();

        ex.printQuestion(1);
        ex.ex1();

        ex.printQuestion(2);
        ex.ex2(ex.colors);

        ex.printQuestion(3);
        System.out.println(testing);
        System.out.println("Now adding the colors tree set");
        testing = ex.ex3(ex.colors, testing);
        System.out.println(testing);

        ex.printQuestion(4);
        reverse = ex.ex4(ex.colors);
        System.out.println(reverse);

        ex.printQuestion(5);
        ex.ex5(testing);
    }
}

class Exercise3{
    TreeSet<String> colors;

    public Exercise3(){
        colors = new TreeSet<>();
    }

    public void ex1(){
        System.out.println("8 colors added!");
        colors.add("blue");
        colors.add("grey");
        colors.add("turquoise");
        colors.add("red");
        colors.add("green");
        colors.add("purple");
        colors.add("yellow");
        colors.add("orange");
    }
    public void add(String value){
        colors.add(value);
    }

    public void ex2(TreeSet<String> set){
        printIterator(set.iterator());
    }

    public TreeSet<String> ex3(TreeSet<String> set1, TreeSet<String> set2){
        set2.addAll(set1);

        return set2;
    }

    public TreeSet<String> ex4(TreeSet<String> set){
        return (TreeSet<String>) set.descendingSet();
    }

    public void ex5(TreeSet<String> set){
        System.out.println("First item: " + set.first());
        System.out.println("Last item: " + set.last());
    }

    public void printIterator(Iterator<String> iterator){
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

    public void print(TreeSet set){
        System.out.println(set);
    }

    public void printQuestion(int number){
        System.out.println("\nQuestion #: " + number);
    }
}