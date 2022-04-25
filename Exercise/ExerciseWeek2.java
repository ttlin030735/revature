import java.io.*;
import java.util.*;

public class ExerciseWeek2
{
    public static void main(String[] args) throws Throwable {
        ExerciseList ex = new ExerciseList();

        ex.QuestionNumber(1);
        ex.ex1();

        ex.QuestionNumber(2);
        ex.ex2();

        ex.QuestionNumber(3);
        try
        {
            ex.ex3();
        }
        catch (NullPointerException e)
        {
            System.out.println("Caught in main");
        }

        ex.QuestionNumber(4);
        ex.ex4();

        ex.QuestionNumber(5);
        ex.ex5();

        ex.QuestionNumber(6);
        ex.ex6();

        ex.QuestionNumber(7);
        ex.ex7();
    }
}

class ExerciseList extends Exception
{
    public void ex1() {
        boolean run = true;
        try
        {
            System.out.print("Input 1 number: ");
            int a = intScanner();
            System.out.print("Input a second number: ");
            int b = intScanner();
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Cannot divided by zero");
            run = false;
        }
        finally
        {
            System.out.println("Did the program run? " + run);
        }
    }

    public void ex2() {
        try
        {
            System.out.print("Input 1 number: ");
            int a = intScanner();
            System.out.print("Input a second number: ");
            int b = intScanner();
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Cannot divided by zero!");
        }
        catch(InputMismatchException e)
        {
            System.out.println("Input is not a number!");
        }
        catch (Exception e)
        {
            System.out.println("Error have occur!");
        }
    }

    public void ex3() {
        try
        {
            throw new NullPointerException("exercise");
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught in exception");
            throw e;
        }
    }

    public void ex4() {
        try
        {
            InputMismatchException ex = new InputMismatchException("Exception E4");
            ex.initCause(new RuntimeException("True Exception E4"));
            throw ex;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(ex);
            System.out.println(ex.getCause());
        }
    }

    public void ex5() {
        try
        {
            throw new ExerciseException("Custom Exception ex5");
        }
        catch(ExerciseException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void ex6() throws IOException {
        Login log = new Login();

        boolean end = false;
        String next;
        while(!end)
        {
            log.login();
            System.out.print("Input 'no' to end, else continue: ");
            next = stringScanner();
            if(next.equals("no"))
                end = true;
        }
    }

    public void ex7()
    {
        SingleObject newObj = SingleObject.createObject();
        SingleObject newObj1 = SingleObject.createObject();
    }

    public int intScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String stringScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public void QuestionNumber(int num) { System.out.println("\nExercise #: " + num);}
}

class ExerciseException extends Exception {
    public ExerciseException(String exception)
    {
        super(exception);
    }
}

class Login {
    private boolean isLoggedOn = false;
    Scanner scanner = new Scanner(System.in);
    public void login() {
        System.out.print("Input student name: ");
        String name = scanner.next();
        System.out.print("Input student password: ");
        String password = scanner.next();

        if(!isLoggedOn)
        {
            if(name.equals("Thomas") && password.equals("578"))
            {
                System.out.println("Logging on");
                isLoggedOn = true;
            }
            else System.out.println("incorrect information");
        }
        else
        {
            try
            {
                throw new ExerciseException("Already logged on");
            }
            catch (ExerciseException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

class SingleObject {
    private static int created = 0;

    private SingleObject()
    {
        created++;
    }

    public static SingleObject createObject()
    {
        if(created != 1)
        {
            System.out.println("Object created");
            return new SingleObject();
        }
        else
        {
            try
            {
                throw new ExerciseException("Object Already Made!!!");
            }
            catch (ExerciseException e)
            {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    public int getCreated()
    {
        return created;
    }
}
