package modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ActionTest {
	
	@Test
	public void testAction() {
		Bandit b1 = new Bandit("karl");
		String d1 = "Avant";
		String d2 = "Arriere";
		String d3 = "Haut";
		String d4 = "Bas";
		
		Actions.deplacement (d2, b1);
		assertEquals(1, b1.place[0]);
		assertEquals(0, b1.place[1]);
		
		Actions.deplacement (d1, b1);
		assertEquals(1, b1.place[0]);
		assertEquals(1, b1.place[1]);
		
		Actions.deplacement (d3, b1);
		assertEquals(1, b1.place[0]);
		assertEquals(1, b1.place[1]);
		
		Actions.deplacement (d4, b1);
		Actions.deplacement (d4, b1);
		Actions.deplacement (d1, b1);
		assertEquals(0, b1.place[0]);
		assertEquals(2, b1.place[1]);
		
		Actions.deplacement (d3, b1);
		Actions.deplacement (d1, b1);
		Actions.deplacement (d1, b1);
		assertEquals(1, b1.place[0]);
		assertEquals(3, b1.place[1]);
		
		Actions.deplacement (d2, b1);
		assertEquals(1, b1.place[0]);
		assertEquals(2, b1.place[1]);
	}

}
