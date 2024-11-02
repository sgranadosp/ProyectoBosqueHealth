package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cita;
import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.DirectorMedico;
import co.edu.unbosque.model.DirectorMedicoDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.EspecialistaDTO;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.TratamientoMedico;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.model.Turno;
import co.edu.unbosque.model.TurnoDTO;

public class DataMapper {
	
	public static PacienteDTO pacienteToPacienteDTO(Paciente e) {
		
		
		//Paciente
		PacienteDTO dto ;
		dto = new PacienteDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getTratamiento());
		return dto;
	}
	
	public static Paciente pacienteDTOToPaciente(PacienteDTO dto) {
		
		Paciente e;
		e = new Paciente(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getTratamiento());
		return e;
	}
	
	public static ArrayList<PacienteDTO> listaPacienteToListaPacienteDTO(ArrayList<Paciente> eList){
		
		ArrayList<PacienteDTO> dtoList = new ArrayList<>();
		for (Paciente p : eList) {
			dtoList.add(new PacienteDTO(p.getNombre(), p.getFechaNacimiento(), p.getGenero(), p.getId(), p.getCorreo(), p.getTratamiento()));
		}
		return dtoList;
	}
	
	public static ArrayList<Paciente> listaPacienteDTOToListaPaciente(ArrayList<PacienteDTO> dtoList){
		
		ArrayList<Paciente> eList = new ArrayList<>();
		for (PacienteDTO p : dtoList) {
			eList.add(new Paciente(p.getNombre(), p.getFechaNacimiento(), p.getGenero(), p.getId(), p.getCorreo(), p.getTratamiento()));
		}
		return eList;
	}
	
	//Especialista
	public static EspecialistaDTO especialistaToEspecialistaDTO(Especialista e) {
		
		EspecialistaDTO dto ;
		dto = new EspecialistaDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad());
		return dto;
	}
	
	public static Especialista especialistaDTOToEspecialista(EspecialistaDTO dto) {
		
		Especialista e;
		e = new Especialista(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getEspecialidad());
		return e;
	}
	
	public static ArrayList<EspecialistaDTO> listaEspecialistaToListaEspecialistaDTO(ArrayList<Especialista> eList){
		
		ArrayList<EspecialistaDTO> dtoList = new ArrayList<>();
		for (Especialista e : eList) {
			dtoList.add(new EspecialistaDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad()));
		}
		return dtoList;
	}
	
	public static ArrayList<Especialista> listaEspecialistaDTOToListaEspecialista(ArrayList<EspecialistaDTO> dtoList){
		
		ArrayList<Especialista> eList = new ArrayList<>();
		for (EspecialistaDTO e : dtoList) {
			eList.add(new Especialista(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad()));
		}
		return eList;
	}
	
	//Director medico
	public static DirectorMedicoDTO directorMedicoToDirectorMedicoDTO(DirectorMedico e) {
		
		DirectorMedicoDTO dto ;
		dto = new DirectorMedicoDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getNivelDirectivo());
		return dto;
	}
	
	public static DirectorMedico directorMedicolistaDTOToDirectorMedico(DirectorMedicoDTO dto) {
		
		DirectorMedico e;
		e = new DirectorMedico(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getNivelDirectivo());
		return e;
	}
	
	public static ArrayList<DirectorMedicoDTO> listaDirectorMedicoToListaDirectorMedicoDTO(ArrayList<DirectorMedico> eList){
		
		ArrayList<DirectorMedicoDTO> dtoList = new ArrayList<>();
		for (DirectorMedico d : eList) {
			dtoList.add(new DirectorMedicoDTO(d.getNombre(), d.getFechaNacimiento(), d.getGenero(), d.getId(), d.getCorreo(), d.getNivelDirectivo()));
		}
		return dtoList;
	}
	
	public static ArrayList<DirectorMedico> listaDirectorMedicoDTOToListaDirectorMedico(ArrayList<DirectorMedicoDTO> dtoList){
		
		ArrayList<DirectorMedico> eList = new ArrayList<>();
		for (DirectorMedicoDTO d : dtoList) {
			eList.add(new DirectorMedico(d.getNombre(), d.getFechaNacimiento(), d.getGenero(), d.getId(), d.getCorreo(), d.getNivelDirectivo()));
		}
		return eList;
	}

	
	//Cita
	public static Cita citaDTOToCita(CitaDTO dto) {
		Cita e;
		e = new Cita(dto.getEspecialista(), dto.getPaciente(), dto.getFecha(), dto.getHora(), dto.getNumeroCita(), dto.getEstado());
		return e;
	}
	
	public static CitaDTO citaToCitaDTO(Cita e) {
		CitaDTO dto;
		dto = new CitaDTO(e.getEspecialista(), e.getPaciente(), e.getFecha(), e.getHora(), e.getNumeroCita(), e.getEstado());
		return dto;
	}
	
	public static ArrayList<Cita> listaCitaDTOToListaCita(ArrayList<CitaDTO> dtoList){
		ArrayList<Cita> eList = new ArrayList<>();
		for (CitaDTO c : dtoList) {
			eList.add(new Cita(c.getEspecialista(), c.getPaciente(), c.getFecha(), c.getHora(), c.getNumeroCita(), c.getEstado()));
		}
		return eList;
	}
	
	public static ArrayList<CitaDTO> listaCitaToListaCitaDTO(ArrayList<Cita> eList){
		ArrayList<CitaDTO> dtoList = new ArrayList<>();
		for (Cita c : eList) {
			dtoList.add(new CitaDTO(c.getEspecialista(), c.getPaciente(), c.getFecha(), c.getHora(), c.getNumeroCita(), c.getEstado()));
		}
		return dtoList;
	}
	
	//Turno
	public static Turno turnoDTOToTurno(TurnoDTO dto) {
		Turno e;
		e = new Turno(dto.getEspecialista(), dto.getFecha(), dto.getNumId());
		return e;
	}
	
	public static TurnoDTO turnoToTurnoDTO(Turno e) {
		TurnoDTO dto;
		dto = new TurnoDTO(e.getEspecialista(), e.getFecha(), e.getNumId());
		return dto;
	}
	
	public static ArrayList<Turno> listaTurnoDTOToListaTurno(ArrayList<TurnoDTO> dtoList){
		ArrayList<Turno> eList = new ArrayList<>();
		for (TurnoDTO t : dtoList) {
			eList.add(new Turno(t.getEspecialista(), t.getFecha(), t.getNumId()));
		}
		return eList;
	}
	
	public static ArrayList<TurnoDTO> listaTurnoToListaTurnoDTO(ArrayList<Turno> eList){
		ArrayList<TurnoDTO> dtoList = new ArrayList<>();
		for (Turno t : eList) {
			dtoList.add(new TurnoDTO(t.getEspecialista(), t.getFecha(), t.getNumId()));
		}
		return dtoList;
	}
	
	
	//Tratamiento medico
	public static TratamientoMedico tratamientoMedicoDTOToTratamientoMedico(TratamientoMedicoDTO dto) {
		TratamientoMedico e;
		e = new TratamientoMedico(dto.getPaciente(),dto.getEspecialista(), dto.getFecha(), dto.getTratamiento(), dto.getExamen(), dto.getDiagnostico()) ;
		return e;
	}
	
	public static TratamientoMedicoDTO tratamientoMedicoToTratamientoMedicoDTO(TratamientoMedico e) {
		TratamientoMedicoDTO dto;
		dto = new TratamientoMedicoDTO(e.getPaciente(), e.getEspecialista(), e.getFecha(), e.getTratamiento(), e.getExamen(), e.getExamen());
		return dto;
	}
	
	public static ArrayList<TratamientoMedico> listaTratamientoMedicoDTOToListaTratamientoMedico(ArrayList<TratamientoMedicoDTO> dtoList){
		ArrayList<TratamientoMedico> eList = new ArrayList<>();
		for (TratamientoMedicoDTO t : dtoList) {
			eList.add(new TratamientoMedico(t.getPaciente(), t.getEspecialista(), t.getFecha(), t.getTratamiento(), t.getExamen(), t.getExamen()));
		}
		return eList;
	}
	
	public static ArrayList<TratamientoMedicoDTO> listaTratamientoMedicoToListaTratamientoMedicoDTO(ArrayList<TratamientoMedico> eList){
		ArrayList<TratamientoMedicoDTO> dtoList = new ArrayList<>();
		for (TratamientoMedico t : eList) {
			dtoList.add(new TratamientoMedicoDTO(t.getPaciente(), t.getEspecialista(), t.getFecha(), t.getTratamiento(), t.getExamen(), t.getExamen()));
		}
		return dtoList;
	}
}
