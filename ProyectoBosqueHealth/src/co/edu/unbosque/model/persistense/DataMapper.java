package co.edu.unbosque.model.persistense;

import java.util.ArrayList;

import co.edu.unbosque.model.DirectorMedico;
import co.edu.unbosque.model.DirectorMedicoDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.EspecialistaDTO;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;

public class DataMapper {
	
	public static PacienteDTO pacienteToPacienteDTO(Paciente e) {
		
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

	
}
