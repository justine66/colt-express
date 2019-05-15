package modele;

import java.util.ArrayList;

public class Train {
	//attributs
	public static final int  NB_WAGON = 4;
	public final static double NERVOSITE_MARSHALL = 0.9;
	public static final String  NOM_BANDIT_1 = "Karl";
	protected Bandit bandit_1;
	private Marshall marshall;
	protected ArrayList<Object> toits = new ArrayList<>();
	protected ArrayList<Object> interieurs = new ArrayList<>();
	protected static ArrayList<Butins> bourse;
	
	//etat des actions
	private boolean isActionState = false;
	private boolean isPreparationState = true;
	public static final int NB_ACTIONS = 4;
	
	//constructeur
	public Train (){
		this.setBandit_1(new Bandit (NOM_BANDIT_1));	
		setMarshall(new Marshall());
		bourse = new ArrayList<>();
		String str;
		for (int j =0; j< NB_WAGON-1; j++) { //on parcours les wagons
			int random = (int) ((Math.random() * 4)+1); //on determine le nb de butins
			//System.out.println(random); k
			for (int i = 0 ; i < random ; i++) { //on cree les butins
				double choix = Math.random();
				if (choix < 0.65) {
					str = "Bourse";
				} else {
					str = "Bijoux";
				}
				bourse.add(new Butins(str, j));
			}
		}
		//System.out.println();
		bourse.add(new Butins("Magot", 0)) ; //2eme parametre n'est pas essantiel pour le magot
		
		
	}

	//methode
	
	public Bandit getBandit_1() {
		return bandit_1;
	}

	public void setBandit_1(Bandit bandit_1) {
		this.bandit_1 = bandit_1;
	}
	
	public Marshall getm() {
		return getMarshall();
	}

	
	
	public ArrayList<Butins> getb() {
		return Train.bourse;
	}
	
	public void setb(ArrayList<Butins> b){
		Train.bourse = b;
	}

	public boolean getPrepa() {
		return isPreparationState;
	}

	public void setPrepa(boolean isPreparationState) {
		this.isPreparationState = isPreparationState;
	}

	public boolean getAction() {
		return isActionState;
	}

	public void setAction(boolean isActionState) {
		this.isActionState = isActionState;
	}

	public Marshall getMarshall() {
		return marshall;
	}

	public void setMarshall(Marshall marshall) {
		this.marshall = marshall;
	}
	
}

