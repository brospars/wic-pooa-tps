package fr.uga.wic.tp2;

public class NoeudVide extends NoeudAbstrait {
	public NoeudVide(NoeudAbstrait frere){
		super(frere);
	}
	@Override
	public boolean contient(String s) {
		return s.isEmpty() || (frere != null && frere.contient(s));
	}

	@Override
	public boolean prefixe(String s) {
		return s.isEmpty() || (frere != null && frere.prefixe(s));
	}

	@Override
	public int nbMots() {
		
		if(this.frere != null){
			return 1+this.frere.nbMots();
		}
		
		return 1;
	}

	@Override
	public NoeudAbstrait ajout(String s) {
		NoeudAbstrait n;
		if(s.isEmpty()){
			return this;
		}
		if(this.frere == null){
			n = new Marque(null);
			for(int i=s.length() - 1; i >=0 ; i--){
				n = new Noeud(null,n,s.charAt(i));
			}
			this.frere = n;
			return this;
		}
		
		this.frere = this.frere.ajout(s);
		return this;
	}

	@Override
	public NoeudAbstrait suppr(String s) {
		NoeudAbstrait n;
		if(s.isEmpty()){
			return this.frere;
		}
		if(this.frere != null){
			this.frere = this.frere.suppr(s);
		}
		return this;
	} 

	@Override
	public String toString() {
		return this.toString("");
	}

	@Override
	public String toString(String s) {
		return (frere == null ? s : this.frere.toString(s))+"\n";
	}
}
