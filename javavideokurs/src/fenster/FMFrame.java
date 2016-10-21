package fenster;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FMFrame extends JFrame {
	
	private JLabel lblHeader;
	private JTable table;
	private JScrollPane scrollTable;
	private JProgressBar progBar;
	private JButton buttonInfo;
	private JButton btnAdd;
	private JLabel lblHersteller, lblLeistung, lblTyp, lblPreis;
	private JTextField fldHersteller;
	private JSpinner spinLeistung, spinPreis;
	private JComboBox boxTyp;
	private int fensterbreite,fensterhoehe;
	
	
	public FMFrame(){
		setTitle("Meine Gui");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(500, 500);
		setLocation(null);
		
		
		createWidgets();
		addWidgets();
		
		setVisible(true);
		
	}
	

	private void createWidgets() {
		
		lblHeader = new JLabel("Mastermind");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD + Font.ITALIC,30));
		lblHeader.setBounds(0, 0, fensterbreite, 30);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.ORANGE);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setOpaque(true);
		// TODO Auto-generated method stub
		
	}
	private void addWidgets() {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
