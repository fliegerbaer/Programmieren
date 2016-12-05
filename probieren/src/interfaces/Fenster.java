package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Fenster extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel listenpanel;
	private JPanel personen;
	private JList list_1;
	private JButton btnNewButton;
	private JList list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster frame = new Fenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tabbedPane);
		
		listenpanel = new JPanel();
		tabbedPane.addTab("Listen", null, listenpanel, null);
		listenpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		list_1 = new JList();
		listenpanel.add(list_1);
		
		btnNewButton = new JButton("New button");
		listenpanel.add(btnNewButton);
		
		personen = new JPanel();
		tabbedPane.addTab("Personen", null, personen, null);
		personen.setLayout(new BorderLayout(0, 0));
		
		list = new JList();
		personen.add(list, BorderLayout.CENTER);
		
		panel = new JPanel();
		personen.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("Neue Person");
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("löschen");
		panel.add(btnNewButton_2);
	}

}
