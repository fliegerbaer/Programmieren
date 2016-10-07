package mastermind;

import java.util.ArrayList;
import java.util.List;
/*
 * Main Methode
 * zum Anfang nur einfache Parameter: anzahl Farben =4
 * anzahl Felder =4
 */
public class MastermindPrg {
	
	int maximaleParalleleSpiele=1;
	private static List<Spiel> alleSpiele=new ArrayList<Spiel>();
	
	
	
	private KonsolenView[] k;

	public static void main(String[] args) {
		//neues Spiel
		
		alleSpiele.add(new Spiel(4,4));//wird hier in alle Spiele ein Spiel gekapselt?
		System.out.println(alleSpiele.size());
		System.out.println(alleSpiele.get(0));
		//System.out.println(alleSpiele.get(0));
		//System.out.println(alleSpiele.get(0));
		// TODO Auto-generated method stub
	}
}