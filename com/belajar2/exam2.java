package com.belajar2;
//Overriding
class cobahitung1{
        double p,l;
        double hitung1(double p,double l){
            return (p*l);
        }
}

class cobahitung2{
        double a,t;
        double hitung2(double a,double t){

            return (a*t/2);
        }
}
public class exam2 {
    public static void main(String[] args) {
        cobahitung1 datar = new cobahitung1();
        cobahitung2 dreiecke = new cobahitung2();
        System.out.println("");
        System.out.println("Rechteck : " + datar.hitung1(12, 12));
        System.out.println("Dreiecke : " + dreiecke.hitung2(12, 14));
    }
}
