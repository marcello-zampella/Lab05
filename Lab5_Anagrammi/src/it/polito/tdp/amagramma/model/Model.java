package it.polito.tdp.amagramma.model;

import java.util.ArrayList;

import it.polito.tdp.anagramma.DAO.anagrammaDAO;

public class Model {
	private ArrayList<Lettera> lettere;
	private ArrayList<Parola> anagrammi;
	private ArrayList<Character> letterecontenute;
	private anagrammaDAO an;
	private int k;
	
	public Model () {
		lettere= new ArrayList<Lettera>();
		letterecontenute=new ArrayList<Character>();
		anagrammi= new ArrayList<Parola>();
		an= new anagrammaDAO();
		
	}

	
	
	public ArrayList<Parola> cercaAnagramma(String parola) {
		k=0;
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
		anagrammaDAO an= new anagrammaDAO();
		System.out.println(k);
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
		k++;
		
		if(lettereTotali==parziale.size()) {
			String temp = this.creaParola(parziale);
			Parola p= new Parola();
			p.setParola(temp);
			p.setEsiste(an.parolaEsiste(temp));
			if(!anagrammi.contains(p)) {
			anagrammi.add(p);
			}
			return;
		}
		
		
		
		
		for(int q=0;q<lettereTotali;q++) {
			int temp=0;
			for(Character c: parziale) {
				if(c==lettere.get(q).getCarattere())
					temp++;
			}
			if(temp< lettere.get(q).getRicorrenze()) {
		parziale.add(lettere.get(q).getCarattere());
		
		//letterecontenute.add(c)
		espandi(parziale,livello+1,lettereTotali);
		parziale.remove(livello);
			}
		}
	}

}
