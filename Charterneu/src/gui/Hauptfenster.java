package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.JDBCTableModel;
import data.ToernConnection;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JDBCTableModel personen;

	/**
	 * Create the frame.
	 */
	public Hauptfenster(ToernConnection connection) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tabbedPane);

		JPanel pnlBedien = new JPanel();
		contentPane.add(pnlBedien, BorderLayout.SOUTH);

		JButton btnSpeichern = new JButton("Speichern");
		pnlBedien.add(btnSpeichern);

		JButton btnNeuerDatensatz = new JButton("neue Zeile");
		btnNeuerDatensatz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = tabbedPane.getSelectedIndex();
				connection.getTabellen()[selectedTab].addNewRow();

			}
		});
		pnlBedien.add(btnNeuerDatensatz);

		JButton btnDatensatzLoeschen = new JButton("Datensatz löschen");
		btnDatensatzLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Datensatz löschen");
			}
		});
		pnlBedien.add(btnDatensatzLoeschen);

		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = tabbedPane.getSelectedIndex();
				try {
					connection.getTabellen()[selectedTab].updateTableContents();
					connection.getTabellen()[selectedTab].addTableContents();
				} catch (SQLException e1) {
					// TODO Fehler behandeln
					e1.printStackTrace();
				}
			}
		});
		for (int i = 0; i < connection.getTabellen().length; i++) {
			JDBCTableModel tm = connection.getTabellen()[i];

			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			tabbedPane.addTab(tm.getMeinTabellenName(), null, panel, null);
			tabbedPane.setEnabledAt(0, true);
			panel.setLayout(new BorderLayout(0, 0));

			scrollPane = new JScrollPane();
			panel.add(scrollPane);

			table = new JTable();
			table.setGridColor(Color.BLACK);
			table.setBackground(Color.LIGHT_GRAY);
			table.setMinimumSize(new Dimension(1, 1));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBorder(new LineBorder(new Color(255, 255, 255)));
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setFillsViewportHeight(true);
			table.setModel(tm);
			scrollPane.setViewportView(table);
			System.out.println("tabelle gemalt");
			for (int j = 0; j < tm.getColumnCount(); j++) {
				Class columnClass = tm.getColumnClass(j);
				if (columnClass == String.class)
					table.getColumnModel().getColumn(j).setCellEditor(new DefaultCellEditor(new JTextField()));
				else
					table.getColumnModel().getColumn(j).setCellEditor(new DatePickerCellEditor());

			}
		}
	}
}
