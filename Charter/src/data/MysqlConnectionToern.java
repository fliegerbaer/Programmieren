package data;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.DatabaseMetaData;
import java.sql.DatabaseMetaData;

public class MysqlConnectionToern {
	
	public static String datenverbindung= "jdbc:mysql://localhost:3306/toerndb?useSSL=false";
	private static String user="root";
	public static String password="123";
	Connection conn=null;
	public static DatabaseMetaData meta;
	
	public static Connection toernConnector(){
	
		return toernConnector(user, password);
	}
	
	public static Connection toernConnector(String user, String password){
		try{
			//Class.forName(com.mysql.jdbc);
			Connection conn = DriverManager.getConnection(datenverbindung,user, password);
			//Connection conn=DriverManager.getConnection(url)
			JOptionPane.showMessageDialog(null, "Datenverbindung mit User " + user + " wurde hergestellt");
			meta = (DatabaseMetaData) conn.getMetaData();
			System.out.println(meta);
			System.out.println(meta.getSQLKeywords());
			System.out.println("Schemas in DML: " + meta.supportsSchemasInDataManipulation());
			System.out.println("Nur Lesen: " + meta.isReadOnly());
			//System.out.println("Schemas in DML: " + meta.getTables(arg0, arg1, arg2, arg3));
			System.out.println("Table Types: " + meta.getTableTypes());
			
			return conn;
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		MysqlConnectionToern.user = user;
	}
		

}
	


