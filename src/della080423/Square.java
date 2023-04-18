/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della080423;

/**
 *
 * @author Windows 10 Pro
 */
public class Square extends Shape {
    
    private int sisi;
    public Square(int sisi){
        this.sisi=sisi;
    }
    
    @Override
    public double getArea(){
        return sisi*sisi;
    }
    
    @Override
    public String getName(){
        return "Square";
    }
    
    public static void main(String[] args){
        Square s = new Square(10);
        System.out.println("Nama Bentuk : "+s.getName());
        System.out.println("Luas    : "+s.getArea());
    }
    
}
