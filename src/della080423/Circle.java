/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della080423;

/**
 *
 * @author Windows 10 Pro
 */
public class Circle extends Shape {
        private int r;
    public Circle(int r){
        this.r=r;
    }
    
    @Override
    public double getArea(){
        return 3.14*r*r;
    }
    
    @Override
    public String getName(){
        return "Circle";
    }
    
    public static void main(String[] args){
        Circle c = new Circle(10);
        System.out.println("Nama Bentuk : "+c.getName());
        System.out.println("Luas : "+c.getArea());
    }
}
