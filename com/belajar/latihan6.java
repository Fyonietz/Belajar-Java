package com.belajar;
import javax.swing.JOptionPane;
public class latihan6 {
    public static void main(String[] args) {
        String nama = "";
        nama = JOptionPane.showInputDialog("Masukkan Nama Anda : ");
        String msg="Hai "+nama;
      
        JOptionPane.showMessageDialog(null, msg);
     }  
}
