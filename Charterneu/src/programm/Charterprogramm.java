package programm;

//TODO datenbankdaten parametrisieren

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import data.ToernConnection;
import gui.Hauptfenster;
import gui.Hauptfenster2;

public class Charterprogramm {
	static String fenstertitel = "Stuis Toernplanung";
	// String user="";
	private static String datenverbindung = "jdbc:mysql://localhost:3306/toerndb?useSSL=false";
	private static String user = "root";
	private static String password = "123";
	public static ToernConnection conroot = null;
	public static String[] tables;

	// Main Methode Start
	public static void main(String[] args) {
		/*
		 * Ablauf: Verbindung aufbauen durch Toern Connection tabellen holen
		 * nach Toern Connection charteprogramm ruft hauptfenster auf mit
		 * Übergabe der toern connection Dann übernimmt das Hauptfenster...
		 */
		conroot = new ToernConnection(datenverbindung, user, password);// datenverbindung,user,password
		fenstertitel = "Datenbank: " + conroot.getDatenverbindung() + " User: " + conroot.getUser();

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Hauptfenster window = new Hauptfenster(conroot);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Main Ende
}
