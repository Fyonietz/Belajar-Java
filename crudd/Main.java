package com.crudd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void connect() {
        // MySQL connection URL
        var url = "jdbc:mysql://localhost:3306/book"; // Replace 'your_database_name' with your DB name
        var user = "root"; // Replace with your MySQL username
        var password = "ggmu"; 
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("\nDatabase Connected Successfully");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}