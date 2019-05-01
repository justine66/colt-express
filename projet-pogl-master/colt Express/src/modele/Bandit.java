package modele;

public class Bandit {
	//attributs
	
	String NOM;
	int[] place ;
	int butin = 0;
	int balle = 6;
	
	//constructeur
	public Bandit (String nom){
		this.NOM = nom;
		this.place = new int[2];
		this.place[0] = 1;
		this.place[1] = 0;
	}
	

}
