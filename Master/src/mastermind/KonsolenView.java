package mastermind;


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class KonsolenView implements View {
	
	//implement View
	
	KonsolenView(){
		//Initialisierung der Klasse
		
		
	}
@Override
	public List<Integer> zugManuell(int felder){
		List<Integer> liste = new ArrayList<>();
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Geben Sie Ihren Zug ein");
		for (int i = 0; i < felder; i++) {
			System.out.println("geben Sie die " + (i+1) + " te Zahl ein");
			int farbe=eingabe.nextInt();
			liste.add(farbe);
		}
		eingabe.close();
		return liste;
	}

@Override
public void allesDarstellen(List<Spiel> s) {
	// 
	for (int i=0;i < s.size();i++){
		System.out.println(s);
		}
	}

}
//unvollständig