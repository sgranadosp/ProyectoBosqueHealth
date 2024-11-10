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
 * La clase VentanaEspecialista representa la interfaz gráfica para la gestión de
 * especialistas médicos.
 * 
 * Esta ventana permite al usuario registrar datos personales del especialista, 
 * gestionar citas médicas, cambiar turnos, asignar tratamientos a pacientes y 
 * visualizar una lista de tratamientos.
 * 
 * La clase utiliza varios paneles para organizar las diferentes secciones del sistema.
 * 
 * <ul>
 * <li>Datos Personales</li>
 * <li>Citas Médicas</li>
 * <li>Turnos del Mes</li>
 * <li>Cambio de Turnos</li>
 * <li>Tratamiento de Pacientes</li>
 * <li>Lista de Tratamientos</li>
 * </ul>
 * 
 * Se utiliza un diseño basado en `CardLayout` para cambiar entre los paneles dinámicamente.
 * 
 * @author Santiago Granados Pascagaza
 * @version 1.0
 * @since 2024-11-09
 */
public class VentanaEspecialista extends JFrame {
	
	private JPanel panelFijoIzq, panelDerechaArriba, panelDatosEspecialista, panelCitasMedicas, 
	panelTurnoMes, panelCambioTurno, panelTratamientoP, panelListaTratamiento, panelVariableTurno;
	private JTextField txtNombreCompleto, txtNumeroDocumento, txtCorreoElectronico, txtExamenP, 
	txtDiagnosticoP, txtTratamientoP;
	private JDateChooser fechaNacimiento, fechaTratamientoP;
	private JComboBox<String> cmbGenero, cmbEspecialidadDP, cmbFechaTurno, cmbEspecialistaActual,
	cmbNuevoEspecialista, cmbEscogerPaciente;
	private JLabel lblNombreCompleto, lblNumeroDocumento, lblFechaNacimiento, lblCorreo, lblGenero, 
	lblEspecialidad, lblTituloDatosP, lblTituloCitasMe, lblFechaTurno, lblEspecialistaActu, 
	lblNuevoEspecialista, lblTituloTratamientoPaciente, lblFechaTratamientoPaciente, lblEscogerPaciente,
	lblExamenPaciente, lblDiagnosticoPaciente, lblTratamientoPaciente, lblTituloListaTratamientos;
	private JButton btnDatosPersonales, btnCitas, btnTurno, btnTratamientoPaciente, btnListaTratamientos,
	btnGuardarDatosP, btnTurnosMes, btnCambioTurno, btnGenerarCambioTurno, btnGuardarTratamiento, btnVolverMenu
	, btnTooltipEspecialista;
	private ImageIcon imgBtnDatos, imgBtnCitas, imgBtnTurnos, imgBtnTratamiento, imgBtnListaTratamientos, imgBtnVolver
	, imgBtnGuardarDatos, imgBtnTurnosMes, imgBtnCambioTurno, imgBtnConfirmarCambio, imgBtnGuardarTratamiento, imgBtnToolTip;
	
	private final static String TURNOSMES = "Turnos del Mes";
	private final static String CAMBIOTURNO = "Cambio Turno";
	
	CardLayout cardLayout = new CardLayout();
	
	 /**
     * Constructor que inicializa la ventana y sus componentes gráficos.
     */
	public VentanaEspecialista() {
		ventana();
		paneles();
		labels();
		textfield();
		botones();
		comboBox();
		calendar();
		
		getPanelFijoIzq().setVisible(true);
		getPanelDerechaArriba().setVisible(false);
		getPanelDatosEspecialista().setVisible(false);
		getPanelCitasMedicas().setVisible(false);
		getPanelTurnoMes().setVisible(false);
		getPanelCambioTurno().setVisible(false);
		getPanelTratamientoP().setVisible(false);
		getPanelListaTratamiento().setVisible(false);
		getPanelVariableTurno().setVisible(false);
		
		add(panelFijoIzq);
		add(panelDerechaArriba);
		add(panelDatosEspecialista);
		add(panelCitasMedicas);
		add(panelTratamientoP);
		add(panelListaTratamiento);
		add(panelVariableTurno);
	}

