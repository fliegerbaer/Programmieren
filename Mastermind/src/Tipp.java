import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tipp {

	private int anzahlFarben;
	private int anzahlFelder;
	Random zufall = new Random();
	List<Integer> tipp = new ArrayList<>(); // erzeugen einer Instanz von
											// Integer mit dem Namen Tipp

	public Tipp(int anzahlFelder, int anzahlFarben) {

		this.anzahlFarben = anzahlFarben;
		this.anzahlFelder = anzahlFelder;
	}
	public void zufallTipp() {
		for (int i = 0; i < anzahlFelder; i++) {
			tipp.add(zufall.nextInt(anzahlFarben));
		}
	}
	public void manuellerTipp(List<Integer> tipp) {
		//Kontrolle auf Konsistenz
		if(tipp.size()!=anzahlFelder){
			throw new RuntimeException("Anzahl der Felder stimmt nicht überein");
			//keine Prüfung auf Anzahl der Farben!!
		}
		this.tipp = tipp;
	}
}
