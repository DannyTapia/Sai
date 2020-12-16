/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author Danny Tapia
 */
public class Helloworld extends Agent{
comportamiento compor = new comportamiento();
    public void setup(){
        this.addBehaviour(compor);
    /**
     * @param args the command line arguments
     */
    }
    
}
