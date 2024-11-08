package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

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
	btnEspecialidadMC, btnCitasCanceladas, btnGenerarTurno, btnVolverMenu;
	
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
		panelDerechaArriba.setBounds(302, 55, 560, 72);
		panelDerechaArriba.setBackground(Color.white);
		
		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(302, 127, 560, 108);
		panelCentral.setBackground(Color.white);
		
		panelDatosDirector = new JPanel();
		panelDatosDirector.setLayout(null);
		panelDatosDirector.setBounds(302, 235, 560, 236);
		panelDatosDirector.setBackground(Color.white);
		
		panelPacientesAtendidos = new JPanel();
		panelPacientesAtendidos.setLayout(null);
		panelPacientesAtendidos.setBounds(302, 235, 560, 236);
		panelPacientesAtendidos.setBackground(Color.white);
		
		panelDiagnosticosRealizados = new JPanel();
		panelDiagnosticosRealizados.setLayout(null);
		panelDiagnosticosRealizados.setBounds(302, 235, 560, 236);
		panelDiagnosticosRealizados.setBackground(Color.white);
		
		panelEspecialisasMNC = new JPanel();
		panelEspecialisasMNC.setLayout(null);
		panelEspecialisasMNC.setBounds(302, 235, 560, 236);
		panelEspecialisasMNC.setBackground(Color.white);
		
		panelEspecialidadMC = new JPanel();
		panelEspecialidadMC.setLayout(null);
		panelEspecialidadMC.setBounds(302, 235, 560, 236);
		panelEspecialidadMC.setBackground(Color.white);
		
		panelCitasCanceladas = new JPanel();
		panelCitasCanceladas.setLayout(null);
		panelCitasCanceladas.setBounds(302, 235, 560, 236);
		panelCitasCanceladas.setBackground(Color.white);
		
		panelVariableReportes = new JPanel(cardLayout);
		panelVariableReportes.setBounds(302, 235, 560, 236);
		panelVariableReportes.setBackground(Color.white);
		panelVariableReportes.add(panelPacientesAtendidos, PA);
		panelVariableReportes.add(panelDiagnosticosRealizados, DR);
		panelVariableReportes.add(panelEspecialisasMNC, EMNC);
		panelVariableReportes.add(panelEspecialidadMC, EMC);
		panelVariableReportes.add(panelCitasCanceladas, CC);
		
		panelReporteMensual = new JPanel();
		panelReporteMensual.setLayout(null);
		panelReporteMensual.setBounds(302, 235, 560, 236);
		panelReporteMensual.setBackground(Color.white);
		
		panelCreacionTurno = new JPanel();
		panelCreacionTurno.setLayout(null);
		panelCreacionTurno.setBounds(302, 235, 560, 236);
		panelCreacionTurno.setBackground(Color.white);
		
	}

	public void labels() {
		//Labels DATOS PERSONALES del Director
		lblTituloDatosP = new JLabel("Datos personales");
		lblTituloDatosP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloDatosP.setForeground(new Color(78, 175, 93));
		lblTituloDatosP.setBounds(30, 10, 350, 30);
		panelDatosDirector.add(lblTituloDatosP);

		lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreCompleto.setForeground(new Color(78, 175, 93));
		lblNombreCompleto.setBounds(30, 35, 180, 20);
		panelDatosDirector.add(lblNombreCompleto);

		lblNumeroDocumento = new JLabel("Número de documento:");
		lblNumeroDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNumeroDocumento.setForeground(new Color(78, 175, 93));
		lblNumeroDocumento.setBounds(30, 60, 180, 20);
		panelDatosDirector.add(lblNumeroDocumento);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(new Color(78, 175, 93));
		lblFechaNacimiento.setBounds(30, 85, 180, 20);
		panelDatosDirector.add(lblFechaNacimiento);

		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCorreo.setForeground(new Color(78, 175, 93));
		lblCorreo.setBounds(30, 110, 180, 20);
		panelDatosDirector.add(lblCorreo);
		
		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(30, 135, 180, 20);
		panelDatosDirector.add(lblGenero);
		
		lblNivelDirectivo = new JLabel("Nivel directivo:");
		lblGenero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGenero.setForeground(new Color(78, 175, 93));
		lblGenero.setBounds(30, 160, 180, 20);
		panelDatosDirector.add(lblGenero);
		
		
		//Labels Turnos - Creación de Turno
		lblTituloCreacionTurno = new JLabel("Creación de Turno");
		lblTituloCreacionTurno.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblTituloCreacionTurno.setForeground(new Color(78, 175, 93));
		lblTituloCreacionTurno.setBounds(30, 10, 350, 30);
		panelCreacionTurno.add(lblTituloCreacionTurno);
		
		lblEspecialidadCT = new JLabel("Especialidad:");
		lblEspecialidadCT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialidadCT.setForeground(new Color(78, 175, 93));
		lblEspecialidadCT.setBounds(30, 35, 180, 20);
		panelCreacionTurno.add(lblEspecialidadCT);

		lblEspecialistaCT = new JLabel("Especialista:");
		lblEspecialistaCT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEspecialistaCT.setForeground(new Color(78, 175, 93));
		lblEspecialistaCT.setBounds(30, 60, 180, 20);
		panelCreacionTurno.add(lblEspecialistaCT);

		lblFechaCreacionT = new JLabel("Fecha:");
		lblFechaCreacionT.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblFechaCreacionT.setForeground(new Color(78, 175, 93));
		lblFechaCreacionT.setBounds(30, 85, 180, 20);
		panelCreacionTurno.add(lblFechaCreacionT);
		
	}

	public void textfield() {
		txtNombreCompleto = new JTextField();
		
		
		txtNumeroDocumento = new JTextField();
		
		
		txtCorreoElectronico = new JTextField();
		
	}

	public void botones() {
		
	}

	public void comboBox() {
		
	}

	public void calendar() {
		
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

	public JPanel getPanelVariableReportes() {
		return panelVariableReportes;
	}

	public void setPanelVariableReportes(JPanel panelVariableReportes) {
		this.panelVariableReportes = panelVariableReportes;
	}
	
	

}
