package arbrelexicographique.v2;

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

}
