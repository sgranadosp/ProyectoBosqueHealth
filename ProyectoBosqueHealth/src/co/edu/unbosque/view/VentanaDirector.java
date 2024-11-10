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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

/**
 * La clase VentanaDirector que extiende JFrame y proporciona una interfaz gráfica
 * para que un Director pueda gestionar datos personales, reportes, turnos, y otras funcionalidades.
 * Esta clase utiliza múltiples paneles, botones, etiquetas, campos de texto y calendarios para 
 * mostrar y gestionar la información relevante.
 * 
 * <p>
 * Hereda de la clase {@link JFrame} y utiliza componentes como {@link JButton}, {@link JLabel} y {@link JComboBox}.
 * <p> 
 * 
 * @author Santiago Granados Pascagaza
 * @version 1.0
 * @since 2024-11-10
 */
public class VentanaDirector extends JFrame{
	
	
	private JPanel panelFijoIzq, panelDerechaArriba, panelCentral,panelDatosDirector, 
	panelPacientesAtendidos, panelDiagnosticosRealizados, panelEspecialisasMNC, panelEspecialidadMC,
	panelCitasCanceladas, panelReporteMensual, panelCreacionTurno, panelVariableReportes;
	private JTextField txtNombreCompleto, txtNumeroDocumento, txtCorreoElectronico;
	private JDateChooser fechaNacimiento, fechaCreacionTurno;
	private JComboBox<String> cmbGenero, cmbNivelDirectivo, cmbEspecialidadCreacionT, 
	cmbEspecialistaCreacionT;
	private JLabel lblNombreCompleto, lblNumeroDocumento, lblFechaNacimiento, lblCorreo, lblGenero, 
	lblTituloDatosP, lblNivelDirectivo, lblTituloCreacionTurno, lblEspecialidadCT, lblEspecialistaCT, 
	lblFechaCreacionT;
	private JButton btnDatosPersonales, btnReportes, btnTurnos, btnGuardarDatosP, btnReporteSemanal,
	btnReporteMensual, btnPacientesAtendidos, btnDiagnosticosRealizados, btnEspecialistasMNC, 
	btnEspecialidadMC, btnCitasCanceladas, btnGenerarTurno, btnVolverMenu, btnTooltipDirector;
	private ImageIcon imgDatosPersonales, imgReportes, imgTurnos, imgGuardarDatosP, imgReporteSemanal,
	imgReporteMensual, imgPacientesAtendidos, imgDiagnosticosRealizados, imgEspecialistasMNC, 
	imgEspecialidadMC, imgCitasCanceladas, imgGenerarTurno, imgVolverMenu, imgBtnToolTip;
	
	private final static String PA = "Pacientes Atendidos";
	private final static String DR = "Diagnosticos Realizados";
	private final static String EMNC = "Especialistas con mayor numero de citas";
	private final static String EMC = "Especialidad con mayor consulta";
	private final static String CC = "Citas Canceladas";
	
	CardLayout cardLayout = new CardLayout();
	
	/**
     * Constructor de la clase VentanaDirector.
     * Ejecuta e  inicializa la ventana y todos sus componentes.
     */
	public VentanaDirector() {
		
		ventana();
		paneles();
		labels();
		textfield();
		botones();
		comboBox();
		calendar();
		
		getPanelFijoIzq().setVisible(true);
		getPanelVariableReportes().setVisible(false);
		getPanelDatosDirector().setVisible(false);
		getPanelDerechaArriba().setVisible(false);
		getPanelCentral().setVisible(false);
		getPanelCreacionTurno().setVisible(false);
		getPanelReporteMensual().setVisible(false);
		
		add(panelFijoIzq);
		add(panelVariableReportes);
		add(panelDatosDirector);
		add(panelDerechaArriba);
		add(panelCentral);
		add(panelCreacionTurno);
		add(panelReporteMensual);
	}

	/**
     * Configura las propiedades de la ventana.
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
     * Configura los paneles de la interfaz y su disposición.
     */
	public void paneles() {
		
		panelFijoIzq = new JPanel();
		panelFijoIzq.setLayout(null);
		panelFijoIzq.setBounds(55, 55, 200, 415);
		panelFijoIzq.setBackground(Color.white);		
		
		panelDerechaArriba = new JPanel();
		panelDerechaArriba.setLayout(null);
		panelDerechaArriba.setBounds(304, 57, 560, 77);
		panelDerechaArriba.setBackground(Color.white);
		
		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(304, 130, 560, 108);
		panelCentral.setBackground(Color.white);
		
		panelDatosDirector = new JPanel();
		panelDatosDirector.setLayout(null);
		panelDatosDirector.setBounds(304, 239, 560, 230);
		panelDatosDirector.setBackground(Color.white);
		
		panelPacientesAtendidos = new JPanel();
		panelPacientesAtendidos.setLayout(null);
		panelPacientesAtendidos.setBounds(304, 239, 560, 230);
		panelPacientesAtendidos.setBackground(Color.white);
		
		panelDiagnosticosRealizados = new JPanel();
		panelDiagnosticosRealizados.setLayout(null);
		panelDiagnosticosRealizados.setBounds(304, 239, 560, 230);
		panelDiagnosticosRealizados.setBackground(Color.white);
		
		panelEspecialisasMNC = new JPanel();
		panelEspecialisasMNC.setLayout(null);
		panelEspecialisasMNC.setBounds(304, 239, 560, 230);
		panelEspecialisasMNC.setBackground(Color.white);
		
		panelEspecialidadMC = new JPanel();
		panelEspecialidadMC.setLayout(null);
		panelEspecialidadMC.setBounds(304, 239, 560, 230);
		panelEspecialidadMC.setBackground(Color.white);
		
		panelCitasCanceladas = new JPanel();
		panelCitasCanceladas.setLayout(null);
		panelCitasCanceladas.setBounds(304, 239, 560, 230);
		panelCitasCanceladas.setBackground(Color.white);
		
		panelVariableReportes = new JPanel(cardLayout);
		panelVariableReportes.setBounds(304, 239, 560, 230);
		panelVariableReportes.setBackground(Color.white);
		panelVariableReportes.add(panelPacientesAtendidos, PA);
		panelVariableReportes.add(panelDiagnosticosRealizados, DR);
		panelVariableReportes.add(panelEspecialisasMNC, EMNC);
		panelVariableReportes.add(panelEspecialidadMC, EMC);
		panelVariableReportes.add(panelCitasCanceladas, CC);
		
		panelReporteMensual = new JPanel();
		panelReporteMensual.setLayout(null);
		panelReporteMensual.setBounds(304, 239, 560, 230);
		panelReporteMensual.setBackground(Color.white);
		
		panelCreacionTurno = new JPanel();
		panelCreacionTurno.setLayout(null);
		panelCreacionTurno.setBounds(304, 239, 560, 230);
		panelCreacionTurno.setBackground(Color.white);
		
	}

