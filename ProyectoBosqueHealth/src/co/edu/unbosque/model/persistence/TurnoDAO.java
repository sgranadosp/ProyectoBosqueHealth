package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Turno;
import co.edu.unbosque.model.TurnoDTO;

public class TurnoDAO implements CRUDOperation<Turno, TurnoDTO>{

	private ArrayList<Turno> listaTurnos;
	private final String SERIALIZED_NAME = "turnos.bat";
	
	public TurnoDAO() {
		
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
	}
	
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

	@Override
	public ArrayList<TurnoDTO> getAll() {
		return DataMapper.listaTurnoToListaTurnoDTO(listaTurnos);
	}

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

	@Override
	public Turno find(Turno toFind) {
		Turno found = null;
		if (!listaTurnos.isEmpty()) {
			for (Turno turno : listaTurnos) {
				if (turno.getNumId() == toFind.getNumId()) {
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
	
	public void writeSerialized() {
		
		FileHandler.writeSerialized(SERIALIZED_NAME, listaTurnos);
	}
	
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
