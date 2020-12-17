package ProyectoComprador;
import Agentes1.BookSellerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class OfferRequestServer extends CyclicBehaviour{
  
  BookSellerAgent bsAgent;
  
  public OfferRequestServer(BookSellerAgent a) {
    bsAgent = a;
  }
  
    /**
     *
     */
    @Override
  public void action() {
    MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
    ACLMessage msg = bsAgent.receive(mt);
    
    if(msg != null) {
      String title = msg.getContent();
      ACLMessage reply = msg.createReply();
      
      Integer price = (Integer) bsAgent.getCatalogue();
      
      if(price != null) {
        reply.setPerformative(ACLMessage.PROPOSE);
        reply.setContent(String.valueOf(price.intValue()));
      } else {
        reply.setPerformative(ACLMessage.REFUSE);
        reply.setContent("libro no disponible");
      }
      
      bsAgent.send(reply);
    } else {
      block();
    }
  }
}
