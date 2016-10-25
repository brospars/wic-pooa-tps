package fr.uga.wic.tp2;

public abstract class NoeudAbstrait {
	protected NoeudAbstrait frere;
	
	public NoeudAbstrait(NoeudAbstrait frere){
		this.frere = frere;
	}
	
	public abstract boolean contient(String s);
	public abstract boolean prefixe(String s);
	public abstract int nbMots();
	public abstract NoeudAbstrait ajout(String s);
	public abstract NoeudAbstrait suppr(String s);
	public abstract String toString();
	public abstract String toString(String s);

	public static void main(String[] args){
		NoeudAbstrait entree = new Marque(null);
		entree = entree.ajout("exemple");
		entree = entree.ajout("personne");
		entree = entree.ajout("exo");
		entree = entree.ajout("exemple");
		System.out.println(entree);

	}
}
