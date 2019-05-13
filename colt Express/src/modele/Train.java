package modele;

import java.util.ArrayList;

public class Train {
	//attributs
	public static final int  NB_WAGON = 4;
	public final static double NERVOSITE_MARSHALL = 0.9;
	public static final String  NOM_BANDIT_1 = "Karl";
	public static final String[] BUTINS = {"Bourse", "Bijoux"};
	protected Bandit bandit_1;
	protected Marshall marshall;
	protected ArrayList<Object> toits= new ArrayList<>();
	protected ArrayList<Object> interieurs= new ArrayList<>();
	protected ArrayList<Butins[]> bourse;
	protected Magot magot ;
	
	//constructeur
	public Train (){
		this.setBandit_1(new Bandit (NOM_BANDIT_1));	
		marshall = new Marshall();
		bourse = new ArrayList<>();
		for (int j =0; j< NB_WAGON-1; j++) { //on parcours les wagons
			int random = (int) ((Math.random() * 4)+1); //on determine le nb de butins
			Butins[] butin = new Butins[random];
			System.out.println(random);
			for (int i = 0 ; i < random ; i++) { //on crée les butins
				String str = BUTINS[(int) Math.random()* 2];
				
				if (str == "Bourse") {
					butin[i] = new Bourse();
				}
				else {
					butin[i] =new Bijoux();
				}
			}
			//System.out.println(""+butin);
			bourse.add(butin); // on initialise dans le train
		}
		//System.out.println(bourse);
		magot = new Magot() ;
		System.out.println(this);
	}

	//methode
	
	public Bandit getBandit_1() {
		return bandit_1;
	}

	public void setBandit_1(Bandit bandit_1) {
		this.bandit_1 = bandit_1;
	}
	
	public Marshall getm() {
		return marshall;
	}

	
	
	public ArrayList<Butins[]> getb() {
		return this.bourse;
	}

	public Magot getmagot() {
		return magot;

	}
}

