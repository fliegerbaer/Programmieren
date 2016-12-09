package programm;



import java.awt.EventQueue;
import java.sql.Connection;

import data.ToernConnection;
import gui.Hauptfenster;

public class charterprogramm {
	public static ToernConnection conroot = null;
	//static MysqlConnectionToern mycon=null;

	

	public static String[] tables;
	
	public static void main(String[] args) {
		//mycon = new MysqlConnectionToern();
		/*
		 * Ablauf: 
		 * Verbindung aufbauen durch Toern Connection
		 * tabellen holen nach Toern Connection
		 * charteprogramm ruft hauptfenster auf mit Übergabe der Tabellen und Fenstertitel
		 * Dann übernimmt das Hauptfenster...
		 * 
		 */
		
		conroot = new ToernConnection();//datenverbindung,user,password
		
		/*
		for (String m:tables){
			System.out.println(tables);
		}
	*/
		
		
		/*try {
			System.out.println(conroot.);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster window = new Hauptfenster(null,ToernConnection.getTabellen());
					window.setFenstertitel("Hauptfenster User: " + ToernConnection.getUser());
					window.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	
		}
	
}
