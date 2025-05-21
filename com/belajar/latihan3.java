package com.belajar;

public class latihan3 {
    //Operator Logika
    public static void main(String[] args) {
        
    
    int A = 70;
    int B = 80;
    int C = 92;
    boolean a_b= A > B && B< C || C < B;
    boolean b_a= A<B || B < C && C > B;
    System.out.println(a_b);
    System.out.println(b_a);
}

}
