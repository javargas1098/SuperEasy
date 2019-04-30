package edu.eci.arsw.model;

import java.io.Serializable;
import java.util.*;

public class Auction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long idSubasta;
	List<User> bidders;
	String  seller;
	int precioSugerido;
	EstadoSubasta estado;
	Date horaIni, horaFin;
	Item item;
	int precioActual;
	

	public Auction() {
	}

	public Auction(long idSubasta, EstadoSubasta estado, Date horaIni, Date horaFin, String seller, int precioSugerido,
			Item item,int precioActual) {

		this.estado = estado;
		this.horaFin = horaFin;
		this.horaFin = horaFin;
		this.idSubasta = idSubasta;
		this.precioSugerido = precioSugerido;
		this.bidders = new LinkedList<User>();
		this.seller = seller;
		this.item = item;
		this.precioActual=precioActual;
		check(); 
			
			
		
		

	}
	
	public int getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(int precioActual) {
		check();
		if (estado.equals(EstadoSubasta.INICIADO)){
			this.precioActual = precioActual;
		}
		
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<User> getBidders() {
		return bidders;
	}

	public void setBidders(List<User> bidders) {
		this.bidders = bidders;
	}

	public long getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(long idSubasta) {
		this.idSubasta = idSubasta;
	}

	public EstadoSubasta getEstado() {
		return estado;
	}

	public void setEstado(EstadoSubasta estado) {
		this.estado = estado;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getPrecioSugerido() {
		return precioSugerido;
	}

	public void setPrecioSugerido(int precioSugerido) {
		this.precioSugerido = precioSugerido;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	
	public void check() {
		if(horaIni.getTime()<System.currentTimeMillis() && horaFin.getTime()>System.currentTimeMillis()) {
			estado=EstadoSubasta.INICIADO;
		}
		else if(horaFin.getTime()<System.currentTimeMillis()) {
			estado=EstadoSubasta.FINALIZADA;
		}
		else {
			estado=EstadoSubasta.SUSPENDIDO;
		}
	}

}
