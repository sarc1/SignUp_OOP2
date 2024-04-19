package com.example.signup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection c = SQLConnection.getConnection();
             Statement statement = c.createStatement()){
            String query = "CREATE TABLE IF NOT EXISTS users(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(100) NOT NULL," +
                    "password VARCHAR(100) NOT NULL)";
            statement.execute(query);
            System.out.println("Table created!");
        }catch(SQLException e){
            e.printStackTrace();
        }

        try(Connection c = SQLConnection.getConnection();
        Statement statement1 = c.createStatement()){
            String query = "CREATE TABLE IF NOT EXISTS playlist(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "songtitle VARCHAR(100) NOT NULL)";
            statement1.execute(query);
            System.out.println("Table created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
