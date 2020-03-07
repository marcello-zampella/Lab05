package it.polito.tdp.amagramma.model;

public class Parola {
	
	
	String parola;
	boolean esiste;
	
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isEsiste() {
		return esiste;
	}
	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	}
	@Override
	public String toString() {
		return "" + parola;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
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
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
	
	
	
	
	

}
