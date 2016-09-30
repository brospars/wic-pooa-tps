package fr.uga.wic.tp1;

import java.util.Map;

public class Feuille extends NoeudAbstrait{
	private Character caractere;
	
	public Feuille(Character c, int poids) {
		super(poids);
		this.caractere = c;
	}

	public void fournitCode(Map<Character, String> m, String prefixe) {
		m.put(this.caractere, prefixe);
	}
	
	public Character getNextChar(String s) throws FinDeTexteInattendueException {
		return this.caractere;
	}

}
