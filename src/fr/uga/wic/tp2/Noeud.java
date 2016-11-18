package fr.uga.wic.tp2;

public class Noeud extends NoeudAbstrait {
	private char valeur;
	private NoeudAbstrait fils;
	
	public Noeud(NoeudAbstrait frere, NoeudAbstrait fils, char valeur){
		super(frere);
		if(fils == null)
			throw new IllegalArgumentException("Un noeud à forcement un fils");
		
		this.fils = fils;
		this.valeur = valeur;
		
	}
	
	@Override
	public boolean contient(String s) {
		if(s.isEmpty()){
			return false;
		}
		char c = s.charAt(0);
		if (c < valeur){
			return false;
		}
		if (c == this.valeur){
			return this.fils.contient(s.substring(1));
		}
		if(this.frere == null) {
			return  false;
		}
		return this.frere.contient(s);
	}

	@Override
	public boolean prefixe(String s) {
		if(s.isEmpty()){
			return true;
		}
		char c = s.charAt(0);
		if (c < valeur){
			return false;
		}
		if (c == this.valeur){
			return this.fils.prefixe(s.substring(1));
		}
		if(this.frere == null) {
			return  false;
		}
		return this.frere.prefixe(s);
	}

	@Override
	public int nbMots() {
		if(this.frere != null){
			return this.fils.nbMots() + this.frere.nbMots();
		}
		return this.fils.nbMots();
	}

	@Override
	public NoeudAbstrait ajout(String s) {
		if(s.isEmpty()){
			return new Marque(this);
		}
		NoeudAbstrait n;
		char c = s.charAt(0);
		if (c < this.valeur){
			n = new Marque(null);
			for(int i=s.length()-1; i>=0 ; i--)
				n = new Noeud(null, n, s.charAt(i));
			n.frere = this;
			return n;
		}
		if (c == this.valeur){
			this.fils = this.fils.ajout(s.substring(1));
			return this;
		}
		// c > valeur
		if(this.frere == null) {
			n = new Marque(null);
			for(int i=s.length()-1; i>=0 ; i--)
				n = new Noeud(null, n, s.charAt(i));
			this.frere = n;
			return this;
		}		
		this.frere = frere.ajout(s);
		return this;
	}

	@Override
	public NoeudAbstrait suppr(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return this.toString("");
	}

	@Override
	public String toString(String s) {
		return this.fils.toString(s+valeur)+(frere == null ? "" : this.frere.toString(s));
	}

}
