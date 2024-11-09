package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * La interfaz {@code CRUDOperation} define un conjunto de operaciones estándar 
 * para manipular datos en una base de datos o un sistema de almacenamiento.
 * <p>
 * Estas operaciones incluyen Crear, Leer, Actualizar y Eliminar (CRUD).
 * Esta interfaz utiliza tipos genéricos para trabajar tanto con entidades como con sus correspondientes DTOs 
 * (Data Transfer Objects).
 * </p>
 *
 * @param <E> el tipo de la entidad que se va a manipular (modelo principal).
 * @param <D> el tipo del Data Transfer Object (DTO) correspondiente a la entidad.
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public interface CRUDOperation<E, D> { // D --> DTO. E --> ENTIDAD

	/**
     * Devuelve todos los datos en un formato legible para propósitos de visualización.
     *
     * @return una cadena que contiene la representación de todos los registros, 
     * o un mensaje indicando que no hay datos disponibles.
     */
	public String showAll();

	 /**
     * Obtiene una lista de todos los registros almacenados en su forma de DTO.
     *
     * @return una lista de objetos {@code D} que representa todos los registros.
     */
	 public ArrayList<D> getAll();
	/**
     * Añade un nuevo registro basado en el objeto DTO proporcionado, asegurándose
     * de que no haya duplicados.
     *
     * @param newData el objeto {@code D} que se va a añadir.
     * @return {@code true} si el objeto fue añadido exitosamente, 
     * {@code false} si ya existe un duplicado.
     */
    public boolean add(D newData);

    /**
     * Elimina un registro existente basado en el objeto DTO proporcionado.
     *
     * @param toDelete el objeto {@code D} que se va a eliminar.
     * @return {@code true} si el registro fue eliminado exitosamente, 
     * {@code false} si no se encontró.
     */
    public boolean delete(D toDelete);

    /**
     * Busca un registro específico en función del objeto de entidad proporcionado.
     *
     * @param toFind el objeto {@code E} que se desea buscar.
     * @return el objeto encontrado de tipo {@code E}, o {@code null} si no se encuentra.
     */
    public E find(E toFind);

    /**
     * Actualiza un registro existente con nueva información basada en el objeto DTO proporcionado.
     *
     * @param previous el objeto {@code D} que se desea actualizar.
     * @param newData el nuevo objeto {@code D} con los datos actualizados.
     * @return {@code true} si el registro fue actualizado exitosamente, 
     * {@code false} si no se encontró.
     */
    public boolean update(D previous, D newData);

}
