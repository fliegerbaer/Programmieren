package staffel03;

public class Aufgabe3 {
	static int kundenzaehler;
	final int identNummer=kundenzaehler;
	
	static {
		kundenzaehler=1;
	}
	
	Aufgabe3() {
		kundenzaehler++;
		System.out.println("KundenZähler: "+kundenzaehler+" identNummer: "+identNummer);
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String[] args) {
		
		Aufgabe3 kunde1=new Aufgabe3();
		
		Aufgabe3 kunde2=new Aufgabe3();
		
		
		
	}
	

}
