package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

/**
 * VentanaPaciente es una clase que representa la interfaz gráfica de usuario (GUI) para la gestión de pacientes en un sistema de salud.
 * Permite a los pacientes ver y gestionar sus datos personales, agendar, reagendar y cancelar citas médicas, y gestionar su tratamiento médico.
 * Esta clase extiende JFrame y contiene paneles, campos de texto, botones y comboboxes para interactuar con el usuario.
 * 
 * <p>
 * Hereda de la clase {@link JFrame} y utiliza componentes como {@link JButton}, {@link JLabel} y {@link JComboBox}.
 * <p> 
 * 
 * @author Santiago Granados Pascagaza
 * @version 1.0
 * @since 2024-11-10
 */
public class VentanaPaciente extends JFrame{
	
	private JPanel panelFijoIzq, panelDerechaArriba, panelDatosPaciente, panelAgendarCitas, 
	panelCitasAgendadas,panelReagendarCita, panelCancelarCita, panelTratamientoMedico,
	panelVariableCitas;
	private JTextField txtNombreCompleto, txtNumeroDocumento, txtCorreoElectronico, txtHora, 
	txtNumeroReagendarCita, txtHoraReagendarCita, txtNumeroCancelarCita;
	private JDateChooser fechaAgendarCita, fechaReagendarCita, fechaNacimiento;
	private JComboBox<String> cmbGenero, cmbEspecialidad, cmbEspecialistas;
	private JLabel lblNombreCompleto, lblNumeroDocumento, lblFechaNacimiento, lblCorreo, lblGenero, 
	lblTituloDatosP, lblEspecialidadAgendar, lblEspecialistasAgendar, lblFechaAgendar, lblHoraAgendar, 
	lblNumeroCitaReagendar, lblFechaReagendar, lblHoraReagendar, lblNumeroCitaCancelar, lblTituloTratamientoMedico;
	private JButton btnDatosPersonales, btnCitas, btnTratamientoMedico, btnGuardarDatosP, btnGenerarCita,
	btnAgendarCita, btnCitasAgendadas, btnReagendarCitas, btnCancelarCita, btnGuardarReagendarCita, 
	btnGuardarCancelarCita, btnVolverMenu, btnTooltipPaciente;
	
	private ImageIcon imgBtnDatosPersonales, imgBtnCitas, imgBtnTratamientoMedico,
		imgBtnGuardarDatosPersonales,
		imgBtnAgendarCita, imgBtnCitasAgendadas, imgBtnReagendarCita, imgBtnCancelarCita,
		imgBtnGenerarCita, imgBtnReagendar, imgBtnCancelar, imgBtnVolverMenu, imgBtnToolTip;
	
	private final static String AGENDARCITA = "AgendarCita";
	private final static String CITASAGENDADAS = "CitasAgendadas";
	private final static String REAGENDARCITA = "ReagendarCita";
	private final static String CANCELARCITA = "CancelarCita";
	
	
	CardLayout cardLayout = new CardLayout();
	
	/**
     * Constructor que inicializa la ventana, paneles, etiquetas, campos de texto, botones, 
     * comboboxes y calendario de la interfaz.
     */
	public VentanaPaciente() {
		ventana();
		paneles();
		labels();
		textfield();
		botones();
		comboBox();
		calendar();
		
		getPanelFijoIzq().setVisible(true);
		getPanelDatosPaciente().setVisible(false);
		getPanelDerechaArriba().setVisible(false);
		getPanelTratamientoMedico().setVisible(false);
		getPanelVariableCitas().setVisible(false);
		
		add(panelFijoIzq);
		add(panelVariableCitas);
		add(panelDatosPaciente);
		add(panelDerechaArriba);
		add(panelTratamientoMedico);
	}
	
	 /**
     * Configura los parámetros de la ventana principal.
     */
	public void ventana() {
        setBounds(50, 50, 1000, 561);
        setTitle("Bosque Health");
        getContentPane().setBackground(new Color(78, 175, 93));;
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
	}
	
	 /**
     * Inicializa los paneles de la interfaz de usuario.
     */
	public void paneles() {
		 panelFijoIzq = new JPanel();
		 panelFijoIzq.setLayout(null);
		 panelFijoIzq.setBounds(55, 55, 200, 415);
		 panelFijoIzq.setBackground(Color.white);
		 
		 panelDerechaArriba = new JPanel();
		 panelDerechaArriba.setLayout(null);
		 panelDerechaArriba.setBounds(302, 55, 560, 100);
		 panelDerechaArriba.setBackground(Color.white);
		 
		 panelDatosPaciente = new JPanel();
		 panelDatosPaciente.setLayout(null);
		 panelDatosPaciente.setBounds(302, 156, 560, 315);
		 panelDatosPaciente.setBackground(Color.white);		 
		 
		 panelAgendarCitas = new JPanel();
		 panelAgendarCitas.setLayout(null);
		 panelAgendarCitas.setBounds(302, 156, 560, 315);
		 panelAgendarCitas.setBackground(Color.white);	
		 
		 panelReagendarCita = new JPanel();
		 panelReagendarCita.setLayout(null);
		 panelReagendarCita.setBounds(302, 156, 560, 315);
		 panelReagendarCita.setBackground(Color.white);			 
		 
		 panelCitasAgendadas = new JPanel();
		 panelCitasAgendadas.setLayout(null);
		 panelCitasAgendadas.setBounds(302, 156, 560, 315);
		 panelCitasAgendadas.setBackground(Color.white);			 
		 
		 panelCancelarCita = new JPanel();
		 panelCancelarCita.setLayout(null);
		 panelCancelarCita.setBounds(302, 156, 560, 315);
		 panelCancelarCita.setBackground(Color.white);		 
		 
		 panelTratamientoMedico = new JPanel();
		 panelTratamientoMedico.setLayout(null);
		 panelTratamientoMedico.setBounds(302, 156, 560, 315);
		 panelTratamientoMedico.setBackground(Color.white);			 
	
		 
		 panelVariableCitas = new JPanel(cardLayout);
		 panelVariableCitas.setBounds(302, 156, 560, 315);
		 panelVariableCitas.setBackground(Color.white);
		 panelVariableCitas.add(panelAgendarCitas, AGENDARCITA);
		 panelVariableCitas.add(panelCitasAgendadas, CITASAGENDADAS);
		 panelVariableCitas.add(panelCancelarCita, CANCELARCITA);
		 panelVariableCitas.add(panelReagendarCita, REAGENDARCITA);
		 
	}
	
