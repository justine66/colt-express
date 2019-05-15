package Vue;


import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import modele.Train;


public class Vue extends Container{
	
	private static final long serialVersionUID = 1L;
	protected static Train t= new Train();
	protected ArrayList<String> l = new ArrayList<>();
	
	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
		
        //setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);
		
		
		VueTrain vueT = new VueTrain(t);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
	    c.gridy = 1;
	    gridbag.setConstraints(vueT, c);
		add(vueT, c);
		
		//creation des bouttons 
		
		c.gridx = 3;
	    c.gridy = 3;
	    makebutton("Action !", gridbag, c);
	    
		//c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 2;
	    c.gridy = 3;
	    makebutton("Arriere", gridbag, c);

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
	    
	    c.fill = GridBagConstraints.VERTICAL;
	    c.gridx = 2;
	    c.gridy = 2;
	    makebutton("Braquage", gridbag, c);
	    
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
		
		private static final long serialVersionUID = 1L;
		
		//partie IV
		


		public Boutton_Action(String texte){
			super(texte);
			
		}
	 
		public void actionPerformed(ActionEvent e, ArrayList<String> l) { 
			System.out.println("debut : " + l.toString() + "; Prepa : " + t.getPrepa() + "; Action : " + t.getAction());
			
			//Distinction des differents cas :
			
			//Cas de la phase de planification
			if(t.getPrepa()) {
				//Ajout a la liste des actions a effectuer pendant la phase d'action
				if (e.getActionCommand() != "Action !") {
					l.add(e.getActionCommand());
					
					//MAJ des etats
					if(l.size() == t.NB_ACTIONS) {
						t.setAction(true);
						t.setPrepa(false);
						System.out.println("Maj state");
						System.out.println("fin : " + l.toString() + "; Prepa : " + t.getPrepa() + "; Action : " + t.getAction());
						return;
					}
				} else {
					//Controlle si on presse le boutton action pendant que c'est la pr�paration
					System.out.println("Phase de preparation, choix impossible !");
					
				}
				
			} 
			
			//Cas de la phase d'action
			if (t.getAction()) {
				//On effectue la premiere action de la liste puis on la retire
				if (e.getActionCommand() == "Action !") {
					modele.Actions.deplaceMarchall(t.getMarshall());
					modele.Actions.attrape(t.getBandit_1() , t.getMarshall());
					modele.Actions.deplacement(l.get(0), t.getBandit_1(), t);
					l.remove(0); 
					modele.Actions.attrape(t.getBandit_1() , t.getMarshall()); //il peut attrapper avant et apres
					
					//MAJ des etats
					if(l.size()== 0) {
						t.setAction(false);
						t.setPrepa(true);
						System.out.println("MAJ state #2");
						System.out.println("fin : " + l.toString() + "; Prepa : " + t.getPrepa() + "; Action : " + t.getAction());
						
					}
				} else {
					//Controlle si on clique sur un boutton autre que action pendant la phase d'action
					System.out.println("Phase d'action, choix impossible !");
					
				}

			}
			
			System.out.println("fin : " + l.toString() + "; Prepa : " + t.getPrepa() + "; Action : " + t.getAction());
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
		//System.out.println("fini"); k
		
		
		
	}

	
}
