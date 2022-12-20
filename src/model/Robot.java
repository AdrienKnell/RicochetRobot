package model;
import java.util.ArrayList;


/**
 * <b>Robot est la classe representant les objets de type Robot. Elle herite de {link@ model.AbstractListenableModel}</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */

public class Robot extends AbstractListenableModel{ 

	/**
     * 	<b>Abscisse de la position du robot sur le plateau. </b>
     */
    public int coordX; 
    
    /**
     * 	<b>Ordonnee de la position du robot sur le plateau.</b>
     */
    public int coordY; 
    
    /**
     * 	<b>Couleur du Robot </b>
     */
    public String color; 

    /**
     * 	<b>Constructeur de la classe  </b>
     *
     * @param coordX
     * 			abscisse de la position du robot.
     * @param coordY
     * 			ordonnee de la position du robot.
     * @param color
     * 			Couleur du robot.
     */
    public Robot(int coordX, int coordY, String color) { 
        this.coordX = coordX; 
        this.coordY = coordY; 
        this.color = color;
    }
    
    
    // 0 : haut 
    // 1 : bas
    // 2 : gauche
    // 3 : droite
    
    /**
	 * <b> Methode qui permet de deplacer le robot sur un plateau. </b>
	 * 
	 * @param grid
	 * 		Le plateau de la partie.
	 * @param sens
	 * 		Entier indiquant le sens de deplacement (0:haut ; 1:bas ; 2:gauche ; 3:droite)
	 */
    public void MoveRobot(Case[][] grid, int sens) {
        Case c = grid[this.coordY][this.coordX];
        c.hasRobot = false;
        ArrayList<Integer> direction = new ArrayList<Integer>();
        int[] dir = {0,0};
        switch(sens) {
	        case 0:
	            direction.add(1); 
	            direction.add(3);
	            direction.add(5);
	            direction.add(7);
	            direction.add(9);
	            direction.add(11);
	            direction.add(13);
	            direction.add(15);
	            dir[0] = -1;
	            break;
	         case 1:
	            direction.add(4); 
	            direction.add(5);
	            direction.add(6);
	            direction.add(12);
	            direction.add(7);
	            direction.add(13);
	            direction.add(14);
	            direction.add(15);
	            dir[0] = 1;
	            break;
	          case 2:
	            direction.add(8); 
	            direction.add(9);
	            direction.add(10);
	            direction.add(12);
	            direction.add(11);
	            direction.add(14);
	            direction.add(15);
	            direction.add(13);
	            dir[1] = -1;
	            break;
	          case 3:
	            direction.add(2); 
	            direction.add(3);
	            direction.add(6);
	            direction.add(10);
	            direction.add(7);
	            direction.add(14);
	            direction.add(11);
	            direction.add(15);
	            dir[1] = 1;
	            break;
	          default:
	            break;
	       }


          while(!(direction.contains(c.caseType)) && (0 <= (this.coordX + dir[1]) && (this.coordX + dir[1]) <= 15) && (0 <= (this.coordY + dir[0])) && ((this.coordY + dir[0]) <= 15) && !(grid[this.coordY + dir[0]][this.coordX + dir[1]].hasRobot)) {
              c = grid[this.coordY + dir[0]][this.coordX + dir[1]];
              this.coordX += dir[1];
              this.coordY += dir[0];
      }
          c.hasRobot = true;
          fireChange();
        }
    
    /**
	 * <b> Methode qui permet de modifier la position du robot. </b>
	 * 
	 * @param x
	 * 		Abscisse de la nouvelle position.
	 * @param y
	 * 		Ordonnee de la nouvelle position.
	 */
    public void placementRobot(int x, int y) {
    	this.coordX = x;
    	this.coordY = y;
    	fireChange();
    }

    /**
	 * <b> Accesseur de l abscisse du robot. </b>
	 * 
	 * @return Entier representant l abscisse.
	 */
    public int getCoordX() {
        return this.coordX;
    }
    
    /**
	 * <b> Accesseur de l ordonnee du robot. </b>
	 * 
	 * @return Entier representant l ordonnee.
	 */
    public int getCoordY() {
        return this.coordY;
    }
    
    /**
	 * <b> Accesseur de la couleur du robot. </b>
	 * 
	 * @return String representant la couleur du robot.
	 */
    public String getColor() {
        return this.color;
    }
    
    /**
	 * <b> Redefinition de la methode equals </b>
	 *
	 *<p> Deux instances de Robot sont equals si elles ont la meme position. (la couleur n est pas importante)</p>
	 *
	 * @param o
	 * 		Object.
	 * 
	 * @return Booleen.
	 */
    @Override
    public boolean equals(Object o){
		  if (  o == null || !(o instanceof Robot) ) {
		    return false;
		}else {
			Robot other = (Robot)o;
			if(this.coordX == other.coordX && this.coordY == other.coordY) {
				return true;
			}
			return false;
		}
		  
}
}
