
import java.sql.SQLOutput;
import java.util.*;

public class Day2Exercise
{
    public static void main(String[] args)
    {
        Question newQ = new Question();
        newQ.QuestionNumber(2);
        newQ.q2();

        newQ.QuestionNumber(3);
        newQ.q3();

        newQ.QuestionNumber(4);
        newQ.q4();

        newQ.QuestionNumber(5);
        newQ.q5(5);

        newQ.QuestionNumber(6);
        newQ.q6();

        newQ.QuestionNumber(7);
        newQ.q7();

        newQ.QuestionNumber(8);
        newQ.q8();

        newQ.QuestionNumber(9);
        newQ.q9(10);
    }
}

class Question
{
    public void q2()
    {
        System.out.println("The sum of the first X even number where X is: ");
        int number = intScanner();
        int sum = 0;
        for(int i = 1; i <= number; i++)
        {
            sum += i * 2;
        }
        System.out.println(sum);
    }

    public void q3()
    {
        System.out.print("Multiplication table for: ");
        int number = intScanner();
        int count = 0;
        while(count <= number)
        {
            System.out.println(number + " X " + count + " = " + (count * number));
            count++;
        }
    }

    public void q4()
    {
        int number = 10;
        int count = 10;
        while(count >= 0)
        {
            System.out.println(number + " X " + count + " = " + (count * number));
            count--;
        }
    }

    public void q5(int number)
    {
        int total = 1;
        for(int i = 1; i <= number; i++)
            total *= i;

        System.out.println("Factorial of " + number + " is: " + total);
    }

    public void q6()
    {
        int number = intScanner();
        int total = 1, count = 1;
        while(count <= number)
        {
            total *= count;
            count++;
        }
        System.out.println("Factorial of " + number + " is: " + total);
    }

    public void q7()
    {
        System.out.println("The sum of the first X even number where X is: ");
        int number = intScanner();
        int sum = 0;
        int i = 1;
        while(i <= number)
        {
            sum += 2 * i++;
        }
        System.out.println(sum);
    }

    public void q8() {System.out.println("true");}

    public void q9(int number)
    {
        int total = 0;
        for(int i = 0; i <= number; i++)
        {
            System.out.println("8 X " + i + " = " + (8 * i));
            total += (8 * i);
        }

        System.out.println("The total sum is: " + total);
    }

    public int intScanner()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void QuestionNumber(int number) {System.out.println("\nQuestion " + number);}
}
