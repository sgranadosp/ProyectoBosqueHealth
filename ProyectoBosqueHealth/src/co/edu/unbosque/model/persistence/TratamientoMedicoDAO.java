package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.TratamientoMedico;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.model.Turno;

public class TratamientoMedicoDAO implements CRUDOperation<TratamientoMedico, TratamientoMedicoDTO>{

	private ArrayList<TratamientoMedico> listaTratamientosMedicos;
	private final String FILE_NAME = "tratamientosMedicos.csv";
	private final String SERIALIZED_NAME = "tratamientosMedicos.dat";
	
	public TratamientoMedicoDAO() {
		FileHandler.checkFolder();
		FileHandler.checkPropertiesFolder();
		readSerialized();
	}
	
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

	@Override
	public ArrayList<TratamientoMedicoDTO> getAll() {
		return DataMapper.listaTratamientoMedicoToListaTratamientoMedicoDTO(listaTratamientosMedicos);
	}

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
	
	public void writeSerialized() {
		
		FileHandler.writeSerialized(SERIALIZED_NAME, listaTratamientosMedicos);
	}
	
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
