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
		
		add(panelFijoIzq);
		add(panelVariableReportes);
		add(panelDatosDirector);
		add(panelDerechaArriba);
		add(panelCentral);
		add(panelCreacionTurno);
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

	public void labels() {
		
		//Labels DATOS PERSONALES del Director
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(161, 24, 350, 30);
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
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(13, 174, 180, 17);
		panelDatosDirector.add(lblGenero);
		
		
		//Labels Turnos - Creación de Turno
		lblTituloCreacionTurno = new JLabel("Creación de Turno");
		lblTituloCreacionTurno.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloCreacionTurno.setForeground(new Color(78, 175, 93));
		lblTituloCreacionTurno.setBounds(152, 29, 350, 30);
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

	public void textfield() {
		
		//Texfields DATOS PERSONALES
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtNombreCompleto.setBounds(206, 9, 200, 26);
		panelDatosDirector.add(txtNombreCompleto);	
		
		txtNumeroDocumento = new JTextField();
		txtNumeroDocumento.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtNumeroDocumento.setBounds(206, 41, 200, 26);
		panelDatosDirector.add(txtNumeroDocumento);	
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtCorreoElectronico.setBounds(206, 105, 200, 26);
		panelDatosDirector.add(txtCorreoElectronico);	
	}

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
		btnVolverMenu.setBounds(807, 505, 174, 40);
		add(btnVolverMenu);
		
		imgBtnToolTip = new ImageIcon("media\\btnToolTipDirector.png");
		btnTooltipDirector = new JButton(imgBtnToolTip);
		btnTooltipDirector.setBorder(null);
		btnTooltipDirector.setBounds(929, 2, 70, 70);
		add(btnTooltipDirector);
		 
	}

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

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public JPanel getPanelDatosDirector() {
		return panelDatosDirector;
	}

	public void setPanelDatosDirector(JPanel panelDatosDirector) {
		this.panelDatosDirector = panelDatosDirector;
	}

	public JPanel getPanelPacientesAtendidos() {
		return panelPacientesAtendidos;
	}

	public void setPanelPacientesAtendidos(JPanel panelPacientesAtendidos) {
		this.panelPacientesAtendidos = panelPacientesAtendidos;
	}

	public JPanel getPanelDiagnosticosRealizados() {
		return panelDiagnosticosRealizados;
	}

	public void setPanelDiagnosticosRealizados(JPanel panelDiagnosticosRealizados) {
		this.panelDiagnosticosRealizados = panelDiagnosticosRealizados;
	}

	public JPanel getPanelEspecialisasMNC() {
		return panelEspecialisasMNC;
	}

	public void setPanelEspecialisasMNC(JPanel panelEspecialisasMNC) {
		this.panelEspecialisasMNC = panelEspecialisasMNC;
	}

	public JPanel getPanelEspecialidadMC() {
		return panelEspecialidadMC;
	}

	public void setPanelEspecialidadMC(JPanel panelEspecialidadMC) {
		this.panelEspecialidadMC = panelEspecialidadMC;
	}

	public JPanel getPanelCitasCanceladas() {
		return panelCitasCanceladas;
	}

	public void setPanelCitasCanceladas(JPanel panelCitasCanceladas) {
		this.panelCitasCanceladas = panelCitasCanceladas;
	}

	public JPanel getPanelReporteMensual() {
		return panelReporteMensual;
	}

	public void setPanelReporteMensual(JPanel panelReporteMensual) {
		this.panelReporteMensual = panelReporteMensual;
	}

	public JPanel getPanelCreacionTurno() {
		return panelCreacionTurno;
	}

	public void setPanelCreacionTurno(JPanel panelCreacionTurno) {
		this.panelCreacionTurno = panelCreacionTurno;
	}

	public JPanel getPanelVariableReportes() {
		return panelVariableReportes;
	}

	public void setPanelVariableReportes(JPanel panelVariableReportes) {
		this.panelVariableReportes = panelVariableReportes;
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

	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public JDateChooser getFechaCreacionTurno() {
		return fechaCreacionTurno;
	}

	public void setFechaCreacionTurno(JDateChooser fechaCreacionTurno) {
		this.fechaCreacionTurno = fechaCreacionTurno;
	}

	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public JComboBox<String> getCmbNivelDirectivo() {
		return cmbNivelDirectivo;
	}

	public void setCmbNivelDirectivo(JComboBox<String> cmbNivelDirectivo) {
		this.cmbNivelDirectivo = cmbNivelDirectivo;
	}

	public JComboBox<String> getCmbEspecialidadCreacionT() {
		return cmbEspecialidadCreacionT;
	}

	public void setCmbEspecialidadCreacionT(JComboBox<String> cmbEspecialidadCreacionT) {
		this.cmbEspecialidadCreacionT = cmbEspecialidadCreacionT;
	}

	public JComboBox<String> getCmbEspecialistaCreacionT() {
		return cmbEspecialistaCreacionT;
	}

	public void setCmbEspecialistaCreacionT(JComboBox<String> cmbEspecialistaCreacionT) {
		this.cmbEspecialistaCreacionT = cmbEspecialistaCreacionT;
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

	public JLabel getLblNivelDirectivo() {
		return lblNivelDirectivo;
	}

	public void setLblNivelDirectivo(JLabel lblNivelDirectivo) {
		this.lblNivelDirectivo = lblNivelDirectivo;
	}

	public JLabel getLblTituloCreacionTurno() {
		return lblTituloCreacionTurno;
	}

	public void setLblTituloCreacionTurno(JLabel lblTituloCreacionTurno) {
		this.lblTituloCreacionTurno = lblTituloCreacionTurno;
	}

	public JLabel getLblEspecialidadCT() {
		return lblEspecialidadCT;
	}

	public void setLblEspecialidadCT(JLabel lblEspecialidadCT) {
		this.lblEspecialidadCT = lblEspecialidadCT;
	}

	public JLabel getLblEspecialistaCT() {
		return lblEspecialistaCT;
	}

	public void setLblEspecialistaCT(JLabel lblEspecialistaCT) {
		this.lblEspecialistaCT = lblEspecialistaCT;
	}

	public JLabel getLblFechaCreacionT() {
		return lblFechaCreacionT;
	}

	public void setLblFechaCreacionT(JLabel lblFechaCreacionT) {
		this.lblFechaCreacionT = lblFechaCreacionT;
	}

	public JButton getBtnDatosPersonales() {
		return btnDatosPersonales;
	}

	public void setBtnDatosPersonales(JButton btnDatosPersonales) {
		this.btnDatosPersonales = btnDatosPersonales;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}

	public void setBtnReportes(JButton btnReportes) {
		this.btnReportes = btnReportes;
	}

	public JButton getBtnTurnos() {
		return btnTurnos;
	}

	public void setBtnTurnos(JButton btnTurnos) {
		this.btnTurnos = btnTurnos;
	}

	public JButton getBtnGuardarDatosP() {
		return btnGuardarDatosP;
	}

	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
		this.btnGuardarDatosP = btnGuardarDatosP;
	}

	public JButton getBtnReporteSemanal() {
		return btnReporteSemanal;
	}

	public void setBtnReporteSemanal(JButton btnReporteSemanal) {
		this.btnReporteSemanal = btnReporteSemanal;
	}

	public JButton getBtnReporteMensual() {
		return btnReporteMensual;
	}

	public void setBtnReporteMensual(JButton btnReporteMensual) {
		this.btnReporteMensual = btnReporteMensual;
	}

	public JButton getBtnPacientesAtendidos() {
		return btnPacientesAtendidos;
	}

	public void setBtnPacientesAtendidos(JButton btnPacientesAtendidos) {
		this.btnPacientesAtendidos = btnPacientesAtendidos;
	}

	public JButton getBtnDiagnosticosRealizados() {
		return btnDiagnosticosRealizados;
	}

	public void setBtnDiagnosticosRealizados(JButton btnDiagnosticosRealizados) {
		this.btnDiagnosticosRealizados = btnDiagnosticosRealizados;
	}

	public JButton getBtnEspecialistasMNC() {
		return btnEspecialistasMNC;
	}

	public void setBtnEspecialistasMNC(JButton btnEspecialistasMNC) {
		this.btnEspecialistasMNC = btnEspecialistasMNC;
	}

	public JButton getBtnEspecialidadMC() {
		return btnEspecialidadMC;
	}

	public void setBtnEspecialidadMC(JButton btnEspecialidadMC) {
		this.btnEspecialidadMC = btnEspecialidadMC;
	}

	public JButton getBtnCitasCanceladas() {
		return btnCitasCanceladas;
	}

	public void setBtnCitasCanceladas(JButton btnCitasCanceladas) {
		this.btnCitasCanceladas = btnCitasCanceladas;
	}

	public JButton getBtnGenerarTurno() {
		return btnGenerarTurno;
	}

	public void setBtnGenerarTurno(JButton btnGenerarTurno) {
		this.btnGenerarTurno = btnGenerarTurno;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	public JButton getBtnTooltipDirector() {
		return btnTooltipDirector;
	}

	public void setBtnTooltipDirector(JButton btnTooltipDirector) {
		this.btnTooltipDirector = btnTooltipDirector;
	}

	public ImageIcon getImgDatosPersonales() {
		return imgDatosPersonales;
	}

	public void setImgDatosPersonales(ImageIcon imgDatosPersonales) {
		this.imgDatosPersonales = imgDatosPersonales;
	}

	public ImageIcon getImgReportes() {
		return imgReportes;
	}

	public void setImgReportes(ImageIcon imgReportes) {
		this.imgReportes = imgReportes;
	}

	public ImageIcon getImgTurnos() {
		return imgTurnos;
	}

	public void setImgTurnos(ImageIcon imgTurnos) {
		this.imgTurnos = imgTurnos;
	}

	public ImageIcon getImgGuardarDatosP() {
		return imgGuardarDatosP;
	}

	public void setImgGuardarDatosP(ImageIcon imgGuardarDatosP) {
		this.imgGuardarDatosP = imgGuardarDatosP;
	}

	public ImageIcon getImgReporteSemanal() {
		return imgReporteSemanal;
	}

	public void setImgReporteSemanal(ImageIcon imgReporteSemanal) {
		this.imgReporteSemanal = imgReporteSemanal;
	}

	public ImageIcon getImgReporteMensual() {
		return imgReporteMensual;
	}

	public void setImgReporteMensual(ImageIcon imgReporteMensual) {
		this.imgReporteMensual = imgReporteMensual;
	}

	public ImageIcon getImgPacientesAtendidos() {
		return imgPacientesAtendidos;
	}

	public void setImgPacientesAtendidos(ImageIcon imgPacientesAtendidos) {
		this.imgPacientesAtendidos = imgPacientesAtendidos;
	}

	public ImageIcon getImgDiagnosticosRealizados() {
		return imgDiagnosticosRealizados;
	}

	public void setImgDiagnosticosRealizados(ImageIcon imgDiagnosticosRealizados) {
		this.imgDiagnosticosRealizados = imgDiagnosticosRealizados;
	}

	public ImageIcon getImgEspecialistasMNC() {
		return imgEspecialistasMNC;
	}

	public void setImgEspecialistasMNC(ImageIcon imgEspecialistasMNC) {
		this.imgEspecialistasMNC = imgEspecialistasMNC;
	}

	public ImageIcon getImgEspecialidadMC() {
		return imgEspecialidadMC;
	}

	public void setImgEspecialidadMC(ImageIcon imgEspecialidadMC) {
		this.imgEspecialidadMC = imgEspecialidadMC;
	}

	public ImageIcon getImgCitasCanceladas() {
		return imgCitasCanceladas;
	}

	public void setImgCitasCanceladas(ImageIcon imgCitasCanceladas) {
		this.imgCitasCanceladas = imgCitasCanceladas;
	}

	public ImageIcon getImgGenerarTurno() {
		return imgGenerarTurno;
	}

	public void setImgGenerarTurno(ImageIcon imgGenerarTurno) {
		this.imgGenerarTurno = imgGenerarTurno;
	}

	public ImageIcon getImgVolverMenu() {
		return imgVolverMenu;
	}

	public void setImgVolverMenu(ImageIcon imgVolverMenu) {
		this.imgVolverMenu = imgVolverMenu;
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

	public static String getPa() {
		return PA;
	}

	public static String getDr() {
		return DR;
	}

	public static String getEmnc() {
		return EMNC;
	}

	public static String getEmc() {
		return EMC;
	}

	public static String getCc() {
		return CC;
	}
	
}
