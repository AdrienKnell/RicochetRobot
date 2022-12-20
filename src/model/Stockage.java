package model;

import java.util.*;

/**
 * <b>Stockage est la classe qui stock la configuration des 3 levels</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */

public class Stockage {

	/**
     * 	<b> Tableau d entier qui stock la valeur de chaque case (selon la methode 1248) du plateau 1</b>
     */
	public int[][] level1 = {
			{0,0,4,0,2,8,0,0,0,2,8,0,0,4,0,0},
	        {0,2,9,0,0,0,0,0,0,0,0,0,0,3,8,0},
	        {0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0},
	        {0,0,0,0,0,2,12,0,2,9,0,0,0,0,0,0},
	        {4,0,0,0,4,0,1,0,0,0,0,0,0,0,0,4},
	        {1,0,0,0,3,8,0,0,0,0,0,0,0,0,0,1},
	        {0,6,8,0,0,0,0,4,4,0,6,8,0,2,12,0},
	        {0,1,0,0,0,0,2,99,99,8,1,0,4,0,1,0},
	        {0,0,4,0,2,12,2,99,99,8,0,2,9,0,0,0},
	        {0,2,9,0,0,1,0,1,1,2,12,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,4},
	        {4,0,0,0,0,0,0,0,0,6,8,0,0,0,4,1},
	        {1,0,0,0,4,0,0,0,0,1,0,0,0,0,3,8},
	        {0,0,0,0,3,8,0,0,0,0,0,0,0,4,0,0},
	        {0,6,8,0,0,0,0,0,0,0,0,0,2,9,0,0},
	        {0,1,0,0,0,2,8,0,0,0,2,8,0,0,0,0}
			};
	
	
	
	/**
     * 	<b> Tableau d entier qui stock la valeur de chaque case (selon la methode 1248) du plateau 2</b>
     */
	public int[][] level2 = {
            {0,0,2,8,0,0,0,0,0,2,8,0,4,0,0,0},
            {0,0,0,0,2,12,0,0,0,0,0,2,9,0,0,4},
            {0,0,0,0,0,1,0,6,8,0,0,0,0,0,0,1},
            {4,0,0,0,0,0,0,1,0,12,0,0,0,0,0,0},
            {1,0,0,6,8,0,4,0,0,1,4,0,0,0,6,8},
            {0,4,0,1,0,2,9,0,0,0,3,8,0,0,1,0},
            {0,3,8,0,0,0,0,4,4,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,2,99,99,8,0,0,0,0,0,0},
            {0,0,0,4,0,0,2,99,99,8,2,12,0,0,0,4},
            {0,0,0,3,8,0,0,1,1,0,0,1,0,0,4,1},
            {0,0,0,0,0,0,4,0,0,0,0,0,0,0,3,8},
            {0,0,0,0,0,2,9,0,0,0,0,0,0,0,0,0},
            {2,12,0,0,0,0,0,0,0,0,4,0,0,0,0,0},
            {4,1,0,0,0,0,0,0,0,6,9,0,0,0,0,0},
            {1,0,0,0,6,8,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,1,0,2,8,0,0,0,0,2,8,0,0}
    };
	
