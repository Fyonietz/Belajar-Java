package com.crudd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BukuForm extends JFrame {
    public BukuForm() {
        setTitle("Pengelolaan Buku");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(); // Tabel untuk menampilkan data buku
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Judul:"));
        JTextField judulField = new JTextField();
        formPanel.add(judulField);

        formPanel.add(new JLabel("Pengarang:"));
        JTextField pengarangField = new JTextField();
        formPanel.add(pengarangField);

        formPanel.add(new JLabel("Tahun Terbit:"));
        JTextField tahunField = new JTextField();
        formPanel.add(tahunField);

        formPanel.add(new JLabel("Kategori:"));
        JTextField kategoriField = new JTextField();
        formPanel.add(kategoriField);

        JButton tambahButton = new JButton("Tambah");
        formPanel.add(tambahButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(formPanel, BorderLayout.SOUTH);

        add(panel);

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tambahkan logika untuk menyimpan data buku ke database
                JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BukuForm().setVisible(true);
        });
    }
}