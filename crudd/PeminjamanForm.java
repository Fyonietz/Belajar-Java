package com.crudd;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeminjamanForm extends JFrame {
    public PeminjamanForm() {
        setTitle("Form Peminjaman");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Tabel untuk menampilkan buku yang tersedia
        String[] bookColumnNames = {"ID Buku", "Judul", "Pengarang", "Tahun Terbit", "Kategori"};
        DefaultTableModel bookTableModel = new DefaultTableModel(bookColumnNames, 0);
        JTable bookTable = new JTable(bookTableModel);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);

        // Panel untuk form peminjaman
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Nama Peminjam:"));
        JTextField namaField = new JTextField();
        formPanel.add(namaField);

        formPanel.add(new JLabel("Tanggal Pinjam (yyyy-MM-dd):"));
        JTextField pinjamField = new JTextField();
        formPanel.add(pinjamField);

        formPanel.add(new JLabel("Tanggal Kembali (yyyy-MM-dd):"));
        JTextField kembaliField = new JTextField();
        formPanel.add(kembaliField);

        formPanel.add(new JLabel("ID Buku:"));
        JTextField idBukuField = new JTextField();
        formPanel.add(idBukuField);

        JButton pinjamButton = new JButton("Pinjam");
        formPanel.add(pinjamButton);

        // Tabel untuk menampilkan daftar peminjam
        String[] borrowerColumnNames = {"Nama Peminjam", "Judul Buku", "Tanggal Pinjam", "Tanggal Kembali"};
        DefaultTableModel borrowerTableModel = new DefaultTableModel(borrowerColumnNames, 0);
        JTable borrowerTable = new JTable(borrowerTableModel);
        JScrollPane borrowerTableScrollPane = new JScrollPane(borrowerTable);

        // Gunakan JSplitPane untuk membagi ruang antara tabel dan form
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookTableScrollPane, formPanel);
        splitPane.setResizeWeight(0.5); // Atur proporsi ruang
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(borrowerTableScrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        // Load data buku dan peminjam dari database
        loadBookData(bookTableModel);
        loadBorrowerData(borrowerTableModel);

        // Event tombol "Pinjam"
        pinjamButton.addActionListener(e -> {
            String namaPeminjam = namaField.getText();
            String tanggalPinjam = pinjamField.getText();
            String tanggalKembali = kembaliField.getText();
            String idBuku = idBukuField.getText();

            // Validasi input
            if (namaPeminjam.isEmpty() || tanggalPinjam.isEmpty() || tanggalKembali.isEmpty() || idBuku.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Validasi format tanggal
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date pinjamDate = sdf.parse(tanggalPinjam);
                Date kembaliDate = sdf.parse(tanggalKembali);

                if (kembaliDate.before(pinjamDate)) {
                    JOptionPane.showMessageDialog(null, "Tanggal kembali tidak boleh sebelum tanggal pinjam!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Simpan data ke database
                try (Connection conn = DatabaseConnection.getConnection()) {
                    // Simpan data peminjam ke tabel borrowers
                    String insertBorrowerQuery = "INSERT INTO borrowers (name) VALUES (?)";
                    PreparedStatement borrowerStmt = conn.prepareStatement(insertBorrowerQuery, Statement.RETURN_GENERATED_KEYS);
                    borrowerStmt.setString(1, namaPeminjam);
                    borrowerStmt.executeUpdate();

                    // Ambil ID peminjam yang baru saja dimasukkan
                    ResultSet borrowerResult = borrowerStmt.getGeneratedKeys();
                    if (borrowerResult.next()) {
                        int borrowerId = borrowerResult.getInt(1);

                        // Simpan data peminjaman ke tabel loans
                        String insertLoanQuery = "INSERT INTO loans (borrower_id, loan_date, return_date, book_id) VALUES (?, ?, ?, ?)";
                        PreparedStatement loanStmt = conn.prepareStatement(insertLoanQuery);
                        loanStmt.setInt(1, borrowerId);
                        loanStmt.setString(2, tanggalPinjam);
                        loanStmt.setString(3, tanggalKembali);
                        loanStmt.setInt(4, Integer.parseInt(idBuku));
                        loanStmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Peminjaman berhasil disimpan!");
                        loadBookData(bookTableModel); // Refresh tabel buku
                        loadBorrowerData(borrowerTableModel); // Refresh tabel peminjam
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Format tanggal salah! Gunakan format yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID Buku harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void loadBookData(DefaultTableModel tableModel) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id, title, author, year, category FROM books WHERE available = 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Hapus data lama di tabel
            tableModel.setRowCount(0);

            // Tambahkan data baru ke tabel
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                String category = rs.getString("category");
                tableModel.addRow(new Object[]{id, title, author, year, category});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadBorrowerData(DefaultTableModel tableModel) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT b.name AS borrower_name, bk.title AS book_title, l.loan_date, l.return_date " +
                           "FROM loans l " +
                           "JOIN borrowers b ON l.borrower_id = b.id " +
                           "JOIN books bk ON l.book_id = bk.id";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Hapus data lama di tabel
            tableModel.setRowCount(0);

            // Tambahkan data baru ke tabel
            while (rs.next()) {
                String borrowerName = rs.getString("borrower_name");
                String bookTitle = rs.getString("book_title");
                String loanDate = rs.getString("loan_date");
                String returnDate = rs.getString("return_date");
                tableModel.addRow(new Object[]{borrowerName, bookTitle, loanDate, returnDate});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PeminjamanForm().setVisible(true);
        });
    }
}