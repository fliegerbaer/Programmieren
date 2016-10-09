package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tipp {

	private int anzahlFarben;
	private int anzahlFelder;
	Random zufall = new Random();
	List<Integer> tipp = new ArrayList<>(); // erzeugen einer Instanz von
											// Integer mit dem Namen Tipp
//Konstruktor
	public Tipp(int anzahlFarben,int anzahlFelder ) {

		this.anzahlFarben = anzahlFarben;
		this.anzahlFelder = anzahlFelder;
		System.out.println("Neue Instanz für Tipp erzeugt");
	}
//Ende Konstruktor
	
	public void zufallTipp() {
		for (int i = 0; i < anzahlFelder; i++) {
			tipp.add(zufall.nextInt(anzahlFarben));
		}
		System.out.println("Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + tipp);
	}
	//Manueller Tipp
	public void manuellerTipp(List<Integer> tipp) {
		//Kontrolle auf Konsistenz
		if(tipp.size()!=anzahlFelder){
			throw new RuntimeException("Anzahl der Felder stimmt nicht überein");
		}	//keine Prüfung auf Anzahl der Farben!!
 
		//this.tipp = zugManuell(anzahlFelder);
		for (int i = 0; i < anzahlFelder; i++) {
			tipp.add(zufall.nextInt(anzahlFarben));//hier muss noch ein Integer rein
		}
		System.out.println("noch ein Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + tipp);
	}
}
