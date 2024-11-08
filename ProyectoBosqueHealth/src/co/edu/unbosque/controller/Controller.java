package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.ModelFacade;
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
		
		vf.getVentanaPaciente().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaPaciente().getBtnVolverMenu().setActionCommand("VOLVER MENU P");
		
		/*vf.getVentanaEspecialista().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaEspecialista().getBtnVolverMenu().setActionCommand("VOLVER MENU E");
		
		vf.getVentanaDirector().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaDirector().getBtnVolverMenu().setActionCommand("VOLVER MENU D");*/
		
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
			vf.getVentanaPaciente().getPanelDerechaArriba().setVisible(true);
			vf.getVentanaPaciente().getPanelDatosPaciente().setVisible(true);
			vf.getVentanaPaciente().getLblTituloDatosP().setVisible(true);
			vf.getVentanaPaciente().getPanelTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getBtnAgendarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCancelarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(false);
			break;
		case "CITAS PACIENTE":
			vf.getVentanaPaciente().getPanelDerechaArriba().setVisible(true);
			vf.getVentanaPaciente().getPanelDatosPaciente().setVisible(false);
			vf.getVentanaPaciente().getPanelTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getLblTituloDatosP().setVisible(false);
			vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getBtnAgendarCita().setVisible(true);
			vf.getVentanaPaciente().getBtnCancelarCita().setVisible(true);
			vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(true);
			vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(true);
			break;
		case "TRATAMIENTO MEDICO PACIENTE":
			vf.getVentanaPaciente().getPanelDerechaArriba().setVisible(true);
			vf.getVentanaPaciente().getPanelDatosPaciente().setVisible(false);
			vf.getVentanaPaciente().getPanelTratamientoMedico().setVisible(true);
			vf.getVentanaPaciente().getLblTituloDatosP().setVisible(false);
			vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(true);
			vf.getVentanaPaciente().getBtnAgendarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCancelarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(false);
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
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getCitasAgendadas());
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
		vf.getVentanaPaciente().getCmbEspecialistas().setSelectedIndex(0);
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
