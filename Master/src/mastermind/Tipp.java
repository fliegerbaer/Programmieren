package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tipp {

	private int anzahlFarben;
	private int anzahlFelder;
	Random zufall = new Random();
	List<Integer> tippZeile = new ArrayList<>(); // erzeugen einer Instanz von
											// Integer mit dem Namen Tipp

	public Tipp(int anzahlFarben,int anzahlFelder ) {

		this.anzahlFarben = anzahlFarben;
		this.anzahlFelder = anzahlFelder;
	}
	public void zufallTipp() {
		for (int i = 0; i < anzahlFelder; i++) {
			tippZeile.add(zufall.nextInt(anzahlFarben));
		}
		System.out.println("Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + tippZeile);
	}
	public void manuellerTipp(List<Integer> tipp) {//TODO Methode manueller Zug muss noch implementiert werden - wie geht das an den View oder Spielcontroller? 
		//Kontrolle auf Konsistenz
		if(tipp.size()!=anzahlFelder){
			throw new RuntimeException("Anzahl der Felder stimmt nicht überein");
			//keine Prüfung auf Anzahl der Farben!!
 
		}
		this.tippZeile = tipp;
		for (int i = 0; i < anzahlFelder; i++) {
			tipp.add(zufall.nextInt(anzahlFarben));//hier muss noch ein Integer rein
		}
		System.out.println("Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + tipp);
	}
}
