package Vue;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

import modele.Bandit;
import modele.Train;


public class Vue extends Container{
	
	private static final long serialVersionUID = 1L;
	protected Train t= new Train();
	protected TreeMap<String, Bandit> l = new TreeMap<>();
	
	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
		
        setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);
		
		
		VueTrain vueT = new VueTrain(t);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
	    c.gridy = 1;
	    gridbag.setConstraints(vueT, c);
		add(vueT, c);
		
		//création des bouttons 
		
		c.gridx = 2;
	    c.gridy = 1;
	    makebutton("Action !", gridbag, c);
	    
		c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 2;
	    c.gridy = 3;

	    makebutton("Arriere", gridbag, c);

	    makebutton("Arrière", gridbag, c);

	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 3;
	    c.gridy = 2;
	    makebutton("Haut", gridbag, c);
		
	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 3;
	    c.gridy = 4;
	    makebutton("Bas", gridbag, c);
	    
	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 4;
	    c.gridy = 3;
	    makebutton("Avant", gridbag, c);
	    
	    setSize(500, 500);	
	    
	}
	
	protected void makebutton(String name,
   GridBagLayout gridbag, GridBagConstraints c) {
		JButton button = new JButton(new Boutton_Action(name));
	    button.setVerticalTextPosition(AbstractButton.BOTTOM);
	    button.setHorizontalTextPosition(AbstractButton.CENTER);
	    button.setActionCommand(name);

		gridbag.setConstraints(button, c);
		add(button);
	}
	
	public  class Boutton_Action extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Boutton_Action(String texte){
			super(texte);
		}
	 
		public void actionPerformed(ActionEvent e, TreeMap<String, Bandit> l) { 
			if (e.getActionCommand() != "Action !") { 
				l.put(e.getActionCommand(), t.getBandit_1());
			}
			else{ 
				System.out.println(l);
				String key = l.firstKey();
				Bandit value = l.get(key);
				modele.Actions.deplacement(key, value);	
				l.remove(key, value);
				
			} 
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			actionPerformed(e, l);
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame fenetre = new JFrame ("Colt Express");
		Vue fenet = new Vue();
		fenet.init();
		fenetre.add(fenet);
		fenetre.pack();
		fenetre.setSize(fenetre.getPreferredSize());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.setVisible(true);
		fenetre.setLocation(10, 10);
		
		
		
	}

	
}
