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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "":
			
			break;

		default:
			break;
		}
		
	}

}
