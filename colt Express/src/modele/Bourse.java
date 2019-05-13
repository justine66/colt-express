package modele;

public class Bourse extends Butins{
	
	int[] place ;
	int butin ;
	String name  = "Bourse" ;
		
	public Bourse(){
		super.setPlace(new int[2]);
		super.getPlace() [0]= 0;
		super.getPlace() [1] = (int) (Math.random() * Train.NB_WAGON-1) ;
		this.butin = (int) (Math.random() * ( 300 - 100 )) ;		
	}

	
	
}
