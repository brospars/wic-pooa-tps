package arbrelexicographique;

public abstract class NoeudAbstrait {
	protected NoeudAbstrait frere;

	public NoeudAbstrait(NoeudAbstrait frere) {
		this.frere = frere;
	}

	public abstract boolean contient(String s);

	public abstract boolean prefixe(String s);

	public abstract int nbMots(); // nombre d'�l�ments

	public abstract NoeudAbstrait ajout(String s) throws MissionImpossibleException;

	public abstract NoeudAbstrait suppr(String s) throws MissionImpossibleException;

	public abstract String toString(String s); // �l�ments s�par�s par \n

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		NoeudAbstrait entree = new NoeudVide();
//		entree = entree.ajout("exemple");
//
//		// Il n'y a aucun retour sur l'ajout d'un mot déjà existant (identique pour la suppression) 
//		entree = entree.ajout("personne");
//		entree = entree.ajout("exo");
//		entree = entree.ajout("exemple");
//		entree = entree.ajout("dernier");
//		// Problème d'ergonomie, d'ajout d'une chaine vide pour l'utilisation de toString 
//		System.out.println(entree.toString(""));
//		entree = entree.suppr("absent");
//		entree = entree.suppr("personne");
//		entree = entree.suppr("personne");
//		System.out.println(entree.toString(""));
//		System.out.println(entree.contient("mot"));
//		System.out.println(entree.contient("dernier"));
//		System.out.println(entree.prefixe("der"));
//		System.out.println(entree.prefixe("exa"));
//		System.out.println(entree.nbMots());
//	}

}
