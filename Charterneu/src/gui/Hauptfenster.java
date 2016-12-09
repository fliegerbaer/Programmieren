package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import data.JDBCTableModel;

import java.awt.Button;
import java.awt.List;
import java.awt.Dimension;

public class Hauptfenster {

	public JFrame frame;
	private String fenstertitel;
	private JTable table;
	private JTable tblPerson;
	private Object[] jPanels;
	private JScrollPane[] jScrollPanes;
	private Object[] jTables;
	private LayoutManager borderLayout22 = new BorderLayout(2, 2);// 
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
	private JButton btnNeueBuchung;
/*
 * Ablauf Hauptfenster: Übernahme der Tabellen aus dem Konstruktor
 * Aufbau der Tabs:
 * pro Tabelle ein Tab
 * Tab enthält Panel
 * Panel enthält Tabelle
 * 
 * 
*/
	/**
	 * @wbp.parser.entryPoint
	 */
	public Hauptfenster(String fenstertitel, JDBCTableModel[] dbTabellenModelle) {
		initialize(fenstertitel, dbTabellenModelle);
		this.frame.pack();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	//.........................Initiierung
	private void initialize(String fenstertitel, JDBCTableModel[] dbTabellenModelle) {
		frame = new JFrame();
		frame.getContentPane().setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(fenstertitel);
		frame.getContentPane().setLayout(borderLayout22);
		//Initiieren der Arrays
		jPanels=new JPanel[dbTabellenModelle.length];
		for (int i=0;i<dbTabellenModelle.length;i++){

		System.out.println("Panel erzeugt ");
		}
		
		createObjects(dbTabellenModelle);
		placeObjects(dbTabellenModelle);
		
	
		
	}//Ende Konstruktor
	
	//---------------------Erzeugen der Objekte---------------------------
	private void createObjects(JDBCTableModel[] dbTabellenModelle){
		//tabbed pane erzeugen
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		//Panels erzeugen
		System.out.println("Hauptfenster: createObjects dbtabellenObjekte.length: "+dbTabellenModelle.length);
		//leere Panels erzeugt
		for (int i=0;i<dbTabellenModelle.length;i++){
			System.out.println("Panel nummer "+i+" erzeugt");
			//jPanels[i].setLayout(borderLayout22);
			System.out.println("Layout gesetzt");
			
		}
	}
	
	//---------------------Objekte ineinander verschachteln---------------
private void placeObjects(JDBCTableModel[] dbTabellenModelle){
	frame.getContentPane().add(tabbedPane);
	for (int i=0;i<dbTabellenModelle.length;i++){
		//tabbedPane.addTab(dbTabellenModelle[i].getMeinTabellenName(), null, jPanels[i],null);
		//Tabellen in das Pane hinzufügen
		//Muster: JPanel jPanels[nummer]=new JPanel();
	}
	
}

/*
		JPanel pnlPerson = new JPanel();//PersonenPanel erzeugen - erledigt
		tabbedPane.addTab("Person", null, pnlPerson, null);//erledigt
		pnlPerson.setLayout(new BorderLayout(0, 0));//erledigt
		
		JPanel pnlPersonSteuerung = new JPanel();
		pnlPerson.add(pnlPersonSteuerung, BorderLayout.SOUTH);
		
		Button btnNeuePerson = new Button("Neu");
		btnNeuePerson.setActionCommand("new");
		btnNeuePerson.addActionListener(new AktionenListener(btnNeuePerson.getName()));
		pnlPersonSteuerung.add(btnNeuePerson);
		
		Button btnLoeschen = new Button("löschen");
		btnLoeschen.setActionCommand("delete");
		btnLoeschen.addActionListener(new AktionenListener(btnLoeschen.getName()));
		pnlPersonSteuerung.add(btnLoeschen);
		
		Button btnAendern = new Button("ändern");
		btnAendern.setActionCommand("alterTable");//hier kann der sql Befehl eingetragen werden oder aus einer sql Liste geholt werden!!
		btnAendern.addActionListener(new AktionenListener(btnAendern.getName()));
		pnlPersonSteuerung.add(btnAendern);
		
		Button btnPersonNeuLaden = new Button("Neu Laden");
		btnPersonNeuLaden.setActionCommand("select");
		//btnPersonNeuLaden.getLabel()
		btnPersonNeuLaden.addActionListener(new AktionenListener(btnPersonNeuLaden.getLabel()));
		pnlPersonSteuerung.add(btnPersonNeuLaden);
		
		JScrollPane personScrollPane = new JScrollPane();  //Container für Personentabelle
		pnlPerson.add(personScrollPane, BorderLayout.CENTER); //Container für Person in pnl Person hinzu
		
		tblPerson = new JTable(); //neue Tabelle Person erstellen
		tblPerson.setRowSelectionAllowed(true);//Zeilenauswahl aktivieren
		tblPerson.setColumnSelectionAllowed(false);//Spaltenauswahl aktivieren 
		tblPerson.setCellSelectionEnabled(true); //Zellauswahl aktivieren
		tblPerson.setShowGrid(true);
		Color gridcolor = new Color(0,0,0);
		tblPerson.setGridColor(gridcolor);
		//tblPerson.
		personScrollPane.setViewportView(tblPerson);
		tblPerson.setModel(person);
		List list = new List();
	
		pnlPerson.add(list, BorderLayout.NORTH);
		
		
		JPanel pnlBuchung = new JPanel();
		tabbedPane.addTab("Buchung", null, pnlBuchung, null);
		pnlBuchung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlBuchungSteuerung = new JPanel();
		pnlBuchung.add(pnlBuchungSteuerung, BorderLayout.SOUTH);
		
		btnNeueBuchung = new JButton("neu");
		//btnNeueBuchung = null;
		//btnNeueBuchung.addActionListener(new AktionenButtons());
		pnlBuchungSteuerung.add(btnNeueBuchung);
		
		JButton buchungen = new JButton("Buchungen");
		pnlBuchungSteuerung.add(buchungen);
		
		JButton btnBuchungLoeschen = new JButton("Löschen");
		pnlBuchungSteuerung.add(btnBuchungLoeschen);
		
		JPanel panel_1 = new JPanel();
		pnlBuchung.add(panel_1, BorderLayout.WEST);
		
		JComboBox cmbbxPersonInBuchung = new JComboBox();
		cmbbxPersonInBuchung.setMaximumRowCount(10);
		cmbbxPersonInBuchung.setToolTipText("Hier Person für Buchung wählen");
		pnlBuchung.add(cmbbxPersonInBuchung, BorderLayout.WEST);
		
		table = new JTable();
		
		pnlBuchung.add(table, BorderLayout.CENTER);
		
		JPanel pnlToern = new JPanel();
		tabbedPane.addTab("Törn", null, pnlToern, null);
		
		JPanel pnlSchiff = new JPanel();
		tabbedPane.addTab("Schiff", null, pnlSchiff, null);
		
		JPanel pnlListen = new JPanel();
		tabbedPane.addTab("ListenExport", null, pnlListen, null);
		pnlListen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSkipperliste = new JButton("Skipperliste");
		pnlListen.add(btnSkipperliste);
		
		JButton btnRundmailliste = new JButton("Rundmailliste");
		pnlListen.add(btnRundmailliste);
*/
	
	// ---------------------getter und setter-----------------------------
	public String getFenstertitel() {
		return fenstertitel;
	}

	public void setFenstertitel(String fenstertitel) {
		this.fenstertitel = fenstertitel;
	}
}

