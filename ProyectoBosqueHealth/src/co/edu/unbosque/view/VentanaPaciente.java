package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class VentanaPaciente extends JPanel{

	private JLabel imgFija, datosPersArriba, datosPersAbajo, citasArriba, agendarAbajo, mostrarCitasAbajo, reagendarCitaAbajo, cancelarCitaAbajo, tratamiento;
	private JTextField nombrePac, documentoPac, correoPac, horaCita, numeroCita, horaCitaReagendar, numeroCitaCancelar;
	private JCalendar fechaNacimientoPac, fechaCita, fechaCitaReagendar;
	private JComboBox<String> generoPac, especialidad, especialista;
	private JButton btnVolverMenu, btnDatosPersonales, btnCitas, btnTratamientoMedico, btnTooltipPac, btnGuardarDatos, btnAgendar, btnGenerarCita,
	btnCitasGeneradas, btnReagendar, btnGenerarReagendada, btnCancelar, btnCancelarCita;
	CardLayout cardLayout = new CardLayout();
	private JPanel panelFijo, panelArribaVariable, panelAbajoVariable;
	private final static String DATOS = "Datos personales";
	private final static String AGENDARCITA = "Agendar cita";
	private final static String MOSTRARCITA = "Mostrar cita";
	private final static String REAGENDARCITA = "Reagendar cita";
	private final static String CANCELARCITA = "Cancelar cita";
	private final static String TRATAMIENTO = "Tratamientos";
	
	public void paneles() {
		
		panelFijo = new JPanel();
		panelFijo.setLayout(null);
		panelFijo.setBounds(0, 0, 1280, 720);
		panelFijo.setBackground(Color.WHITE);
		
		panelArribaVariable = new JPanel(cardLayout);
		panelArribaVariable.setBounds(600, 100, 500, 100);
		panelArribaVariable.setBackground(Color.WHITE);
		panelArribaVariable.add(panelFijo, DATOS);
		panelArribaVariable.add(panelFijo, AGENDARCITA);
		panelArribaVariable.add(panelFijo, MOSTRARCITA);
		panelArribaVariable.add(panelFijo, REAGENDARCITA);
		panelArribaVariable.add(panelFijo, CANCELARCITA);
		panelArribaVariable.add(panelFijo, TRATAMIENTO);
		
		panelAbajoVariable = new JPanel(cardLayout);
		panelAbajoVariable.setBounds(600, 100, 500, 100);
		panelAbajoVariable.setBackground(Color.WHITE);
		panelAbajoVariable.add(panelFijo, DATOS);
		panelAbajoVariable.add(panelFijo, AGENDARCITA);
		panelAbajoVariable.add(panelFijo, MOSTRARCITA);
		panelAbajoVariable.add(panelFijo, REAGENDARCITA);
		panelAbajoVariable.add(panelFijo, CANCELARCITA);
		panelAbajoVariable.add(panelFijo, TRATAMIENTO);
		
	}
	
	public VentanaPaciente() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		//Fondo fijo para pacientes
		
		imgFija = new JLabel();
		ImageIcon imagenPaciente = new ImageIcon("media/imgsPaciente/ImgPacienteFija.png");
		Image redimensionado = imagenPaciente.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgFija.setIcon(new ImageIcon(redimensionado));
		imgFija.setBounds(0, 0, 1280, 720);
		panelFijo.add(imgFija);
		
		//Imágen arriba título datos personales de pacientes
		
		datosPersArriba = new JLabel();
		ImageIcon imagenDatosAr = new ImageIcon("media/imgsPaciente/ImgDatosPersArriba.png");
		Image redimensionado2 = imagenDatosAr.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPersArriba.setIcon(new ImageIcon(redimensionado2));
		datosPersArriba.setBounds(0, 0, 1280, 720);
		panelArribaVariable.add(datosPersArriba);
		
		//Botones que van fijos (citas,datos,tratamiento, volver)
		
		btnTooltipPac = new JButton();
		btnTooltipPac.setToolTipText("Panel de gestión para pacientes");
		btnTooltipPac.setBounds(1200, 0, 40, 40);
		btnTooltipPac.setOpaque(true);
		panelFijo.add(btnTooltipPac);
		
		btnVolverMenu = new JButton("Volver al Menú Principal");
		btnVolverMenu.setBounds(1100, 600, 250, 70);
		btnVolverMenu.setOpaque(true);
		btnVolverMenu.setActionCommand("VOLVER AL MENU");
		panelFijo.add(btnVolverMenu);
		
		btnDatosPersonales = new JButton("Datos personales");
		btnDatosPersonales.setBounds(500, 100, 250, 70);
		btnDatosPersonales.setOpaque(true);
		btnDatosPersonales.setActionCommand("DATOS PERSONALES");
		panelFijo.add(btnDatosPersonales);
		
		btnCitas = new JButton("Citas");
		btnCitas.setBounds(500, 200, 250, 70);
		btnCitas.setOpaque(true);
		btnCitas.setActionCommand("CITAS");
		panelFijo.add(btnCitas);
		
		btnTratamientoMedico = new JButton("Tratamiento Médico");
		btnTratamientoMedico.setBounds(500, 300, 250, 70);
		btnTratamientoMedico.setOpaque(true);
		btnTratamientoMedico.setActionCommand("TRATAMIENTO MÉDICO");
		panelFijo.add(btnTratamientoMedico);
		
		//Imágen y botones del panel de abajo variable de datos personales del paciente
		
		datosPersAbajo = new JLabel();
		ImageIcon imagenDatosAb = new ImageIcon("media/imgsPaciente/ImgDatosPersAbajo.png");
		Image redimensionado3 = imagenDatosAb.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPersAbajo.setIcon(new ImageIcon(redimensionado3));
		datosPersAbajo.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(datosPersAbajo);
		
		nombrePac = new JTextField();
		nombrePac.setBounds(0, 0, 250, 70);
		nombrePac.setOpaque(true);
		panelAbajoVariable.add(nombrePac);
		
		documentoPac = new JTextField();
		documentoPac.setBounds(0, 100, 250, 70);
		documentoPac.setOpaque(true);
		panelAbajoVariable.add(documentoPac);
		
		fechaNacimientoPac = new JCalendar();
		fechaNacimientoPac.setBounds(0, 200, 250, 70);
		fechaNacimientoPac.setOpaque(true);
		panelAbajoVariable.add(fechaNacimientoPac);
		
		correoPac = new JTextField();
		correoPac.setBounds(0, 300, 250, 70);
		correoPac.setOpaque(true);
		panelAbajoVariable.add(correoPac);
		
		generoPac = new JComboBox<String>();
		generoPac.setBounds(0, 400, 250, 70);
		generoPac.addItem("");
		generoPac.addItem("Femenino");
		generoPac.addItem("Masculino");
		generoPac.addItem("Otro");
		panelAbajoVariable.add(generoPac);
		
		btnGuardarDatos = new JButton("Guardar datos");
		btnGuardarDatos.setBounds(0, 530, 250, 70);
		btnGuardarDatos.setOpaque(true);
		btnGuardarDatos.setActionCommand("GUARDAR DATOS");
		panelAbajoVariable.add(btnGuardarDatos);
		
		//Imágen panel de arriba variable y botones del panel Citas pacientes
		
		citasArriba = new JLabel();
		ImageIcon imagenAgendarAr = new ImageIcon("media/imgsPaciente/ImgCitasArribaPac.png");
		Image redimensionado4 = imagenAgendarAr.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		citasArriba.setIcon(new ImageIcon(redimensionado4));
		citasArriba.setBounds(0, 0, 1280, 720);
		panelArribaVariable.add(citasArriba);
		
		btnAgendar = new JButton();
		btnAgendar.setBounds(0, 0, 250, 70);
		btnAgendar.setOpaque(true);
		btnAgendar.setActionCommand("AGENDAR CITA");
		panelArribaVariable.add(btnAgendar);
		
		btnCitasGeneradas = new JButton();
		btnCitasGeneradas.setBounds(300, 0, 250, 70);
		btnCitasGeneradas.setOpaque(true);
		btnCitasGeneradas.setActionCommand("CITAS AGENDADAS");
		panelArribaVariable.add(btnCitasGeneradas);
		
		btnReagendar = new JButton();
		btnReagendar.setBounds(0, 120, 250, 70);
		btnReagendar.setOpaque(true);
		btnReagendar.setActionCommand("REAGENDAR CITA");
		panelArribaVariable.add(btnReagendar);
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(300, 120, 250, 70);
		btnCancelar.setOpaque(true);
		btnCancelar.setActionCommand("CANCELAR");
		panelArribaVariable.add(btnCancelar);
		
		// Imágen, botones, etc del panel de abajp variable agendar cita
		
		agendarAbajo = new JLabel();
		ImageIcon imagenAgendarAb = new ImageIcon("media/imgsPaciente/ImgAgendarAbajo.png");
		Image redimensionado5 = imagenAgendarAb.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		agendarAbajo.setIcon(new ImageIcon(redimensionado5));
		agendarAbajo.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(agendarAbajo);
		
		especialidad = new JComboBox<String>();
		especialidad.setBounds(0, 200, 250, 70);
		especialidad.addItem("");
		especialidad.addItem("Cirugía");
		especialidad.addItem("Oncología");
		especialidad.addItem("Dermatología");
		especialidad.addItem("Neumología");
		especialidad.addItem("Cardiología");
		especialidad.addItem("Medicina Interna");
		panelAbajoVariable.add(especialidad);
		
		especialista = new JComboBox<String>();
		especialista.setBounds(0, 300, 250, 70);
		especialista.addItem("");
		panelAbajoVariable.add(especialista);
		
		fechaCita = new JCalendar();
		fechaCita.setBounds(0, 400, 250, 70);
		fechaCita.setOpaque(true);
		panelAbajoVariable.add(fechaCita);
		
		horaCita = new JTextField();
		horaCita.setBounds(0, 500, 250, 70); 
		horaCita.setOpaque(true);
		panelAbajoVariable.add(horaCita);
		
		btnGenerarCita = new JButton("Generar cita");
		btnGenerarCita.setBounds(0, 620, 250, 70);
		btnGenerarCita.setOpaque(true);
		btnGenerarCita.setActionCommand("GENERAR CITA");
		panelAbajoVariable.add(btnGenerarCita);
		
		//Imágen panel de abajo variable citas generadas / en este no hay panel inferior pq está vacío, solo va la tabla
		
		mostrarCitasAbajo = new JLabel();
		ImageIcon imagenMostrarAb = new ImageIcon("media/imgsPaciente/ImgMostrarAbajo.png");
		Image redimensionado6 = imagenMostrarAb.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		mostrarCitasAbajo.setIcon(new ImageIcon(redimensionado6));
		mostrarCitasAbajo.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(mostrarCitasAbajo);
		
		//Aquí va el bloque de código para hacer la tabla que muestra las citas ya generadas
		
		//Imágen panel de abajo variable para reagendar cita pacientes
		
		reagendarCitaAbajo = new JLabel();
		ImageIcon imagenReagendarAb = new ImageIcon("media/imgsPaciente/ImgReagendarAbajo.png");
		Image redimensionado7 = imagenReagendarAb.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		reagendarCitaAbajo.setIcon(new ImageIcon(redimensionado7));
		reagendarCitaAbajo.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(reagendarCitaAbajo);
		
		numeroCita = new JTextField();
		numeroCita.setBounds(0, 200, 250, 70);
		numeroCita.setOpaque(true);
		panelAbajoVariable.add(numeroCita);
		
		fechaCitaReagendar = new JCalendar();
		fechaCitaReagendar.setBounds(0, 300, 250, 70);
		fechaCitaReagendar.setOpaque(true);
		panelAbajoVariable.add(fechaCitaReagendar);
		
		horaCitaReagendar = new JTextField();
		horaCitaReagendar.setBounds(0, 400, 250, 70);
		horaCitaReagendar.setOpaque(true);
		panelAbajoVariable.add(horaCitaReagendar);
		
		btnGenerarReagendada = new JButton("Generar reagendar");
		btnGenerarReagendada.setBounds(0, 550, 250, 70);
		btnGenerarReagendada.setOpaque(true);
		btnGenerarReagendada.setActionCommand("GENERAR REAGENDAR CITA");
		panelAbajoVariable.add(btnGenerarReagendada);
		
		//Imágen, botones, etc panel variable de abajo para cancelar citas
		
		cancelarCitaAbajo = new JLabel();
		ImageIcon imagenCancelar= new ImageIcon("media/imgsPaciente/ImgCancelarAbajo.png");
		Image redimensionado8 = imagenCancelar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		cancelarCitaAbajo.setIcon(new ImageIcon(redimensionado8));
		cancelarCitaAbajo.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(cancelarCitaAbajo);
		
		numeroCitaCancelar = new JTextField();
		numeroCitaCancelar.setBounds(0, 400, 250, 70);
		numeroCitaCancelar.setOpaque(true);
		panelAbajoVariable.add(numeroCitaCancelar);
		
		btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.setBounds(0, 550, 250, 70);
		btnCancelarCita.setOpaque(true);
		btnCancelarCita.setActionCommand("CANCELAR CITA");
		panelAbajoVariable.add(btnCancelarCita);
		
		//Imágen panel variable de abajo para tratamientos
		
		tratamiento = new JLabel();
		ImageIcon imagenTratamiento= new ImageIcon("media/imgsPaciente/ImgMostrarAbajo.png");
		Image redimensionado9 = imagenTratamiento.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		tratamiento.setIcon(new ImageIcon(redimensionado9));
		tratamiento.setBounds(0, 0, 1280, 720);
		panelAbajoVariable.add(tratamiento);
		
		//Aquí va el bloque de código donde va la tabla que muestra los tratamientos
		
		add(panelFijo);
		add(panelArribaVariable);
		add(panelAbajoVariable);
	}

	public JLabel getImgFija() {
		return imgFija;
	}

	public void setImgFija(JLabel imgFija) {
		this.imgFija = imgFija;
	}

	public JLabel getDatosPersArriba() {
		return datosPersArriba;
	}

	public void setDatosPersArriba(JLabel datosPersArriba) {
		this.datosPersArriba = datosPersArriba;
	}

	public JLabel getDatosPersAbajo() {
		return datosPersAbajo;
	}

	public void setDatosPersAbajo(JLabel datosPersAbajo) {
		this.datosPersAbajo = datosPersAbajo;
	}

	public JLabel getCitasArriba() {
		return citasArriba;
	}

	public void setCitasArriba(JLabel citasArriba) {
		this.citasArriba = citasArriba;
	}

	public JLabel getAgendarAbajo() {
		return agendarAbajo;
	}

	public void setAgendarAbajo(JLabel agendarAbajo) {
		this.agendarAbajo = agendarAbajo;
	}

	public JLabel getMostrarCitasAbajo() {
		return mostrarCitasAbajo;
	}

	public void setMostrarCitasAbajo(JLabel mostrarCitasAbajo) {
		this.mostrarCitasAbajo = mostrarCitasAbajo;
	}

	public JLabel getReagendarCitaAbajo() {
		return reagendarCitaAbajo;
	}

	public void setReagendarCitaAbajo(JLabel reagendarCitaAbajo) {
		this.reagendarCitaAbajo = reagendarCitaAbajo;
	}

	public JLabel getCancelarCitaAbajo() {
		return cancelarCitaAbajo;
	}

	public void setCancelarCitaAbajo(JLabel cancelarCitaAbajo) {
		this.cancelarCitaAbajo = cancelarCitaAbajo;
	}

	public void setTratamiento(JLabel tratamiento) {
		this.tratamiento = tratamiento;
	}

	public JTextField getNombrePac() {
		return nombrePac;
	}

	public void setNombrePac(JTextField nombrePac) {
		this.nombrePac = nombrePac;
	}

	public JTextField getDocumentoPac() {
		return documentoPac;
	}

	public void setDocumentoPac(JTextField documentoPac) {
		this.documentoPac = documentoPac;
	}

	public JTextField getCorreoPac() {
		return correoPac;
	}

	public void setCorreoPac(JTextField correoPac) {
		this.correoPac = correoPac;
	}

	public JTextField getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(JTextField horaCita) {
		this.horaCita = horaCita;
	}

	public JTextField getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(JTextField numeroCita) {
		this.numeroCita = numeroCita;
	}

	public JTextField getHoraCitaReagendar() {
		return horaCitaReagendar;
	}

	public void setHoraCitaReagendar(JTextField horaCitaReagendar) {
		this.horaCitaReagendar = horaCitaReagendar;
	}

	public JTextField getNumeroCitaCancelar() {
		return numeroCitaCancelar;
	}

	public void setNumeroCitaCancelar(JTextField numeroCitaCancelar) {
		this.numeroCitaCancelar = numeroCitaCancelar;
	}

	public JCalendar getFechaNacimientoPac() {
		return fechaNacimientoPac;
	}

	public void setFechaNacimientoPac(JCalendar fechaNacimientoPac) {
		this.fechaNacimientoPac = fechaNacimientoPac;
	}

	public JCalendar getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(JCalendar fechaCita) {
		this.fechaCita = fechaCita;
	}

	public JCalendar getFechaCitaReagendar() {
		return fechaCitaReagendar;
	}

	public void setFechaCitaReagendar(JCalendar fechaCitaReagendar) {
		this.fechaCitaReagendar = fechaCitaReagendar;
	}

	public JComboBox<String> getGeneroPac() {
		return generoPac;
	}

	public void setGeneroPac(JComboBox<String> generoPac) {
		this.generoPac = generoPac;
	}

	public JComboBox<String> getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(JComboBox<String> especialidad) {
		this.especialidad = especialidad;
	}

	public JComboBox<String> getEspecialista() {
		return especialista;
	}

	public void setEspecialista(JComboBox<String> especialista) {
		this.especialista = especialista;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
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

	public JButton getBtnTooltipPac() {
		return btnTooltipPac;
	}

	public void setBtnTooltipPac(JButton btnTooltipPac) {
		this.btnTooltipPac = btnTooltipPac;
	}

	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}

	public void setBtnGuardarDatos(JButton btnGuardarDatos) {
		this.btnGuardarDatos = btnGuardarDatos;
	}

	public JButton getBtnAgendar() {
		return btnAgendar;
	}

	public void setBtnAgendar(JButton btnAgendar) {
		this.btnAgendar = btnAgendar;
	}

	public JButton getBtnGenerarCita() {
		return btnGenerarCita;
	}

	public void setBtnGenerarCita(JButton btnGenerarCita) {
		this.btnGenerarCita = btnGenerarCita;
	}

	public JButton getBtnCitasGeneradas() {
		return btnCitasGeneradas;
	}

	public void setBtnCitasGeneradas(JButton btnCitasGeneradas) {
		this.btnCitasGeneradas = btnCitasGeneradas;
	}

	public JButton getBtnReagendar() {
		return btnReagendar;
	}

	public void setBtnReagendar(JButton btnReagendar) {
		this.btnReagendar = btnReagendar;
	}

	public JButton getBtnGenerarReagendada() {
		return btnGenerarReagendada;
	}

	public void setBtnGenerarReagendada(JButton btnGenerarReagendada) {
		this.btnGenerarReagendada = btnGenerarReagendada;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnCancelarCita() {
		return btnCancelarCita;
	}

	public void setBtnCancelarCita(JButton btnCancelarCita) {
		this.btnCancelarCita = btnCancelarCita;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JPanel getPanelFijo() {
		return panelFijo;
	}

	public void setPanelFijo(JPanel panelFijo) {
		this.panelFijo = panelFijo;
	}

	public JPanel getPanelArribaVariable() {
		return panelArribaVariable;
	}

	public void setPanelArribaVariable(JPanel panelArribaVariable) {
		this.panelArribaVariable = panelArribaVariable;
	}

	public JPanel getPanelAbajoVariable() {
		return panelAbajoVariable;
	}

	public void setPanelAbajoVariable(JPanel panelAbajoVariable) {
		this.panelAbajoVariable = panelAbajoVariable;
	}

	public static String getDatos() {
		return DATOS;
	}

	public static String getAgendarcita() {
		return AGENDARCITA;
	}

	public static String getMostrarcita() {
		return MOSTRARCITA;
	}

	public static String getReagendarcita() {
		return REAGENDARCITA;
	}

	public static String getCancelarcita() {
		return CANCELARCITA;
	}

	public static String getTratamiento() {
		return TRATAMIENTO;
	}
	
}
