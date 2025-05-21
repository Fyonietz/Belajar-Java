package com.crudd;

public class contohKasusArray2D {
    public static void main(String[] args) {
        // Nama hari dan sesi (baris: hari, kolom: sesi)
        String[][] jadwal = {
            {"Matematika", "Fisika", "Kosong", "Kosong", "Kimia"},      // Senin
            {"Biologi", "Kosong", "Sejarah", "Bahasa Inggris", "Kosong"}, // Selasa
            {"Fisika", "Matematika", "Kosong", "Kimia", "Kosong"},      // Rabu
            {"Kosong", "Kosong", "Pemrograman", "Matematika", "Bahasa Inggris"}, // Kamis
            {"Sejarah", "Biologi", "Kosong", "Kosong", "Kosong"}        // Jumat
        };

        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        // Tampilkan jadwal
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println(hari[i] + ":");
            for (int j = 0; j < jadwal[i].length; j++) {
                System.out.println("  Sesi " + (j+1) + ": " + jadwal[i][j]);
            }
            System.out.println();
        }
    }
}
