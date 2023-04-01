/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della180323;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author Windows 10 Pro
 */
public class LatihanModul61_2 {
        public static void main(final String[] args){
      String input1, input2, input3;
      
      input1 = JOptionPane.showInputDialog("Entri nilai A : ");
      double nilai1 = Double.parseDouble(input1);
              
      input2 = JOptionPane.showInputDialog("Entri nilai B : ");
      double nilai2 = Double.parseDouble(input2);
      
      input3 = JOptionPane.showInputDialog("Entri nilai C : ");
      double nilai3 = Double.parseDouble(input3); 
      
      double ratarata = (nilai1 + nilai2 + nilai3)/3;
      
      String smiley = ":-)";
      
      if (ratarata <60){
          smiley = ":-( " ;
      }
      

      String output = "Nilai rata-rata ujian adalah" + ratarata + " " + smiley;
      JOptionPane.showMessageDialog(null, output);
  
    }
}
