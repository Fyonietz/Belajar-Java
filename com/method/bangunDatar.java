package com.method;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class bangunDatar {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    public static class BangunDatar {
        float luas() {
            System.out.println("Menghitung luas bangun datar");
            return 0;
        }

        float keliling() {
            System.out.println("Menghitung keliling bangun datar");
            return 0;
        }
    }

    public static class Persegi extends BangunDatar {
        int sisi;

        public Persegi(int sisi) {
            this.sisi = sisi;
        }

        @Override
        public float luas() {
            return this.sisi * this.sisi;
        }

        @Override
        public float keliling() {
            return 4 * this.sisi;
        }
    }

    public static class Segitiga extends BangunDatar {
        int alas;
        int tinggi;

        public Segitiga(int alas, int tinggi) {
            this.alas = alas;
            this.tinggi = tinggi;
        }

        @Override
        public float luas() {
            return this.alas * this.tinggi / 2;
        }
    }

    public static class Lingkaran extends BangunDatar {
        int r;

        public Lingkaran(int r) {
            this.r = r;
        }

        @Override
        public float luas() {
            return (float) (Math.PI * this.r * this.r);
        }

        @Override
        public float keliling() {
            return (float) (2 * Math.PI * this.r);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Masukkan sisi persegi: ");
        int sisi = Integer.parseInt(br.readLine());
        Persegi persegi = new Persegi(sisi);

        System.out.print("Masukkan alas segitiga: ");
        int alas = Integer.parseInt(br.readLine());
        System.out.print("Masukkan tinggi segitiga: ");
        int tinggi = Integer.parseInt(br.readLine());
        Segitiga segitiga = new Segitiga(alas, tinggi);

        System.out.print("Masukkan jari-jari lingkaran: ");
        int r = Integer.parseInt(br.readLine());
        Lingkaran lingkaran = new Lingkaran(r);

        System.out.println("Luas persegi: " + persegi.luas());
        System.out.println("Keliling persegi: " + persegi.keliling());
        System.out.println("Luas segitiga: " + segitiga.luas());
        System.out.println("Luas lingkaran: " + lingkaran.luas());
        System.out.println("Keliling lingkaran: " + lingkaran.keliling());
    }
}