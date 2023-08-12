package com.example.javaeeproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserConnection {
    private static final Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/db_mvc_cat","root","");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }



}