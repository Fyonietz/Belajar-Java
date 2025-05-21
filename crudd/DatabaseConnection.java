package com.crudd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book"; // Ganti dengan nama database Anda
    private static final String DB_USER = "root"; // Ganti dengan username MySQL Anda
    private static final String DB_PASSWORD = "ggmu"; // Ganti dengan password MySQL Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}