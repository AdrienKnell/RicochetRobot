package model;

/**
 * <b>Case est la classe utlisee pour representer les cases du plateau</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */

public class Case {

	/**
     * 	<b> Entier permettant de connaitre la presence de mur grace a la methode 1248 </b>
     */
	public int caseType = 0;
	
	/**
     * 	<b> Booleen indiquant la presence d un robot </b>
     */
	public boolean hasRobot = false;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise le caseType de la case.</p>
     *
     * @param caseType
     * 			Entier indiquant la presence de murs.
     */
	public Case(int caseType)
	{
		this.caseType = caseType;
	}
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise le caseType de la case a 0.</p>
     *
     */
	public Case()
	{
		this(0);
	}
}

