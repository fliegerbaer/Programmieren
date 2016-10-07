package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spiel 
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
		rateTipp = new Tipp(anzahlFarben,anzahlFelder);
		rateTipp.zufallTipp();
		//Abfrage der Attribute
		spielArray =new ArrayList<Tipp>();
		
	}

}
