package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.unbosque.model.Cita;
import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.DirectorMedico;
import co.edu.unbosque.model.DirectorMedicoDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.EspecialistaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.TratamientoMedico;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.model.Turno;
import co.edu.unbosque.model.TurnoDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.TurnoDAO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.InvalidDateException;
import co.edu.unbosque.util.exception.MailException;
import co.edu.unbosque.util.exception.NotSpecialCharacterException;
import co.edu.unbosque.util.exception.PositiveIntegerException;
import co.edu.unbosque.util.mail.Mail;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Paciente pacienteActual;
	private Especialista especialistaActual;
	private DirectorMedico directorActual;
	private int numCita = 0;
	private Mail envioEmail;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		cargarPEDinicial();
		vf.getMenuPrincipal().setVisible(true);
		asignarLectores();
	}

	private void asignarLectores() {
		// Menu de personas
		// director
		vf.getMenuPrincipal().getBtnDirector().addActionListener(this);
		vf.getMenuPrincipal().getBtnDirector().setActionCommand("DIRECTOR");

		// especialista
		vf.getMenuPrincipal().getBtnEspecialista().addActionListener(this);
		vf.getMenuPrincipal().getBtnEspecialista().setActionCommand("ESPECIALISTA");

		// paciente
		vf.getMenuPrincipal().getBtnPaciente().addActionListener(this);
		vf.getMenuPrincipal().getBtnPaciente().setActionCommand("PACIENTE");

		// MENU VOLVER
		// Volver menu paciente
		vf.getVentanaPaciente().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaPaciente().getBtnVolverMenu().setActionCommand("VOLVER MENU P");

		// Volver menu especialista
		vf.getVentanaEspecialista().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaEspecialista().getBtnVolverMenu().setActionCommand("VOLVER MENU E");

		// Volver menu director
		vf.getVentanaDirector().getBtnVolverMenu().addActionListener(this);
		vf.getVentanaDirector().getBtnVolverMenu().setActionCommand("VOLVER MENU D");

		// PACIENTES
		// MENU FIJO PACIENTES IZQ
		// Datos personales Paciente
		vf.getVentanaPaciente().getBtnDatosPersonales().addActionListener(this);
		vf.getVentanaPaciente().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES PACIENTE");

		// Citas Paciente
		vf.getVentanaPaciente().getBtnCitas().addActionListener(this);
		vf.getVentanaPaciente().getBtnCitas().setActionCommand("CITAS PACIENTE");

		// Tratamiento medico Paciente
		vf.getVentanaPaciente().getBtnTratamientoMedico().addActionListener(this);
		vf.getVentanaPaciente().getBtnTratamientoMedico().setActionCommand("TRATAMIENTO MEDICO PACIENTE");

		// BOTONES PACIENTE CITAS

		// Agendar Cita
		vf.getVentanaPaciente().getBtnAgendarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnAgendarCita().setActionCommand("AGENDAR CITA");

		// Citas Agendadas
		vf.getVentanaPaciente().getBtnCitasAgendadas().addActionListener(this);
		vf.getVentanaPaciente().getBtnCitasAgendadas().setActionCommand("CITAS AGENDADAS");

		// ReagendarCita
		vf.getVentanaPaciente().getBtnReagendarCitas().addActionListener(this);
		vf.getVentanaPaciente().getBtnReagendarCitas().setActionCommand("REAGENDAR CITA");

		// Cancelar Cita
		vf.getVentanaPaciente().getBtnCancelarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnCancelarCita().setActionCommand("CANCELAR CITA");

		// BOTONES DE ACCION (GUARDAR-CANCELAR-...)
		// Boton guardar los datos del paciente
		vf.getVentanaPaciente().getBtnGuardarDatosP().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarDatosP().setActionCommand("GUARDAR DATOS PACIENTE");

		// Boton generar cita del paciente
		vf.getVentanaPaciente().getBtnGenerarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGenerarCita().setActionCommand("GENERAR CITA PACIENTE");

		// Boton para cancelar la cita
		vf.getVentanaPaciente().getBtnGuardarCancelarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarCancelarCita().setActionCommand("GUARDAR CANCELAR CITA");

		// Boton para reagendar la cita
		vf.getVentanaPaciente().getBtnGuardarReagendarCita().addActionListener(this);
		vf.getVentanaPaciente().getBtnGuardarReagendarCita().setActionCommand("GUARDAR REAGENDAR CITA");

		// ESPECIALISTA
		// MENU FIJO PACIENTES IZQ
		// Datos personales especialista
		vf.getVentanaEspecialista().getBtnDatosPersonales().addActionListener(this);
		vf.getVentanaEspecialista().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES ESPECIALISTA");

		// CITAS ESPECIALISTA
		vf.getVentanaEspecialista().getBtnCitas().addActionListener(this);
		vf.getVentanaEspecialista().getBtnCitas().setActionCommand("CITAS ESPECIALISTA");

		// TURNOS ESPECIALISTAS
		vf.getVentanaEspecialista().getBtnTurno().addActionListener(this);
		vf.getVentanaEspecialista().getBtnTurno().setActionCommand("TURNOS ESPECIALISTA");

		// TRATAMIENTO PACIENTE ESP
		vf.getVentanaEspecialista().getBtnTratamientoPaciente().addActionListener(this);
		vf.getVentanaEspecialista().getBtnTratamientoPaciente().setActionCommand("TRATAMIENTO PACIENTE ESPECIALISTA");

		// LISTA TRATAMIETOS
		vf.getVentanaEspecialista().getBtnListaTratamientos().addActionListener(this);
		vf.getVentanaEspecialista().getBtnListaTratamientos().setActionCommand("LISTA TRATAMIENTOS ESPECIALISTA");

		// SELECCION DE BOTONES
		// TURNOS MES
		vf.getVentanaEspecialista().getBtnTurnosMes().addActionListener(this);
		vf.getVentanaEspecialista().getBtnTurnosMes().setActionCommand("TURNOS MES ESPECIALISTA");

		// CAMBIO TURNO
		vf.getVentanaEspecialista().getBtnCambioTurno().addActionListener(this);
		vf.getVentanaEspecialista().getBtnCambioTurno().setActionCommand("CAMBIO TURNO ESPECIALISTA");

		// GUARDAR DATOS
		vf.getVentanaEspecialista().getBtnGuardarDatosP().addActionListener(this);
		vf.getVentanaEspecialista().getBtnGuardarDatosP().setActionCommand("GUARDAR DATOS ESPECIALISTA");

		// GENERAR CAMBIO TURNO
		vf.getVentanaEspecialista().getBtnGenerarCambioTurno().addActionListener(this);
		vf.getVentanaEspecialista().getBtnGenerarCambioTurno().setActionCommand("GENERAR CAMBIO TURNO ESP");

		// GUARDAR TRATAMIENTO
		vf.getVentanaEspecialista().getBtnGuardarTratamiento().addActionListener(this);
		vf.getVentanaEspecialista().getBtnGuardarTratamiento().setActionCommand("GUARDAR TRATAMIENTO ESP");

		// DIRECTOR
		// MENU FIJO PACIENTES IZQ
		// Datos personales director
		vf.getVentanaDirector().getBtnDatosPersonales().addActionListener(this);
		vf.getVentanaDirector().getBtnDatosPersonales().setActionCommand("DATOS PERSONALES DIRECTOR");

		// Reportes director
		vf.getVentanaDirector().getBtnReportes().addActionListener(this);
		vf.getVentanaDirector().getBtnReportes().setActionCommand("REPORTES");

		// Turnos director
		vf.getVentanaDirector().getBtnTurnos().addActionListener(this);
		vf.getVentanaDirector().getBtnTurnos().setActionCommand("TURNOS");

		// BOTONES REPORTES SEMANAL Y MENSUAL, OTROS
		// Boton Reporte semanal
		vf.getVentanaDirector().getBtnReporteSemanal().addActionListener(this);
		vf.getVentanaDirector().getBtnReporteSemanal().setActionCommand("REPORTE SEMANAL");

		// Reporte mensual
		vf.getVentanaDirector().getBtnReporteMensual().addActionListener(this);
		vf.getVentanaDirector().getBtnReporteMensual().setActionCommand("REPORTE MENSUAL");

		// Reporte semanal - Pacientes atendidos
		vf.getVentanaDirector().getBtnPacientesAtendidos().addActionListener(this);
		vf.getVentanaDirector().getBtnPacientesAtendidos().setActionCommand("PACIENTES ATENDIDOS");

		// Reporte semanal - Diagnosticos Realizados
		vf.getVentanaDirector().getBtnDiagnosticosRealizados().addActionListener(this);
		vf.getVentanaDirector().getBtnDiagnosticosRealizados().setActionCommand("DIAGNOSTICOS REALIZADOS");

		// Reporte semanal - EspecialistasMNC
		vf.getVentanaDirector().getBtnEspecialistasMNC().addActionListener(this);
		vf.getVentanaDirector().getBtnEspecialistasMNC().setActionCommand("ESPECIALISTA MNC");

		// Reporte semanal - EspecialidadMC
		vf.getVentanaDirector().getBtnEspecialidadMC().addActionListener(this);
		vf.getVentanaDirector().getBtnEspecialidadMC().setActionCommand("ESPECIALIDAD MC");

		// Reporte semanal - Citas canceladas
		vf.getVentanaDirector().getBtnCitasCanceladas().addActionListener(this);
		vf.getVentanaDirector().getBtnCitasCanceladas().setActionCommand("CITAS CANCELADAS");

		// BOTONES DE ACCION
		// Guardar datos personales director
		vf.getVentanaDirector().getBtnGuardarDatosP().addActionListener(this);
		vf.getVentanaDirector().getBtnGuardarDatosP().setActionCommand("GUARDAR DATOS DIRECTOR");

		// Generar turno director
		vf.getVentanaDirector().getBtnGenerarTurno().addActionListener(this);
		vf.getVentanaDirector().getBtnGenerarTurno().setActionCommand("GENERAR TURNO DIRECTOR");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "DIRECTOR":
			JOptionPane.showMessageDialog(null, "Seleccionaste Director Médico");
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaDirector().setVisible(true);

			break;
		case "ESPECIALISTA":
			JOptionPane.showMessageDialog(null, "Seleccionaste Especialista");
			vf.getMenuPrincipal().setVisible(false);
			vf.getVentanaEspecialista().setVisible(true);
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
			cambiarPanelesPacientes(true, false, false, false, false, false, true, true, true, true);

			break;
		case "TRATAMIENTO MEDICO PACIENTE":
			cambiarPanelesPacientes(true, false, false, true, false, true, false, false, false, false);
			tablaTratamientoMedicoP();

			break;

		case "AGENDAR CITA":
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(),
					vf.getVentanaPaciente().getAgendarcita());
			preparacionDeDatosEsp();
			cargarComboBoxAgendarCita();

			break;

		case "CITAS AGENDADAS":
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(),
					vf.getVentanaPaciente().getCitasagendadas());
			tablaCitasAgendadasP();

			break;
		case "REAGENDAR CITA":
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(),
					vf.getVentanaPaciente().getReagendarcita());

			break;
		case "CANCELAR CITA":
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getPanelVariableCitas().setVisible(true);
			vf.getVentanaPaciente().getCardLayout().show(vf.getVentanaPaciente().getPanelVariableCitas(),
					vf.getVentanaPaciente().getCancelarcita());

			break;

		case "GUARDAR DATOS PACIENTE":
			Date fecNacimientoDC = vf.getVentanaPaciente().getFechaNacimiento().getDate();
			String sFecNacimientoDC = null;
			if (fecNacimientoDC == null)
				sFecNacimientoDC = "";
			else
				sFecNacimientoDC = DateFormat.getDateInstance().format(fecNacimientoDC);

			if (vf.getVentanaPaciente().getTxtNombreCompleto().getText().trim().equals("")
					|| vf.getVentanaPaciente().getTxtNumeroDocumento().getText().trim().equals("")
					|| sFecNacimientoDC.equals("")
					|| vf.getVentanaPaciente().getTxtCorreoElectronico().getText().equals("")
					|| vf.getVentanaPaciente().getCmbGenero().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String nombreCompleto = vf.getVentanaPaciente().getTxtNombreCompleto().getText();
				String numeroDoc = vf.getVentanaPaciente().getTxtNumeroDocumento().getText();
				fecNacimientoDC = vf.getVentanaPaciente().getFechaNacimiento().getDate();
				String correo = vf.getVentanaPaciente().getTxtCorreoElectronico().getText();
				String genero = vf.getVentanaPaciente().getCmbGenero().getSelectedItem().toString();

				if (verifyMail(correo)) {

					int numDoc = Integer.parseInt(numeroDoc);

					mf.getPacienteDAO().add(new PacienteDTO(nombreCompleto, fecNacimientoDC, genero, numDoc, correo));
					JOptionPane.showMessageDialog(null, "Paciente creado exitosamente");

					pacienteActual = new Paciente(nombreCompleto, fecNacimientoDC, genero, numDoc, correo);
					limpiarEntradasPacientes();
				} else {
					JOptionPane.showMessageDialog(null, "Formato inválido de correo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

			break;
		case "GENERAR CITA PACIENTE":
			Date fechaCita = vf.getVentanaPaciente().getFechaAgendarCita().getDate();
			String fecAgendarCita = null;
			if (fechaCita == null)
				fecAgendarCita = "";
			else
				fecAgendarCita = DateFormat.getDateInstance().format(fechaCita);

			if (vf.getVentanaPaciente().getCmbEspecialidad().getSelectedItem().toString().equals("")
					|| vf.getVentanaPaciente().getCmbEspecialistas().getSelectedItem().toString().equals("")
					|| fecAgendarCita.equals("") || vf.getVentanaPaciente().getTxtHora().getText().trim().equals("")) {

				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String especialidad = vf.getVentanaPaciente().getCmbEspecialidad().getSelectedItem().toString();
				String especialista = vf.getVentanaPaciente().getCmbEspecialistas().getSelectedItem().toString();
				fechaCita = vf.getVentanaPaciente().getFechaAgendarCita().getDate();
				String horaCita = vf.getVentanaPaciente().getTxtHora().getText();
				numCita = numRandom();

				Especialista espCita = new Especialista(especialista, null, null, 0, null, especialidad);

				mf.getCitaDAO().add(new CitaDTO(espCita, pacienteActual, fechaCita, horaCita, numCita, "Activo"));
				JOptionPane.showMessageDialog(null, "Cita generada exitosamente");

				// Enviar correo
				envioEmail = new Mail();
				String subject = "Nueva cita creada";
				String content = "Estimado " + pacienteActual.getNombre() + ", su cita de " + espCita.getEspecialidad()
						+ " fué programada para la siguiente fecha y hora " + "\n--> Fecha: " + fechaCita
						+ "\n--> Hora: " + horaCita;
				envioEmail.enviarC(pacienteActual.getCorreo(), subject, content);

				limpiarEntradasPacientes();

			}

			break;

		case "GUARDAR CANCELAR CITA":

			String numCancelarCita = vf.getVentanaPaciente().getTxtNumeroCancelarCita().getText();
			int numCC = Integer.parseInt(numCancelarCita);

			Cita citaACancelar = new Cita();
			citaACancelar.setNumeroCita(numCC);
			Cita citaEncontrada = mf.getCitaDAO().find(citaACancelar);
			if (citaEncontrada != null) {
				// eliminar cita encontrada
				CitaDTO citaDTOAEliminar = new CitaDTO();
				citaDTOAEliminar.setNumeroCita(numCC);
				// citaDTOAEliminar.

				if (mf.getCitaDAO().delete(citaDTOAEliminar)) {
					// Eliminó
					JOptionPane.showMessageDialog(null, "Cita No. " + numCC + "cancelada satisfactoriamente");
					vf.getVentanaPaciente().getTxtNumeroCancelarCita().setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Cita No. " + numCC + "NO ENCONTRADA");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cita No. " + numCC + "NO ENCONTRADA");
			}

			break;

		case "GUARDAR REAGENDAR CITA":
			String numReagendarCita = vf.getVentanaPaciente().getTxtNumeroReagendarCita().getText();
			int numRC = Integer.parseInt(numReagendarCita);

			Cita citaABuscar = new Cita();
			citaABuscar.setNumeroCita(numRC);

			mf.getCitaDAO().find(citaABuscar);

			Cita citaEncontradaReagendar = mf.getCitaDAO().find(citaABuscar);
			CitaDTO cEncontradaReagendar = DataMapper.citaToCitaDTO(citaEncontradaReagendar);

			if (citaEncontradaReagendar != null) {
				// eliminar cita encontrada

				CitaDTO citaDTOAReagendar = new CitaDTO(cEncontradaReagendar.getEspecialista(),
						cEncontradaReagendar.getPaciente(), vf.getVentanaPaciente().getFechaReagendarCita().getDate(),
						vf.getVentanaPaciente().getTxtHoraReagendarCita().getText(),
						cEncontradaReagendar.getNumeroCita(), cEncontradaReagendar.getEstado());

				mf.getCitaDAO().update(cEncontradaReagendar, citaDTOAReagendar);
				JOptionPane.showMessageDialog(null, "Cita No. " + numRC + " fue reagendada con exito");

				limpiarEntradasPacientes();

			} else {
				JOptionPane.showMessageDialog(null, "Cita No. " + numRC + " no pudo ser reagendada");
			}

			break;

		// VOLVER AL MENU
		case "VOLVER MENU P":
			volverMenuPrincipal();
			break;
		case "VOLVER MENU E":
			volverMenuPrincipal();
			break;
		case "VOLVER MENU D":
			volverMenuPrincipal();
			break;

		// ESPECIALISTAS
		case "DATOS PERSONALES ESPECIALISTA":
			cambiarPanelesEspecialista(true, true, false, false, false, false, true, false, false, false, false, false);
			break;
		case "CITAS ESPECIALISTA":
			cambiarPanelesEspecialista(true, false, false, true, false, false, false, true, false, false, false, false);
			tablaCitasMedicasE();
			break;
		case "TURNOS ESPECIALISTA":
			cambiarPanelesEspecialista(true, false, false, false, false, false, false, false, false, false, true, true);

			break;
		case "TRATAMIENTO PACIENTE ESPECIALISTA":
			cambiarPanelesEspecialista(true, false, false, false, true, false, false, false, true, false, false, false);
			cargarCmbPacienteTrat();
			break;
		case "LISTA TRATAMIENTOS ESPECIALISTA":
			cambiarPanelesEspecialista(true, false, false, false, false, true, false, false, false, true, false, false);
			tablaListaDeTratamientosE();
			break;
		case "TURNOS MES ESPECIALISTA":
			vf.getVentanaEspecialista().getPanelVariableTurno().setVisible(true);
			vf.getVentanaEspecialista().getCardLayout().show(vf.getVentanaEspecialista().getPanelVariableTurno(),
					vf.getVentanaEspecialista().getTurnosmes());
			tablaTurnosMesE();
			break;
		case "CAMBIO TURNO ESPECIALISTA":
			vf.getVentanaEspecialista().getPanelVariableTurno().setVisible(true);
			vf.getVentanaEspecialista().getCardLayout().show(vf.getVentanaEspecialista().getPanelVariableTurno(),
					vf.getVentanaEspecialista().getCambioturno());
			cargarCmbFechaTurno();
			break;
		case "GUARDAR DATOS ESPECIALISTA":

			Date fecNacimientoE = vf.getVentanaEspecialista().getFechaNacimiento().getDate();
			String sFecNacimientoE = null;
			if (fecNacimientoE == null)
				sFecNacimientoE = "";
			else
				sFecNacimientoE = DateFormat.getDateInstance().format(fecNacimientoE);

			if (vf.getVentanaEspecialista().getTxtNombreCompleto().getText().trim().equals("")
					|| vf.getVentanaEspecialista().getTxtNumeroDocumento().getText().trim().equals("")
					|| sFecNacimientoE.equals("")
					|| vf.getVentanaEspecialista().getTxtCorreoElectronico().getText().equals("")
					|| vf.getVentanaEspecialista().getCmbGenero().getSelectedItem().toString().equals("")
					|| vf.getVentanaEspecialista().getCmbEspecialidadDP().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String nombreCompletoE = vf.getVentanaEspecialista().getTxtNombreCompleto().getText();
				String numeroDocE = vf.getVentanaEspecialista().getTxtNumeroDocumento().getText();
				fecNacimientoE = vf.getVentanaEspecialista().getFechaNacimiento().getDate();
				String correoE = vf.getVentanaEspecialista().getTxtCorreoElectronico().getText();
				String generoE = vf.getVentanaEspecialista().getCmbGenero().getSelectedItem().toString();
				String especialidadE = vf.getVentanaEspecialista().getCmbEspecialidadDP().getSelectedItem().toString();

				int numDocE = Integer.parseInt(numeroDocE);
				
				if (verifyMail(correoE)) {

				mf.getEspecialistaDAO().add(
						new EspecialistaDTO(nombreCompletoE, fecNacimientoE, generoE, numDocE, correoE, especialidadE));
				JOptionPane.showMessageDialog(null, "Especialista creado exitosamente");

				especialistaActual = new Especialista(nombreCompletoE, fecNacimientoE, generoE, numDocE, correoE,
						especialidadE);

				limpiarEntradasEspecialistas();
				}else {
					JOptionPane.showMessageDialog(null, "Formato inválido de correo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
		case "GENERAR CAMBIO TURNO ESP":

			if (vf.getVentanaEspecialista().getCmbFechaTurno().getSelectedItem().toString().equals("")
					|| vf.getVentanaEspecialista().getCmbEspecialistaActual().getSelectedItem().toString().equals("")
					|| vf.getVentanaEspecialista().getCmbNuevoEspecialista().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {

				String fechaTurno = vf.getVentanaEspecialista().getCmbFechaTurno().getSelectedItem().toString();
				String[] splitFecha = fechaTurno.split(" : ");

				int turnoId = Integer.parseInt(splitFecha[0]);
				SimpleDateFormat formaFecha = new SimpleDateFormat("dd/MM/yyyy");
				String fechaTCT = splitFecha[1];
				Date fechaTurnoa = null;
				try {
					fechaTurnoa = formaFecha.parse(fechaTCT);
				} catch (ParseException e1) {

				}
				String espActu = vf.getVentanaEspecialista().getCmbEspecialistaActual().getSelectedItem().toString();
				String nuevoEsp = vf.getVentanaEspecialista().getCmbNuevoEspecialista().getSelectedItem().toString();

				// cambiar turno
				// buscar el Turno en la lista de Turnos con el turnoId

				Turno turnoEncontrado = mf.getTurnoDAO().find(new Turno(null, null, turnoId));

				if (turnoEncontrado != null) {
					// lo encontró
					// turnoEncontrado es el turno Anterior
					// lo cambio a DTO
					TurnoDTO turnoDTOEncontradoAnterior = DataMapper.turnoToTurnoDTO(turnoEncontrado);

					// ahora preparo el turno nuevo

					Especialista espNuevoTemp = new Especialista(nuevoEsp, null, null, 0, null,
							turnoDTOEncontradoAnterior.getEspecialista().getEspecialidad());

					TurnoDTO turnoNuevo = new TurnoDTO(espNuevoTemp, fechaTurnoa, turnoId);

					mf.getTurnoDAO().update(turnoDTOEncontradoAnterior, turnoNuevo);
					JOptionPane.showMessageDialog(null, "Cambio de Turno generado exitosamente");

					limpiarEntradasEspecialistas();
				}

				

			}

			break;
		case "GUARDAR TRATAMIENTO ESP":
			Date fecTratamientoE = vf.getVentanaEspecialista().getFechaTratamientoP().getDate();
			String sFecTratamietoE = null;
			if (fecTratamientoE == null)
				sFecTratamietoE = "";
			else
				sFecTratamietoE = DateFormat.getDateInstance().format(fecTratamientoE);

			if (sFecTratamietoE.equals("") || vf.getVentanaEspecialista().getTxtExamenP().getText().trim().equals("")
					|| vf.getVentanaEspecialista().getTxtDiagnosticoP().getText().equals("")
					|| vf.getVentanaEspecialista().getTxtTratamientoP().getText().equals("")
					|| vf.getVentanaEspecialista().getCmbEscogerPaciente().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				fecTratamientoE = vf.getVentanaEspecialista().getFechaTratamientoP().getDate();
				String pacienteTratE = vf.getVentanaEspecialista().getCmbEscogerPaciente().getSelectedItem().toString();
				String examenTratE = vf.getVentanaEspecialista().getTxtExamenP().getText();
				String diagnosticoE = vf.getVentanaEspecialista().getTxtNumeroDocumento().getText();
				String tratamientoE = vf.getVentanaEspecialista().getTxtTratamientoP().getText();

				Paciente pacTemp = new Paciente(pacienteTratE, null, null, 0, null, null);

				mf.getTratamientoMedicoDAO().add(new TratamientoMedicoDTO(pacTemp, especialistaActual, fecTratamientoE,
						tratamientoE, examenTratE, diagnosticoE));
				JOptionPane.showMessageDialog(null, "Tratamiento creado exitosamente");

				limpiarEntradasEspecialistas();
			}
			break;

		// DIRECTOR
		case "DATOS PERSONALES DIRECTOR":
			cambiarPanelesDirector(true, true, false, false, false, false, true, false, false, false, false, false,
					false, false, false);
			break;
		case "REPORTES":
			cambiarPanelesDirector(true, false, false, false, false, false, false, true, true, false, false, false,
					false, false, false);
			break;
		case "TURNOS":
			cambiarPanelesDirector(true, false, false, false, false, true, false, false, false, false, false, false,
					false, true, false);
			cargarComboBoxGenerarTurno();
			break;
		case "REPORTE SEMANAL":
			cambiarPanelesDirector(true, false, false, true, false, false, false, true, true, true, true, true, true,
					false, true);
			break;
		case "REPORTE MENSUAL":
			cambiarPanelesDirector(true, false, false, false, true, false, false, true, true, false, false, false,
					false, false, false);
			tablaReporteMensualDM();
			break;
		case "PACIENTES ATENDIDOS":
			vf.getVentanaDirector().getPanelVariableReportes().setVisible(true);
			vf.getVentanaDirector().getCardLayout().show(vf.getVentanaDirector().getPanelVariableReportes(),
					vf.getVentanaDirector().getPa());
			tablaPacientesAtendidosDM();
			break;
		case "DIAGNOSTICOS REALIZADOS":
			vf.getVentanaDirector().getPanelVariableReportes().setVisible(true);
			vf.getVentanaDirector().getCardLayout().show(vf.getVentanaDirector().getPanelVariableReportes(),
					vf.getVentanaDirector().getDr());
			tablaDiagnosticosRealizadosDM();
			break;
		case "ESPECIALISTA MNC":
			vf.getVentanaDirector().getPanelVariableReportes().setVisible(true);
			vf.getVentanaDirector().getCardLayout().show(vf.getVentanaDirector().getPanelVariableReportes(),
					vf.getVentanaDirector().getEmnc());
			tablaEspecialistasMayorNumeroCitasDM();
			break;
		case "ESPECIALIDAD MC":
			vf.getVentanaDirector().getPanelVariableReportes().setVisible(true);
			vf.getVentanaDirector().getCardLayout().show(vf.getVentanaDirector().getPanelVariableReportes(),
					vf.getVentanaDirector().getEmc());
			tablaEspecialidadMayorConsultaDM();
			break;
		case "CITAS CANCELADAS":
			vf.getVentanaDirector().getPanelVariableReportes().setVisible(true);
			vf.getVentanaDirector().getCardLayout().show(vf.getVentanaDirector().getPanelVariableReportes(),
					vf.getVentanaDirector().getCc());
			tablaCitasCanceladasDM();
			break;
		case "GUARDAR DATOS DIRECTOR":
			Date fecNacimientoDM = vf.getVentanaDirector().getFechaNacimiento().getDate();
			String sFecNacimientoDM = null;
			if (fecNacimientoDM == null)
				sFecNacimientoDM = "";
			else
				sFecNacimientoDM = DateFormat.getDateInstance().format(fecNacimientoDM);

			if (vf.getVentanaDirector().getTxtNombreCompleto().getText().trim().equals("")
					|| vf.getVentanaDirector().getTxtNumeroDocumento().getText().trim().equals("")
					|| sFecNacimientoDM.equals("")
					|| vf.getVentanaDirector().getTxtCorreoElectronico().getText().equals("")
					|| vf.getVentanaDirector().getCmbGenero().getSelectedItem().toString().equals("")
					|| vf.getVentanaDirector().getCmbNivelDirectivo().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String nombreCompletoDM = vf.getVentanaDirector().getTxtNombreCompleto().getText();
				String numeroDocDM = vf.getVentanaDirector().getTxtNumeroDocumento().getText();
				fecNacimientoDM = vf.getVentanaDirector().getFechaNacimiento().getDate();
				String correoDM = vf.getVentanaDirector().getTxtCorreoElectronico().getText();
				String generoDM = vf.getVentanaDirector().getCmbGenero().getSelectedItem().toString();
				String nivelD = vf.getVentanaDirector().getCmbNivelDirectivo().getSelectedItem().toString();

				int numDocDM = Integer.parseInt(numeroDocDM);

							mf.getDirectorMedicoDAO().add(new DirectorMedicoDTO(nombreCompletoDM, fecNacimientoDM,
									generoDM, numDocDM, correoDM, nivelD));
							JOptionPane.showMessageDialog(null, "Director Medico creado exitosamente");

							limpiarEntradasDirectorMedico();
						
			}
			break;
		case "GENERAR TURNO DIRECTOR":

			Date fecCreacionTDM = vf.getVentanaDirector().getFechaCreacionTurno().getDate();
			String sfecCreacionTDM = null;
			if (fecCreacionTDM == null)
				sfecCreacionTDM = "";
			else
				sfecCreacionTDM = DateFormat.getDateInstance().format(fecCreacionTDM);

			if (sfecCreacionTDM.equals("")
					|| vf.getVentanaDirector().getCmbEspecialidadCreacionT().getSelectedItem().toString().equals("")
					|| vf.getVentanaDirector().getCmbEspecialistaCreacionT().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				fecCreacionTDM = vf.getVentanaDirector().getFechaCreacionTurno().getDate();
				String EspecialidadCTDM = vf.getVentanaDirector().getCmbEspecialidadCreacionT().getSelectedItem()
						.toString();
				String EspecialistaCTD = vf.getVentanaDirector().getCmbEspecialistaCreacionT().getSelectedItem()
						.toString();

				Especialista espTempCreacionT = new Especialista(EspecialistaCTD, null, null, 0, null,
						EspecialidadCTDM);

				mf.getTurnoDAO().add(new TurnoDTO(espTempCreacionT, fecCreacionTDM, numRandom()));
				JOptionPane.showMessageDialog(null, "Turno creado exitosamente");

				limpiarEntradasDirectorMedico();
			}
			break;
		default:
			break;
		}

	}

	public void cambiarPanelesPacientes(boolean vDA, boolean vDP, boolean vVC, boolean vTM, boolean vTDP, boolean vTTM,
			boolean vBAC, boolean vBCC, boolean vBCA, boolean vBRC) {
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

	public void cambiarPanelesEspecialista(boolean vDA, boolean vDE, boolean vVT, boolean vCM, boolean vTP, boolean vLT,
			boolean vTDP, boolean vTCM, boolean vTTP, boolean vTLT, boolean vTM, boolean vCT) {
		vf.getVentanaEspecialista().getPanelDerechaArriba().setVisible(vDA);
		vf.getVentanaEspecialista().getPanelDatosEspecialista().setVisible(vDE);
		vf.getVentanaEspecialista().getPanelVariableTurno().setVisible(vVT);
		vf.getVentanaEspecialista().getPanelCitasMedicas().setVisible(vCM);
		vf.getVentanaEspecialista().getPanelTratamientoP().setVisible(vTP);
		vf.getVentanaEspecialista().getPanelListaTratamiento().setVisible(vLT);
		vf.getVentanaEspecialista().getLblTituloDatosP().setVisible(vTDP);
		vf.getVentanaEspecialista().getLblTituloCitasMe().setVisible(vTCM);
		vf.getVentanaEspecialista().getLblTituloTratamientoPaciente().setVisible(vTTP);
		vf.getVentanaEspecialista().getLblTituloListaTratamientos().setVisible(vTLT);
		vf.getVentanaEspecialista().getBtnTurnosMes().setVisible(vTM);
		vf.getVentanaEspecialista().getBtnCambioTurno().setVisible(vCT);
	}

	public void cambiarPanelesDirector(boolean vDA, boolean vDD, boolean vVR, boolean vPC, boolean vRM, boolean vCT,
			boolean vTitDP, boolean vBRS, boolean vBRM, boolean vBPA, boolean vBDR, boolean vEMNC, boolean vBEMC,
			boolean vLTCT, boolean cBCC) {
		vf.getVentanaDirector().getPanelDerechaArriba().setVisible(vDA);
		vf.getVentanaDirector().getPanelDatosDirector().setVisible(vDD);
		vf.getVentanaDirector().getPanelVariableReportes().setVisible(vVR);
		vf.getVentanaDirector().getPanelCentral().setVisible(vPC);
		vf.getVentanaDirector().getPanelReporteMensual().setVisible(vRM);
		vf.getVentanaDirector().getPanelCreacionTurno().setVisible(vCT);
		vf.getVentanaDirector().getLblTituloDatosP().setVisible(vTitDP);
		vf.getVentanaDirector().getBtnReporteSemanal().setVisible(vBRS);
		vf.getVentanaDirector().getBtnReporteMensual().setVisible(vBRM);
		vf.getVentanaDirector().getBtnPacientesAtendidos().setVisible(vBPA);
		vf.getVentanaDirector().getBtnDiagnosticosRealizados().setVisible(vBDR);
		vf.getVentanaDirector().getBtnEspecialistasMNC().setVisible(vEMNC);
		vf.getVentanaDirector().getBtnEspecialidadMC().setVisible(vBEMC);
		vf.getVentanaDirector().getBtnCitasCanceladas().setVisible(cBCC);
		vf.getVentanaDirector().getLblTituloCreacionTurno().setVisible(vLTCT);
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
		// vf.getVentanaPaciente().getCmbEspecialistas().setSelectedIndex(0);
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
		// vf.getVentanaDirector().getCmbEspecialistaCreacionT().setSelectedIndex(0);
		vf.getVentanaDirector().getCmbGenero().setSelectedIndex(0);
		vf.getVentanaDirector().getCmbNivelDirectivo().setSelectedIndex(0);
		vf.getVentanaDirector().getFechaCreacionTurno().setCalendar(null);
		vf.getVentanaDirector().getFechaNacimiento().setCalendar(null);
	}

	// TABLA DE CITAS AGENDADAS DEL PACIENTE
	public void tablaCitasAgendadasP() {
		String titulosCA[] = { "Número de Cita", "Especialidad", "Especialista", "Fecha", "Hora", "Estado" };
		ArrayList<CitaDTO> cList = mf.getCitaDAO().getAll();
		// pendiente filtrar las citas del Paciente actual
		// .....
		String datosCA[][] = new String[1][6];
		if (cList != null) {
			datosCA = new String[cList.size()][6];

			int i = 0;
			for (CitaDTO citaDTO : cList) {
				datosCA[i][0] = Integer.toString(citaDTO.getNumeroCita());
				// recuperar el Especialista
				Especialista esp = citaDTO.getEspecialista();
				if (esp != null) {
					datosCA[i][1] = esp.getEspecialidad();
					datosCA[i][2] = esp.getNombre();
				}
				if (citaDTO.getFecha() != null)
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
		scrollPane.setBounds(10, 10, 500, 300); // validar coordenadas
		vf.getVentanaPaciente().getPanelCitasAgendadas().add(scrollPane);
		scrollPane.setViewportView(jtCitasAgendadas);

	}

	// TABLA TRATAMIENTO MEDICO DEL PACIENTE
	public void tablaTratamientoMedicoP() {
		String titulosTM[] = { "Nombre del Especialista", "Fecha", "Examen Solicitado", "Diagnostico", "Tratamiento" };
		ArrayList<TratamientoMedicoDTO> tmList = mf.getTratamientoMedicoDAO().getAll();
		// pendiente filtrar las citas del Paciente actual
		// .....
		String datosCA[][] = new String[1][5];
		if (tmList != null) {
			datosCA = new String[tmList.size()][5];

			int i = 0;
			for (TratamientoMedicoDTO tmDTO : tmList) {
				// recuperar el Especialista
				Especialista esp = tmDTO.getEspecialista();
				if (esp != null) {
					datosCA[i][0] = esp.getNombre();
				}
				if (tmDTO.getFecha() != null)
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
		scrollPane.setBounds(10, 10, 500, 300); // validar coordenadas
		vf.getVentanaPaciente().getPanelTratamientoMedico().add(scrollPane);
		scrollPane.setViewportView(jtTratamientoMedico);

	}

	// DATOS
	public void preparacionDeDatosEsp() {

		// NEUMOLOGÍA

		EspecialistaDTO esp1 = new EspecialistaDTO("Sofía Sequea",
				new GregorianCalendar(2001, Calendar.APRIL, 5).getTime(), "Femenino", 452136097,
				"dcaicedos@unbosque.edu.co", "Neumología");
		EspecialistaDTO esp2 = new EspecialistaDTO("Alejandra Díaz",
				new GregorianCalendar(2000, Calendar.AUGUST, 6).getTime(), "Femenino", 213645879,
				"dcaicedos@unbosque.edu.co", "Neumología");
		EspecialistaDTO esp3 = new EspecialistaDTO("Bredy Daza",
				new GregorianCalendar(1998, Calendar.DECEMBER, 30).getTime(), "Masculino", 754819613,
				"dcaicedos@unbosque.edu.co", "Neumología");
		EspecialistaDTO esp4 = new EspecialistaDTO("Nicolás Moncada",
				new GregorianCalendar(2002, Calendar.MAY, 18).getTime(), "Masculino", 854697238,
				"dcaicedos@unbosque.edu.co", "Neumología");
		EspecialistaDTO esp5 = new EspecialistaDTO("Jerónimo Vega",
				new GregorianCalendar(1999, Calendar.JULY, 3).getTime(), "Masculino", 2013469853,
				"dcaicedos@unbosque.edu.co", "Neumología");

		// CARDIOLOGÍA
		EspecialistaDTO esp6 = new EspecialistaDTO("Andrés Toquica",
				new GregorianCalendar(1997, Calendar.AUGUST, 8).getTime(), "Masculino", 987654321,
				"sperezhe@unbosque.edu.co", "Cardiología");
		EspecialistaDTO esp7 = new EspecialistaDTO("Alejandra Villa",
				new GregorianCalendar(1998, Calendar.FEBRUARY, 9).getTime(), "Femenino", 876543210,
				"sperezhe@unbosque.edu.co", "Cardiología");
		EspecialistaDTO esp8 = new EspecialistaDTO("Manuela Villalba",
				new GregorianCalendar(1995, Calendar.NOVEMBER, 15).getTime(), "Femenino", 765432109,
				"sperezhe@unbosque.edu.co", "Cardiología");
		EspecialistaDTO esp9 = new EspecialistaDTO("Estefany Silva",
				new GregorianCalendar(1990, Calendar.MARCH, 21).getTime(), "Femenino", 654321097,
				"sperezhe@unbosque.edu.co", "Cardiología");
		EspecialistaDTO esp10 = new EspecialistaDTO("Nicholas Olaya",
				new GregorianCalendar(1992, Calendar.JANUARY, 11).getTime(), "Masculino", 561243048,
				"sperezhe@unbosque.edu.co", "Cardiología");

		// MEDICINA INTERNA

		EspecialistaDTO esp11 = new EspecialistaDTO("Nicolás Gutiérrez",
				new GregorianCalendar(1996, Calendar.JUNE, 2).getTime(), "Masculino", 1541564154,
				"sgranadosp@unbosque.edu.co", "Medicina Interna");
		EspecialistaDTO esp12 = new EspecialistaDTO("Alexandra Cardona",
				new GregorianCalendar(2001, Calendar.SEPTEMBER, 1).getTime(), "Femenino", 484564845,
				"sgranadosp@unbosque.edu.co", "Medicina Interna");
		EspecialistaDTO esp13 = new EspecialistaDTO("Daniel Sánchez",
				new GregorianCalendar(2002, Calendar.NOVEMBER, 19).getTime(), "Masculino", 789789741,
				"sgranadosp@unbosque.edu.co", "Medicina Interna");
		EspecialistaDTO esp14 = new EspecialistaDTO("Fernando Hernández",
				new GregorianCalendar(1997, Calendar.DECEMBER, 7).getTime(), "Masculino", 791264551,
				"sgranadosp@unbosque.edu.co", "Medicina Interna");
		EspecialistaDTO esp15 = new EspecialistaDTO("Luis Díaz",
				new GregorianCalendar(1989, Calendar.JANUARY, 26).getTime(), "Masculino", 315489987,
				"sgranadosp@unbosque.edu.co", "Medicina Interna");

		// CIRUGÍA

		EspecialistaDTO esp16 = new EspecialistaDTO("Ginna Romero",
				new GregorianCalendar(2001, Calendar.APRIL, 4).getTime(), "Femenino", 1234567891,
				"dcaicedos@unbosque.edu.co", "Cirugía");
		EspecialistaDTO esp17 = new EspecialistaDTO("Alejandra Wage",
				new GregorianCalendar(2000, Calendar.AUGUST, 5).getTime(), "Femenino", 234567912,
				"dcaicedos@unbosque.edu.co", "Cirugía");
		EspecialistaDTO esp18 = new EspecialistaDTO("Mario Rodriguez",
				new GregorianCalendar(1998, Calendar.DECEMBER, 29).getTime(), "Masculino", 34789123,
				"dcaicedos@unbosque.edu.co", "Cirugía");
		EspecialistaDTO esp19 = new EspecialistaDTO("Nicolás Zambrano",
				new GregorianCalendar(2002, Calendar.MAY, 17).getTime(), "Masculino", 456791234,
				"dcaicedos@unbosque.edu.co", "Cirugía");
		EspecialistaDTO esp20 = new EspecialistaDTO("Sebastián Pérez",
				new GregorianCalendar(1999, Calendar.JULY, 4).getTime(), "Masculino", 569712345,
				"dcaicedos@unbosque.edu.co", "Cirugía");

		// ONCOLOGÍA

		EspecialistaDTO esp21 = new EspecialistaDTO("Julio Avendaño",
				new GregorianCalendar(1997, Calendar.AUGUST, 7).getTime(), "Masculino", 654783258,
				"sperezhe@unbosque.edu.co", "Oncología");
		EspecialistaDTO esp22 = new EspecialistaDTO("Luisa Suárez",
				new GregorianCalendar(1998, Calendar.FEBRUARY, 8).getTime(), "Femenino", 452184324,
				"sperezhe@unbosque.edu.co", "Oncología");
		EspecialistaDTO esp23 = new EspecialistaDTO("Lizeth Estevez",
				new GregorianCalendar(1995, Calendar.NOVEMBER, 14).getTime(), "Femenino", 754964287,
				"sperezhe@unbosque.edu.co", "Oncología");
		EspecialistaDTO esp24 = new EspecialistaDTO("Esperanza Valderrama",
				new GregorianCalendar(1990, Calendar.MARCH, 20).getTime(), "Femenino", 325489102,
				"sperezhe@unbosque.edu.co", "Oncología");
		EspecialistaDTO esp25 = new EspecialistaDTO("Eduardo Peña",
				new GregorianCalendar(1992, Calendar.JANUARY, 10).getTime(), "Masculino", 1025478967,
				"sperezhe@unbosque.edu.co", "Oncología");

		// DERMATOLOGÍA

		EspecialistaDTO esp26 = new EspecialistaDTO("Mauricio Pedraza",
				new GregorianCalendar(1996, Calendar.JUNE, 1).getTime(), "Masculino", 458793214,
				"sgranadosp@unbosque.edu.co", "Dermatología");
		EspecialistaDTO esp27 = new EspecialistaDTO("Diana Olaya",
				new GregorianCalendar(2001, Calendar.SEPTEMBER, 2).getTime(), "Femenino", 852314960,
				"sgranadosp@unbosque.edu.co", "Dermatología");
		EspecialistaDTO esp28 = new EspecialistaDTO("Cesar Díaz",
				new GregorianCalendar(2002, Calendar.NOVEMBER, 13).getTime(), "Masculino", 1023456879,
				"sgranadosp@unbosque.edu.co", "Dermatología");
		EspecialistaDTO esp29 = new EspecialistaDTO("Leonardo Bernal",
				new GregorianCalendar(1997, Calendar.DECEMBER, 22).getTime(), "Masculino", 256340897,
				"sgranadosp@unbosque.edu.co", "Dermatología");
		EspecialistaDTO esp30 = new EspecialistaDTO("Yimmy Chará",
				new GregorianCalendar(1989, Calendar.JANUARY, 25).getTime(), "Masculino", 302148586,
				"sgranadosp@unbosque.edu.co", "Dermatología");

		mf.getEspecialistaDAO().add(esp1);
		mf.getEspecialistaDAO().add(esp2);
		mf.getEspecialistaDAO().add(esp3);
		mf.getEspecialistaDAO().add(esp4);
		mf.getEspecialistaDAO().add(esp5);
		mf.getEspecialistaDAO().add(esp6);
		mf.getEspecialistaDAO().add(esp7);
		mf.getEspecialistaDAO().add(esp8);
		mf.getEspecialistaDAO().add(esp9);
		mf.getEspecialistaDAO().add(esp10);
		mf.getEspecialistaDAO().add(esp11);
		mf.getEspecialistaDAO().add(esp12);
		mf.getEspecialistaDAO().add(esp13);
		mf.getEspecialistaDAO().add(esp14);
		mf.getEspecialistaDAO().add(esp15);
		mf.getEspecialistaDAO().add(esp16);
		mf.getEspecialistaDAO().add(esp17);
		mf.getEspecialistaDAO().add(esp18);
		mf.getEspecialistaDAO().add(esp19);
		mf.getEspecialistaDAO().add(esp20);
		mf.getEspecialistaDAO().add(esp21);
		mf.getEspecialistaDAO().add(esp22);
		mf.getEspecialistaDAO().add(esp23);
		mf.getEspecialistaDAO().add(esp24);
		mf.getEspecialistaDAO().add(esp25);
		mf.getEspecialistaDAO().add(esp26);
		mf.getEspecialistaDAO().add(esp27);
		mf.getEspecialistaDAO().add(esp28);
		mf.getEspecialistaDAO().add(esp29);
		mf.getEspecialistaDAO().add(esp30);

	}

	// TABLAS CITAS MEDICAS ESPECIALISTA
	public void tablaCitasMedicasE() {
		String titulosCitasMedicasE[] = { "Número de cita", "Paciente", "Especialista", "Fecha", "Hora" };
		ArrayList<CitaDTO> citaMedicaList = mf.getCitaDAO().getAll();

		String datosCM[][] = new String[1][5];
		if (citaMedicaList != null) {
			datosCM = new String[citaMedicaList.size()][5];

			int i = 0;
			for (CitaDTO cmedicaDTO : citaMedicaList) {
				datosCM[i][0] = String.valueOf(cmedicaDTO.getNumeroCita());
				Paciente paTemp = cmedicaDTO.getPaciente();
				if (paTemp != null) {
					datosCM[i][1] = paTemp.getNombre();
				}
				Especialista espTemp = cmedicaDTO.getEspecialista();
				if (espTemp != null) {
					datosCM[i][2] = espTemp.getNombre();
				}

				datosCM[i][3] = cmedicaDTO.getFecha().toString();
				datosCM[i][4] = cmedicaDTO.getHora();

				i++;
			}
		}

		JTable jtCitasMedicasE = new JTable(datosCM, titulosCitasMedicasE);
		jtCitasMedicasE.setEnabled(true);
		jtCitasMedicasE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 300); // validar coordenadas
		vf.getVentanaEspecialista().getPanelCitasMedicas().add(scrollPane);
		scrollPane.setViewportView(jtCitasMedicasE);

	}

	// TABLA TURNOS DEL MES DEL ESPECIALISTA
	public void tablaTurnosMesE() {
		String titulosTME[] = { "Fecha", "Especialista" };
		ArrayList<TurnoDTO> tmeList = mf.getTurnoDAO().getAll();

		String datosTME[][] = new String[1][2];
		if (tmeList != null) {
			datosTME = new String[tmeList.size()][2];

			int i = 0;
			for (TurnoDTO tmeDTO : tmeList) {

				Especialista esp = tmeDTO.getEspecialista();
				datosTME[i][0] = tmeDTO.getFecha().toString();
				if (esp != null) {
					datosTME[i][1] = esp.getNombre();
				}

				i++;
			}
		}

		JTable jtTurnosMes = new JTable(datosTME, titulosTME);
		jtTurnosMes.setEnabled(true);
		jtTurnosMes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 300); // validar coordenadas
		vf.getVentanaEspecialista().getPanelTurnoMes().add(scrollPane);
		scrollPane.setViewportView(jtTurnosMes);
	}

	// TABLA LISTA DE TRATAMIENTOS DEL ESPECIALISTA
	public void tablaListaDeTratamientosE() {
		String titulosLTE[] = { "Paciente", "Tratamiento" };
		ArrayList<TratamientoMedicoDTO> lteList = mf.getTratamientoMedicoDAO().getAll();

		String datosLTE[][] = new String[1][2];
		if (lteList != null) {
			datosLTE = new String[lteList.size()][2];

			int i = 0;
			for (TratamientoMedicoDTO lteDTO : lteList) {
				// recuperar el Especialista
				Paciente paci = lteDTO.getPaciente();
				if (paci != null) {
					datosLTE[i][0] = paci.getNombre();
				}
				datosLTE[i][1] = lteDTO.getTratamiento();

				i++;
			}
		}

		JTable jtListaTratE = new JTable(datosLTE, titulosLTE);
		jtListaTratE.setEnabled(true);
		jtListaTratE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 300); // validar coordenadas
		vf.getVentanaEspecialista().getPanelListaTratamiento().add(scrollPane);
		scrollPane.setViewportView(jtListaTratE);
	}

	// TABLA PACIENTES ATENDIDOS DIRECTOR MEDICO
	public void tablaPacientesAtendidosDM() {
		String titulosPADM[] = { "Especialista", "Paciente", "Fecha" };
		ArrayList<CitaDTO> padmList = mf.getCitaDAO().getAll();

		String datosPADM[][] = new String[1][3];
		if (padmList != null) {
			datosPADM = new String[padmList.size()][3];

			int i = 0;
			for (CitaDTO padmDTO : padmList) {

				Especialista esp = padmDTO.getEspecialista();
				if (esp != null) {
					datosPADM[i][0] = esp.getNombre();
				}
				Paciente paci = padmDTO.getPaciente();
				if (paci != null) {
					datosPADM[i][1] = paci.getNombre();
				}
				datosPADM[i][2] = padmDTO.getFecha().toString();

				i++;
			}
		}

		JTable jtPacientesAtendidosDM = new JTable(datosPADM, titulosPADM);
		jtPacientesAtendidosDM.setEnabled(true);
		jtPacientesAtendidosDM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelPacientesAtendidos().add(scrollPane);
		scrollPane.setViewportView(jtPacientesAtendidosDM);
	}

	// TABLA DIAGNOSTICOS REALIZADOS DIRECTOR MEDICO
	public void tablaDiagnosticosRealizadosDM() {
		String titulosDRDM[] = { "Paciente", "Diagnostico", "Fecha" };
		ArrayList<TratamientoMedicoDTO> drdmList = mf.getTratamientoMedicoDAO().getAll();

		String datosDRDM[][] = new String[1][3];
		if (drdmList != null) {
			datosDRDM = new String[drdmList.size()][3];

			int i = 0;
			for (TratamientoMedicoDTO drdmDTO : drdmList) {

				Paciente paci = drdmDTO.getPaciente();
				if (paci != null) {
					datosDRDM[i][0] = paci.getNombre();
				}
				datosDRDM[i][1] = drdmDTO.getDiagnostico();
				datosDRDM[i][2] = drdmDTO.getFecha().toString();

				i++;
			}
		}

		JTable jtDiagnosticosRealizadosDM = new JTable(datosDRDM, titulosDRDM);
		jtDiagnosticosRealizadosDM.setEnabled(true);
		jtDiagnosticosRealizadosDM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelDiagnosticosRealizados().add(scrollPane);
		scrollPane.setViewportView(jtDiagnosticosRealizadosDM);
	}

	// Clase interna para facilitar el reporte
	class EspecialistaContador {
		public String NombreEspecialista;
		public int cantidadCitas;

		public EspecialistaContador() {
			// TODO Auto-generated constructor stub
		}

		public EspecialistaContador(String nombreEspecialista, int cantidadCitas) {
			super();
			NombreEspecialista = nombreEspecialista;
			this.cantidadCitas = cantidadCitas;
		}

		public String getNombreEspecialista() {
			return NombreEspecialista;
		}

		public void setNombreEspecialista(String nombreEspecialista) {
			NombreEspecialista = nombreEspecialista;
		}

		public int getCantidadCitas() {
			return cantidadCitas;
		}

		public void setCantidadCitas(int cantidadCitas) {
			this.cantidadCitas = cantidadCitas;
		}

	}

	class EspecialistaContadorT {
		public String NombreEspecialista;
		public int cantidadTurnos;

		public EspecialistaContadorT() {
			// TODO Auto-generated constructor stub
		}

		public EspecialistaContadorT(String nombreEspecialista, int cantidadTurnos) {
			super();
			NombreEspecialista = nombreEspecialista;
			this.cantidadTurnos = cantidadTurnos;
		}

		public String getNombreEspecialista() {
			return NombreEspecialista;
		}

		public void setNombreEspecialista(String nombreEspecialista) {
			NombreEspecialista = nombreEspecialista;
		}

		public int getCantidadTurnos() {
			return cantidadTurnos;
		}

		public void setCantidadTurnos(int cantidadTurnos) {
			this.cantidadTurnos = cantidadTurnos;
		}

	}

	// TABLA ESPECIALISTAS CON MAYOR NUMERO DE CITAS DIRECTOR MEDICO

	public void tablaEspecialistasMayorNumeroCitasDM() {

		ArrayList<EspecialistaContador> contadorCitas = new ArrayList<>();
		ArrayList<CitaDTO> emncdList = mf.getCitaDAO().getAll();
		String nombreEspecialista = "";

		for (CitaDTO citaDTO : emncdList) {
			nombreEspecialista = citaDTO.getEspecialista().getNombre();
			// buscar especialista en el arraylist contador de citas
			// si existe entonces le añado una cita
			// si no existe, añado el especialista al arraylist y lo inicio con 1

			// recorrer el arraylist contador de citas
			int ci = 0;
			boolean debeAgregarItem = false;
			for (EspecialistaContador especialistaContador : contadorCitas) {
				if (especialistaContador.getNombreEspecialista().equals(nombreEspecialista)) {
					// lo encontró, entonces trae el contador que tenga actualmente y le añade 1
					int cantCitasActual = especialistaContador.getCantidadCitas(); // recupera cantidadActual
					cantCitasActual++; // le añade 1
					// nuevo Valor a ingresar -- es el mismo update
					EspecialistaContador espContadorActualizado = new EspecialistaContador(nombreEspecialista,
							cantCitasActual);
					contadorCitas.set(ci, especialistaContador);
				} else {
					debeAgregarItem = true;

				}

			}
			if (contadorCitas.size() == 0) // esto sucede cuando no hay ningún item creado
				debeAgregarItem = true;

			if (debeAgregarItem) {
				// no lo encontró, entonces crea un nuevo item y lo añade al arreglo de
				// acumulación
				EspecialistaContador espContadorAgregar = new EspecialistaContador(nombreEspecialista, 1);
				contadorCitas.add(espContadorAgregar);
			}

			// contadorCitas.contains(nombreEspecialista)
		}
		// recorrer arreglo de citas

		String titulosEMNCDM[] = { "Especialista", "Número de citas" };

		String datosEMNCDM[][] = new String[1][2];
		if (contadorCitas != null) {
			datosEMNCDM = new String[contadorCitas.size()][2];

			int i = 0;

			for (EspecialistaContador espCont : contadorCitas) {

				datosEMNCDM[i][0] = espCont.getNombreEspecialista();
				datosEMNCDM[i][1] = String.valueOf(espCont.getCantidadCitas());

				i++;
			}
		}

		JTable jtEspMayorNumCitasDM = new JTable(datosEMNCDM, titulosEMNCDM);
		jtEspMayorNumCitasDM.setEnabled(true);
		jtEspMayorNumCitasDM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelEspecialisasMNC().add(scrollPane);
		scrollPane.setViewportView(jtEspMayorNumCitasDM);
	}

	// TABLA ESPECIALIDAD CON MAYOR CONSULTA DIRECTOR MEDICO
	public void tablaEspecialidadMayorConsultaDM() {
		String titulosEMCDM[] = { "Especialidad", "Número de consultas" };
		// ArrayList<TratamientoMedicoDTO> drdmList =
		// mf.getTratamientoMedicoDAO().getAll();

		String datosEMCDM[][] = new String[1][2];
		/*
		 * if (drdmList != null) { datosEMCDM = new String[drdmList.size()][3];
		 * 
		 * int i = 0; for (TratamientoMedicoDTO drdmDTO : drdmList) {
		 * 
		 * Paciente paci = drdmDTO.getPaciente(); if (paci != null) { datosEMCDM[i][0] =
		 * paci.getNombre(); } datosEMCDM[i][1] = drdmDTO.getDiagnostico();
		 * datosEMCDM[i][2] = drdmDTO.getFecha().toString();
		 * 
		 * i++; } }
		 */

		JTable jtEMCDM = new JTable(datosEMCDM, titulosEMCDM);
		jtEMCDM.setEnabled(true);
		jtEMCDM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelEspecialidadMC().add(scrollPane);
		scrollPane.setViewportView(jtEMCDM);
	}

	// TABLA CITAS CANCELADAS DIRECTOR MEDICO
	public void tablaCitasCanceladasDM() {
		String titulosCCDM[] = { "Especialidad", "Paciente", "Fecha" };
		// ArrayList<TratamientoMedicoDTO> drdmList =
		// mf.getTratamientoMedicoDAO().getAll();

		String datosCCDM[][] = new String[1][3];
		/*
		 * if (drdmList != null) { datosEMCDM = new String[drdmList.size()][3];
		 * 
		 * int i = 0; for (TratamientoMedicoDTO drdmDTO : drdmList) {
		 * 
		 * Paciente paci = drdmDTO.getPaciente(); if (paci != null) { datosEMCDM[i][0] =
		 * paci.getNombre(); } datosEMCDM[i][1] = drdmDTO.getDiagnostico();
		 * datosEMCDM[i][2] = drdmDTO.getFecha().toString();
		 * 
		 * i++; } }
		 */

		JTable jtCC = new JTable(datosCCDM, titulosCCDM);
		jtCC.setEnabled(true);
		jtCC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelCitasCanceladas().add(scrollPane);
		scrollPane.setViewportView(jtCC);
	}

	// TABLA REPORTE MENSUAL DIRECTOR MEDICO
	public void tablaReporteMensualDM() {
		ArrayList<EspecialistaContadorT> contadorTurnos = new ArrayList<>();
		ArrayList<TurnoDTO> emncList = mf.getTurnoDAO().getAll();
		String nombreEspecialistaT = "";

		for (TurnoDTO turnDTO : emncList) {
			nombreEspecialistaT = turnDTO.getEspecialista().getNombre();
			// buscar especialista en el arraylist contador de citas
			// si existe entonces le añado una cita
			// si no existe, añado el especialista al arraylist y lo inicio con 1

			// recorrer el arraylist contador de citas
			int ti = 0;
			boolean debeAgregarItemT = false;
			for (EspecialistaContadorT especialistaContadorT : contadorTurnos) {
				if (especialistaContadorT.getNombreEspecialista().equals(nombreEspecialistaT)) {
					// lo encontró, entonces trae el contador que tenga actualmente y le añade 1
					int cantTurno = especialistaContadorT.getCantidadTurnos(); // recupera cantidadActual
					cantTurno++; // le añade 1
					// nuevo Valor a ingresar -- es el mismo update
					EspecialistaContador espContadorActualizado = new EspecialistaContador(nombreEspecialistaT,
							cantTurno);
					contadorTurnos.set(ti, especialistaContadorT);
				} else {
					debeAgregarItemT = true;

				}

			}
			if (contadorTurnos.size() == 0) // esto sucede cuando no hay ningún item creado
				debeAgregarItemT = true;

			if (debeAgregarItemT) {
				// no lo encontró, entonces crea un nuevo item y lo añade al arreglo de
				// acumulación
				EspecialistaContadorT espContadorAgregarTur = new EspecialistaContadorT(nombreEspecialistaT, 1);
				contadorTurnos.add(espContadorAgregarTur);
			}

			// contadorCitas.contains(nombreEspecialista)
		}
		// recorrer arreglo de citas

		String titulosRMDM[] = { "Especialista", "Cantidad de Turnos" };

		String datosRMDM[][] = new String[1][2];
		if (contadorTurnos != null) {
			datosRMDM = new String[contadorTurnos.size()][2];

			int i = 0;

			for (EspecialistaContadorT espContT : contadorTurnos) {

				datosRMDM[i][0] = espContT.getNombreEspecialista();
				datosRMDM[i][1] = String.valueOf(espContT.getCantidadTurnos());

				i++;
			}
		}

		JTable jtDirectorRMDM = new JTable(datosRMDM, titulosRMDM);
		jtDirectorRMDM.setEnabled(true);
		jtDirectorRMDM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 200); // validar coordenadas
		vf.getVentanaDirector().getPanelReporteMensual().add(scrollPane);
		scrollPane.setViewportView(jtDirectorRMDM);
	}

	public void cargarComboBoxAgendarCita() {
		vf.getVentanaPaciente().getCmbEspecialidad().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cargarEspecialistaAgendar((String) vf.getVentanaPaciente().getCmbEspecialidad().getSelectedItem());
			}
		});
	}

	public void cargarEspecialistaAgendar(String seleccionEsp) {
		vf.getVentanaPaciente().getCmbEspecialistas().removeAllItems();
		ArrayList<EspecialistaDTO> listaE = mf.getEspecialistaDAO().getAll();
		for (EspecialistaDTO especialistaDTO : listaE) {
			if (especialistaDTO.getEspecialidad().equals(seleccionEsp)) {
				vf.getVentanaPaciente().getCmbEspecialistas().addItem(especialistaDTO.getNombre());
			}
		}
	}

	public void cargarComboBoxGenerarTurno() {
		vf.getVentanaDirector().getCmbEspecialidadCreacionT().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cargarEspecialistaGenerarTurnos(
						(String) vf.getVentanaDirector().getCmbEspecialidadCreacionT().getSelectedItem());
			}
		});
	}

	public void cargarEspecialistaGenerarTurnos(String selectEsp) {
		vf.getVentanaDirector().getCmbEspecialistaCreacionT().removeAllItems();
		ArrayList<EspecialistaDTO> listaE = mf.getEspecialistaDAO().getAll();
		for (EspecialistaDTO especialistaDTO : listaE) {
			if (especialistaDTO.getEspecialidad().equals(selectEsp)) {
				vf.getVentanaDirector().getCmbEspecialistaCreacionT().addItem(especialistaDTO.getNombre());
			}
		}
	}

	public void cargarCmbPacienteTrat() {
		vf.getVentanaEspecialista().getCmbEscogerPaciente().removeAllItems();
		vf.getVentanaEspecialista().getCmbEspecialistaActual().removeAllItems();
		vf.getVentanaEspecialista().getCmbNuevoEspecialista().removeAllItems();
		ArrayList<PacienteDTO> listaP = mf.getPacienteDAO().getAll();
		for (PacienteDTO pacienteDTO : listaP) {
			vf.getVentanaEspecialista().getCmbEscogerPaciente().addItem(pacienteDTO.getNombre());
		}
	}

	public void cargarCmbFechaTurno() {
		vf.getVentanaEspecialista().getCmbFechaTurno().removeAllItems();
		vf.getVentanaEspecialista().getCmbFechaTurno().addItem("");

		ArrayList<TurnoDTO> listaT = mf.getTurnoDAO().getAll();
		for (TurnoDTO turnoDTO : listaT) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fecTurno = turnoDTO.getFecha();
			String SFecTurno = sdf.format(fecTurno);

			vf.getVentanaEspecialista().getCmbFechaTurno()
					.addItem(String.valueOf(turnoDTO.getNumId()) + " : " + SFecTurno);

		}
		vf.getVentanaEspecialista().getCmbFechaTurno().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vf.getVentanaEspecialista().getCmbEspecialistaActual().removeAllItems();

				if (vf.getVentanaEspecialista().getCmbFechaTurno().getSelectedItem() != null) {

					String turnoSelec = vf.getVentanaEspecialista().getCmbFechaTurno().getSelectedItem().toString();
					String[] turnoSplit = turnoSelec.split(" : ");
					if (turnoSplit != null && turnoSplit.length >= 0) {
						if (!turnoSplit[0].trim().equals("")) {
							int iDTurno = Integer.parseInt(turnoSplit[0]);
							Turno turnoTemp = new Turno(null, null, iDTurno);
							Turno tEncontrado = mf.getTurnoDAO().find(turnoTemp);
							if (tEncontrado != null) {
								vf.getVentanaEspecialista().getCmbEspecialistaActual()
										.addItem(tEncontrado.getEspecialista().getNombre());

								String espeTempActua = tEncontrado.getEspecialista().getEspecialidad();

								ArrayList<EspecialistaDTO> listTempEsp = mf.getEspecialistaDAO().getAll();
								for (EspecialistaDTO espTemp : listTempEsp) {
									if (espTemp.getEspecialidad().equals(espeTempActua)) {
										vf.getVentanaEspecialista().getCmbNuevoEspecialista()
												.addItem(espTemp.getNombre());
									}
								}

							}
						}
					}
				}
			}

		});
	}

	public boolean verifyMail(String mail) {
		try {
			ExceptionChecker.mail(mail);
			return true;
		} catch (MailException e) {
			return false;
		}
	}

	public boolean verifyDate(Date fecha) {
		try {
			ExceptionChecker.notValidBirthdateException(fecha);
			return true;
		} catch (InvalidDateException e) {
			return false;
		}
	}

	public boolean verifyNumber(int num) {
		try {
			ExceptionChecker.notValidNumberException(num);
			return true;
		} catch (PositiveIntegerException e) {
			return false;
		}
	}

	public boolean verifyTxt(String txt) {
		try {
			ExceptionChecker.notSpecialCharacter(txt);
			return true;
		} catch (NotSpecialCharacterException e) {

			return false;
		}
	}

	public void cargarPEDinicial() {
		// NivelesPersona nivelesPersona =
		// listNivelesPersona2.get(listNivelesPersona2.size() -1 );

		ArrayList<PacienteDTO> listPa = mf.getPacienteDAO().getAll();
		if (listPa.size() > 0) {
			PacienteDTO pacDTOTemp = listPa.get(listPa.size() - 1);
			pacienteActual = new Paciente(pacDTOTemp.getNombre(), pacDTOTemp.getFechaNacimiento(),
					pacDTOTemp.getGenero(), pacDTOTemp.getId(), pacDTOTemp.getCorreo(), pacDTOTemp.getTratamiento());
		}

		ArrayList<EspecialistaDTO> listEsp = mf.getEspecialistaDAO().getAll();
		if (listEsp.size() > 0) {
			EspecialistaDTO espDTOTemp = listEsp.get(listEsp.size() - 1);
			especialistaActual = new Especialista(espDTOTemp.getNombre(), espDTOTemp.getFechaNacimiento(),
					espDTOTemp.getGenero(), espDTOTemp.getId(), espDTOTemp.getCorreo(), espDTOTemp.getEspecialidad());
		}

		ArrayList<DirectorMedicoDTO> listDirMe = mf.getDirectorMedicoDAO().getAll();
		if (listDirMe.size() > 0) {
			DirectorMedicoDTO dirMeDTOTemp = listDirMe.get(listDirMe.size() - 1);
			directorActual = new DirectorMedico(dirMeDTOTemp.getNombre(), dirMeDTOTemp.getFechaNacimiento(),
					dirMeDTOTemp.getGenero(), dirMeDTOTemp.getId(), dirMeDTOTemp.getCorreo(),
					dirMeDTOTemp.getNivelDirectivo());
		}
	}

	public int numRandom() {
		return (int) (Math.random() * 10000 + 100);
	}

}