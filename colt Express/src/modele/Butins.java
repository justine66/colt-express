package modele;

public class Butins {
	
	int[] place ;
	int butin ;
	String name ;
	
	public Butins(String str, int place) {
		this.name = str;
		this.setPlace(new int[2]);
		if (str == "Bourse") {
			this.butin = (int) Math.floor(Math.random() * 501 ) ;
			this.getPlace() [0]= 0;
			this.getPlace() [1] = place ;
		}
		if (str == "Bijoux") { 
			this.butin = 500; 
			this.getPlace() [0]= 0;
			this.getPlace() [1] = place ;
		}
		if (str == "Magot") {
			this.getPlace() [0]= 0;
			this.getPlace() [1] = Train.NB_WAGON-1 ;
			this.butin = 1000 ;		
		}
	}
	public Butins(String str, int butin, int[]place) {
		this.name = str;
		this.butin = butin;
		this.setPlace(place);
	}
	
	public int[] getPlace() {
		return place;
	}

	public void setPlace(int[] place) {
		this.place = place;
	}
	
	public String getName() {
		return name;
	}
	
	public String[] toString(String i) {
		String[] str  = {this.name.toString(), Integer.toString(this.butin) , this.place.toString() };
		return str;
	}

}

