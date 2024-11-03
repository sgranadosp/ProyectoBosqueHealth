package co.edu.unbosque.test;


import javax.swing.JButton;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

public class CalendarTest extends JFrame {

	private JDateChooser fecha;
	private JButton btn;
	
	public CalendarTest() {	
		setSize(600,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializar();
	}
	
	public void inicializar() {
		setLayout(null);
		fecha = new JDateChooser();
		fecha.setBounds(50, 50, 150, 20);
		add(fecha);
	}

	
	public static void main(String[] args) {
		CalendarTest c = new CalendarTest();
		c.setVisible(true);
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
