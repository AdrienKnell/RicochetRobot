package vue.actionListener;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.GameController;
import model.ModelContent;
import vue.Frame;

/**
 * <b>Listener est la classe qui capte toutes les actions au clavier de l utilisateur.</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */
public class Listener implements KeyListener{
	
	/**
     * 	<b> Instance de {link@ model.ModelContent} qui represente la partie avec laquelle l utilisateur interragit </b>
     */
	public ModelContent partie;
	
	/**
     * 	<b> Instance de {link@ vue.Frame} qui represente la fenetre d affichage du jeu. </b>
     */
	public Frame fenetre;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * @param partie
     * 			Instance de {link@ model.ModelContent}.
     * @param fenetre
     * 			Instance de {link@ vue.Frame}.
     */
	public Listener(ModelContent partie, Frame fenetre) {
		this.partie = partie;
		this.fenetre = fenetre;
	}
	
	/**
	 * <b> Methode qui permet d ecouter toutes les actions clavier de l utilisateur et d agir en fonction. </b>
	 * 
	 * @param k
	 * 		Action de l utilisateur.
	 */
	public void keyPressed(KeyEvent k)
	{
		
		if(!this.partie.over) {
			switch(k.getKeyCode())
			{
				//Key codes:
				//Up arrow: 38
				//Down arrow: 40
				//Left arrow: 37
				//Right arrow: 39
				//R: 82
				//G: 72
				//Y: 89
				//B: 66
			
				case 38:{GameController.increaseMoveCounter(this.partie);GameController.moveRobot(this.partie, this.fenetre, 0); break;}
				case 40:{GameController.increaseMoveCounter(this.partie);GameController.moveRobot(this.partie, this.fenetre,1);break;}
				case 37:{GameController.increaseMoveCounter(this.partie);GameController.moveRobot(this.partie, this.fenetre,2);break;}
				case 39:{GameController.increaseMoveCounter(this.partie);GameController.moveRobot(this.partie, this.fenetre,3);break;}
			
				case 65: {System.out.println("here"); GameController.reset(this.partie);break;}
				case 82: {System.out.println("Red robot selected"); GameController.switchSelectedRobot(this.partie, 0); break;}
				case 71: {System.out.println("Green robot selected"); GameController.switchSelectedRobot(this.partie,1);break;}
				case 89: {System.out.println("Yellow robot selected"); GameController.switchSelectedRobot(this.partie,2);break;}
				case 66:{System.out.println("Blue robot selected"); GameController.switchSelectedRobot(this.partie,3);break;}
				
				default:{System.out.println(k.getKeyCode()); break;}
			}
		}
	}
				

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
