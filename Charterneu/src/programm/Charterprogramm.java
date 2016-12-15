package programm;



import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import data.ToernConnection;
import gui.Hauptfenster;
import gui.Hauptfenster2;

public class Charterprogramm {
	static String fenstertitel = "Stuis Toernplanung";
	public static ToernConnection conroot  = null;
	public static String[] tables;
	
	public static void main(String[] args) {//Main Methode

		    try {
		            // Set cross-platform Java L&F (also called "Metal")
		        //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		        UIManager.setLookAndFeel(UIManger.getSystemLookAndFe);
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    	System.out.println("unsupported look and feel nicht umgestellt");
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    	System.out.println("handle look and feel nicht umgestellt");
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    	System.out.println("instantiation look and feel nicht umgestellt");
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    	System.out.println("illegal look and feel nicht umgestellt");
		    }
		/*
		 * Ablauf: 
		 * Verbindung aufbauen durch Toern Connection
		 * tabellen holen nach Toern Connection
		 * charteprogramm ruft hauptfenster auf mit Übergabe der Tabellen und Fenstertitel
		 * Dann übernimmt das Hauptfenster...
		 * 
		 */
		
		conroot = new ToernConnection();//datenverbindung,user,password
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*
				try {
					Hauptfenster window = new Hauptfenster(null,ToernConnection.getTabellen());
					window.setFenstertitel("Hauptfenster User: " + ToernConnection.getUser());
					window.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
				*/
				try {
					Hauptfenster2 window2 = new Hauptfenster2(fenstertitel);

					//window2.setFenstertitel("Hauptfenster2 User: " + ToernConnection.getUser());
					//window2.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
		}
}
