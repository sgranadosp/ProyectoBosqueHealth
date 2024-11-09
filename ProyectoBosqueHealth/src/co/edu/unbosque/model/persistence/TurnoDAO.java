package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Turno;
import co.edu.unbosque.model.TurnoDTO;

/**
 * La clase `TurnoDAO` implementa las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre los turnos médicos en un sistema. Esta clase gestiona una lista de turnos médicos
 * que se pueden persistir tanto en archivos serializados.
 * 
 * <p>Esta clase permite realizar operaciones de manejo de turnos, como agregar, eliminar,
 * buscar, actualizar y mostrar los turnos médicos registrados.</p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class TurnoDAO implements CRUDOperation<Turno, TurnoDTO>{

	/**
     * Lista que almacena los turnos médicos cargados desde el archivo de persistencia.
     */
    private ArrayList<Turno> listaTurnos;

    /**
     * Nombre del archivo serializado donde se guardan los turnos médicos en formato binario.
     */
    private final String SERIALIZED_NAME = "turnos.dat";

    /**
     * Constructor de la clase. Inicializa las carpetas necesarias y carga los datos de turnos
     * médicos desde el archivo serializado.
     */
	public TurnoDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	/**
     * Muestra todos los turnos médicos en formato de texto.
     * 
     * @return Una cadena que contiene todos los turnos médicos en formato legible, o un mensaje
     *         si no hay turnos para mostrar.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaTurnos.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Turno turno : listaTurnos) {
				rta += turno + "\n";

			}
			return rta;
		}
	}

	 /**
     * Obtiene todos los turnos médicos como una lista de objetos `TurnoDTO`.
     * 
     * @return Una lista de objetos `TurnoDTO` que representan los turnos médicos.
     */
	@Override
	public ArrayList<TurnoDTO> getAll() {
		return DataMapper.listaTurnoToListaTurnoDTO(listaTurnos);
	}

	/**
     * Agrega un nuevo turno médico al sistema.
     * 
     * @param newData El objeto `TurnoDTO` que contiene los datos del turno médico a agregar.
     * @return `true` si el turno médico fue agregado correctamente, o `false` si ya existe un turno igual.
     */
	@Override
	public boolean add(TurnoDTO newData) {
		if (find(DataMapper.turnoDTOToTurno(newData)) == null) {
			listaTurnos.add(DataMapper.turnoDTOToTurno(newData));
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	/**
     * Elimina un turno médico del sistema.
     * 
     * @param toDelete El objeto `TurnoDTO` que contiene los datos del turno médico a eliminar.
     * @return `true` si el turno médico fue eliminado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean delete(TurnoDTO toDelete) {
		Turno found = find(DataMapper.turnoDTOToTurno(toDelete));
		if (found != null) {
			listaTurnos.remove(found);
			return true;
		} else {
			return false;
		}
	}

	/**
     * Busca un turno médico en la lista de turnos médicos.
     * 
     * @param toFind El objeto `Turno` que contiene los datos del turno médico a buscar.
     * @return El turno médico encontrado, o `null` si no se encuentra.
     */
	@Override
	public Turno find(Turno toFind) {
		Turno found = null;
		if (!listaTurnos.isEmpty()) {
			for (Turno turno : listaTurnos) {
				if (turno.getFecha().equals(toFind.getFecha())) {
					found = turno;
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
     * Actualiza los datos de un turno médico en el sistema.
     * 
     * @param previous El objeto `TurnoDTO` con los datos del turno médico a actualizar.
     * @param newData El objeto `TurnoDTO` con los nuevos datos del turno médico.
     * @return `true` si el turno médico fue actualizado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean update(TurnoDTO previous, TurnoDTO newData) {
		Turno found = find(DataMapper.turnoDTOToTurno(previous));

		if (found != null) {
			listaTurnos.remove(found);
			listaTurnos.add(DataMapper.turnoDTOToTurno(newData));
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	/**
     * Escribe los datos de los turnos médicos en el archivo serializado.
     */
	public void writeSerialized() {
		
		FileHandler.writeSerialized(SERIALIZED_NAME, listaTurnos);
	}
	
	/**
     * Lee los datos de los turnos médicos desde el archivo serializado.
     */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaTurnos = new ArrayList<>();
		} else {
			listaTurnos = (ArrayList<Turno>) content;
		}
	}
	
}
