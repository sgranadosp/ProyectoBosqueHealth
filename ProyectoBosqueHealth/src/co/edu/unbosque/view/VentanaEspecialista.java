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
		add(panelTurnoMes);
		add(panelCambioTurno);
		add(panelTratamientoP);
		add(panelListaTratamiento);
		add(panelVariableTurno);
	}

	public void ventana() {
        setBounds(50, 50, 1000, 561);
        setTitle("Bosque Health");
        getContentPane().setBackground(new Color(78, 175, 93));;
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
	}

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
		panelTurnoMes.setLayout(null);
		panelCambioTurno.setBounds(302, 156, 560, 315);
		panelCambioTurno.setBackground(Color.white);
		
		panelVariableTurno = new JPanel();
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

	public void labels() {
	
		//Labels DATOS PERSONALES
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(154, 40, 220, 40);
		panelDerechaArriba.add(lblTituloDatosP);
		
		lblNombreCompleto = new JLabel("Nombre especialista");
		lblNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreCompleto.setForeground(new Color(78, 175, 93));
		lblNombreCompleto.setBounds(13, 14, 176, 20);
		panelDatosEspecialista.add(lblNombreCompleto);
		
		lblNumeroDocumento = new JLabel("Documento del especialista");
		lblNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroDocumento.setForeground(new Color(78, 175, 93));
		lblNumeroDocumento.setBounds(13, 58, 176, 20);
		panelDatosEspecialista.add(lblNumeroDocumento);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento del especialista");
		lblFechaNacimiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(new Color(78, 175, 93));
		lblFechaNacimiento.setBounds(13, 100, 176, 20);
		panelDatosEspecialista.add(lblFechaNacimiento);
		
		lblCorreo = new JLabel("Correo del especialista");
		lblCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCorreo.setForeground(new Color(78, 175, 93));
		lblCorreo.setBounds(13, 142, 176, 20);
		panelDatosEspecialista.add(lblCorreo);
		
		lblGenero = new JLabel();
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(13, 184, 176, 20);
		panelDatosEspecialista.add(lblGenero);
		
		lblEspecialidad = new JLabel();
		lblEspecialidad.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialidad.setForeground(new Color(78, 175, 93));
		lblEspecialidad.setBounds(13, 226, 176, 20);
		panelDatosEspecialista.add(lblEspecialidad);
		
		//Label CITAS
		lblTituloCitasMe = new JLabel();
		lblTituloCitasMe.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloCitasMe.setForeground(new Color(78, 175, 93));
		lblTituloCitasMe.setBounds(154, 40, 220, 40);
		panelDerechaArriba.add(lblTituloCitasMe);
		
		//LabelS TURNOS
		
		lblFechaTurno = new JLabel();
		lblFechaTurno.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaTurno.setForeground(new Color(78, 175, 93));
		lblFechaTurno.setBounds(42, 51, 122, 20);
		panelCambioTurno.add(lblFechaTurno);
		
		lblEspecialistaActu = new JLabel();
		lblEspecialistaActu.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialistaActu.setForeground(new Color(78, 175, 93));
		lblEspecialistaActu.setBounds(49, 146, 180, 40);
		panelCambioTurno.add(lblEspecialistaActu);
		
		lblNuevoEspecialista = new JLabel();
		lblNuevoEspecialista.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNuevoEspecialista.setForeground(new Color(78, 175, 93));
		lblNuevoEspecialista.setBounds(303, 146, 180, 40);
		panelCambioTurno.add(lblNuevoEspecialista);
		
		//Labels TRATAMIENTO
		lblTituloTratamientoPaciente = new JLabel();
		lblTituloTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblTituloTratamientoPaciente.setBounds(154, 40, 220, 40);
		panelDerechaArriba.add(lblTituloTratamientoPaciente);
		
		lblFechaTratamientoPaciente = new JLabel();
		lblFechaTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblFechaTratamientoPaciente.setBounds(22, 20, 130, 20);
		panelTratamientoP.add(lblFechaTratamientoPaciente);
		
		lblEscogerPaciente = new JLabel();
		lblEscogerPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEscogerPaciente.setForeground(new Color(78, 175, 93));
		lblEscogerPaciente.setBounds(22, 98, 130, 20);
		panelTratamientoP.add(lblEscogerPaciente);
		
		lblExamenPaciente = new JLabel();
		lblExamenPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblExamenPaciente.setForeground(new Color(78, 175, 93));
		lblExamenPaciente.setBounds(22, 176, 130, 20);
		panelTratamientoP.add(lblExamenPaciente);
		
		lblDiagnosticoPaciente = new JLabel();
		lblDiagnosticoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblDiagnosticoPaciente.setForeground(new Color(78, 175, 93));
		lblDiagnosticoPaciente.setBounds(22, 254, 130, 20);
		panelTratamientoP.add(lblDiagnosticoPaciente);
		
		lblTratamientoPaciente = new JLabel();
		lblTratamientoPaciente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblTratamientoPaciente.setForeground(new Color(78, 175, 93));
		lblTratamientoPaciente.setBounds(22, 332, 130, 20);
		panelTratamientoP.add(lblTratamientoPaciente);
		
		//Label LISTA DE TRATAMIENTOS
		lblTituloListaTratamientos = new JLabel();
		lblTituloListaTratamientos.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloListaTratamientos.setForeground(new Color(78, 175, 93));
		lblTituloListaTratamientos.setBounds(154, 40, 220, 40);
		panelDerechaArriba.add(lblTituloListaTratamientos);
			
	}

	public void textfield() {
		
		//Textfields DATOS PERSONALES
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNombreCompleto.setBounds(204, 10, 185, 20);
		panelDatosEspecialista.add(txtNombreCompleto);	
		
		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNumeroDocumento.setBounds(204, 53, 185, 20);
		panelDatosEspecialista.add(txtNumeroDocumento);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtCorreoElectronico.setBounds(204, 139, 185, 20);
		panelDatosEspecialista.add(txtCorreoElectronico);
		
		//Textfields TRATAMIENTO PACIENTE
		txtExamenP = new JTextField();
		txtExamenP.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtExamenP.setBounds(164, 92, 338, 25);
		panelTratamientoP.add(txtExamenP);
		
		txtDiagnosticoP = new JTextField();
		txtDiagnosticoP.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtDiagnosticoP.setBounds(164, 132, 338, 25);
		panelTratamientoP.add(txtDiagnosticoP);
		
		txtTratamientoP = new JTextField();
		txtTratamientoP.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtTratamientoP.setBounds(164, 172, 338, 45);
		panelTratamientoP.add(txtTratamientoP);
	}

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
		panelVariableTurno.add(btnTurnosMes);
		
		imgBtnCambioTurno = new ImageIcon("media\\btnCambioTurno.png");	
		btnCambioTurno = new JButton(imgBtnCambioTurno);
		btnCambioTurno.setBorder(null);
		btnCambioTurno.setBounds(298, 32, 200, 40);
		panelVariableTurno.add(btnCambioTurno);
		
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
		btnVolverMenu.setBounds(806, 507, 175, 42);
		add(btnVolverMenu);
		
		imgBtnToolTip = new ImageIcon("media\\btnToolTipEspecialista.png");
		btnTooltipEspecialista = new JButton(imgBtnToolTip);
		btnTooltipEspecialista.setBorder(null);
		btnTooltipEspecialista.setBounds(931, 2, 68, 68);
		btnTooltipEspecialista.setToolTipText("Panel de gestión para especialistas médicos");
		add(btnTooltipEspecialista);
	}

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

	public JPanel getPanelFijoIzq() {
		return panelFijoIzq;
	}

	public void setPanelFijoIzq(JPanel panelFijoIzq) {
		this.panelFijoIzq = panelFijoIzq;
	}

	public JPanel getPanelDerechaArriba() {
		return panelDerechaArriba;
	}

	public void setPanelDerechaArriba(JPanel panelDerechaArriba) {
		this.panelDerechaArriba = panelDerechaArriba;
	}

	public JPanel getPanelDatosEspecialista() {
		return panelDatosEspecialista;
	}

	public void setPanelDatosEspecialista(JPanel panelDatosEspecialista) {
		this.panelDatosEspecialista = panelDatosEspecialista;
	}

	public JPanel getPanelCitasMedicas() {
		return panelCitasMedicas;
	}

	public void setPanelCitasMedicas(JPanel panelCitasMedicas) {
		this.panelCitasMedicas = panelCitasMedicas;
	}

	public JPanel getPanelTurnoMes() {
		return panelTurnoMes;
	}

	public void setPanelTurnoMes(JPanel panelTurnoMes) {
		this.panelTurnoMes = panelTurnoMes;
	}

	public JPanel getPanelCambioTurno() {
		return panelCambioTurno;
	}

	public void setPanelCambioTurno(JPanel panelCambioTurno) {
		this.panelCambioTurno = panelCambioTurno;
	}

	public JPanel getPanelTratamientoP() {
		return panelTratamientoP;
	}

	public void setPanelTratamientoP(JPanel panelTratamientoP) {
		this.panelTratamientoP = panelTratamientoP;
	}

	public JPanel getPanelListaTratamiento() {
		return panelListaTratamiento;
	}

	public void setPanelListaTratamiento(JPanel panelListaTratamiento) {
		this.panelListaTratamiento = panelListaTratamiento;
	}

	public JPanel getPanelVariableTurno() {
		return panelVariableTurno;
	}

	public void setPanelVariableTurno(JPanel panelVariableTurno) {
		this.panelVariableTurno = panelVariableTurno;
	}

	public JTextField getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
	}

	public JTextField getTxtNumeroDocumento() {
		return txtNumeroDocumento;
	}

	public void setTxtNumeroDocumento(JTextField txtNumeroDocumento) {
		this.txtNumeroDocumento = txtNumeroDocumento;
	}

	public JTextField getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	public JTextField getTxtExamenP() {
		return txtExamenP;
	}

	public void setTxtExamenP(JTextField txtExamenP) {
		this.txtExamenP = txtExamenP;
	}

	public JTextField getTxtDiagnosticoP() {
		return txtDiagnosticoP;
	}

	public void setTxtDiagnosticoP(JTextField txtDiagnosticoP) {
		this.txtDiagnosticoP = txtDiagnosticoP;
	}

	public JTextField getTxtTratamientoP() {
		return txtTratamientoP;
	}

	public void setTxtTratamientoP(JTextField txtTratamientoP) {
		this.txtTratamientoP = txtTratamientoP;
	}

	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public JDateChooser getFechaTratamientoP() {
		return fechaTratamientoP;
	}

	public void setFechaTratamientoP(JDateChooser fechaTratamientoP) {
		this.fechaTratamientoP = fechaTratamientoP;
	}

	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public JComboBox<String> getCmbEspecialidadDP() {
		return cmbEspecialidadDP;
	}

	public void setCmbEspecialidadDP(JComboBox<String> cmbEspecialidadDP) {
		this.cmbEspecialidadDP = cmbEspecialidadDP;
	}

	public JComboBox<String> getCmbFechaTurno() {
		return cmbFechaTurno;
	}

	public void setCmbFechaTurno(JComboBox<String> cmbFechaTurno) {
		this.cmbFechaTurno = cmbFechaTurno;
	}

	public JComboBox<String> getCmbEspecialistaActual() {
		return cmbEspecialistaActual;
	}

	public void setCmbEspecialistaActual(JComboBox<String> cmbEspecialistaActual) {
		this.cmbEspecialistaActual = cmbEspecialistaActual;
	}

	public JComboBox<String> getCmbNuevoEspecialista() {
		return cmbNuevoEspecialista;
	}

	public void setCmbNuevoEspecialista(JComboBox<String> cmbNuevoEspecialista) {
		this.cmbNuevoEspecialista = cmbNuevoEspecialista;
	}

	public JComboBox<String> getCmbEscogerPaciente() {
		return cmbEscogerPaciente;
	}

	public void setCmbEscogerPaciente(JComboBox<String> cmbEscogerPaciente) {
		this.cmbEscogerPaciente = cmbEscogerPaciente;
	}

	public JLabel getLblNombreCompleto() {
		return lblNombreCompleto;
	}

	public void setLblNombreCompleto(JLabel lblNombreCompleto) {
		this.lblNombreCompleto = lblNombreCompleto;
	}

	public JLabel getLblNumeroDocumento() {
		return lblNumeroDocumento;
	}

	public void setLblNumeroDocumento(JLabel lblNumeroDocumento) {
		this.lblNumeroDocumento = lblNumeroDocumento;
	}

	public JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public JLabel getLblTituloDatosP() {
		return lblTituloDatosP;
	}

	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
		this.lblTituloDatosP = lblTituloDatosP;
	}

	public JLabel getLblTituloCitasMe() {
		return lblTituloCitasMe;
	}

	public void setLblTituloCitasMe(JLabel lblTituloCitasMe) {
		this.lblTituloCitasMe = lblTituloCitasMe;
	}

	public JLabel getLblFechaTurno() {
		return lblFechaTurno;
	}

	public void setLblFechaTurno(JLabel lblFechaTurno) {
		this.lblFechaTurno = lblFechaTurno;
	}

	public JLabel getLblEspecialistaActu() {
		return lblEspecialistaActu;
	}

	public void setLblEspecialistaActu(JLabel lblEspecialistaActu) {
		this.lblEspecialistaActu = lblEspecialistaActu;
	}

	public JLabel getLblNuevoEspecialista() {
		return lblNuevoEspecialista;
	}

	public void setLblNuevoEspecialista(JLabel lblNuevoEspecialista) {
		this.lblNuevoEspecialista = lblNuevoEspecialista;
	}

	public JLabel getLblTituloTratamientoPaciente() {
		return lblTituloTratamientoPaciente;
	}

	public void setLblTituloTratamientoPaciente(JLabel lblTituloTratamientoPaciente) {
		this.lblTituloTratamientoPaciente = lblTituloTratamientoPaciente;
	}

	public JLabel getLblFechaTratamientoPaciente() {
		return lblFechaTratamientoPaciente;
	}

	public void setLblFechaTratamientoPaciente(JLabel lblFechaTratamientoPaciente) {
		this.lblFechaTratamientoPaciente = lblFechaTratamientoPaciente;
	}

	public JLabel getLblEscogerPaciente() {
		return lblEscogerPaciente;
	}

	public void setLblEscogerPaciente(JLabel lblEscogerPaciente) {
		this.lblEscogerPaciente = lblEscogerPaciente;
	}

	public JLabel getLblExamenPaciente() {
		return lblExamenPaciente;
	}

	public void setLblExamenPaciente(JLabel lblExamenPaciente) {
		this.lblExamenPaciente = lblExamenPaciente;
	}

	public JLabel getLblDiagnosticoPaciente() {
		return lblDiagnosticoPaciente;
	}

	public void setLblDiagnosticoPaciente(JLabel lblDiagnosticoPaciente) {
		this.lblDiagnosticoPaciente = lblDiagnosticoPaciente;
	}

	public JLabel getLblTratamientoPaciente() {
		return lblTratamientoPaciente;
	}

	public void setLblTratamientoPaciente(JLabel lblTratamientoPaciente) {
		this.lblTratamientoPaciente = lblTratamientoPaciente;
	}

	public JLabel getLblTituloListaTratamientos() {
		return lblTituloListaTratamientos;
	}

	public void setLblTituloListaTratamientos(JLabel lblTituloListaTratamientos) {
		this.lblTituloListaTratamientos = lblTituloListaTratamientos;
	}

	public JButton getBtnDatosPersonales() {
		return btnDatosPersonales;
	}

	public void setBtnDatosPersonales(JButton btnDatosPersonales) {
		this.btnDatosPersonales = btnDatosPersonales;
	}

	public JButton getBtnCitas() {
		return btnCitas;
	}

	public void setBtnCitas(JButton btnCitas) {
		this.btnCitas = btnCitas;
	}

	public JButton getBtnTurno() {
		return btnTurno;
	}

	public void setBtnTurno(JButton btnTurno) {
		this.btnTurno = btnTurno;
	}

	public JButton getBtnTratamientoPaciente() {
		return btnTratamientoPaciente;
	}

	public void setBtnTratamientoPaciente(JButton btnTratamientoPaciente) {
		this.btnTratamientoPaciente = btnTratamientoPaciente;
	}

	public JButton getBtnListaTratamientos() {
		return btnListaTratamientos;
	}

	public void setBtnListaTratamientos(JButton btnListaTratamientos) {
		this.btnListaTratamientos = btnListaTratamientos;
	}

	public JButton getBtnGuardarDatosP() {
		return btnGuardarDatosP;
	}

	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
		this.btnGuardarDatosP = btnGuardarDatosP;
	}

	public JButton getBtnTurnosMes() {
		return btnTurnosMes;
	}

	public void setBtnTurnosMes(JButton btnTurnosMes) {
		this.btnTurnosMes = btnTurnosMes;
	}

	public JButton getBtnCambioTurno() {
		return btnCambioTurno;
	}

	public void setBtnCambioTurno(JButton btnCambioTurno) {
		this.btnCambioTurno = btnCambioTurno;
	}

	public JButton getBtnGenerarCambioTurno() {
		return btnGenerarCambioTurno;
	}

	public void setBtnGenerarCambioTurno(JButton btnGenerarCambioTurno) {
		this.btnGenerarCambioTurno = btnGenerarCambioTurno;
	}

	public JButton getBtnGuardarTratamiento() {
		return btnGuardarTratamiento;
	}

	public void setBtnGuardarTratamiento(JButton btnGuardarTratamiento) {
		this.btnGuardarTratamiento = btnGuardarTratamiento;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	public JButton getBtnTooltipEspecialista() {
		return btnTooltipEspecialista;
	}

	public void setBtnTooltipEspecialista(JButton btnTooltipEspecialista) {
		this.btnTooltipEspecialista = btnTooltipEspecialista;
	}

	public ImageIcon getImgBtnDatos() {
		return imgBtnDatos;
	}

	public void setImgBtnDatos(ImageIcon imgBtnDatos) {
		this.imgBtnDatos = imgBtnDatos;
	}

	public ImageIcon getImgBtnCitas() {
		return imgBtnCitas;
	}

	public void setImgBtnCitas(ImageIcon imgBtnCitas) {
		this.imgBtnCitas = imgBtnCitas;
	}

	public ImageIcon getImgBtnTurnos() {
		return imgBtnTurnos;
	}

	public void setImgBtnTurnos(ImageIcon imgBtnTurnos) {
		this.imgBtnTurnos = imgBtnTurnos;
	}

	public ImageIcon getImgBtnTratamiento() {
		return imgBtnTratamiento;
	}

	public void setImgBtnTratamiento(ImageIcon imgBtnTratamiento) {
		this.imgBtnTratamiento = imgBtnTratamiento;
	}

	public ImageIcon getImgBtnListaTratamientos() {
		return imgBtnListaTratamientos;
	}

	public void setImgBtnListaTratamientos(ImageIcon imgBtnListaTratamientos) {
		this.imgBtnListaTratamientos = imgBtnListaTratamientos;
	}

	public ImageIcon getImgBtnVolver() {
		return imgBtnVolver;
	}

	public void setImgBtnVolver(ImageIcon imgBtnVolver) {
		this.imgBtnVolver = imgBtnVolver;
	}

	public ImageIcon getImgBtnGuardarDatos() {
		return imgBtnGuardarDatos;
	}

	public void setImgBtnGuardarDatos(ImageIcon imgBtnGuardarDatos) {
		this.imgBtnGuardarDatos = imgBtnGuardarDatos;
	}

	public ImageIcon getImgBtnTurnosMes() {
		return imgBtnTurnosMes;
	}

	public void setImgBtnTurnosMes(ImageIcon imgBtnTurnosMes) {
		this.imgBtnTurnosMes = imgBtnTurnosMes;
	}

	public ImageIcon getImgBtnCambioTurno() {
		return imgBtnCambioTurno;
	}

	public void setImgBtnCambioTurno(ImageIcon imgBtnCambioTurno) {
		this.imgBtnCambioTurno = imgBtnCambioTurno;
	}

	public ImageIcon getImgBtnConfirmarCambio() {
		return imgBtnConfirmarCambio;
	}

	public void setImgBtnConfirmarCambio(ImageIcon imgBtnConfirmarCambio) {
		this.imgBtnConfirmarCambio = imgBtnConfirmarCambio;
	}

	public ImageIcon getImgBtnGuardarTratamiento() {
		return imgBtnGuardarTratamiento;
	}

	public void setImgBtnGuardarTratamiento(ImageIcon imgBtnGuardarTratamiento) {
		this.imgBtnGuardarTratamiento = imgBtnGuardarTratamiento;
	}

	public ImageIcon getImgBtnToolTip() {
		return imgBtnToolTip;
	}

	public void setImgBtnToolTip(ImageIcon imgBtnToolTip) {
		this.imgBtnToolTip = imgBtnToolTip;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public static String getTurnosmes() {
		return TURNOSMES;
	}

	public static String getCambioturno() {
		return CAMBIOTURNO;
	}

}
