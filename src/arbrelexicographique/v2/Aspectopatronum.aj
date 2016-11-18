package arbrelexicographique.v2;

public aspect Aspectopatronum {
	private NoeudVide instance = new NoeudVide();
	
	private pointcut appelConstructeur() : call(NoeudVide.new()) && ! within(arbrelexicographique.v2.Aspectopatronum);
	
	NoeudVide around () : appelConstructeur(){
		return instance;
	}
	
}

