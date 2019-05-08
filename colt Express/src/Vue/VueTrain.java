package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import modele.Bandit;
import modele.Train;


public class VueTrain extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	//Attributs
	private Train train;
	
	private final int WIDTH = 100;
	private final int HEIGHT = 50;
	
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
		int compteur = 0;
		for (int i = 25; i < Train.NB_WAGON*WIDTH + 4 * 5; i = i + WIDTH + 5) {
			int compteur1 = 1;
			for (int j = 15; j < 2*HEIGHT + 10; j = j + HEIGHT + 10) {
				paint(g, i, j);
				if (bandit.getPlace()[0]== compteur1 && bandit.getPlace()[1]== compteur ) {
			         paintBandit(g, i+10, j+10);
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
		g.fillRect(x, y, 10, 10);
	}
}
