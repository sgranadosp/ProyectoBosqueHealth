package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;


public class PacienteDAO implements CRUDOperation<Paciente, PacienteDTO>{

	private ArrayList<Paciente> listaPacientes;
	private final String FILE_NAME = "pacientes.csv";
	private final String SERIALIZED_NAME = "pacientes.bat";
	
	public PacienteDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
	}
	
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

	@Override
	public ArrayList<PacienteDTO> getAll() {
		return DataMapper.listaPacienteToListaPacienteDTO(listaPacientes);
	}

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

	@Override
	public boolean delete(PacienteDTO toDelete) {
		Paciente found = find(DataMapper.pacienteDTOToPaciente(toDelete));
		if (found != null) {
			listaPacientes.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Paciente find(Paciente toFind) {
		Paciente found = null;
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
		return null;
	}

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
	
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaPacientes);
	}
	
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
