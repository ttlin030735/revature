package com.revature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    Connection connection;

    public EmployeeDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (name, email) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if(count > 0) System.out.println("Employee saved");
        else System.out.println("Oops! Something went wrong!");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET name = ?, email = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        if (preparedStatement.executeUpdate() > 0) System.out.println("Employee updated");
        else System.out.println("Error have occurred please try again!");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0) System.out.println("Employee deleted");
        else System.out.println("Oops! Something went wrong!");
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            employees.add(new Employee(id, name, email));
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        Employee employee = new Employee();
        employee.setId(id);
        String sql = "SELECT * FROM employee WHERE ID = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()) return(new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3)));
        return employee;
    }

}