	 /**
     * Configura los labels utilizadas en la interfaz.
     */
	public void labels() {
		
		//Labels DATOS PERSONALES del Director
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(161, 12, 350, 40);
		panelDerechaArriba.add(lblTituloDatosP);

		lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreCompleto.setForeground(new Color(78, 175, 93));
		lblNombreCompleto.setBounds(13, 14, 180, 17);
		panelDatosDirector.add(lblNombreCompleto);

		lblNumeroDocumento = new JLabel("Número de documento:");
		lblNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroDocumento.setForeground(new Color(78, 175, 93));
		lblNumeroDocumento.setBounds(13, 46, 180, 17);
		panelDatosDirector.add(lblNumeroDocumento);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(new Color(78, 175, 93));
		lblFechaNacimiento.setBounds(13, 78, 180, 17);
		panelDatosDirector.add(lblFechaNacimiento);

		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCorreo.setForeground(new Color(78, 175, 93));
		lblCorreo.setBounds(13, 110, 180, 17);
		panelDatosDirector.add(lblCorreo);
		
		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(13, 142, 180, 17);
		panelDatosDirector.add(lblGenero);
		
		lblNivelDirectivo = new JLabel("Nivel directivo:");
		lblNivelDirectivo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNivelDirectivo.setForeground(new Color(78, 175, 93));
		lblNivelDirectivo.setBounds(13, 174, 180, 17);
		panelDatosDirector.add(lblNivelDirectivo);
		
		
		//Labels Turnos - Creación de Turno
		lblTituloCreacionTurno = new JLabel("Creación de Turno");
		lblTituloCreacionTurno.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloCreacionTurno.setForeground(new Color(78, 175, 93));
		lblTituloCreacionTurno.setBounds(152, 12, 350, 40);
		panelDerechaArriba.add(lblTituloCreacionTurno);
		
		lblEspecialidadCT = new JLabel("Especialidad:");
		lblEspecialidadCT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialidadCT.setForeground(new Color(78, 175, 93));
		lblEspecialidadCT.setBounds(28, 27, 100, 16);
		panelCreacionTurno.add(lblEspecialidadCT);

		lblEspecialistaCT = new JLabel("Especialista:");
		lblEspecialistaCT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialistaCT.setForeground(new Color(78, 175, 93));
		lblEspecialistaCT.setBounds(28, 75, 100, 16);
		panelCreacionTurno.add(lblEspecialistaCT);

		lblFechaCreacionT = new JLabel("Fecha:");
		lblFechaCreacionT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaCreacionT.setForeground(new Color(78, 175, 93));
		lblFechaCreacionT.setBounds(28, 123, 100, 16);
		panelCreacionTurno.add(lblFechaCreacionT);
		
	}

	/**
     * Configura los campos de texto para la entrada de datos.
     */
	public void textfield() {
		
		//Texfields DATOS PERSONALES
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNombreCompleto.setBounds(206, 9, 200, 26);
		panelDatosDirector.add(txtNombreCompleto);	
		
		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtNumeroDocumento.setBounds(206, 41, 200, 26);
		panelDatosDirector.add(txtNumeroDocumento);	
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Helvetica", Font.PLAIN, 12));
		txtCorreoElectronico.setBounds(206, 105, 200, 26);
		panelDatosDirector.add(txtCorreoElectronico);	
	}

