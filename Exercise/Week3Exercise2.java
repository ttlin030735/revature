package com.revature.Exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Week3Exercise2 {
    public static void main(String[] args) {
        Exercise2 ex = new Exercise2();

        ex.printQuestion(1);
        ex.ex1(101);

        ex.printQuestion(2);
        ex.ex2();

        ex.printQuestion(3);
        ex.ex3();

        ex.printQuestion(4);
        ex.ex4();
    }
}

class Exercise2{
    HashSet<Integer> hashSet;
    Random random = new Random();

    public Exercise2() {
        hashSet = new HashSet<>();
        while(hashSet.size() < 8)
            hashSet.add(random.nextInt(100));
        hashSet.add(100);

        printIterator(hashSet.iterator());
    }

    public void ex1(int number){
        if(hashSet.contains(number))
            System.out.println("Number already exist in set");
        else{
            System.out.println("Number added");
            hashSet.add(number);
            print();
        }
    }

    public void ex2(){
        printIterator(hashSet.iterator());
    }

    public void ex3(){
        System.out.println(hashSet.size());
    }

    public void ex4(){
        hashSet.clear();
    }

    public void printQuestion(int number){
        System.out.println("\nQuestion number: " + number);
    }

    public void print(){
        System.out.println(hashSet);
    }

    public void printIterator(Iterator<Integer> iterator){
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}