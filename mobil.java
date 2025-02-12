package com.belajar;

public class mobil {
            String warna;
            int tahun_roduksi;
            int nomor_mesin;
            int nomor_angka;

            public static void main(String[] args) {
                mobil mobil_niaga = new mobil();
                //Pemanggilan Method Void
                mobil_niaga.isi();
                mobil_niaga.tampil();
            }
            //Mengisi variable instance
            void isi(){
                   warna = "Merah";
                   tahun_roduksi = 1998;
                   nomor_mesin = 1376;
                   nomor_angka = 2667;         
            }
            //Menampilkan variable instance
            void tampil(){
                System.out.println("Warna Mobil : "+warna);
                System.out.println("Tahun Produksi : "+tahun_roduksi);
                System.out.println("Nomor Mesin : "+nomor_mesin);
                System.out.println("Nomor Angka : "+nomor_angka);
            }
}
