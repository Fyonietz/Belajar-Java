package com.belajar;
import  java.util.Scanner;
public class latihan5 {
    public static void main(String[] args) {
        int NISN,Usia;
        String Nama,Alamat;
        Scanner input = new Scanner(System.in);
        System.out.println("Data Siswa");
        System.out.print("NISN : ");
        NISN = input.nextInt();
        input.nextLine();
        System.out.print("Nama : ");
        Nama = input.nextLine();
        System.out.print("Alamat : ");
        Alamat = input.nextLine();
        System.out.print("Usia : ");
        Usia = input.nextInt();
        //Menampilkan data siswa
        System.out.println("\nData Siswa");
        System.out.println("NISN : "+NISN);
        System.out.println("Nama : "+Nama);
        System.out.println("Alamat : "+Alamat);
        System.out.println("Usia : "+Usia);
    }

}
