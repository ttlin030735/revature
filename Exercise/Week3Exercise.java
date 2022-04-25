package com.revature.Week3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//ArrayList
public class Week3Exercise {
    public static void main(String[] args) {
        Exercise exercise = new Exercise();

        exercise.print();

        exercise.printExample(1);
        exercise.ex1(4);
        exercise.print();

        exercise.printExample(2);
        exercise.ex2();

        exercise.printExample(3);
        exercise.ex3(4);

        exercise.printExample(4);
        exercise.ex4();

        exercise.printExample(5);
        exercise.ex5(5, 25);
        exercise.print();
    }
}

class Exercise {
    ArrayList<Integer> exerciseList;
    Random random = new Random();

    Exercise(){
        exerciseList = new ArrayList<>();
        for(int i = 0; i < 8; i++)
            exerciseList.add(random.nextInt(100));
    }

    public void ex1(int index){
        Integer temp = exerciseList.remove(index);
        exerciseList.add(temp);
    }

    public void ex2(){
        printIterator(exerciseList.iterator());

    }

    public void ex3(int number){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int index = number; index < exerciseList.size(); index++)
            temp.add(exerciseList.get(index));

        printIterator(temp.iterator());
    }

    public void ex4(){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int index = exerciseList.size() -1; index >= 0; index--)
            temp.add(exerciseList.get(index));

        printIterator(temp.iterator());
    }

    public void ex5(int index, int element){
        exerciseList.add(index, element);
    }

    public void print(){
        for (int number : exerciseList)
            System.out.println(number);
    }

    public void printIterator(Iterator<Integer> iterator){
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

    public void printExample(int num){
        System.out.println("\nExample #: " + num);
    }
}