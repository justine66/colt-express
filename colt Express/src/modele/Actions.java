package modele;

import java.util.ArrayList;

import modele.Train;


public class Actions {
	
	//Methods
	
	@SuppressWarnings("null")
	public static void deplacement (String direction, Bandit bandit, Train t) {
		
		String str = null;
		if (direction == "Avant") {
			if (bandit.getPlace()[1] == Train.NB_WAGON-1){
				str = bandit.NOM + " est deja sur la locomotive";
			}
			else {
				bandit.place[1] = bandit.getPlace()[1]+1; 
				str = bandit.NOM + " ce deplace vers " + direction;
			}
		}
		if (direction == "Arriere") {
			if (bandit.getPlace()[1] == 0){
				str = bandit.NOM + " est deja sur le dernier wagon";
			}
			else {
				bandit.place[1] = bandit.getPlace()[1]-1; 
				str = bandit.NOM + " ce deplace vers " + direction;
			}
		}
		
		if (direction == "Haut") {
			if (bandit.getPlace()[0] == 1){
				 str = bandit.NOM + " est deja sur le toit";
			}
			else {
				bandit.place[0] = bandit.getPlace()[0] + 1; 
				str = bandit.NOM + " ce deplace vers " + direction;
			}
		}
		
		if (direction == "Bas") {
			if (bandit.getPlace()[0] == 0){
				str = bandit.NOM + " est deja à l'interieur";
			}
			else {
				bandit.place[0] = bandit.getPlace()[0] - 1; 
				str = bandit.NOM + " ce deplace vers " + direction;
			}
		}
		if (direction == "Braquage") {
			for(Butins b : t.getb()) {
				if (bandit.getPlace()[1] == b.getPlace()[1] && bandit.getPlace()[0] == b.getPlace()[0]){
					bandit.butin += b.butin ;
					bandit.bourse.add(b);
					System.out.println(bandit.NOM + " a ramassé une bourse : " + bandit.butin);  // pour voir si l'argent monte 
					// il faut supprimer la bourse
					//train.bourse.remove(b); 
					Train.bourse.remove(b);
					break;
				}
			}
		}
		System.out.println(bandit.getPlace()[0]);
		System.out.println(bandit.getPlace()[1]);
		System.out.println(str);
	}
	public static void attrape(Bandit bandit , Marshall marshall) {
		if (bandit.getPlace()[1] == marshall.getPlace() && bandit.getPlace()[0] == 0){
			System.out.println(bandit.NOM + " a été attrapé par le Marshall");
			bandit.getPlace()[0] = 1 ;
			bandit.getPlace()[1]= 0;
		}
	}

	public static void deplaceMarchall (Marshall marshall) {
		// faire le déplacement du marshall
		if (Math.random() <= Train.NERVOSITE_MARSHALL ) {
			if (Math.random() < 0.5) {
				if (marshall.getPlace() <= Train.NB_WAGON-1 && marshall.getPlace() > 0){
					marshall.place  = marshall.getPlace() - 1 ;
					System.out.println("Le Marshall bouge attention !! ");
				}
			}
			else if (Math.random() > 0.5) {
				if (marshall.getPlace() < Train.NB_WAGON-1 && marshall.getPlace() >= 0 ){
					marshall.place  = marshall.getPlace() + 1 ;
				}
			}
		}
	}
	
}