package ru.shonin.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shonin.consoleapp.ConsoleApp;
import ru.shonin.database.DataBaseHandler;
import ru.shonin.database.EmployeeConfig;
import ru.shonin.database.EmployeeRepository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

public class StartApp {
    public static void main(String[] args) throws Exception {
//        Connection connection = DataBaseHandler.getDataBaseHandler().getDbConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
//
//        while(resultSet.next()){
//            System.out.println( resultSet.getInt(1) +" " + resultSet.getString(2)+" " + resultSet.getString(3) );
//        }

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.shonin");
        //System.out.println(context.getBean(EmployeeConfig.class));
        //EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
       //employeeRepository.findAll().forEach(System.out::println);


        context.getBean(ConsoleApp.class).run();
       //Сделать малое консольное приложение позволяющее добавлять сотрудников
    }
}
