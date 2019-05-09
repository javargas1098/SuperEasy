package edu.eci.arsw.persistences.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.User;
import edu.eci.arsw.model.Item;

@Repository
public interface IAuctionRepository extends DAO<Auction, String> {
	List<User> getBidders(String idSubasta);
	Item getItem(String idSubasta) throws SQLException;
	String saveItem(Item item);
	void Bid(String idsubasta, int newPrice) throws SQLException;
}
