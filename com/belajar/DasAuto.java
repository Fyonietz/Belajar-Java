package com.belajar;
//Latihan Method Static
public class DasAuto {
    static String farbe = "Schwarz";
    static int baujahr = 2020;
    //Method Static
    static void aendern(){
        farbe = "Rot";
        baujahr = 2021;
    }
    static void anzeigen(){
        System.out.println("Farbe : "+farbe);
        System.out.println("Baujahr : "+baujahr);
    }
    public static void main(String[] args) {
        DasAuto.aendern();
        DasAuto.anzeigen();
    }
}
