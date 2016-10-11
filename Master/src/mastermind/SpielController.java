package mastermind;

import java.util.List;

public class SpielController {
	
	/*Controller verknüpft View mit Spiel (Modell) 
	 * Sinn: 
	* Spiel (Modell) wird vom View getrennt!! 
	* Separierung der Zuständigkeiten.
	*/
	public SpielController(Spiel spiel, KonsolenView konsolenView) {
		this.spiel=spiel;
		view=konsolenView;
		// TODO Auto-generated constructor stub
	}
	private Spiel spiel;
	private View view;
	
	
	
	
	//Zahlen voview.;
	
	//Zahlen vom View an Spiel übergeben
	
	
	//Ergebnis wieder an View übergeben
	
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
