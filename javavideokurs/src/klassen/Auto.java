package klassen;

public class Auto {
	/*
	 * Reihenfolge der Instanziierung:
	 * 1. überspringen 
	 * 2. Speicherbereichfür Variablen reservieren, noch keine Zuweisung von Werten!
	 * 3. Die Werte werden zugewiesen. (ansonsten Default Wert aber nur wenn noch nichts zugewiesen- Datentypabhängig)  
	 * danach Ausführen der Initialisierungsblöcke (nicht statische Initialisierungsblöcke) - Codeblock im Klassenrumpf { }
	 * 4. Der Konstruktor wird ausgeführt
	 */

	//Instanzvariablen: (Attribute, Member)
	// <Datentyp> <name> [<Zuweisung>] Designregeln: Zuweisung bei fixen Werten
	private int leistung; //PS default 0
	private String hersteller; // default null
	
	{
		leistung = 10; //erster Initialisierungsblock
	}
	{
		leistung = 0; //zweiter InitBlock
	}
	// Instanz-Methoden
	void tunen(int tuneWert){
		leistung = leistung + tuneWert;
	
	}
	// Getter	
	public int getLeistung(){
		return leistung;
	}
	public String getHersteller(){
		return hersteller;
	}
	// Setter
	public void setLeistung(int leistung){
		/*
		 * TODO Wert muss noch überprüft werden
		 */
		this.leistung=leistung;
	}
	public void setHersteller(String hersteller){
		this.hersteller=hersteller;
	}
	
	
	
	
	//Konstruktoren:
	Auto(int dieLeistung,String derHersteller) {
		leistung=dieLeistung;
		hersteller=derHersteller;
	}
	
	public static void printInfos(Auto auto){ //keine Informationen über ein Objekt vorhanden
		System.out.println("Der Hersteller ist: " + auto.hersteller +" Die Leistung ist: ");
	}
	
}