	/**
     * Configura los botones utilizados en la interfaz.
     */
	public void botones() {
		
		//Botones panel fijo de la izquierda
		imgDatosPersonales = new ImageIcon("media\\btnDatosPersonalesDir.png");
		btnDatosPersonales = new JButton(imgDatosPersonales);
		btnDatosPersonales.setBorder(null);
		btnDatosPersonales.setBounds(1, 42, 196, 20);
		panelFijoIzq.add(btnDatosPersonales);
		
		imgReportes = new ImageIcon("media\\btnReportesDir.png");
		btnReportes = new JButton(imgReportes);
		btnReportes.setBorder(null);
		btnReportes.setBounds(1, 118, 196, 20);
		panelFijoIzq.add(btnReportes);
		
		imgTurnos = new ImageIcon("media\\btnTurnosDir.png");
		btnTurnos = new JButton(imgTurnos);
		btnTurnos.setBorder(null);
		btnTurnos.setBounds(1, 190, 196, 20);
		panelFijoIzq.add(btnTurnos);
		
		//Boton DATOS PERSONALES 	
		imgGuardarDatosP = new ImageIcon("media\\btnGuardarDatosEsp.png");
		btnGuardarDatosP = new JButton(imgGuardarDatosP);
		btnGuardarDatosP.setBorder(null);
		btnGuardarDatosP.setBounds(212, 198, 154, 28);
		panelDatosDirector.add(btnGuardarDatosP);
		
		//Botones de arriba reportes
		imgReporteSemanal = new ImageIcon("media\\btnReporteSemanal.png");
		btnReporteSemanal = new JButton(imgReporteSemanal);
		btnReporteSemanal.setBorder(null);
		btnReporteSemanal.setBounds(40, 13, 198, 40);
		panelDerechaArriba.add(btnReporteSemanal);
		
		imgReporteMensual = new ImageIcon("media\\btnReporteMensual.png");
		btnReporteMensual = new JButton(imgReporteMensual);
		btnReporteMensual.setBorder(null);
		btnReporteMensual.setBounds(298, 13, 198, 40);
		panelDerechaArriba.add(btnReporteMensual);
		
		//Botones reporte semanal panel central
		imgPacientesAtendidos = new ImageIcon("media\\btnPacientesAtendidos.png");
		btnPacientesAtendidos = new JButton(imgPacientesAtendidos);
		btnPacientesAtendidos.setBorder(null);
		btnPacientesAtendidos.setBounds(32, 26, 138, 29);
		panelCentral.add(btnPacientesAtendidos);
		
		imgDiagnosticosRealizados = new ImageIcon("media\\btnDiagnosticosRealizados.png");
		btnDiagnosticosRealizados = new JButton(imgDiagnosticosRealizados);
		btnDiagnosticosRealizados.setBorder(null);
		btnDiagnosticosRealizados.setBounds(210, 26, 138, 29);
		panelCentral.add(btnDiagnosticosRealizados);
		
		imgEspecialistasMNC = new ImageIcon("media\\btnEspecialistasMNC.png");
		btnEspecialistasMNC = new JButton(imgEspecialistasMNC);
		btnEspecialistasMNC.setBorder(null);
		btnEspecialistasMNC.setBounds(386, 26, 138, 29);
		panelCentral.add(btnEspecialistasMNC);
		
		imgEspecialidadMC = new ImageIcon("media\\btnEspecialidadMC.png");
		btnEspecialidadMC = new JButton(imgEspecialidadMC);
		btnEspecialidadMC.setBorder(null);
		btnEspecialidadMC.setBounds(111, 70, 138, 29);
		panelCentral.add(btnEspecialidadMC);
		
		imgCitasCanceladas = new ImageIcon("media\\btnCitasCanceladas.png");
		btnCitasCanceladas = new JButton(imgCitasCanceladas);
		btnCitasCanceladas.setBorder(null);
		btnCitasCanceladas.setBounds(318, 70, 138, 29);
		panelCentral.add(btnCitasCanceladas);
		
		//Boton Turnos
		imgGenerarTurno = new ImageIcon("media\\btnGuardarTurno.png");
		btnGenerarTurno = new JButton(imgGenerarTurno);
		btnGenerarTurno.setBorder(null);
		btnGenerarTurno.setBounds(164, 164, 229, 28);
		panelCreacionTurno.add(btnGenerarTurno);
		
		//Volver y tooltip de la esquina
		imgVolverMenu = new ImageIcon("media\\btnVolverMenu.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnVolverMenu = new JButton(imgVolverMenu);
		btnVolverMenu.setBorder(null);
		btnVolverMenu.setBounds(800, 475, 174, 40);
		add(btnVolverMenu);
		
		imgBtnToolTip = new ImageIcon("media\\btnToolTipDirector.png");
		btnTooltipDirector = new JButton(imgBtnToolTip);
		btnTooltipDirector.setBorder(null);
		btnTooltipDirector.setBounds(915, 2, 70, 70);
		add(btnTooltipDirector);
		 
	}

	 /**
     * Configura los ComboBox para la selección de datos.
     */
	public void comboBox() {
		
		//Combobox DATOS PERSONALES
		cmbGenero = new JComboBox<String>();
		cmbGenero.setBounds(206, 137, 200, 26);
		cmbGenero.setToolTipText("Género del Director médico");
		cmbGenero.addItem("");
		cmbGenero.addItem("Masculino");
		cmbGenero.addItem("Femenino");
		panelDatosDirector.add(cmbGenero);
		
		cmbNivelDirectivo = new JComboBox<String>();
		cmbNivelDirectivo.setBounds(206, 169, 200, 26);
		cmbNivelDirectivo.setToolTipText("Nivel directivo del director");
		cmbNivelDirectivo.addItem("");
		cmbNivelDirectivo.addItem("Ejecutivo");
		cmbNivelDirectivo.addItem("Estratega");
		cmbNivelDirectivo.addItem("Supervisor");
		cmbNivelDirectivo.addItem("Líder de equipos");
		cmbNivelDirectivo.addItem("Coordinadoe");
		cmbNivelDirectivo.addItem("Consultor de políticas");
		cmbNivelDirectivo.addItem("Representante externo");
		panelDatosDirector.add(cmbNivelDirectivo);
		
		//Combobox CAMBIO DE TURNO
		cmbEspecialidadCreacionT = new JComboBox<String>();
		cmbEspecialidadCreacionT.setBounds(144, 23, 200, 26);
		cmbEspecialidadCreacionT.setToolTipText("Especialidad del Especialista al que se le asignará turno");
		cmbEspecialidadCreacionT.addItem("");
		cmbEspecialidadCreacionT.addItem("Cirugía");
		cmbEspecialidadCreacionT.addItem("Oncología");
		cmbEspecialidadCreacionT.addItem("Dermatología");
		cmbEspecialidadCreacionT.addItem("Neumología");
		cmbEspecialidadCreacionT.addItem("Cardiología");
		cmbEspecialidadCreacionT.addItem("Medicina Interna");
		panelCreacionTurno.add(cmbEspecialidadCreacionT);
		
		cmbEspecialistaCreacionT = new JComboBox<String>();
		cmbEspecialistaCreacionT.setBounds(144, 69, 200, 26);
		cmbEspecialistaCreacionT.setToolTipText("Especialista al que se le asignará turno");
		cmbEspecialistaCreacionT.addItem("");
		panelCreacionTurno.add(cmbEspecialistaCreacionT);
	}

	 /**
     * Configura los componentes JDateChooser (calendarios).
     */
	public void calendar() {
		
		//JJcalendar DATOS ESPECIALES
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(206, 73, 200, 26);
		panelDatosDirector.add(fechaNacimiento);
		
		//Jcalendar CREACÓN DE TURNOS
		fechaCreacionTurno = new JDateChooser();
		fechaCreacionTurno.setBounds(144, 115, 200, 26);
		panelCreacionTurno.add(fechaCreacionTurno);
	}

	/**
	 * Obtiene el panel izquierdo fijo.
	 * 
	 * @return JPanel que representa el panel izquierdo fijo.
	 */
	public JPanel getPanelFijoIzq() {
		return panelFijoIzq;
	}

	/**
	 * Establece el panel izquierdo fijo.
	 * 
	 * @param panelFijoIzq JPanel que se asignará como el panel izquierdo fijo.
	 */
	public void setPanelFijoIzq(JPanel panelFijoIzq) {
		this.panelFijoIzq = panelFijoIzq;
	}

	/**
	 * Obtiene el panel superior derecho.
	 * 
	 * @return JPanel que representa el panel superior derecho.
	 */
	public JPanel getPanelDerechaArriba() {
		return panelDerechaArriba;
	}

	/**
	 * Establece el panel superior derecho.
	 * 
	 * @param panelDerechaArriba JPanel que se asignará como el panel superior derecho.
	 */
	public void setPanelDerechaArriba(JPanel panelDerechaArriba) {
		this.panelDerechaArriba = panelDerechaArriba;
	}

	/**
	 * Obtiene el panel central.
	 * 
	 * @return JPanel que representa el panel central.
	 */
	public JPanel getPanelCentral() {
		return panelCentral;
	}

	/**
	 * Establece el panel central.
	 * 
	 * @param panelCentral JPanel que se asignará como el panel central.
	 */
	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	/**
	 * Obtiene el panel de datos del director.
	 * 
	 * @return JPanel que contiene la información del director.
	 */
	public JPanel getPanelDatosDirector() {
		return panelDatosDirector;
	}

	/**
	 * Establece el panel de datos del director.
	 * 
	 * @param panelDatosDirector JPanel que se asignará como panel de datos del director.
	 */
	public void setPanelDatosDirector(JPanel panelDatosDirector) {
		this.panelDatosDirector = panelDatosDirector;
	}

	/**
	 * Obtiene el panel que muestra los pacientes atendidos.
	 * 
	 * @return JPanel que contiene la lista de pacientes atendidos.
	 */
	public JPanel getPanelPacientesAtendidos() {
		return panelPacientesAtendidos;
	}

	/**
	 * Establece el panel de pacientes atendidos.
	 * 
	* @param panelPacientesAtendidos JPanel que se asignará como panel de pacientes atendidos.
	*/
	public void setPanelPacientesAtendidos(JPanel panelPacientesAtendidos) {
		this.panelPacientesAtendidos = panelPacientesAtendidos;
	}

	/**
	 * Obtiene el panel de diagnósticos realizados.
	 * 
	 * @return JPanel que contiene los diagnósticos realizados.
	 */
	public JPanel getPanelDiagnosticosRealizados() {
		return panelDiagnosticosRealizados;
	}

	/**
	 * Establece el panel de diagnósticos realizados.
	 * 
	 * @param panelDiagnosticosRealizados JPanel que se asignará como panel de diagnósticos realizados.
	 */
	public void setPanelDiagnosticosRealizados(JPanel panelDiagnosticosRealizados) {
		this.panelDiagnosticosRealizados = panelDiagnosticosRealizados;
	}

	/**
	 * Obtiene el panel Especialistas con mayor numero de citas.
	 * 
	 * @return JPanel que contiene los especialistas con mayor numero de citas.
	 */
	public JPanel getPanelEspecialisasMNC() {
		return panelEspecialisasMNC;
	}

	/**
	 * Establece el panel Especialistas con mayor numero de citas.
	 * 
	 * @param panelEspecialisasMNC JPanel que se asignara como panel de especialistas con mayor numero de citas.
	 */
	public void setPanelEspecialisasMNC(JPanel panelEspecialisasMNC) {
		this.panelEspecialisasMNC = panelEspecialisasMNC;
	}
	/**
	 * Obtiene el panel especialidad con mas consultas.
	 * 
	 * @return JPanel que contiene la especialidad con mas consultas.
	 */
	public JPanel getPanelEspecialidadMC() {
		return panelEspecialidadMC;
	}

	/**
	 * Establece el panel especialidad con mas consultas.
	 * 
	 * @param panelEspecialidadMC JPanel que contiene la especialidad con mas consultas.
	 */
	public void setPanelEspecialidadMC(JPanel panelEspecialidadMC) {
		this.panelEspecialidadMC = panelEspecialidadMC;
	}

	/**
	 * Obtiene el panel que muestra las citas canceladas.
	 * 
	 * @return JPanel que muestra las citas canceladas.
	 */
	public JPanel getPanelCitasCanceladas() {
		return panelCitasCanceladas;
	}
	/**
	 * Establece el panel que muesta las citas canceladas.
	 * 
	 * @param panelCitasCanceladas JPanel que muestra las citas canceladas.
	 */
	public void setPanelCitasCanceladas(JPanel panelCitasCanceladas) {
		this.panelCitasCanceladas = panelCitasCanceladas;
	}

	/**
	 * Obtiene el panel que muestra los reportes mensuales.
	 * 
	 * @return JPanel que muestra los reportes mensuales.
	 */
	public JPanel getPanelReporteMensual() {
		return panelReporteMensual;
	}

	/**
	 * Establece el panel que muestra los reportes mensuales.
	 * 
	 * @param panelReporteMensual JPanel que muestra los reportes mensuales.
	 */
	public void setPanelReporteMensual(JPanel panelReporteMensual) {
		this.panelReporteMensual = panelReporteMensual;
	}

	/**
	 * Obtiene el panel de creacion de turnos.
	 * 
	 * @return JPanel que muestra el panel de creacion de turnos.
	 */
	public JPanel getPanelCreacionTurno() {
		return panelCreacionTurno;
	}

	/**
	 * Establece el panel de creacion de turnos.
	 * 
	 * @param panelCreacionTurno JPanel que muestra el panel de creacion de turnos.
	 */
	public void setPanelCreacionTurno(JPanel panelCreacionTurno) {
		this.panelCreacionTurno = panelCreacionTurno;
	}

	/**
	 * Obtiene el panel que muestra las variables de los reportes.
	 * 
	 * @return JPanel que muestra las variables de los reportes.
	 */
	public JPanel getPanelVariableReportes() {
		return panelVariableReportes;
	}

	/**
	 * Establece el panel que muestra las variables de los reportes.
	 * 
	 * @param panelVariableReportes JPanel que muestra las variables de los reportes.
	 */
	public void setPanelVariableReportes(JPanel panelVariableReportes) {
		this.panelVariableReportes = panelVariableReportes;
	}

	/**
	 * Obtiene el campo de texto para el nombre completo.
	 * 
	 * @return JTextField que contiene el nombre completo.
	 */
	public JTextField getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	/**
	 * Establece el campo de texto para el nombre completo.
	 * 
	 * @param txtNombreCompleto JTextField que contiene el nombre completo.
	 */
	public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
	}

