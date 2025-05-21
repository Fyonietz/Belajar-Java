package com.belajar;
import java.util.Scanner;

public class Ian {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int id;

        System.out.println("pilih barang: ");
        System.out.println("1.telur ");
        System.out.println("2.sayur ");
        System.out.println("3.gula ");
        System.out.println("4.minyak ");
        System.out.println("5.beras ");
        id = Input.nextInt();

        if(id == 1){
            System.out.println("telur 2k");
        } else if (id == 2){
            System.out.println(".(sayur 3k)");
        }else if (id == 3){
            System.out.println(".(gula 10k)");
        }else if (id == 4){
            System.out.println("minyak 20k");
        }else if (id == 5){
            System.out.println(".(beras 1000k)");
        }
    };
}