	 /**
     * Configura las propiedades principales de la ventana.
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
     * Inicializa y configura los paneles utilizados en la interfaz.
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
		
		panelDatosEspecialista = new JPanel();
		panelDatosEspecialista.setLayout(null);
		panelDatosEspecialista.setBounds(302, 156, 560, 315);
		panelDatosEspecialista.setBackground(Color.white);	
		
		panelCitasMedicas = new JPanel();
		panelCitasMedicas.setLayout(null);
		panelCitasMedicas.setBounds(302, 156, 560, 315);
		panelCitasMedicas.setBackground(Color.white);
		
		panelTurnoMes = new JPanel();
		panelTurnoMes.setLayout(null);
		panelTurnoMes.setBounds(302, 156, 560, 315);
		panelTurnoMes.setBackground(Color.white);
		
		panelCambioTurno = new JPanel();
		panelCambioTurno.setLayout(null);
		panelCambioTurno.setBounds(302, 156, 560, 315);
		panelCambioTurno.setBackground(Color.white);
		
		panelVariableTurno = new JPanel(cardLayout);
		panelVariableTurno.setBounds(302, 156, 560, 315);
		panelVariableTurno.setBackground(Color.white);
		panelVariableTurno.add(panelTurnoMes, TURNOSMES);
		panelVariableTurno.add(panelCambioTurno, CAMBIOTURNO);
		
		panelTratamientoP = new JPanel();
		panelTratamientoP.setLayout(null);
		panelTratamientoP.setBounds(302, 156, 560, 315);
		panelTratamientoP.setBackground(Color.white);
		
		panelListaTratamiento = new JPanel();
		panelListaTratamiento.setLayout(null);
		panelListaTratamiento.setBounds(302, 156, 560, 315);
		panelListaTratamiento.setBackground(Color.white);
		
	}

	/**
     * Configura los componentes `JLabel` que se utilizarán en la ventana.
     */
	public void labels() {
	
		//Labels DATOS PERSONALES
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(154, 40, 280, 40);
		panelDerechaArriba.add(lblTituloDatosP);
		
		lblNombreCompleto = new JLabel("Nombre especialista:");
		lblNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreCompleto.setForeground(new Color(78, 175, 93));
		lblNombreCompleto.setBounds(13, 14, 176, 20);
		panelDatosEspecialista.add(lblNombreCompleto);
		
		lblNumeroDocumento = new JLabel("Documento del especialista:");
		lblNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroDocumento.setForeground(new Color(78, 175, 93));
		lblNumeroDocumento.setBounds(13, 58, 176, 20);
		panelDatosEspecialista.add(lblNumeroDocumento);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento del especialista:");
		lblFechaNacimiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(new Color(78, 175, 93));
		lblFechaNacimiento.setBounds(13, 100, 176, 20);
		panelDatosEspecialista.add(lblFechaNacimiento);
		
		lblCorreo = new JLabel("Correo del especialista:");
		lblCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCorreo.setForeground(new Color(78, 175, 93));
		lblCorreo.setBounds(13, 142, 176, 20);
		panelDatosEspecialista.add(lblCorreo);
		
		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(13, 184, 176, 20);
		panelDatosEspecialista.add(lblGenero);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialidad.setForeground(new Color(78, 175, 93));
		lblEspecialidad.setBounds(13, 226, 176, 20);
		panelDatosEspecialista.add(lblEspecialidad);
		
		//Label CITAS
		lblTituloCitasMe = new JLabel("Citas médicas");
		lblTituloCitasMe.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloCitasMe.setForeground(new Color(78, 175, 93));
		lblTituloCitasMe.setBounds(154, 40, 220, 40);
		panelDerechaArriba.add(lblTituloCitasMe);
		
		//LabelS TURNOS
		
		lblFechaTurno = new JLabel("Fecha del turno:");
		lblFechaTurno.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaTurno.setForeground(new Color(78, 175, 93));
		lblFechaTurno.setBounds(42, 41, 122, 20);
		panelCambioTurno.add(lblFechaTurno);
		
		lblEspecialistaActu = new JLabel("Especialista Actual:");
		lblEspecialistaActu.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialistaActu.setForeground(new Color(78, 175, 93));
		lblEspecialistaActu.setBounds(49, 136, 180, 40);
		panelCambioTurno.add(lblEspecialistaActu);
		
		lblNuevoEspecialista = new JLabel("Nuevo Especialista:");
		lblNuevoEspecialista.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNuevoEspecialista.setForeground(new Color(78, 175, 93));
		lblNuevoEspecialista.setBounds(303, 136, 180, 40);
		panelCambioTurno.add(lblNuevoEspecialista);
		
		//Labels TRATAMIENTO
		lblTituloTratamientoPaciente = new JLabel("Tramiento del paciente");
		lblTituloTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblTituloTratamientoPaciente.setBounds(90, 40, 350, 40);
		panelDerechaArriba.add(lblTituloTratamientoPaciente);
		
		lblFechaTratamientoPaciente = new JLabel("Fecha:");
		lblFechaTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblFechaTratamientoPaciente.setBounds(22, 10, 130, 20);
		panelTratamientoP.add(lblFechaTratamientoPaciente);
		
		lblEscogerPaciente = new JLabel("Escoger paciente:");
		lblEscogerPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEscogerPaciente.setForeground(new Color(78, 175, 93));
		lblEscogerPaciente.setBounds(22, 52, 130, 20);
		panelTratamientoP.add(lblEscogerPaciente);
		
		lblExamenPaciente = new JLabel("Examen:");
		lblExamenPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblExamenPaciente.setForeground(new Color(78, 175, 93));
		lblExamenPaciente.setBounds(22, 92, 130, 20);
		panelTratamientoP.add(lblExamenPaciente);
		
		lblDiagnosticoPaciente = new JLabel("Diagnostico:");
		lblDiagnosticoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblDiagnosticoPaciente.setForeground(new Color(78, 175, 93));
		lblDiagnosticoPaciente.setBounds(22, 132, 130, 20);
		panelTratamientoP.add(lblDiagnosticoPaciente);
		
		lblTratamientoPaciente = new JLabel("Tratamiento");
		lblTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblTratamientoPaciente.setBounds(22, 172, 130, 20);
		panelTratamientoP.add(lblTratamientoPaciente);
		
		//Label LISTA DE TRATAMIENTOS
		lblTituloListaTratamientos = new JLabel("Lista de Tratamientos");
		lblTituloListaTratamientos.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloListaTratamientos.setForeground(new Color(78, 175, 93));
		lblTituloListaTratamientos.setBounds(120, 40, 300, 40);
		panelDerechaArriba.add(lblTituloListaTratamientos);
			
	}

	/**
     * Configura los componentes `JTextField` que permiten la entrada de datos.
     */
	public void textfield() {
		
		//Textfields DATOS PERSONALES
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNombreCompleto.setBounds(204, 10, 185, 20);
		panelDatosEspecialista.add(txtNombreCompleto);	
		
		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNumeroDocumento.setBounds(204, 53, 185, 20);
		panelDatosEspecialista.add(txtNumeroDocumento);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtCorreoElectronico.setBounds(204, 139, 185, 20);
		panelDatosEspecialista.add(txtCorreoElectronico);
		
		//Textfields TRATAMIENTO PACIENTE
		txtExamenP = new JTextField();
		txtExamenP.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtExamenP.setBounds(164, 92, 338, 25);
		panelTratamientoP.add(txtExamenP);
		
		txtDiagnosticoP = new JTextField();
		txtDiagnosticoP.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtDiagnosticoP.setBounds(164, 132, 338, 25);
		panelTratamientoP.add(txtDiagnosticoP);
		
		txtTratamientoP = new JTextField();
		txtTratamientoP.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtTratamientoP.setBounds(164, 172, 338, 45);
		panelTratamientoP.add(txtTratamientoP);
	}

