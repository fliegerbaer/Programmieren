package programm;



import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.DatabaseMetaData;

import data.JDBCTableModel;
import data.MysqlConnectionToern;
import gui.Hauptfenster;

public class charterprogramm {
	public static Connection conroot = null;
	static MysqlConnectionToern mycon=null;
	
	
	
	public static JDBCTableModel toern;
	public static JDBCTableModel buchung;
	public static JDBCTableModel person;
	public static JDBCTableModel schiff;
	public static JDBCTableModel ort;
	public static JDBCTableModel[] tabellen; 
	
	
	public static void main(String[] args) {
		mycon = new MysqlConnectionToern();
		
		conroot = MysqlConnectionToern.toernConnector("root","123");
		
		try {
			toern = new JDBCTableModel(conroot, "toern");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			buchung = new JDBCTableModel(conroot, "buchung");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			schiff = new JDBCTableModel(conroot, "schiff");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ort = new JDBCTableModel(conroot, "ort");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			person = new JDBCTableModel(conroot, "person");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/*try {
			System.out.println(conroot.);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster window = new Hauptfenster(null,toern,person);
					window.setFenstertitel("Hauptfenster User: " + MysqlConnectionToern.getUser());
					window.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	
		}
	
}
