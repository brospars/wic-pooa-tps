package fr.uga.wic.tp2;

public class Marque extends NoeudAbstrait {
	public Marque(NoeudAbstrait frere){
		super(frere);
	}
	@Override
	public boolean contient(String s) {
		if(s.equals("")){
			return true;
		}else if(this.frere != null){
			return this.frere.contient(s);
		}else{
			return false;
		}
	}

	@Override
	public boolean prefixe(String s) {
		if(this.frere != null){
			return this.frere.prefixe(s);
		}
		return false;
	}

	@Override
	public int nbMots() {
		int nbfreres = 0;
		
		if(this.frere != null){
			nbfreres = this.frere.nbMots();
		}
		
		return 1+nbfreres;
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
		return null;
	}
}
