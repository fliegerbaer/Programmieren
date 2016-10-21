package klasse;

import java.util.List;

import inter.View;

public class SpielController {
	
	/*Controller verknüpft View mit Spiel (Modell) 
	 * Sinn: 
	* Spiel (Modell) wird vom View getrennt!! 
	* Separierung der Zuständigkeiten.
	*/
	public SpielController(Spiel spiel, View konsolenView) {
		this.spiel=spiel;
		view=konsolenView;
		// TODO Auto-generated constructor stub
	}
	private Spiel spiel;
	private View view;
	
	//Zahlen vom View an Spiel übergeben
	
	//Ergebnis wieder an View übergeben
	
	/**
	 * hier wird dem view mitgeteilt, ein neuen Zug auszuführen
	 * @return
	 */
	public boolean neuerZug() {
		// TODO Auto-generated method stub
List<Integer> zugManuell = view.zugManuell(spiel.getAnzahlFelder());
List<Integer> neuerZug = spiel.neuerZug(zugManuell);
view.ergebnisDarstellen(neuerZug,zugManuell);
if(spiel.hasGewonnen()){
	view.displayGewonnen();
	return false;
}
return true;

	}

}
