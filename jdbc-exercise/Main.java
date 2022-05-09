package com.revature;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag){
            Employee employee = new Employee();
            System.out.println("**************************************");
            System.out.println("Select from the options below");
            System.out.println("**************************************");
            System.out.println("Press 1: Add Employee");
            System.out.println("Press 2: Update Employee");
            System.out.println("Press 3: Delete Employee");
            System.out.println("Press 4: Get All Employee");
            System.out.println("Press 5: Get Employee By ID");
            System.out.println("Press 6: Exit");
            System.out.println("**************************************");

            int input = getNumber();
            switch(input){
                case 1:
                    System.out.print("Enter first name: ");
                    employee.setName(scanner.next());
                    System.out.print("Enter email: ");
                    employee.setEmail(scanner.next());
                    dao.addEmployee(employee);
                    break;
                case 2: //update
                    System.out.print("Enter ID: ");
                    employee.setId(getNumber());
                    System.out.print("Enter first name: ");
                    employee.setName(scanner.next());
                    System.out.print("Enter email: ");
                    employee.setEmail(scanner.next());
                    dao.updateEmployee(employee);
                    break;
                case 3: //delete
                    System.out.print("Enter the employee's ID to delete: ");
                    int id = getNumber();
                    dao.deleteEmployee(id);System.out.println("Please enter a valid ID!");
                    break;
                case 4:
                    List<Employee> employees = dao.getEmployees();
                    employees.forEach(System.out::println);
                    break;
                case 5: // get employee by id
                    System.out.print("Enter ID: ");
                    employee = dao.getEmployeeById(getNumber());
                    if(employee.getName() == null) System.out.println("ID not found");
                    else System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Email: " + employee.getEmail());
                    break;
                case 6:
                    System.out.println("Thank you! Now exiting...");
                    ConnectionFactory.getConnection().close();
                    flag = false;
                    break;
                default:
                    System.out.println("Choose number between 1-6!!!");
            }
        }
    }

    public static int getNumber(){
        int num;
        Scanner scanner = new Scanner(System.in);
        try{
            num = scanner.nextInt();
        } catch(InputMismatchException e){
            num = 0;
        }
        return num;
    }
}
