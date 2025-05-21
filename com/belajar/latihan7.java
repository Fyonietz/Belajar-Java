package com.belajar;
import java.io.BufferedReader;
import java.io.IOException;
import  java.io.InputStreamReader;
public class latihan7 {
    public static void main(String[] args)throws IOException {
        String nama;
        int umur;
        //Stream Reader
        InputStreamReader isr = new InputStreamReader(System.in);
        //Buffered Reader
        BufferedReader br = new BufferedReader(isr);
        System.out.print("\nMasukkan Nama Anda:");
        nama = br.readLine();
        System.out.print("\nMasukkan Umur Anda:");
        umur =Integer.parseInt(br.readLine());
        System.out.println("Nama Anda Adalah "+nama);
        System.out.print("Umur Anda "+umur);
    }
}
