package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.EspecialistaDTO;

/**
 * La clase EspecialistaDAO gestiona las operaciones CRUD para los objetos de tipo
 * {@link Especialista}. Permite añadir, buscar, actualizar y eliminar especialistas,
 * así como guardar y cargar información desde archivos CSV y binarios.
 * 
 * <p>Implementa la interfaz {@link CRUDOperation} para proporcionar
 * las operaciones básicas.</p>
 * 
 * <p>Los datos pueden ser almacenados en un archivo CSV o serializados en un archivo binario.</p>
 * 
 *@author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class EspecialistaDAO implements CRUDOperation<Especialista, EspecialistaDTO>{

	/**
	 * Lista que contiene todos los especialistas registrados.
	 */
	private ArrayList<Especialista> listaEspecialistas;
	/** Nombre del archivo plano donde se guardan los datos de los especialistas */
	private final String FILE_NAME = "Especialistas.csv";
	/** Nombre del archivo serializado donde se guardan los datos de los especialistas */
	private final String SERIALIZED_NAME = "Especialistas.dat";

	/**
     * Constructor de la clase. Verifica la existencia de las carpetas necesarias y
     * carga los datos previamente serializados.
     */
	public EspecialistaDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	/**
     * Muestra todos los especialistas almacenados.
     * 
     * @return Una cadena con los detalles de todos los especialistas,
     * o un mensaje indicando que no hay datos disponibles.
     */  /**
     * Obtiene todos los especialistas en formato de lista DTO.
     * 
     * @return Lista de {@link EspecialistaDTO}.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaEspecialistas.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Especialista Especialista : listaEspecialistas) {
				rta += Especialista + "\n";

			}
			return rta;
		}
	}

	/**
     * Obtiene todos los especialistas en formato de lista DTO.
     * 
     * @return Lista de {@link EspecialistaDTO}.
     */
	@Override
	public ArrayList<EspecialistaDTO> getAll() {
		return DataMapper.listaEspecialistaToListaEspecialistaDTO(listaEspecialistas);
	}

	 /**
     * Añade un nuevo especialista si no existe ya en la lista.
     * 
     * @param newData El especialista a añadir en formato {@link EspecialistaDTO}.
     * @return true si el especialista fue añadido exitosamente, false si ya existía.
     */
	@Override
	public boolean add(EspecialistaDTO newData) {
		if (find(DataMapper.especialistaDTOToEspecialista(newData)) == null) {
			listaEspecialistas.add(DataMapper.especialistaDTOToEspecialista(newData));
			writeFile();
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	/**
     * Elimina un especialista existente.
     * 
     * @param toDelete El especialista a eliminar en formato {@link EspecialistaDTO}.
     * @return true si se eliminó exitosamente, false si no se encontró.
     */
	@Override
	public boolean delete(EspecialistaDTO toDelete) {
		Especialista found = find(DataMapper.especialistaDTOToEspecialista(toDelete));
		if (found != null) {
			listaEspecialistas.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
     * Busca un especialista por nombre.
     * 
     * @param toFind El especialista a buscar.
     * @return El objeto {@link Especialista} encontrado, o null si no existe.
     */
	@Override
	public Especialista find(Especialista toFind) {
		Especialista found = null;
		if (!listaEspecialistas.isEmpty()) {
			for (Especialista Especialista : listaEspecialistas) {
				if (Especialista.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = Especialista;
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
     * Actualiza la información de un especialista existente.
     * 
     * @param previous El especialista a actualizar en formato {@link EspecialistaDTO}.
     * @param newData Los nuevos datos para el especialista en formato {@link EspecialistaDTO}.
     * @return true si se actualizó exitosamente, false si no se encontró.
     */
	@Override
	public boolean update(EspecialistaDTO previous, EspecialistaDTO newData) {
		Especialista found = find(DataMapper.especialistaDTOToEspecialista(previous));

		if (found != null) {
			listaEspecialistas.remove(found);
			listaEspecialistas.add(DataMapper.especialistaDTOToEspecialista(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	/**
     * Guarda la lista de especialistas en un archivo CSV.
     */
	public void writeFile() {
		String content = "";
		for (Especialista Especialista : listaEspecialistas) {
			content += Especialista.getNombre() + ";";
			content += Especialista.getFechaNacimiento() + ";";
			content += Especialista.getGenero() + ";";
			content += Especialista.getId() + ";";
			content += Especialista.getCorreo() + ";";
			content += Especialista.getEspecialidad() + ";";
			content += "\n";

		}
		FileHandler.writeFile(FILE_NAME, content);
	}
	
	/**
	 * Lee los datos de un especialista en un archivo CSV.
	 */
	public void readFile() {
		
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) // si no hay datos o si el archivo se acaba de crear
		{
			listaEspecialistas = new ArrayList<>();
		} else {
			listaEspecialistas = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				
				String[] cols = row.split(";");
				Especialista temp = new Especialista();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;
				try {
					fecha = df.parse(cols[1]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				int id = Integer.parseInt(cols[3]);
				temp.setNombre(cols[0]);
				temp.setFechaNacimiento(fecha);
				temp.setGenero(cols[2]);
				temp.setId(id);
				temp.setCorreo(cols[4]);
				temp.setEspecialidad(cols[5]);
				
				listaEspecialistas.add(temp);
			}
		}
	}
	
	 /**
     * Serializa y guarda la lista de especialistas en un archivo binario.
     */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaEspecialistas);
		
	}
	
	/**
     * Lee los datos serializados desde un archivo.
     */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaEspecialistas = new ArrayList<>();
		} else {
			listaEspecialistas = (ArrayList<Especialista>) content;
		}
	}
}
