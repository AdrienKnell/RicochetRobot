
package model.IA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.*;

public class A_star {
    
public ArrayList<Node> openList = new ArrayList<Node>();
public ArrayList<Node> closeList = new ArrayList<Node>(); 
public Map<Node, Integer> map = new HashMap<>();
public String[] listString = {"Blue", "Red","Green","Yellow"}; 
    
public ArrayList<Node> fonc(String robot, ModelContent dep1, Coords end){
	
	System.out.println(robot);
	Node dep = new Node();
	
	dep.robotBlueX = dep1.robots[3].coordX;
	dep.robotBlueY = dep1.robots[3].coordY;
	dep.robotRedX = dep1.robots[0].coordX;
	dep.robotRedY = dep1.robots[0].coordY;
	dep.robotGreenX = dep1.robots[1].coordX;
	dep.robotGreenY = dep1.robots[1].coordY;
	dep.robotYellowX = dep1.robots[2].coordX;
	dep.robotYellowY = dep1.robots[2].coordY;
	
	switch(robot.charAt(0)) {
	case 'R' :
		dep.goalRobotX = dep.robotRedX;
		dep.goalRobotY = dep.robotRedY;
		break;
	case 'B' :
		dep.goalRobotX = dep.robotBlueX;
		dep.goalRobotY = dep.robotBlueY;
		break;
	case 'G' :
		dep.goalRobotX = dep.robotGreenX;
		dep.goalRobotY = dep.robotGreenY;
		break;
	case 'Y' :
		dep.goalRobotX = dep.robotYellowX;
		dep.goalRobotY = dep.robotYellowY;
		break;
	default : 
		dep.goalRobotX = dep.robotBlueX;
		dep.goalRobotY = dep.robotBlueY;
	}
	
    this.openList.add(dep);
    
    this.map.put(dep, 0);
    
    while(this.openList.size() > 0){
    	
        int index = 0;
        int indexfinal = 0;
        Node currentSituation = this.openList.get(0);
        //System.out.println(currentSituation.goalRobot);
        
        for(Node i : this.openList){
            if(i.somme < currentSituation.somme){
            	currentSituation = i;
                indexfinal = index;
            }
            index += 1;
        }
        this.openList.remove(indexfinal);
        this.closeList.add(currentSituation);  
        
        
        if((currentSituation.goalRobotX == end.x) && (currentSituation.goalRobotY == end.y)){
            ArrayList<Node> finalList = new ArrayList<Node>();
            Node valeur = currentSituation;
            while(valeur.parent != null){
                finalList.add(valeur);
                valeur = valeur.parent;
            }
            ArrayList<Node> finalList2 = new ArrayList<Node>();
            for(int i=0;i < finalList.size() ; i++){
                finalList2.add(finalList.get(finalList.size() - 1 - i));
            }
            return finalList2;
        }
        
       ArrayList<Node> possibilityList = new ArrayList<Node>();
        
       Node tmp;
       for(int color=0; color<4 ; color++) {
	       for(int i = 0; i<4 ; i++) {
	    	   tmp = this.possibilitySitu(listString[color], currentSituation, i, dep1);
	    	   if(listString[color].charAt(0) == robot.charAt(0)) {
	    		   switch(listString[color]) {
	    		   	case "Red":
	    		   		tmp.goalRobotX = tmp.robotRedX;
	    		   		tmp.goalRobotY = tmp.robotRedY;
	    		   		break;
	    		   	case "Blue":
	    		   		tmp.goalRobotX = tmp.robotBlueX;
	    		   		tmp.goalRobotY= tmp.robotBlueY;
	    		   		break;
	    		   	case "Green":
	    		   		tmp.goalRobotX = tmp.robotGreenX;
	    		   		tmp.goalRobotY = tmp.robotGreenY;
	    		   		break;
	    		   	case "Yellow":
	    		   		tmp.goalRobotX = tmp.robotYellowX;
	    		   		tmp.goalRobotY = tmp.robotYellowY;
	    		   		break;
	    		   }
	    	   }
	    	   
	    	   if(!(this.map.containsKey(tmp))){
	    		   
	    			this.map.put(tmp, currentSituation.depth + 1);
	    			possibilityList.add(tmp);
	    		}else {
	    			
	    			if(this.map.get(tmp) > currentSituation.depth + 1) {
	    				
	    				this.map.replace(tmp,currentSituation.depth + 1);
	    				possibilityList.add(tmp);
	    			}
	    		}
	       }
	   }
       //copyBoard.goalRobot = Integer.toHexString(dep1.robotRed.coordX) + Integer.toHexString(dep1.robotRed.coordY);
       
       
       
        for(Node i : possibilityList){
            int testcontinue = 0;
            int testcontinue2 = 0;
            for(Node j : this.closeList){
                if(j.equals(i)){
                    testcontinue = 1;
                }
            }
            if(testcontinue == 1){
                continue;
            }
            
            i.heuristique = Math.abs(i.goalRobotX - end.x) + Math.abs(i.goalRobotY - end.y);
            i.cost = currentSituation.cost + 10;
            i.depth = currentSituation.depth + 1;
            i.somme = i.heuristique + i.cost;
            
            
            for(Node j : this.openList){
                if((j.equals(i)) && (i.cost >= j.cost)){
                    testcontinue2 = 1;
                }
            }
            if(testcontinue2 == 1){
                continue;
            }
            this.openList.add(i);
            }
      }
    return null;
        
    }

public Node possibilitySitu(String color, Node currentSituation, int direction, ModelContent dep1) {
	Node copyBoard = currentSituation.copy();
	copyBoard.parent = currentSituation;
	
	dep1.gameBoard.grid[dep1.robots[3].coordY][dep1.robots[3].coordX].hasRobot = false;
	dep1.gameBoard.grid[dep1.robots[1].coordY][dep1.robots[1].coordX].hasRobot = false;
	dep1.gameBoard.grid[dep1.robots[2].coordY][dep1.robots[2].coordX].hasRobot = false;
	dep1.gameBoard.grid[dep1.robots[0].coordY][dep1.robots[0].coordX].hasRobot = false;
	
	dep1.robots[3].coordX = copyBoard.robotBlueX;
	dep1.robots[3].coordY = copyBoard.robotBlueY;
	dep1.robots[0].coordX = copyBoard.robotRedX;
	dep1.robots[0].coordY = copyBoard.robotRedY;
	dep1.robots[1].coordX = copyBoard.robotGreenX;
	dep1.robots[1].coordY = copyBoard.robotGreenY;
	dep1.robots[2].coordX = copyBoard.robotYellowX;
	dep1.robots[2].coordY = copyBoard.robotYellowY;
	
	dep1.gameBoard.grid[dep1.robots[3].coordY][dep1.robots[3].coordX].hasRobot = true;
	dep1.gameBoard.grid[dep1.robots[1].coordY][dep1.robots[1].coordX].hasRobot = true;
	dep1.gameBoard.grid[dep1.robots[2].coordY][dep1.robots[2].coordX].hasRobot = true;
	dep1.gameBoard.grid[dep1.robots[0].coordY][dep1.robots[0].coordX].hasRobot = true;
	
	switch(color) {
		case "Red":
			dep1.robots[0].MoveRobot(dep1.gameBoard.grid, direction);
			copyBoard.robotRedX = dep1.robots[0].coordX;
			copyBoard.robotRedY = dep1.robots[0].coordY;
			break;
		case "Green":
			dep1.robots[1].MoveRobot(dep1.gameBoard.grid, direction);
			copyBoard.robotGreenX = dep1.robots[1].coordX;
			copyBoard.robotGreenY = dep1.robots[1].coordY;
			break;
		case "Yellow":
			dep1.robots[2].MoveRobot(dep1.gameBoard.grid, direction);
			copyBoard.robotYellowX = dep1.robots[2].coordX;
			copyBoard.robotYellowY = dep1.robots[2].coordY;
			break;
		case "Blue":
			dep1.robots[3].MoveRobot(dep1.gameBoard.grid, direction);
			copyBoard.robotBlueX = dep1.robots[3].coordX;
			copyBoard.robotBlueY = dep1.robots[3].coordY;
			break;
		default :
			dep1.robots[0].MoveRobot(dep1.gameBoard.grid, direction);
			copyBoard.robotRedX = dep1.robots[0].coordX;
			copyBoard.robotRedY = dep1.robots[0].coordY;
			break;
	}
	
	return copyBoard;
	
}

}