	/**
     * Configura los botones y sus acciones en la interfaz.
     */
	public void botones() {
		
		//BOYTONES PANEL IZQUIERDO
		imgBtnDatos = new ImageIcon("media\\btnDatosPersonalesP.png");
		btnDatosPersonales = new JButton(imgBtnDatos);
		btnDatosPersonales.setBorder(null);
		btnDatosPersonales.setBounds(3, 38, 193, 30);
		panelFijoIzq.add(btnDatosPersonales);
		
		imgBtnCitas = new ImageIcon("media\\btnCitasP.png");
		btnCitas = new JButton(imgBtnCitas);
		btnCitas.setBorder(null);
		btnCitas.setBounds(3, 100, 193, 30);
		panelFijoIzq.add(btnCitas);
		
		imgBtnTurnos = new ImageIcon("media\\btnTurnosEsp.png");
		btnTurno = new JButton(imgBtnTurnos);
		btnTurno.setBorder(null);
		btnTurno.setBounds(3, 162, 193, 30);
		panelFijoIzq.add(btnTurno);
		
		imgBtnTratamiento = new ImageIcon("media\\btnTratamientoEsp.png");
		btnTratamientoPaciente = new JButton(imgBtnTratamiento);
		btnTratamientoPaciente.setBorder(null);
		btnTratamientoPaciente.setBounds(3, 224, 193, 30);
		panelFijoIzq.add(btnTratamientoPaciente);
		
		imgBtnListaTratamientos = new ImageIcon("media\\btnListaTratamientos.png");
		btnListaTratamientos = new JButton(imgBtnListaTratamientos);
		btnListaTratamientos.setBorder(null);
		btnListaTratamientos.setBounds(3, 286, 193, 30);
		panelFijoIzq.add(btnListaTratamientos);
		
		
		//Botón DATOS PERSONALES
		imgBtnGuardarDatos = new ImageIcon("media\\btnGuardarDatosEsp.png");
		btnGuardarDatosP = new JButton(imgBtnGuardarDatos);
		btnGuardarDatosP.setBorder(null);
		btnGuardarDatosP.setBounds(220, 260, 152, 27);
		panelDatosEspecialista.add(btnGuardarDatosP);
		
		//Botones TURNOS
		imgBtnTurnosMes = new ImageIcon("media\\btnTurnosMes.png");
		btnTurnosMes = new JButton(imgBtnTurnosMes);
		btnTurnosMes.setBorder(null);
		btnTurnosMes.setBounds(42, 32, 200, 40);
		panelDerechaArriba.add(btnTurnosMes);
		
		imgBtnCambioTurno = new ImageIcon("media\\btnCambioTurno.png");	
		btnCambioTurno = new JButton(imgBtnCambioTurno);
		btnCambioTurno.setBorder(null);
		btnCambioTurno.setBounds(298, 32, 200, 40);
		panelDerechaArriba.add(btnCambioTurno);
		
		imgBtnConfirmarCambio = new ImageIcon("media\\btnGuardarCambioTurno.png");
		btnGenerarCambioTurno = new JButton(imgBtnConfirmarCambio);
		btnGenerarCambioTurno.setBorder(null);
		btnGenerarCambioTurno.setBounds(151, 233, 228, 28);
		panelCambioTurno.add(btnGenerarCambioTurno);
		
		//Botón TRATAMIENTO
		imgBtnGuardarTratamiento = new ImageIcon("media\\btnGuardarTratamiento.png");
		btnGuardarTratamiento = new JButton(imgBtnGuardarTratamiento);
		btnGuardarTratamiento.setBorder(null);
		btnGuardarTratamiento.setBounds(151, 250, 228, 28);
		panelTratamientoP.add(btnGuardarTratamiento);
		
		//Botón volver al menú principal----------------------------------------------------
		imgBtnVolver = new ImageIcon("media\\btnVolverMenu.png");
		btnVolverMenu = new JButton(imgBtnVolver);
		btnVolverMenu.setBorder(null);
		btnVolverMenu.setBounds(800, 475, 174, 40);
		add(btnVolverMenu);
		
		imgBtnToolTip = new ImageIcon("media\\btnToolTipEspecialista.png");
		btnTooltipEspecialista = new JButton(imgBtnToolTip);
		btnTooltipEspecialista.setBorder(null);
		btnTooltipEspecialista.setBounds(915, 2, 68, 68);
		btnTooltipEspecialista.setToolTipText("Panel de gestión para especialistas médicos");
		add(btnTooltipEspecialista);
	}

	/**
     * Configura los `JComboBox` que permiten seleccionar opciones.
     */
	public void comboBox() {
		
		//Combobox DATOS ESPECIALISTA
		cmbGenero = new JComboBox<String>();
		cmbGenero.setBounds(204, 182, 185, 20);
		cmbGenero.setToolTipText("Género del especialista");
		cmbGenero.addItem("");
		cmbGenero.addItem("Masculino");
		cmbGenero.addItem("Femenino");
		panelDatosEspecialista.add(cmbGenero);
		
		cmbEspecialidadDP = new JComboBox<String>();
		cmbEspecialidadDP.setBounds(204, 225, 185, 20);
		cmbEspecialidadDP.setToolTipText("Especialidad");
		cmbEspecialidadDP.addItem("");
		cmbEspecialidadDP.addItem("Cirugía");
		cmbEspecialidadDP.addItem("Oncología");
		cmbEspecialidadDP.addItem("Dermatología");
		cmbEspecialidadDP.addItem("Neumología");
		cmbEspecialidadDP.addItem("Cardiología");
		cmbEspecialidadDP.addItem("Medicina Interna");
		panelDatosEspecialista.add(cmbEspecialidadDP);
		
		//Combobox CAMBIO DE TURNO
		cmbFechaTurno = new JComboBox<String>();
		cmbFechaTurno.setBounds(174, 44, 185, 25);
		cmbFechaTurno.setToolTipText("Fecha del turno");
		cmbFechaTurno.addItem("");
		panelCambioTurno.add(cmbFechaTurno);
		
		cmbEspecialistaActual = new JComboBox<String>();
		cmbEspecialistaActual.setBounds(49, 171, 185, 25);
		cmbEspecialistaActual.setToolTipText("Especialista actual asignado");
		cmbEspecialistaActual.addItem("");
		panelCambioTurno.add(cmbEspecialistaActual);
		
		cmbNuevoEspecialista = new JComboBox<>();
		cmbNuevoEspecialista.setBounds(303, 171, 185, 25);
		cmbNuevoEspecialista.setToolTipText("Especialista nuevo");
		cmbNuevoEspecialista.addItem("");
		panelCambioTurno.add(cmbNuevoEspecialista);
		
		//Combobox TRATAMIENTO
		cmbEscogerPaciente = new JComboBox<String>();
		cmbEscogerPaciente.setBounds(164, 52, 338, 25);
		cmbEscogerPaciente.setToolTipText("Escoger paciente a atender");
		cmbEscogerPaciente.addItem("");
		panelTratamientoP.add(cmbEscogerPaciente);
		
	}

	 /**
     * Configura los calendarios utilizados para seleccionar fechas.
     */
	public void calendar() {
		
		//Calendar fecha de nacimiento del especialista
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(204, 96, 185, 20);
		panelDatosEspecialista.add(fechaNacimiento);
		
		//Calendar fecha para programar el tratamiento
		fechaTratamientoP = new JDateChooser();
		fechaTratamientoP.setBounds(164, 12, 338, 25);
		panelTratamientoP.add(fechaTratamientoP);
		
	}

	/**
	 * Obtiene el panel fijo izquierdo.
	 * 
	 * @return El panel fijo izquierdo.
	 */
	public JPanel getPanelFijoIzq() {
	    return panelFijoIzq;
	}

	/**
	 * Establece el panel fijo izquierdo.
	 * 
	 * @param panelFijoIzq El nuevo panel fijo izquierdo.
	 */
	public void setPanelFijoIzq(JPanel panelFijoIzq) {
	    this.panelFijoIzq = panelFijoIzq;
	}

	/**
	 * Obtiene el panel superior derecho.
	 * 
	 * @return El panel superior derecho.
	 */
	public JPanel getPanelDerechaArriba() {
	    return panelDerechaArriba;
	}

	/**
	 * Establece el panel superior derecho.
	 * 
	 * @param panelDerechaArriba El nuevo panel superior derecho.
	 */
	public void setPanelDerechaArriba(JPanel panelDerechaArriba) {
	    this.panelDerechaArriba = panelDerechaArriba;
	}

	/**
	 * Obtiene el panel de datos del especialista.
	 * 
	 * @return El panel de datos del especialista.
	 */
	public JPanel getPanelDatosEspecialista() {
	    return panelDatosEspecialista;
	}

	/**
	 * Establece el panel de datos del especialista.
	 * 
	 * @param panelDatosEspecialista El nuevo panel de datos del especialista.
	 */
	public void setPanelDatosEspecialista(JPanel panelDatosEspecialista) {
	    this.panelDatosEspecialista = panelDatosEspecialista;
	}

	/**
	 * Obtiene el panel de citas médicas.
	 * 
	 * @return El panel de citas médicas.
	 */
	public JPanel getPanelCitasMedicas() {
	    return panelCitasMedicas;
	}

