package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AktionenListener implements ActionListener{
	
	
	AktionenListener(){
		
	}
	
	
	
	AktionenListener(String knopf){
		
		System.out.println(knopf + " wurde erzeugt");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		e.getSource();
		// TODO Auto-generated method stub
		System.out.println("Label " + e.getActionCommand() + " Wurde geklickt");//ActionCommand=Name
		System.out.println("Objekt"+ e.toString() + "Wurde geklickt");//aendern
		System.out.println(e.paramString());
				
	}

}
