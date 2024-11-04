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
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "DIRECTOR":
			
			break;
		case "ESPECIALISTA":
			
			break;
			
		case "PACIENTE":
			
			break;

		default:
			break;
		}
		
	}
	
}
