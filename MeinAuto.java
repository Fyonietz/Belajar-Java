package com.belajar;
//Latihan Method non Void 
public class MeinAuto {
        String warna1;
        int tahun1;
        int nomor_mesin1;
        int nomor_angka1;
    
    //Method Filling Instance Variable
    void isi(String warna1, int tahun1, int nomor_mesin1, int nomor_angka1){
        this.warna1 = warna1;
        this.tahun1 = tahun1;
        this.nomor_mesin1 = nomor_mesin1;
        this.nomor_angka1 = nomor_angka1;

    }
    //Method Showing Variable Instance
    String ambil_warna(){
        return warna1;
    };

    int ambil_tahun(){
        return tahun1;
    };

    int ambil_nomor_mesin(){
        return nomor_mesin1;
    };

    int ambil_nomor_angka (){
        return nomor_angka1;
    };

    public static void main(String[] args) {
        MeinAuto mazda = new MeinAuto();
        mazda.isi("Merah", 1980, 7862, 5678);
        System.out.println("Warna Mobil : "+mazda.ambil_warna());
        System.out.println("Tahun Produksi : "+mazda.ambil_tahun());
        System.out.println("Nomor Mesin : "+mazda.ambil_nomor_mesin());
        System.out.println("Nomor Angka : "+mazda.ambil_nomor_angka());
    }
}