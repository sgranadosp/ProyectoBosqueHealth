package co.edu.unbosque.util.exception;

/**
 * La clase PositiveIntegerException es una excepción personalizada que se lanza
 * cuando un número entero negativo es ingresado en un contexto donde se espera un número positivo.
 * 
 * Esta clase extiende la clase base {@link Exception}, lo que permite manejar 
 * errores específicos relacionados con enteros positivos en la aplicación.
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 * 
 * 
 */
public class PositiveIntegerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * Constructor por defecto que crea una instancia de {@code PositiveIntegerException}
     * con un mensaje predeterminado indicando que el número no puede ser negativo.
     */
	public PositiveIntegerException() {
		super("The number can't be negative");
	}

}
