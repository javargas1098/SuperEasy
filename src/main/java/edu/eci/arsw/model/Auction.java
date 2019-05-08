package edu.eci.arsw.model;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Auction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String idSubasta;
	List<User> bidders;
	String seller;
	int precioSugerido, precioActual;
	int estado;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp horaIni;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp horaFinal;
	Item item;

	@Override
	public String toString() {
		String respuesta = "ID: " + idSubasta + "\n" +
				"Bidders: " + bidders + "\n" +
				"Seller: " + seller + "\n" +
				"PrecioSugerido: " + precioSugerido + "\n" +
				"PrecioActual: " + precioActual + "\n" +
				"EstadoSubasta: " + estado + "\n" +
				"HoraInicio: " + horaIni + "\n" +
				"HoraFin: " + horaFinal + "\n" +
				"MarcaItem: " + item.getMarca() + "\n" +
				"DescripcionItem: " + item.getDescripcion() + "\n" +
				"ModeloItem: " + item.getModelo() + "\n";
				
		return respuesta;
	}

	public Auction() {
	}

	public Auction(String idSubasta, int estado, Timestamp horaIni, Timestamp horaFinal, String seller,
			int precioSugerido, Item item, int precioActual) {

		this.estado = estado;
		this.horaFinal = horaFinal;
		this.horaIni = horaIni;
		this.idSubasta = idSubasta;
		this.precioSugerido = precioSugerido;
		this.bidders = new LinkedList<User>();
		this.seller = seller;
		this.item = item;
		this.precioActual = precioActual;
		check();

	}

	public int getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(int precioActual) {
		check();
		if (estado == 1) {
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

	public String getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(String idSubasta) {
		this.idSubasta = idSubasta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
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

	public Timestamp getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Timestamp horaIni) {
		this.horaIni = horaIni;
	}

	public Timestamp getHoraFin() {
		return horaFinal;
	}

	public void setHoraFin(Timestamp horaFinal) {
		this.horaFinal = horaFinal;
	}

	public boolean check() {
		if (horaIni.getTime() < System.currentTimeMillis() && horaFinal.getTime() > System.currentTimeMillis()) {
			return true;
		}
		return false;
		
	}

}
