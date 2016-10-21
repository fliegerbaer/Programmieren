package klasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * Spiel enthält: Das Spiel mit einer ArrayListe von Tipps, sowie den Rahmenbedingungen des Spiels
 * anzahl der Felder = Felderzahl zu erraten
 * anzahlFarben = anzahl der möglichen Farben
 */

public class Spiel // Spiel
{
	// private List<Tipp> tipp = new ArrayList<>();
	/**
	 * wird wahr wenn die Methode hasGewonnen() wahr wird
	 */
	private boolean gewonnen=false;

	private int anzahlFelder;
	private int anzahlFarben;
	private Zeile rateTipp;
	private ArrayList<Zeile> spielzuege;// =new ArrayList<Integer>();

	// Konstruktor Spiel
	public Spiel(int anzahlFarben, int anzahlFelder) {
		// beim Erzeugen der neuen Instanz sollen die Attribute abgefragt werden
		this.anzahlFarben = anzahlFarben;
		this.anzahlFelder = anzahlFelder;
		System.out.println("Farben:" + anzahlFarben + " Felder:" + anzahlFelder);
		rateTipp = new Zeile(anzahlFarben, anzahlFelder);
		rateTipp.zufallTipp();
		System.out.println("Ratetipp: " + rateTipp.tippZeile);
		// Abfrage der Attribute
		spielzuege = new ArrayList<Zeile>();

		System.out.println("Größe neues SpielArray: " + spielzuege.size());
	}

	/**
	 * Vergleicht übergibt den Tipp zur Überprüfung an die Methode
	 * vergleichTipp() und ergänzt die Spielliste um den Tipp
	 * 
	 * @param manuellerTipp
	 * @return
	 */
	public List<Integer> neuerZug(List<Integer> manuellerTipp) {
		List<Integer> vergleichTipp = vergleichTipp(manuellerTipp);
		spielzuege.add(new Zeile(manuellerTipp)); // fügt den Spielzügen den
													// neuen Zug an
		return vergleichTipp;
	}

	/**
	 * Vergleicht den Tipp mit dem Ursprungstipp. Und prüft auf gewinnen.
	 * 
	 * @param manuelleTippreihe
	 * @return
	 */
	private List<Integer> vergleichTipp(List<Integer> manuelleTippreihe) {

		Integer volltreffer = 0;
		Integer farbtreffer = 0;
		for (int i = 0; i < anzahlFelder; i++) {
			Integer gegebenerWert = manuelleTippreihe.get(i);
			Integer erwartungsWert = rateTipp.getTippZeile().get(i);
			if (gegebenerWert == erwartungsWert) {
				volltreffer++;
			}
		}
		for (int i = 0; i < anzahlFelder; i++) {
			Integer gtippteZahl = manuelleTippreihe.get(i);
			for (int j = 0; j < anzahlFelder; j++) {
				Integer erwartungsWert = rateTipp.getTippZeile().get(j);
				if (gtippteZahl == erwartungsWert) {
					farbtreffer++;
				}
			}
		}
		farbtreffer=farbtreffer-volltreffer;
		ArrayList<Integer> rueckgabeliste = new ArrayList<>();
		for (int i = 0;i<volltreffer;i++){//TODO hier muss noch was gemacht werden volltreffer und farbtreffer werden gedoppelt
			rueckgabeliste.add(1);
		}
		for (int i = 0;i<farbtreffer;i++){
			rueckgabeliste.add(2);
		}
		for (int i = 0; i < (anzahlFelder-(volltreffer+farbtreffer)); i++) {
			rueckgabeliste.add(0);
		}
		//getRateTipp(); wird nicht benötigt?
		if (volltreffer==anzahlFelder) {
			gewonnen=true;
			}
		return rueckgabeliste;
	}

	public boolean hasGewonnen() {
		return gewonnen;
	}
	public int getAnzahlFelder() {
		return anzahlFelder;
	}
	public Zeile getRateTipp() {
		return rateTipp;
	}
	public void setRateTipp(Zeile rateTipp) {
		this.rateTipp = rateTipp;
	}
	public Zeile getSpielzug(int zug) {
		return spielzuege.get(zug);
	}

}
