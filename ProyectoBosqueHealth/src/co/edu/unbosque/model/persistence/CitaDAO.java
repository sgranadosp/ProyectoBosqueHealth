package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cita;
import co.edu.unbosque.model.CitaDTO;

/**
 * La clase {@code CitaDAO} es una implementación del patrón DAO (Data Access Object)
 * para gestionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de citas médicas
 * utilizando archivos serializados para el almacenamiento persistente.
 * <p>
 * Esta clase implementa la interfaz {@code CRUDOperation} y permite manejar objetos 
 * de tipo {@code Cita} y su correspondiente DTO ({@code CitaDTO}).
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class CitaDAO implements CRUDOperation<Cita, CitaDTO>{

	/** Lista que contiene todas las citas registradas */
    private ArrayList<Cita> listaCitas;

    /** Nombre del archivo serializado donde se guardan las citas */
    private final String SERIALIZED_NAME = "citas.dat";

    /**
     * Constructor que inicializa el DAO. Verifica la existencia de carpetas y archivos necesarios
     * para la serialización y lee los datos previamente almacenados.
     */
	public CitaDAO() {
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	 /**
     * Muestra todas las citas almacenadas en la lista.
     * 
     * @return una cadena que contiene todas las citas o un mensaje indicando que no hay datos.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaCitas.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Cita cita : listaCitas) {
				rta += cita + "\n";

			}
			return rta;
		}
	}

	/**
     * Obtiene una lista de todas las citas en formato DTO.
     * 
     * @return una lista de objetos {@code CitaDTO}.
     */
	@Override
	public ArrayList<CitaDTO> getAll() {
		return DataMapper.listaCitaToListaCitaDTO(listaCitas);
	}

	 /**
     * Añade una nueva cita utilizando el DTO proporcionado.
     * 
     * @param newData el objeto {@code CitaDTO} que se va a añadir.
     * @return {@code true} si la cita fue añadida exitosamente, {@code false} si ya existía.
     */
	@Override
	public boolean add(CitaDTO newData) {
		if (find(DataMapper.citaDTOToCita(newData)) == null) {
			listaCitas.add(DataMapper.citaDTOToCita(newData));
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	 /**
     * Elimina una cita utilizando el DTO proporcionado.
     * 
     * @param toDelete el objeto {@code CitaDTO} que se va a eliminar.
     * @return {@code true} si la cita fue eliminada exitosamente, {@code false} si no fue encontrada.
     */
	@Override
	public boolean delete(CitaDTO toDelete) {
		Cita found = find(DataMapper.citaDTOToCita(toDelete));
		if (found != null) {
			listaCitas.remove(found);
			return true;
		} else {
			return false;
		}
	}

	 /**
     * Busca una cita en la lista utilizando un objeto {@code Cita}.
     * 
     * @param toFind la cita a buscar.
     * @return el objeto {@code Cita} encontrado, o {@code null} si no existe.
     */
	@Override
	public Cita find(Cita toFind) {
		Cita found = null;
		if (!listaCitas.isEmpty()) {
			for (Cita cita : listaCitas) {
				if (cita.getNumeroCita() == toFind.getNumeroCita()) {
					found = cita;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	 /**
     * Actualiza una cita existente con nuevos datos proporcionados en el DTO.
     * 
     * @param previous el objeto {@code CitaDTO} que se va a actualizar.
     * @param newData  el nuevo objeto {@code CitaDTO} con los datos actualizados.
     * @return {@code true} si la cita fue actualizada exitosamente, {@code false} si no fue encontrada.
     */
	@Override
	public boolean update(CitaDTO previous, CitaDTO newData) {
		Cita found = find(DataMapper.citaDTOToCita(previous));

		if (found != null) {
			listaCitas.remove(found);
			listaCitas.add(DataMapper.citaDTOToCita(newData));
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	/**
     * Serializa y guarda la lista de citas en un archivo.
     */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaCitas);
	}
	
	 /**
     * Lee el archivo serializado y carga la lista de citas.
     * Si el archivo no existe, inicializa una lista vacía.
     */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaCitas = new ArrayList<>();
		} else {
			listaCitas = (ArrayList<Cita>) content;
		}
	}

}
