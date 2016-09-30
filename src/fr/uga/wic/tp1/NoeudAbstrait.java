package fr.uga.wic.tp1;

import java.util.Map;

public abstract class NoeudAbstrait implements Comparable<NoeudAbstrait> {
	private int poids;

	public NoeudAbstrait() {
		super();
	}

	public NoeudAbstrait(int poids) {
		super();
		this.poids = poids;
	}
	
	public int getPoids(){
		return this.poids;
	}
	
	public int compareTo(NoeudAbstrait n){
		
		return this.poids - n.getPoids();
	}
	
	public abstract void fournitCode(Map<Character, String> m, String prefixe);
	
	public abstract Character getNextChar(String s) throws FinDeTexteInattendueException;
	
	
}
