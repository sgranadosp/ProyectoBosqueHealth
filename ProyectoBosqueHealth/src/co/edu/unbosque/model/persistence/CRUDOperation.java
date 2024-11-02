package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<E, D> { // D --> DTO. E --> ENTIDAD

	public String showAll();

	public ArrayList<D> getAll(); // Mostrar todo como DTO

	public boolean add(D newData); // Verificar que no hay duplicados

	public boolean delete(D toDelete);

	public E find(E toFind);

	public boolean update(D previous, D newData);

}
