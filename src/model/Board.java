package model;

/**
 * <b>Board est la classe qui represente le plateau du jeu.</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */

public class Board {

	/**
     * 	<b> Constante qui represente le taille de bordure du plateau. </b>
     */
	private static final int BOARDSIZE = 16;
	
	/**
     * 	<b> Tableau de {link@ model.Case} qui represente le plateau. </b>
     */
	public Case[][] grid;
	
	/**
     * 	<b> Tableau d entier qui stock les donnees du niveau selectionne </b>
     */
	public int[][] selectedLevel;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     *<p>Initialise le grid en un tableau de Case 16 par 16. </p>
     */
	public Board()
	{
		this.grid = new Case[BOARDSIZE][BOARDSIZE]; 
	}
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     *<p>Initialise le grid en fonction du niveau choisi </p>
     *
     *@param selectedLevel
     *		Tableau d'entier qui stock les donnees du niveau.
     */
	public Board(int[][] selectedLevel)
	{
		this.selectedLevel = selectedLevel;
		
		//Init the grid.
		this.grid = new Case[BOARDSIZE][BOARDSIZE];
		//For every square in the grid, copy the cases from the storage to the grid.
		for (int y = 0; y < BOARDSIZE; y++)
		{
			for (int x= 0; x < BOARDSIZE; x++)
			{
				this.grid[y][x] = new Case(selectedLevel[y][x]);
				
			}
		}
		
	}
	
	/**
	 * <b> Methode qui permet de retourner une copie de l instance. </b>
	 *
	 *<p> Pour la copie, on fait une copie profonde des cases du grid.</p>
	 *
	 * 
	 * @return instance de Board.
	 */
	public Board copy() {
		Board copyGame = new Board();
		for(int i = 0 ; i < BOARDSIZE ; i++) {
			for(int j = 0 ; j < BOARDSIZE ; j++) {
				copyGame.grid[i][j] = new Case(this.grid[i][j].caseType);
				copyGame.grid[i][j].hasRobot = this.grid[i][j].hasRobot;
			}
		}
		return copyGame;
	}
	
	
}


