package ru.shonin.main;

import ru.shonin.database.DataBaseHandler;

import java.io.IOException;
import java.sql.*;

public class StartApp {
    public static void main(String[] args) throws Exception {
        Connection connection = DataBaseHandler.getDataBaseHandler().getDbConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Students\"");

        while(resultSet.next()){
            System.out.println( resultSet.getInt(1) +" " + resultSet.getString(2)+" " + resultSet.getString(3) );
        }
    }
}