	/**
     * 	<b> Tableau d entier qui stock la valeur de chaque case (selon la methode 1248) du plateau 3</b>
     */
	public int[][] level3 = {
            {0,0,0,0,0,2,8,0,2,8,4,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,2,9,0,0,0,0,0},
            {0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
            {2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,6,8,6,8,0,0,0,0,0,0},
            {4,0,4,0,0,0,1,0,1,0,0,0,2,12,0,0},
            {1,0,3,12,0,0,0,4,4,0,0,0,0,3,8,0},
            {0,0,4,1,0,0,2,99,99,8,0,0,0,0,0,0},
            {0,0,3,8,0,0,2,99,99,8,0,0,4,0,0,0},
            {0,0,0,0,2,12,0,1,1,0,0,2,9,0,0,4},
            {0,6,8,0,0,1,0,0,0,0,6,8,0,0,0,1},
            {4,1,0,0,4,0,0,0,0,0,1,0,0,0,4,0},
            {1,0,0,0,3,8,0,0,0,0,0,0,0,0,3,8},
            {0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,2,9,0,0,0,2,12,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0}
	};
	
	/**
     * 	<b> Hasmap de String,Coords stockant le nom des cases contenant un objectif et leur position, du niveau 1</b>
     */
	public Map<String,Coords> level1Goals = new HashMap<String,Coords>();
	
	/**
     * 	<b> Hasmap de String,Coords stockant le nom des cases contenant un objectif et leur position, du niveau 2</b>
     */
	public Map<String,Coords> level2Goals = new HashMap<String,Coords>();
	
	/**
     * 	<b> Hasmap de String,Coords stockant le nom des cases contenant un objectif et leur position, du niveau 3</b>
     */
	public Map<String,Coords> level3Goals = new HashMap<String,Coords>();
	
	/**
     * 	<b> ArrayList de tableau de Int permettant de stocker les 3 niveaux</b>
     */
	public ArrayList<int[][]> levelStorage;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise et rempli les Hashmaps et l ArrayList.</p>
     *
     */
	public Stockage()
	{
		this.levelStorage = new ArrayList<int[][]>();
		this.levelStorage.add(this.level1);
		this.levelStorage.add(this.level2);
		this.levelStorage.add(this.level3);
		
		this.level1Goals.put("BlueDonut",  new Coords(10,9));
        this.level1Goals.put("BlueDrink",  new Coords(10,6));
        this.level1Goals.put("BlueChick",  new Coords(4,13));
        this.level1Goals.put("BlueSand", new Coords(6,3) );
        this.level1Goals.put("GreenDonut", new Coords(13,1) );
        this.level1Goals.put("GreenDrink", new Coords(2,9) );
        this.level1Goals.put("GreenChick", new Coords(14,12) );
        this.level1Goals.put("GreenSand",  new Coords(1,6));
        this.level1Goals.put("RedDonut", new Coords(13,14) );
        this.level1Goals.put("RedDrink", new Coords(1,14) );
        this.level1Goals.put("RedChick", new Coords(9,3) );
        this.level1Goals.put("RedSand", new Coords(4,5) );
        this.level1Goals.put("YellowDonut", new Coords(14,6) );
        this.level1Goals.put("YellowDrink", new Coords(9,11) );
        this.level1Goals.put("YellowChick", new Coords(2,1) );
        this.level1Goals.put("YellowSand", new Coords(5,8) );
        
        this.level2Goals.put("BlueDonut",  new Coords(9,3));
        this.level2Goals.put("BlueDrink",  new Coords(6,11));
        this.level2Goals.put("BlueChick",  new Coords(11,8));
        this.level2Goals.put("BlueSand", new Coords(5,1));
        this.level2Goals.put("GreenDonut", new Coords(1,12));
        this.level2Goals.put("GreenDrink", new Coords(6,5));
        this.level2Goals.put("GreenChick", new Coords(10,13));
        this.level2Goals.put("GreenSand",  new Coords(14,4));
        this.level2Goals.put("RedDonut", new Coords(4,14));
        this.level2Goals.put("RedDrink", new Coords(3,4));
        this.level2Goals.put("RedChick", new Coords(12,1));
        this.level2Goals.put("RedSand", new Coords(14,10));
        this.level2Goals.put("YellowDonut", new Coords(1,6));
        this.level2Goals.put("YellowDrink", new Coords(9,13));
        this.level2Goals.put("YellowChick", new Coords(3,9));
        this.level2Goals.put("YellowSand", new Coords(10,5));
        
        this.level3Goals.put("BlueDonut",  new Coords(1,10));
        this.level3Goals.put("BlueDrink",  new Coords(8,4));
        this.level3Goals.put("BlueChick",  new Coords(12,9));
        this.level3Goals.put("BlueSand", new Coords(3,6));
        this.level3Goals.put("GreenDonut", new Coords(13,5));
        this.level3Goals.put("GreenDrink", new Coords(11,14));
        this.level3Goals.put("GreenChick", new Coords(2,6));
        this.level3Goals.put("GreenSand",  new Coords(5,9));
        this.level3Goals.put("RedDonut", new Coords(1,3));
        this.level3Goals.put("RedDrink", new Coords(4,12));
        this.level3Goals.put("RedChick", new Coords(10,1));
        this.level3Goals.put("RedSand", new Coords(14,12));
        this.level3Goals.put("YellowDonut", new Coords(10,10));
        this.level3Goals.put("YellowDrink", new Coords(6,4));
        this.level3Goals.put("YellowChick", new Coords(13,6));
        this.level3Goals.put("YellowSand", new Coords(6,14));
	}
}
