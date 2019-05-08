package edu.eci.arsw.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.Item;
import edu.eci.arsw.persistences.repositories.IAuctionRepository;
import edu.eci.arsw.services.contracts.IAuctionServices;

@Component
public class AuctionServices implements IAuctionServices{
	
	@Autowired
	@Qualifier("AuctionPostgresRepository")
	private IAuctionRepository auctionRepository;
	
	@Override
	public List<Auction> list() throws SQLException, ParseException {
		return auctionRepository.findAll();
	}

	@Override
	public void create(Auction auction) throws SQLException {
		System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
		auctionRepository.save(auction);
	}
	
	@Override
	public String createItem(Item item) {
		return auctionRepository.saveItem(item);
	}

	@Override
	public Auction get(long id) {
		//auctionRepository.find(id);
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
