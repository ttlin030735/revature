package com.revature.Week1.Day1;

import java.util.*;

public class Day1Exercise
{
    public static void main(String[] args)
    {
        ExerciseList ex = new ExerciseList();

        //ex 1
        ex.exerciseNum(1);
        ex.exercise1();
        //ex 2
        ex.exerciseNum(2);
        ex.exercise2();
        //ex 3
        ex.exerciseNum(3);
        ex.exercise3();
        //ex 4
        ex.exerciseNum(4);
        ex.exercise4();
        //ex 5
        ex.exerciseNum(5);
        ex.exercise5();
        //ex 6
        ex.exerciseNum(6);
        ex.exercise6();
        //ex 7
        ex.exerciseNum(7);
        ex.exercise7();
        //ex 8
        ex.exerciseNum(8);
        ex.exercise8();
        //ex 9
        ex.exerciseNum(9);
        ex.exercise9();

        //ex 10
        ex.exerciseNum(10);
        ex.exercise10();

        ex.diamond();
    }
}

class ExerciseList
{
    Scanner scanner = new Scanner(System.in);

    public void exercise1()
    {
        System.out.print("Number of column: ");
        int number = scanner();
        for(int x = 0; x < number; x++)
        {
            for(int y = 0; y <= x; y++)
                System.out.print("*");

            System.out.println();
        }
    }

    public void exercise2()
    {
        System.out.print("Number of column: ");
        int number = scanner();
        for(int a = number; a > 0; a--)
        {
            for(int b = number; b > 0;b--)
                if(b <= a){ System.out.print("*");}

            System.out.println();
        }
    }

    public void exercise3()
    {
        System.out.print("Number of column: ");
        int row = scanner();
        int column = row * 2 - 1;
        int mid = row - 1;
        int max = mid;
        int min = mid;

        for(int i = 0; i < row; i++)
        {
            for(int f = 0; f < column; f++)
            {
                if(f >= min && f <= max)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            min--;
            max++;
            System.out.println();
        }
    }

    public void exercise4()
    {
        System.out.print("Number of column: ");
        int row = scanner();
        int column = 2 * row - 1;
        int max = column - 1;
        for(int i = 0; i < row; i++)
        {
            for(int f = 0; f < column; f++)
            {
                if(f >= i && f <= max)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            max--;
            System.out.println();
        }
    }

    public void exercise5()
    {
        System.out.print("Number of column: ");
        int row = scanner();
        int max = row + 1;
        for(int i = row; i > 0;i--)
        {
            for(int j = 1; j < max; j++)
            {
                if(j >= i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

    public void exercise6()
    {
        int highest;
        System.out.print("Input the 1st number: ");
        int a = scanner();
        System.out.print("Input the 2nd number: ");
        int b = scanner();
        System.out.print("Input the 3rd number: ");
        int c = scanner();

        System.out.println("The greatest: " + Math.max(Math.max(a,b),c));
    }

    public void exercise7()
    {
        System.out.print("Input the number (Table to be Calculated) : Input number of terms: ");
        int x = scanner();

        for(int i = 0; i <= x; i++)
            System.out.println(x + " X " + i + " = " + (x * i));

    }

    public void exercise8()
    {
        System.out.print("Input number of rows: ");
        int x = scanner();
        for(int i = 1; i <= x; i++)
        {
            for (int j = 1; j <= i; j++)
                System.out.print("" + j);

            System.out.println();
        }
    }

    // works input 9 or less
    public void exercise9() {
        System.out.print("Number of Rows: ");
        int x = scanner();
        int y = 2 * x - 1;
        int mid = x - 1;
        int min = mid;
        int max = mid;
        for (int column = 1; column <= x; column++) {
            for (int row = 0; row < y; row++)
            {
                if (row >= min && row <= max)
                {
                    if(x % 2 == 0)
                    {
                        if (row % 2 == column % 2)
                            System.out.print(column);
                        else
                            System.out.print(" ");
                    }
                    else
                    {
                        if (row % 2 != column % 2)
                            System.out.print(column);
                        else
                            System.out.print(" ");
                    }
                }
                else
                    System.out.print(" ");
            }
            min--;
            max++;
            System.out.println();
        }
    }

    public void exercise10()
    {
        System.out.println("Max length of the diamond: ");
        int length = scanner();
        int mid = length - 1;
        int lowerBound = mid;
        int upperBound = mid;
        int max2 = 2 * mid ;
        for(int i = 0; i < mid; i++)
        {
            for(int f = 0; f < max2 +1; f++)
            {
                if(f >= lowerBound && f <= upperBound) System.out.print("*");
                else System.out.print(" ");
            }
            lowerBound--;
            upperBound++;
            System.out.println();
        }
        for(int i = 0; i < mid + 1; i++)
        {
            for(int f = 0; f < length * 2; f++)
            {
                if(f >= i && f <= max2) System.out.print("*");
                else System.out.print(" ");
            }
            max2--;
            System.out.println();
        }
    }

    public void diamond()
    {
        System.out.print("Enter the length of the diamond: ");
        int length = scanner();
        top(length, length);
        bot(length, length - 1);
    }

    public void top(int row, int column)
    {
        if (row == 0) return;

        space(row);
        star(2 * (column - row) + 1);
        System.out.println();
        top(row - 1, column);
    }

    public void bot(int row, int column)
    {
        if (column == 0) return;

        space(row - column + 1);
        star(2 * column - 1);
        System.out.println();
        bot(row, column - 1);
    }

    public void space(int space)
    {
        if(space == 0) return;
        System.out.print(" ");
        space(space - 1);
    }

    public void star(int star)
    {
        if(star == 0) return;
        System.out.print("*");
        star(star - 1);
    }

    public int scanner() { return scanner.nextInt();}

    public void exerciseNum(int a) { System.out.println("\nExercise " + a);}
}


