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

public class VentanaEspecialista extends JPanel{
	
	private JButton btnDatosPersonales, btnCitas, btnTurnos,
	btnTratamientoDelPaciente, btnListaDeTratamientos, btnGuardarDatos, btnVolver,
	btnTurnosMes, btnCambioDeTurno, btnConfirmarCambio, btnGuardarTratamiento;
	private JTextField nombreEsp, idEsp, correoEsp, examenTratamiento, diagnosticoTratamiento, tratamiento;
	private JCalendar fechaNacimientoEsp, fechaDelTurnoCambiar, fechaTratamientoPaciente;
	private JComboBox<String> generoEsp, especialidadEsp, especialistaActualEsp, especialistaNuevoEsp
	, escogerPaciente;
	private JLabel imgFija, imgArribaDatos, imgAbajoDatos, imgArribaCitas,
	imgAbajoCitas, imgArribaTurnoMes, imgAbajoTurnoMes, imgArribaCambioTurno,
	imgAbajoCambioTurno, imgArribaTratamiento, imgAbajoTratamiento,
	imgArribaListaTratamientos, imgAbajoListaTratamientos;
	private JPanel panelFijoEsp, panelArribaVariableEsp, panelAbajoVariableEsp;
	CardLayout cardLayoutEsp = new CardLayout();
	private final static String DATOSESP = "Datos personales del especialista";
	private final static String CITASESP = "Citas médicas del especialista";
	private final static String TURNOSESP = "Sección vacía de turnos";
	private final static String TURNOSMESESP = "Turnos del mes del especialista";
	private final static String CAMBIOTURNOSESP = "Cambio de turno entre especialistas";
	private final static String TRATAMIENTOESP = "Tratamiento que atiende el especialista";
	private final static String LISTATRATAMIENTOSESP = "Lista de tratamientos que atiende el especialista";
	
	public void paneles() {
		
		panelFijoEsp = new JPanel();
		panelFijoEsp.setLayout(null);
		panelFijoEsp.setBounds(0, 0, 1280, 720);
		panelFijoEsp.setBackground(Color.WHITE);
		
		panelArribaVariableEsp = new JPanel(cardLayoutEsp);
		panelArribaVariableEsp.setBounds(600, 100, 500, 100);
		panelArribaVariableEsp.setBackground(Color.WHITE);
		panelArribaVariableEsp.add(panelFijoEsp, DATOSESP);
		panelArribaVariableEsp.add(panelFijoEsp, CITASESP);
		panelArribaVariableEsp.add(panelFijoEsp, TURNOSESP);
		panelArribaVariableEsp.add(panelFijoEsp, TURNOSMESESP);
		panelArribaVariableEsp.add(panelFijoEsp, CAMBIOTURNOSESP);
		panelArribaVariableEsp.add(panelFijoEsp, TRATAMIENTOESP);
		panelArribaVariableEsp.add(panelFijoEsp, LISTATRATAMIENTOSESP);
		
		panelAbajoVariableEsp = new JPanel(cardLayoutEsp);
		panelAbajoVariableEsp.setBounds(600, 100, 500, 100);
		panelAbajoVariableEsp.setBackground(Color.WHITE);
		panelAbajoVariableEsp.add(panelFijoEsp, DATOSESP);
		panelAbajoVariableEsp.add(panelFijoEsp, CITASESP);
		panelAbajoVariableEsp.add(panelFijoEsp, TURNOSESP);
		panelAbajoVariableEsp.add(panelFijoEsp, TURNOSMESESP);
		panelAbajoVariableEsp.add(panelFijoEsp, CAMBIOTURNOSESP);
		panelAbajoVariableEsp.add(panelFijoEsp, TRATAMIENTOESP);
		panelAbajoVariableEsp.add(panelFijoEsp, LISTATRATAMIENTOSESP);
		
	}
	
	public VentanaEspecialista() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		paneles();
		
		//Fondo fijo para especialistas
		
		imgFija = new JLabel();
		ImageIcon imagenPaciente = new ImageIcon("media/imgsEspecialista/ImgFijaEsp.png");
		Image redimensionado = imagenPaciente.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgFija.setIcon(new ImageIcon(redimensionado));
		imgFija.setBounds(0, 0, 1280, 720);
		panelFijoEsp.add(imgFija);
		
		//
		
		btnDatosPersonales = new JButton("datos personales");
		btnDatosPersonales.setBounds(0, 0, 250, 70);
		btnDatosPersonales.setOpaque(true);
		btnDatosPersonales.setActionCommand("DATOS PERSONALES ESP");
		
		btnCitas = new JButton("citas");
		btnCitas.setBounds(0, 0, 250, 70);
		btnCitas.setOpaque(true);
		btnCitas.setActionCommand("CITAS ESP");
		
