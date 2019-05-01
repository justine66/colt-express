package Vue;

import java.applet.Applet;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import modele.Bandit;
import modele.Train;


@SuppressWarnings("deprecation")
public class Vue extends Applet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
		
        setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);
		
		VueTrain vueT = new VueTrain(new Train());
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
	    makebutton("arrière", gridbag, c);

	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 3;
	    c.gridy = 2;
	    makebutton("haut", gridbag, c);
		
	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 3;
	    c.gridy = 4;
	    makebutton("bas", gridbag, c);
	    
	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 4;
	    c.gridy = 3;
	    makebutton("avant", gridbag, c);
	    
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
	public class Boutton_Action extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Boutton_Action(String texte){
			super(texte);
		}
	 
		public void actionPerformed(ActionEvent e) { 
			modele.Actions.deplacement(e.getActionCommand(), new Bandit (Train.NOM_BANDIT_1));
		    System.out.println("action");
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
		System.out.println("fini");
		
		
		
	}
}
