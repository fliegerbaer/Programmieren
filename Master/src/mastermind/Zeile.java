package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zeile {

	private int anzahlFarben;
	private int anzahlFelder;
	Random zufall = new Random();
	List<Integer> tippZeile = new ArrayList<>(); // erzeugen einer Instanz von
											// Integer mit dem Namen Tipp

	public List<Integer> getTippZeile() {
		return tippZeile;
	}
	public void setTippZeile(List<Integer> tippZeile) {
		this.tippZeile = tippZeile;
	}
	public Zeile(int anzahlFarben,int anzahlFelder ) {

		this.anzahlFarben = anzahlFarben;
		this.anzahlFelder = anzahlFelder;
	}
	public Zeile(List<Integer> manuellerTipp) {
		tippZeile = manuellerTipp;
		// TODO Auto-generated constructor stub
	}
	public void zufallTipp() {
		for (int i = 0; i < anzahlFelder; i++) {
			tippZeile.add(zufall.nextInt(anzahlFarben));
		}
		System.out.println("Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + tippZeile);
	}
	public void manuellerTipp() {//TODO Methode manueller Zug muss noch implementiert werden - wie geht das an den View oder Spielcontroller? 
		//Kontrolle auf Konsistenz
		getTippZeile();
		System.out.println(getTippZeile());
		if(getTippZeile().size()!=anzahlFelder){
			throw new RuntimeException("Anzahl der Felder stimmt nicht überein");
			//keine Prüfung auf Anzahl der Farben!!
 
		}
		
		for (int i = 0; i < anzahlFelder; i++) {
			//setTippZeile(tippZeile);.add(zufall.nextInt(anzahlFarben));//hier muss noch ein Integer rein
		}
		System.out.println("Zufallstipp erzeugt!");
		System.out.println("Das ist der Tipp: " + getTippZeile());
	}
}
