package data;
/**
 * ToernConnection contains following objects: Array of TableModels of the connected database and informations about the Database
 * 
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ToernConnection {

	public static JDBCTableModel[] jdbcTabellenModellArray;
	public static DefaultTableModel standardTabellenModellArray[];
	public Connection conn = null;
	public static DatabaseMetaData meta;
	public String datenverbindung,user;
	private int anzahlTabellenInDatenbank = 0;// Anfangswert auf 0
	private String[] tabellenStringArray;
/**
 * The Constructor creates/holds the connection conn and produces an StringArray of tables from the connected database. 
 * And also an Array of JDBCTableModels of the Tables.
 */
	//Konstruktor Start
	public ToernConnection(String datenverbindung,String user, String password) {// String datenverbindung,String user, String 
								// password
		System.out.println("KONSTRUKTOR ToernConnection START");
		this.datenverbindung = datenverbindung;
		this.user = user;
		// TODO Auto-generated constructor stub
		conn = toernConnector(datenverbindung,user,password);// datenverbindung,user, password (reseviert für
								// Übergabe von Verbindungsdaten
		try {
			tabellenStringArray = getTables(conn);//tabellen werden in dem Array gespeichert
			System.out.println("ToernConnection: erzeugte Tabellen: " + tabellenStringArray.length);
			for (int i = 0; i < tabellenStringArray.length; i++) {
				System.out.println("Tabelle " + i + " im Connector: " + tabellenStringArray[i].toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jdbcTabellenModellArray = new JDBCTableModel[tabellenStringArray.length];
		standardTabellenModellArray = new DefaultTableModel[tabellenStringArray.length];
		
		//standardTabellenModellArray = new DefaultTableModel(tabellenStringArray, anzahlTabellenInDatenbank);
		for (int i = 0; i < tabellenStringArray.length; i++) {
			try {
				jdbcTabellenModellArray[i] = new JDBCTableModel(conn, tabellenStringArray[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ToernConnection: Tabelle "+i+" mit Namen "+jdbcTabellenModellArray[i].getMeinTabellenName()+" wurde erzeugt");
		}
		for (int i = 0; i < tabellenStringArray.length; i++) {
			standardTabellenModellArray[i] = new DefaultTableModel();
			System.out.println("standardToernConnection: Tabelle "+i+" mit Namen "+standardTabellenModellArray[i].toString()+" wurde erzeugt");
		}
		System.out.println("Toern Connection: KONSTRUKTOR ENDE");
	}

	private Connection toernConnector(String datenverbindung,String user, String password) {// String datenverbindung,String user,
										// String password
		System.out.println("toernConnector START");
		try {
			// Class.forName(com.mysql.jdbc);
			Connection conn = DriverManager.getConnection(datenverbindung, user, password);
			meta = (DatabaseMetaData) conn.getMetaData();
			JOptionPane.showMessageDialog(null, "Datenverbindung mit User " + user + " wurde hergestellt. Datenbank: "
					+ meta.getDatabaseProductName() + " Version: " + meta.getDatabaseProductVersion());

			System.out.println(meta);
			System.out.println(meta.getSQLKeywords());
			System.out
					.println("Toern Connection: Schemas in DML änderbar: " + meta.supportsSchemasInDataManipulation());
			System.out.println("Toern Connection: Nur Lesen: " + meta.isReadOnly());
			// System.out.println("Schemas in DML: " + meta.getTables(arg0,
			// arg1, arg2, arg3));
			System.out.println("Toern Connection: Datenbank: " + meta.getDatabaseProductName());
			System.out.println("Toern Connection: Datenbankversion: " + meta.getDatabaseProductVersion());
			System.out.println("Toern Connection: TOERN CONNECTOR ERFOLGREICH BEENDET");
			return conn;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println("Toern Connection: TOERNCONNECTOR MIT FEHLERN!");
			return null;
		}
	}
	// ab hier Methoden

	public String[] getTables(Connection conn) throws Exception {
		System.out.println("Toern Connection: START METHODE GET TABLES");
		String TABLE_NAME = "TABLE_NAME";
		String[] TABLE_TYPES = { "TABLE" };
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet tables = dbmd.getTables(null, TABLE_NAME, null, TABLE_TYPES);
		// tables.get
		while (tables.next()) {// TODO elegantere Lösung finden!
			System.out.print("Toern Connection: Tabelle nummer: " + getAnzahlTabellenInDatenbank() + " :");
			System.out.println(tables.getString(TABLE_NAME));
			anzahlTabellenInDatenbank = getAnzahlTabellenInDatenbank() + 1;
		}
		tables.beforeFirst();// rücksetzen auf Zeile 1
		String[] gettabellenStringArray = new String[getAnzahlTabellenInDatenbank()];
		int i = 0;
		while (tables.next()) {// TODO elegantere Lösung finden!
			gettabellenStringArray[i] = tables.getString(TABLE_NAME);
			i++;
			//System.out.println(ToernConnection: getTables Nummer: "+");
		}
		System.out.println("ToernConnection: ENDER DER METHODE GET TABLES, Array tabellenStringArray mit "
				+ gettabellenStringArray.length + " Datensätzen erzeugt");
		return gettabellenStringArray;
	}// Ende Methode get Tables
		// -------------------------GETTER UND
		// SETTER--------------------------------------

	public String getUser() {
		return user;
	}

	/*public static void setUser(String user) {
		ToernConnection.user = user;
	}*/

	public String getDatenverbindung() {
		return datenverbindung;
	}

	/*public void setDatenverbindung(String datenverbindung) {
		ToernConnection.datenverbindung = datenverbindung;
	}*/

	public static JDBCTableModel[] getTabellen() {
		return jdbcTabellenModellArray;
	}

	public void setTabellen(JDBCTableModel[] tabellen) {
		this.jdbcTabellenModellArray = tabellen;
	}

	public String[] getTablesNamesAsStringArray() {
		return tabellenStringArray;
	}

	public int getAnzahlTabellenInDatenbank() {
		return anzahlTabellenInDatenbank;
	}

	public static DefaultTableModel[] getStandardTabellenModellArray() {
		return standardTabellenModellArray;
	}

	public static void setStandardTabellenModellArray(DefaultTableModel[] standardTabellenModellArray) {
		ToernConnection.standardTabellenModellArray = standardTabellenModellArray;
	}

}
