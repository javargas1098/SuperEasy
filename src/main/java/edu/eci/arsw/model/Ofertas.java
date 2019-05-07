package edu.eci.arsw.model;


public class Ofertas {

	long ofertaID;
	int  precio;
	String auction;
	String user;
	
	public Ofertas() {
	}

	public Ofertas(long ofertaID, int precio, String auction, String user) {
		super();
		this.ofertaID = ofertaID;
		this.precio = precio;
		this.auction = auction;
		this.user = user;
	}

	public long getOfertaID() {
		return ofertaID;
	}

	public void setOfertaID(long ofertaID) {
		this.ofertaID = ofertaID;
	}

	

	public String getAuction() {
		return auction;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setAuction(String auction) {
		this.auction = auction;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	

}
