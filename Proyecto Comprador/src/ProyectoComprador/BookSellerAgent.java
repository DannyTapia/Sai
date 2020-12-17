package ProyectoComprador;
import java.util.Hashtable;

//import behaviours.OfferRequestServer;
//import behaviours.PurchaseOrderServer;
//import Agentes1.BookSellerGui;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BookSellerAgent extends Agent{

	private Hashtable catalogue;

	
    /**
     *
     */
    @Override
	protected void setup() {
	  catalogue = new Hashtable();

	  
	  DFAgentDescription dfd = new DFAgentDescription();
	  dfd.setName(getAID());
	  
	  ServiceDescription sd = new ServiceDescription();
	  sd.setType("book-selling");
	  sd.setName("book-trading");
	  dfd.addServices(sd);
	  
	  try {
	    DFService.register(this, dfd);
	  }catch(FIPAException fe) {
	  }
	  
	  addBehaviour(new OfferRequestServer(this));
	  
	  addBehaviour(new PurchaseOrderServer(this));
	}
	
    /**
     *
     */
    @Override
	protected void takeDown() {
	  try {
	    DFService.deregister(this);
	  }catch(FIPAException fe) {
	  }
	  
	  System.out.println("Seller agent " + getAID().getName() + "terminating");
	}
	
	public void updateCatalogue(final String title, final int price) {
	  addBehaviour(new OneShotBehaviour() {
            @Override
	    public void action() {
	      catalogue.put(title, price);
	      System.out.println(title + " inserted with a price of " + price);
	    }
	  });
	}
	
	public Hashtable getCatalogue() {
	  return catalogue;
	}
}
