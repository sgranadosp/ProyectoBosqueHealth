package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.EspecialistaDTO;


public class EspecialistaDAO implements CRUDOperation<Especialista, EspecialistaDTO>{

	private ArrayList<Especialista> listaEspecialistas;
	private final String FILE_NAME = "Especialistas.csv";
	private final String SERIALIZED_NAME = "Especialistas.bat";
	
	public EspecialistaDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
	}
	
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

	@Override
	public ArrayList<EspecialistaDTO> getAll() {
		return DataMapper.listaEspecialistaToListaEspecialistaDTO(listaEspecialistas);
	}

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
	
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaEspecialistas);
	}
	
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
