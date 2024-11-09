package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;

/**
 * La clase `PacienteDAO` implementa las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre los pacientes en un sistema. Esta clase maneja una lista de pacientes que puede
 * ser persistida tanto en archivos de texto CSV como en archivos serializados. Utiliza el
 * patrón Data Mapper para convertir entre los objetos de dominio (`Paciente`) y los
 * objetos de transferencia de datos (`PacienteDTO`).
 * 
 * <p>Se encarga de leer y escribir los datos de los pacientes en el archivo CSV y el archivo
 * serializado correspondiente, y ofrece una interfaz para gestionar pacientes.</p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class PacienteDAO implements CRUDOperation<Paciente, PacienteDTO>{

	/**
     * Lista que almacena los pacientes cargados desde los archivos de persistencia.
     */
    private ArrayList<Paciente> listaPacientes;

    /**
     * Nombre del archivo CSV donde se guardan los pacientes en formato de texto.
     */
    private final String FILE_NAME = "pacientes.csv";

    /**
     * Nombre del archivo serializado donde se guardan los pacientes en formato binario.
     */
    private final String SERIALIZED_NAME = "pacientes.dat";

    /**
     * Constructor de la clase. Inicializa las carpetas necesarias y carga los datos de pacientes
     * desde el archivo serializado.
     */
	public PacienteDAO() {
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
	 /**
     * Muestra todos los pacientes en formato de texto.
     * 
     * @return Una cadena que contiene todos los pacientes en formato legible, o un mensaje
     *         si no hay pacientes para mostrar.
     */
	@Override
	public String showAll() {
		String rta = "";

		if (listaPacientes.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Paciente paciente : listaPacientes) {
				rta += paciente + "\n";

			}
			return rta;
		}
	}

	/**
     * Obtiene todos los pacientes como una lista de objetos `PacienteDTO`.
     * 
     * @return Una lista de objetos `PacienteDTO` que representan los pacientes.
     */
	@Override
	public ArrayList<PacienteDTO> getAll() {
		return DataMapper.listaPacienteToListaPacienteDTO(listaPacientes);
	}

	/**
     * Agrega un nuevo paciente al sistema.
     * 
     * @param newData El objeto `PacienteDTO` que contiene los datos del paciente a agregar.
     * @return true si el paciente fue agregado correctamente, o false si el paciente ya existe.
     */
	@Override
	public boolean add(PacienteDTO newData) {
		if (find(DataMapper.pacienteDTOToPaciente(newData)) == null) {
			listaPacientes.add(DataMapper.pacienteDTOToPaciente(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
     * Elimina un paciente del sistema.
     * 
     * @param toDelete El objeto `PacienteDTO` que contiene los datos del paciente a eliminar.
     * @return `true` si el paciente fue eliminado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean delete(PacienteDTO toDelete) {
		Paciente found = find(DataMapper.pacienteDTOToPaciente(toDelete));
		if (found != null) {
			listaPacientes.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	 /**
     * Busca un paciente en la lista de pacientes.
     * 
     * @param toFind El objeto `Paciente` que contiene los datos del paciente a buscar.
     * @return El paciente encontrado, o `null` si no se encuentra.
     */
	@Override
	public Paciente find(Paciente toFind) {
		Paciente found = null;
		if (listaPacientes!=null) {
			if (!listaPacientes.isEmpty()) {
				for (Paciente paciente : listaPacientes) {
					if (paciente.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
						found = paciente;
						return found;
					} else {
						continue;
					}
				}
			} else {
				return null;
			}
		}
		return null;
	}

	 /**
     * Actualiza los datos de un paciente en el sistema.
     * 
     * @param previous El objeto `PacienteDTO` con los datos del paciente a actualizar.
     * @param newData El objeto `PacienteDTO` con los nuevos datos del paciente.
     * @return `true` si el paciente fue actualizado correctamente, o `false` si no se encuentra.
     */
	@Override
	public boolean update(PacienteDTO previous, PacienteDTO newData) {
		Paciente found = find(DataMapper.pacienteDTOToPaciente(previous));

		if (found != null) {
			listaPacientes.remove(found);
			listaPacientes.add(DataMapper.pacienteDTOToPaciente(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}
	
	/**
     * Escribe los datos de los pacientes en el archivo CSV.
     */
	public void writeFile() {
		String content = "";
		for (Paciente paciente : listaPacientes) {
			content += paciente.getNombre() + ";";
			content += paciente.getFechaNacimiento() + ";";
			content += paciente.getGenero() + ";";
			content += paciente.getId() + ";";
			content += paciente.getCorreo() + ";";
			content += paciente.getTratamiento() + ";";
			content += "\n";

		}
		FileHandler.writeFile(FILE_NAME, content);
	}
	
	 /**
     * Lee los datos de los pacientes desde el archivo CSV.
     */
	public void readFile() {
		
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) // si no hay datos o si el archivo se acaba de crear
		{
			listaPacientes = new ArrayList<>();
		} else {
			listaPacientes = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				
				String[] cols = row.split(";");
				Paciente temp = new Paciente();
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
				temp.setTratamiento(cols[5]);
				
				listaPacientes.add(temp);
			}
		}
	}
	
	/**
     * Escribe los datos de los pacientes en el archivo serializado.
     */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaPacientes);
	}
	
	 /**
     * Lee los datos de los pacientes desde el archivo serializado.
     */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIALIZED_NAME);
		if (content == null) {
			listaPacientes = new ArrayList<>();
		} else {
			listaPacientes = (ArrayList<Paciente>) content;
		}
	}
}
