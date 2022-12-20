package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.GameController;
import model.Board;
import model.Coords;
import model.ModelContent;
import model.Stockage;

@SuppressWarnings("serial")
public class Menu extends JFrame{

	
	public Frame fenetre;
	public int level = 0;
	public boolean visible;
	public ModelContent GameManager;

	
	public Menu() {
		this.setSize(900,500);
		this.afficheMenu();
		this.setVisible(true);
		
	}
	
	public void afficheMenu() {
		/*
Stockage stockLevel = new Stockage();
		
		Map<String,Coords> levels;
		switch(nbrLevel) {
		case 1:
			levels = stockLevel.level1Goals;
			break;
		case 2:
			levels = stockLevel.level2Goals;
			break;
		case 3:
			levels = stockLevel.level3Goals;
			break;
		default :
			levels = stockLevel.level1Goals;
		}
		
		
		this.gameBoard = new Board(stockLevel.levelStorage.get(nbrLevel-1));
		this.GameManager = new ModelContent(this.gameBoard, levels, nbrLevel);
		
		this.GameManager.initialiseRobots();
		this.GameManager.prepareGoals();				
		this.fenetre = new Frame(this.GameManager);
		
	*/	
		
		
		
		Icon icon = new ImageIcon("././image/bouton/bouton1.jpg");
		Icon icon2 = new ImageIcon("././image/bouton/bouton2.jpg");
		Icon icon3 = new ImageIcon("././image/bouton/bouton3.jpg");
		Icon icon4 = new ImageIcon("././image/bouton/rules.jpg");
		JButton level1 = new JButton(icon);
		level1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             System.out.println("Ok Button is clicked here");
	             close();
	             changelevel(1);
	             loadLevels();
	          }
	       });
		JButton level2 = new JButton(icon2);
		level2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 close();
				 changelevel(2);
				 loadLevels();
			}
        	});
		JButton level3 = new JButton(icon3);
		level3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 close();
				 changelevel(3);
				 loadLevels();
			}
        	});
		
		
		
		
		JButton rules = new JButton(icon4);
		GridLayout layout = new GridLayout(4,0);
		level1.setBounds(200, 50, 200, 60);
		level2.setBounds(200, 150, 200, 60);
		level3.setBounds(200, 250, 200, 60);
		rules.setBounds(200, 350,  200, 60);
		this.setLayout(null);
		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.add(rules);
		
	}
	
	public void loadLevels() {
		Stockage stockLevel = new Stockage();
		
		Map<String,Coords> levels;
		switch(this.level) {
		case 1:
			levels = stockLevel.level1Goals;
			break;
		case 2:
			levels = stockLevel.level2Goals;
			break;
		case 3:
			levels = stockLevel.level3Goals;
			break;
		default :
			levels = stockLevel.level1Goals;
		}
		Board gameBoard = new Board(stockLevel.levelStorage.get(this.level-1));
		this.GameManager = new ModelContent(gameBoard, levels, this.level);
		
		this.GameManager.initialiseRobots();
		this.GameManager.prepareGoals();	
		this.GameManager.selectedRobot = GameManager.robots[0];
		this.fenetre = new Frame(this.GameManager);
		this.fenetre.affichage();
	}
	
	public void changelevel(int level) {
		this.level = level;
	}
	
	public void close() {
		this.dispose();
		
	}

}
