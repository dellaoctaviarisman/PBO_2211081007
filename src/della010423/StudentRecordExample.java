/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della010423;

/**
 *
 * @author Windows 10 Pro
 */
public class StudentRecordExample {
    
    public static void main(String[] args){
        StudentRecord sasa = new StudentRecord();
        StudentRecord rara = new StudentRecord();
        
        sasa.setName ("Sasa");
        sasa.setAddress("Padang");
        sasa.setAge(18);
        
        rara.setName ("Rara");
        rara.setAddress("Bukittinggi");
        rara.setAge(20);
        
        //menampilkan
        System.out.println("Data Objek sasa");
        System.out.println("Nama        :" + sasa.getName());
        System.out.println("Alamat      :" + sasa.getAddress());
        System.out.println("Umur        :" + sasa.getAge());
        
        //memanggil method print
        System.out.println("\nData Objek Rara");
        rara.print("");
        rara.print(70, 80, 90);
        
        //menampilkan jumlah mahsiswa
        System.out.println("Count="+ StudentRecord.getStudentCount());
        
    }   
}
