package com.example.testpage.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {
    private static Connection connection;
    public static String value = "error";
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        try {
            //--------------------------------------------
            Properties properties = new Properties();
            InputStream inputStream = ConnectionDB.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            String password = properties.getProperty("db.password");
            String url = properties.getProperty("db.url");
            String userName = properties.getProperty("db.username");
            String driverPath = properties.getProperty("db.driver");
            //------------------------------------------------
            Class.forName(driverPath).getDeclaredConstructor().newInstance();
            connection = DriverManager
                    .getConnection(url,userName,password);
        }catch(Exception ex){

        }
        return connection;
    }
}
