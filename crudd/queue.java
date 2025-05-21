package com.crudd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class queue{
    String str;
    int num;

    public static void main(String[] args) {
        new queue(); // This instantiation is necessary to run the constructor logic
    }

    public queue(){
        try {
            LinkedList<Integer> list = new LinkedList<>();
            BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Jumlah Data: ");
            str = bf.readLine();
            if((num=Integer.parseInt(str))==1){
                System.err.println("Anda menekan angka satu");
                System.exit(0);
            }else{
                    for(int i =1;i<=num;i++){
                        System.out.print("masukkan elemen "+i+" : ");
                        str = bf.readLine();
                        list.add(Integer.valueOf(str)); // Avoid unnecessary temporary variable
                    }
            }
            System.out.println("Isi queue: "+list);
            System.out.println("Elemen pertama: "+list.removeFirst());
            System.out.println("Elemen terakhir: "+list.removeLast());
            System.out.print("Elemen tengah: ");
            while(!list.isEmpty()){
                System.err.println(list.remove()+" ");
            }
            System.out.println(" ");
        } catch (NumberFormatException | IOException e) {
            System.err.println(e.getMessage()); // Print specific error message
        }
    }
}