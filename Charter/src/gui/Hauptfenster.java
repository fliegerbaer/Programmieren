package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class Hauptfenster {

	public JFrame frame;
	
	private String fenstertitel;
	private JTable table;
	private JTable tblPerson;

	private JButton btnNeueBuchung;
	


	public static void main(String[] args) {

	}

	
	public Hauptfenster(String fenstertitel) {
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Hauptfenster(Object object, JDBCTableModel toern, JDBCTableModel person) {
		// TODO Auto-generated constructor stub
		initialize(fenstertitel, toern, person);
		this.frame.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String fenstertitel, JDBCTableModel toern,JDBCTableModel person) {
		frame = new JFrame();
		//dimensionen();
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(fenstertitel);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(tabbedPane);
		
		JPanel pnlPerson = new JPanel();
		tabbedPane.addTab("Person", null, pnlPerson, null);
		pnlPerson.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlPersonSteuerung = new JPanel();
		pnlPerson.add(pnlPersonSteuerung, BorderLayout.SOUTH);
		
		Button btnNeuePerson = new Button("Neu");
		btnNeuePerson.setActionCommand("new");
		btnNeuePerson.addActionListener(new Aktionen(btnNeuePerson.getName()));
		pnlPersonSteuerung.add(btnNeuePerson);
		
		Button btnLoeschen = new Button("löschen");
		btnLoeschen.setActionCommand("delete");
		btnLoeschen.addActionListener(new Aktionen(btnLoeschen.getName()));
		pnlPersonSteuerung.add(btnLoeschen);
		
		Button btnAendern = new Button("ändern");
		btnAendern.setActionCommand("alterTable");//hier kann der sql Befehl eingetragen werden oder aus einer sql Liste geholt werden!!
		btnAendern.addActionListener(new Aktionen(btnAendern.getName()));
		pnlPersonSteuerung.add(btnAendern);
		
		Button btnPersonNeuLaden = new Button("Neu Laden");
		btnPersonNeuLaden.setActionCommand("select");
		//btnPersonNeuLaden.getLabel()
		btnPersonNeuLaden.addActionListener(new Aktionen(btnPersonNeuLaden.getLabel()));
		pnlPersonSteuerung.add(btnPersonNeuLaden);
		
		JScrollPane scrollPane = new JScrollPane();
		pnlPerson.add(scrollPane, BorderLayout.CENTER);
		
		tblPerson = new JTable();
		tblPerson.setColumnSelectionAllowed(true);
		tblPerson.setCellSelectionEnabled(true);
		//tblPerson.
		scrollPane.setViewportView(tblPerson);
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
	}
	

	
	// ---------------------getter und setter-----------------------------
	public String getFenstertitel() {
		return fenstertitel;
	}

	public void setFenstertitel(String fenstertitel) {
		this.fenstertitel = fenstertitel;
	}
}
