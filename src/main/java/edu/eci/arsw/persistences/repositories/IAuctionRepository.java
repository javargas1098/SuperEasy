package edu.eci.arsw.persistences.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.User;
import edu.eci.arsw.model.Item;

@Repository
public interface IAuctionRepository extends DAO<Auction, Long> {
	List<User> getBidders(long idSubasta);
	Item getItem(long idSubasta);
	String saveItem(Item item);
}
