package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import inter.View;
import klasse.Spiel;

public class AppWindow extends JFrame implements View {

	private int fensterbreite = 500, fensterhoehe = 500;
	private JLabel lblTitel;
	private JButton btnSpielNeu;
	private JTable table;

//Konstruktor
	public AppWindow() {
		setTitle("Franks Mastermind");
		setDefaultLookAndFeelDecorated(true); //Look and Feel vom BS übernehmen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm wird beim Schließen beendet
		
		
			//erster Schritt: Instanzen erstellen
		createWidgets();
		//zweiter Schritt: Instanzen hinzufügen
		addWidgets();
		setSize(fensterbreite, fensterhoehe);
		setLocationRelativeTo(null);
		setVisible(true);
		}//ENDE Konstruktor

	private void addWidgets() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(null); //um das standardvoreingestellt zu überschreiben.
		//dem Pane Inhalte hinzufügen:
		getContentPane().add(lblTitel);
		/*dem Inhalt den Titel hinzufügen. Typ: "Component" JLabel erbt von Component. 
		 * standard: 0x0 pixel
		*/

	}
	private void createWidgets() {
		System.out.println("Widgets werden erzeugt");
		//Titel erzeugen 
		lblTitel = new JLabel("Mastermind");
		lblTitel.setFont(lblTitel.getFont().deriveFont(Font.BOLD + Font.ITALIC,30));
		lblTitel.setBounds(0, 0, fensterbreite, 30);
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitel.setForeground(Color.ORANGE);
		lblTitel.setBackground(Color.BLACK);
		lblTitel.setOpaque(true);
		
		// TODO Auto-generated method stub
	}

	@Override
	public List<Integer> zugManuell(int felder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allesDarstellen(List<Spiel> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayGewonnen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ergebnisDarstellen(List<Integer> neuerZug, List<Integer> zugManuell) {
		// TODO Auto-generated method stub
		
	}
	

	

	}

