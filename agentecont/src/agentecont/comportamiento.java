/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentecont;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
/**
 *
 * @author Danny Tapia
 */
public class comportamiento extends Behaviour {
    
    int x=0;
    public void action() {
        System.out.println(x);
    }

    public boolean done() {
        if(x==100)
            return true;
        x++;
        return false;
}
    
}
