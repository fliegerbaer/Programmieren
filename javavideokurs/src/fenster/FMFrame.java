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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
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
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

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
	private JPanel pnlLeft;
	private JLabel label;
	private JPanel panel;
	//---------------------------------------------K O N S T R U K T O R für das Fenster------------------------------------------------
	public FMFrame(String fenstertitelKonstruktor){
		setTitle(fenstertitelKonstruktor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(600, 600); gibt fixe Größe Vor
		dimensionen();
		System.out.print(fensterbreite + " ");
		System.out.println(fensterhoehe);
		//setLocation(null); //Das geht hier nicht!! (wegen 2 Monitorbetrieb??)
		createWidgets(fenstertitelKonstruktor);
		addWidgets();
		pack();//bei Laoutmanager ist besser die funktion pack()
		setVisible(true);
	}
	//---------------------------------------------METHODE------------------------------------------------
	private void dimensionen() {//Fensterdimensionen abfragen
		fensterhoehe=getHeight();
		fensterbreite=getWidth();
	}
	//---------------------------------------------Widgets erzeugen------------------------------------------------
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
		progBar.setBackground(Color.CYAN);
		progBar.setPreferredSize(new Dimension(10, 30));
		progBar.setOpaque(true);
		progBar.setValue(75); 
		//Tabelle erzeugen
		table = new JTable(500, 4);
		table.setBorder(new LineBorder(new Color(50, 50, 50)));
		table.setSurrendersFocusOnKeystroke(true);
		//table.add(spinPreis, "Hallo",-1); tut so nicht!!
		
		//table.setBounds(170, 50, 310, 390); das Table hängt an der scrollTable
		//zugehörige Bildlaufleiste
		scrollTable = new JScrollPane(table);
		
		//pnlAdd.setBounds(0, 50, 200, 300);
		//Komponenten des Gruppenpanels erzeugen 1.: Beschriftungen
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setVerticalAlignment(SwingConstants.TOP);
		lblLeistung = new JLabel("Leistung");
		lblPreis = new JLabel("Preis");
		lblTyp=new JLabel("Typ");
		//Größe der Beschriftungen festlegen

		//Datenfelder erzeugen
		fldHersteller = new JTextField();
		fldHersteller.setAlignmentX(5);
		fldHersteller.setMaximumSize(getPreferredSize());
		//Spinner erzeugen mit der Klasse "Model" = SpinnerNumberModel(...)
		spinLeistung = new JSpinner(new SpinnerNumberModel(100, 5, 1000, 10));
		spinPreis = new JSpinner(new SpinnerNumberModel(5000, 500, 10000, 100));
		boxTyp = new JComboBox<>(new Object[] {"PKW","LKW","Motorrad"});
		//Position der Datenfelder in dem Panel festlegen

		btnAdd = new JButton("Hinzufügen...");
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setFont(getFont());
		//Gruppenpanel erzeugen
		pnlAdd = new JPanel();
		pnlAdd.setBackground(Color.CYAN);
		//pnlAdd.setMinimumSize(new Dimension(0, 0));
		//linkes Panel erzeugen, nimmt Gruppenpanel auf
		pnlLeft = new JPanel();	
		pnlLeft.setLayout(new BoxLayout(pnlLeft,BoxLayout.PAGE_AXIS));
		pnlLeft.setMaximumSize(getPreferredSize());
		getContentPane().setLayout(new BorderLayout(5, 5));//Border Layout verwenden
		getContentPane().add(BorderLayout.NORTH, lblHeader);
		getContentPane().add(BorderLayout.SOUTH,progBar);
		getContentPane().add(BorderLayout.EAST,scrollTable);
		getContentPane().add(BorderLayout.WEST,pnlLeft);
 
	}
	//---------------------------------------------Widgets hinzufügen------------------------------------------------
	private void addWidgets() {
		//getContentPane().setLayout(null); //null= das Standardlayout nicht verwenden
	pnlLeft.add(pnlAdd);
		pnlAdd.setLayout(new GridLayout(0, 2, 0, 0));
		pnlAdd.add(lblHersteller);
		pnlAdd.add(fldHersteller);
		pnlAdd.add(lblLeistung);
		pnlAdd.add(spinLeistung);
		pnlAdd.add(lblPreis);
		pnlAdd.add(spinPreis);
		pnlAdd.add(lblTyp);
		pnlAdd.add(boxTyp);
		pnlAdd.add(btnAdd);
		pnlAdd.setMaximumSize(getPreferredSize());
		
		label = new JLabel("");
		pnlAdd.add(label);
		
		panel = new JPanel();
		pnlLeft.add(panel);
		// scrollTable.setBounds(270, 50, 310, 390);
		//Infoknopf erzeugen
		btnInfo = new JButton("Information...");
		btnInfo.setBackground(Color.BLACK);
		btnInfo.setFont(getFont());
		btnInfo.setAlignmentX(LEFT_ALIGNMENT);
		
			
				
				pnlLeft.add(btnInfo);
		
		//das Gruppenpanel ausrichten
		//getContentPane().add(BorderLayout.WEST,pnlAdd);
		getContentPane().validate();
		// TODO Auto-generated method stub
	}


	
	
	
	

}
