package edu.eci.arsw.model;

public  class TipoDePago {
	
	long id;
	int jairitos;
	boolean truequeFlag;
	Trueque trueque;
	
	public TipoDePago() {
	}

	public TipoDePago(long id, int jairitos, boolean truequeFlag, Trueque trueque) {
		super();
		this.id = id;
		this.jairitos = jairitos;
		this.truequeFlag = truequeFlag;
		this.trueque = trueque;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getJairitos() {
		return jairitos;
	}

	public void setJairitos(int jairitos) {
		this.jairitos = jairitos;
	}

	public boolean isTruequeFlag() {
		return truequeFlag;
	}

	public void setTruequeFlag(boolean truequeFlag) {
		this.truequeFlag = truequeFlag;
	}

	public Trueque getTrueque() {
		return trueque;
	}

	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}
	
	
	
}
