package fenster;

import java.awt.Color;
import java.awt.Font;

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
import javax.swing.SwingConstants;

public class FMFrame extends JFrame {
	
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
	
	
	public FMFrame(String fenstertitel){
		setTitle(fenstertitel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600, 600);
		dimensionen();
		//setLocation(null); Das geht hier nicht!! (2 Monitorbetrieb??)
		
		
		createWidgets();
		addWidgets();
		
		setVisible(true);
		
	}
	

	private void dimensionen() {
		//Fensterdimensionen abfragen
		fensterhoehe=getHeight();
		fensterbreite=getWidth();
		
	}


	private void createWidgets() {
		
		lblHeader = new JLabel("Mastermind");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD + Font.ITALIC,30));
		lblHeader.setBounds(0, 0, fensterbreite, 30);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.ORANGE);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setOpaque(true);
		// Progressbar erzeugen
		progBar = new JProgressBar(0,100);//Progressbar von 0 bis 100 (Werte) Standard ist horizontale Ausrichtung
		progBar.setBounds(0, (fensterhoehe-fensterhoehe/10), fensterbreite, fensterhoehe/10);
		progBar.setBackground(Color.BLUE);
		progBar.setOpaque(true);
		progBar.setValue(75); 
		//Tabelle erzeugen
		table = new JTable(500, 4);
		//table.setBounds(170, 50, 310, 390); das Table hängt an der scrollTable
		//zugehörige Bildlaufleiste
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(270, 50, 310, 390);
		
		//Infoknopf erzeugen
		btnInfo = new JButton("Information...");
		btnInfo.setBackground(Color.BLACK);
		btnInfo.setFont(getFont());
		System.out.println("Fensterhöhe: "+fensterhoehe);
		btnInfo.setBounds(5, 450, 150,50 );
		
		//Gruppenpanel erzeugen
		pnlAdd = new JPanel();
		pnlAdd.setLayout(null);
		pnlAdd.setBackground(Color.CYAN);
		pnlAdd.setBounds(0, 50, 200, 300);
		
		
	}
	private void addWidgets() {
		//System.out.println(getContentPane().getLayout());
		getContentPane().setLayout(null); //null= das Standardlayout nicht verwenden
		//System.out.println(getContentPane().getLayout());
		getContentPane().add(lblHeader);
		getContentPane().add(progBar);
		//getContentPane().add(table); ist in scrolltable enthalten
		getContentPane().add(scrollTable);
		getContentPane().add(btnInfo);
		getContentPane().add(pnlAdd);
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
