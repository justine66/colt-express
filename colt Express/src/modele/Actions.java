package modele;

public class Actions {
	
	//Methods
	
	public static void deplacement (String direction, Bandit bandit) {
		String str = bandit.NOM + " ce déplace vers " + direction;
		if (direction == "Avant") {
			if (bandit.getPlace()[1] == Train.NB_WAGON-1){
				str = bandit.NOM + " est deja sur la locomotive";
			}
			else {
				bandit.place[1] = bandit.getPlace()[1]+1; 
			}
		}
		if (direction == "Arriere") {
			if (bandit.getPlace()[1] == 0){
				str = bandit.NOM + " est deja sur le dernier wagon";
			}
			else {
				bandit.place[1] = bandit.getPlace()[1]-1; 
			}
		}
		
		if (direction == "Haut") {
			if (bandit.getPlace()[0] == 1){
				str = bandit.NOM + " est deja sur le toit";
			}
			else {
				bandit.place[0] = bandit.getPlace()[0] + 1; 
			}
		}
		
		if (direction == "Bas") {
			if (bandit.getPlace()[0] == 0){
				str = bandit.NOM + " est deja à l'intérieur";
			}
			else {
				bandit.place[0] = bandit.getPlace()[0] - 1; 
			}
		}
		System.out.println(bandit.getPlace()[0]);
		System.out.println(bandit.getPlace()[1]);
		System.out.println(str);
		
	}
}