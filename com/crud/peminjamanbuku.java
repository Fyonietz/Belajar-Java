package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class peminjamanbuku {
    public static void connect() {
        // Correct JDBC URL for SQLite
        var url = "jdbc:sqlite:book.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Database Connected Successfully");
        } catch (SQLException e) {
            System.out.println("Connection -00ca-4467-9c4e-e9b6629c1a2dConnection failed: No suitable driver found for jdbc:sqlite:\r\n" + //
                                "book.dbfailed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
