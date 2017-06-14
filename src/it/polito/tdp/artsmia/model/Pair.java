package it.polito.tdp.artsmia.model;

public class Pair {

	private Exhibition source ;
	private Exhibition target ;
	
	
	public Pair(Exhibition source, Exhibition target) {
		super();
		this.source = source;
		this.target = target;
	}


	public Exhibition getSource() {
		return source;
	}


	public Exhibition getTarget() {
		return target;
	}
	
	
	
	
	
}
