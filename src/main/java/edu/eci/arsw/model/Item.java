package edu.eci.arsw.model;

public class Item {
	int id;
	String descripcion, marca, modelo;

	public Item(int id, String descripcion, String marca, String modelo) {
		this.descripcion = descripcion;
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;

	}
	
	public Item() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	

}