	/**
     * Inicializa los labels que describen cada campo o sección de la interfaz.
     */
	public void labels() {
		
		//Labels DATOS PERSONALES
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(30, 40, 350, 40);
		panelDerechaArriba.add(lblTituloDatosP);
				
				
		lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreCompleto.setForeground(new Color(78, 175, 93));
		lblNombreCompleto.setBounds(30, 35, 180, 20);
		panelDatosPaciente.add(lblNombreCompleto);

		lblNumeroDocumento = new JLabel("Número de documento:");
		lblNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroDocumento.setForeground(new Color(78, 175, 93));
		lblNumeroDocumento.setBounds(30, 70, 180, 20);
		panelDatosPaciente.add(lblNumeroDocumento);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(new Color(78, 175, 93));
		lblFechaNacimiento.setBounds(30, 105, 180, 20);
		panelDatosPaciente.add(lblFechaNacimiento);

		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCorreo.setForeground(new Color(78, 175, 93));
		lblCorreo.setBounds(30, 140, 180, 20);
		panelDatosPaciente.add(lblCorreo);
		
		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(30, 175, 180, 20);
		panelDatosPaciente.add(lblGenero);

		
		//Labels CITAS - AGENDAR CITA
		lblEspecialidadAgendar = new JLabel("Especialidad:");
		lblEspecialidadAgendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialidadAgendar.setForeground(new Color(78, 175, 93));
		lblEspecialidadAgendar.setBounds(30, 35, 180, 20);
		panelAgendarCitas.add(lblEspecialidadAgendar);

		lblEspecialistasAgendar = new JLabel("Especialistas:");
		lblEspecialistasAgendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialistasAgendar.setForeground(new Color(78, 175, 93));
		lblEspecialistasAgendar.setBounds(30, 70, 180, 20);
		panelAgendarCitas.add(lblEspecialistasAgendar);

		lblFechaAgendar = new JLabel("Fecha:");
		lblFechaAgendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaAgendar.setForeground(new Color(78, 175, 93));
		lblFechaAgendar.setBounds(30, 105, 180, 20);
		panelAgendarCitas.add(lblFechaAgendar);

		lblHoraAgendar = new JLabel("Hora:");
		lblHoraAgendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblHoraAgendar.setForeground(new Color(78, 175, 93));
		lblHoraAgendar.setBounds(30, 140, 180, 20);
		panelAgendarCitas.add(lblHoraAgendar);

		
		//Labels CITAS - REAGENDAR CITA

		
		lblFechaReagendar = new JLabel("Fecha:");
		lblFechaReagendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaReagendar.setForeground(new Color(78, 175, 93));
		lblFechaReagendar.setBounds(30, 70, 180, 20);
		panelReagendarCita.add(lblFechaReagendar);

		lblHoraReagendar = new JLabel("Hora:");
		lblHoraReagendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblHoraReagendar.setForeground(new Color(78, 175, 93));
		lblHoraReagendar.setBounds(30, 105, 180, 20);
		panelReagendarCita.add(lblHoraReagendar);
	
		lblNumeroCitaReagendar = new JLabel("Número de cita:");
		lblNumeroCitaReagendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroCitaReagendar.setForeground(new Color(78, 175, 93));
		lblNumeroCitaReagendar.setBounds(30, 35, 180, 20);
		//panelReagendarCita.add(lblNumeroCitaReagendar);
		panelReagendarCita.add(lblNumeroCitaReagendar);
		

		//Labels CITAS - CANCELAR CITA
		lblNumeroCitaCancelar = new JLabel("Número de cita:");
		lblNumeroCitaCancelar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroCitaCancelar.setForeground(new Color(78, 175, 93));
		lblNumeroCitaCancelar.setBounds(30, 35, 180, 20);
		panelCancelarCita.add(lblNumeroCitaCancelar);
		
		
		//Labels CITAS - TRATAMIENTO MEDICO
		lblTituloTratamientoMedico = new JLabel("Tratamiento médico");
		lblTituloTratamientoMedico.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloTratamientoMedico.setForeground(new Color(78, 175, 93));
		lblTituloTratamientoMedico.setBounds(30, 40, 350, 40);
		panelDerechaArriba.add(lblTituloTratamientoMedico);

		
	}
	
	/**
     * Inicializa los campos de texto utilizados en la interfaz.
     */
	public void textfield() {
		//TextFields Datos personales
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNombreCompleto.setBounds(240, 35, 200, 20);
		panelDatosPaciente.add(txtNombreCompleto);	

		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNumeroDocumento.setBounds(240, 70, 200, 20);
		panelDatosPaciente.add(txtNumeroDocumento);
	
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtCorreoElectronico.setBounds(240, 140, 200, 20);
		panelDatosPaciente.add(txtCorreoElectronico);
		
		//TextFields Citas - Agendar
		txtHora = new JTextField();
		txtHora.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtHora.setBounds(240, 140, 200, 20);
		panelAgendarCitas.add(txtHora);

		//TextFields Citas - Reagendar
		txtNumeroReagendarCita = new JTextField();
		txtNumeroReagendarCita.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNumeroReagendarCita.setBounds(240, 35, 200, 20);
		panelReagendarCita.add(txtNumeroReagendarCita);

		txtHoraReagendarCita = new JTextField();
		txtHoraReagendarCita.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtHoraReagendarCita.setBounds(240, 105, 200, 20);
		panelReagendarCita.add(txtHoraReagendarCita);

		//TextFields Citas - Cancelar
		txtNumeroCancelarCita = new JTextField();
		txtNumeroCancelarCita.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNumeroCancelarCita.setBounds(240, 35, 200, 20);
		panelCancelarCita.add(txtNumeroCancelarCita);
		
	}
	