		btnTurnos = new JButton("turnos");
		btnTurnos.setBounds(0, 0, 250, 70);
		btnTurnos.setOpaque(true);
		btnTurnos.setActionCommand("TURNOS ESP");
		
		btnTratamientoDelPaciente = new JButton("Tratamiento del paciente");
		btnTratamientoDelPaciente.setBounds(0, 0, 250, 70);
		btnTratamientoDelPaciente.setOpaque(true);
		btnTratamientoDelPaciente.setActionCommand("TRATAMIENTO DEL PACIENTE");
		
		btnListaDeTratamientos = new JButton("Lista de tratamientos");
		btnListaDeTratamientos.setBounds(0, 0, 250, 70);
		btnListaDeTratamientos.setOpaque(true);
		btnListaDeTratamientos.setActionCommand("LISTA TRATAMIENTOS");
		
		btnGuardarDatos = new JButton("guardar");
		btnGuardarDatos.setBounds(0, 0, 250, 70);
		btnGuardarDatos.setOpaque(true);
		btnGuardarDatos.setActionCommand("GUARDAR ESP");
		
		btnVolver = new JButton("volver");
		btnVolver.setBounds(0, 0, 250, 70);
		btnVolver.setOpaque(true);
		btnVolver.setActionCommand("VOLVER ESP");
		
		btnTurnosMes = new JButton("turno mes");
		btnTurnosMes.setBounds(0, 0, 250, 70);
		btnTurnosMes.setOpaque(true);
		btnTurnosMes.setActionCommand("TURNO MES ESP");
		
		btnCambioDeTurno = new JButton("cambio de turno");
		btnCambioDeTurno.setBounds(0, 0, 250, 70);
		btnCambioDeTurno.setOpaque(true);
		btnCambioDeTurno.setActionCommand("CAMBIO TURNO ESP");
		
		btnConfirmarCambio = new JButton("confirmar cambio de turno");
		btnConfirmarCambio.setBounds(0, 0, 250, 70);
		btnConfirmarCambio.setOpaque(true);
		btnConfirmarCambio.setActionCommand("CONFIRMAR CAMBIO TURNO");
		
		nombreEsp = new JTextField();
		nombreEsp.setBounds(0, 0, 250, 70);
		nombreEsp.setOpaque(true);
		
		idEsp = new JTextField();
		idEsp.setBounds(0, 0, 250, 70);
		idEsp.setOpaque(true);
		
		correoEsp = new JTextField();
		correoEsp.setBounds(0, 0, 250, 70);
		correoEsp.setOpaque(true);
		
		fechaNacimientoEsp = new JCalendar();
		fechaNacimientoEsp.setBounds(0, 0, 250, 70);
		fechaNacimientoEsp.setOpaque(true);
		
		fechaDelTurnoCambiar = new JCalendar();
		fechaDelTurnoCambiar.setBounds(0, 0, 250, 70);
		fechaDelTurnoCambiar.setOpaque(true);
		
		generoEsp = new JComboBox<String>();
		generoEsp.setBounds(0, 400, 250, 70);
		generoEsp.addItem("");
		generoEsp.addItem("Femenino");
		generoEsp.addItem("Masculino");
		generoEsp.addItem("otro");
		
		especialidadEsp = new JComboBox<String>();
		especialidadEsp.setBounds(0, 200, 250, 70);
		especialidadEsp.addItem("");
		especialidadEsp.addItem("Cirugía");
		especialidadEsp.addItem("Oncología");
		especialidadEsp.addItem("Dermatología");
		especialidadEsp.addItem("Neumología");
		especialidadEsp.addItem("Cardiología");
		especialidadEsp.addItem("Medicina Interna");
		
		especialistaActualEsp = new JComboBox<String>();
		especialistaActualEsp.setBounds(0, 200, 250, 70);
		especialistaActualEsp.addItem("");
		
		especialistaNuevoEsp = new JComboBox<String>();
		especialistaNuevoEsp.setBounds(0, 200, 250, 70);
		especialistaNuevoEsp.addItem("");
		//toca hacer que se añadan los especialistas que esten
		
		//falta añadir las cosas de los labels
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

	public JButton getBtnTurnos() {
		return btnTurnos;
	}

	public void setBtnTurnos(JButton btnTurnos) {
		this.btnTurnos = btnTurnos;
	}

	public JButton getBtnTratamientoDelPaciente() {
		return btnTratamientoDelPaciente;
	}

	public void setBtnTratamientoDelPaciente(JButton btnTratamientoDelPaciente) {
		this.btnTratamientoDelPaciente = btnTratamientoDelPaciente;
	}

