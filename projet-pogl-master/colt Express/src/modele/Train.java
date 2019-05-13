package modele;

import java.util.ArrayList;

public class Train {
	//attributs
	public static final int  NB_WAGON = 4;
	public static final String  NOM_BANDIT_1 = "Karl";
	private Bandit bandit_1;
	protected ArrayList<Object> toits= new ArrayList<>();
	protected ArrayList<Object> interieurs= new ArrayList<>();
	
	//constructeur
	public Train (){
		this.setBandit_1(new Bandit (NOM_BANDIT_1));	
	}

	//methode
	
	public Bandit getBandit_1() {
		return bandit_1;
	}

	public void setBandit_1(Bandit bandit_1) {
		this.bandit_1 = bandit_1;
	}
	
}

