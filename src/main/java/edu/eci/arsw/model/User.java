package edu.eci.arsw.model;

import java.io.Serializable;
<<<<<<< HEAD

=======
>>>>>>> a

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int jairitos, jairitosCongelados, jairitosBenefit;
	public  String name, number, addres, password,email;

	
	private long id;
	
public User() {
		
	}

	public User(long id, String name, String number, int jairitos, int jairitosCongelados,
			int jairitosBenefit, String password,String email) {

		this.id = id;
		this.name = name;
		this.number = number;
		this.jairitos = jairitos;
		this.jairitosBenefit = jairitosBenefit;
		this.jairitosCongelados = jairitosCongelados;
		this.password = password;
		this.email=email;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		this.id=id;
	}

	
}