	/**
	 * Establece el panel de citas médicas.
	 * 
	 * @param panelCitasMedicas El nuevo panel de citas médicas.
	 */
	public void setPanelCitasMedicas(JPanel panelCitasMedicas) {
	    this.panelCitasMedicas = panelCitasMedicas;
	}

	/**
	 * Obtiene el panel que muestra el turno del mes.
	 * 
	 * @return El panel que muestra el turno del mes.
	 */
	public JPanel getPanelTurnoMes() {
	    return panelTurnoMes;
	}

	/**
	 * Establece el panel que muestra el turno del mes.
	 * 
	 * @param panelTurnoMes El nuevo panel que muestra el turno del mes.
	 */
	public void setPanelTurnoMes(JPanel panelTurnoMes) {
	    this.panelTurnoMes = panelTurnoMes;
	}

	/**
	 * Obtiene el panel para cambiar el turno.
	 * 
	 * @return El panel para cambiar el turno.
	 */
	public JPanel getPanelCambioTurno() {
	    return panelCambioTurno;
	}

	/**
	 * Establece el panel para cambiar el turno.
	 * 
	 * @param panelCambioTurno El nuevo panel para cambiar el turno.
	 */
	public void setPanelCambioTurno(JPanel panelCambioTurno) {
	    this.panelCambioTurno = panelCambioTurno;
	}

	/**
	 * Obtiene el panel del tratamiento específico.
	 * 
	 * @return El panel del tratamiento específico.
	 */
	public JPanel getPanelTratamientoP() {
	    return panelTratamientoP;
	}

	/**
	 * Establece el panel del tratamiento específico.
	 * 
	 * @param panelTratamientoP El nuevo panel del tratamiento específico.
	 */
	public void setPanelTratamientoP(JPanel panelTratamientoP) {
	    this.panelTratamientoP = panelTratamientoP;
	}

	/**
	 * Obtiene el panel que lista los tratamientos.
	 * 
	 * @return El panel que lista los tratamientos.
	 */
	public JPanel getPanelListaTratamiento() {
	    return panelListaTratamiento;
	}

	/**
	 * Establece el panel que lista los tratamientos.
	 * 
	 * @param panelListaTratamiento El nuevo panel que lista los tratamientos.
	 */
	public void setPanelListaTratamiento(JPanel panelListaTratamiento) {
	    this.panelListaTratamiento = panelListaTratamiento;
	}

	/**
	 * Obtiene el panel para turnos variables.
	 * 
	 * @return El panel para turnos variables.
	 */
	public JPanel getPanelVariableTurno() {
	    return panelVariableTurno;
	}

	/**
	 * Establece el panel para turnos variables.
	 * 
	 * @param panelVariableTurno El nuevo panel para turnos variables.
	 */
	public void setPanelVariableTurno(JPanel panelVariableTurno) {
	    this.panelVariableTurno = panelVariableTurno;
	}

	/**
	 * Obtiene el campo de texto para el nombre completo.
	 * 
	 * @return El campo de texto para el nombre completo.
	 */
	public JTextField getTxtNombreCompleto() {
	    return txtNombreCompleto;
	}

