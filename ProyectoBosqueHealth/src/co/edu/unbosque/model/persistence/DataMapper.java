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

/**
 * La clase {@code DataMapper} proporciona métodos para convertir entre objetos de entidad 
 * y sus correspondientes objetos Data Transfer Object (DTO), y viceversa.
 * <p>
 * Esta clase facilita la conversión entre estos tipos, permitiendo la manipulación 
 * de datos a nivel de aplicación sin exponer las entidades originales.
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class DataMapper {
	
	 /**
     * Convierte un objeto {@code Paciente} a un objeto {@code PacienteDTO}.
     * 
     * @param e el objeto {@code Paciente} que se va a convertir.
     * @return un nuevo objeto {@code PacienteDTO} con los mismos datos.
     */
	public static PacienteDTO pacienteToPacienteDTO(Paciente e) {
		
		//Paciente
		PacienteDTO dto ;
		dto = new PacienteDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getTratamiento());
		return dto;
	}
	
	/**
     * Convierte un objeto {@code PacienteDTO} a un objeto {@code Paciente}.
     * 
     * @param dto el objeto {@code PacienteDTO} que se va a convertir.
     * @return un nuevo objeto {@code Paciente} con los mismos datos.
     */
	public static Paciente pacienteDTOToPaciente(PacienteDTO dto) {
		
		Paciente e;
		e = new Paciente(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getTratamiento());
		return e;
	}
	
	 /**
     * Convierte una lista de {@code Paciente} a una lista de {@code PacienteDTO}.
     * 
     * @param eList la lista de objetos {@code Paciente}.
     * @return una lista de objetos {@code PacienteDTO} con los mismos datos.
     */
	public static ArrayList<PacienteDTO> listaPacienteToListaPacienteDTO(ArrayList<Paciente> eList){
		ArrayList<PacienteDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (Paciente p : eList) {
				dtoList.add(new PacienteDTO(p.getNombre(), p.getFechaNacimiento(), p.getGenero(), p.getId(), p.getCorreo(), p.getTratamiento()));
			}
		}	
		return dtoList;
	}
	
	 /**
     * Convierte una lista de {@code PacienteDTO} a una lista de {@code Paciente}.
     * 
     * @param dtoList la lista de objetos {@code PacienteDTO}.
     * @return una lista de objetos {@code Paciente} con los mismos datos.
     */
	public static ArrayList<Paciente> listaPacienteDTOToListaPaciente(ArrayList<PacienteDTO> dtoList){
		ArrayList<Paciente> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (PacienteDTO p : dtoList) {
				eList.add(new Paciente(p.getNombre(), p.getFechaNacimiento(), p.getGenero(), p.getId(), p.getCorreo(), p.getTratamiento()));
			}
		}	
		return eList;
	}
	
	//Especialista
	/**
     * Convierte un objeto {@code Especialista} a un objeto {@code EspecialistaDTO}.
     * 
     * @param e el objeto {@code Especialista} que se va a convertir.
     * @return un nuevo objeto {@code EspecialistaDTO} con los mismos datos.
     */
	public static EspecialistaDTO especialistaToEspecialistaDTO(Especialista e) {
		
		EspecialistaDTO dto ;
		dto = new EspecialistaDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad());
		return dto;
	}
	
	/**
     * Convierte un objeto {@code EspecialistaDTO} a un objeto {@code EspecialistaDTO}.
     * 
     * @param dto el objeto {@code EspecialistaDTO} que se va a convertir.
     * @return un nuevo objeto {@code Especialista} con los mismos datos.
     */
	public static Especialista especialistaDTOToEspecialista(EspecialistaDTO dto) {
		
		Especialista e;
		e = new Especialista(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getEspecialidad());
		return e;
	}
	
	/**
	 * Convierte una lista de {@code Especialista} a una lista de {@code EspecialistaDTO}.
     * 
     * @param eList la lista de objetos {@code Especialista}.
     * @return una lista de objetos {@code EspecialistaDTO} con los mismos datos.
     */
	public static ArrayList<EspecialistaDTO> listaEspecialistaToListaEspecialistaDTO(ArrayList<Especialista> eList){
		ArrayList<EspecialistaDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (Especialista e : eList) {
				dtoList.add(new EspecialistaDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad()));
			}
		}
		return dtoList;
	}
	
	/**
     * Convierte una lista de {@code EspecialistaDTO} a una lista de {@code Especialista}.
     * 
     * @param dtoList la lista de objetos {@code EspecialistaDTO}.
     * @return una lista de objetos {@code Especialista} con los mismos datos.
     */
	public static ArrayList<Especialista> listaEspecialistaDTOToListaEspecialista(ArrayList<EspecialistaDTO> dtoList){
		ArrayList<Especialista> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (EspecialistaDTO e : dtoList) {
				eList.add(new Especialista(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getEspecialidad()));
			}
		}	
		return eList;
	}
	
	//Director medico
	
	/**
     * Convierte un objeto {@code DirectorMedico} a un objeto {@code DirectorMedicoDTO}.
     * 
     * @param e el objeto {@code DirectorMedico} que se va a convertir.
     * @return un nuevo objeto {@code DirectorMedicoDTO} con los mismos datos.
     */
	public static DirectorMedicoDTO directorMedicoToDirectorMedicoDTO(DirectorMedico e) {
		
		DirectorMedicoDTO dto ;
		dto = new DirectorMedicoDTO(e.getNombre(), e.getFechaNacimiento(), e.getGenero(), e.getId(), e.getCorreo(), e.getNivelDirectivo());
		return dto;
	}
	
	/**
     * Convierte un objeto {@code DirectorMedicoDTO} a un objeto {@code DirectorMedico}.
     * 
     * @param dto el objeto {@code DirectorMedicoDTO} que se va a convertir.
     * @return un nuevo objeto {@code DirectorMedico} con los mismos datos.
     */
	public static DirectorMedico directorMedicolistaDTOToDirectorMedico(DirectorMedicoDTO dto) {
		
		DirectorMedico e;
		e = new DirectorMedico(dto.getNombre(), dto.getFechaNacimiento(), dto.getGenero(), dto.getId(), dto.getCorreo(), dto.getNivelDirectivo());
		return e;
	}
	
	/**
     * Convierte una lista de {@code DirectorMedico} a una lista de {@code DirectorMedicoDTO}.
     * 
     * @param eList la lista de objetos {@code DirectorMedico}.
     * @return una lista de objetos {@code DirectorMedicoDTO} con los mismos datos.
     */
	public static ArrayList<DirectorMedicoDTO> listaDirectorMedicoToListaDirectorMedicoDTO(ArrayList<DirectorMedico> eList){
		ArrayList<DirectorMedicoDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (DirectorMedico d : eList) {
				dtoList.add(new DirectorMedicoDTO(d.getNombre(), d.getFechaNacimiento(), d.getGenero(), d.getId(), d.getCorreo(), d.getNivelDirectivo()));
			}
		}	
		return dtoList;
	}
	
	/**
     * Convierte una lista de {@code DirectorMedicoDTO} a una lista de {@code DirectorMedicoDTO}.
     * 
     * @param dtoList la lista de objetos {@code DirectorMedicoDTO}.
     * @return una lista de objetos {@code DirectorMedico} con los mismos datos.
     */
	public static ArrayList<DirectorMedico> listaDirectorMedicoDTOToListaDirectorMedico(ArrayList<DirectorMedicoDTO> dtoList){
		ArrayList<DirectorMedico> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (DirectorMedicoDTO d : dtoList) {
				eList.add(new DirectorMedico(d.getNombre(), d.getFechaNacimiento(), d.getGenero(), d.getId(), d.getCorreo(), d.getNivelDirectivo()));
			}
		}
		return eList;
	}

	
	//Cita
	/**
     * Convierte un objeto {@code Cita} a un objeto {@code CitaDTO}.
     * 
     * @param e el objeto {@code Cita} que se va a convertir.
     * @return un nuevo objeto {@code CitaDTO} con los mismos datos.
     */
	public static Cita citaDTOToCita(CitaDTO dto) {
		Cita e;
		e = new Cita(dto.getEspecialista(), dto.getPaciente(), dto.getFecha(), dto.getHora(), dto.getNumeroCita(), dto.getEstado());
		return e;
	}
	
	/**
     * Convierte un objeto {@code CitaDTO} a un objeto {@code CitaDTO}.
     * 
     * @param dto el objeto {@code CitaDTO} que se va a convertir.
     * @return un nuevo objeto {@code Cita} con los mismos datos.
     */
	public static CitaDTO citaToCitaDTO(Cita e) {
		CitaDTO dto;
		dto = new CitaDTO(e.getEspecialista(), e.getPaciente(), e.getFecha(), e.getHora(), e.getNumeroCita(), e.getEstado());
		return dto;
	}
	
	/**
     * Convierte una lista de {@code CitaDTO} a una lista de {@code Cita}.
     * 
     * @param eList la lista de objetos {@code Cita}.
     * @return una lista de objetos {@code CitaDTO} con los mismos datos.
     */
	public static ArrayList<Cita> listaCitaDTOToListaCita(ArrayList<CitaDTO> dtoList){
		ArrayList<Cita> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (CitaDTO c : dtoList) {
				eList.add(new Cita(c.getEspecialista(), c.getPaciente(), c.getFecha(), c.getHora(), c.getNumeroCita(), c.getEstado()));
			}
		}
		return eList;
	}
	
	/**
     * Convierte una lista de {@code Cita} a una lista de {@code CitaDTO}.
     * 
     * @param eList la lista de objetos {@code Cita}.
     * @return una lista de objetos {@code CitaDTO} con los mismos datos.
     */

	public static ArrayList<CitaDTO> listaCitaToListaCitaDTO(ArrayList<Cita> eList){
		ArrayList<CitaDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (Cita c : eList) {
				dtoList.add(new CitaDTO(c.getEspecialista(), c.getPaciente(), c.getFecha(), c.getHora(), c.getNumeroCita(), c.getEstado()));
			}			
		}
		return dtoList;
	}
	
	//Turno
	/**
     * Convierte un objeto {@code TurnoDTO} a un objeto {@code Turno}.
     * 
     * @param dto el objeto {@code TurnoDTO} que se va a convertir.
     * @return un nuevo objeto {@code Turno} con los mismos datos.
     */
	public static Turno turnoDTOToTurno(TurnoDTO dto) {
		Turno e;
		e = new Turno(dto.getEspecialista(), dto.getFecha(), dto.getNumId());
		return e;
	}
	
	/**
     * Convierte un objeto {@code Turno} a un objeto {@code TurnoDTO}.
     * 
     * @param e el objeto {@code Turno} que se va a convertir.
     * @return un nuevo objeto {@code TurnoDTO} con los mismos datos.
     */
	public static TurnoDTO turnoToTurnoDTO(Turno e) {
		TurnoDTO dto;
		dto = new TurnoDTO(e.getEspecialista(), e.getFecha(), e.getNumId());
		return dto;
	}
	
	/**
     * Convierte una lista de {@code TurnoDTO} a una lista de {@code Turno}.
     * 
     * @param dtoList la lista de objetos {@code TurnoDTO}.
     * @return una lista de objetos {@code Turno} con los mismos datos.
     */
	public static ArrayList<Turno> listaTurnoDTOToListaTurno(ArrayList<TurnoDTO> dtoList){
		ArrayList<Turno> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (TurnoDTO t : dtoList) {
				eList.add(new Turno(t.getEspecialista(), t.getFecha(), t.getNumId()));
			}
		}	
		return eList;
	}
	
	/**
     * Convierte una lista de {@code Turno} a una lista de {@code TurnoDTO}.
     * 
     * @param eList la lista de objetos {@code Turno}.
     * @return una lista de objetos {@code TurnoDTO} con los mismos datos.
     */
	public static ArrayList<TurnoDTO> listaTurnoToListaTurnoDTO(ArrayList<Turno> eList){
		ArrayList<TurnoDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (Turno t : eList) {
				dtoList.add(new TurnoDTO(t.getEspecialista(), t.getFecha(), t.getNumId()));
			}
		}	
		return dtoList;
	}
	
	
	//Tratamiento medico
	/**
     * Convierte un objeto {@code TratamientoMedicoDTO} a un objeto {@code TratamientoMedico}.
     * 
     * @param dto el objeto {@code TratamientoMedicoDTO} que se va a convertir.
     * @return un nuevo objeto {@code TratamientoMedico} con los mismos datos.
     */
	public static TratamientoMedico tratamientoMedicoDTOToTratamientoMedico(TratamientoMedicoDTO dto) {
		TratamientoMedico e;
		e = new TratamientoMedico(dto.getPaciente(),dto.getEspecialista(), dto.getFecha(), dto.getTratamiento(), dto.getExamen(), dto.getDiagnostico()) ;
		return e;
	}
	
	/**
     * Convierte un objeto {@code TratamientoMedico} a un objeto {@code TratamientoMedicoDTO}.
     * 
     * @param e el objeto {@code TratamientoMedico} que se va a convertir.
     * @return un nuevo objeto {@code TratamientoMedicoDTO} con los mismos datos.
     */
	public static TratamientoMedicoDTO tratamientoMedicoToTratamientoMedicoDTO(TratamientoMedico e) {
		TratamientoMedicoDTO dto;
		dto = new TratamientoMedicoDTO(e.getPaciente(), e.getEspecialista(), e.getFecha(), e.getTratamiento(), e.getExamen(), e.getExamen());
		return dto;
	}
	
	/**
     * Convierte una lista de {@code TratamientoMedicoDTO} a una lista de {@code TratamientoMedico}.
     * 
     * @param dtoList la lista de objetos {@code TratamientoMedicoDTO}.
     * @return una lista de objetos {@code TratamientoMedico} con los mismos datos.
     */
	public static ArrayList<TratamientoMedico> listaTratamientoMedicoDTOToListaTratamientoMedico(ArrayList<TratamientoMedicoDTO> dtoList){
		ArrayList<TratamientoMedico> eList = new ArrayList<>();
		if (dtoList!=null) {
			for (TratamientoMedicoDTO t : dtoList) {
				eList.add(new TratamientoMedico(t.getPaciente(), t.getEspecialista(), t.getFecha(), t.getTratamiento(), t.getExamen(), t.getExamen()));
			}
		}
		return eList;
	}
	
	/**
     * Convierte una lista de {@code TratamientoMedico} a una lista de {@code TratamientoMedicoDTO}.
     * 
     * @param eList la lista de objetos {@code TratamientoMedico}.
     * @return una lista de objetos {@code TratamientoMedicoDTO} con los mismos datos.
     */
	public static ArrayList<TratamientoMedicoDTO> listaTratamientoMedicoToListaTratamientoMedicoDTO(ArrayList<TratamientoMedico> eList){
		ArrayList<TratamientoMedicoDTO> dtoList = new ArrayList<>();
		if (eList!=null) {
			for (TratamientoMedico t : eList) {
				dtoList.add(new TratamientoMedicoDTO(t.getPaciente(), t.getEspecialista(), t.getFecha(), t.getTratamiento(), t.getExamen(), t.getExamen()));
			}
		}
		return dtoList;
	}
}
