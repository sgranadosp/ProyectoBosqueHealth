package co.edu.unbosque.util.exception;

/**
 * La clase {@code InvalidDateException} es una excepción personalizada que se lanza
 * cuando se ingresa una fecha no válida.
 * 
 * Esta excepción se utiliza para validar entradas de fechas en la aplicación,
 * asegurando que las fechas proporcionadas sean correctas antes de realizar 
 * cualquier operación que dependa de ellas.
 * 
 * Extiende la clase {@link Exception}, lo que permite capturar y manejar
 * errores relacionados con la validación de fechas.
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class InvalidDateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException() {
		// TODO Auto-generated constructor stub
		super("The date entered can't be used");
	}
}
