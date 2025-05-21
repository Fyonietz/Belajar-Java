package com.crudd;

public class array2 {
    public static void main(String[] args) {
        String[][] negara = new String[3][2];
        negara[0][0] = "Indonesia";
        negara[0][1] = "Jakarta";
        negara[1][0] = "Malaysia";
        negara[1][1] = "Kuala Lumpur";
        negara[2][0] = "Singapura";
        negara[2][1] = "Singapura";

        // Tampilkan isi array
        System.out.println("Daftar Negara dan Ibukota:");
        for (int i = 0; i < negara.length; i++) {
            System.out.println("Negara: " + negara[i][0] + ", Ibukota: " + negara[i][1]);
        }
    }
}
