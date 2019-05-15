package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Bandit;
import modele.Butins;
import modele.Marshall;
import modele.Train;


public class VueTrain extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	//Attributs
	private Train train;
	
	private final int WIDTH = 200;
	private final int HEIGHT = 200;
	
	public VueTrain(Train t) {
		this.train = t;
		
		//Train.addObserver(this);
		
		Dimension dim = new Dimension(100 + WIDTH*Train.NB_WAGON, 50 + HEIGHT * 2);
		this.setPreferredSize(dim);
	}
	
	public void update() { 
		repaint(); 
	}
		
	public void paintComponent(Graphics g){
		super.repaint();
		
		Bandit bandit = this.train.getBandit_1();
		Marshall marshall = this.train.getm();
		ArrayList<Butins> bourse =  this.train.getb();
		int compteur = 0;
		for (int i = 25; i < Train.NB_WAGON*WIDTH + 4 * 5; i = i + WIDTH + 5) {
			int compteur1 = 1;
			for (int j = 15; j < 2*HEIGHT + 10; j = j + HEIGHT + 10) {
				int compteur3 = 0;
				paint(g, i, j);
				
				if (bandit.getPlace()[0]== compteur1 && bandit.getPlace()[1]== compteur ) {
			         paintBandit(g, i+10, j+10);

		         }
				
				if (marshall.getPlace()== compteur && 0 == compteur1 ) {  // on parcours tous les emplacement
					paintMarshall(g, i+40, j+10);
		         }
				
				for ( Butins b : bourse) {
					if (b.getPlace()[1]== compteur && b.getPlace()[0]== compteur1) {  // on parcours tous les emplacement
						if(b.getName() == "Bourse") {
							paintBourse(g, i+70, j+10+compteur3);
							compteur3 += 20;
						}
						if(b.getName() == "Bijoux") {
	
							paintBijoux(g, i+70, j+10+compteur3);
							compteur3 += 20;
						}
						if(b.getName() == "Magot") {
							paintMagot(g, i+70, j+35);
						
						}	
					}
				}
				compteur1--;
			}
			compteur++;
		}
		update();
		 
	}
	
	public void paint(Graphics g, int x, int y){
		g.setColor(Color.GRAY);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public void paintBandit(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 20);
		g.setColor(Color.BLACK);
		g.drawString(Train.NOM_BANDIT_1, x, y+10);
		
		
	}
	
	public void paintMarshall(Graphics g, int x, int y){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 55, 20);
		g.setColor(Color.BLACK);
		g.drawString("Marshall", x, y+10);
	}
	
	public void paintBourse(Graphics g, int x, int y){
		g.setColor(Color.cyan);
		g.fillRect(x, y, 45, 10);
		g.setColor(Color.BLACK);
		g.drawString("Bourse", x, y+10);
	}
	
	public void paintBijoux(Graphics g, int x, int y){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 45, 10);
		g.setColor(Color.BLACK);
		g.drawString("Bijoux", x, y+10);
	}
	
	public void paintMagot(Graphics g, int x, int y){
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, 45, 10);
		g.setColor(Color.BLACK);
		g.drawString("Magot", x, y+10);
	}
}
