package com.belajar;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class latihan10 {
    // Stream Reader
    static InputStreamReader isr = new InputStreamReader(System.in);
    // Buffered Reader
    static BufferedReader br = new BufferedReader(isr);
    static double r;

    static void isi() throws Exception {
        System.out.print("Masukkan Jari-jari : ");
        r = Double.parseDouble(br.readLine());
    }

    static void ambil(double r) {
        latihan10.r = r;
    }

    static void hitung() {
        double luas = Math.PI * r * r;
        double keliling = 2 * Math.PI * r;
        System.out.println("Luas Lingkaran : " + luas);
        System.out.println("Keliling Lingkaran : " + keliling);
    }

    public static void main(String[] args) {
        try {
            latihan10.isi();
            latihan10.ambil(r);
            latihan10.hitung();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
