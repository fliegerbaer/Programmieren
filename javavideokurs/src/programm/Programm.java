package programm;

import javax.swing.UIManager;

import fenster.FMFrame;

public class Programm {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			e.printStackTrace();
		}
		
		FMFrame frame = new FMFrame("Fenstertitel");
		
		//frame.setResizable(false);//fenster lässt sich in der Größe nicht ändern
		//frame.setTitle("Fenstertitel");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		//
	}

}
