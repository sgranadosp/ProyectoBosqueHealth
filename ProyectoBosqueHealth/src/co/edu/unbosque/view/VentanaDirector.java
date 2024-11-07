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

public class VentanaDirector extends JPanel{

	private JLabel imgFijaDir, datosPersArriba, datosPersMedio, datosPersAbajo ;
	private JTextField nombreDir, documentoDir, correoDir;
	private JCalendar fechaNacDir, fechaTurno;
	private JComboBox<String> generoDir, nivlDirectivoDir, especialidadEsp, especialista;
	private JButton btnDatosPersonales, btnReportes, btnTurnos, btnVolver, btnToolTipDir, btnGuardarDatos, btnReporteSemanal, btnPacAtendidos, btnDiagnosticosRealizados, btnEspConMasCitas, btnEspecialidadMayorConsulta, btnCitasCanceladas, btnReporteMensual, btnGenerarTurno;
	private JPanel panelFijoDir, panelArribaVariable, panelCentroVariable, panelAbajoVariable;
	CardLayout cardLayout = new CardLayout();
	private final static String DATOSDIR = "Datos personales del director";
	private final static String REPORTESEMANAL = "Aparecer los 5 botones de reporte semanal";
	private final static String PACATENDIDOS = "Mostrar tabla de pacientes atendidos la última semana";
	private final static String DIAGNOSTICOS = "Mostrar tabla de los diagnósticos realizados en la última semana";
	private final static String ESPECIALISTASCONMASCITAS = "Mostrar tabla de los especialistas que atendieron más citas";
	private final static String ESPECIALIDADMAYORCONSULTA = "Mostrar tabla de las especialidades con mayor consulta";
	private final static String CITASCANCELADAS = "Mostrar una tabla con las citas canceladas";
	private final static String REPORTEMENSUAL = "Mostrar el reporte mensual de especialistas";
	private final static String CREARTURNO = "Mostrar ventana de crear turno";

	public void paneles() {
		
		panelFijoDir = new JPanel();
		panelFijoDir.setLayout(null);
		panelFijoDir.setBounds(0, 0, 1280, 720);
		panelFijoDir.setBackground(Color.WHITE);
		
		panelArribaVariable = new JPanel(cardLayout);
		panelArribaVariable.setBounds(388, 74, 712, 96);
		panelArribaVariable.setBackground(Color.WHITE);
		panelArribaVariable.add(panelFijoDir, DATOSDIR);
		panelArribaVariable.add(panelFijoDir, REPORTESEMANAL);
		panelArribaVariable.add(panelFijoDir, PACATENDIDOS);
		panelArribaVariable.add(panelFijoDir, DIAGNOSTICOS);
		panelArribaVariable.add(panelFijoDir, ESPECIALISTASCONMASCITAS);
		panelArribaVariable.add(panelFijoDir, ESPECIALIDADMAYORCONSULTA);
		panelArribaVariable.add(panelFijoDir, CITASCANCELADAS);
		panelArribaVariable.add(panelFijoDir, REPORTEMENSUAL);
		panelArribaVariable.add(panelFijoDir, CREARTURNO);
		
		panelCentroVariable = new JPanel(cardLayout);
		panelCentroVariable.setBounds(388, 170, 712, 137);
		panelCentroVariable.setBackground(Color.WHITE);
		panelCentroVariable.add(panelFijoDir, DATOSDIR);
		panelCentroVariable.add(panelFijoDir, REPORTESEMANAL);
		panelCentroVariable.add(panelFijoDir, PACATENDIDOS);
		panelCentroVariable.add(panelFijoDir, DIAGNOSTICOS);
		panelCentroVariable.add(panelFijoDir, ESPECIALISTASCONMASCITAS);
		panelCentroVariable.add(panelFijoDir, ESPECIALIDADMAYORCONSULTA);
		panelCentroVariable.add(panelFijoDir, CITASCANCELADAS);
		panelCentroVariable.add(panelFijoDir, REPORTEMENSUAL);
		panelCentroVariable.add(panelFijoDir, CREARTURNO);
		
		panelAbajoVariable = new JPanel(cardLayout);
		panelAbajoVariable.setBounds(388, 307, 712, 295);
		panelAbajoVariable.setBackground(Color.WHITE);
		panelAbajoVariable.setBackground(Color.WHITE);
		panelAbajoVariable.add(panelFijoDir, DATOSDIR);
		panelAbajoVariable.add(panelFijoDir, REPORTESEMANAL);
		panelAbajoVariable.add(panelFijoDir, PACATENDIDOS);
		panelAbajoVariable.add(panelFijoDir, DIAGNOSTICOS);
		panelAbajoVariable.add(panelFijoDir, ESPECIALISTASCONMASCITAS);
		panelAbajoVariable.add(panelFijoDir, ESPECIALIDADMAYORCONSULTA);
		panelAbajoVariable.add(panelFijoDir, CITASCANCELADAS);
		panelAbajoVariable.add(panelFijoDir, REPORTEMENSUAL);
		panelAbajoVariable.add(panelFijoDir, CREARTURNO);
		
	}
	
	public VentanaDirector() {
		
		setLayout(null);
		setSize(1280, 720);
		setVisible(true);
		
		paneles();
		
		// Fondo fijo para Directores médicos
		
		imgFijaDir = new JLabel();
		ImageIcon imagenDirector = new ImageIcon("media/imgsDirector/ImgFijaDir.png");
		Image redimensionado = imagenDirector.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgFijaDir.setIcon(new ImageIcon(redimensionado));
		imgFijaDir.setBounds(0, 0, 1280, 720);
		panelFijoDir.add(imgFijaDir);
		
		//Imágen arriba > centro > abajo de Datos personales del director
		
		datosPersArriba = new JLabel();
		ImageIcon imagenDatosAr = new ImageIcon("media/imgsDirector/ImgArribaDatosDir.png");
		Image redimensionado2 = imagenDatosAr.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPersArriba.setIcon(new ImageIcon(redimensionado2));
		datosPersArriba.setBounds(388, 74, 712, 96);
		panelArribaVariable.add(datosPersArriba);
		
		datosPersMedio = new JLabel();
		ImageIcon imagenDatosC = new ImageIcon("media/imgsDirector/ImgCentroDatosDir.png");
		Image redimensionado3 = imagenDatosC.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPersMedio.setIcon(new ImageIcon(redimensionado3));
		datosPersMedio.setBounds(388, 170, 712, 137);
		panelCentroVariable.add(datosPersMedio);
		
		datosPersAbajo = new JLabel();
		ImageIcon imagenDatosAb = new ImageIcon("media/imgsDirector/ImgCentroDatosDir.png");
		Image redimensionado4 = imagenDatosAb.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		datosPersAbajo.setIcon(new ImageIcon(redimensionado4));
		datosPersAbajo.setBounds(388, 307, 712, 295);
		panelAbajoVariable.add(datosPersAbajo);
		
		
		
		add(panelFijoDir);
		add(panelArribaVariable);
		add(panelCentroVariable);
		add(panelAbajoVariable);
		
	}
	
}
