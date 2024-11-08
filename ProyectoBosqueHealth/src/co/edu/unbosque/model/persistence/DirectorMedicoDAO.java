package co.edu.unbosque.model.persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.DirectorMedico;
import co.edu.unbosque.model.DirectorMedicoDTO;


public class DirectorMedicoDAO implements CRUDOperation<DirectorMedico, DirectorMedicoDTO>{

	private ArrayList<DirectorMedico> listaDirectorMedicos;
	private final String FILE_NAME = "DirectorMedico.csv";
	private final String SERIALIZED_NAME = "DirectorMedico.dat";
	
	public DirectorMedicoDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
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

	@Override
	public ArrayList<DirectorMedicoDTO> getAll() {
		return DataMapper.listaDirectorMedicoToListaDirectorMedicoDTO(listaDirectorMedicos);
	}

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
