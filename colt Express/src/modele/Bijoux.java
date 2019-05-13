package modele;

public class Bijoux extends Butins{
	
	int[] place ;
	int butin ;
	String name = "Bijoux";
		
	public Bijoux(){
		super.setPlace(new int[2]);
		super.getPlace() [0]= 0;
		super.getPlace() [1] = (int) (Math.random() * Train.NB_WAGON-1) ;
		this.butin = 500 ;		
	}
	

}
