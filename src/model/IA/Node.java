
package model.IA;
import java.util.Objects;

import model.*;
/**
 *
 * @author adrie
 */

public class Node {
    
    public Node parent = null;
    public int cost = 0;
    public int heuristique = 0;
    public int somme = 0;
    public int robotBlueX; 
    public int robotBlueY; 
    public int robotRedX; 
    public int robotRedY; 
    public int robotGreenX; 
    public int robotGreenY;
    public int robotYellowX; 
    public int robotYellowY;
    public int goalRobotX;
    public int goalRobotY;
    public int depth = 0;
    
    /*public Node(int goalRobot, int otherRobot1, int otherRobot2, int otherRobot3){
        this.goalRobot = goalRobot;
        this.otherRobot1 = otherRobot1;
        this.otherRobot2 = otherRobot2;
        this.otherRobot3 = otherRobot3;
    }*/
    
    public Node copy() {
		Node copyGame = new Node();
		copyGame.robotBlueX = this.robotBlueX;
		copyGame.robotRedX = this.robotRedX;
		copyGame.robotGreenX = this.robotGreenX;
		copyGame.robotYellowX = this.robotYellowX;
		copyGame.goalRobotX = this.goalRobotX;
		copyGame.robotBlueY = this.robotBlueY;
		copyGame.robotRedY = this.robotRedY;
		copyGame.robotGreenY = this.robotGreenY;
		copyGame.robotYellowY = this.robotYellowY;
		copyGame.goalRobotY = this.goalRobotY;
		return copyGame;
	}
    
    
    @Override    
	public int hashCode(){
	  return Objects.hash(this.robotBlueX, this.robotGreenX, this.robotRedX, this.robotYellowX, this.robotBlueY, this.robotGreenY, this.robotRedY, this.robotYellowY);
	}
    
    public boolean equals(Object o){
    	 if (o == null || !(o instanceof Node) ) {
    		    return false;
    		}else {
    			Node other = (Node)o;
    			if(((this.goalRobotX==other.goalRobotX) && (this.goalRobotY==other.goalRobotY))
    					&& (((this.robotBlueX==other.robotBlueX)&&(this.robotBlueY==other.robotBlueY)) || ((this.robotBlueX==other.robotRedX)&&(this.robotBlueY==other.robotRedY)) || ((this.robotBlueX==other.robotYellowX)&&(this.robotBlueY==other.robotYellowY)) || ((this.robotBlueX==other.robotGreenX)&&(this.robotBlueY==other.robotGreenY)))
    					&& (((this.robotRedX==other.robotBlueX)&&(this.robotRedY==other.robotBlueY)) || ((this.robotRedX==other.robotRedX)&&(this.robotRedY==other.robotRedY)) || ((this.robotRedX==other.robotYellowX)&&(this.robotRedY==other.robotYellowY)) || ((this.robotRedX==other.robotGreenX)&&(this.robotRedY==other.robotGreenY)))
    					&& (((this.robotGreenX==other.robotBlueX)&&(this.robotGreenY==other.robotBlueY)) || ((this.robotGreenX==other.robotRedX)&&(this.robotGreenY==other.robotRedY)) || ((this.robotGreenX==other.robotYellowX)&&(this.robotGreenY==other.robotYellowY)) || ((this.robotGreenX==other.robotGreenX)&&(this.robotGreenY==other.robotGreenY)))
    					&& (((this.robotYellowX==other.robotBlueX)&&(this.robotYellowY==other.robotBlueY)) || ((this.robotYellowX==other.robotRedX)&&(this.robotYellowY==other.robotRedY)) || ((this.robotYellowX==other.robotYellowX)&&(this.robotYellowY==other.robotYellowY)) || ((this.robotYellowX==other.robotGreenX)&&(this.robotYellowY==other.robotGreenY)))){
    				return true;
    			}
    	 return false;
    }
}
    
}
