package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * Spiel enthält: Das Spiel mit einer ArrayListe von Tipps, sowie den Rahmenbedingungen des Spiels
 * anzahl der Felder = Felderzahl zu erraten
 * anzahlFarben = anzahl der möglichen Farben
 */

public class Spiel //Spiel 
{
	private List<Tipp> tipp = new ArrayList<>();
	private int anzahlFelder;
	private int anzahlFarben;
	private Tipp rateTipp;
	//private int maximaleAnzahlZuege = 99; nicht notwendig, da Array List
	private int aktuellerZug=1;
	private ArrayList<Tipp> spielArray;// =new ArrayList<Integer>();
	Spiel(int anzahlFarben,int anzahlFelder){
		//beim Erzeugen der neuen Instanz sollen die Attribute abgefragt werden
		this.anzahlFarben=anzahlFarben;
		this.anzahlFelder=anzahlFelder;
		System.out.println("Farben:" + anzahlFarben + " Felder:"+anzahlFelder);
		rateTipp = new Tipp(anzahlFarben,anzahlFelder);
		rateTipp.zufallTipp();
		System.out.println("Ratetipp: "+rateTipp.tipp);
		//Abfrage der Attribute
		spielArray =new ArrayList<Tipp>();
		System.out.println("Größe SpielArray: "+spielArray.size());
		
	}
	void neuerZug(){
		
	}

}
