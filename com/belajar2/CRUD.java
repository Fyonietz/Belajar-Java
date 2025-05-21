package com.belajar2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CRUD {
    public static void main(String[] args) {
        Frame window = new Frame("CRUD AWT + MySQL");

        // Components
        Label label = new Label("Masukan Nama:");
        TextField input = new TextField();
        TextField newName = new TextField("New Name (for Edit)");
        Button btnSave = new Button("Simpan");
        Button btnRead = new Button("Tampilkan");
        Button btnEdit = new Button("Edit");
        Button btnDelete = new Button("Hapus");
        TextArea output = new TextArea();

        // Bounds
        label.setBounds(10, 50, 200, 30);
        input.setBounds(10, 80, 300, 40);
        newName.setBounds(10, 130, 300, 40);
        btnSave.setBounds(320, 80, 100, 40);
        btnRead.setBounds(430, 80, 100, 40);
        btnEdit.setBounds(320, 130, 100, 40);
        btnDelete.setBounds(430, 130, 100, 40);
        output.setBounds(10, 200, 520, 300);

        // Add
        window.add(label);
        window.add(input);
        window.add(newName);
        window.add(btnSave);
        window.add(btnRead);
        window.add(btnEdit);
        window.add(btnDelete);
        window.add(output);

        // Window Settings
        window.setSize(600, 550);
        window.setLayout(null);
        window.setVisible(true);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                window.dispose();
            }
        });

        // Save Button
        btnSave.addActionListener(e -> {
            String name = input.getText().trim();
            if (!name.isEmpty()) {
                if (insertUser(name)) {
                    label.setText("Berhasil disimpan: " + name);
                } else {
                    label.setText("Gagal menyimpan.");
                }
            } else {
                label.setText("Nama tidak boleh kosong.");
            }
        });

        // Read Button
        btnRead.addActionListener(e -> {
            String data = readUsers();
            output.setText(data);
        });

        // Edit Button
        btnEdit.addActionListener(e -> {
            String oldName = input.getText().trim();
            String newN = newName.getText().trim();
            if (!oldName.isEmpty() && !newN.isEmpty()) {
                if (updateUser(oldName, newN)) {
                    label.setText("Berhasil diupdate.");
                } else {
                    label.setText("Update gagal.");
                }
            } else {
                label.setText("Masukkan nama lama dan baru.");
            }
        });

        // Delete Button
        btnDelete.addActionListener(e -> {
            String name = input.getText().trim();
            if (!name.isEmpty()) {
                if (deleteUser(name)) {
                    label.setText("Berhasil dihapus: " + name);
                } else {
                    label.setText("Gagal menghapus.");
                }
            } else {
                label.setText("Nama tidak boleh kosong.");
            }
        });
    }

    // Database credentials
    static final String URL = "jdbc:mysql://127.0.0.1:3306/testdb";
    static final String USER = "root";
    static final String PASS = "ggmu";

    public static boolean insertUser(String name) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO users (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readUsers() {
        StringBuilder result = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result.append(rs.getInt("id")).append(". ").append(rs.getString("name")).append("\n");
            }
        } catch (SQLException e) {
            result.append("Error reading users.\n");
            e.printStackTrace();
        }
        return result.toString();
    }

    public static boolean updateUser(String oldName, String newName) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "UPDATE users SET name = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setString(2, oldName);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String name) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "DELETE FROM users WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
