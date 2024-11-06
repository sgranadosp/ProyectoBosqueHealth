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
	
	public void paneles() {
		
		panelFijoEsp = new JPanel();
		panelFijoEsp.setLayout(null);
		panelFijoEsp.setBounds(0, 0, 1280, 720);
		panelFijoEsp.setBackground(Color.WHITE);
		
		panelArribaVariableEsp = new JPanel(cardLayoutEsp);
		panelArribaVariableEsp.setBounds(600, 100, 500, 100);
		panelArribaVariableEsp.setBackground(Color.WHITE);
		
		panelAbajoVariableEsp = new JPanel(cardLayoutEsp);
		panelAbajoVariableEsp.setBounds(600, 100, 500, 100);
		panelAbajoVariableEsp.setBackground(Color.WHITE);
		
	}
	
	public VentanaEspecialista() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		imgFija = new JLabel();
		ImageIcon imagenPaciente = new ImageIcon("media/imgsPaciente/ImgPacienteFija.png");
		Image redimensionado = imagenPaciente.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgFija.setIcon(new ImageIcon(redimensionado));
		imgFija.setBounds(0, 0, 1280, 720);
		panelFijoEsp.add(imgFija);
		
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
}
