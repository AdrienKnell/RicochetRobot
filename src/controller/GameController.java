package controller;

import java.util.*;

import model.*;
import model.IA.A_star;
import model.IA.Node;
import vue.*;

public class GameController
{	
	public static void mainLoop(ModelContent gameManager, Frame fenetre)
	{	
		System.out.println("Deplacer le robot " + gameManager.goalRobot.color + " a la case (" + gameManager.goalCoord.x + "," + gameManager.goalCoord.y + ")");
		gameManager.selectedRobot = gameManager.robots[0];
		fenetre.affichage();
}
	
	public static void IA(ModelContent gameManager, Frame fenetre) {
		A_star b = new A_star();
		ModelContent copy = gameManager.copyMySelf.copy();
		ArrayList<Node> solutionListe =  b.fonc(copy.colorGoal, copy, copy.goalCoord);
		System.out.println("FINISHSHSHSHSHS");
		try {
			   Thread.sleep(5000) ;
			}  catch (InterruptedException e) {
			    // gestion de l'erreur
			}

		for(Node i : solutionListe) {
			
			gameManager.robots[0].placementRobot(i.robotRedX, i.robotRedY);
			gameManager.robots[1].placementRobot(i.robotGreenX, i.robotGreenY);
			gameManager.robots[2].placementRobot(i.robotYellowX, i.robotYellowY);
			gameManager.robots[3].placementRobot(i.robotBlueX, i.robotBlueY);
			
			fenetre.repaint();
			
			try {
				   Thread.sleep(1000) ;
				}  catch (InterruptedException e) {
				    // gestion de l'erreur
				}

		}
		
		System.out.println(solutionListe.size());
		System.out.println(gameManager.totalMoves);
		
		if(solutionListe.size() >= gameManager.totalMoves) {
			fenetre.playerWin();
		}else {
			fenetre.iaWin();
		}
	}
	
	public static void gameEndedWin(ModelContent gameManager, Frame fenetre) {
		gameManager.endTime = System.currentTimeMillis();
		gameManager.timeElapsed = (gameManager.endTime - gameManager.startTime);
		gameManager.timeElapsed = gameManager.timeElapsed / 1000;
		fenetre.informationSucceded();
		
		IA(gameManager, fenetre);
	}
	
	public static void gameEndedLost(ModelContent gameManager, Frame fenetre) {
		System.out.println("You took too much time.");
		gameManager.totalMoves = 99;
		fenetre.informationFailed();
		IA(gameManager, fenetre);
		
	}
	
	public static void moveRobot(ModelContent gameManager, Frame fenetre, int moveNum)
	{
		gameManager.selectedRobot.MoveRobot(gameManager.gameBoard.grid, moveNum);
		gameManager.isOver();
		long endtime = System.currentTimeMillis();
		if((endtime - gameManager.startTime)/1000 > 1) {
			gameManager.over = true;
			gameEndedLost(gameManager, fenetre);
		}
		else if(gameManager.over) {
			gameEndedWin(gameManager, fenetre);
		}
	}
	
	public static void increaseMoveCounter(ModelContent gameManager)
	{
		gameManager.totalMoves++;
	}

	public static void switchSelectedRobot(ModelContent gameManager, int selectedRobot)
	{
		gameManager.selectedRobot = gameManager.robots[selectedRobot];
	}
	
	public static void reset(ModelContent gameManager) {
		gameManager.gameBoard.grid[gameManager.robots[0].coordY][gameManager.robots[0].coordX].hasRobot = false;
		gameManager.gameBoard.grid[gameManager.robots[1].coordY][gameManager.robots[1].coordX].hasRobot = false;
		gameManager.gameBoard.grid[gameManager.robots[2].coordY][gameManager.robots[2].coordX].hasRobot = false;
		gameManager.gameBoard.grid[gameManager.robots[3].coordY][gameManager.robots[3].coordX].hasRobot = false;
		
		gameManager.robots[0].placementRobot(gameManager.copyMySelf.robots[0].coordX, gameManager.copyMySelf.robots[0].coordY);
		gameManager.robots[1].placementRobot(gameManager.copyMySelf.robots[1].coordX, gameManager.copyMySelf.robots[1].coordY);
		gameManager.robots[2].placementRobot(gameManager.copyMySelf.robots[2].coordX, gameManager.copyMySelf.robots[2].coordY);
		gameManager.robots[3].placementRobot(gameManager.copyMySelf.robots[3].coordX, gameManager.copyMySelf.robots[3].coordY);
		
		gameManager.gameBoard.grid[gameManager.copyMySelf.robots[0].coordY][gameManager.copyMySelf.robots[0].coordX].hasRobot = true;
		gameManager.gameBoard.grid[gameManager.copyMySelf.robots[1].coordY][gameManager.copyMySelf.robots[1].coordX].hasRobot = true;
		gameManager.gameBoard.grid[gameManager.copyMySelf.robots[2].coordY][gameManager.copyMySelf.robots[2].coordX].hasRobot = true;
		gameManager.gameBoard.grid[gameManager.copyMySelf.robots[3].coordY][gameManager.copyMySelf.robots[3].coordX].hasRobot = true;
		
		gameManager.totalMoves = 0;
	}
	
}
