package model;

import java.util.*;
import java.util.stream.Collectors;


import vue.*;


public class ModelContent
{
	public ModelContent copyMySelf;
	public Robot[] robots; // Ordre : RGYB
	public Robot goalRobot;
	public Robot selectedRobot;
	public Coords goalCoord;
	public Board gameBoard;
	public String colorGoal;
	public Map<String,Coords> levelGoals;
	public int level;
	
	public int totalMoves = 0;
	
	public boolean over = false;
	public long startTime;
	public long endTime;
	public float timeElapsed;
	public Random random = new Random();
	private static final int BOARDSIZE = 16;
	
	public ModelContent(Board gameBoard, Map<String,Coords> levelGoals, int level)
	{
		this.level = level;
		this.gameBoard = gameBoard;
		this.levelGoals = levelGoals;
		this.robots = new Robot[4];
		this.startTime = System.currentTimeMillis();
	}
	
	public ModelContent copy() {
		Board copyBoard = this.gameBoard.copy();
		
		ModelContent copyGame = new ModelContent(copyBoard, this.levelGoals, this.level);
		
		copyGame.robots[0] = new Robot(this.robots[0].coordX,this.robots[0].coordY,"Red");
		copyGame.robots[1] = new Robot(this.robots[1].coordX,this.robots[1].coordY,"Green");
		copyGame.robots[2] = new Robot(this.robots[2].coordX,this.robots[2].coordY,"Yellow");
		copyGame.robots[3] = new Robot(this.robots[3].coordX,this.robots[3].coordY,"Blue");
		
		copyGame.goalCoord = this.goalCoord;
		copyGame.colorGoal = this.colorGoal;
		
		return copyGame;
	}
	
	public HashMap<String,Coords> prepareGoals()
	{
		String[] goals = {"BlueDrink","RedDrink","YellowDrink", "GreenDrink","BlueChick","RedChick","YellowChick", "GreenChick","BlueSand","RedSand","YellowSand", "GreenSand","BlueDonut","RedDonut","YellowDonut", "GreenDonut"};
		
		int a = random.nextInt(goals.length);
		
		HashMap<String,Coords> goalRandom = new HashMap<String,Coords>();
		goalRandom.put(goals[a], levelGoals.get(goals[a]));
		this.colorGoal = goals[a]; 
		this.goalCoord = levelGoals.get(goals[a]);
		switch(goals[a].charAt(0)) {
			case 'B':
				this.goalRobot = this.robots[3];
				break;
			case 'R':
				this.goalRobot = this.robots[0];
				break;
			case 'G':
				this.goalRobot = this.robots[1];
				break;
			case 'Y':
				this.goalRobot = this.robots[2];
				break;
			default :
				this.goalRobot = this.robots[2];
				break;
		}
		
		this.copyMySelf = this.copy();
		return goalRandom;
	}
	
	public void initialiseRobots()
	{
		int k = -1;
		String[] robotColors = {"Red","Green","Yellow","Blue"};
		for(String i : robotColors) {
			k++;
			while(true) {
				int x = random.nextInt(BOARDSIZE);
				int y = random.nextInt(BOARDSIZE);
				if(! this.gameBoard.grid[y][x].hasRobot && this.gameBoard.selectedLevel[y][x]!=99 && !this.levelGoals.containsValue(new Coords(x,y))) {
					this.gameBoard.grid[y][x].hasRobot = true;
					this.robots[k] = new Robot(x,y,i);
					break;
				}
			}
		}
		/*
		this.gameBoard.robotRed = this.robots[0];
		this.gameBoard.robotGreen = this.robots[1];
		this.gameBoard.robotYellow = this.robots[2];
		this.gameBoard.robotBlue = this.robots[3];*/
	}
	
	public void isOver()
	{
		if(this.goalRobot.coordX == this.goalCoord.x && this.goalRobot.coordY == this.goalCoord.y) {
			this.over = true;
		}
		else {
			this.over = false;
		}
	}
	
	
}
