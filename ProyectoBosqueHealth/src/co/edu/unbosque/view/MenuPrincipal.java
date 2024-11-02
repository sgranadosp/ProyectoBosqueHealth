package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame{

	private VentanaDirector vDirector;
	private VentanaEspecialista vEspecialista;
	private VentanaPaciente vPaciente;
	
	public MenuPrincipal() {

		setLocation(70, 70);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);

		setTitle("MENU PRINCIPAL");

		ImageIcon logo = new ImageIcon("src/media/LogoUEB.png");
		setIconImage(logo.getImage());

		vDirector = new VentanaDirector();
		vEspecialista = new VentanaEspecialista();
		vPaciente = new VentanaPaciente();

	}
	
	public void mostrarVentanaDirector() {
		setContentPane(vDirector);
	}
	
	public void mostrarVentanaEspecialista() {
		setContentPane(vEspecialista);
	}
	
	public void mostrarVentanaPaciente() {
		setContentPane(vPaciente);
	}

	public VentanaDirector getvDirector() {
		return vDirector;
	}

	public VentanaEspecialista getvEspecialista() {
		return vEspecialista;
	}
	
	public VentanaPaciente getvPaciente() {
		return vPaciente;
	}
	
}
