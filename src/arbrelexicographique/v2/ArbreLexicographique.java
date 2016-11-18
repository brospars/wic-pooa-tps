package arbrelexicographique.v2;

public class ArbreLexicographique {
	private NoeudAbstrait entree;
	
	public ArbreLexicographique() {
		entree = new NoeudVide();
	}
	
	public boolean contient(String s) {
		return entree.contient(s);
	}
	
	public boolean prefixe(String s){
		return entree.prefixe(s);
	}
	
	public int nbMots(){
		return entree.nbMots();
	}
	
	public boolean ajout(String s){
		try {
			entree = entree.ajout(s);
		} catch (MissionImpossibleException e) {
			// Ajout du mot impossible car déjà présent
			return false;
		}
		return true;
	}
	
	public boolean suppr(String s){
		try {
			entree = entree.suppr(s);
		} catch (MissionImpossibleException e) {
			// Suppression du mot impossible car il est déjà parti voir ailleurs
			return false;
		}
		return true; 
	}
	
	public String toString(){
		return entree.toString("");
	}
	
	public boolean estVide(){
		return entree instanceof NoeudVide;
	}
	
	public static void main(String[] args) {

		ArbreLexicographique chene = new ArbreLexicographique();
		System.out.println("Est ce que c'est un arbre creux :  "+chene.estVide());
		chene.ajout("exemple");

		// Il n'y a aucun retour sur l'ajout d'un mot déjà existant (identique pour la suppression) 
		chene.ajout("personne");
		chene.ajout("exo");
		chene.ajout("exemple");
		chene.ajout("dernier");
		// Problème d'ergonomie, d'ajout d'une chaine vide pour l'utilisation de toString 
		System.out.println(chene);
		chene.suppr("absent");
		System.out.println(" Une personne dans un chene : "+chene.suppr("personne"));
		System.out.println(" Par contre deux personne : "+chene.suppr("personne"));
		System.out.println(chene.toString());
		System.out.println(chene.contient("mot"));
		System.out.println(chene.contient("dernier"));
		System.out.println(chene.prefixe("der"));
		System.out.println(chene.prefixe("exa"));
		System.out.println(chene.nbMots());
		System.out.println("Est ce que c'est un arbre creux :  "+chene.estVide());
	
	}
	

}
