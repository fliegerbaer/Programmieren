package staffel03;

public class AufgabeN1 {
	
	public static final boolean SINGLETON;
final int tv;
	
	static{SINGLETON=true;}
	{
		tv=1;
	}
	AufgabeN1(){
		System.out.println("testwert:" + tv);
		System.out.println("Singleton: "+SINGLETON);
		System.out.println("instanz erzeugt");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
AufgabeN1 erster = new AufgabeN1();
AufgabeN1 zweiter = new AufgabeN1();


	}

}
