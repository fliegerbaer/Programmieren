package klassen;

public class AutoProgramm {
	
	public static void main (String[] args){
		
		Auto bmw,audi;
		
		/*
		 * Varible bmw, audi für den Datentyp Auto wird erzeugt und benannt. Inhalt=null
		 */
		bmw = new Auto(100,"BMW"); //Erzeugen einer Instanz der Klasse Auto mit den Parametern für den 
		//Konstruktor (Siehe Initialisierungsablauf in der Klasse Auto) und Zuweisung an die Variable bmw
		audi = new Auto(150,"Audi");
		
		//Punktnotation
		bmw.tunen(25);

		Auto.printInfos(audi);
		
		Auto.printInfos(bmw);
		
		
	}

}
