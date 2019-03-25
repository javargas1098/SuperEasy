package edu.eci.arsw.model;

import java.util.*;

public class Auction {

	List<User> bidders;
	int idSubasta, id_Seller, precioSugerido;
	EstadoSubasta estado;
	Date horaIni, horaFin;

	public Auction() {
		// TODO Auto-generated constructor stub
	}

	public Auction(int idSubasta, EstadoSubasta estado, Date horaIni, Date horaFin, int id_seller, int precioSugerido) {

		this.estado = estado;
		this.horaFin = horaFin;
		this.horaFin = horaFin;
		this.idSubasta = idSubasta;
		this.precioSugerido = precioSugerido;
		bidders = new LinkedList<User>();

	}

	public List<User> getBidders() {
		return bidders;
	}

	public void setBidders(List<User> bidders) {
		this.bidders = bidders;
	}

	public int getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public EstadoSubasta getEstado() {
		return estado;
	}

	public void setEstado(EstadoSubasta estado) {
		this.estado = estado;
	}

	public int getId_Seller() {
		return id_Seller;
	}

	public void setId_Seller(int id_Seller) {
		this.id_Seller = id_Seller;
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

}
