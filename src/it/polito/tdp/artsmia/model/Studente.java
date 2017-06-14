package it.polito.tdp.artsmia.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Studente {
	
	private Set<Integer> viste ;
	private Exhibition prossimo ;
	
	public Studente(Exhibition e){
		this.viste = new HashSet<>();
		this.prossimo = e ;
	}

	public Set<Integer> getViste() {
		return viste;
	}

	public void setViste(Set<Integer> viste) {
		this.viste = viste;
	}

	public Exhibition getProssimo() {
		return prossimo;
	}

	public void setProssimo(Exhibition prossimo) {
		this.prossimo = prossimo;
	}
	
	

}
