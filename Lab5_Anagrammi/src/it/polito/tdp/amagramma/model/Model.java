package it.polito.tdp.amagramma.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagramma.DAO.anagrammaDAO;

public class Model {
	private ArrayList<Lettera> lettere;
	private HashSet<Parola> anagrammi;
	private ArrayList<Character> letterecontenute;
	private anagrammaDAO an;
	private HashSet<String> dizionario;
	
	public Model () {
		lettere= new ArrayList<Lettera>();
		letterecontenute=new ArrayList<Character>();
		anagrammi= new HashSet<Parola>();
		anagrammaDAO an= new anagrammaDAO();
		dizionario=an.getDizionario();
	}

	
	
	public HashSet<Parola> cercaAnagramma(String parola) {
		lettere.clear();
		letterecontenute.clear();
		anagrammi.clear();
		for(int i=0;i<parola.length();i++) {
			Lettera l=new Lettera();
			l.setCarattere(parola.charAt(i));
			if(!lettere.contains(l))
				lettere.add(l);
			else {
				lettere.get(lettere.indexOf(l)).aumentaRicorrenze();
				lettere.add(lettere.get(lettere.indexOf(l)));
			}
		}
		
		
		espandi( new ArrayList<Character>(), 0,  parola.length());
		return anagrammi;
		
		
	}
	
	private String creaParola(ArrayList<Character> parziale) {
		String temp="";
		for(Character lettera: parziale) {
			temp+=""+lettera;
		}
		return temp;
		
	}
	
	void espandi(ArrayList<Character> parziale, int livello, int lettereTotali){
		
		//CONDIZIONE DI TERMINAZIONE
		if(lettereTotali==parziale.size()) {
			String temp = this.creaParola(parziale);
			Parola p= new Parola();
			p.setParola(temp);
			p.setEsiste(dizionario.contains(temp));
			anagrammi.add(p);
			return;
		}
		
		
		
		
		for(int q=0;q<lettereTotali;q++) {
			int temp=0;
			for(Character c: parziale) { //CONTA LE RICORRENZE
				if(c==lettere.get(q).getCarattere())
					temp++;
			}
			if(temp< lettere.get(q).getRicorrenze()) {
		parziale.add(lettere.get(q).getCarattere());
		
		//letterecontenute.add(c)
		espandi(parziale,livello+1,lettereTotali);
		//BACKTRACK
		parziale.remove(livello);
			}
		}
	}

}
