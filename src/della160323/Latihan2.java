/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della160323;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Windows 10 Pro
 */
public class Latihan2 {
  public static void main(String[] args) {
        BufferedReader dataIn = 
            new BufferedReader(new InputStreamReader(System.in));
        String word1 = "", word2 = "", word3 = "";
        
        System.out.print("Enter word 1: ");
        try {
            word1 = dataIn.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        
        System.out.print("Enter word 2: ");
        try {
            word2 = dataIn.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        
        System.out.print("Enter word 3: ");
        try {
            word3 = dataIn.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        
        System.out.print(word1+" " +word2+ " "+ word3);
  }
}  

