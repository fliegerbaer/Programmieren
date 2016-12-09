package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


/** an immutable table model built from getting 
	metadata about a table in a jdbc database 
	*/
public class JDBCTableModel extends AbstractTableModel {
	Object[][] data;
	String[] columnNames;
	Class[] columnClasses;
	String[]tables;
	private String meinTabellenName;
	public JDBCTableModel (Connection conn,
			   String tableName){
		setMeinTabellenName(tableName);
		System.out.println("JDBCTableModel für Tabelle " + tableName + " wurde instanziiert");
		
		/*
	for(String tableName:tables){
		throws SQLException {
		super();
		
		return JDBCTableModel getTableContents (conn, tableName);
		}
		//hier kann man das Array befüllen


	}*/
	
}

	
	protected void getTableContents (Connection conn,
				 String tableName)
		throws SQLException {

	// get metadata: what columns exist and what
	// types (classes) are they?
	DatabaseMetaData meta = conn.getMetaData();
	System.out.println ("got meta = " + meta);
	ResultSet results =
		meta.getColumns (null, null, tableName, null) ;
	System.out.println ("got column results");
	ArrayList colNamesList = new ArrayList();
	ArrayList colClassesList = new ArrayList();
	while (results.next()) {
		colNamesList.add (results.getString ("COLUMN_NAME")); 
		System.out.println ("name: " + results.getString ("COLUMN_NAME"));
		int dbType = results.getInt ("DATA_TYPE");
		switch (dbType) {
		case Types.INTEGER:
	colClassesList.add (Integer.class); break; 
		case Types.FLOAT:
	colClassesList.add (Float.class); break; 
		case Types.DOUBLE: 
		case Types.REAL:
	colClassesList.add (Double.class); break; 
		case Types.DATE: 
		case Types.TIME: 
		case Types.TIMESTAMP:
	colClassesList.add (java.sql.Date.class); break; 
		default:
	colClassesList.add (String.class); break; 
		}; 
		System.out.println ("type: " +
			results.getInt ("DATA_TYPE"));
		}
		columnNames = new String [colNamesList.size()];
		colNamesList.toArray (columnNames);
		columnClasses = new Class [colClassesList.size()];
		colClassesList.toArray (columnClasses);
		
		// get all data from table and put into
		// contents array

		Statement statement =
	conn.createStatement ();
		results = statement.executeQuery ("SELECT * FROM " +
					  tableName);
		ArrayList rowList = new ArrayList();
		while (results.next()) {
	ArrayList cellList = new ArrayList(); 
	for (int i = 0; i<columnClasses.length; i++) { 
		Object cellValue = null;


		if (columnClasses[i] == String.class) 
	cellValue = results.getString (columnNames[i]); 
		else if (columnClasses[i] == Integer.class) 
	cellValue = new Integer ( 
			results.getInt (columnNames[i])); 
		else if (columnClasses[i] == Float.class) 
	cellValue = new Float ( 
			results.getInt (columnNames[i])); 
		else if (columnClasses[i] == Double.class) 
	cellValue = new Double ( 
			results.getDouble (columnNames[i]));
		else if (columnClasses[i] == java.sql.Date.class) 
	cellValue = results.getDate (columnNames[i]); 
		else 
	System.out.println ("Can't assign " + 
			columnNames[i]);
		cellList.add (cellValue);
	}// for
	Object[] cells = cellList.toArray();
	rowList.add (cells);
	
} // while
// finally create contents two-dim array
data = new Object[rowList.size()] [];
for (int i=0; i<data.length; i++)

	data[i] = (Object []) rowList.get (i);
System.out.println ("Created model with " +
		   data.length + " rows");

// close stuff
results.close();
statement.close();

}
// AbstractTableModel methods
public int getRowCount() {
	return data.length;
}

public int getColumnCount() {
	if (data.length == 0)
		return 0;
	else
		return data[0].length;
	}

	public Object getValueAt (int row, int column) {
		return data [row][column];
	}

	// overrides methods for which AbstractTableModel
	// has trivial implementations

	public Class getColumnClass (int col) {
		return columnClasses [col];
	}

	public String getColumnName (int col) { 
		return columnNames [col]; 
	}


	/**
	 * @return the meinTabellenName
	 */
	public String getMeinTabellenName() {
		return meinTabellenName;
	}


	/**
	 * @param meinTabellenName the meinTabellenName to set
	 */
	public void setMeinTabellenName(String meinTabellenName) {
		this.meinTabellenName = meinTabellenName;
	} 
}