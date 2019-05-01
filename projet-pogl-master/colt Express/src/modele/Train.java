package modele;

import java.util.ArrayList;

public class Train {
	//attributs
	public static final int  NB_WAGON = 4;
	public static final String  NOM_BANDIT_1 = "Karl";
	protected Bandit bandit_1;
	protected ArrayList<Object> toits= new ArrayList<>();
	protected ArrayList<Object> interieurs= new ArrayList<>();
	
	//constructeur
	public Train (){
		this.bandit_1 = new Bandit (NOM_BANDIT_1);	
	}

	//methode
	public Bandit get() {
		return bandit_1;
	}
	
}

