package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cita;
import co.edu.unbosque.model.CitaDTO;


public class CitaDAO implements CRUDOperation<Cita, CitaDTO>{

	private ArrayList<Cita> listaCitas;
	private final String SERIALIZED_NAME = "citas.dat";
	
	public CitaDAO() {
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
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

	@Override
	public ArrayList<CitaDTO> getAll() {
		return DataMapper.listaCitaToListaCitaDTO(listaCitas);
	}

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
	
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIALIZED_NAME, listaCitas);
	}
	
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
