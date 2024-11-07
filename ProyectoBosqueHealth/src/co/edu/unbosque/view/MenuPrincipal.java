package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame {
	
	private JButton btnPaciente, btnEspecialista, btnDirector;
	private JLabel lblFondo;
	
	public MenuPrincipal() {
		ventana();
		labels();
		botones();
	}
	
	public void ventana() {
        setBounds(50, 50, 950, 535);
        setTitle("Bosque Health");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
	}
	public void labels() {
		lblFondo = new JLabel(new ImageIcon("media\\fondoBosqueHealth.png"));
		setContentPane(lblFondo);
	}
	
	public void botones() {
		ImageIcon btnPacienteImg = new ImageIcon("media\\btnPacienteMenu.png");
        btnPaciente = new JButton(btnPacienteImg);
        btnPaciente.setBounds(260, 174, 375, 63);
        btnPaciente.setBorder(null);
        add(btnPaciente);
        
        ImageIcon btnEspecialistaImg = new ImageIcon("media\\btnEspecialistaMenu.png");
        btnEspecialista = new JButton(btnEspecialistaImg);
        btnEspecialista.setBounds(260, 282, 375, 63);
        btnEspecialista.setBorder(null);
        add(btnEspecialista);
        
        ImageIcon btnDirectorImg = new ImageIcon("media\\btnDirectorMenu.png");
        btnDirector = new JButton(btnDirectorImg);
        btnDirector.setBounds(260, 388, 375, 63);
        btnDirector.setBorder(null);
        add(btnDirector);
	}

	public JButton getBtnPaciente() {
		return btnPaciente;
	}

	public void setBtnPaciente(JButton btnPaciente) {
		this.btnPaciente = btnPaciente;
	}

	public JButton getBtnEspecialista() {
		return btnEspecialista;
	}

	public void setBtnEspecialista(JButton btnEspecialista) {
		this.btnEspecialista = btnEspecialista;
	}

	public JButton getBtnDirector() {
		return btnDirector;
	}

	public void setBtnDirector(JButton btnDirector) {
		this.btnDirector = btnDirector;
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}
	
	

}
