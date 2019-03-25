package edu.eci.arsw.model;

public class Trueque extends TipoDePago {
	Item item;
	TipoDePago tipoDePago;

	public Trueque() {
	
	}

	public Trueque(Item item, TipoDePago tipoDePago) {
		super();
		this.item = item;
		this.tipoDePago = tipoDePago;
	}
	
	
}
