package edu.eci.arsw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
	private int jairitos, jairitosCongelados, jairitosBenefit;
	private String name, number, addres, password;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public User() {
		
	}

	public User(long id, String name, String number, String addres, int jairitos, int jairitosCongelados,
			int jairitosBenefit, String password) {

		this.id = id;
		this.name = name;
		this.addres = addres;
		this.number = number;
		this.jairitos = jairitos;
		this.jairitosBenefit = jairitosBenefit;
		this.jairitosCongelados = jairitosCongelados;
		this.password = password;

	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getJairitos() {
		return jairitos;
	}

	public void setJairitos(int jairitos) {
		this.jairitos = jairitos;
	}

	public int getJairitosCongelados() {
		return jairitosCongelados;
	}

	public void setJairitosCongelados(int jairitosCongelados) {
		this.jairitosCongelados = jairitosCongelados;
	}

	public int getJairitosBenefit() {
		return jairitosBenefit;
	}

	public void setJairitosBenefit(int jairitosBenefit) {
		this.jairitosBenefit = jairitosBenefit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