	/**
	 * Obtiene el campo de texto para el número de documento.
	 * 
	 * @return JTextField que contiene el número de documento.
	 */
	public JTextField getTxtNumeroDocumento() {
		return txtNumeroDocumento;
	}

	/**
	 * Establece el campo de texto para el número de documento.
	 * 
	 * @param txtNumeroDocumento JTextField que se asignará como número de documento.
	 */
	public void setTxtNumeroDocumento(JTextField txtNumeroDocumento) {
		this.txtNumeroDocumento = txtNumeroDocumento;
	}

	/**
	 * Obtiene el campo de texto para el correo electrónico.
	 * 
	 * @return JTextField que contiene el correo electrónico.
	 */
	public JTextField getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	/**
	 * Establece el campo de texto para el correo electrónico.
	 * 
	 * @param txtCorreoElectronico JTextField que se asignará como correo electrónico.
	 */
	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	/**
	 * Obtiene la fecha de nacimiento seleccionada.
	 * 
	 * @return JDateChooser que contiene la fecha de nacimiento.
	 */
	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece la fecha de nacimiento.
	 * 
	 * @param fechaNacimiento JDateChooser que se asignará como la fecha de nacimiento.
	 */
	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene la fecha de creación del turno.
	 * 
	 * @return JDateChooser que contiene la fecha de creación del turno.
	 */
	public JDateChooser getFechaCreacionTurno() {
		return fechaCreacionTurno;
	}

