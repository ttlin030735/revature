package com.revature.Exercise;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Week3Exercise4 {
    public static void main(String[] args) throws IOException {
        Exercise4 exercise4 = new Exercise4();

        exercise4.printExercise(1);
        exercise4.ex1();

        exercise4.printExercise(2);
        exercise4.ex2();

        exercise4.printExercise(3);
        exercise4.ex3("Exercise 4", "third.txt");
        exercise4.ex3("Exercise 4", "fourth.txt");

        exercise4.printExercise(4);
        exercise4.ex4("Exercise 4", "third.txt");
        exercise4.ex4("Exercise 4", "new folder");

        exercise4.printExercise(5);
        exercise4.ex5();

        exercise4.printExercise(6);
        exercise4.ex6("Exercise 4", "Problem.txt");

        exercise4.printExercise(7);
        exercise4.ex7("Exercise 4", "Problem.txt");

        exercise4.printExercise(8);
        exercise4.ex8("Exercise 4", "Problem.txt");

    }
}

class Exercise4{

    File directory;
    File first;
    File second;
    File third;
    File folder;

    public Exercise4() {
        this.directory = new File("Exercise 4");
        this.first = new File("Exercise 4","first.txt");
        this.second = new File("Exercise 4","second.txt");
        this.third = new File("Exercise 4","third.txt");
        this.folder = new File("Exercise 4", "new folder");

        makeDirectory(directory);
        makeFile(first);
        makeFile(second);
        makeFile(third);
        makeDirectory(folder);

    }

    // list all file/directory name
    public void ex1(){
        String[] list = directory.list();

        for(String path: list)
            System.out.println(path);
    }
    // get files by extension
    public void ex2(){
        String[] list = directory.list();
        int periodIndex = 0;

        for(String path: list){
            if(path.toLowerCase().endsWith(".txt"))
                System.out.println(path);
        }

    }
    public void ex3(String folder, String file){
        System.out.println((new File(folder, file)).exists());
    }

    public void ex4(String folder, String fileName){
        File file = new File(folder , fileName);
        if(file.exists()){
            if((file).isDirectory())
                System.out.println("This is a directory.");
            else System.out.println("Not a directory!");
        } else
            System.out.println("File doesn't exist!");
    }
    public void ex5() throws IOException {
        File file = new File("Exercise 4", "Problem.txt");
        makeFile(file);
        try{
            FileWriter writer = new FileWriter(file, true);
            writer.write("\n" + stringInput());
            writer.close();
            System.out.println("finish writing");
        } catch(IOException e){
            System.out.println("Did not write");
            e.printStackTrace();
        }
//        FileWriter fileWriter = new FileWriter("Problem 5-6.txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        System.out.println("What do you want to write: ");
//
//        bufferedWriter.close();
//        fileWriter.close();
    }
    public void ex6(String folder, String fileName) {
        File file = new File(folder, fileName);
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    public void ex7(String folder, String fileName) {
        File file = new File(folder, fileName);
        int line = 0;
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine() && line < 3){
                System.out.println(reader.nextLine());
                line++;
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    public void ex8(String folder, String fileName){
        File file = new File(folder, fileName);
        String longest = "";
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String temp = reader.nextLine();
                if(temp.length() > longest.length())
                    longest = temp;
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
        System.out.println(longest);
    }

    public void printExercise(int number){
        System.out.println("\nProblem #: " + number);
    }

    public void makeDirectory(File file){
        if(!file.exists())
            file.mkdir();
    }
    public void makeFile(File file){
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String stringInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        return scanner.nextLine();
    }
}
