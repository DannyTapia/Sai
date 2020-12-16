/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentecont;
import jade.core.Agent;

/**
 *
 * @author Danny Tapia
 */
public class Agentecont extends Agent{
  comportamiento compor = new comportamiento();
    public void setup(){
        this.addBehaviour(compor);
    }
    /**
     * @param args the command line arguments
     */
 
    
}
