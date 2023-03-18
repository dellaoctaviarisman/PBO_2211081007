/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della160323;
import java.util.Scanner;
/**
 *
 * @author Windows 10 Pro
 */
public class Latihan643 {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Masukkan angka yang akan dipangkatkan: ");
       int angka = input.nextInt();
       System.out.print("Masukkan nilai pangkat: ");
       int pangkat = input.nextInt();

       int hasil = 1;

       for (int i = 0; i < pangkat; i++) {
           hasil = hasil * angka;
       }

       System.out.println(angka + " pangkat " + pangkat + " adalah " + hasil);
   }
}
  

