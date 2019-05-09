package edu.eci.arsw.webSockets;

import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.Ofertas;
import edu.eci.arsw.persistences.AuctionPostgresRepository;
import edu.eci.arsw.persistences.repositories.IAuctionRepository;

@Controller
public class StompBidHandler {
	
	@Autowired
	SimpMessagingTemplate msgt;
	
	@Autowired
	@Qualifier("AuctionPostgresRepository")
	private IAuctionRepository apr;
	
	ConcurrentHashMap<String,Ofertas> bids=new ConcurrentHashMap<String,Ofertas>();
	
	@MessageMapping("/{idsubasta}")
	public void handlePointEvent(Ofertas newB,@DestinationVariable String idsubasta) throws Exception {
		//ConcurrentMap guarantees memory consistency on key/value operations in a multi-threading environment.
		if(!bids.containsKey(idsubasta)) {
			System.out.println("subasta creada con id:"+idsubasta+" y valor incial"+newB.getPrecio());
			Ofertas ofertaActual= new Ofertas(1,newB.getPrecio(),idsubasta,newB.getUser());
			bids.put(idsubasta,ofertaActual);
		}
		synchronized(bids.get(idsubasta)) {
			Auction a = apr.find(idsubasta);
			if (a.check()) {
				apr.Bid(idsubasta,newB.getPrecio(),newB.getUser() );
				bids.get(idsubasta).setUser(newB.getUser());
				bids.get(idsubasta).setPrecio(newB.getPrecio());
				msgt.convertAndSend("/topic/"+idsubasta, newB);
				
			}
			
		}
		
	}
	
	

}
