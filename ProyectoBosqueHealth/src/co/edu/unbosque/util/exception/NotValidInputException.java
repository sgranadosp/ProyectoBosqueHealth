package co.edu.unbosque.util.exception;
/**
 * La clase {@code NotValidInputException} representa una excepción personalizada
 * que se lanza cuando la entrada proporcionada contiene caracteres no válidos.
 * 
 * Esta excepción se utiliza para validar que la entrada no contenga caracteres especiales
 * ni números en campos donde solo se esperan letras.
 * 
 * Extiende la clase {@link Exception}, lo que permite manejar errores específicos
 * de validación en la aplicación.
 * 
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 * @since 2024-11-10
 */
public class NotValidInputException extends Exception {

    /**
     * Identificador de versión para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto que crea una instancia de {@code NotValidInputException}
     * con un mensaje predeterminado indicando que no se deben ingresar caracteres especiales o números.
     */
	public NotValidInputException() {
		super("don't enter special characters or numbers");
	}
}
