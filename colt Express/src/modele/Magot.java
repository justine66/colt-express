package modele;

public class Magot extends Butins {

	int[] place ;
	int butin ;
		
	public Magot(){
		super.setPlace(new int[2]);
		super.getPlace() [0]= 0;
		super.getPlace() [1] = Train.NB_WAGON-1 ;
		this.butin = 1000 ;		
	}
}
