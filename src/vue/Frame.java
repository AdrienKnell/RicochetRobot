package vue;
import model.*;
import vue.actionListener.Listener;
import controller.*;

import java.awt.event.*;

import java.awt.Color;

import javax.swing.*;


public class Frame extends JFrame implements ModelListener{
	
	public static final long serialVersionUID = 0;
	
	public JPanel bluePanel, redPanel, yellowPanel, greenPanel, goalPanel ,background;
	public JPanel imageBlue,imageRed,imageYellow,imageGreen,imageBack;
	
	public JLabel currentSelectedRobot;
	public JLabel totalMoves;
	
	public ModelContent partie;
	
	int height = 800;
	int width = 600;
	
	public Frame(ModelContent partie)
	{
		this.partie = partie;
		
		this.addKeyListener(new Listener(this.partie, this));
		
		// Ajout du Listener pour lier les robots et le frame
		for(Robot i : this.partie.robots) {
			i.addModelListener(this);
		}
		
		this.currentSelectedRobot = new JLabel();
		
		this.bluePanel = new JPanel();
		this.redPanel = new JPanel();
		this.yellowPanel = new JPanel();
		this.greenPanel = new JPanel();
		this.goalPanel = new JPanel();
		this.background = new JPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(this.height, this.width);
	}
	
	@Override
	public void modelUpdated(Object source)
	{
		this.redPanel.setBounds(this.partie.robots[0].getCoordX()*35,this.partie.robots[0].getCoordY()*35,35,35);
		this.greenPanel.setBounds(this.partie.robots[1].getCoordX()*35,this.partie.robots[1].getCoordY()*35,35,35);
		this.yellowPanel.setBounds(this.partie.robots[2].getCoordX()*35,this.partie.robots[2].getCoordY()*35,35,35);
		this.bluePanel.setBounds(this.partie.robots[3].getCoordX()*35,this.partie.robots[3].getCoordY()*35,35,35);
		this.repaint();
	}

	public void affichage() {
		/*Creation */
		JLayeredPane layer = new JLayeredPane();
		/* creation des panels pour les robots et l'image de fond */

		
		/* Import des images */
		JLabel imageBlue = new JLabel( new ImageIcon( "././image/Robot/robot_bleu.png"));
		JLabel imageRed = new JLabel( new ImageIcon( "././image/Robot/robot_rouge.png"));
		JLabel imageYellow = new JLabel( new ImageIcon( "././image/Robot/robot_jaune.png"));
		JLabel imageGreen = new JLabel( new ImageIcon( "././image/Robot/robot_vert.png"));
		JLabel imageBack = new JLabel( new ImageIcon( "././image/plateau/plateau" + this.partie.level + ".jpeg"));
		JLabel imageGoal = new JLabel( new ImageIcon( "././image/food/" +this.partie.colorGoal + ".png"));
		 
		
		/* Position des images */
		this.redPanel.setBounds(this.partie.robots[0].getCoordX()*35,this.partie.robots[0].getCoordY()*35,35,35);
		this.greenPanel.setBounds(this.partie.robots[1].getCoordX()*35,this.partie.robots[1].getCoordY()*35,35,35);
		this.yellowPanel.setBounds(this.partie.robots[2].getCoordX()*35,this.partie.robots[2].getCoordY()*35,35,35);
		this.bluePanel.setBounds(this.partie.robots[3].getCoordX()*35,this.partie.robots[3].getCoordY()*35,35,35);
		this.goalPanel.setBounds(7*35,7*35 + 5,70,70);
		this.background.setBounds(0,0,560,560);
		
		/*Ajout des images dans les panels correspondants */
		this.background.add(imageBack);
		this.bluePanel.add(imageBlue);
		this.redPanel.add(imageRed);
		this.yellowPanel.add(imageYellow);
		this.greenPanel.add(imageGreen);
		this.goalPanel.add(imageGoal);
		
		/* Faire que les images n'aient pas de background */
		this.bluePanel.setBackground(new Color(0,0,0,0));
		this.redPanel.setBackground(new Color(0,0,0,0));
		this.yellowPanel.setBackground(new Color(0,0,0,0));
		this.greenPanel.setBackground(new Color(0,0,0,0));
		this.goalPanel.setBackground(new Color(0,0,0,0));
		
		/* Ajout de tous les panels dans le layer */
		layer.add(bluePanel);
		layer.add(redPanel);
		layer.add(yellowPanel);
		layer.add(greenPanel);
		layer.add(goalPanel);
		layer.add(background);
		
		this.setSize(height+200, width+200);
		this.add(layer);
		this.setVisible(true);
	}
	
	 public void informationSucceded()
	    {
	        String message = "Felicitations, vous avez mis "+ this.partie.timeElapsed+" secondes, et effectue "+ this.partie.totalMoves+ " deplacements. Au tour de l IA !";
	         JOptionPane.showMessageDialog(null, message,"GOAL",JOptionPane.INFORMATION_MESSAGE);
	    }
	 
	 public void informationFailed()
	    {
	        String message = "Vous avez pris trop de temps ! Au tour de l IA !";
	         JOptionPane.showMessageDialog(null, message,"GOAL",JOptionPane.INFORMATION_MESSAGE);
	    }
	 
	 public void iaWin()
	    {
	        String message = "L IA est bien trop forte, vous etes nazes";
	         JOptionPane.showMessageDialog(null, message,"GOAL",JOptionPane.INFORMATION_MESSAGE);
	    }
	 public void playerWin()
	    {
	        String message = "Felicitations, vous avez battu ou fait egalite avec l IA !";
	         JOptionPane.showMessageDialog(null, message,"GOAL",JOptionPane.INFORMATION_MESSAGE);
	    }
	
	
	
	
}
