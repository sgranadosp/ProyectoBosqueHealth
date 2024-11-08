package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private int numSeleccionCita = 0;
	
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		vf.getMenuPrincipal().setVisible(true);
		asignarLectores();
	}
	
	private void asignarLectores() {
		//Menu de personas
		//director
		vf.getMenuPrincipal().getBtnDirector().addActionListener(this);
		vf.getMenuPrincipal().getBtnDirector().setActionCommand("DIRECTOR");
		
		//especialista
		vf.getMenuPrincipal().getBtnEspecialista().addActionListener(this);
		vf.getMenuPrincipal().getBtnEspecialista().setActionCommand("ESPECIALISTA");
		
		//paciente
		vf.getMenuPrincipal().getBtnPaciente().addActionListener(this);
		vf.getMenuPrincipal().getBtnPaciente().setActionCommand("PACIENTE");
		
		
		//MENU VOLVER
		//Volver menu paciente
		vf.getVentanaPaciente().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaPaciente().getBtnVolverMenu().setActionCommand("VOLVER MENU P");
		
		//Volver menu especialista
		vf.getVentanaEspecialista().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaEspecialista().getBtnVolverMenu().setActionCommand("VOLVER MENU E");
		
		//Volver menu director
		vf.getVentanaDirector().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaDirector().getBtnVolverMenu().setActionCommand("VOLVER MENU D");
		
		//PACIENTES
		//MENU FIJO PACIENTES IZQ
		//Datos personales Paciente
		vf.getVentanaPaciente().getBtnDatosPersonales().addActionListener(this);
		vf.getVentanaPaciente().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES PACIENTE");
		
		//Citas Paciente
		vf.getVentanaPaciente().getBtnCitas().addActionListener(this);
		vf.getVentanaPaciente().getBtnCitas().setActionCommand("CITAS PACIENTE");
		
		//Tratamiento medico Paciente
		vf.getVentanaPaciente().getBtnTratamientoMedico().addActionListener(this);
		vf.getVentanaPaciente().getBtnTratamientoMedico().setActionCommand("TRATAMIENTO MEDICO PACIENTE");
		
		
		//BOTONES PACIENTE CITAS
		
		//Agendar Cita
		vf.getVentanaPaciente().getBtnAgendarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnAgendarCita().setActionCommand("AGENDAR CITA");
		
		//Citas Agendadas
		vf.getVentanaPaciente().getBtnCitasAgendadas().addActionListener(this);
		vf.getVentanaPaciente().getBtnCitasAgendadas().setActionCommand("CITAS AGENDADAS");
		
		//ReagendarCita
		vf.getVentanaPaciente().getBtnReagendarCitas().addActionListener(this);
		vf.getVentanaPaciente().getBtnReagendarCitas().setActionCommand("REAGENDAR CITA");
		
		//Cancelar Cita
		vf.getVentanaPaciente().getBtnCancelarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnCancelarCita().setActionCommand("CANCELAR CITA");
		
		
		//BOTONES DE ACCION (GUARDAR-CANCELAR-...)
		//Boton guardar los datos del paciente
		vf.getVentanaPaciente().getBtnGuardarDatosP().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarDatosP().setActionCommand("GUARDAR DATOS PACIENTE");
		
		//Boton generar cita del paciente
		vf.getVentanaPaciente().getBtnGenerarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGenerarCita().setActionCommand("GENERAR CITA PACIENTE");
		
		//Boton para cancelar la cita
		vf.getVentanaPaciente().getBtnGuardarCancelarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarCancelarCita().setActionCommand("GUARDAR CANCELAR CITA");
		
		//Boton para reagendar la cita
		vf.getVentanaPaciente().getBtnGuardarReagendarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarReagendarCita().setActionCommand("GUARDAR REAGENDAR CITA");
		
		
		
		//ESPECIALISTA
		//MENU FIJO PACIENTES IZQ
		
		
		
		
		//DIRECTOR
		//MENU FIJO PACIENTES IZQ
		//Datos personales director
		vf.getVentanaDirector().getBtnDatosPersonales().addActionListener(this);
		vf.getVentanaDirector().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES DIRECTOR");
				
		//Reportes director
		vf.getVentanaDirector().getBtnReportes().addActionListener(this);
		vf.getVentanaDirector().getBtnReportes().setActionCommand("REPORTES");
				
		//Turnos director
		vf.getVentanaDirector().getBtnTurnos().addActionListener(this);
		vf.getVentanaDirector().getBtnTurnos().setActionCommand("TURNOS");
		
		
		//BOTONES REPORTES SEMANAL Y MENSUAL, OTROS
		//Boton Reporte semanal
		vf.getVentanaDirector().getBtnReporteSemanal().addActionListener(this);
		vf.getVentanaDirector().getBtnReporteSemanal().setActionCommand("REPORTE SEMANAL");
				
		//Reporte mensual
		vf.getVentanaDirector().getBtnReporteMensual().addActionListener(this);
		vf.getVentanaDirector().getBtnReporteMensual().setActionCommand("REPORTE MENSUAL");
				
		//Reporte semanal - Pacientes atendidos
		vf.getVentanaDirector().getBtnPacientesAtendidos().addActionListener(this);
		vf.getVentanaDirector().getBtnPacientesAtendidos().setActionCommand("PACIENTES ATENDIDOS");
		
		//Reporte semanal - Diagnosticos Realizados
		vf.getVentanaDirector().getBtnDiagnosticosRealizados().addActionListener(this);
		vf.getVentanaDirector().getBtnDiagnosticosRealizados().setActionCommand("DIAGNOSTICOS REALIZADOS");
		
		//Reporte semanal - EspecialistasMNC
		vf.getVentanaDirector().getBtnEspecialistasMNC().addActionListener(this);
		vf.getVentanaDirector().getBtnEspecialistasMNC().setActionCommand("ESPECIALISTA MNC");
		
		//Reporte semanal - EspecialidadMC
		vf.getVentanaDirector().getBtnEspecialidadMC().addActionListener(this);
		vf.getVentanaDirector().getBtnEspecialidadMC().setActionCommand("ESPECIALIDAD MC");
		
		//Reporte semanal - Citas canceladas
		vf.getVentanaDirector().getBtnCitasCanceladas().addActionListener(this);
		vf.getVentanaDirector().getBtnCitasCanceladas().setActionCommand("CITAS CANCELADAS");
		
		//BOTONES DE ACCION
		//Guardar datos personales director
		vf.getVentanaDirector().getBtnGuardarDatosP().addActionListener(this);
		vf.getVentanaDirector().getBtnGuardarDatosP().setActionCommand("GUARDAR DATOS DIRECTOR");
		
		//Generar turno director
		vf.getVentanaDirector().getBtnGenerarTurno().addActionListener(this);
		vf.getVentanaDirector().getBtnGenerarTurno().setActionCommand("CITAS CANCELADAS");
						
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "DIRECTOR":
			JOptionPane.showMessageDialog(null, "Seleccionaste Director Médico");
			vf.getMenuPrincipal().setVisible(false);
			break;
		case "ESPECIALISTA":
			JOptionPane.showMessageDialog(null, "Seleccionaste Especialista");
			vf.getMenuPrincipal().setVisible(false);
			break;
		case "PACIENTE":
			JOptionPane.showMessageDialog(null, "Seleccionaste Paciente");
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaPaciente().setVisible(true);
			
			break;	
		case "DATOS PERSONALES PACIENTE":
			cambiarPanelesPacientes(true, true, false, false, true, false, false, false, false, false);
			
			break;
		case "CITAS PACIENTE":
			cambiarPanelesPacientes(true, false, true, false, false, false, true, true, true, true);
			
			break;
		case "TRATAMIENTO MEDICO PACIENTE":
			cambiarPanelesPacientes(true, false, false, true, false, true, false, false, false, false);
			tablaTratamientoMedicoP();
			
			break;
			
		case "AGENDAR CITA":
			numSeleccionCita = 1;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getAgendarcita());
			
			break;
		
		case "CITAS AGENDADAS":
			numSeleccionCita = 2;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getCitasagendadas());
			tablaCitasAgendadasP();
			
			break;
		case "REAGENDAR CITA":
			numSeleccionCita = 3;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getReagendarcita());
			
			break;
		case "CANCELAR CITA":
			numSeleccionCita = 4;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getCancelarcita());

			break;
			

			
		case "GUARDAR DATOS PACIENTE":
			Date fecNacimientoDC = vf.getVentanaPaciente().getFechaNacimiento().getDate();
			String sFecNacimientoDC = null;
			if (fecNacimientoDC==null)
				sFecNacimientoDC = "";
			else
				sFecNacimientoDC = DateFormat.getDateInstance().format(fecNacimientoDC);
			
			if (vf.getVentanaPaciente().getTxtNombreCompleto().getText().trim().equals("")
						|| vf.getVentanaPaciente().getTxtNumeroDocumento().getText().trim().equals("")
						|| sFecNacimientoDC.equals("")
						|| vf.getVentanaPaciente().getTxtCorreoElectronico().getText().equals("")
						|| vf.getVentanaPaciente().getCmbGenero().getSelectedItem().toString().equals("")
						) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
				
			} else {
				String nombreCompleto = "";
				String numeroDoc = vf.getVentanaPaciente().getTxtNumeroDocumento().getText();
				fecNacimientoDC = vf.getVentanaPaciente().getFechaNacimiento().getDate();
				String correo = vf.getVentanaPaciente().getTxtCorreoElectronico().getText();
				String genero = vf.getVentanaPaciente().getCmbGenero().getSelectedItem().toString();
				
				int numDoc = Integer.parseInt(numeroDoc);
				
				mf.getPacienteDAO().add(new PacienteDTO(nombreCompleto, fecNacimientoDC, genero, numDoc, correo));
				JOptionPane.showMessageDialog(null, "Paciente creado exitosamente");
				
				limpiarEntradasPacientes();
			}
			
			break;
		case "GENERAR CITA PACIENTE":
			
			
			break;	
			
		case "GUARDAR CANCELAR CITA":

			
			break;
			
		case "GUARDAR REAGENDAR CITA":

			
			break;	

		case "VOLVER MENU P":
			volverMenuPrincipal();
			break;
		case "VOLVER MENU E":
			volverMenuPrincipal();
			break;
		case "VOLVER MENU D":
			volverMenuPrincipal();
			break;	

		default:
			break;
		}
		
	}
	
	public void cambiarPanelesPacientes(boolean vDA, boolean vDP, boolean vVC, boolean vTM, boolean vTDP,
			boolean vTTM, boolean vBAC, boolean vBCC, boolean vBCA, boolean vBRC) {
		vf.getVentanaPaciente().getPanelDerechaArriba().setVisible(vDA);
		vf.getVentanaPaciente().getPanelDatosPaciente().setVisible(vDP);
		vf.getVentanaPaciente().getPanelVariableCitas().setVisible(vVC);
		vf.getVentanaPaciente().getPanelTratamientoMedico().setVisible(vTM);
		vf.getVentanaPaciente().getLblTituloDatosP().setVisible(vTDP);
		vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(vTTM);
		vf.getVentanaPaciente().getBtnAgendarCita().setVisible(vBAC);
		vf.getVentanaPaciente().getBtnCancelarCita().setVisible(vBCC);
		vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(vBCA);
		vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(vBRC);
		
	}
	
	public void volverMenuPrincipal() {
		vf.getMenuPrincipal().setVisible(true);
		vf.getVentanaDirector().setVisible(false);
		vf.getVentanaEspecialista().setVisible(false);
		vf.getVentanaPaciente().setVisible(false);
	}
	
	public void limpiarEntradasPacientes() {
		vf.getVentanaPaciente().getTxtCorreoElectronico().setText(null);
		vf.getVentanaPaciente().getTxtHora().setText(null);
		vf.getVentanaPaciente().getTxtHoraReagendarCita().setText(null);
		vf.getVentanaPaciente().getTxtNombreCompleto().setText(null);
		vf.getVentanaPaciente().getTxtNumeroCancelarCita().setText(null);
		vf.getVentanaPaciente().getTxtNumeroDocumento().setText(null);
		vf.getVentanaPaciente().getTxtNumeroReagendarCita().setText(null);
		vf.getVentanaPaciente().getCmbEspecialidad().setSelectedIndex(0);
		//vf.getVentanaPaciente().getCmbEspecialistas().setSelectedIndex(0);
		vf.getVentanaPaciente().getCmbGenero().setSelectedIndex(0);
		vf.getVentanaPaciente().getFechaNacimiento().setCalendar(null);
		vf.getVentanaPaciente().getFechaAgendarCita().setCalendar(null);
		vf.getVentanaPaciente().getFechaReagendarCita().setCalendar(null);

	}
	
	public void limpiarEntradasEspecialistas() {
		vf.getVentanaEspecialista().getTxtCorreoElectronico().setText(null);
		vf.getVentanaEspecialista().getTxtDiagnosticoP().setText(null);
		vf.getVentanaEspecialista().getTxtExamenP().setText(null);
		vf.getVentanaEspecialista().getTxtNombreCompleto().setText(null);
		vf.getVentanaEspecialista().getTxtNumeroDocumento().setText(null);
		vf.getVentanaEspecialista().getTxtTratamientoP().setText(null);
		vf.getVentanaEspecialista().getCmbEscogerPaciente().setSelectedIndex(0);
		vf.getVentanaEspecialista().getCmbEspecialidadDP().setSelectedIndex(0);
		vf.getVentanaEspecialista().getCmbEspecialistaActual().setSelectedIndex(0);
		vf.getVentanaEspecialista().getCmbFechaTurno().setSelectedIndex(0);
		vf.getVentanaEspecialista().getCmbGenero().setSelectedIndex(0);
		vf.getVentanaEspecialista().getCmbNuevoEspecialista().setSelectedIndex(0);
		vf.getVentanaEspecialista().getFechaNacimiento().setCalendar(null);
		vf.getVentanaEspecialista().getFechaTratamientoP().setCalendar(null);
	}
	
	public void limpiarEntradasDirectorMedico() {
		vf.getVentanaDirector().getTxtCorreoElectronico().setText(null);
		vf.getVentanaDirector().getTxtNombreCompleto().setText(null);
		vf.getVentanaDirector().getTxtNumeroDocumento().setText(null);
		vf.getVentanaDirector().getCmbEspecialidadCreacionT().setSelectedIndex(0);
		vf.getVentanaDirector().getCmbEspecialistaCreacionT().setSelectedIndex(0);
		vf.getVentanaDirector().getCmbGenero().setSelectedIndex(0);
		vf.getVentanaDirector().getCmbNivelDirectivo().setSelectedIndex(0);
		vf.getVentanaDirector().getFechaCreacionTurno().setCalendar(null);
		vf.getVentanaDirector().getFechaNacimiento().setCalendar(null);
	}
	
	public void tablaCitasAgendadasP() {
		String titulosCA[] = { "Numero de Cita", "Especialidad", "Especialista", "Fecha", "Hora", "Estado"};
		ArrayList<CitaDTO> cList = mf.getCitaDAO().getAll();
		//pendiente filtrar las citas del Paciente actual
		//.....
		String datosCA[][] = new String[1][6];
		if (cList!=null) {
			datosCA = new String[cList.size()][6];	


			int i = 0;
			for (CitaDTO citaDTO : cList) {
				datosCA[i][0] = Integer.toString(citaDTO.getNumeroCita());
				//recuperar el Especialista
				Especialista esp = citaDTO.getEspecialista();
				if (esp!=null) {
					datosCA[i][1] = esp.getEspecialidad();
					datosCA[i][2] = esp.getNombre();
				}
				if (citaDTO.getFecha()!=null)
					datosCA[i][3] = citaDTO.getFecha().toString();
				datosCA[i][4] = citaDTO.getHora();
				datosCA[i][5] = citaDTO.getEstado();
				i++;
			}
		}
		
		JTable jtCitasAgendadas = new JTable(datosCA, titulosCA);
		jtCitasAgendadas.setEnabled(true);
		jtCitasAgendadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 300); //validar coordenadas
		vf.getVentanaPaciente().getPanelCitasAgendadas().add(scrollPane);
		scrollPane.setViewportView(jtCitasAgendadas);		
	}
	
	public void tablaTratamientoMedicoP() {
		String titulosTM[] = { "Nombre del Especialista", "Fecha", "Examen Solicitado", "Diagnostico", "Tratamiento"};
		ArrayList<TratamientoMedicoDTO> tmList = mf.getTratamientoMedicoDAO().getAll();
		//pendiente filtrar las citas del Paciente actual
		//.....
		String datosCA[][] = new String[1][5];
		if (tmList!=null) {
			datosCA = new String[tmList.size()][5];	


			int i = 0;
			for (TratamientoMedicoDTO tmDTO : tmList) {
				//recuperar el Especialista
				Especialista esp = tmDTO.getEspecialista();
				if (esp!=null) {
					datosCA[i][0] = esp.getNombre();
				}
				if (tmDTO.getFecha()!=null)
					datosCA[i][1] = tmDTO.getFecha().toString();
				datosCA[i][2] = tmDTO.getExamen();
				datosCA[i][3] = tmDTO.getDiagnostico();
				datosCA[i][4] = tmDTO.getTratamiento();
				
				i++;
			}
		}
		
		JTable jtTratamientoMedico = new JTable(datosCA, titulosTM);
		jtTratamientoMedico.setEnabled(true);
		jtTratamientoMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 300); //validar coordenadas
		vf.getVentanaPaciente().getPanelTratamientoMedico().add(scrollPane);
		scrollPane.setViewportView(jtTratamientoMedico);	
	}
	
	public void preparacionDeDatosEsp() {
		ArrayList<Especialista> espList = new ArrayList<>();
		
		Especialista esp1 = new Especialista("David Caicedo", new GregorianCalendar(2000, Calendar.AUGUST, 4).getTime(), "Masculino" , 142139, "de.c@gmail.com", "Cirugía");
		Especialista esp2 = new Especialista("Pedro Gomez", new GregorianCalendar(1980, Calendar.FEBRUARY, 15).getTime(), "Masculino" , 662139, "de.c@gmail.com", "Cirugía");
		Especialista esp3 = new Especialista("Andrea Pelaez", new GregorianCalendar(1980, Calendar.APRIL, 3).getTime(), "Femenino" , 857139, "de.c@gmail.com", "Cirugía");
		Especialista esp4 = new Especialista("Jorge Lopez", new GregorianCalendar(1990, Calendar.AUGUST, 7).getTime(), "Masculino" , 196739, "de.c@gmail.com", "Cirugía");
		Especialista esp5 = new Especialista("Pepe Aguilar", new GregorianCalendar(1991, Calendar.APRIL, 22).getTime(), "Masculino" , 199139, "de.c@gmail.com", "Cirugía");
		Especialista esp6 = new Especialista("Michael Jackson", new GregorianCalendar(1995, Calendar.JUNE, 12).getTime(), "Masculino" , 106739, "de.c@gmail.com", "Cirugía");
		Especialista esp7 = new Especialista("Tom Cruise", new GregorianCalendar(1990, Calendar.JULY, 14).getTime(), "Masculino" , 102139, "de.c@gmail.com", "Cirugía");
		Especialista esp8 = new Especialista("Super Man", new GregorianCalendar(1988, Calendar.AUGUST, 3).getTime(), "Masculino" , 102139, "de.c@gmail.com", "Cirugía");
		Especialista esp9 = new Especialista("Linda Caicedo", new GregorianCalendar(1976, Calendar.NOVEMBER, 4).getTime(), "Femenino" , 102139, "de.c@gmail.com", "Cirugía");
		Especialista esp10 = new Especialista("Petrona Gonzalez", new GregorianCalendar(1987, Calendar.AUGUST, 1).getTime(), "Femenino" , 102139, "de.c@gmail.com", "Cirugía");
		Especialista esp11 = new Especialista("Oliver Caicedo", new GregorianCalendar(1999, Calendar.DECEMBER, 14).getTime(), "Masculino" , 102139, "de.c@gmail.com", "Cirugía");
	}
	
	public void tablaCitasMedicasE() {
		
	}
	
	public void tablaTurnosMesE() {
		
	}
	
	public void tablaListaDeTratamientosE() {
		
	}
	
	public void tablaPacientesAtendidosDM() {
		
	}
	
	public void tablaDiagnosticosRealizadosDM() {
		
	}
	
	public void tablaEspecialistasMayorNumeroCitasDM() {
		
	}
	
	public void TablaEspecialidadMayorConsultaDM() {
		
	}
	
	public void tablaCitasCanceladasDM() {
		
	}
	
	public void tablaReporteMensualDM() {
		
	}

}
