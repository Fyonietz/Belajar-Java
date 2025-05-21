package com.belajar;

import java.util.ArrayList;
import java.util.Scanner;

public class Markets {
    static class Product {
        String name;
        int price;
        int quantity;

        public Product(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize products
        products.add(new Product("Hardisk", 150000, 0));
        products.add(new Product("SSD", 200000, 0));
        products.add(new Product("Mouse", 50000, 0));
        products.add(new Product("Keyboard", 200000, 0));
        products.add(new Product("Pad", 30000, 0));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Lihat Keranjang");
            System.out.println("3. Bayar");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showProducts(scanner);
                    break;
                case 2:
                    showCart();
                    break;
                case 3:
                    checkout(scanner);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 4);
    }

    public static void showProducts(Scanner scanner) {
        System.out.println("List Produk:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).name + ": " + products.get(i).price);
        }

        System.out.print("Masukkan nomor produk untuk ditambahkan ke keranjang (0 untuk kembali): ");
        int productIndex = scanner.nextInt();
        if (productIndex > 0) {
            System.out.print("Masukkan jumlah: ");
            int quantity = scanner.nextInt();
            addToCart(productIndex - 1, quantity);
        }
    }

    public static void addToCart(int productIndex, int quantity) {
        if (productIndex >= 0 && productIndex < products.size()) {
            boolean found = false;
            for (Product item : cart) {
                if (item.name.equals(products.get(productIndex).name)) {
                    item.quantity += quantity;
                    found = true;
                    break;
                }
            }
            if (!found) {
                Product product = products.get(productIndex);
                product.quantity = quantity;
                cart.add(product);
            }
            System.out.println(quantity + " " + products.get(productIndex).name + " telah ditambahkan ke keranjang.");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public static void showCart() {
        System.out.println("Keranjang Belanja:");
        int total = 0;
        for (Product product : cart) {
            System.out.println(product.name + " (x" + product.quantity + "): " + product.price * product.quantity);
            total += product.price * product.quantity;
        }
        System.out.println("Total: " + total);
    }

    public static void checkout(Scanner scanner) {
        showCart();
        int total = 0;
        for (Product product : cart) {
            total += product.price * product.quantity;
        }
        System.out.println("Total belanja: " + total);
        System.out.print("Masukkan jumlah uang: ");
        int payment = scanner.nextInt();
        if (payment >= total) {
            System.out.println("Pembayaran berhasil. Kembalian: " + (payment - total));
            System.out.println("Terima kasih telah berbelanja!");
            cart.clear();
        } else {
            System.out.println("Uang tidak cukup. Pembayaran gagal.");
        }
    }
}
