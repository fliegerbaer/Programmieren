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
	private JTable tblSchiff;
	private JTable tblPerson;
	private JPanel[] jPanels;
	private JScrollPane[] jScrollPanes;
	private JTable[] jTables;
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
		jPanels=new JPanel[dbTabellenModelle.length];//für jede Tabelle(i) ein Pane erzeugt
		System.out.println(jPanels.length+" Panels erzeugt");
		jScrollPanes=new JScrollPane[dbTabellenModelle.length];//für jede Tabelle(i)ein ScrollPane erzeugen
		System.out.println(jScrollPanes.length+" JScrollpanes erzeugt");
		jTables=new JTable[dbTabellenModelle.length];//
		System.out.println(jTables.length+" JTables erzeugt");
		
		//tabbed pane erzeugen
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		for (int i=0;i<dbTabellenModelle.length;i++){
			jTables[i]=new JTable();jScrollPanes[i]=new JScrollPane();jPanels[i]=new JPanel();
			
System.out.println("Tabelle Nummer: "+i+" heißt "+dbTabellenModelle[i].getMeinTabellenName());

jTables[i].setShowGrid(true);
jTables[i].setGridColor(new Color(0,0,0));
jScrollPanes[i].setViewportView(jTables[i]);
jTables[i].setModel(dbTabellenModelle[i]);
jScrollPanes[i].add(jTables[i]);
jPanels[i].setLayout(borderLayout22);
jPanels[i].add(jScrollPanes[i], BorderLayout.CENTER);
		}
		frame.getContentPane().add(tabbedPane);
		for (int i=0;i<dbTabellenModelle.length;i++){
			tabbedPane.addTab(dbTabellenModelle[i].getMeinTabellenName(), null, jPanels[i],null);
			//Tabellen in das Pane hinzufügen
			//Muster: JPanel jPanels[nummer]=new JPanel();
		}
	}//Ende Konstruktor
	//in Pane JScrollpane hinzu dann JTable in Jscrollpane
	// ---------------------getter und setter-----------------------------
	public String getFenstertitel() {
		return fenstertitel;
	}

	public void setFenstertitel(String fenstertitel) {
		this.fenstertitel = fenstertitel;
	}
}
