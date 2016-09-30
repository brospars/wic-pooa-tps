package fr.uga.wic.tp1;

import java.util.Map;

public class Noeud extends NoeudAbstrait{
	private NoeudAbstrait gauche;
	private NoeudAbstrait droit;
	
	public Noeud(int poids, NoeudAbstrait gauche, NoeudAbstrait droit) {
		super(poids);
		this.gauche = gauche;
		this.droit = droit;
	}
	
	public void fournitCode(Map<Character, String> m, String prefixe){
		this.gauche.fournitCode(m, prefixe+"0");
		this.droit.fournitCode(m, prefixe+"1");
	}
	
	public Character getNextChar(String s) throws FinDeTexteInattendueException {
		if (s.isEmpty())
			throw new FinDeTexteInattendueException();
		if (s.charAt(0) == '0'){
			String suite = s.substring(1);
			return this.gauche.getNextChar(suite);
		}
		else {
			String suite = s.substring(1);
			return this.droit.getNextChar(suite);
		}
	}
	
	
	
}
