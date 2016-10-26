package fenster;
import java.awt.BorderLayout;
/*
 * Vorgehensweise:
 * 1. Fenster planen
 * 2. Instanzvariablen erzeugen
 * 3.Konstruktor erzeugt das eigene Fenster (es wird hier nur der Fenstertitel übergeben)
 * 
 * 
 * 
 * mit Layoutmanager kann das Fensterverhalrten automatisiert werden
 * Positionen der Widgets werden relativ angegeben
 * Border Layout: Mitte, Nord Süd, ost west
 * Flow Layout: nebeneinander solang es passt
 * Box Layout enthält Flow (Glue ist Platzhalter)
 * Grid Layout tabellarisches Layout mit mehreren Möglichkeiten Alle Komponenten sind gleich groß
 * Grid Bag Layout - mächtig, komplex
 * Card Layout - Karten es gibt wie bei karten mehrere Karten, nur eine wird angezeigt in den Karten finden die anderen Komponenten platz.
 * 
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class FMFrame extends JFrame {
	//(2)Instanzvariablen erzeugen
	private JLabel lblHeader;
	private JTable table;
	private JScrollPane scrollTable;
	private JProgressBar progBar;
	private JButton btnInfo;
	private JButton btnAdd;
	private JLabel lblHersteller, lblLeistung, lblTyp, lblPreis;
	private JTextField fldHersteller;
	private JSpinner spinLeistung, spinPreis;
	private JComboBox boxTyp;
	private int fensterbreite,fensterhoehe;
	private JPanel pnlAdd;
	
	public FMFrame(String fenstertitelKonstruktor){
		setTitle(fenstertitelKonstruktor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(600, 600); gibt fixe Größe Vor
		dimensionen();
		//setLocation(null); Das geht hier nicht!! (wegen 2 Monitorbetrieb??)
		createWidgets(fenstertitelKonstruktor);
		addWidgets();
		pack();//bei Laoutmanager ist besser die funktion pack()
		setVisible(true);
	}
	private void dimensionen() {//Fensterdimensionen abfragen
		fensterhoehe=getHeight();
		fensterbreite=getWidth();
	}
	private void createWidgets(String fenstertitelCreateWidget) {
		lblHeader = new JLabel(fenstertitelCreateWidget);
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD + Font.ITALIC,30));
		//lblHeader.setBounds(0, 0, fensterbreite, 30);
		
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.ORANGE);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setOpaque(true);
		// Progressbar erzeugen
		progBar = new JProgressBar(0,100);//Progressbar von 0 bis 100 (Werte) Standard ist horizontale Ausrichtung
		//progBar.setBounds(0, (fensterhoehe-fensterhoehe/10), fensterbreite, fensterhoehe/10);
		progBar.setBackground(Color.BLUE);
		progBar.setOpaque(true);
		progBar.setValue(75); 
		//Tabelle erzeugen
		table = new JTable(500, 4);
		//table.setBounds(170, 50, 310, 390); das Table hängt an der scrollTable
		//zugehörige Bildlaufleiste
		scrollTable = new JScrollPane(table);
		// scrollTable.setBounds(270, 50, 310, 390);
		//Infoknopf erzeugen
		btnInfo = new JButton("Information...");
		btnInfo.setBackground(Color.BLACK);
		btnInfo.setFont(getFont());
		System.out.println("Fensterhöhe: "+fensterhoehe);
		btnInfo.setBounds(10, 150, 120,90 );
		//Gruppenpanel erzeugen
		pnlAdd = new JPanel();
		pnlAdd.setLayout(new BoxLayout(pnlAdd, javax.swing.BoxLayout.Y_AXIS)); //Layout erzeugen
		pnlAdd.setBackground(Color.CYAN); //ändert den Hintergrundfarbton, kein set opaque
		pnlAdd.setBounds(0, 50, 200, 300);
		//Komponenten des Gruppenpanels erzeugen 1.: Beschriftungen
		lblHersteller = new JLabel("Hersteller");
		lblLeistung = new JLabel("Leistung");
		lblPreis = new JLabel("Preis");
		lblTyp=new JLabel("Typ");
		//Größe der Beschriftungen festlegen
		lblHersteller.setBounds(10, 0, 100, 25);
		lblLeistung.setBounds(10, 30, 100, 25);
		lblPreis.setBounds(10, 60, 100, 25);
		lblTyp.setBounds(10, 90, 100, 25);
		//Datenfelder erzeugen
		fldHersteller = new JTextField();
		//Spinner erzeugen mit der Klasse "Model" = SpinnerNumberModel(...)
		spinLeistung = new JSpinner(new SpinnerNumberModel(100, 5, 1000, 10));
		spinPreis = new JSpinner(new SpinnerNumberModel(5000, 500, 10000, 100));
		boxTyp = new JComboBox<>(new Object[] {"PKW","LKW","Motorrad"});
		//Position der Datenfelder in dem Panel festlegen
		fldHersteller.setBounds(110, 0, 90, 25);
		spinLeistung.setBounds(110, 30, 90, 25);
		spinPreis.setBounds(110, 60, 90, 25);
		boxTyp.setBounds(110, 90, 90, 25);
		
		btnAdd = new JButton("Hinzufügen...");
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setFont(getFont());
		btnAdd.setBounds(10, 120, 130,25 );
		
		
		
		
	}
	private void addWidgets() {
		//System.out.println(getContentPane().getLayout());
		//getContentPane().setLayout(null); //null= das Standardlayout nicht verwenden
		
		getContentPane().setLayout(new BorderLayout(5, 5));//Border Layout verwenden
		
		//System.out.println(getContentPane().getLayout());
		getContentPane().add(BorderLayout.NORTH, lblHeader);
		//getContentPane().add(lblHeader);
		getContentPane().add(BorderLayout.SOUTH,progBar);
		//getContentPane().add(table); ist in scrolltable enthalten
		getContentPane().add(BorderLayout.EAST,scrollTable);
		//getContentPane().add(BorderLayout.WEST,btnInfo);
		//in das Gruppenpanel JPanel pnlAdd die Komponenten hinzufügen
		
		pnlAdd.add(lblHersteller);pnlAdd.add(fldHersteller);
		pnlAdd.add(lblLeistung);pnlAdd.add(spinLeistung);
		pnlAdd.add(lblPreis);pnlAdd.add(spinPreis);
		pnlAdd.add(lblTyp); pnlAdd.add(boxTyp);
		pnlAdd.add(btnAdd);
		pnlAdd.add(btnInfo);
		
		//das Gruppenpanel ausrichten
		getContentPane().add(BorderLayout.WEST,pnlAdd);
		getContentPane().validate();
		// TODO Auto-generated method stub
	}


	
	
	
	

}
