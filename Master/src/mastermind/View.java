package mastermind;

import java.util.List;

/**
 * 
 */

/**
 * @author frank
 *
 */
public interface View {

	List<Integer> zugManuell(int felder);
	void allesDarstellen(List<Spiel> s);
	void displayGewonnen();
	void ergebnisDarstellen(List<Integer> neuerZug, List<Integer> zugManuell);
	
	
	
	
	//hier die View Methoden: neuerTipp(); neuesSpiel(parameter);

}
