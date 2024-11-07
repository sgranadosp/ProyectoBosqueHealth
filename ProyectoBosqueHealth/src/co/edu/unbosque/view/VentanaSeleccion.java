package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSeleccion extends JPanel{

	private JLabel imagenPpal;
	private JButton btnPaciente, btnEspecialista, btnDirector;

	public VentanaSeleccion() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		imagenPpal = new JLabel();
		ImageIcon imagen1 = new ImageIcon("media/ImgSeleccion.png");
		Image redimensionado = imagen1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imagenPpal.setIcon(new ImageIcon(redimensionado));
		imagenPpal.setBounds(0, 0, 1280, 720);
		
		btnPaciente = new JButton("Paciente");
		btnPaciente.setBounds(372, 262, 505, 85);
		btnPaciente.setOpaque(false);
		btnPaciente.setActionCommand("PACIENTE");
		btnPaciente.setToolTipText("Gestión para Pacientes");
		
		btnEspecialista = new JButton("Especialista");
		btnEspecialista.setBounds(372, 384, 505, 85);
		btnEspecialista.setOpaque(false);
		btnEspecialista.setActionCommand("ESPECIALISTA");
		btnEspecialista.setToolTipText("Gestión para Especialistas");
		
		btnDirector = new JButton("Director");
		btnDirector.setBounds(372, 507, 505, 85);
		btnDirector.setOpaque(false);
		btnDirector.setActionCommand("DIRECTOR");
		btnDirector.setToolTipText("Gestión para Director Médico");
		
		add(imagenPpal);
		add(btnDirector);
		add(btnEspecialista);
		add(btnPaciente);
		
	}

	public JLabel getImagenPpal() {
		return imagenPpal;
	}

	public JButton getBtnPaciente() {
		return btnPaciente;
	}

	public JButton getBtnEspecialista() {
		return btnEspecialista;
	}

	public JButton getBtnDirector() {
		return btnDirector;
	}
	
}
