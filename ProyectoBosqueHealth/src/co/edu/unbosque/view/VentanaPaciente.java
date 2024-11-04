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

	private	JLabel datosPers, agendarCita, mostrarCitas, reagendarCita, cancelarCita, tratamiento;
	private JTextField nombrePac, documentoPac, correoPac, horaCita, numeroCita, horaCitaReagendar, numeroCitaCancelar;
	private JCalendar fechaNacimientoPac, fechaCita, fechaCitaReagendar;
	private JComboBox<String> generoPac, especialidad, especialista;
	private JButton btnVolverMenu, btnDatosPersonales, btnCitas, btnTratamientoMedico, btnTooltipPac, btnGuardarDatos, btnAgendar, btnGenerarCita, btnCitasGeneradas, btnReagendar, btnGenerarReagendada, btnCancelar, btnCancelarCita;
	CardLayout cardLayout = new CardLayout();
	private JPanel panelFijo, panelArribaVariable, panelAbajoVariable;
	
	public void paneles() {
		
		panelFijo = new JPanel();
		panelFijo.setLayout(null);
		panelFijo.setBounds(0, 0, 1280, 720);
		panelFijo.setBackground(Color.WHITE);
		
		panelArribaVariable = new JPanel();
		panelArribaVariable.setLayout(null);
		panelArribaVariable.setBounds(600, 100, 500, 100);
		panelArribaVariable.setBackground(Color.WHITE);
		
		panelAbajoVariable = new JPanel();
		panelAbajoVariable.setLayout(null);
		panelAbajoVariable.setBounds(600, 100, 500, 100);
		panelAbajoVariable.setBackground(Color.WHITE);
		
	}
	
	public VentanaPaciente() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		datosPers = new JLabel();
		ImageIcon imagenDatos = new ImageIcon("media/imgDatosPersonalesPac.png");
		Image redimensionado = imagenDatos.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPers.setIcon(new ImageIcon(redimensionado));
		datosPers.setBounds(0, 0, 1280, 720);
		panelFijo.add(datosPers);
		
		btnTooltipPac = new JButton();
		btnTooltipPac.setToolTipText("Panel de gestión para pacientes");
		btnTooltipPac.setBounds(1200, 0, 40, 40);
		btnTooltipPac.setOpaque(true);
		
		btnVolverMenu = new JButton("Volver al Menú Principal");
		btnVolverMenu.setBounds(1100, 600, 250, 70);
		btnVolverMenu.setOpaque(true);
		btnVolverMenu.setActionCommand("VOLVER AL MENU");
		
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
		
		//Aquí va el bloque de código para hacer la tabla que muestra las citas ya generadas
		
		
		reagendarCita = new JLabel();
		ImageIcon imagenReagendar = new ImageIcon("media/ImgReagendarCita.png");
		Image redimensionado4 = imagenReagendar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		reagendarCita.setIcon(new ImageIcon(redimensionado4));
		reagendarCita.setBounds(0, 0, 1280, 720);
		
		numeroCita = new JTextField();
		numeroCita.setBounds(0, 200, 250, 70);
		numeroCita.setOpaque(true);
		
		fechaCitaReagendar = new JCalendar();
		fechaCitaReagendar.setBounds(0, 300, 250, 70);
		fechaCitaReagendar.setOpaque(true);
		
		horaCitaReagendar = new JTextField();
		horaCitaReagendar.setBounds(0, 400, 250, 70);
		horaCitaReagendar.setOpaque(true);
		
		btnGenerarReagendada = new JButton("Reagendar Cita");
		btnGenerarReagendada.setBounds(0, 550, 250, 70);
		btnGenerarReagendada.setOpaque(true);
		btnGenerarReagendada.setActionCommand("REAGENDAR CITA");
		
		cancelarCita = new JLabel();
		ImageIcon imagenCancelar= new ImageIcon("media/ImgCancelarCita.png");
		Image redimensionado5 = imagenCancelar.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		cancelarCita.setIcon(new ImageIcon(redimensionado5));
		cancelarCita.setBounds(0, 0, 1280, 720);
		
		numeroCitaCancelar = new JTextField();
		numeroCitaCancelar.setBounds(0, 400, 250, 70);
		numeroCitaCancelar.setOpaque(true);
		
		btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.setBounds(0, 550, 250, 70);
		btnCancelarCita.setOpaque(true);
		btnCancelarCita.setActionCommand("CANCELAR CITA");
		
		tratamiento = new JLabel();
		ImageIcon imagenTratamiento= new ImageIcon("media/ImgTratamientoMedico.png");
		Image redimensionado6 = imagenTratamiento.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		tratamiento.setIcon(new ImageIcon(redimensionado6));
		tratamiento.setBounds(0, 0, 1280, 720);
		
		//Aquí va el bloque de código donde va la tabla que muestra los tratamientos
		
		
		
		add(panelFijo)
;		add(panelArribaVariable);
		add(panelAbajoVariable);
	}
	
}
