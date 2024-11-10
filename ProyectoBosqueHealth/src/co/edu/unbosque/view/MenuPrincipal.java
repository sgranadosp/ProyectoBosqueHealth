package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase MenuPrincipal crea una ventana gráfica que representa el menú principal de la aplicación
 * "Bosque Health". Proporciona botones para acceder a diferentes funcionalidades: Paciente,
 * Especialista y Director Médico.
 * 
 * <p>
 * Hereda de la clase {@link JFrame} y utiliza componentes como {@link JButton} y {@link JLabel}.
 * <p>
 * 
 * @author Santiago Granados Pascagaza
 * @version 1.0
 * @since 2024-11-10
 */
public class MenuPrincipal extends JFrame {
	
	private JButton btnPaciente, btnEspecialista, btnDirector;
	private JLabel lblFondo;
	
	 /**
     * Constructor de la clase MenuPrincipal. Ejecuta las funciones ventana, labels y botones.
     */
	public MenuPrincipal() {
		ventana();
		labels();
		botones();
	}
	
	 /**
     * Configura las propiedades de la ventana principal, incluyendo el tamaño, título y comportamiento al cerrar.
     */
	public void ventana() {
        setBounds(50, 50, 950, 535);
        setTitle("Bosque Health");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
	}
	
	 /**
     * Inicializa y establece la imagen de fondo para la ventana utilizando un {@link JLabel}.
     */
	public void labels() {
		lblFondo = new JLabel(new ImageIcon("media\\fondoBosqueHealth.png"));
		setContentPane(lblFondo);
	}
	
	/**
     * Crea e inicializa los botones del menú: Paciente, Especialista y Director.
     * Los botones tienen imágenes personalizadas y no tienen bordes visibles.
     */
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

	/**
     * Obtiene el botón para la sección de Pacientes.
     *
     * @return el botón {@link JButton} para Paciente.
     */
	public JButton getBtnPaciente() {
		return btnPaciente;
	}

	/**
     * Establece el botón para la sección de Pacientes.
     *
     * @param btnPaciente el botón {@link JButton} para Paciente.
     */
	public void setBtnPaciente(JButton btnPaciente) {
		this.btnPaciente = btnPaciente;
	}

	 /**
     * Obtiene el botón para la sección de Especialistas.
     *
     * @return el botón {@link JButton} para Especialista.
     */
	public JButton getBtnEspecialista() {
		return btnEspecialista;
	}

	  /**
     * Establece el botón para la sección de Especialistas.
     *
     * @param btnEspecialista el botón {@link JButton} para Especialista.
     */
	public void setBtnEspecialista(JButton btnEspecialista) {
		this.btnEspecialista = btnEspecialista;
	}

	/**
     * Obtiene el botón para la sección de Directores Médicos.
     *
     * @return el botón {@link JButton} para Director.
     */
	public JButton getBtnDirector() {
		return btnDirector;
	}

	/**
    * Establece el botón para la sección de Directores Médicos.
    *
    * @param btnDirector el botón {@link JButton} para Director.
    */
	public void setBtnDirector(JButton btnDirector) {
		this.btnDirector = btnDirector;
	}

	 /**
     * Obtiene la etiqueta que contiene la imagen de fondo.
     *
     * @return la etiqueta {@link JLabel} de fondo.
     */
	public JLabel getLblFondo() {
		return lblFondo;
	}

	/**
     * Establece la etiqueta que contiene la imagen de fondo.
     *
     * @param lblFondo la etiqueta {@link JLabel} de fondo.
     */
	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

}
