package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class VentanaPaciente extends JPanel{

	private	JLabel datosPers, agendarCita, mostrarCitas, reagendarCita, cancelarCita, tratamiento;
	private JTextField nombrePac, documentoPac, correoPac, horaCita, numeroCita, horaCitaReagendar, numeroCitaCancelar;
	private JCalendar fechaNacimientoPac, fechaCita, fechaCitaReagendar;
	private JComboBox<String> generoPac, especialidad, especialista;
	private JButton btnDatosPersonales, btnCitas, btnTratamientoMedico, btnTooltipPac, btnGuardarDatos, btnAgendar, btnGenerarCita, btnCitasGeneradas, btnReagendar, btnGenerarReagendada, btnCancelar, btnCancelarCita;
	
	public VentanaPaciente() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		datosPers = new JLabel();
		ImageIcon imagenDatos = new ImageIcon("media/imgDatosPersonalesPac.png");
		Image redimensionado = imagenDatos.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPers.setIcon(new ImageIcon(redimensionado));
		datosPers.setBounds(0, 0, 1280, 720);
		
		btnDatosPersonales = new JButton("Datos personales");
		btnDatosPersonales.setBounds(500, 100, 250, 70);
		btnDatosPersonales.setOpaque(true);
		btnDatosPersonales.setActionCommand("DATOS PERSONALES");
		
		btnCitas = new JButton("Citas");
		btnCitas.setBounds(500, 200, 250, 70);
		btnCitas.setOpaque(true);
		btnCitas.setActionCommand("CITAS");
		
		btnTratamientoMedico = new JButton("Tratamiento Médico");
		btnTratamientoMedico.setBounds(500, 300, 250, 70);
		btnTratamientoMedico.setOpaque(true);
		btnTratamientoMedico.setActionCommand("TRATAMIENTO MÉDICO");
		
		nombrePac = new JTextField();
		nombrePac.setBounds(0, 0, 250, 70);
		nombrePac.setOpaque(true);
		
		documentoPac = new JTextField();
		documentoPac.setBounds(0, 100, 250, 70);
		documentoPac.setOpaque(true);
		
		fechaNacimientoPac = new JCalendar();
		fechaNacimientoPac.setBounds(0, 200, 250, 70);
		fechaNacimientoPac.setOpaque(true);
		
		correoPac = new JTextField();
		correoPac.setBounds(0, 300, 250, 70);
		correoPac.setOpaque(true);
		
		generoPac = new JComboBox<String>();
		generoPac.setBounds(0, 400, 250, 70);
		generoPac.addItem("");
		generoPac.addItem("Femenino");
		generoPac.addItem("Masculino");
		generoPac.addItem("Otro");
		
		btnGuardarDatos = new JButton("Guardar datos");
		btnGuardarDatos.setBounds(0, 530, 250, 70);
		btnGuardarDatos.setOpaque(true);
		btnGuardarDatos.setActionCommand("GUARDAR DATOS");
		
		btnTooltipPac = new JButton();
		btnTooltipPac.setToolTipText("Panel de gestión para pacientes");
		btnTooltipPac.setBounds(1200, 0, 40, 40);
		btnTooltipPac.setOpaque(true);
		
		agendarCita = new JLabel();
		ImageIcon imagenAgendar = new ImageIcon("media/ImgAgendarCita.png");
		Image redimensionado2 = imagenAgendar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		agendarCita.setIcon(new ImageIcon(redimensionado2));
		agendarCita.setBounds(0, 0, 1280, 720);
		
		btnAgendar = new JButton();
		btnAgendar.setBounds(0, 0, 250, 70);
		btnAgendar.setOpaque(true);
		btnAgendar.setActionCommand("AGENDAR CITA");
		
		btnCitasGeneradas = new JButton();
		btnCitasGeneradas.setBounds(300, 0, 250, 70);
		btnCitasGeneradas.setOpaque(true);
		btnCitasGeneradas.setActionCommand("CITAS AGENDADAS");
		
		btnReagendar = new JButton();
		btnReagendar.setBounds(0, 120, 250, 70);
		btnReagendar.setOpaque(true);
		btnReagendar.setActionCommand("REAGENDAR CITA");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(300, 120, 250, 70);
		btnCancelar.setOpaque(true);
		btnCancelar.setActionCommand("CANCELAR CITA");
		
		especialidad = new JComboBox<String>();
		especialidad.setBounds(0, 200, 250, 70);
		especialidad.addItem("");
		especialidad.addItem("Cirugía");
		especialidad.addItem("Oncología");
		especialidad.addItem("Dermatología");
		especialidad.addItem("Neumología");
		especialidad.addItem("Cardiología");
		especialidad.addItem("Medicina Interna");
		
		especialista = new JComboBox<String>();
		especialista.setBounds(0, 300, 250, 70);
		especialista.addItem("");
		
		fechaCita = new JCalendar();
		fechaCita.setBounds(0, 400, 250, 70);
		fechaCita.setOpaque(true);
		
		horaCita = new JTextField();
		horaCita.setBounds(0, 500, 250, 70);
		horaCita.setOpaque(true);
		
		btnGenerarCita = new JButton("Generar cita");
		btnGenerarCita.setBounds(0, 620, 250, 70);
		btnGenerarCita.setOpaque(true);
		btnGenerarCita.setActionCommand("GENERAR CITA");
		
		mostrarCitas = new JLabel();
		ImageIcon imagenMostrar = new ImageIcon("media/ImgCitasAgendadas.png");
		Image redimensionado3 = imagenMostrar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		mostrarCitas.setIcon(new ImageIcon(redimensionado3));
		mostrarCitas.setBounds(0, 0, 1280, 720);
		
		reagendarCita = new JLabel();
		ImageIcon imagenReagendar = new ImageIcon("media/ImgReagendarCita.png");
		Image redimensionado4 = imagenReagendar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		reagendarCita.setIcon(new ImageIcon(redimensionado4));
		reagendarCita.setBounds(0, 0, 1280, 720);
		
	}
	
}
