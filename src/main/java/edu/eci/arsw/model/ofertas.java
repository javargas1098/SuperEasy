package edu.eci.arsw.model;


public class ofertas {
	int oferta,tipopago,subasta,usuariosid;
	
	
	public int getOferta() {
		return oferta;
	}
	public void setOferta(int oferta) {
		this.oferta = oferta;
	}
	public int getTipopago() {
		return tipopago;
	}
	public void setTipopago(int tipopago) {
		this.tipopago = tipopago;
	}
	public int getSubasta() {
		return subasta;
	}
	public void setSubasta(int subasta) {
		this.subasta = subasta;
	}
	public int getUsuariosid() {
		return usuariosid;
	}
	public void setUsuariosid(int usuariosid) {
		this.usuariosid = usuariosid;
	}
	public ofertas() {
		// TODO Auto-generated constructor stub
	}
	public ofertas(int oferta,int tipoPago,int subasta,int usuariosid) {
		this.oferta=oferta;
		this.usuariosid=usuariosid;
		this.tipopago=tipoPago;
		this.subasta=subasta;
		
	}

}
