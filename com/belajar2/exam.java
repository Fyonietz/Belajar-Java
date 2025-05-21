package com.belajar2;
//Overloading
class cobahitung{
    int  p,l;
    double r;

    int hitung(int p,int l){
        
        
        return (p*l);
    };
    double hitung(double r){
        return (2*3.14*r);
    }
}


public class exam extends cobahitung{
    public static void main(String[] args) {
        exam datar = new exam();
        System.out.println("\nHitung Luas Persegi Panjang : " + datar.hitung(12, 14));
        System.out.println("\nHitung Keliling Lingkaran : " + datar.hitung(20));
    }

}
