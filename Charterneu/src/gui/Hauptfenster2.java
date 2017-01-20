package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Hauptfenster2 {
	//Variablen
	JFrame fenster;//Hauptfenster
	JTabbedPane tbdpne;
	String fenstertitel;
	
	
	public Hauptfenster2(String fenstertitel){//Konstruktor
		setFenstertitel(fenstertitel);//der übergebene Fenstertitel wird in die Variable geschrieben
		hauptfenster();//erzeugen des Fensters mit der Funktion Hauptfenster
		person();
		
	}
	
	private void person() {
		// TODO Auto-generated method stub
		tbdpne.addTab("person", new JPanel(new LayoutManager() {
			
			@Override
			public void removeLayoutComponent(Component comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Dimension preferredLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dimension minimumLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void layoutContainer(Container parent) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addLayoutComponent(String name, Component comp) {
				// TODO Auto-generated method stub
				
			}
		}));
		
	}

	void hauptfenster(){
		fenster=new JFrame(fenstertitel);
		tbdpne = new JTabbedPane(JTabbedPane.BOTTOM);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(800, 600);
		fenster.setVisible(true);
		
	}

	public String getFenstertitel() {
		return fenstertitel;
	}

	public void setFenstertitel(String fenstertitel) {
		this.fenstertitel = fenstertitel;
	}

}