	/**
	 * Establece la fecha de creación del turno.
	 * 
	 * @param fechaCreacionTurno JDateChooser que se asignará como fecha de creación.
	 */
	public void setFechaCreacionTurno(JDateChooser fechaCreacionTurno) {
		this.fechaCreacionTurno = fechaCreacionTurno;
	}

	/**
	 * Obtiene el combo box para seleccionar el género.
	 * 
	 * @return JComboBox que contiene las opciones de género.
	 */
	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	/**
	 * Establece el combo box para seleccionar el género.
	 * 
	 * @param cmbGenero JComboBox que se asignará como selector de género.
	 */
	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	/**
	 * Obtiene el combo box para seleccionar el nivel directivo.
	 * 
	 * @return JComboBox que contiene las opciones de nivel directivo.
	 */
	public JComboBox<String> getCmbNivelDirectivo() {
		return cmbNivelDirectivo;
	}

	/**
	 * Establece el combo box para seleccionar el nivel directivo.
	 * 
	 * @param cmbNivelDirectivo JComboBox que se asignará como selector de nivel directivo.
	 */
	public void setCmbNivelDirectivo(JComboBox<String> cmbNivelDirectivo) {
		this.cmbNivelDirectivo = cmbNivelDirectivo;
	}

	/**
	 * Obtiene el combo box para seleccionar la especialidad al crear un turno.
	 * 
	 * @return JComboBox que contiene las opciones de especialidad.
	 */
	public JComboBox<String> getCmbEspecialidadCreacionT() {
		return cmbEspecialidadCreacionT;
	}

	/**
	 * Establece el combo box para seleccionar la especialidad al crear un turno.
	 * 
	 * @param cmbEspecialidadCreacionT JComboBox que se asignará como selector de especialidad.
	 */
	public void setCmbEspecialidadCreacionT(JComboBox<String> cmbEspecialidadCreacionT) {
		this.cmbEspecialidadCreacionT = cmbEspecialidadCreacionT;
	}

	/**
	 * Obtiene el combo box para seleccionar el especialista al crear un turno.
	 * 
	 * @return JComboBox que contiene las opciones de especialistas.
	 */
	public JComboBox<String> getCmbEspecialistaCreacionT() {
		return cmbEspecialistaCreacionT;
	}

	/**
	 * Establece el combo box para seleccionar el especialista al crear un turno.
	 * 
	 * @param cmbEspecialistaCreacionT JComboBox que se asignará como selector de especialista.
	 */
	public void setCmbEspecialistaCreacionT(JComboBox<String> cmbEspecialistaCreacionT) {
		this.cmbEspecialistaCreacionT = cmbEspecialistaCreacionT;
	}

	/**
	 * Obtiene la etiqueta que muestra el nombre completo.
	 * 
	 * @return JLabel que contiene el nombre completo.
	 */
	public JLabel getLblNombreCompleto() {
		return lblNombreCompleto;
	}

	/**
	 * Establece la etiqueta que muestra el nombre completo.
	 * 
	 * @param lblNombreCompleto JLabel que se asignará para mostrar el nombre completo.
	 */
	public void setLblNombreCompleto(JLabel lblNombreCompleto) {
		this.lblNombreCompleto = lblNombreCompleto;
	}

	/**
	 * Obtiene la etiqueta que muestra el número de documento.
	 * 
	 * @return JLabel que contiene el número de documento.
	 */
	public JLabel getLblNumeroDocumento() {
		return lblNumeroDocumento;
	}

	/**
	 * Establece la etiqueta que muestra el número de documento.
	 * 
	 * @param lblNumeroDocumento JLabel que se asignará para mostrar el número de documento.
	 */
	public void setLblNumeroDocumento(JLabel lblNumeroDocumento) {
		this.lblNumeroDocumento = lblNumeroDocumento;
	}

	/**
	 * Obtiene la etiqueta que muestra la fecha de nacimiento.
	 * 
	 * @return JLabel que contiene la fecha de nacimiento.
	 */
	public JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	/**
	 * Establece la etiqueta que muestra la fecha de nacimiento.
	 * 
	 * @param lblFechaNacimiento JLabel que se asignará para mostrar la fecha de nacimiento.
	 */
	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	/**
	 * Obtiene la etiqueta que muestra el correo electrónico.
	 * 
	 * @return JLabel que contiene el correo electrónico.
	 */
	public JLabel getLblCorreo() {
		return lblCorreo;
	}


	/**
	 * Establece la etiqueta que muestra el correo electrónico.
	 * 
	 * @param lblCorreo JLabel que se asignará para mostrar el correo electrónico.
	 */
	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	/**
	 * Obtiene la etiqueta que muestra el género.
	 * 
	 * @return JLabel que contiene el género.
	 */
	public JLabel getLblGenero() {
		return lblGenero;
	}

