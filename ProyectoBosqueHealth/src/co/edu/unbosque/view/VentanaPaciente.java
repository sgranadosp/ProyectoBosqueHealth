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
	btnGuardarCancelarCita, btnVolverMenu;
	
	private ImageIcon imgBtnDatosPersonales, imgBtnCitas, imgBtnTratamientoMedico,
		imgBtnGuardarDatosPersonales,
		imgBtnAgendarCita, imgBtnCitasAgendadas, imgBtnReagendarCita, imgBtnCancelarCita,
		imgBtnGenerarCita, imgBtnReagendar, imgBtnCancelar, imgBtnVolverMenu;
	
	private final static String AGENDARCITA = "AgendarCita";
	private final static String CITASAGENDADAS = "CitasAgendadas";
	private final static String REAGENDARCITA = "ReagendarCita";
	private final static String CANCELARCITA = "CancelarCita";
	
	
	CardLayout cardLayout = new CardLayout();
	
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
		lblNumeroCitaReagendar = new JLabel("Número de cita:");
		lblNumeroCitaReagendar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroCitaReagendar.setForeground(new Color(78, 175, 93));
		lblNumeroCitaReagendar.setBounds(30, 35, 180, 20);
		panelReagendarCita.add(lblNumeroCitaReagendar);
		
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
		

		//Labels CITAS - CANCELAR CITA
		lblNumeroCitaCancelar = new JLabel("Número de cita:");
		lblNumeroCitaCancelar.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroCitaCancelar.setForeground(new Color(78, 175, 93));
		lblNumeroCitaCancelar.setBounds(30, 35, 180, 20);
		panelCancelarCita.add(lblNumeroCitaReagendar);
		
		
		//Labels CITAS - TRATAMIENTO MEDICO
		lblTituloTratamientoMedico = new JLabel("Tratamiento médico:");
		lblTituloTratamientoMedico.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloTratamientoMedico.setForeground(new Color(78, 175, 93));
		lblTituloTratamientoMedico.setBounds(30, 40, 350, 40);
		panelDerechaArriba.add(lblTituloTratamientoMedico);

		
	}
	public void textfield() {
		//TextFields Datos personales
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNombreCompleto.setBounds(240, 35, 200, 20);
		panelDatosPaciente.add(txtNombreCompleto);	

		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNumeroDocumento.setBounds(240, 70, 200, 20);
		panelDatosPaciente.add(txtNumeroDocumento);
	
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtCorreoElectronico.setBounds(240, 140, 200, 20);
		panelDatosPaciente.add(txtCorreoElectronico);
		
		//TextFields Citas - Agendar
		txtHora = new JTextField();
		txtHora.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtHora.setBounds(240, 140, 200, 20);
		panelAgendarCitas.add(txtHora);

		//TextFields Citas - Reagendar
		txtNumeroReagendarCita = new JTextField();
		txtNumeroReagendarCita.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNumeroReagendarCita.setBounds(240, 35, 200, 20);
		panelReagendarCita.add(txtNumeroReagendarCita);

		txtHoraReagendarCita = new JTextField();
		txtHoraReagendarCita.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtHoraReagendarCita.setBounds(240, 105, 200, 20);
		panelReagendarCita.add(txtHoraReagendarCita);

		//TextFields Citas - Cancelar
		txtNumeroCancelarCita = new JTextField();
		txtNumeroCancelarCita.setFont(new Font("Agency FB", Font.BOLD, 12));
		txtNumeroCancelarCita.setBounds(240, 35, 200, 20);
		panelCancelarCita.add(txtNumeroCancelarCita);
		
	}
	
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
		imgBtnGenerarCita = new ImageIcon("media\\btnGuardarGenerarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGenerarCita = new JButton(imgBtnGenerarCita);
		btnGenerarCita.setBorder(null);
		btnGenerarCita.setBounds(270, 360, 229, 27);
		panelAgendarCitas.add(btnGenerarCita);

		
		// botón Reagendar (Reagendar cita)
		imgBtnReagendar = new ImageIcon("media\\btnGuardarReagendarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGuardarReagendarCita = new JButton(imgBtnReagendar);
		btnGuardarReagendarCita.setBorder(null);
		btnGuardarReagendarCita.setBounds(270, 360,  229, 27);
		panelReagendarCita.add(btnGuardarReagendarCita);

		// botón Cancelar (Cancelar cita)
		imgBtnCancelar = new ImageIcon("media\\btnGuardarCancelarCita.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnGuardarCancelarCita = new JButton(imgBtnCancelar);
		btnGuardarCancelarCita.setBorder(null);
		btnGuardarCancelarCita.setBounds(270, 360,  229, 27);
		panelCancelarCita.add(btnGuardarCancelarCita);
		
		//boton menu principal
		imgBtnVolverMenu = new ImageIcon("media\\btnVolverMenu.png"); // OJO **** PENDIENTE DEFINIR IMAGEN
		btnVolverMenu = new JButton(imgBtnVolverMenu);
		btnVolverMenu.setBorder(null);
		btnVolverMenu.setBounds(800, 475, 174, 40);
		add(btnVolverMenu);
		
		
		
	}
	
	
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
		fechaReagendarCita.setBounds(240, 105, 200, 20);
		panelReagendarCita.add(fechaReagendarCita);
		
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


	public JPanel getPanelDatosPaciente() {
		return panelDatosPaciente;
	}


	public void setPanelDatosPaciente(JPanel panelDatosPaciente) {
		this.panelDatosPaciente = panelDatosPaciente;
	}


	public JPanel getPanelAgendarCitas() {
		return panelAgendarCitas;
	}


	public void setPanelAgendarCitas(JPanel panelAgendarCitas) {
		this.panelAgendarCitas = panelAgendarCitas;
	}


	public JPanel getPanelCitasAgendadas() {
		return panelCitasAgendadas;
	}


	public void setPanelCitasAgendadas(JPanel panelCitasAgendadas) {
		this.panelCitasAgendadas = panelCitasAgendadas;
	}


	public JPanel getPanelReagendarCita() {
		return panelReagendarCita;
	}


	public void setPanelReagendarCita(JPanel panelReagendarCita) {
		this.panelReagendarCita = panelReagendarCita;
	}


	public JPanel getPanelCancelarCita() {
		return panelCancelarCita;
	}


	public void setPanelCancelarCita(JPanel panelCancelarCita) {
		this.panelCancelarCita = panelCancelarCita;
	}


	public JPanel getPanelTratamientoMedico() {
		return panelTratamientoMedico;
	}


	public void setPanelTratamientoMedico(JPanel panelTratamientoMedico) {
		this.panelTratamientoMedico = panelTratamientoMedico;
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


	public JTextField getTxtHora() {
		return txtHora;
	}


	public void setTxtHora(JTextField txtHora) {
		this.txtHora = txtHora;
	}


	public JTextField getTxtNumeroReagendarCita() {
		return txtNumeroReagendarCita;
	}


	public void setTxtNumeroReagendarCita(JTextField txtNumeroReagendarCita) {
		this.txtNumeroReagendarCita = txtNumeroReagendarCita;
	}


	public JTextField getTxtNumeroCancelarCita() {
		return txtNumeroCancelarCita;
	}


	public void setTxtNumeroCancelarCita(JTextField txtNumeroCancelarCita) {
		this.txtNumeroCancelarCita = txtNumeroCancelarCita;
	}


	public JDateChooser getFechaAgendarCita() {
		return fechaAgendarCita;
	}



	public void setFechaAgendarCita(JDateChooser fechaAgendarCita) {
		this.fechaAgendarCita = fechaAgendarCita;
	}



	public JDateChooser getFechaReagendarCita() {
		return fechaReagendarCita;
	}



	public void setFechaReagendarCita(JDateChooser fechaReagendarCita) {
		this.fechaReagendarCita = fechaReagendarCita;
	}



	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}


	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}


	public JComboBox<String> getCmbEspecialidad() {
		return cmbEspecialidad;
	}


	public void setCmbEspecialidad(JComboBox<String> cmbEspecialidad) {
		this.cmbEspecialidad = cmbEspecialidad;
	}


	public JComboBox<String> getCmbEspecialistas() {
		return cmbEspecialistas;
	}


	public void setCmbEspecialistas(JComboBox<String> cmbEspecialistas) {
		this.cmbEspecialistas = cmbEspecialistas;
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


	public JLabel getLblTituloDatosP() {
		return lblTituloDatosP;
	}


	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
		this.lblTituloDatosP = lblTituloDatosP;
	}


	public JLabel getLblEspecialidadAgendar() {
		return lblEspecialidadAgendar;
	}


	public void setLblEspecialidadAgendar(JLabel lblEspecialidadAgendar) {
		this.lblEspecialidadAgendar = lblEspecialidadAgendar;
	}


	public JLabel getLblEspecialistasAgendar() {
		return lblEspecialistasAgendar;
	}


	public void setLblEspecialistasAgendar(JLabel lblEspecialistasAgendar) {
		this.lblEspecialistasAgendar = lblEspecialistasAgendar;
	}


	public JLabel getLblFechaAgendar() {
		return lblFechaAgendar;
	}


	public void setLblFechaAgendar(JLabel lblFechaAgendar) {
		this.lblFechaAgendar = lblFechaAgendar;
	}


	public JLabel getLblHoraAgendar() {
		return lblHoraAgendar;
	}


	public void setLblHoraAgendar(JLabel lblHoraAgendar) {
		this.lblHoraAgendar = lblHoraAgendar;
	}


	public JLabel getLblNumeroCitaReagendar() {
		return lblNumeroCitaReagendar;
	}


	public void setLblNumeroCitaReagendar(JLabel lblNumeroCitaReagendar) {
		this.lblNumeroCitaReagendar = lblNumeroCitaReagendar;
	}


	public JLabel getLblFechaReagendar() {
		return lblFechaReagendar;
	}


	public void setLblFechaReagendar(JLabel lblFechaReagendar) {
		this.lblFechaReagendar = lblFechaReagendar;
	}


	public JLabel getLblHoraReagendar() {
		return lblHoraReagendar;
	}


	public void setLblHoraReagendar(JLabel lblHoraReagendar) {
		this.lblHoraReagendar = lblHoraReagendar;
	}


	public JLabel getLblNumeroCitaCancelar() {
		return lblNumeroCitaCancelar;
	}


	public void setLblNumeroCitaCancelar(JLabel lblNumeroCitaCancelar) {
		this.lblNumeroCitaCancelar = lblNumeroCitaCancelar;
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


	public JButton getBtnTratamientoMedico() {
		return btnTratamientoMedico;
	}


	public void setBtnTratamientoMedico(JButton btnTratamientoMedico) {
		this.btnTratamientoMedico = btnTratamientoMedico;
	}


	public JButton getBtnGuardarDatosP() {
		return btnGuardarDatosP;
	}


	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
		this.btnGuardarDatosP = btnGuardarDatosP;
	}


	public JButton getBtnGenerarCita() {
		return btnGenerarCita;
	}


	public void setBtnGenerarCita(JButton btnGenerarCita) {
		this.btnGenerarCita = btnGenerarCita;
	}


	public JButton getBtnAgendarCita() {
		return btnAgendarCita;
	}


	public void setBtnAgendarCita(JButton btnAgendarCita) {
		this.btnAgendarCita = btnAgendarCita;
	}


	public JButton getBtnCitasAgendadas() {
		return btnCitasAgendadas;
	}


	public void setBtnCitasAgendadas(JButton btnCitasAgendadas) {
		this.btnCitasAgendadas = btnCitasAgendadas;
	}


	public JButton getBtnReagendarCitas() {
		return btnReagendarCitas;
	}


	public void setBtnReagendarCitas(JButton btnReagendarCitas) {
		this.btnReagendarCitas = btnReagendarCitas;
	}


	public JButton getBtnCancelarCita() {
		return btnCancelarCita;
	}


	public void setBtnCancelarCita(JButton btnCancelarCita) {
		this.btnCancelarCita = btnCancelarCita;
	}


	public JButton getBtnGuardarReagendarCita() {
		return btnGuardarReagendarCita;
	}


	public void setBtnGuardarReagendarCita(JButton btnGuardarReagendarCita) {
		this.btnGuardarReagendarCita = btnGuardarReagendarCita;
	}


	public JButton getBtnGuardarCancelarCita() {
		return btnGuardarCancelarCita;
	}


	public void setBtnGuardarCancelarCita(JButton btnGuardarCancelarCita) {
		this.btnGuardarCancelarCita = btnGuardarCancelarCita;
	}


	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}


	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}



	public CardLayout getCardLayout() {
		return cardLayout;
	}



	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}


	public String getAgendarcita() {
		return AGENDARCITA;
	}



	public String getCitasAgendadas() {
		return CITASAGENDADAS;
	}



	public String getReagendarcita() {
		return REAGENDARCITA;
	}



	public String getCancelarcita() {
		return CANCELARCITA;
	}



	public JPanel getPanelVariableCitas() {
		return panelVariableCitas;
	}



	public void setPanelVariableCitas(JPanel panelVariableCitas) {
		this.panelVariableCitas = panelVariableCitas;
	}



	public JTextField getTxtHoraReagendarCita() {
		return txtHoraReagendarCita;
	}



	public void setTxtHoraReagendarCita(JTextField txtHoraReagendarCita) {
		this.txtHoraReagendarCita = txtHoraReagendarCita;
	}



	public JLabel getLblTituloTratamientoMedico() {
		return lblTituloTratamientoMedico;
	}



	public void setLblTituloTratamientoMedico(JLabel lblTituloTratamientoMedico) {
		this.lblTituloTratamientoMedico = lblTituloTratamientoMedico;
	}
	
	

}
