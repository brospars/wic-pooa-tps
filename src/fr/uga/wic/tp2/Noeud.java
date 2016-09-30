package fr.uga.wic.tp2;

public class Noeud extends NoeudAbstrait {
	private char valeur;
	private NoeudAbstrait fils;
	
	public Noeud(NoeudAbstrait frere, NoeudAbstrait fils, char valeur){
		super(frere);
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
		return this.frere.contient(s.substring(1));
	}

	@Override
	public boolean prefixe(String s) {
		if(s.isEmpty()){
			return true;
		}else if (s.charAt(0) == this.valeur){
			return this.fils.prefixe(s.substring(1));
		} else if(this.frere != null) {
			return  this.frere.prefixe(s.substring(1));
		}else{
			return false;
		}
	}

	@Override
	public int nbMots() {
		int nbfils = 0, nbfreres = 0;
		
		if(this.frere != null){
			nbfreres = this.frere.nbMots();
		}
		if(this.fils != null){
			nbfils = this.fils.nbMots();
		}
		return nbfils+nbfreres;
	}

	@Override
	public NoeudAbstrait ajout(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoeudAbstrait suppr(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		/*String str = ""+this.valeur;
		String strfrere = "";
		String strfils = "";
		
		if(this.frere != null){
			strfrere = this.frere.toString();
		}
		if(this.fils != null){
			strfils = this.fils.toString();
		}
		*/
		return null;
	}

}
