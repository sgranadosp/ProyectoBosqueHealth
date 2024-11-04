package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class VentanaEspecialista extends JPanel{
	
	private JButton btnDatosPersonales, btnCitas, btnTurnos,
	btnTratamientoDelPaciente, btnListaDeTratamientos, btnGuardar, btnVolver,
	btnTurnosMes, btnCambioTurno;
	private JTextField nombreEsp, idEsp, correoEsp;
	private JCalendar fechaNacimientoEsp, fechaDelTurnoCambiar;
	private JComboBox<String> generoEsp, especialidadEsp, especialistaActualEsp, EspecialistaCambiarEsp;
	private JLabel imgFija, imgArribaDatos, imgAbajoDatos, imgArribaCitas,
	imgAbajoCitas, imgArribaTurnoMes, imgAbajoTurnoMes, imgArribaCambioTurno,
	imgAbajoCambioTurno, imgArribaTratamiento, imgAbajoTratamiento,
	imgArribaListaTratamientos, imgAbajoListaTratamientos;
	
	public VentanaEspecialista() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
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
		
		btnGuardar = new JButton("guardar");
		btnGuardar.setBounds(0, 0, 250, 70);
		btnGuardar.setOpaque(true);
		btnGuardar.setActionCommand("GUARDAR ESP");
		
		btnVolver = new JButton("volver");
		btnVolver.setBounds(0, 0, 250, 70);
		btnVolver.setOpaque(true);
		btnVolver.setActionCommand("VOLVER ESP");
		
		btnTurnosMes = new JButton("turno mes");
		btnTurnosMes.setBounds(0, 0, 250, 70);
		btnTurnosMes.setOpaque(true);
		btnTurnosMes.setActionCommand("TURNO MES ESP");
		
		btnCambioTurno = new JButton("cambio de turno");
		btnCambioTurno.setBounds(0, 0, 250, 70);
		btnCambioTurno.setOpaque(true);
		btnCambioTurno.setActionCommand("CAMBIO TURNO ESP");
		
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
		
		EspecialistaCambiarEsp = new JComboBox<String>();
		EspecialistaCambiarEsp.setBounds(0, 200, 250, 70);
		EspecialistaCambiarEsp.addItem("");
		//toca hacer que se añadan los especialistas que esten
		
		//falta añadir las cosas de los labels
	}
}