	/**
	 * Establece el campo de texto para el nombre completo.
	 * 
	 * @param txtNombreCompleto El nuevo campo de texto para el nombre completo.
	 */
	public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
	    this.txtNombreCompleto = txtNombreCompleto;
	}

	/**
	 * Obtiene el campo de texto para el número de documento.
	 * 
	 * @return El campo de texto para el número de documento.
	 */
	public JTextField getTxtNumeroDocumento() {
	    return txtNumeroDocumento;
	}

	/**
	 * Establece el campo de texto para el número de documento.
	 * 
	 * @param txtNumeroDocumento El nuevo campo de texto para el número de documento.
	 */
	public void setTxtNumeroDocumento(JTextField txtNumeroDocumento) {
	    this.txtNumeroDocumento = txtNumeroDocumento;
	}

	/**
	 * Obtiene el campo de texto para el correo electrónico.
	 * 
	 * @return El campo de texto para el correo electrónico.
	 */
	public JTextField getTxtCorreoElectronico() {
	    return txtCorreoElectronico;
	}

	/**
	 * Establece el campo de texto para el correo electrónico.
	 * 
	 * @param txtCorreoElectronico El nuevo campo de texto para el correo electrónico.
	 */
	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
	    this.txtCorreoElectronico = txtCorreoElectronico;
	}

	/**
	 * Obtiene el campo de texto para el examen.
	 * 
	 * @return El campo de texto para el examen.
	 */
	public JTextField getTxtExamenP() {
	    return txtExamenP;
	}

	/**
	 * Establece el campo de texto para el examen.
	 * 
	 * @param txtExamenP El nuevo campo de texto para el examen.
	 */
	public void setTxtExamenP(JTextField txtExamenP) {
	    this.txtExamenP = txtExamenP;
	}

	/**
	 * Obtiene el campo de texto para el diagnóstico.
	 * 
	 * @return El campo de texto para el diagnóstico.
	 */
	public JTextField getTxtDiagnosticoP() {
	    return txtDiagnosticoP;
	}

	/**
	 * Establece el campo de texto para el diagnóstico.
	 * 
	 * @param txtDiagnosticoP El nuevo campo de texto para el diagnóstico.
	 */
	public void setTxtDiagnosticoP(JTextField txtDiagnosticoP) {
	    this.txtDiagnosticoP = txtDiagnosticoP;
	}

	/**
	 * Obtiene el campo de texto para el tratamiento.
	 * 
	 * @return El campo de texto para el tratamiento.
	 */
	public JTextField getTxtTratamientoP() {
	    return txtTratamientoP;
	}

	/**
	 * Establece el campo de texto para el tratamiento.
	 * 
	 * @param txtTratamientoP El nuevo campo de texto para el tratamiento.
	 */
	public void setTxtTratamientoP(JTextField txtTratamientoP) {
	    this.txtTratamientoP = txtTratamientoP;
	}

	/**
	 * Obtiene el selector de fecha de nacimiento.
	 * 
	 * @return El selector de fecha de nacimiento.
	 */
	public JDateChooser getFechaNacimiento() {
	    return fechaNacimiento;
	}

	/**
	 * Establece el selector de fecha de nacimiento.
	 * 
	 * @param fechaNacimiento El nuevo selector de fecha de nacimiento.
	 */
	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
	    this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene el selector de fecha para el tratamiento.
	 * 
	 * @return El selector de fecha para el tratamiento.
	 */
	public JDateChooser getFechaTratamientoP() {
	    return fechaTratamientoP;
	}

	/**
	 * Establece el selector de fecha para el tratamiento.
	 * 
	 * @param fechaTratamientoP El nuevo selector de fecha para el tratamiento.
	 */
	public void setFechaTratamientoP(JDateChooser fechaTratamientoP) {
	    this.fechaTratamientoP = fechaTratamientoP;
	}

	/**
	 * Obtiene el combo box para seleccionar el género.
	 * 
	 * @return El combo box para seleccionar el género.
	 */
	public JComboBox<String> getCmbGenero() {
	    return cmbGenero;
	}

	/**
	 * Establece el combo box para seleccionar el género.
	 * 
	 * @param cmbGenero El nuevo combo box para seleccionar el género.
	 */
	public void setCmbGenero(JComboBox<String> cmbGenero) {
	    this.cmbGenero = cmbGenero;
	}

	/**
	 * Obtiene el combo box para seleccionar la especialidad.
	 * 
	 * @return El combo box para seleccionar la especialidad.
	 */
	public JComboBox<String> getCmbEspecialidadDP() {
	    return cmbEspecialidadDP;
	}

	/**
	 * Establece el combo box para seleccionar la especialidad.
	 * 
	 * @param cmbEspecialidadDP El nuevo combo box para seleccionar la especialidad.
	 */
	public void setCmbEspecialidadDP(JComboBox<String> cmbEspecialidadDP) {
	    this.cmbEspecialidadDP = cmbEspecialidadDP;
	}

	/**
	 * Obtiene el combo box para seleccionar la fecha del turno.
	 * 
	 * @return El combo box para seleccionar la fecha del turno.
	 */
	public JComboBox<String> getCmbFechaTurno() {
	    return cmbFechaTurno;
	}

	/**
	 * Establece el combo box para seleccionar la fecha del turno.
	 * 
	 * @param cmbFechaTurno El nuevo combo box para seleccionar la fecha del turno.
	 */
	public void setCmbFechaTurno(JComboBox<String> cmbFechaTurno) {
	    this.cmbFechaTurno = cmbFechaTurno;
	}

	/**
	 * Obtiene el combo box para seleccionar el especialista actual.
	 * 
	 * @return El combo box para seleccionar el especialista actual.
	 */
	public JComboBox<String> getCmbEspecialistaActual() {
	    return cmbEspecialistaActual;
	}

	/**
	 * Establece el combo box para seleccionar el especialista actual.
	 * 
	 * @param cmbEspecialistaActual El nuevo combo box para seleccionar el especialista actual.
	 */
	public void setCmbEspecialistaActual(JComboBox<String> cmbEspecialistaActual) {
	    this.cmbEspecialistaActual = cmbEspecialistaActual;
	}

	/**
	 * Obtiene el combo box para seleccionar el nuevo especialista.
	 * 
	 * @return El combo box para seleccionar el nuevo especialista.
	 */
	public JComboBox<String> getCmbNuevoEspecialista() {
	    return cmbNuevoEspecialista;
	}

	/**
	 * Establece el combo box para seleccionar el nuevo especialista.
	 * 
	 * @param cmbNuevoEspecialista El nuevo combo box para seleccionar el nuevo especialista.
	 */
	public void setCmbNuevoEspecialista(JComboBox<String> cmbNuevoEspecialista) {
	    this.cmbNuevoEspecialista = cmbNuevoEspecialista;
	}

	/**
	 * Obtiene el combo box para seleccionar un paciente.
	 * 
	 * @return El combo box para seleccionar un paciente.
	 */
	public JComboBox<String> getCmbEscogerPaciente() {
	    return cmbEscogerPaciente;
	}

	/**
	 * Establece el combo box para seleccionar un paciente.
	 * 
	 * @param cmbEscogerPaciente El nuevo combo box para seleccionar un paciente.
	 */
	public void setCmbEscogerPaciente(JComboBox<String> cmbEscogerPaciente) {
	    this.cmbEscogerPaciente = cmbEscogerPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra el nombre completo.
	 * 
	 * @return La etiqueta que muestra el nombre completo.
	 */
	public JLabel getLblNombreCompleto() {
	    return lblNombreCompleto;
	}

	/**
	 * Establece la etiqueta que muestra el nombre completo.
	 * 
	 * @param lblNombreCompleto La nueva etiqueta que muestra el nombre completo.
	 */
	public void setLblNombreCompleto(JLabel lblNombreCompleto) {
	    this.lblNombreCompleto = lblNombreCompleto;
	}

	/**
	 * Obtiene la etiqueta que muestra el número de documento.
	 * 
	 * @return La etiqueta que muestra el número de documento.
	 */
	public JLabel getLblNumeroDocumento() {
	    return lblNumeroDocumento;
	}

	/**
	 * Establece la etiqueta que muestra el número de documento.
	 * 
	 * @param lblNumeroDocumento La nueva etiqueta que muestra el número de documento.
	 */
	public void setLblNumeroDocumento(JLabel lblNumeroDocumento) {
	    this.lblNumeroDocumento = lblNumeroDocumento;
	}

	/**
	 * Obtiene la etiqueta que muestra la fecha de nacimiento.
	 * 
	 * @return La etiqueta que muestra la fecha de nacimiento.
	 */
	public JLabel getLblFechaNacimiento() {
	    return lblFechaNacimiento;
	}

	/**
	 * Establece la etiqueta que muestra la fecha de nacimiento.
	 * 
	 * @param lblFechaNacimiento La nueva etiqueta que muestra la fecha de nacimiento.
	 */
	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
	    this.lblFechaNacimiento = lblFechaNacimiento;
	}

	/**
	 * Obtiene la etiqueta que muestra el correo electrónico.
	 * 
	 * @return La etiqueta que muestra el correo electrónico.
	 */
	public JLabel getLblCorreo() {
	    return lblCorreo;
	}

	/**
	 * Establece la etiqueta que muestra el correo electrónico.
	 * 
	 * @param lblCorreo La nueva etiqueta que muestra el correo electrónico.
	 */
	public void setLblCorreo(JLabel lblCorreo) {
	    this.lblCorreo = lblCorreo;
	}

	/**
	 * Obtiene la etiqueta que muestra el género.
	 * 
	 * @return La etiqueta que muestra el género.
	 */
	public JLabel getLblGenero() {
	    return lblGenero;
	}

	/**
	 * Establece la etiqueta que muestra el género.
	 * 
	 * @param lblGenero La nueva etiqueta que muestra el género.
	 */
	public void setLblGenero(JLabel lblGenero) {
	    this.lblGenero = lblGenero;
	}

	/**
	 * Obtiene la etiqueta que muestra la especialidad.
	 * 
	 * @return La etiqueta que muestra la especialidad.
	 */
	public JLabel getLblEspecialidad() {
	    return lblEspecialidad;
	}

	/**
	 * Establece la etiqueta que muestra la especialidad.
	 * 
	 * @param lblEspecialidad La nueva etiqueta que muestra la especialidad.
	 */
	public void setLblEspecialidad(JLabel lblEspecialidad) {
	    this.lblEspecialidad = lblEspecialidad;
	}

	/**
	 * Obtiene la etiqueta que muestra el título de los datos del paciente.
	 * 
	 * @return La etiqueta que muestra el título de los datos del paciente.
	 */
	public JLabel getLblTituloDatosP() {
	    return lblTituloDatosP;
	}

	/**
	 * Establece la etiqueta que muestra el título de los datos del paciente.
	 * 
	 * @param lblTituloDatosP La nueva etiqueta que muestra el título de los datos del paciente.
	 */
	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
	    this.lblTituloDatosP = lblTituloDatosP;
	}

	/**
	 * Obtiene la etiqueta que muestra el título de las citas médicas.
	 * 
	 * @return La etiqueta que muestra el título de las citas médicas.
	 */
	public JLabel getLblTituloCitasMe() {
	    return lblTituloCitasMe;
	}

	/**
	 * Establece la etiqueta que muestra el título de las citas médicas.
	 * 
	 * @param lblTituloCitasMe La nueva etiqueta que muestra el título de las citas médicas.
	 */
	public void setLblTituloCitasMe(JLabel lblTituloCitasMe) {
	    this.lblTituloCitasMe = lblTituloCitasMe;
	}

	/**
	 * Obtiene la etiqueta que muestra la fecha del turno.
	 * 
	 * @return La etiqueta que muestra la fecha del turno.
	 */
	public JLabel getLblFechaTurno() {
	    return lblFechaTurno;
	}

	/**
	 * Establece la etiqueta que muestra la fecha del turno.
	 * 
	 * @param lblFechaTurno La nueva etiqueta que muestra la fecha del turno.
	 */
	public void setLblFechaTurno(JLabel lblFechaTurno) {
	    this.lblFechaTurno = lblFechaTurno;
	}

	/**
	 * Obtiene la etiqueta que muestra el especialista actual.
	 * 
	 * @return La etiqueta que muestra el especialista actual.
	 */
	public JLabel getLblEspecialistaActu() {
	    return lblEspecialistaActu;
	}

	/**
	 * Establece la etiqueta que muestra el especialista actual.
	 * 
	 * @param lblEspecialistaActu La nueva etiqueta que muestra el especialista actual.
	 */
	public void setLblEspecialistaActu(JLabel lblEspecialistaActu) {
	    this.lblEspecialistaActu = lblEspecialistaActu;
	}

	/**
	 * Obtiene la etiqueta que muestra el nuevo especialista.
	 * 
	 * @return La etiqueta que muestra el nuevo especialista.
	 */
	public JLabel getLblNuevoEspecialista() {
	    return lblNuevoEspecialista;
	}

	/**
	 * Establece la etiqueta que muestra el nuevo especialista.
	 * 
	 * @param lblNuevoEspecialista La nueva etiqueta que muestra el nuevo especialista.
	 */
	public void setLblNuevoEspecialista(JLabel lblNuevoEspecialista) {
	    this.lblNuevoEspecialista = lblNuevoEspecialista;
	}

	/**
	 * Obtiene la etiqueta que muestra el título del tratamiento del paciente.
	 * 
	 * @return La etiqueta que muestra el título del tratamiento del paciente.
	 */
	public JLabel getLblTituloTratamientoPaciente() {
	    return lblTituloTratamientoPaciente;
	}

	/**
	 * Establece la etiqueta que muestra el título del tratamiento del paciente.
	 * 
	 * @param lblTituloTratamientoPaciente La nueva etiqueta que muestra el título del tratamiento del paciente.
	 */
	public void setLblTituloTratamientoPaciente(JLabel lblTituloTratamientoPaciente) {
	    this.lblTituloTratamientoPaciente = lblTituloTratamientoPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra la fecha del tratamiento del paciente.
	 * 
	 * @return La etiqueta que muestra la fecha del tratamiento del paciente.
	 */
	public JLabel getLblFechaTratamientoPaciente() {
	    return lblFechaTratamientoPaciente;
	}

	/**
	 * Establece la etiqueta que muestra la fecha del tratamiento del paciente.
	 * 
	 * @param lblFechaTratamientoPaciente La nueva etiqueta que muestra la fecha del tratamiento del paciente.
	 */
	public void setLblFechaTratamientoPaciente(JLabel lblFechaTratamientoPaciente) {
	    this.lblFechaTratamientoPaciente = lblFechaTratamientoPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra la opción de escoger un paciente.
	 * 
	 * @return La etiqueta que muestra la opción de escoger un paciente.
	 */
	public JLabel getLblEscogerPaciente() {
	    return lblEscogerPaciente;
	}

	/**
	 * Establece la etiqueta que muestra la opción de escoger un paciente.
	 * 
	 * @param lblEscogerPaciente La nueva etiqueta que muestra la opción de escoger un paciente.
	 */
	public void setLblEscogerPaciente(JLabel lblEscogerPaciente) {
	    this.lblEscogerPaciente = lblEscogerPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra el examen del paciente.
	 * 
	 * @return La etiqueta que muestra el examen del paciente.
	 */
	public JLabel getLblExamenPaciente() {
	    return lblExamenPaciente;
	}

	/**
	 * Establece la etiqueta que muestra el examen del paciente.
	 * 
	 * @param lblExamenPaciente La nueva etiqueta que muestra el examen del paciente.
	 */
	public void setLblExamenPaciente(JLabel lblExamenPaciente) {
	    this.lblExamenPaciente = lblExamenPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra el diagnóstico del paciente.
	 * 
	 * @return La etiqueta que muestra el diagnóstico del paciente.
	 */
	public JLabel getLblDiagnosticoPaciente() {
	    return lblDiagnosticoPaciente;
	}

	/**
	 * Establece la etiqueta que muestra el diagnóstico del paciente.
	 * 
	 * @param lblDiagnosticoPaciente La nueva etiqueta que muestra el diagnóstico del paciente.
	 */
	public void setLblDiagnosticoPaciente(JLabel lblDiagnosticoPaciente) {
	    this.lblDiagnosticoPaciente = lblDiagnosticoPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra el tratamiento del paciente.
	 * 
	 * @return La etiqueta que muestra el tratamiento del paciente.
	 */
	public JLabel getLblTratamientoPaciente() {
	    return lblTratamientoPaciente;
	}

	/**
	 * Establece la etiqueta que muestra el tratamiento del paciente.
	 * 
	 * @param lblTratamientoPaciente La nueva etiqueta que muestra el tratamiento del paciente.
	 */
	public void setLblTratamientoPaciente(JLabel lblTratamientoPaciente) {
	    this.lblTratamientoPaciente = lblTratamientoPaciente;
	}

	/**
	 * Obtiene la etiqueta que muestra el título de la lista de tratamientos.
	 * 
	 * @return La etiqueta que muestra el título de la lista de tratamientos.
	 */
	public JLabel getLblTituloListaTratamientos() {
	    return lblTituloListaTratamientos;
	}

	/**
	 * Establece la etiqueta que muestra el título de la lista de tratamientos.
	 * 
	 * @param lblTituloListaTratamientos La nueva etiqueta que muestra el título de la lista de tratamientos.
	 */
	public void setLblTituloListaTratamientos(JLabel lblTituloListaTratamientos) {
	    this.lblTituloListaTratamientos = lblTituloListaTratamientos;
	}

	/**
	 * Obtiene el botón que muestra los datos personales.
	 * 
	 * @return El botón que muestra los datos personales.
	 */
	public JButton getBtnDatosPersonales() {
	    return btnDatosPersonales;
	}

	/**
	 * Establece el botón que muestra los datos personales.
	 * 
	 * @param btnDatosPersonales El nuevo botón que muestra los datos personales.
	 */
	public void setBtnDatosPersonales(JButton btnDatosPersonales) {
	    this.btnDatosPersonales = btnDatosPersonales;
	}

	/**
	 * Obtiene el botón que muestra las citas.
	 * 
	 * @return El botón que muestra las citas.
	 */
	public JButton getBtnCitas() {
	    return btnCitas;
	}

	/**
	 * Establece el botón que muestra las citas.
	 * 
	 * @param btnCitas El nuevo botón que muestra las citas.
	 */
	public void setBtnCitas(JButton btnCitas) {
	    this.btnCitas = btnCitas;
	}

	/**
	 * Obtiene el botón que muestra el turno.
	 * 
	 * @return El botón que muestra el turno.
	 */
	public JButton getBtnTurno() {
	    return btnTurno;
	}

	/**
	 * Establece el botón que muestra el turno.
	 * 
	 * @param btnTurno El nuevo botón que muestra el turno.
	 */
	public void setBtnTurno(JButton btnTurno) {
	    this.btnTurno = btnTurno;
	}

	/**
	 * Obtiene el botón que muestra el tratamiento del paciente.
	 * 
	 * @return El botón que muestra el tratamiento del paciente.
	 */
	public JButton getBtnTratamientoPaciente() {
	    return btnTratamientoPaciente;
	}

	/**
	 * Establece el botón que muestra el tratamiento del paciente.
	 * 
	 * @param btnTratamientoPaciente El nuevo botón que muestra el tratamiento del paciente.
	 */
	public void setBtnTratamientoPaciente(JButton btnTratamientoPaciente) {
	    this.btnTratamientoPaciente = btnTratamientoPaciente;
	}

	/**
	 * Obtiene el botón que muestra la lista de tratamientos.
	 * 
	 * @return El botón que muestra la lista de tratamientos.
	 */
	public JButton getBtnListaTratamientos() {
	    return btnListaTratamientos;
	}

	/**
	 * Establece el botón que muestra la lista de tratamientos.
	 * 
	 * @param btnListaTratamientos El nuevo botón que muestra la lista de tratamientos.
	 */
	public void setBtnListaTratamientos(JButton btnListaTratamientos) {
	    this.btnListaTratamientos = btnListaTratamientos;
	}

	/**
	 * Obtiene el botón para guardar los datos del paciente.
	 * 
	 * @return El botón para guardar los datos del paciente.
	 */
	public JButton getBtnGuardarDatosP() {
	    return btnGuardarDatosP;
	}

	/**
	 * Establece el botón para guardar los datos del paciente.
	 * 
	 * @param btnGuardarDatosP El nuevo botón para guardar los datos del paciente.
	 */
	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
	    this.btnGuardarDatosP = btnGuardarDatosP;
	}

	/**
	 * Obtiene el botón que muestra los turnos del mes.
	 * 
	 * @return El botón que muestra los turnos del mes.
	 */
	public JButton getBtnTurnosMes() {
	    return btnTurnosMes;
	}

	/**
	 * Establece el botón que muestra los turnos del mes.
	 * 
	 * @param btnTurnosMes El nuevo botón que muestra los turnos del mes.
	 */
	public void setBtnTurnosMes(JButton btnTurnosMes) {
	    this.btnTurnosMes = btnTurnosMes;
	}

	/**
	 * Obtiene el botón para cambiar el turno.
	 * 
	 * @return El botón para cambiar el turno.
	 */
	public JButton getBtnCambioTurno() {
	    return btnCambioTurno;
	}

	/**
	 * Establece el botón para cambiar el turno.
	 * 
	 * @param btnCambioTurno El nuevo botón para cambiar el turno.
	 */
	public void setBtnCambioTurno(JButton btnCambioTurno) {
	    this.btnCambioTurno = btnCambioTurno;
	}

	/**
	 * Obtiene el botón para generar el cambio de turno.
	 * 
	 * @return El botón para generar el cambio de turno.
	 */
	public JButton getBtnGenerarCambioTurno() {
	    return btnGenerarCambioTurno;
	}

	/**
	 * Establece el botón para generar el cambio de turno.
	 * 
	 * @param btnGenerarCambioTurno El nuevo botón para generar el cambio de turno.
	 */
	public void setBtnGenerarCambioTurno(JButton btnGenerarCambioTurno) {
	    this.btnGenerarCambioTurno = btnGenerarCambioTurno;
	}

	/**
	 * Obtiene el botón para guardar el tratamiento del paciente.
	 * 
	 * @return El botón para guardar el tratamiento del paciente.
	 */
	public JButton getBtnGuardarTratamiento() {
	    return btnGuardarTratamiento;
	}

	/**
	 * Establece el botón para guardar el tratamiento del paciente.
	 * 
	 * @param btnGuardarTratamiento El nuevo botón para guardar el tratamiento del paciente.
	 */
	public void setBtnGuardarTratamiento(JButton btnGuardarTratamiento) {
	    this.btnGuardarTratamiento = btnGuardarTratamiento;
	}

	/**
	 * Obtiene el botón para volver al menú.
	 * 
	 * @return El botón para volver al menú.
	 */
	public JButton getBtnVolverMenu() {
	    return btnVolverMenu;
	}

	/**
	 * Establece el botón para volver al menú.
	 * 
	 * @param btnVolverMenu El nuevo botón para volver al menú.
	 */
	public void setBtnVolverMenu(JButton btnVolverMenu) {
	    this.btnVolverMenu = btnVolverMenu;
	}

	/**
	 * Obtiene el botón para mostrar un tooltip sobre el especialista.
	 * 
	 * @return El botón para mostrar un tooltip sobre el especialista.
	 */
	public JButton getBtnTooltipEspecialista() {
	    return btnTooltipEspecialista;
	}

	/**
	 * Establece el botón para mostrar un tooltip sobre el especialista.
	 * 
	 * @param btnTooltipEspecialista El nuevo botón para mostrar un tooltip sobre el especialista.
	 */
	public void setBtnTooltipEspecialista(JButton btnTooltipEspecialista) {
	    this.btnTooltipEspecialista = btnTooltipEspecialista;
	}


	/**
	 * Obtiene el ícono de la imagen para el botón de datos.
	 * 
	 * @return El ícono de la imagen del botón de datos.
	 */
	public ImageIcon getImgBtnDatos() {
	    return imgBtnDatos;
	}

	/**
	 * Establece el ícono de la imagen para el botón de datos.
	 * 
	 * @param imgBtnDatos El nuevo ícono de la imagen para el botón de datos.
	 */
	public void setImgBtnDatos(ImageIcon imgBtnDatos) {
	    this.imgBtnDatos = imgBtnDatos;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de citas.
	 * 
	 * @return El ícono de la imagen del botón de citas.
	 */
	public ImageIcon getImgBtnCitas() {
	    return imgBtnCitas;
	}

	/**
	 * Establece el ícono de la imagen para el botón de citas.
	 * 
	 * @param imgBtnCitas El nuevo ícono de la imagen para el botón de citas.
	 */
	public void setImgBtnCitas(ImageIcon imgBtnCitas) {
	    this.imgBtnCitas = imgBtnCitas;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de turnos.
	 * 
	 * @return El ícono de la imagen del botón de turnos.
	 */
	public ImageIcon getImgBtnTurnos() {
	    return imgBtnTurnos;
	}

	/**
	 * Establece el ícono de la imagen para el botón de turnos.
	 * 
	 * @param imgBtnTurnos El nuevo ícono de la imagen para el botón de turnos.
	 */
	public void setImgBtnTurnos(ImageIcon imgBtnTurnos) {
	    this.imgBtnTurnos = imgBtnTurnos;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de tratamiento.
	 * 
	 * @return El ícono de la imagen del botón de tratamiento.
	 */
	public ImageIcon getImgBtnTratamiento() {
	    return imgBtnTratamiento;
	}

	/**
	 * Establece el ícono de la imagen para el botón de tratamiento.
	 * 
	 * @param imgBtnTratamiento El nuevo ícono de la imagen para el botón de tratamiento.
	 */
	public void setImgBtnTratamiento(ImageIcon imgBtnTratamiento) {
	    this.imgBtnTratamiento = imgBtnTratamiento;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de lista de tratamientos.
	 * 
	 * @return El ícono de la imagen del botón de lista de tratamientos.
	 */
	public ImageIcon getImgBtnListaTratamientos() {
	    return imgBtnListaTratamientos;
	}

	/**
	 * Establece el ícono de la imagen para el botón de lista de tratamientos.
	 * 
	 * @param imgBtnListaTratamientos El nuevo ícono de la imagen para el botón de lista de tratamientos.
	 */
	public void setImgBtnListaTratamientos(ImageIcon imgBtnListaTratamientos) {
	    this.imgBtnListaTratamientos = imgBtnListaTratamientos;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de volver.
	 * 
	 * @return El ícono de la imagen del botón de volver.
	 */
	public ImageIcon getImgBtnVolver() {
	    return imgBtnVolver;
	}

	/**
	 * Establece el ícono de la imagen para el botón de volver.
	 * 
	 * @param imgBtnVolver El nuevo ícono de la imagen para el botón de volver.
	 */
	public void setImgBtnVolver(ImageIcon imgBtnVolver) {
	    this.imgBtnVolver = imgBtnVolver;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de guardar datos.
	 * 
	 * @return El ícono de la imagen del botón de guardar datos.
	 */
	public ImageIcon getImgBtnGuardarDatos() {
	    return imgBtnGuardarDatos;
	}

	/**
	 * Establece el ícono de la imagen para el botón de guardar datos.
	 * 
	 * @param imgBtnGuardarDatos El nuevo ícono de la imagen para el botón de guardar datos.
	 */
	public void setImgBtnGuardarDatos(ImageIcon imgBtnGuardarDatos) {
	    this.imgBtnGuardarDatos = imgBtnGuardarDatos;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de turnos del mes.
	 * 
	 * @return El ícono de la imagen del botón de turnos del mes.
	 */
	public ImageIcon getImgBtnTurnosMes() {
	    return imgBtnTurnosMes;
	}

	/**
	 * Establece el ícono de la imagen para el botón de turnos del mes.
	 * 
	 * @param imgBtnTurnosMes El nuevo ícono de la imagen para el botón de turnos del mes.
	 */
	public void setImgBtnTurnosMes(ImageIcon imgBtnTurnosMes) {
	    this.imgBtnTurnosMes = imgBtnTurnosMes;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de cambio de turno.
	 * 
	 * @return El ícono de la imagen del botón de cambio de turno.
	 */
	public ImageIcon getImgBtnCambioTurno() {
	    return imgBtnCambioTurno;
	}

	/**
	 * Establece el ícono de la imagen para el botón de cambio de turno.
	 * 
	 * @param imgBtnCambioTurno El nuevo ícono de la imagen para el botón de cambio de turno.
	 */
	public void setImgBtnCambioTurno(ImageIcon imgBtnCambioTurno) {
	    this.imgBtnCambioTurno = imgBtnCambioTurno;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de confirmar cambio.
	 * 
	 * @return El ícono de la imagen del botón de confirmar cambio.
	 */
	public ImageIcon getImgBtnConfirmarCambio() {
	    return imgBtnConfirmarCambio;
	}

	/**
	 * Establece el ícono de la imagen para el botón de confirmar cambio.
	 * 
	 * @param imgBtnConfirmarCambio El nuevo ícono de la imagen para el botón de confirmar cambio.
	 */
	public void setImgBtnConfirmarCambio(ImageIcon imgBtnConfirmarCambio) {
	    this.imgBtnConfirmarCambio = imgBtnConfirmarCambio;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de guardar tratamiento.
	 * 
	 * @return El ícono de la imagen del botón de guardar tratamiento.
	 */
	public ImageIcon getImgBtnGuardarTratamiento() {
	    return imgBtnGuardarTratamiento;
	}

	/**
	 * Establece el ícono de la imagen para el botón de guardar tratamiento.
	 * 
	 * @param imgBtnGuardarTratamiento El nuevo ícono de la imagen para el botón de guardar tratamiento.
	 */
	public void setImgBtnGuardarTratamiento(ImageIcon imgBtnGuardarTratamiento) {
	    this.imgBtnGuardarTratamiento = imgBtnGuardarTratamiento;
	}

	/**
	 * Obtiene el ícono de la imagen para el botón de tooltip.
	 * 
	 * @return El ícono de la imagen del botón de tooltip.
	 */
	public ImageIcon getImgBtnToolTip() {
	    return imgBtnToolTip;
	}

	/**
	 * Establece el ícono de la imagen para el botón de tooltip.
	 * 
	 * @param imgBtnToolTip El nuevo ícono de la imagen para el botón de tooltip.
	 */
	public void setImgBtnToolTip(ImageIcon imgBtnToolTip) {
	    this.imgBtnToolTip = imgBtnToolTip;
	}

	/**
	 * Obtiene el objeto `CardLayout` utilizado en la interfaz.
	 * 
	 * @return El objeto `CardLayout` que maneja las pantallas.
	 */
	public CardLayout getCardLayout() {
	    return cardLayout;
	}

	/**
	 * Establece el objeto `CardLayout` utilizado en la interfaz.
	 * 
	 * @param cardLayout El nuevo objeto `CardLayout` que maneja las pantallas.
	 */
	public void setCardLayout(CardLayout cardLayout) {
	    this.cardLayout = cardLayout;
	}

	/**
	 * Obtiene el valor de la constante {@code TURNOSMES}.
	 * 
	 * @return El valor de la constante {@code TURNOSMES}.
	 */
	public static String getTurnosmes() {
	    return TURNOSMES;
	}

	/**
	 * Obtiene el valor de la constante {@code CAMBIOTURNO}.
	 * 
	 * @return El valor de la constante {@code CAMBIOTURNO}.
	 */
	public static String getCambioturno() {
	    return CAMBIOTURNO;
	}


}
