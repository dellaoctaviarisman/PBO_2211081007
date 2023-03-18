/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della160323;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author Windows 10 Pro
 */
public class Latihan61 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader( System.in) );
        
        System.out.print("Masukkan nilai 1 : ");
        double nilai1 = Double.parseDouble(br.readLine());
        System.out.print("Masukkan nilai 2 : ");
        double nilai2 = Double.parseDouble(br.readLine());
        System.out.print("Masukkan nilai 3 : ");
        double nilai3 = Double.parseDouble(br.readLine());
        
        double rata = (nilai1 + nilai2 + nilai3) / 3;
        
        System.out.println("Rata-rata nilai adalah : " + rata);
        
        if (rata >= 60){
           System.out.println(":)");
        } else{
             System.out.println(":(");
                     
        }
    }   
}
