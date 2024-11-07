package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	
	private ModelFacade mf;
	private ViewFacade vf;
	
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		vf.getVentanaSeleccion().setVisible(true);
		asignarLectores();
	}
	
	public void asignarLectores() {
		
		//Menu de personas
		//director
		vf.getMenuPrincipal().getvSeleccion().getBtnDirector().addActionListener(this);
		vf.getMenuPrincipal().getvSeleccion().getBtnDirector().setActionCommand("DIRECTOR");
		
		//especialista
		vf.getMenuPrincipal().getvSeleccion().getBtnEspecialista().addActionListener(this);
		vf.getMenuPrincipal().getvSeleccion().getBtnEspecialista().setActionCommand("ESPECIALISTA");
		
		//paciente
		vf.getMenuPrincipal().getvSeleccion().getBtnPaciente().addActionListener(this);
		vf.getMenuPrincipal().getvSeleccion().getBtnPaciente().setActionCommand("PACIENTE");
		
		//Ventana paciente
		//volver al menu
		vf.getMenuPrincipal().getvPaciente().getBtnVolverMenu().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnVolverMenu().setActionCommand("VOLVER AL MENU");
		
		//Datos personales
		vf.getMenuPrincipal().getvPaciente().getBtnDatosPersonales().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES");
		
		//Citas
		vf.getMenuPrincipal().getvPaciente().getBtnCitas().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnCitas().setActionCommand("CITAS");
		
		//Tratamiento medico
		vf.getMenuPrincipal().getvPaciente().getBtnTratamientoMedico().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnTratamientoMedico().setActionCommand("TRATAMIENTO MÉDICO");

		//guardar datos
		vf.getMenuPrincipal().getvPaciente().getBtnGuardarDatos().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnGuardarDatos().setActionCommand("GUARDAR DATOS");
		
		//Agendar cita
		vf.getMenuPrincipal().getvPaciente().getBtnAgendar().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnAgendar().setActionCommand("AGENDAR CITA");
		
		//citas agendadas
		vf.getMenuPrincipal().getvPaciente().getBtnCitasGeneradas().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnCitasGeneradas().setActionCommand("CITAS AGENDADAS");
		
		//reagendar citas
		vf.getMenuPrincipal().getvPaciente().getBtnReagendar().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnReagendar().setActionCommand("REAGENDAR CITA");
		
		//Generar reagendar cita
		vf.getMenuPrincipal().getvPaciente().getBtnGenerarReagendada().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnGenerarReagendada().setActionCommand("GENERAR REAGENDAR CITA");
		
		//Cancelar 
		vf.getMenuPrincipal().getvPaciente().getBtnCancelar().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnCancelar().setActionCommand("CANCELAR");
		
		//Cancelar cita
		vf.getMenuPrincipal().getvPaciente().getBtnCancelarCita().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnCancelarCita().setActionCommand("CANCELAR CITA"); 
		
		//generar cita
		vf.getMenuPrincipal().getvPaciente().getBtnGenerarCita().addActionListener(this);
		vf.getMenuPrincipal().getvPaciente().getBtnGenerarCita().setActionCommand("GENERAR CITA");
		
		//Ventana especialista
		//datos personales
		vf.getMenuPrincipal().getvEspecialista().getBtnDatosPersonales().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES ESP");
		
		//Citas
		vf.getMenuPrincipal().getvEspecialista().getBtnCitas().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnCitas().setActionCommand("CITAS ESP");
		
		//Turnos
		vf.getMenuPrincipal().getvEspecialista().getBtnTurnos().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnTurnos().setActionCommand("TURNOS ESP");
		
		//tratamientos del paciente
		vf.getMenuPrincipal().getvEspecialista().getBtnTratamientoDelPaciente().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnTratamientoDelPaciente().setActionCommand("TRATAMIENTO DEL PACIENTE");
		
		//Mostrar lista de tratamientos
		vf.getMenuPrincipal().getvEspecialista().getBtnListaDeTratamientos().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnListaDeTratamientos().setActionCommand("LISTA TRATAMIENTOS");
		
		//Guardar datos del especialista
		vf.getMenuPrincipal().getvEspecialista().getBtnGuardarDatos().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnGuardarDatos().setActionCommand("GUARDAR ESP");
		
		//volver al menu principal
		vf.getMenuPrincipal().getvEspecialista().getBtnVolver().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnVolver().setActionCommand("VOLVER ESP");
		
		//turnos del mes del especialista
		vf.getMenuPrincipal().getvEspecialista().getBtnTurnosMes().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnTurnosMes().setActionCommand("TURNO MES ESP");
		
		//Mostrar ventana de cambio de turno
		vf.getMenuPrincipal().getvEspecialista().getBtnCambioDeTurno().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnCambioDeTurno().setActionCommand("CAMBIO TURNO ESP");
		
		//confirmar cambio de turno
		vf.getMenuPrincipal().getvEspecialista().getBtnConfirmarCambio().addActionListener(this);
		vf.getMenuPrincipal().getvEspecialista().getBtnConfirmarCambio().setActionCommand("CONFIRMAR CAMBIO TURNO");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "DIRECTOR":
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaDirector().setVisible(true);
			break;
		case "ESPECIALISTA":
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaEspecialista().setVisible(true);
			break;
			
		case "PACIENTE":
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaPaciente().setVisible(true);
			vf.getVentanaPaciente().getPanelFijo().setVisible(true);
			break;

		default:
			break;
		}
		
	}
	
}
