package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class VentanaEspecialista extends JFrame {
	
	private JPanel panelFijoIzq, panelDerechaArriba, panelDatosEspecialista, panelCitasMedicas, 
	panelTurnoMes, panelCambioTurno, panelTratamientoP, panelListaTratamiento, panelVariableTurno;
	private JTextField txtNombreCompleto, txtNumeroDocumento, txtCorreoElectronico, txtExamenP, 
	txtDiagnosticoP, txtTratamientoP;
	private JDateChooser fechaNacimiento, fechaTratamientoP;
	private JComboBox<String> cmbGenero, cmbEspecialidadDP, cmbFechaTurno, cmbEspecialistaActual,
	cmbNuevoEspecialista, cmbEscogerPaciente;
	private JLabel lblNombreCompleto, lblNumeroDocumento, lblFechaNacimiento, lblCorreo, lblGenero, 
	lblEspecialidad, lblTituloDatosP, lblTituloCitasMe, lblFechaTurno, lblEspecialistaActu, 
	lblNuevoEspecialista, lblTituloTratamientoPaciente, lblFechaTratamientoPaciente, lblEscogerPaciente,
	lblExamenPaciente, lblDiagnosticoPaciente, lblTratamientoPaciente;
	private JButton btnDatosPersonales, btnCitas, btnTurno, btnTratamientoPaciente, btnListaTratamientos,
	btnGuardarDatosP, btnTurnosMes, btnCambioTurno, btnGenerarCambioTurno, btnGuardarTratamiento, btnVolverMenu;
	
	private final static String TURNOSMES = "Turnos del Mes";
	private final static String CAMBIOTURNO = "Cambio Turno";
	
	CardLayout cardLayout = new CardLayout();
	
	public VentanaEspecialista() {
		ventana();
		paneles();
		labels();
		textfield();
		botones();
		comboBox();
		calendar();
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
		
		
		panelDerechaArriba = new JPanel();
		
		
		panelDatosEspecialista = new JPanel();
		
		
		panelCitasMedicas = new JPanel();
		
		
		panelTurnoMes = new JPanel();
		
		
		panelCambioTurno = new JPanel();
		
		
		panelTratamientoP = new JPanel();
		
		
		panelListaTratamiento = new JPanel();
		
		
	}

	public void labels() {
	
		lblTituloDatosP = new JLabel();
		
		
		lblTituloCitasMe = new JLabel();
		
		
		lblTituloTratamientoPaciente = new JLabel();
		
		
		lblNombreCompleto = new JLabel();
		
		
		lblNumeroDocumento = new JLabel();
		
		
		lblFechaNacimiento = new JLabel();
		
		
		lblCorreo = new JLabel();
		
		
		lblGenero = new JLabel();
		
		
		lblEspecialidad = new JLabel();
		
		
		lblFechaTurno = new JLabel();
		
		
		lblEspecialistaActu = new JLabel();
		
		
		lblNuevoEspecialista = new JLabel();
		
		
		lblFechaTratamientoPaciente = new JLabel();
		
		
		lblEscogerPaciente = new JLabel();
		
		
		lblExamenPaciente = new JLabel();
		
		
		lblDiagnosticoPaciente = new JLabel();
		
		
		lblTratamientoPaciente = new JLabel();
		
		
	}

	public void textfield() {
		
		txtNombreCompleto = new JTextField();
		
		
		txtNumeroDocumento = new JTextField();
		
		
		txtCorreoElectronico = new JTextField();
		
		
		txtExamenP = new JTextField();
		
		
		txtDiagnosticoP = new JTextField();
		
		
		txtTratamientoP = new JTextField();
	}

	public void botones() {
		
		btnDatosPersonales = new JButton();
		
		
		btnCitas = new JButton();
		
		
		btnTurno = new JButton();
		
		
		btnTratamientoPaciente = new JButton();
		
		
		btnListaTratamientos = new JButton();
		
		
		btnGuardarDatosP = new JButton();
		
		
		btnTurnosMes = new JButton();
		
		
		btnCambioTurno = new JButton();
		
		
		btnGenerarCambioTurno = new JButton();
		
		
		btnGuardarTratamiento = new JButton();
		
		
		btnVolverMenu = new JButton();
		
	}

	public void comboBox() {
		cmbGenero = new JComboBox<>();
		
		
		cmbEspecialidadDP = new JComboBox<>();
		
		
		cmbFechaTurno = new JComboBox<>();
		
		
		cmbEspecialistaActual = new JComboBox<>();
		
		
		cmbNuevoEspecialista = new JComboBox<>();
		
		
		cmbEscogerPaciente = new JComboBox<>();
		
	}

	public void calendar() {
		
		fechaNacimiento = new JDateChooser();
		
		
		fechaTratamientoP = new JDateChooser();
		
		
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

	public JPanel getPanelDatosEspecialista() {
		return panelDatosEspecialista;
	}

	public void setPanelDatosEspecialista(JPanel panelDatosEspecialista) {
		this.panelDatosEspecialista = panelDatosEspecialista;
	}

	public JPanel getPanelCitasMedicas() {
		return panelCitasMedicas;
	}

	public void setPanelCitasMedicas(JPanel panelCitasMedicas) {
		this.panelCitasMedicas = panelCitasMedicas;
	}

	public JPanel getPanelTurnoMes() {
		return panelTurnoMes;
	}

	public void setPanelTurnoMes(JPanel panelTurnoMes) {
		this.panelTurnoMes = panelTurnoMes;
	}

	public JPanel getPanelCambioTurno() {
		return panelCambioTurno;
	}

	public void setPanelCambioTurno(JPanel panelCambioTurno) {
		this.panelCambioTurno = panelCambioTurno;
	}

	public JPanel getPanelTratamientoP() {
		return panelTratamientoP;
	}

	public void setPanelTratamientoP(JPanel panelTratamientoP) {
		this.panelTratamientoP = panelTratamientoP;
	}

	public JPanel getPanelListaTratamiento() {
		return panelListaTratamiento;
	}

	public void setPanelListaTratamiento(JPanel panelListaTratamiento) {
		this.panelListaTratamiento = panelListaTratamiento;
	}

	public JPanel getPanelVariableTurno() {
		return panelVariableTurno;
	}

	public void setPanelVariableTurno(JPanel panelVariableTurno) {
		this.panelVariableTurno = panelVariableTurno;
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

	public JTextField getTxtExamenP() {
		return txtExamenP;
	}

	public void setTxtExamenP(JTextField txtExamenP) {
		this.txtExamenP = txtExamenP;
	}

	public JTextField getTxtDiagnosticoP() {
		return txtDiagnosticoP;
	}

	public void setTxtDiagnosticoP(JTextField txtDiagnosticoP) {
		this.txtDiagnosticoP = txtDiagnosticoP;
	}

	public JTextField getTxtTratamientoP() {
		return txtTratamientoP;
	}

	public void setTxtTratamientoP(JTextField txtTratamientoP) {
		this.txtTratamientoP = txtTratamientoP;
	}

	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public JDateChooser getFechaTratamientoP() {
		return fechaTratamientoP;
	}

	public void setFechaTratamientoP(JDateChooser fechaTratamientoP) {
		this.fechaTratamientoP = fechaTratamientoP;
	}

	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public JComboBox<String> getCmbEspecialidadDP() {
		return cmbEspecialidadDP;
	}

	public void setCmbEspecialidadDP(JComboBox<String> cmbEspecialidadDP) {
		this.cmbEspecialidadDP = cmbEspecialidadDP;
	}

	public JComboBox<String> getCmbFechaTurno() {
		return cmbFechaTurno;
	}

	public void setCmbFechaTurno(JComboBox<String> cmbFechaTurno) {
		this.cmbFechaTurno = cmbFechaTurno;
	}

	public JComboBox<String> getCmbEspecialistaActual() {
		return cmbEspecialistaActual;
	}

	public void setCmbEspecialistaActual(JComboBox<String> cmbEspecialistaActual) {
		this.cmbEspecialistaActual = cmbEspecialistaActual;
	}

	public JComboBox<String> getCmbNuevoEspecialista() {
		return cmbNuevoEspecialista;
	}

	public void setCmbNuevoEspecialista(JComboBox<String> cmbNuevoEspecialista) {
		this.cmbNuevoEspecialista = cmbNuevoEspecialista;
	}

	public JComboBox<String> getCmbEscogerPaciente() {
		return cmbEscogerPaciente;
	}

	public void setCmbEscogerPaciente(JComboBox<String> cmbEscogerPaciente) {
		this.cmbEscogerPaciente = cmbEscogerPaciente;
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

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(JLabel lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public JLabel getLblTituloDatosP() {
		return lblTituloDatosP;
	}

	public void setLblTituloDatosP(JLabel lblTituloDatosP) {
		this.lblTituloDatosP = lblTituloDatosP;
	}

	public JLabel getLblTituloCitasMe() {
		return lblTituloCitasMe;
	}

	public void setLblTituloCitasMe(JLabel lblTituloCitasMe) {
		this.lblTituloCitasMe = lblTituloCitasMe;
	}

	public JLabel getLblFechaTurno() {
		return lblFechaTurno;
	}

	public void setLblFechaTurno(JLabel lblFechaTurno) {
		this.lblFechaTurno = lblFechaTurno;
	}

	public JLabel getLblEspecialistaActu() {
		return lblEspecialistaActu;
	}

	public void setLblEspecialistaActu(JLabel lblEspecialistaActu) {
		this.lblEspecialistaActu = lblEspecialistaActu;
	}

	public JLabel getLblNuevoEspecialista() {
		return lblNuevoEspecialista;
	}

	public void setLblNuevoEspecialista(JLabel lblNuevoEspecialista) {
		this.lblNuevoEspecialista = lblNuevoEspecialista;
	}

	public JLabel getLblTituloTratamientoPaciente() {
		return lblTituloTratamientoPaciente;
	}

	public void setLblTituloTratamientoPaciente(JLabel lblTituloTratamientoPaciente) {
		this.lblTituloTratamientoPaciente = lblTituloTratamientoPaciente;
	}

	public JLabel getLblFechaTratamientoPaciente() {
		return lblFechaTratamientoPaciente;
	}

	public void setLblFechaTratamientoPaciente(JLabel lblFechaTratamientoPaciente) {
		this.lblFechaTratamientoPaciente = lblFechaTratamientoPaciente;
	}

	public JLabel getLblEscogerPaciente() {
		return lblEscogerPaciente;
	}

	public void setLblEscogerPaciente(JLabel lblEscogerPaciente) {
		this.lblEscogerPaciente = lblEscogerPaciente;
	}

	public JLabel getLblExamenPaciente() {
		return lblExamenPaciente;
	}

	public void setLblExamenPaciente(JLabel lblExamenPaciente) {
		this.lblExamenPaciente = lblExamenPaciente;
	}

	public JLabel getLblDiagnosticoPaciente() {
		return lblDiagnosticoPaciente;
	}

	public void setLblDiagnosticoPaciente(JLabel lblDiagnosticoPaciente) {
		this.lblDiagnosticoPaciente = lblDiagnosticoPaciente;
	}

	public JLabel getLblTratamientoPaciente() {
		return lblTratamientoPaciente;
	}

	public void setLblTratamientoPaciente(JLabel lblTratamientoPaciente) {
		this.lblTratamientoPaciente = lblTratamientoPaciente;
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

	public JButton getBtnTurno() {
		return btnTurno;
	}

	public void setBtnTurno(JButton btnTurno) {
		this.btnTurno = btnTurno;
	}

	public JButton getBtnTratamientoPaciente() {
		return btnTratamientoPaciente;
	}

	public void setBtnTratamientoPaciente(JButton btnTratamientoPaciente) {
		this.btnTratamientoPaciente = btnTratamientoPaciente;
	}

	public JButton getBtnListaTratamientos() {
		return btnListaTratamientos;
	}

	public void setBtnListaTratamientos(JButton btnListaTratamientos) {
		this.btnListaTratamientos = btnListaTratamientos;
	}

	public JButton getBtnGuardarDatosP() {
		return btnGuardarDatosP;
	}

	public void setBtnGuardarDatosP(JButton btnGuardarDatosP) {
		this.btnGuardarDatosP = btnGuardarDatosP;
	}

	public JButton getBtnTurnosMes() {
		return btnTurnosMes;
	}

	public void setBtnTurnosMes(JButton btnTurnosMes) {
		this.btnTurnosMes = btnTurnosMes;
	}

	public JButton getBtnCambioTurno() {
		return btnCambioTurno;
	}

	public void setBtnCambioTurno(JButton btnCambioTurno) {
		this.btnCambioTurno = btnCambioTurno;
	}

	public JButton getBtnGenerarCambioTurno() {
		return btnGenerarCambioTurno;
	}

	public void setBtnGenerarCambioTurno(JButton btnGenerarCambioTurno) {
		this.btnGenerarCambioTurno = btnGenerarCambioTurno;
	}

	public JButton getBtnGuardarTratamiento() {
		return btnGuardarTratamiento;
	}

	public void setBtnGuardarTratamiento(JButton btnGuardarTratamiento) {
		this.btnGuardarTratamiento = btnGuardarTratamiento;
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

	public static String getTurnosmes() {
		return TURNOSMES;
	}

	public static String getCambioturno() {
		return CAMBIOTURNO;
	}
	
	
	
	

}
