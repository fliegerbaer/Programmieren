package programm;

import java.util.ArrayList;
import java.util.List;

import klasse.Spiel;
import klasse.SpielController;
import view.AppWindow;
import view.KonsolenView;
/*
 * Main Methode
 * zum Anfang nur einfache Parameter: anzahl Farben =4
 * anzahl Felder =4
 */
public class MastermindPrg {
	
	private static List<SpielController> alleSpiele=new ArrayList<>();

	public static void main(String[] args) {
		//neues Spiel
		
		alleSpiele.add(new SpielController(new Spiel(4,4),new AppWindow()));
		//alleSpiele.add(new SpielController(new Spiel(4,4),new Appwindow()));
		//wird hier in alle Spiele ein Spiel gekapselt mit Konsolenview? Wichtig!! Zuständigkeiten müssen separiert werden!!
		System.out.println(alleSpiele.size());
		System.out.println(alleSpiele.get(0));
		
		//while(alleSpiele.get(0).neuerZug()); das muss wieder aktiviert werden.
		
	}
}