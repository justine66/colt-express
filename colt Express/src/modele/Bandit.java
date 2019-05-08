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
		this.setPlace(new int[2]);
		this.getPlace()[0] = 1;
		this.getPlace()[1] = 0;
	}

	public int[] getPlace() {
		return place;
	}

	public void setPlace(int[] place) {
		this.place = place;
	}
	

}
