package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.DirectorMedico;
import co.edu.unbosque.model.DirectorMedicoDTO;

/**
 * La clase DirectorMedicoDAO gestiona las operaciones CRUD para los objetos
 * de tipo {@link DirectorMedico}. Permite añadir, buscar, actualizar y eliminar
 * directores médicos, así como guardar y cargar información desde archivos.
 * 
 * <p>Implementa la interfaz {@link CRUDOperation} para proporcionar
 * las operaciones básicas.</p>
 * 
 * <p>Los datos pueden ser guardados en un archivo CSV o serializados en un archivo binario.</p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class DirectorMedicoDAO implements CRUDOperation<DirectorMedico, DirectorMedicoDTO>{

	/** Lista que contiene los directores medicos registrados */
	private ArrayList<DirectorMedico> listaDirectorMedicos;
	/** Nombre del archivo plano donde se guardan los datos de director medico */
	private final String FILE_NAME = "DirectorMedico.csv";
	/** Nombre del archivo serializado donde se guardan los datos de director medico */
	private final String SERIALIZED_NAME = "DirectorMedico.dat";
	
	/**
     * Constructor de la clase. Verifica la existencia de las carpetas necesarias y
     * carga los datos previamente serializados.
     */
	public DirectorMedicoDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	/**
     * Muestra todos los directores médicos almacenados.
     * 
     * @return Una cadena con los detalles de todos los directores médicos,
     * o un mensaje indicando que no hay datos disponibles.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaDirectorMedicos.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (DirectorMedico DirectorMedico : listaDirectorMedicos) {
				rta += DirectorMedico + "\n";

			}
			return rta;
		}
	}

	 /**
     * Obtiene todos los directores médicos en formato de lista DTO.
     * 
     * @return Lista de {@link DirectorMedicoDTO}.
     */
	@Override
	public ArrayList<DirectorMedicoDTO> getAll() {
		return DataMapper.listaDirectorMedicoToListaDirectorMedicoDTO(listaDirectorMedicos);
	}

	/**
     * Añade un nuevo director médico si no existe ya en la lista.
     * 
     * @param newData El director médico a añadir en formato {@link DirectorMedicoDTO}.
     * @return true si el director fue añadido exitosamente, false si ya existía.
     */
	@Override
	public boolean add(DirectorMedicoDTO newData) {
		if (find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) == null) {
			listaDirectorMedicos.add(DataMapper.directorMedicolistaDTOToDirectorMedico(newData));
			writeFile();
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	 /**
     * Elimina un director médico existente.
     * 
     * @param toDelete El director médico a eliminar en formato {@link DirectorMedicoDTO}.
     * @return true si se eliminó exitosamente, false si no se encontró.
     */
	@Override
	public boolean delete(DirectorMedicoDTO toDelete) {
		DirectorMedico found = find(DataMapper.directorMedicolistaDTOToDirectorMedico(toDelete));
		if (found != null) {
			listaDirectorMedicos.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
     * Busca un director médico por nombre.
     * 
     * @param toFind El director médico a buscar.
     * @return El objeto {@link DirectorMedico} encontrado, o null si no existe.
     */
	@Override
	public DirectorMedico find(DirectorMedico toFind) {
		DirectorMedico found = null;
		if (!listaDirectorMedicos.isEmpty()) {
			for (DirectorMedico DirectorMedico : listaDirectorMedicos) {
				if (DirectorMedico.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = DirectorMedico;
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
     * Actualiza la información de un director médico existente.
     * 
     * @param previous El director médico a actualizar en formato {@link DirectorMedicoDTO}.
     * @param newData Los nuevos datos para el director en formato {@link DirectorMedicoDTO}.
     * @return true si se actualizó exitosamente, false si no se encontró.
     */
	@Override
	public boolean update(DirectorMedicoDTO previous, DirectorMedicoDTO newData) {
		DirectorMedico found = find(DataMapper.directorMedicolistaDTOToDirectorMedico(previous));

		if (found != null) {
			listaDirectorMedicos.remove(found);
			listaDirectorMedicos.add(DataMapper.directorMedicolistaDTOToDirectorMedico(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	/**
     * Guarda la lista de directores médicos en un archivo CSV.
     */
	public void writeFile() {
		String content = "";
		for (DirectorMedico DirectorMedico : listaDirectorMedicos) {
			content += DirectorMedico.getNombre() + ";";
			content += DirectorMedico.getFechaNacimiento() + ";";
			content += DirectorMedico.getGenero() + ";";
			content += DirectorMedico.getId() + ";";
			content += DirectorMedico.getCorreo() + ";";
			content += DirectorMedico.getNivelDirectivo() + ";";
			content += "\n";

		}
		FileHandler.writeFile(FILE_NAME, content);
	}
	
	/**
     * Serializa y guarda la lista de directores médicos en un archivo binario.
     */
	public void readFile() {
		
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) // si no hay datos o si el archivo se acaba de crear
		{
			listaDirectorMedicos = new ArrayList<>();
		} else {
			listaDirectorMedicos = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				
				String[] cols = row.split(";");
				DirectorMedico temp = new DirectorMedico();
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
				temp.setNivelDirectivo(cols[5]);
				
				listaDirectorMedicos.add(temp);
			}
		}
	}
	
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaDirectorMedicos);
	}
	
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaDirectorMedicos = new ArrayList<>();
		} else {
			listaDirectorMedicos = (ArrayList<DirectorMedico>) content;
		}
	}
}
