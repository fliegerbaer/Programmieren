package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


/** an immutable table model built from getting 
	metadata about a table in a jdbc database 
	*/
public class JDBCTableModel extends AbstractTableModel {


	Object[][] data;
	String[] columnNames;
	Class[] columnClasses;
	String[]tables;
	private Connection conn;
	private String meinTabellenName;
	private Set<Integer> datachanges=new HashSet<>();//hier werden die veränderten Zeilen gespeichert
	public JDBCTableModel (Connection conn,
			   String tableName)
		throws SQLException {
			super();
			getTableContents (conn, tableName);
			setMeinTabellenName(tableName);
			System.out.println("JDBCTableModel für Tabelle " + tableName + " wurde instanziiert");
			this.conn=conn;
}
	public void updateTableContents() throws SQLException {
		for (Integer row : datachanges) {
			Statement updateStatement = conn.createStatement();
			String updateSQL= "UPDATE "+getMeinTabellenName()+" SET ";
			for (int i = 1; i < columnNames.length; i++) {
				String col = columnNames[i];
				if(columnClasses[i]==String.class){
				updateSQL = updateSQL + col + "="+"´" +data[row][i]+"´"+" ";
				}
				else
				{
				updateSQL = updateSQL + col + "="+ data[row][i]+" ";
				}
			}
			updateSQL=updateSQL+"where "+columnNames[0]+"="+data[row][0]+";";
			System.out.println(updateSQL);
			updateStatement.execute(updateSQL);
			
		}
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
			results.getInt (columnNames[i])); //TODO Prüfen ob Fehler getInt getFloat?
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
	rowList.add (cells);//Zellen werden in die Zeile gefügt
	
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
}//Data Array befüllt
// AbstractTableModel methods
public int getRowCount() {
	return data.length; //Zeilenzahl für Abstract Table Model
}

public int getColumnCount() {//Spaltenzahl für Abstract Table Model
	if (data.length == 0)
		return 0;
	else
		return data[0].length;
	}

	public Object getValueAt (int row, int column) {
		return data [row][column];//holt Wert aus Datenarray für Tabellen Modell für JTable
	}
@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	data[rowIndex][columnIndex]=aValue;//TODO hier Werte prüfen!
	datachanges.add(rowIndex);		
}
@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	return true;
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