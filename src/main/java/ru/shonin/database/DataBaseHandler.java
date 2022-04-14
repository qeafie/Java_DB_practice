package ru.shonin.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHandler {
    private static DataBaseHandler instance;
    private static Connection dbConnection;

    public static DataBaseHandler getDataBaseHandler(){
        if (instance==null)
            instance = new DataBaseHandler();
        return instance;
    }

    private DataBaseHandler(){
    }

    public static Connection getDbConnection() throws IOException {


        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/main/resources/dbConfig.properties")));

        try{
            Class.forName(properties.getProperty("db_Driver"));
            if (dbConnection == null) {
                dbConnection = DriverManager.getConnection(properties.getProperty("db_URL"), properties.getProperty("username"), properties.getProperty("password"));
            }
            return dbConnection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

}