	public JButton getBtnListaDeTratamientos() {
		return btnListaDeTratamientos;
	}

	public void setBtnListaDeTratamientos(JButton btnListaDeTratamientos) {
		this.btnListaDeTratamientos = btnListaDeTratamientos;
	}

	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}

	public void setBtnGuardarDatos(JButton btnGuardarDatos) {
		this.btnGuardarDatos = btnGuardarDatos;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnTurnosMes() {
		return btnTurnosMes;
	}

	public void setBtnTurnosMes(JButton btnTurnosMes) {
		this.btnTurnosMes = btnTurnosMes;
	}

	public JButton getBtnCambioDeTurno() {
		return btnCambioDeTurno;
	}

	public void setBtnCambioDeTurno(JButton btnCambioDeTurno) {
		this.btnCambioDeTurno = btnCambioDeTurno;
	}

	public JButton getBtnConfirmarCambio() {
		return btnConfirmarCambio;
	}

	public void setBtnConfirmarCambio(JButton btnConfirmarCambio) {
		this.btnConfirmarCambio = btnConfirmarCambio;
	}

	public JButton getBtnGuardarTratamiento() {
		return btnGuardarTratamiento;
	}

	public void setBtnGuardarTratamiento(JButton btnGuardarTratamiento) {
		this.btnGuardarTratamiento = btnGuardarTratamiento;
	}

	public JTextField getNombreEsp() {
		return nombreEsp;
	}

	public void setNombreEsp(JTextField nombreEsp) {
		this.nombreEsp = nombreEsp;
	}

	public JTextField getIdEsp() {
		return idEsp;
	}

	public void setIdEsp(JTextField idEsp) {
		this.idEsp = idEsp;
	}

	public JTextField getCorreoEsp() {
		return correoEsp;
	}

	public void setCorreoEsp(JTextField correoEsp) {
		this.correoEsp = correoEsp;
	}

	public JTextField getExamenTratamiento() {
		return examenTratamiento;
	}

	public void setExamenTratamiento(JTextField examenTratamiento) {
		this.examenTratamiento = examenTratamiento;
	}

	public JTextField getDiagnosticoTratamiento() {
		return diagnosticoTratamiento;
	}

	public void setDiagnosticoTratamiento(JTextField diagnosticoTratamiento) {
		this.diagnosticoTratamiento = diagnosticoTratamiento;
	}

	public JTextField getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(JTextField tratamiento) {
		this.tratamiento = tratamiento;
	}

	public JCalendar getFechaNacimientoEsp() {
		return fechaNacimientoEsp;
	}

	public void setFechaNacimientoEsp(JCalendar fechaNacimientoEsp) {
		this.fechaNacimientoEsp = fechaNacimientoEsp;
	}

	public JCalendar getFechaDelTurnoCambiar() {
		return fechaDelTurnoCambiar;
	}

	public void setFechaDelTurnoCambiar(JCalendar fechaDelTurnoCambiar) {
		this.fechaDelTurnoCambiar = fechaDelTurnoCambiar;
	}

	public JCalendar getFechaTratamientoPaciente() {
		return fechaTratamientoPaciente;
	}

	public void setFechaTratamientoPaciente(JCalendar fechaTratamientoPaciente) {
		this.fechaTratamientoPaciente = fechaTratamientoPaciente;
	}

	public JComboBox<String> getGeneroEsp() {
		return generoEsp;
	}

	public void setGeneroEsp(JComboBox<String> generoEsp) {
		this.generoEsp = generoEsp;
	}

	public JComboBox<String> getEspecialidadEsp() {
		return especialidadEsp;
	}

	public void setEspecialidadEsp(JComboBox<String> especialidadEsp) {
		this.especialidadEsp = especialidadEsp;
	}

	public JComboBox<String> getEspecialistaActualEsp() {
		return especialistaActualEsp;
	}

	public void setEspecialistaActualEsp(JComboBox<String> especialistaActualEsp) {
		this.especialistaActualEsp = especialistaActualEsp;
	}

	public JComboBox<String> getEspecialistaNuevoEsp() {
		return especialistaNuevoEsp;
	}

	public void setEspecialistaNuevoEsp(JComboBox<String> especialistaNuevoEsp) {
		this.especialistaNuevoEsp = especialistaNuevoEsp;
	}

	public JComboBox<String> getEscogerPaciente() {
		return escogerPaciente;
	}

	public void setEscogerPaciente(JComboBox<String> escogerPaciente) {
		this.escogerPaciente = escogerPaciente;
	}

	public JLabel getImgFija() {
		return imgFija;
	}

	public void setImgFija(JLabel imgFija) {
		this.imgFija = imgFija;
	}

	public JLabel getImgArribaDatos() {
		return imgArribaDatos;
	}

	public void setImgArribaDatos(JLabel imgArribaDatos) {
		this.imgArribaDatos = imgArribaDatos;
	}

	public JLabel getImgAbajoDatos() {
		return imgAbajoDatos;
	}

	public void setImgAbajoDatos(JLabel imgAbajoDatos) {
		this.imgAbajoDatos = imgAbajoDatos;
	}

	public JLabel getImgArribaCitas() {
		return imgArribaCitas;
	}

	public void setImgArribaCitas(JLabel imgArribaCitas) {
		this.imgArribaCitas = imgArribaCitas;
	}

	public JLabel getImgAbajoCitas() {
		return imgAbajoCitas;
	}

	public void setImgAbajoCitas(JLabel imgAbajoCitas) {
		this.imgAbajoCitas = imgAbajoCitas;
	}

	public JLabel getImgArribaTurnoMes() {
		return imgArribaTurnoMes;
	}

	public void setImgArribaTurnoMes(JLabel imgArribaTurnoMes) {
		this.imgArribaTurnoMes = imgArribaTurnoMes;
	}

	public JLabel getImgAbajoTurnoMes() {
		return imgAbajoTurnoMes;
	}

	public void setImgAbajoTurnoMes(JLabel imgAbajoTurnoMes) {
		this.imgAbajoTurnoMes = imgAbajoTurnoMes;
	}

	public JLabel getImgArribaCambioTurno() {
		return imgArribaCambioTurno;
	}

	public void setImgArribaCambioTurno(JLabel imgArribaCambioTurno) {
		this.imgArribaCambioTurno = imgArribaCambioTurno;
	}

	public JLabel getImgAbajoCambioTurno() {
		return imgAbajoCambioTurno;
	}

	public void setImgAbajoCambioTurno(JLabel imgAbajoCambioTurno) {
		this.imgAbajoCambioTurno = imgAbajoCambioTurno;
	}

	public JLabel getImgArribaTratamiento() {
		return imgArribaTratamiento;
	}

	public void setImgArribaTratamiento(JLabel imgArribaTratamiento) {
		this.imgArribaTratamiento = imgArribaTratamiento;
	}

	public JLabel getImgAbajoTratamiento() {
		return imgAbajoTratamiento;
	}

	public void setImgAbajoTratamiento(JLabel imgAbajoTratamiento) {
		this.imgAbajoTratamiento = imgAbajoTratamiento;
	}

	public JLabel getImgArribaListaTratamientos() {
		return imgArribaListaTratamientos;
	}

	public void setImgArribaListaTratamientos(JLabel imgArribaListaTratamientos) {
		this.imgArribaListaTratamientos = imgArribaListaTratamientos;
	}

	public JLabel getImgAbajoListaTratamientos() {
		return imgAbajoListaTratamientos;
	}

	public void setImgAbajoListaTratamientos(JLabel imgAbajoListaTratamientos) {
		this.imgAbajoListaTratamientos = imgAbajoListaTratamientos;
	}

	public JPanel getPanelFijoEsp() {
		return panelFijoEsp;
	}

	public void setPanelFijoEsp(JPanel panelFijoEsp) {
		this.panelFijoEsp = panelFijoEsp;
	}

	public JPanel getPanelArribaVariableEsp() {
		return panelArribaVariableEsp;
	}

	public void setPanelArribaVariableEsp(JPanel panelArribaVariableEsp) {
		this.panelArribaVariableEsp = panelArribaVariableEsp;
	}

	public JPanel getPanelAbajoVariableEsp() {
		return panelAbajoVariableEsp;
	}

	public void setPanelAbajoVariableEsp(JPanel panelAbajoVariableEsp) {
		this.panelAbajoVariableEsp = panelAbajoVariableEsp;
	}

	public CardLayout getCardLayoutEsp() {
		return cardLayoutEsp;
	}

	public void setCardLayoutEsp(CardLayout cardLayoutEsp) {
		this.cardLayoutEsp = cardLayoutEsp;
	}

	public static String getDatosesp() {
		return DATOSESP;
	}

	public static String getCitasesp() {
		return CITASESP;
	}

	public static String getTurnosesp() {
		return TURNOSESP;
	}

	public static String getTurnosmesesp() {
		return TURNOSMESESP;
	}

	public static String getCambioturnosesp() {
		return CAMBIOTURNOSESP;
	}

	public static String getTratamientoesp() {
		return TRATAMIENTOESP;
	}

	public static String getListatratamientosesp() {
		return LISTATRATAMIENTOSESP;
	}
	
	
}
