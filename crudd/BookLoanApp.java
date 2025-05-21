package com.crudd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookLoanApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book"; // Replace 'book' with your database name
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "ggmu"; // Replace with your MySQL password

    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Loan System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel bookLabel = new JLabel("Book Title:");
        JTextField bookField = new JTextField();
        JLabel borrowerLabel = new JLabel("Borrower Name:");
        JTextField borrowerField = new JTextField();
        JButton loanButton = new JButton("Loan Book");
        JTextArea outputArea = new JTextArea(5, 30);

        panel.add(bookLabel);
        panel.add(bookField);
        panel.add(borrowerLabel);
        panel.add(borrowerField);
        panel.add(loanButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        loanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = bookField.getText();
                String borrowerName = borrowerField.getText();

                if (bookTitle.isEmpty() || borrowerName.isEmpty()) {
                    outputArea.setText("Please fill in all fields.");
                    return;
                }

                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String checkBookQuery = "SELECT id, available FROM books WHERE title = ?";
                    PreparedStatement checkBookStmt = conn.prepareStatement(checkBookQuery);
                    checkBookStmt.setString(1, bookTitle);
                    ResultSet bookResult = checkBookStmt.executeQuery();

                    if (bookResult.next()) {
                        int bookId = bookResult.getInt("id");
                        boolean available = bookResult.getBoolean("available");

                        if (!available) {
                            outputArea.setText("Book is not available.");
                            return;
                        }

                        String insertBorrowerQuery = "INSERT INTO borrowers (name) VALUES (?)";
                        PreparedStatement insertBorrowerStmt = conn.prepareStatement(insertBorrowerQuery, Statement.RETURN_GENERATED_KEYS);
                        insertBorrowerStmt.setString(1, borrowerName);
                        insertBorrowerStmt.executeUpdate();

                        ResultSet borrowerResult = insertBorrowerStmt.getGeneratedKeys();
                        if (borrowerResult.next()) {
                            int borrowerId = borrowerResult.getInt(1);

                            String loanBookQuery = "INSERT INTO loans (book_id, borrower_id, loan_date) VALUES (?, ?, NOW())";
                            PreparedStatement loanBookStmt = conn.prepareStatement(loanBookQuery);
                            loanBookStmt.setInt(1, bookId);
                            loanBookStmt.setInt(2, borrowerId);
                            loanBookStmt.executeUpdate();

                            String updateBookQuery = "UPDATE books SET available = 0 WHERE id = ?";
                            PreparedStatement updateBookStmt = conn.prepareStatement(updateBookQuery);
                            updateBookStmt.setInt(1, bookId);
                            updateBookStmt.executeUpdate();

                            outputArea.setText("Book loaned successfully!");
                        }
                    } else {
                        outputArea.setText("Book not found.");
                    }
                } catch (SQLException ex) {
                    outputArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}