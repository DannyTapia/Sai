/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author Danny Tapia
 */
public class comportamiento extends Behaviour{
      public void action() {
        System.out.println("Hello world");
    }

    public boolean done() {
       return true; 
    }
}
