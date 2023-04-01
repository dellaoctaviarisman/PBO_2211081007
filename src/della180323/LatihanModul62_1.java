/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della180323;
import java.util.Scanner;
/**
 *
 * @author Windows 10 Pro
 */
public class LatihanModul62_1 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan sebuah angka antara 1-10: ");
        int num = input.nextInt();

        if (num == 1) {
            System.out.println("Satu");
        } else if (num == 2) {
            System.out.println("Dua");
        } else if (num == 3) {
            System.out.println("Tiga");
        } else if (num == 4) {
            System.out.println("Empat");
        } else if (num == 5) {
            System.out.println("Lima");
        } else if (num == 6) {
            System.out.println("Enam");
        } else if (num == 7) {
            System.out.println("Tujuh");
        } else if (num == 8) {
            System.out.println("Delapan");
        } else if (num == 9) {
            System.out.println("Sembilan");
        } else if (num == 10) {
            System.out.println("Sepuluh");
        } else {
            System.out.println("Invalid number");
        }
    }
    
}
