package it.polito.tdp.amagramma.model;

public class Lettera {
	private char carattere;
	private int ricorrenze;
	public char getCarattere() {
		return carattere;
	}
	public void setCarattere(char carattere) {
		this.carattere = carattere;
		this.ricorrenze=1;
	}
	public int getRicorrenze() {
		return ricorrenze;
	}
	public void aumentaRicorrenze() {
		this.ricorrenze++;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carattere;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (carattere != other.carattere)
			return false;
		return true;
	}
	
	
	

}