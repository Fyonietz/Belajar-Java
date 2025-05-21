package com.belajar;
import java.util.Scanner;

public class market {
    public static void main(String[] args) {
        int Pilihan;
        Scanner input = new Scanner(System.in);
        int Jumlah;
        long hasil;
        String Yakin;
        long uang;
        long total;
        boolean duar = true;
        while (duar) {
            // Show menu
            System.out.println("Masukkan Pilihan Barang");
            System.out.println("1 Untuk Hardisk");
            System.out.println("2 Untuk Ram");
            System.out.println("3 Untuk SSD");
            System.out.println("4 Untuk Keyboard");
            System.out.println("5 Untuk Mouse");
            System.out.println("0 Untuk keluar");

            Pilihan = input.nextInt();
            input.nextLine();

            if (Pilihan == 0) {
                System.out.println("Program selesai.");
                break;
            }
            
            switch (Pilihan) {
                case 1:
                    long Hardisk = 150000L;
                    System.out.println("Harga Hardisk Adalah Rp150.000");
                    System.out.print("Yakin? (y/n): ");
                    Yakin = input.nextLine();

                    if (Yakin.equalsIgnoreCase("y")) {
                        System.out.print("Berapa Jumlahnya: ");
                        Jumlah = input.nextInt();
                        input.nextLine();

                        hasil = Jumlah * Hardisk;
                        System.out.println("Jumlah Yang Akan Anda Bayar: Rp" + hasil);

                        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                        uang = input.nextLong();
                        input.nextLine();

                        if (uang >= hasil) {
                            long kembalian = uang - hasil;
                            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
                            duar = false;
                        } else {
                            System.out.println("Uang tidak cukup. Pembelian dibatalkan.");
                        }
                        break;
                    } else {
                        System.out.println("Pembelian Dibatalkan");
                    }
                    break;
                case 2:
                    long Ram = 250000L;
                    System.out.println("Harga Ram Adalah Rp250.000");
                    System.out.print("Yakin? (y/n): ");
                    Yakin = input.nextLine();

                    if (Yakin.equalsIgnoreCase("y")) {
                        System.out.print("Berapa Jumlahnya: ");
                        Jumlah = input.nextInt();
                        input.nextLine();

                        hasil = Jumlah * Ram;
                        System.out.println("Jumlah Yang Akan Anda Bayar: Rp" + hasil);

                        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                        uang = input.nextLong();
                        input.nextLine();

                        if (uang >= hasil) {
                            long kembalian = uang - hasil;
                            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
                            duar = false;
                        } else {
                            System.out.println("Uang tidak cukup. Pembelian dibatalkan.");
                        }
                        break;
                    } else {
                        System.out.println("Pembelian Dibatalkan");
                    }
                    break;
                case 3:
                    long SSD = 500000L;
                    System.out.println("Harga SSD Adalah Rp500.000");
                    System.out.print("Yakin? (y/n): ");
                    Yakin = input.nextLine();

                    if (Yakin.equalsIgnoreCase("y")) {
                        System.out.print("Berapa Jumlahnya: ");
                        Jumlah = input.nextInt();
                        input.nextLine();

                        hasil = Jumlah * SSD;
                        System.out.println("Jumlah Yang Akan Anda Bayar: Rp" + hasil);

                        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                        uang = input.nextLong();
                        input.nextLine();

                        if (uang >= hasil) {
                            long kembalian = uang - hasil;
                            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
                            duar = false;
                        } else {
                            System.out.println("Uang tidak cukup. Pembelian dibatalkan.");
                        }
                        break;
                    } else {
                        System.out.println("Pembelian Dibatalkan");
                    }
                    break;
                case 4:
                    long Keyboard = 1150000L;
                    System.out.println("Harga Keyboard Adalah Rp1.150.000");
                    System.out.print("Yakin? (y/n): ");
                    Yakin = input.nextLine();

                    if (Yakin.equalsIgnoreCase("y")) {
                        System.out.print("Berapa Jumlahnya: ");
                        Jumlah = input.nextInt();
                        input.nextLine();

                        hasil = Jumlah * Keyboard;
                        System.out.println("Jumlah Yang Akan Anda Bayar: Rp" + hasil);

                        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                        uang = input.nextLong();
                        input.nextLine();

                        if (uang >= hasil) {
                            long kembalian = uang - hasil;
                            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
                            duar = false;
                        } else {
                            System.out.println("Uang tidak cukup. Pembelian dibatalkan.");
                        }
                        break;
                    } else {
                        System.out.println("Pembelian Dibatalkan");
                    }
                    break;
                case 5:
                    long Mouse = 350000L;
                    System.out.println("Harga Mouse Adalah Rp350.000");
                    System.out.print("Yakin? (y/n): ");
                    Yakin = input.nextLine();

                    if (Yakin.equalsIgnoreCase("y")) {
                        System.out.print("Berapa Jumlahnya: ");
                        Jumlah = input.nextInt();
                        input.nextLine();

                        hasil = Jumlah * Mouse;
                        System.out.println("Jumlah Yang Akan Anda Bayar: Rp" + hasil);

                        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                        uang = input.nextLong();
                        input.nextLine();

                        if (uang >= hasil) {
                            long kembalian = uang - hasil;
                            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
                            duar = false;
                        } else {
                            System.out.println("Uang tidak cukup. Pembelian dibatalkan.");
                        }
                        break;
                    } else {
                        System.out.println("Pembelian Dibatalkan");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        input.close();
    }
}
