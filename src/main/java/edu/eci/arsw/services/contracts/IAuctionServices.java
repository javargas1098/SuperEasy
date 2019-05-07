package edu.eci.arsw.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.Item;
import edu.eci.arsw.model.User;

@Service
public interface IAuctionServices {
	List<Auction> list();
    void create(Auction auction);
    String createItem(Item item);
    Auction get(long id);
    void deleteAuction(Auction auction);
    void removeAuction(Auction auction);
	void updateAuction(Auction auction);
}
