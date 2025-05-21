package com.belajar2;

public class kuda extends binatang{
    public void suara(){
        System.out.println("");
        System.out.println("Palembang Ni Bos");
    }
    
     public static void main(String[] args){
        binatang poni = new kuda();
        poni.suara();
     }
}