	/**
	 * Establece la etiqueta que muestra el género.
	 * 
	 * @param lblGenero JLabel que se asignará para mostrar el género.
	 */
	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}


	/**
	 * Obtiene la etiqueta que muestra el título de la sección de datos personales.
	 * 
	 * @return JLabel que contiene el título de datos personales.
	 */
	public JLabel getLblTituloDatosP() {
		return lblTituloDatosP;
	}

	/**
	 * Establece la etiqueta que muestra el título de la sección de datos personales.
	 * 
	 * @param lblTituloDatosP JLabel que se asignará para el título de datos personales.
	 */
	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
		this.lblTituloDatosP = lblTituloDatosP;
	}

	/**
	 * Obtiene la etiqueta que muestra el nivel directivo.
	 * 
	 * @return JLabel que contiene el nivel directivo.
	 */
	public JLabel getLblNivelDirectivo() {
		return lblNivelDirectivo;
	}

	/**
	 * Establece la etiqueta que muestra el nivel directivo.
	 * 
	 * @param lblNivelDirectivo JLabel que se asignará para mostrar el nivel directivo.
	 */
	public void setLblNivelDirectivo(JLabel lblNivelDirectivo) {
		this.lblNivelDirectivo = lblNivelDirectivo;
	}

	/**
	 * Obtiene la etiqueta que muestra el título para la creación de un turno.
	 * 
	 * @return JLabel que contiene el título para la creación de un turno.
	 */
	public JLabel getLblTituloCreacionTurno() {
		return lblTituloCreacionTurno;
	}

	/**
	 * Establece la etiqueta que muestra el título para la creación de un turno.
	 * 
	 * @param lblTituloCreacionTurno JLabel que se asignará como título para la creación de un turno.
	 */
	public void setLblTituloCreacionTurno(JLabel lblTituloCreacionTurno) {
		this.lblTituloCreacionTurno = lblTituloCreacionTurno;
	}

	/**
	 * Obtiene la etiqueta que muestra la especialidad en la creación de turnos.
	 * 
	 * @return JLabel que contiene la especialidad en la creación de turnos.
	 */
	public JLabel getLblEspecialidadCT() {
		return lblEspecialidadCT;
	}

	/**
	 * Establece la etiqueta que muestra la especialidad en la creación de turnos.
	 * 
	 * @param lblEspecialidadCT JLabel que se asignará para mostrar la especialidad.
	 */
	public void setLblEspecialidadCT(JLabel lblEspecialidadCT) {
		this.lblEspecialidadCT = lblEspecialidadCT;
	}
	
	/**
	 * Obtiene la etiqueta que muestra el especialista en la creación de turnos.
	 * 
	 * @return JLabel que contiene el especialista en la creación de turnos.
	 */
	public JLabel getLblEspecialistaCT() {
		return lblEspecialistaCT;
	}

	/**
	 * Establece la etiqueta que muestra el especialista en la creación de turnos.
	 * 
	 * @param lblEspecialistaCT JLabel que se asignará para mostrar el especialista.
	 */
	public void setLblEspecialistaCT(JLabel lblEspecialistaCT) {
		this.lblEspecialistaCT = lblEspecialistaCT;
	}

	/**
	 * Obtiene la etiqueta que muestra la fecha de creación del turno.
	 * 
	 * @return JLabel que contiene la fecha de creación del turno.
	 */
	public JLabel getLblFechaCreacionT() {
		return lblFechaCreacionT;
	}

	/**
	 * Establece la etiqueta que muestra la fecha de creación del turno.
	 * 
	 * @param lblFechaCreacionT JLabel que se asignará para mostrar la fecha de creación del turno.
	 */
	public void setLblFechaCreacionT(JLabel lblFechaCreacionT) {
		this.lblFechaCreacionT = lblFechaCreacionT;
	}

	/**
	 * Obtiene el botón para guardar los datos personales.
	 * 
	 * @return JButton que permite guardar los datos personales.
	 */
	public JButton getBtnDatosPersonales() {
		return btnDatosPersonales;
	}

	/**
	 * Establece el botón para guardar los datos personales.
	 * 
	 * @param btnGuardarDatosP JButton que se asignará como el botón para guardar datos.
	 */
	public void setBtnDatosPersonales(JButton btnDatosPersonales) {
		this.btnDatosPersonales = btnDatosPersonales;
	}

	/**
	 * Obtiene el botón que muestra la sección de reportes.
	 * 
	 * @return JButton para acceder a la sección de reportes.
	 */
	public JButton getBtnReportes() {
		return btnReportes;
	}

	/**
	 * Establece el botón que muestra la sección de reportes.
	 * 
	 * @param btnReportes JButton que se asignará para la sección de reportes.
	 */
	public void setBtnReportes(JButton btnReportes) {
		this.btnReportes = btnReportes;
	}

	/**
	 * Obtiene el botón que muestra la sección de turnos.
	 * 
	 * @return JButton para acceder a la sección de turnos.
	 */
	public JButton getBtnTurnos() {
		return btnTurnos;
	}

	/**
	 * Establece el botón que muestra la sección de turnos.
	 * 
	 * @param btnTurnos JButton que se asignará para la sección de turnos.
	 */
	public void setBtnTurnos(JButton btnTurnos) {
		this.btnTurnos = btnTurnos;
	}

	/**
	 * Obtiene el botón que guarda los datos personales.
	 * 
	 * @return JButton para guardar los datos personales.
	 */
	public JButton getBtnGuardarDatosP() {
		return btnGuardarDatosP;
	}

	/**
	 * Establece el botón que guarda los datos personales.
	 * 
	 * @param btnGuardarDatosP JButton que se asignará para guardar los datos personales.
	 */
	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
		this.btnGuardarDatosP = btnGuardarDatosP;
	}

	/**
	 * Obtiene el botón para generar el reporte semanal.
	 * 
	 * @return JButton para generar el reporte semanal.
	 */
	public JButton getBtnReporteSemanal() {
		return btnReporteSemanal;
	}

	/**
	 * Establece el botón para generar el reporte semanal.
	 * 
	 * @param btnReporteSemanal JButton que se asignará para el reporte semanal.
	 */
	public void setBtnReporteSemanal(JButton btnReporteSemanal) {
		this.btnReporteSemanal = btnReporteSemanal;
	}

	/**
	 * Obtiene el botón para generar el reporte mensual.
	 * 
	 * @return JButton para generar el reporte mensual.
	 */
	public JButton getBtnReporteMensual() {
		return btnReporteMensual;
	}

	/**
	 * Establece el botón para generar el reporte mensual.
	 * 
	 * @param btnReporteMensual JButton que se asignará para el reporte mensual.
	 */
	public void setBtnReporteMensual(JButton btnReporteMensual) {
		this.btnReporteMensual = btnReporteMensual;
	}

	/**
	 * Obtiene el botón para consultar los pacientes atendidos.
	 * 
	 * @return JButton para acceder a la lista de pacientes atendidos.
	 */
	public JButton getBtnPacientesAtendidos() {
		return btnPacientesAtendidos;
	}

	/**
	 * Establece el botón para consultar los pacientes atendidos.
	 * 
	 * @param btnPacientesAtendidos JButton que se asignará para mostrar pacientes atendidos.
	 */
	public void setBtnPacientesAtendidos(JButton btnPacientesAtendidos) {
		this.btnPacientesAtendidos = btnPacientesAtendidos;
	}

	/**
	 * Obtiene el botón para ver diagnósticos realizados.
	 * 
	 * @return JButton para mostrar diagnósticos realizados.
	 */
	public JButton getBtnDiagnosticosRealizados() {
		return btnDiagnosticosRealizados;
	}

	/**
	 * Establece el botón para ver diagnósticos realizados.
	 * 
	 * @param btnDiagnosticosRealizados JButton que se asignará para mostrar diagnósticos.
	 */
	public void setBtnDiagnosticosRealizados(JButton btnDiagnosticosRealizados) {
		this.btnDiagnosticosRealizados = btnDiagnosticosRealizados;
	}

	/**
	 * Obtiene el botón para acceder al reporte de especialistas con mayor número de citas.
	 * 
	 * @return JButton para mostrar el reporte de especialistas con más citas.
	 */
	public JButton getBtnEspecialistasMNC() {
		return btnEspecialistasMNC;
	}

	/**
	 * Establece el botón para acceder al reporte de especialistas con mayor número de citas.
	 * 
	 * @param btnEspecialistasMNC JButton que se asignará para mostrar especialistas con más citas.
	 */
	public void setBtnEspecialistasMNC(JButton btnEspecialistasMNC) {
		this.btnEspecialistasMNC = btnEspecialistasMNC;
	}

	/**
	 * Obtiene el botón para acceder al reporte por especialidad con mayor cantidad de citas.
	 * 
	 * @return JButton para mostrar el reporte por especialidad con más citas.
	 */
	public JButton getBtnEspecialidadMC() {
		return btnEspecialidadMC;
	}

	/**
	 * Establece el botón para acceder al reporte por especialidad con mayor cantidad de citas.
	 * 
	 * @param btnEspecialidadMC JButton que se asignará para mostrar especialidades con más citas.
	 */
	public void setBtnEspecialidadMC(JButton btnEspecialidadMC) {
		this.btnEspecialidadMC = btnEspecialidadMC;
	}

	/**
	 * Obtiene el botón para ver el reporte de citas canceladas.
	 * 
	 * @return JButton para acceder al reporte de citas canceladas.
	 */
	public JButton getBtnCitasCanceladas() {
		return btnCitasCanceladas;
	}

	/**
	 * Establece el botón para ver el reporte de citas canceladas.
	 * 
	 * @param btnCitasCanceladas JButton que se asignará para mostrar citas canceladas.
	 */
	public void setBtnCitasCanceladas(JButton btnCitasCanceladas) {
		this.btnCitasCanceladas = btnCitasCanceladas;
	}

	/**
	 * Obtiene el botón para la generación de un turno.
	 * 
	 * @return JButton que genera un nuevo turno.
	 */
	public JButton getBtnGenerarTurno() {
		return btnGenerarTurno;
	}

	/**
	 * Establece el botón para la generación de un turno.
	 * 
	 * @param btnGenerarTurno JButton que se asignará para generar un turno.
	 */
	public void setBtnGenerarTurno(JButton btnGenerarTurno) {
		this.btnGenerarTurno = btnGenerarTurno;
	}

	/**
	 * Obtiene el botón para volver al menú principal.
	 * 
	 * @return JButton que permite volver al menú principal.
	 */
	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	/**
	 * Establece el botón para volver al menú principal.
	 * 
	 * @param btnVolverMenu JButton que se asignará para regresar al menú.
	 */
	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	/**
	 * Obtiene el boton para mostrar informacion adicional para el director medico.
	 * 
	 * @return JButton que permite mostrar informacion adicional del director medico.
	 */
	public JButton getBtnTooltipDirector() {
		return btnTooltipDirector;
	}

	/**
	 * Establece el boton para mostrar informacion adicional para el director medico.
	 * 
	 * @param btnTooltipDirector permite mostrar informacion adicional de el director medico.
	 */
	public void setBtnTooltipDirector(JButton btnTooltipDirector) {
		this.btnTooltipDirector = btnTooltipDirector;
	}

	/**
	 * Obtiene el icono de imagen para la seleccion datos personales.
	 * 
	 * @return ImageIcon que representa el icono de la seleccion de datos personales.
	 */
	public ImageIcon getImgDatosPersonales() {
		return imgDatosPersonales;
	}

	/**
	 * Establece el icono de imagen para la seccion de datos personales.
	 * 
	 * @param imgDatosPersonales que se asignara como icono de la seleccion de datos personales.
	 */
	public void setImgDatosPersonales(ImageIcon imgDatosPersonales) {
		this.imgDatosPersonales = imgDatosPersonales;
	}
	/**
	 * Obtiene el icono de imagen para la sección de reportes.
	 * 
	 * @return ImageIcon que representa el icono de la sección de reportes.
	 */
	public ImageIcon getImgReportes() {
		return imgReportes;
	}
	/**
	 * Establece el icono de imagen para la sección de reportes.
	 * 
	 * @param imgReportes ImageIcon que se asignará como icono de reportes.
	 */
	public void setImgReportes(ImageIcon imgReportes) {
		this.imgReportes = imgReportes;
	}

	/**
	 * Obtiene el icono de imagen para la sección de turnos.
	 * 
	 * @return ImageIcon que representa el icono de la sección de turnos.
	 */
	public ImageIcon getImgTurnos() {
		return imgTurnos;
	}

	/**
	 * Establece el icono de imagen para la sección de turnos.
	 * 
	 * @param imgTurnos ImageIcon que se asignará como icono para la sección de turnos.
	 */
	public void setImgTurnos(ImageIcon imgTurnos) {
		this.imgTurnos = imgTurnos;
	}

	/**
	 * Obtiene el ícono utilizado para el botón de guardar datos personales.
	 * 
	 * @return ImageIcon para el botón de guardar datos personales.
	 */
	public ImageIcon getImgGuardarDatosP() {
	    return imgGuardarDatosP;
	}

	/**
	 * Establece el ícono utilizado para el botón de guardar datos personales.
	 * 
	 * @param imgGuardarDatosP ImageIcon que se asignará al botón de guardar datos.
	 */
	public void setImgGuardarDatosP(ImageIcon imgGuardarDatosP) {
	    this.imgGuardarDatosP = imgGuardarDatosP;
	}

	/**
	 * Obtiene el ícono para el reporte semanal.
	 * 
	 * @return ImageIcon para el reporte semanal.
	 */
	public ImageIcon getImgReporteSemanal() {
	    return imgReporteSemanal;
	}

	/**
	 * Establece el ícono para el reporte semanal.
	 * 
	 * @param imgReporteSemanal ImageIcon que se asignará al botón de reporte semanal.
	 */
	public void setImgReporteSemanal(ImageIcon imgReporteSemanal) {
	    this.imgReporteSemanal = imgReporteSemanal;
	}

	/**
	 * Obtiene el ícono para el reporte mensual.
	 * 
	 * @return ImageIcon para el reporte mensual.
	 */
	public ImageIcon getImgReporteMensual() {
	    return imgReporteMensual;
	}

	/**
	 * Establece el ícono para el reporte mensual.
	 * 
	 * @param imgReporteMensual ImageIcon que se asignará al botón de reporte mensual.
	 */
	public void setImgReporteMensual(ImageIcon imgReporteMensual) {
	    this.imgReporteMensual = imgReporteMensual;
	}

	/**
	 * Obtiene el ícono para la sección de pacientes atendidos.
	 * 
	 * @return ImageIcon para el botón de pacientes atendidos.
	 */
	public ImageIcon getImgPacientesAtendidos() {
	    return imgPacientesAtendidos;
	}

	/**
	 * Establece el ícono para la sección de pacientes atendidos.
	 * 
	 * @param imgPacientesAtendidos ImageIcon que se asignará al botón de pacientes atendidos.
	 */
	public void setImgPacientesAtendidos(ImageIcon imgPacientesAtendidos) {
	    this.imgPacientesAtendidos = imgPacientesAtendidos;
	}

	/**
	 * Obtiene el ícono para la sección de diagnósticos realizados.
	 * 
	 * @return ImageIcon para el botón de diagnósticos realizados.
	 */
	public ImageIcon getImgDiagnosticosRealizados() {
	    return imgDiagnosticosRealizados;
	}

	/**
	 * Establece el ícono para la sección de diagnósticos realizados.
	 * 
	 * @param imgDiagnosticosRealizados ImageIcon que se asignará al botón de diagnósticos.
	 */
	public void setImgDiagnosticosRealizados(ImageIcon imgDiagnosticosRealizados) {
	    this.imgDiagnosticosRealizados = imgDiagnosticosRealizados;
	}

	/**
	 * Obtiene el ícono para el reporte de especialistas con mayor número de citas.
	 * 
	 * @return ImageIcon para el botón de reporte de especialistas con más citas.
	 */
	public ImageIcon getImgEspecialistasMNC() {
	    return imgEspecialistasMNC;
	}

	/**
	 * Establece el ícono para el reporte de especialistas con mayor número de citas.
	 * 
	 * @param imgEspecialistasMNC ImageIcon que se asignará al botón de especialistas con más citas.
	 */
	public void setImgEspecialistasMNC(ImageIcon imgEspecialistasMNC) {
	    this.imgEspecialistasMNC = imgEspecialistasMNC;
	}

	/**
	 * Obtiene el ícono para el reporte de especialidades con mayor número de citas.
	 * 
	 * @return ImageIcon para el botón de reporte de especialidades.
	 */
	public ImageIcon getImgEspecialidadMC() {
	    return imgEspecialidadMC;
	}

	/**
	 * Establece el ícono para el reporte de especialidades con mayor número de citas.
	 * 
	 * @param imgEspecialidadMC ImageIcon que se asignará al botón de especialidades.
	 */
	public void setImgEspecialidadMC(ImageIcon imgEspecialidadMC) {
	    this.imgEspecialidadMC = imgEspecialidadMC;
	}

	/**
	 * Obtiene el ícono para el reporte de citas canceladas.
	 * 
	 * @return ImageIcon para el botón de citas canceladas.
	 */
	public ImageIcon getImgCitasCanceladas() {
	    return imgCitasCanceladas;
	}

	/**
	 * Establece el ícono para el reporte de citas canceladas.
	 * 
	 * @param imgCitasCanceladas ImageIcon que se asignará al botón de citas canceladas.
	 */
	public void setImgCitasCanceladas(ImageIcon imgCitasCanceladas) {
	    this.imgCitasCanceladas = imgCitasCanceladas;
	}

	/**
	 * Obtiene el ícono para la creación de un nuevo turno.
	 * 
	 * @return ImageIcon para el botón de generación de turnos.
	 */
	public ImageIcon getImgGenerarTurno() {
	    return imgGenerarTurno;
	}

	/**
	 * Establece el ícono para la creación de un nuevo turno.
	 * 
	 * @param imgGenerarTurno ImageIcon que se asignará al botón de generación de turnos.
	 */
	public void setImgGenerarTurno(ImageIcon imgGenerarTurno) {
	    this.imgGenerarTurno = imgGenerarTurno;
	}

	/**
	 * Obtiene el ícono para volver al menú principal.
	 * 
	 * @return ImageIcon para el botón de volver al menú.
	 */
	public ImageIcon getImgVolverMenu() {
	    return imgVolverMenu;
	}

	/**
	 * Establece el ícono para volver al menú principal.
	 * 
	 * @param imgVolverMenu ImageIcon que se asignará al botón de volver al menú.
	 */
	public void setImgVolverMenu(ImageIcon imgVolverMenu) {
	    this.imgVolverMenu = imgVolverMenu;
	}

	/**
	 * Obtiene el icono del botón que muestra información adicional para el director.
	 * 
	 * @return ImageIcon que representa el tooltip para el director.
	 */
	public ImageIcon getImgBtnToolTip() {
		return imgBtnToolTip;
	}

	/**
	 * Establece el icono del botón que muestra información adicional para el director.
	 * 
	 * @param imgBtnToolTip ImageIcon que se asignará como icono para el tooltip.
	 */
	public void setImgBtnToolTip(ImageIcon imgBtnToolTip) {
		this.imgBtnToolTip = imgBtnToolTip;
	}

	/**
	 * Obtiene el diseño de tarjetas utilizado para alternar entre paneles.
	 * 
	 * @return CardLayout que administra la navegación entre paneles.
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Establece el diseño de tarjetas utilizado para alternar entre paneles.
	 * 
	 * @param cardLayout CardLayout que se asignará para la gestión de paneles.
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	/**
	 * Obtiene el identificador para la sección de pacientes atendidos.
	 * 
	 * @return String constante que representa la sección de pacientes atendidos.
	 */
	public static String getPa() {
		return PA;
	}

	/**
	 * Obtiene el identificador para la sección de diagnósticos realizados.
	 * 
	 * @return String constante que representa la sección de diagnósticos realizados.
	 */
	public static String getDr() {
		return DR;
	}

	/**
	 * Obtiene el identificador para la seccion de especialistas con mayor numero de citas.
	 * 
	 * @return String constante que representa la seccion de especialistas con mayor numero de citas.
	 */
	public static String getEmnc() {
		return EMNC;
	}

	/**
	 * Obtiene el identificador para la seccion de especialidades con mayor consultas.
	 * 
	 * @return String constante que representa la seccion de especialidades con mayor consultas.
	 */
	public static String getEmc() {
		return EMC;
	}

	/**
	 * Obtiene el identificador para la seccion citas canceladas.
	 * 
	 * @return String constante que representa la seccion de citas canceladas.
	 */
	public static String getCc() {
		return CC;
	}
	
}