	/**
     * Inicializa los botones de la interfaz.
     */
	public void botones() {
		//BOTONES DE MENU IZQUIERDA
		imgBtnDatosPersonales = new ImageIcon("media\\btnDatosPersonalesP.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnDatosPersonales = new JButton(imgBtnDatosPersonales);
		btnDatosPersonales.setBorder(null);
		btnDatosPersonales.setBounds(5, 50, 190, 35);
		panelFijoIzq.add(btnDatosPersonales);

		imgBtnCitas = new ImageIcon("media\\btnCitasP.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnCitas = new JButton(imgBtnCitas);
		btnCitas.setBorder(null);
		btnCitas.setBounds(5, 100, 190, 35);
		panelFijoIzq.add(btnCitas);

		imgBtnTratamientoMedico = new ImageIcon("media\\btnTratamientoMedicoP.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnTratamientoMedico = new JButton(imgBtnTratamientoMedico);
		btnTratamientoMedico.setBorder(null);
		btnTratamientoMedico.setBounds(5, 150, 190, 35);
		panelFijoIzq.add(btnTratamientoMedico);
		
		//BOTONES DE Datos personales
		imgBtnGuardarDatosPersonales = new ImageIcon("media\\btnGuardarDatosPerP.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGuardarDatosP = new JButton(imgBtnGuardarDatosPersonales);
		btnGuardarDatosP.setBorder(null);
		btnGuardarDatosP.setBounds(200, 250, 150, 26);
		panelDatosPaciente.add(btnGuardarDatosP);

		//BOTONES DE CITAS - panel Derecha Arriba
		imgBtnAgendarCita = new ImageIcon("media\\btnAgendarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnAgendarCita = new JButton(imgBtnAgendarCita);
		btnAgendarCita.setBorder(null);
		btnAgendarCita.setBounds(70, 5, 199, 38);
		panelDerechaArriba.add(btnAgendarCita);

		imgBtnCitasAgendadas = new ImageIcon("media\\btnCitasAgendadas.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnCitasAgendadas = new JButton(imgBtnCitasAgendadas);
		btnCitasAgendadas.setBorder(null);
		btnCitasAgendadas.setBounds(320, 5, 199, 38);
		panelDerechaArriba.add(btnCitasAgendadas);
		
		imgBtnReagendarCita = new ImageIcon("media\\btnReagendarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnReagendarCitas = new JButton(imgBtnReagendarCita);
		btnReagendarCitas.setBorder(null);
		btnReagendarCitas.setBounds(70, 60, 199, 38);
		panelDerechaArriba.add(btnReagendarCitas);
		
		imgBtnCancelarCita =  new ImageIcon("media\\btnCancelarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnCancelarCita = new JButton(imgBtnCancelarCita);
		btnCancelarCita.setBorder(null);
		btnCancelarCita.setBounds(320, 60, 199, 38);
		panelDerechaArriba.add(btnCancelarCita);
		
	
		// botón Generar cita (Agendar cita)
		imgBtnGenerarCita = new ImageIcon("media\\btnGuardargGenerarCita2.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGenerarCita = new JButton(imgBtnGenerarCita);
		btnGenerarCita.setBorder(null);
		btnGenerarCita.setBounds(145,250, 229, 27);
		panelAgendarCitas.add(btnGenerarCita);

		
		// botón Reagendar (Reagendar cita)
		imgBtnReagendar = new ImageIcon("media\\btnGuardarReagendarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGuardarReagendarCita = new JButton(imgBtnReagendar);
		btnGuardarReagendarCita.setBorder(null);
		btnGuardarReagendarCita.setBounds(145,250, 229, 27);
		panelReagendarCita.add(btnGuardarReagendarCita);

		// botón Cancelar (Cancelar cita)
		imgBtnCancelar = new ImageIcon("media\\btnGuardarCancelarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGuardarCancelarCita = new JButton(imgBtnCancelar);
		btnGuardarCancelarCita.setBorder(null);
		btnGuardarCancelarCita.setBounds(145,250, 229, 27);
		panelCancelarCita.add(btnGuardarCancelarCita);
		
		//boton menu principal
		imgBtnVolverMenu = new ImageIcon("media\\btnVolverMenu.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnVolverMenu = new JButton(imgBtnVolverMenu);
		btnVolverMenu.setBorder(null);
		btnVolverMenu.setBounds(800, 475, 174, 40);
		add(btnVolverMenu);
		
		imgBtnToolTip = new ImageIcon("media\\btnToolTipPaciente.png");
		btnTooltipPaciente = new JButton(imgBtnToolTip);
		btnTooltipPaciente.setBorder(null);
		btnTooltipPaciente.setBounds(915, 2, 68, 68);
		btnTooltipPaciente.setToolTipText("Panel de gestión para pacientes");
		add(btnTooltipPaciente);
		
	}
	
	/**
     * Inicializa los comboboxes que permiten seleccionar opciones.
     */
	public void comboBox() {
		//Combos Datos personales
		cmbGenero = new JComboBox<String>();
		cmbGenero.setBounds(240, 175, 200, 20);
		cmbGenero.setToolTipText("Género del paciente");
		cmbGenero.addItem("");
		cmbGenero.addItem("Masculino");
		cmbGenero.addItem("Femenino");
		panelDatosPaciente.add(cmbGenero);
		
		//Combos Citas
		cmbEspecialidad = new JComboBox<String>();
		cmbEspecialidad.setBounds(240, 35, 200, 20);
		cmbEspecialidad.setToolTipText("Especialidad");
		cmbEspecialidad.addItem("");
		cmbEspecialidad.addItem("Cirugía");
		cmbEspecialidad.addItem("Oncología");
		cmbEspecialidad.addItem("Dermatología");
		cmbEspecialidad.addItem("Neumología");
		cmbEspecialidad.addItem("Cardiología");
		cmbEspecialidad.addItem("Medicina Interna");
		panelAgendarCitas.add(cmbEspecialidad);
		
		cmbEspecialistas = new JComboBox<String>();
		cmbEspecialistas.setBounds(240, 70, 200, 20);
		cmbEspecialistas.setToolTipText("Especialistas para la especialidad seleccionada");	
		panelAgendarCitas.add(cmbEspecialistas);
		
	}
	
	/**
     * Inicializa los calendarios (componentes JDateChooser) para seleccionar fechas.
     */
	public void calendar() {
		
		//Calendar en datos personales
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(240, 105, 200, 20);
		panelDatosPaciente.add(fechaNacimiento);
		
		//Calendar en agendar cita
		fechaAgendarCita = new JDateChooser();
		fechaAgendarCita.setBounds(240, 105, 200, 20);
		panelAgendarCitas.add(fechaAgendarCita);
		
		//Calendar en reagendar cita
		fechaReagendarCita = new JDateChooser();
		fechaReagendarCita.setBounds(240, 70, 200, 20);
		panelReagendarCita.add(fechaReagendarCita);
		
	}


	/**
	 * Obtiene el panel de la izquierda fijo.
	 *
	 * @return el panel de la izquierda fijo.
	 */
	public JPanel getPanelFijoIzq() {
	    return panelFijoIzq;
	}

	/**
	 * Establece el panel de la izquierda fijo.
	 *
	 * @param panelFijoIzq el nuevo panel de la izquierda fijo.
	 */
	public void setPanelFijoIzq(JPanel panelFijoIzq) {
	    this.panelFijoIzq = panelFijoIzq;
	}

	/**
	 * Obtiene el panel de la parte superior derecha.
	 *
	 * @return el panel de la parte superior derecha.
	 */
	public JPanel getPanelDerechaArriba() {
	    return panelDerechaArriba;
	}

	/**
	 * Establece el panel de la parte superior derecha.
	 *
	 * @param panelDerechaArriba el nuevo panel de la parte superior derecha.
	 */
	public void setPanelDerechaArriba(JPanel panelDerechaArriba) {
	    this.panelDerechaArriba = panelDerechaArriba;
	}

	/**
	 * Obtiene el panel de datos del paciente.
	 *
	 * @return el panel de datos del paciente.
	 */
	public JPanel getPanelDatosPaciente() {
	    return panelDatosPaciente;
	}

	/**
	 * Establece el panel de datos del paciente.
	 *
	 * @param panelDatosPaciente el nuevo panel de datos del paciente.
	 */
	public void setPanelDatosPaciente(JPanel panelDatosPaciente) {
	    this.panelDatosPaciente = panelDatosPaciente;
	}

	/**
	 * Obtiene el panel para agendar citas.
	 *
	 * @return el panel para agendar citas.
	 */
	public JPanel getPanelAgendarCitas() {
	    return panelAgendarCitas;
	}

	/**
	 * Establece el panel para agendar citas.
	 *
	 * @param panelAgendarCitas el nuevo panel para agendar citas.
	 */
	public void setPanelAgendarCitas(JPanel panelAgendarCitas) {
	    this.panelAgendarCitas = panelAgendarCitas;
	}

	/**
	 * Obtiene el panel de citas agendadas.
	 *
	 * @return el panel de citas agendadas.
	 */
	public JPanel getPanelCitasAgendadas() {
	    return panelCitasAgendadas;
	}

	/**
	 * Establece el panel de citas agendadas.
	 *
	 * @param panelCitasAgendadas el nuevo panel de citas agendadas.
	 */
	public void setPanelCitasAgendadas(JPanel panelCitasAgendadas) {
	    this.panelCitasAgendadas = panelCitasAgendadas;
	}

	/**
	 * Obtiene el panel para reagendar una cita.
	 *
	 * @return el panel para reagendar una cita.
	 */
	public JPanel getPanelReagendarCita() {
	    return panelReagendarCita;
	}

	/**
	 * Establece el panel para reagendar una cita.
	 *
	 * @param panelReagendarCita el nuevo panel para reagendar una cita.
	 */
	public void setPanelReagendarCita(JPanel panelReagendarCita) {
	    this.panelReagendarCita = panelReagendarCita;
	}

	/**
	 * Obtiene el panel para cancelar una cita.
	 *
	 * @return el panel para cancelar una cita.
	 */
	public JPanel getPanelCancelarCita() {
	    return panelCancelarCita;
	}

	/**
	 * Establece el panel para cancelar una cita.
	 *
	 * @param panelCancelarCita el nuevo panel para cancelar una cita.
	 */
	public void setPanelCancelarCita(JPanel panelCancelarCita) {
	    this.panelCancelarCita = panelCancelarCita;
	}

	/**
	 * Obtiene el panel de tratamiento médico.
	 *
	 * @return el panel de tratamiento médico.
	 */
	public JPanel getPanelTratamientoMedico() {
	    return panelTratamientoMedico;
	}

	/**
	 * Establece el panel de tratamiento médico.
	 *
	 * @param panelTratamientoMedico el nuevo panel de tratamiento médico.
	 */
	public void setPanelTratamientoMedico(JPanel panelTratamientoMedico) {
	    this.panelTratamientoMedico = panelTratamientoMedico;
	}

	/**
	 * Obtiene el panel para las variables de citas.
	 *
	 * @return el panel para las variables de citas.
	 */
	public JPanel getPanelVariableCitas() {
	    return panelVariableCitas;
	}

	/**
	 * Establece el panel para las variables de citas.
	 *
	 * @param panelVariableCitas el nuevo panel para las variables de citas.
	 */
	public void setPanelVariableCitas(JPanel panelVariableCitas) {
	    this.panelVariableCitas = panelVariableCitas;
	}


	/**
	 * Obtiene el campo de texto para el nombre completo.
	 *
	 * @return el campo de texto para el nombre completo.
	 */
	public JTextField getTxtNombreCompleto() {
	    return txtNombreCompleto;
	}

	/**
	 * Establece el campo de texto para el nombre completo.
	 *
	 * @param txtNombreCompleto el nuevo campo de texto para el nombre completo.
	 */
	public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
	    this.txtNombreCompleto = txtNombreCompleto;
	}

	/**
	 * Obtiene el campo de texto para el número de documento.
	 *
	 * @return el campo de texto para el número de documento.
	 */
	public JTextField getTxtNumeroDocumento() {
	    return txtNumeroDocumento;
	}

	/**
	 * Establece el campo de texto para el número de documento.
	 *
	 * @param txtNumeroDocumento el nuevo campo de texto para el número de documento.
	 */
	public void setTxtNumeroDocumento(JTextField txtNumeroDocumento) {
	    this.txtNumeroDocumento = txtNumeroDocumento;
	}

	/**
	 * Obtiene el campo de texto para el correo electrónico.
	 *
	 * @return el campo de texto para el correo electrónico.
	 */
	public JTextField getTxtCorreoElectronico() {
	    return txtCorreoElectronico;
	}

	/**
	 * Establece el campo de texto para el correo electrónico.
	 *
	 * @param txtCorreoElectronico el nuevo campo de texto para el correo electrónico.
	 */
	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
	    this.txtCorreoElectronico = txtCorreoElectronico;
	}

	/**
	 * Obtiene el campo de texto para la hora.
	 *
	 * @return el campo de texto para la hora.
	 */
	public JTextField getTxtHora() {
	    return txtHora;
	}

	/**
	 * Establece el campo de texto para la hora.
	 *
	 * @param txtHora el nuevo campo de texto para la hora.
	 */
	public void setTxtHora(JTextField txtHora) {
	    this.txtHora = txtHora;
	}

	/**
	 * Obtiene el campo de texto para el número de la cita a reagendar.
	 *
	 * @return el campo de texto para el número de la cita a reagendar.
	 */
	public JTextField getTxtNumeroReagendarCita() {
	    return txtNumeroReagendarCita;
	}

	/**
	 * Establece el campo de texto para el número de la cita a reagendar.
	 *
	 * @param txtNumeroReagendarCita el nuevo campo de texto para el número de la cita a reagendar.
	 */
	public void setTxtNumeroReagendarCita(JTextField txtNumeroReagendarCita) {
	    this.txtNumeroReagendarCita = txtNumeroReagendarCita;
	}

	/**
	 * Obtiene el campo de texto para la hora de la cita a reagendar.
	 *
	 * @return el campo de texto para la hora de la cita a reagendar.
	 */
	public JTextField getTxtHoraReagendarCita() {
	    return txtHoraReagendarCita;
	}

	/**
	 * Establece el campo de texto para la hora de la cita a reagendar.
	 *
	 * @param txtHoraReagendarCita el nuevo campo de texto para la hora de la cita a reagendar.
	 */
	public void setTxtHoraReagendarCita(JTextField txtHoraReagendarCita) {
	    this.txtHoraReagendarCita = txtHoraReagendarCita;
	}

	/**
	 * Obtiene el campo de texto para el número de la cita a cancelar.
	 *
	 * @return el campo de texto para el número de la cita a cancelar.
	 */
	public JTextField getTxtNumeroCancelarCita() {
	    return txtNumeroCancelarCita;
	}

	/**
	 * Establece el campo de texto para el número de la cita a cancelar.
	 *
	 * @param txtNumeroCancelarCita el nuevo campo de texto para el número de la cita a cancelar.
	 */
	public void setTxtNumeroCancelarCita(JTextField txtNumeroCancelarCita) {
	    this.txtNumeroCancelarCita = txtNumeroCancelarCita;
	}


	/**
	 * Obtiene el selector de fecha para agendar una cita.
	 *
	 * @return el selector de fecha para agendar una cita.
	 */
	public JDateChooser getFechaAgendarCita() {
	    return fechaAgendarCita;
	}

	/**
	 * Establece el selector de fecha para agendar una cita.
	 *
	 * @param fechaAgendarCita el nuevo selector de fecha para agendar una cita.
	 */
	public void setFechaAgendarCita(JDateChooser fechaAgendarCita) {
	    this.fechaAgendarCita = fechaAgendarCita;
	}

	/**
	 * Obtiene el selector de fecha para reagendar una cita.
	 *
	 * @return el selector de fecha para reagendar una cita.
	 */
	public JDateChooser getFechaReagendarCita() {
	    return fechaReagendarCita;
	}

	/**
	 * Establece el selector de fecha para reagendar una cita.
	 *
	 * @param fechaReagendarCita el nuevo selector de fecha para reagendar una cita.
	 */
	public void setFechaReagendarCita(JDateChooser fechaReagendarCita) {
	    this.fechaReagendarCita = fechaReagendarCita;
	}

	/**
	 * Obtiene el selector de fecha de nacimiento del paciente.
	 *
	 * @return el selector de fecha de nacimiento.
	 */
	public JDateChooser getFechaNacimiento() {
	    return fechaNacimiento;
	}

	/**
	 * Establece el selector de fecha de nacimiento del paciente.
	 *
	 * @param fechaNacimiento el nuevo selector de fecha de nacimiento.
	 */
	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
	    this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene el combo box para seleccionar el género.
	 *
	 * @return el combo box para seleccionar el género.
	 */
	public JComboBox<String> getCmbGenero() {
	    return cmbGenero;
	}

	/**
	 * Establece el combo box para seleccionar el género.
	 *
	 * @param cmbGenero el nuevo combo box para seleccionar el género.
	 */
	public void setCmbGenero(JComboBox<String> cmbGenero) {
	    this.cmbGenero = cmbGenero;
	}

	/**
	 * Obtiene el combo box para seleccionar la especialidad.
	 *
	 * @return el combo box para seleccionar la especialidad.
	 */
	public JComboBox<String> getCmbEspecialidad() {
	    return cmbEspecialidad;
	}

	/**
	 * Establece el combo box para seleccionar la especialidad.
	 *
	 * @param cmbEspecialidad el nuevo combo box para seleccionar la especialidad.
	 */
	public void setCmbEspecialidad(JComboBox<String> cmbEspecialidad) {
	    this.cmbEspecialidad = cmbEspecialidad;
	}

	/**
	 * Obtiene el combo box para seleccionar el especialista.
	 *
	 * @return el combo box para seleccionar el especialista.
	 */
	public JComboBox<String> getCmbEspecialistas() {
	    return cmbEspecialistas;
	}

	/**
	 * Establece el combo box para seleccionar el especialista.
	 *
	 * @param cmbEspecialistas el nuevo combo box para seleccionar el especialista.
	 */
	public void setCmbEspecialistas(JComboBox<String> cmbEspecialistas) {
	    this.cmbEspecialistas = cmbEspecialistas;
	}

	/**
	 * Obtiene la etiqueta para el nombre completo.
	 *
	 * @return la etiqueta para el nombre completo.
	 */
	public JLabel getLblNombreCompleto() {
	    return lblNombreCompleto;
	}

	/**
	 * Establece la etiqueta para el nombre completo.
	 *
	 * @param lblNombreCompleto la nueva etiqueta para el nombre completo.
	 */
	public void setLblNombreCompleto(JLabel lblNombreCompleto) {
	    this.lblNombreCompleto = lblNombreCompleto;
	}

	/**
	 * Obtiene la etiqueta para el número de documento.
	 *
	 * @return la etiqueta para el número de documento.
	 */
	public JLabel getLblNumeroDocumento() {
	    return lblNumeroDocumento;
	}

	/**
	 * Establece la etiqueta para el número de documento.
	 *
	 * @param lblNumeroDocumento la nueva etiqueta para el número de documento.
	 */
	public void setLblNumeroDocumento(JLabel lblNumeroDocumento) {
	    this.lblNumeroDocumento = lblNumeroDocumento;
	}

	/**
	 * Obtiene la etiqueta para la fecha de nacimiento.
	 *
	 * @return la etiqueta para la fecha de nacimiento.
	 */
	public JLabel getLblFechaNacimiento() {
	    return lblFechaNacimiento;
	}

	/**
	 * Establece la etiqueta para la fecha de nacimiento.
	 *
	 * @param lblFechaNacimiento la nueva etiqueta para la fecha de nacimiento.
	 */
	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
	    this.lblFechaNacimiento = lblFechaNacimiento;
	}

	/**
	 * Obtiene la etiqueta para el correo electrónico.
	 *
	 * @return la etiqueta para el correo electrónico.
	 */
	public JLabel getLblCorreo() {
	    return lblCorreo;
	}

	/**
	 * Establece la etiqueta para el correo electrónico.
	 *
	 * @param lblCorreo la nueva etiqueta para el correo electrónico.
	 */
	public void setLblCorreo(JLabel lblCorreo) {
	    this.lblCorreo = lblCorreo;
	}

	/**
	 * Obtiene la etiqueta para el género.
	 *
	 * @return la etiqueta para el género.
	 */
	public JLabel getLblGenero() {
	    return lblGenero;
	}

	/**
	 * Establece la etiqueta para el género.
	 *
	 * @param lblGenero la nueva etiqueta para el género.
	 */
	public void setLblGenero(JLabel lblGenero) {
	    this.lblGenero = lblGenero;
	}

	/**
	 * Obtiene la etiqueta para el título de datos personales.
	 *
	 * @return la etiqueta para el título de datos personales.
	 */
	public JLabel getLblTituloDatosP() {
	    return lblTituloDatosP;
	}

	/**
	 * Establece la etiqueta para el título de datos personales.
	 *
	 * @param lblTituloDatosP la nueva etiqueta para el título de datos personales.
	 */
	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
	    this.lblTituloDatosP = lblTituloDatosP;
	}

	/**
	 * Obtiene la etiqueta para la especialidad al agendar cita.
	 *
	 * @return la etiqueta para la especialidad al agendar cita.
	 */
	public JLabel getLblEspecialidadAgendar() {
	    return lblEspecialidadAgendar;
	}

	/**
	 * Establece la etiqueta para la especialidad al agendar cita.
	 *
	 * @param lblEspecialidadAgendar la nueva etiqueta para la especialidad al agendar cita.
	 */
	public void setLblEspecialidadAgendar(JLabel lblEspecialidadAgendar) {
	    this.lblEspecialidadAgendar = lblEspecialidadAgendar;
	}

	/**
	 * Obtiene la etiqueta para los especialistas al agendar cita.
	 *
	 * @return la etiqueta para los especialistas al agendar cita.
	 */
	public JLabel getLblEspecialistasAgendar() {
	    return lblEspecialistasAgendar;
	}

	/**
	 * Establece la etiqueta para los especialistas al agendar cita.
	 *
	 * @param lblEspecialistasAgendar la nueva etiqueta para los especialistas al agendar cita.
	 */
	public void setLblEspecialistasAgendar(JLabel lblEspecialistasAgendar) {
	    this.lblEspecialistasAgendar = lblEspecialistasAgendar;
	}

	/**
	 * Obtiene la etiqueta para la fecha al agendar cita.
	 *
	 * @return la etiqueta para la fecha al agendar cita.
	 */
	public JLabel getLblFechaAgendar() {
	    return lblFechaAgendar;
	}

	/**
	 * Establece la etiqueta para la fecha al agendar cita.
	 *
	 * @param lblFechaAgendar la nueva etiqueta para la fecha al agendar cita.
	 */
	public void setLblFechaAgendar(JLabel lblFechaAgendar) {
	    this.lblFechaAgendar = lblFechaAgendar;
	}

	/**
	 * Obtiene la etiqueta para la hora al agendar cita.
	 *
	 * @return la etiqueta para la hora al agendar cita.
	 */
	public JLabel getLblHoraAgendar() {
	    return lblHoraAgendar;
	}

	/**
	 * Establece la etiqueta para la hora al agendar cita.
	 *
	 * @param lblHoraAgendar la nueva etiqueta para la hora al agendar cita.
	 */
	public void setLblHoraAgendar(JLabel lblHoraAgendar) {
	    this.lblHoraAgendar = lblHoraAgendar;
	}

	/**
	 * Obtiene la etiqueta para el número de cita al reagendar.
	 *
	 * @return la etiqueta para el número de cita al reagendar.
	 */
	public JLabel getLblNumeroCitaReagendar() {
	    return lblNumeroCitaReagendar;
	}

	/**
	 * Establece la etiqueta para el número de cita al reagendar.
	 *
	 * @param lblNumeroCitaReagendar la nueva etiqueta para el número de cita al reagendar.
	 */
	public void setLblNumeroCitaReagendar(JLabel lblNumeroCitaReagendar) {
	    this.lblNumeroCitaReagendar = lblNumeroCitaReagendar;
	}

	/**
	 * Obtiene la etiqueta para la fecha al reagendar cita.
	 *
	 * @return la etiqueta para la fecha al reagendar cita.
	 */
	public JLabel getLblFechaReagendar() {
	    return lblFechaReagendar;
	}

	/**
	 * Establece la etiqueta para la fecha al reagendar cita.
	 *
	 * @param lblFechaReagendar la nueva etiqueta para la fecha al reagendar cita.
	 */
	public void setLblFechaReagendar(JLabel lblFechaReagendar) {
	    this.lblFechaReagendar = lblFechaReagendar;
	}

	/**
	 * Obtiene la etiqueta para la hora al reagendar cita.
	 *
	 * @return la etiqueta para la hora al reagendar cita.
	 */
	public JLabel getLblHoraReagendar() {
	    return lblHoraReagendar;
	}

	/**
	 * Establece la etiqueta para la hora al reagendar cita.
	 *
	 * @param lblHoraReagendar la nueva etiqueta para la hora al reagendar cita.
	 */
	public void setLblHoraReagendar(JLabel lblHoraReagendar) {
	    this.lblHoraReagendar = lblHoraReagendar;
	}

	/**
	 * Obtiene la etiqueta para el número de cita al cancelar.
	 *
	 * @return la etiqueta para el número de cita al cancelar.
	 */
	public JLabel getLblNumeroCitaCancelar() {
	    return lblNumeroCitaCancelar;
	}

	/**
	 * Establece la etiqueta para el número de cita al cancelar.
	 *
	 * @param lblNumeroCitaCancelar la nueva etiqueta para el número de cita al cancelar.
	 */
	public void setLblNumeroCitaCancelar(JLabel lblNumeroCitaCancelar) {
	    this.lblNumeroCitaCancelar = lblNumeroCitaCancelar;
	}

	/**
	 * Obtiene la etiqueta para el título del tratamiento médico.
	 *
	 * @return la etiqueta para el título del tratamiento médico.
	 */
	public JLabel getLblTituloTratamientoMedico() {
	    return lblTituloTratamientoMedico;
	}

	/**
	 * Establece la etiqueta para el título del tratamiento médico.
	 *
	 * @param lblTituloTratamientoMedico la nueva etiqueta para el título del tratamiento médico.
	 */
	public void setLblTituloTratamientoMedico(JLabel lblTituloTratamientoMedico) {
	    this.lblTituloTratamientoMedico = lblTituloTratamientoMedico;
	}

	/**
	 * Obtiene el botón para los datos personales.
	 *
	 * @return el botón para los datos personales.
	 */
	public JButton getBtnDatosPersonales() {
	    return btnDatosPersonales;
	}

	/**
	 * Establece el botón para los datos personales.
	 *
	 * @param btnDatosPersonales el nuevo botón para los datos personales.
	 */
	public void setBtnDatosPersonales(JButton btnDatosPersonales) {
	    this.btnDatosPersonales = btnDatosPersonales;
	}

	/**
	 * Obtiene el botón para acceder a las citas.
	 *
	 * @return el botón para acceder a las citas.
	 */
	public JButton getBtnCitas() {
	    return btnCitas;
	}

	/**
	 * Establece el botón para acceder a las citas.
	 *
	 * @param btnCitas el nuevo botón para acceder a las citas.
	 */
	public void setBtnCitas(JButton btnCitas) {
	    this.btnCitas = btnCitas;
	}

	/**
	 * Obtiene el botón para acceder al tratamiento médico.
	 *
	 * @return el botón para acceder al tratamiento médico.
	 */
	public JButton getBtnTratamientoMedico() {
	    return btnTratamientoMedico;
	}

	/**
	 * Establece el botón para acceder al tratamiento médico.
	 *
	 * @param btnTratamientoMedico el nuevo botón para acceder al tratamiento médico.
	 */
	public void setBtnTratamientoMedico(JButton btnTratamientoMedico) {
	    this.btnTratamientoMedico = btnTratamientoMedico;
	}

	/**
	 * Obtiene el botón para guardar los datos personales.
	 *
	 * @return el botón para guardar los datos personales.
	 */
	public JButton getBtnGuardarDatosP() {
	    return btnGuardarDatosP;
	}

	/**
	 * Establece el botón para guardar los datos personales.
	 *
	 * @param btnGuardarDatosP el nuevo botón para guardar los datos personales.
	 */
	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
	    this.btnGuardarDatosP = btnGuardarDatosP;
	}

	/**
	 * Obtiene el botón para generar la cita.
	 *
	 * @return el botón para generar la cita.
	 */
	public JButton getBtnGenerarCita() {
	    return btnGenerarCita;
	}

	/**
	 * Establece el botón para generar la cita.
	 *
	 * @param btnGenerarCita el nuevo botón para generar la cita.
	 */
	public void setBtnGenerarCita(JButton btnGenerarCita) {
	    this.btnGenerarCita = btnGenerarCita;
	}

	/**
	 * Obtiene el botón para agendar una cita.
	 *
	 * @return el botón para agendar una cita.
	 */
	public JButton getBtnAgendarCita() {
	    return btnAgendarCita;
	}

	/**
	 * Establece el botón para agendar una cita.
	 *
	 * @param btnAgendarCita el nuevo botón para agendar una cita.
	 */
	public void setBtnAgendarCita(JButton btnAgendarCita) {
	    this.btnAgendarCita = btnAgendarCita;
	}

	/**
	 * Obtiene el botón para ver las citas agendadas.
	 *
	 * @return el botón para ver las citas agendadas.
	 */
	public JButton getBtnCitasAgendadas() {
	    return btnCitasAgendadas;
	}

	/**
	 * Establece el botón para ver las citas agendadas.
	 *
	 * @param btnCitasAgendadas el nuevo botón para ver las citas agendadas.
	 */
	public void setBtnCitasAgendadas(JButton btnCitasAgendadas) {
	    this.btnCitasAgendadas = btnCitasAgendadas;
	}

	/**
	 * Obtiene el botón para reagendar una cita.
	 *
	 * @return el botón para reagendar una cita.
	 */
	public JButton getBtnReagendarCitas() {
	    return btnReagendarCitas;
	}

	/**
	 * Establece el botón para reagendar una cita.
	 *
	 * @param btnReagendarCitas el nuevo botón para reagendar una cita.
	 */
	public void setBtnReagendarCitas(JButton btnReagendarCitas) {
	    this.btnReagendarCitas = btnReagendarCitas;
	}

	/**
	 * Obtiene el botón para cancelar una cita.
	 *
	 * @return el botón para cancelar una cita.
	 */
	public JButton getBtnCancelarCita() {
	    return btnCancelarCita;
	}

	/**
	 * Establece el botón para cancelar una cita.
	 *
	 * @param btnCancelarCita el nuevo botón para cancelar una cita.
	 */
	public void setBtnCancelarCita(JButton btnCancelarCita) {
	    this.btnCancelarCita = btnCancelarCita;
	}

	/**
	 * Obtiene el botón para guardar los cambios al reagendar una cita.
	 *
	 * @return el botón para guardar los cambios al reagendar una cita.
	 */
	public JButton getBtnGuardarReagendarCita() {
	    return btnGuardarReagendarCita;
	}

	/**
	 * Establece el botón para guardar los cambios al reagendar una cita.
	 *
	 * @param btnGuardarReagendarCita el nuevo botón para guardar los cambios al reagendar una cita.
	 */
	public void setBtnGuardarReagendarCita(JButton btnGuardarReagendarCita) {
	    this.btnGuardarReagendarCita = btnGuardarReagendarCita;
	}

	/**
	 * Obtiene el botón para guardar los cambios al cancelar una cita.
	 *
	 * @return el botón para guardar los cambios al cancelar una cita.
	 */
	public JButton getBtnGuardarCancelarCita() {
	    return btnGuardarCancelarCita;
	}

	/**
	 * Establece el botón para guardar los cambios al cancelar una cita.
	 *
	 * @param btnGuardarCancelarCita el nuevo botón para guardar los cambios al cancelar una cita.
	 */
	public void setBtnGuardarCancelarCita(JButton btnGuardarCancelarCita) {
	    this.btnGuardarCancelarCita = btnGuardarCancelarCita;
	}

	/**
	 * Obtiene el botón para volver al menú.
	 *
	 * @return el botón para volver al menú.
	 */
	public JButton getBtnVolverMenu() {
	    return btnVolverMenu;
	}

	/**
	 * Establece el botón para volver al menú.
	 *
	 * @param btnVolverMenu el nuevo botón para volver al menú.
	 */
	public void setBtnVolverMenu(JButton btnVolverMenu) {
	    this.btnVolverMenu = btnVolverMenu;
	}

	/**
	 * Obtiene el botón para mostrar el tooltip del paciente.
	 *
	 * @return el botón para mostrar el tooltip del paciente.
	 */
	public JButton getBtnTooltipPaciente() {
	    return btnTooltipPaciente;
	}

	/**
	 * Establece el botón para mostrar el tooltip del paciente.
	 *
	 * @param btnTooltipPaciente el nuevo botón para mostrar el tooltip del paciente.
	 */
	public void setBtnTooltipPaciente(JButton btnTooltipPaciente) {
	    this.btnTooltipPaciente = btnTooltipPaciente;
	}

	/**
	 * Obtiene la imagen del botón de datos personales.
	 *
	 * @return la imagen del botón de datos personales.
	 */
	public ImageIcon getImgBtnDatosPersonales() {
	    return imgBtnDatosPersonales;
	}

	/**
	 * Establece la imagen del botón de datos personales.
	 *
	 * @param imgBtnDatosPersonales la nueva imagen del botón de datos personales.
	 */
	public void setImgBtnDatosPersonales(ImageIcon imgBtnDatosPersonales) {
	    this.imgBtnDatosPersonales = imgBtnDatosPersonales;
	}

	/**
	 * Obtiene la imagen del botón de citas.
	 *
	 * @return la imagen del botón de citas.
	 */
	public ImageIcon getImgBtnCitas() {
	    return imgBtnCitas;
	}

	/**
	 * Establece la imagen del botón de citas.
	 *
	 * @param imgBtnCitas la nueva imagen del botón de citas.
	 */
	public void setImgBtnCitas(ImageIcon imgBtnCitas) {
	    this.imgBtnCitas = imgBtnCitas;
	}

	/**
	 * Obtiene la imagen del botón de tratamiento médico.
	 *
	 * @return la imagen del botón de tratamiento médico.
	 */
	public ImageIcon getImgBtnTratamientoMedico() {
	    return imgBtnTratamientoMedico;
	}

	/**
	 * Establece la imagen del botón de tratamiento médico.
	 *
	 * @param imgBtnTratamientoMedico la nueva imagen del botón de tratamiento médico.
	 */
	public void setImgBtnTratamientoMedico(ImageIcon imgBtnTratamientoMedico) {
	    this.imgBtnTratamientoMedico = imgBtnTratamientoMedico;
	}

	/**
	 * Obtiene la imagen del botón para guardar los datos personales.
	 *
	 * @return la imagen del botón para guardar los datos personales.
	 */
	public ImageIcon getImgBtnGuardarDatosPersonales() {
	    return imgBtnGuardarDatosPersonales;
	}

	/**
	 * Establece la imagen del botón para guardar los datos personales.
	 *
	 * @param imgBtnGuardarDatosPersonales la nueva imagen del botón para guardar los datos personales.
	 */
	public void setImgBtnGuardarDatosPersonales(ImageIcon imgBtnGuardarDatosPersonales) {
	    this.imgBtnGuardarDatosPersonales = imgBtnGuardarDatosPersonales;
	}

	/**
	 * Obtiene la imagen del botón para agendar una cita.
	 *
	 * @return la imagen del botón para agendar una cita.
	 */
	public ImageIcon getImgBtnAgendarCita() {
	    return imgBtnAgendarCita;
	}

	/**
	 * Establece la imagen del botón para agendar una cita.
	 *
	 * @param imgBtnAgendarCita la nueva imagen del botón para agendar una cita.
	 */
	public void setImgBtnAgendarCita(ImageIcon imgBtnAgendarCita) {
	    this.imgBtnAgendarCita = imgBtnAgendarCita;
	}

	/**
	 * Obtiene la imagen del botón para ver las citas agendadas.
	 *
	 * @return la imagen del botón para ver las citas agendadas.
	 */
	public ImageIcon getImgBtnCitasAgendadas() {
	    return imgBtnCitasAgendadas;
	}

	/**
	 * Establece la imagen del botón para ver las citas agendadas.
	 *
	 * @param imgBtnCitasAgendadas la nueva imagen del botón para ver las citas agendadas.
	 */
	public void setImgBtnCitasAgendadas(ImageIcon imgBtnCitasAgendadas) {
	    this.imgBtnCitasAgendadas = imgBtnCitasAgendadas;
	}

	/**
	 * Obtiene la imagen del botón para reagendar una cita.
	 *
	 * @return la imagen del botón para reagendar una cita.
	 */
	public ImageIcon getImgBtnReagendarCita() {
	    return imgBtnReagendarCita;
	}

	/**
	 * Establece la imagen del botón para reagendar una cita.
	 *
	 * @param imgBtnReagendarCita la nueva imagen del botón para reagendar una cita.
	 */
	public void setImgBtnReagendarCita(ImageIcon imgBtnReagendarCita) {
	    this.imgBtnReagendarCita = imgBtnReagendarCita;
	}

	/**
	 * Obtiene la imagen del botón para cancelar una cita.
	 *
	 * @return la imagen del botón para cancelar una cita.
	 */
	public ImageIcon getImgBtnCancelarCita() {
	    return imgBtnCancelarCita;
	}

	/**
	 * Establece la imagen del botón para cancelar una cita.
	 *
	 * @param imgBtnCancelarCita la nueva imagen del botón para cancelar una cita.
	 */
	public void setImgBtnCancelarCita(ImageIcon imgBtnCancelarCita) {
	    this.imgBtnCancelarCita = imgBtnCancelarCita;
	}

	/**
	 * Obtiene la imagen del botón para generar una cita.
	 *
	 * @return la imagen del botón para generar una cita.
	 */
	public ImageIcon getImgBtnGenerarCita() {
	    return imgBtnGenerarCita;
	}

	/**
	 * Establece la imagen del botón para generar una cita.
	 *
	 * @param imgBtnGenerarCita la nueva imagen del botón para generar una cita.
	 */
	public void setImgBtnGenerarCita(ImageIcon imgBtnGenerarCita) {
	    this.imgBtnGenerarCita = imgBtnGenerarCita;
	}

	/**
	 * Obtiene la imagen del botón para reagendar.
	 *
	 * @return la imagen del botón para reagendar.
	 */
	public ImageIcon getImgBtnReagendar() {
	    return imgBtnReagendar;
	}

	/**
	 * Establece la imagen del botón para reagendar.
	 *
	 * @param imgBtnReagendar la nueva imagen del botón para reagendar.
	 */
	public void setImgBtnReagendar(ImageIcon imgBtnReagendar) {
	    this.imgBtnReagendar = imgBtnReagendar;
	}

	/**
	 * Obtiene la imagen del botón para cancelar.
	 *
	 * @return la imagen del botón para cancelar.
	 */
	public ImageIcon getImgBtnCancelar() {
	    return imgBtnCancelar;
	}

	/**
	 * Establece la imagen del botón para cancelar.
	 *
	 * @param imgBtnCancelar la nueva imagen del botón para cancelar.
	 */
	public void setImgBtnCancelar(ImageIcon imgBtnCancelar) {
	    this.imgBtnCancelar = imgBtnCancelar;
	}

	/**
	 * Obtiene la imagen del botón para volver al menú.
	 *
	 * @return la imagen del botón para volver al menú.
	 */
	public ImageIcon getImgBtnVolverMenu() {
	    return imgBtnVolverMenu;
	}

	/**
	 * Establece la imagen del botón para volver al menú.
	 *
	 * @param imgBtnVolverMenu la nueva imagen del botón para volver al menú.
	 */
	public void setImgBtnVolverMenu(ImageIcon imgBtnVolverMenu) {
	    this.imgBtnVolverMenu = imgBtnVolverMenu;
	}

	/**
	 * Obtiene la imagen del botón para mostrar el tooltip.
	 *
	 * @return la imagen del botón para mostrar el tooltip.
	 */
	public ImageIcon getImgBtnToolTip() {
	    return imgBtnToolTip;
	}

	/**
	 * Establece la imagen del botón para mostrar el tooltip.
	 *
	 * @param imgBtnToolTip la nueva imagen del botón para mostrar el tooltip.
	 */
	public void setImgBtnToolTip(ImageIcon imgBtnToolTip) {
	    this.imgBtnToolTip = imgBtnToolTip;
	}

	/**
	 * Obtiene el objeto CardLayout utilizado para la gestión de paneles.
	 *
	 * @return el objeto CardLayout utilizado para la gestión de paneles.
	 */
	public CardLayout getCardLayout() {
	    return cardLayout;
	}

	/**
	 * Establece el objeto CardLayout utilizado para la gestión de paneles.
	 *
	 * @param cardLayout el nuevo objeto CardLayout utilizado para la gestión de paneles.
	 */
	public void setCardLayout(CardLayout cardLayout) {
	    this.cardLayout = cardLayout;
	}


	/**
	 * Obtiene el valor de la constante AGENDARCITA.
	 *
	 * @return el valor de la constante AGENDARCITA.
	 */
	public static String getAgendarcita() {
	    return AGENDARCITA;
	}

	/**
	 * Obtiene el valor de la constante CITASAGENDADAS.
	 *
	 * @return el valor de la constante CITASAGENDADAS.
	 */
	public static String getCitasagendadas() {
	    return CITASAGENDADAS;
	}

	/**
	 * Obtiene el valor de la constante REAGENDARCITA.
	 *
	 * @return el valor de la constante REAGENDARCITA.
	 */
	public static String getReagendarcita() {
	    return REAGENDARCITA;
	}

	/**
	 * Obtiene el valor de la constante CANCELARCITA.
	 *
	 * @return el valor de la constante CANCELARCITA.
	 */
	public static String getCancelarcita() {
	    return CANCELARCITA;
	}

	
}
