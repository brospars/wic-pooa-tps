package fr.uga.wic.tp1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Huffman {
	private Map<Character, String> dictionnaire;
	private NoeudAbstrait arbre;
	
	public Huffman(String texte){
		initArbre(compteCaracteres(texte));
		initDictionnaire();
	}
	
	private Map<Character, Integer> compteCaracteres(String texte){
		
		Map<Character, Integer> map = new TreeMap <Character, Integer>();
		
		for(int i=0; i<texte.length(); i++){
			if(map.get(texte.charAt(i)) == null){
				map.put(texte.charAt(i),1);
			}else{
				map.put(texte.charAt(i), map.get(texte.charAt(i))+ 1);
			}
		}
		
		return map;
	}
	
	private void initArbre(Map<Character, Integer> comptes){
		ListeTriee list = new ListeTriee();
		for (Character c : comptes.keySet()){
			list.add(new Feuille (c, comptes.get(c)));			
		}
		NoeudAbstrait g, d ;
		while (list.size() > 1){
			g = list.removeFirst();
			d = list.removeFirst();
			list.add(new Noeud(g.getPoids() + d.getPoids(), g, d));
		}
		
		arbre = list.removeFirst();
		
	}
	
	private void initDictionnaire(){
		this.dictionnaire = new TreeMap<Character, String>();
		arbre.fournitCode(dictionnaire,"");
	}
	
	public String code(String texte) throws CaractereInconnuException{
		String textBinary = "";
		for(int i=0; i<texte.length(); i++){
			textBinary = textBinary + this.dictionnaire.get(texte.charAt(i));
		}
		return textBinary;
	}
	
	public String decode(String texte) throws FinDeTexteInattendueException{
		String result = "";
		while (! texte.isEmpty()){
			char c = arbre.getNextChar(texte);
			result = result + c;
			texte = texte.substring(dictionnaire.get(c).length());
		}
		return result;
	}
	
	public void printDico(){
		for (Character key : this.dictionnaire.keySet()){
			System.out.println(key + " : " + dictionnaire.get(key));
		}
	}

}
