package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.TratamientoMedico;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.model.Turno;

/**
 * La clase `TratamientoMedicoDAO` implementa las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre los tratamientos médicos en un sistema. Esta clase maneja una lista de tratamientos médicos
 * que puede ser persistida tanto en archivos de texto CSV como en archivos serializados.
 * 
 * <p>Se encarga de leer y escribir los datos de los tratamientos médicos en el archivo CSV y el archivo
 * serializado correspondiente, y ofrece una interfaz para gestionar tratamientos médicos.</p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class TratamientoMedicoDAO implements CRUDOperation<TratamientoMedico, TratamientoMedicoDTO>{
	/**
     * Lista que almacena los tratamientos médicos cargados desde los archivos de persistencia.
     */
    private ArrayList<TratamientoMedico> listaTratamientosMedicos;

    /**
     * Nombre del archivo CSV donde se guardan los tratamientos médicos en formato de texto.
     */
    private final String FILE_NAME = "tratamientosMedicos.csv";

    /**
     * Nombre del archivo serializado donde se guardan los tratamientos médicos en formato binario.
     */
    private final String SERIALIZED_NAME = "tratamientosMedicos.dat";

    /**
     * Constructor de la clase. Inicializa las carpetas necesarias y carga los datos de tratamientos
     * médicos desde el archivo serializado.
     */
	public TratamientoMedicoDAO() {
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	/**
     * Muestra todos los tratamientos médicos en formato de texto.
     * 
     * @return Una cadena que contiene todos los tratamientos médicos en formato legible, o un mensaje
     *         si no hay tratamientos para mostrar.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaTratamientosMedicos.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (TratamientoMedico tratamientoMedico : listaTratamientosMedicos) {
				rta += tratamientoMedico + "\n";

			}
			return rta;
		}
	}

	 /**
     * Obtiene todos los tratamientos médicos como una lista de objetos `TratamientoMedicoDTO`.
     * 
     * @return Una lista de objetos `TratamientoMedicoDTO` que representan los tratamientos médicos.
     */
	@Override
	public ArrayList<TratamientoMedicoDTO> getAll() {
		return DataMapper.listaTratamientoMedicoToListaTratamientoMedicoDTO(listaTratamientosMedicos);
	}

	 /**
     * Agrega un nuevo tratamiento médico al sistema.
     * 
     * @param newData El objeto `TratamientoMedicoDTO` que contiene los datos del tratamiento médico a agregar.
     * @return `true` si el tratamiento médico fue agregado correctamente, o `false` si ya existe un tratamiento igual.
     */
	@Override
	public boolean add(TratamientoMedicoDTO newData) {
		if (find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) == null) {
			listaTratamientosMedicos.add(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData));
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	 /**
     * Elimina un tratamiento médico del sistema.
     * 
     * @param toDelete El objeto `TratamientoMedicoDTO` que contiene los datos del tratamiento médico a eliminar.
     * @return `true` si el tratamiento médico fue eliminado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean delete(TratamientoMedicoDTO toDelete) {
		TratamientoMedico found = find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(toDelete));
		if (found != null) {
			listaTratamientosMedicos.remove(found);
			return true;
		} else {
			return false;
		}
	}

	/**
     * Busca un tratamiento médico en la lista de tratamientos médicos.
     * 
     * @param toFind El objeto `TratamientoMedico` que contiene los datos del tratamiento médico a buscar.
     * @return El tratamiento médico encontrado, o `null` si no se encuentra.
     */
	@Override
	public TratamientoMedico find(TratamientoMedico toFind) {
		TratamientoMedico found = null;
		if (!listaTratamientosMedicos.isEmpty()) {
			for (TratamientoMedico tratamiento : listaTratamientosMedicos) {
				if (tratamiento.getEspecialista().equals(toFind.getEspecialista())) {
					if(tratamiento.getPaciente().equals(toFind.getPaciente())) {
						found = tratamiento;
						return found;
					}else {
						continue;
					}
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
     * Actualiza los datos de un tratamiento médico en el sistema.
     * 
     * @param previous El objeto `TratamientoMedicoDTO` con los datos del tratamiento médico a actualizar.
     * @param newData El objeto `TratamientoMedicoDTO` con los nuevos datos del tratamiento médico.
     * @return `true` si el tratamiento médico fue actualizado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean update(TratamientoMedicoDTO previous, TratamientoMedicoDTO newData) {
		TratamientoMedico found = find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(previous));

		if (found != null) {
			listaTratamientosMedicos.remove(found);
			listaTratamientosMedicos.add(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData));
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	 /**
     * Escribe los datos de los tratamientos médicos en el archivo serializado.
     */
	public void writeSerialized() {
		
		FileHandler.writeSerialized(SERIALIZED_NAME, listaTratamientosMedicos);
	}
	
	 /**
     * Lee los datos de los tratamientos médicos desde el archivo serializado.
     */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaTratamientosMedicos = new ArrayList<>();
		} else {
			listaTratamientosMedicos = (ArrayList<TratamientoMedico>) content;
		}
	}
	
}
