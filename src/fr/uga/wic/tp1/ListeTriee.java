package fr.uga.wic.tp1;

import java.util.Collection;
import java.util.LinkedList;

public class ListeTriee extends LinkedList<NoeudAbstrait>{

	public ListeTriee() {
		super();
	}

	public ListeTriee(Collection<? extends NoeudAbstrait> c) {
		super(c);
	}
	
	public boolean add(NoeudAbstrait n){
		int i;
		for (i=0; i < this.size() && n.compareTo(this.get(i)) > 0; i++){
		}
		
		this.add(i,n);
		
		return true;
	}
	
	public boolean addAll(Collection<? extends NoeudAbstrait> c){
		for (NoeudAbstrait n : c){
			this.add(n);
		}
		return this.size() > 0;
	}
}
