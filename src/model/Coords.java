package model;

/**
 * <b>Coords permet de visualiser un x et un y sous forme de coordonnee.</b>
 * 
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */

public class Coords
{
	/**
     * 	<b>valeur de l abscisse x </b>
     */
	public int x;
	
	/**
     * 	<b>valeur de l ordonnee y </b>
     */
	public int y;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * @param x
     * 			abscisse de la coordonnee.
     * @param y
     * 			ordonnee de la coordonnee.
     */
	public Coords(int inputX, int inputY)
	{
		this.x = inputX;
		this.y = inputY;
	}
	
	/**
     * 	<b>Redefinition de la methode equals()</b>
     * <p>Deux Coords sont identiques si elles ont le meme abscisse et la meme ordonnee </p>
     *
     * @param o
     * 			Object.
     */
	@Override
	public boolean equals(Object o) {
	  if (o == null || !(o instanceof Coords) ) {
	    return false;
	  }else {
		  Coords other = (Coords)o;
		  if(this.x == other.x && this.y == other.y) {
			  return true;
		  }
	  }
	  return false;
	}
}
