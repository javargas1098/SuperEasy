package edu.eci.arsw.webSockets;

import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.Ofertas;
import edu.eci.arsw.persistences.AuctionPostgresRepository;
@Controller
public class StompBidHandler {
	
	@Autowired
	SimpMessagingTemplate msgt;
	
	ConcurrentHashMap<String,Ofertas> bids=new ConcurrentHashMap<String,Ofertas>();
	AuctionPostgresRepository apr= new AuctionPostgresRepository();
	@MessageMapping("/{idsubasta}/{idUser}")
	public void handlePointEvent(int newValue,@DestinationVariable String idsubasta,@DestinationVariable String idUser) throws Exception {
		//ConcurrentMap guarantees memory consistency on key/value operations in a multi-threading environment.
		if(!bids.containsKey(idsubasta)) {
			Ofertas ofertaActual= new Ofertas(1,newValue,idsubasta,idUser);
			bids.put(idsubasta,ofertaActual);
		}
		synchronized(bids.get(idsubasta)) {
//			Auction a = apr.find(idsubasta);
//			if (a.check()) {
//				apr.Bid(idsubasta, newValue);
//				bids.get(idsubasta).setUser(idUser);
//				bids.get(idsubasta).setPrecio(newValue);
//				
//			}
			msgt.convertAndSend("/topic/"+idsubasta+"/"+idUser, newValue);
		}
		
	}
	
	

}
