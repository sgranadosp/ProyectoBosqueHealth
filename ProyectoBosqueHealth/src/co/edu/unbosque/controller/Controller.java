package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
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
			vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getBtnAgendarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCancelarCita().setVisible(false);
			vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(false);
			break;
		case "CITAS PACIENTE":
			vf.getVentanaPaciente().getPanelDerechaArriba().setVisible(true);
			vf.getVentanaPaciente().getPanelDatosPaciente().setVisible(false);
			vf.getVentanaPaciente().getLblTituloDatosP().setVisible(false);
			vf.getVentanaPaciente().getLblTituloTratamientoMedico().setVisible(false);
			vf.getVentanaPaciente().getBtnAgendarCita().setVisible(true);
			vf.getVentanaPaciente().getBtnCancelarCita().setVisible(true);
			vf.getVentanaPaciente().getBtnCitasAgendadas().setVisible(true);
			vf.getVentanaPaciente().getBtnReagendarCitas().setVisible(true);
			break;
		case "TRATAMIENTO MEDICO PACIENTE":
			JOptionPane.showMessageDialog(null, "Tratamietno paciente");
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaPaciente().setVisible(true);
			
			break;
			
		case "AGENDAR CITA":
			numSeleccionCita = 1;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getAgendarcita());
			/*			
			vf.getVentanaPaciente().getPanelAgendarCitas().setVisible(true);
			vf.getVentanaPaciente().getPanelCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getPanelReagendarCita().setVisible(false);
			vf.getVentanaPaciente().getPanelCancelarCita().setVisible(false);
			*/
			break;
		
		case "CITAS AGENDADAS":
			numSeleccionCita = 2;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getCitasAgendadas());
			/*
			vf.getVentanaPaciente().getPanelCitasAgendadas().setVisible(true);
			vf.getVentanaPaciente().getPanelAgendarCitas().setVisible(false);
			vf.getVentanaPaciente().getPanelReagendarCita().setVisible(false);
			vf.getVentanaPaciente().getPanelCancelarCita().setVisible(false);
			*/
			break;
		case "REAGENDAR CITA":
			numSeleccionCita = 3;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getReagendarcita());
			/*
			vf.getVentanaPaciente().getPanelReagendarCita().setVisible(true);
			vf.getVentanaPaciente().getPanelAgendarCitas().setVisible(false);
			vf.getVentanaPaciente().getPanelCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getPanelCancelarCita().setVisible(false);
			*/
			break;
		case "CANCELAR CITA":
			numSeleccionCita = 4;
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(), vf.getVentanaPaciente().getCancelarcita());

			/*
			vf.getVentanaPaciente().getPanelCancelarCita().setVisible(true);
			vf.getVentanaPaciente().getPanelAgendarCitas().setVisible(false);
			vf.getVentanaPaciente().getPanelCitasAgendadas().setVisible(false);
			vf.getVentanaPaciente().getPanelReagendarCita().setVisible(false);
			*/
			
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

}
