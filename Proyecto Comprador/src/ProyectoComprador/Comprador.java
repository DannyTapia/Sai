/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoComprador;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
/**
 *
 * @author Danny Tapia
 */
public class Comprador extends Agent{
    
    private String titulo;
    
    @Override
    protected void setup(){
        System.out.println("\n --> Hola, soy el comprador: "+ getAID().getName());
        
        Object[] args = getArguments();
        
        if(args != null && args.length > 0){
            titulo = (String) args[0];
            System.out.println("Vamos a comprar el libro: " + titulo);
            
            addBehaviour(
                    new TickerBehaviour(this, 10000) {
                        @Override
                        protected void onTick() {
                            System.out.println("Enviando petición a posibles vendedores ...");
                            myAgent.addBehaviour(new RequestPerformer());
                        }
                    }
            );
        }
        else{
            System.out.println("No se ha especificado un titulo que comprar!!!");
            doDelete();
        }
    }
    
    @Override
    protected void takeDown(){
    
        System.out.println("Finalizando el agente comprador: " + getAID().getName());
        
    }
    
    private class RequestPerformer extends Behaviour {

    @Override
    public void action(){
    
    }
    
    @Override
    public boolean done() {
        
        return true;
    }
}
    
}

