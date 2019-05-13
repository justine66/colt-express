package modele;

public class Marshall {
	
	String NOM;
	int place ;
	
	//constructeur
	public Marshall (){
		this.NOM = "Marshall";
		this.place = Train.NB_WAGON-1 ;
	}
	
	public int getPlace(){
		return this.place;
	}

}
