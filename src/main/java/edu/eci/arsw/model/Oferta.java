package edu.eci.arsw.model;


public class Oferta {;

	long ofertaID;
	TipoDePago  tipoDePago;
	Auction auction;
	User user;
	
	public Oferta() {
	}

	public Oferta(long ofertaID, TipoDePago tipoDePago, Auction auction, User user) {
		super();
		this.ofertaID = ofertaID;
		this.tipoDePago = tipoDePago;
		this.auction = auction;
		this.user = user;
	}

	public long getOfertaID() {
		return ofertaID;
	}

	public void setOfertaID(long ofertaID) {
		this.ofertaID = ofertaID;
	}

	public TipoDePago getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(TipoDePago tipoDePago) {
		this.tipoDePago = tipoDePago;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
