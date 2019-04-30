package edu.eci.arsw.webSockets;

import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.model.Auction;
@Controller
public class StompBidHandler {
	
	@Autowired
	SimpMessagingTemplate msgt;
	
	ConcurrentHashMap<String,Auction> bids=new ConcurrentHashMap<String,Auction>();
	//@MessageMapping("/{producto}")
	// cuando subasta este completada crear el topico (llave emailsub-producto) y al ofertar se suscribirá

}
