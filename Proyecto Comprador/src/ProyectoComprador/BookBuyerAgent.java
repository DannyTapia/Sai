package ProyectoComprador;

import jade.core.Agent;
import Agentes1.RequestPerformer;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BookBuyerAgent extends Agent {
  private String bookTitle;
  private AID[] sellerAgents;
  private final int ticker_timer = 10000;
  private final BookBuyerAgent this_agent = this;
  
    /**
     *
     */
    @Override
  protected void setup() {
    System.out.println("Buyer agent " + getAID().getName() + " is ready");
    
    Object[] args = getArguments();
    if(args != null && args.length > 0) {
      bookTitle = (String)args[0];
      System.out.println("Libro : " + bookTitle);
      
      addBehaviour(new TickerBehaviour(this, ticker_timer) {
        @Override
        protected void onTick() {
          System.out.println("Comprando " + bookTitle);
          
          DFAgentDescription template = new DFAgentDescription();
          ServiceDescription sd = new ServiceDescription();
          sd.setType("Libros en venta");
          template.addServices(sd);
          
          try {
            DFAgentDescription[] result = DFService.search(myAgent, template);
            System.out.println("Se encontraron los siguientes vendedores:");
            sellerAgents = new AID[result.length];
            for(int i = 0; i < result.length; i++) {
              sellerAgents[i] = result[i].getName();
              System.out.println(sellerAgents[i].getName());
            }
            
          }catch(FIPAException fe) {
          }
          
          myAgent.addBehaviour(new RequestPerformer(this_agent));
        }
      });
    } else {
      System.out.println("No se ha especificado ningun libro");
      doDelete();
    }
  }
}
       
  
 