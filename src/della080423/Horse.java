/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della080423;

/**
 *
 * @author Windows 10 Pro
 */
public class Horse extends LivingThing {
    
    @Override
    public void walk(){
    System.out.println("Horse walks...");
    
    }
    
     public static void main(String[] args){
        Horse m = new Horse();
        m.breath();
        m.eat();
        m.walk();
    }
}
