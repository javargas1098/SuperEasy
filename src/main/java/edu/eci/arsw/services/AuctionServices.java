package edu.eci.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.repositories.IAuctionRepository;
import edu.eci.arsw.services.contracts.IAuctionServices;

@Component
public class AuctionServices implements IAuctionServices{
	
	@Autowired
	@Qualifier("AuctionPostgresRepository")
	private IAuctionRepository auctionRepository;
	
	@Override
	public List<Auction> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(Auction auction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuction(Auction auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAuction(Auction auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuction(Auction auction) {
		// TODO Auto-generated method stub
		
	}

}
