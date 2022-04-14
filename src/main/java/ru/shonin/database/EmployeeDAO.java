package ru.shonin.database;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    Connection connection = DataBaseHandler.getDbConnection();
    Statement statement = connection.createStatement();
    PreparedStatement preparedStatement;

    public EmployeeDAO() throws IOException, SQLException {
    }

    public Employee createEmployee (ResultSet resultSet) throws SQLException {
        Employee employee = new Employee(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3));
        return employee;
    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"employee\"");

        while (resultSet.next()){
            list.add(createEmployee(resultSet));
        }
        return list;
    }

    public List<Employee> getAllByName(String name) throws SQLException {
        List<Employee> list = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM \"employee\" where name like ?");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"employee\" WHERE name = " + name +" ");

      while (resultSet.next()){
           list.add(createEmployee(resultSet));
      }
       return  list;
    }

    public void save (Employee employee) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"employee\" WHERE id = " + employee.getId());


        if (!resultSet.next()){
            preparedStatement = connection.prepareStatement("INSERT INTO \"employee\" (name,department) VALUES ( ?, ?)");
        }
        else{
            preparedStatement = connection.prepareStatement("UPDATE \"employee\" SET name = ?, department = ?");
        }
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2, Integer.toString(employee.getDepartment()));
    }
}
