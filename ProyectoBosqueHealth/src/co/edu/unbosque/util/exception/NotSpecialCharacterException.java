package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotSpecialCharacterException} es una excepción personalizada
 * que se lanza cuando se detectan caracteres especiales en un campo de texto
 * donde no son permitidos.
 * 
 * Esta excepción se utiliza para validar que los usuarios no ingresen caracteres
 * especiales en ciertos campos, garantizando que la entrada sea válida.
 * 
 * Extiende la clase {@link Exception}, lo que permite capturar y manejar errores
 * de validación específicos en la aplicación.
 * 
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 * @since 2024-11-10
 */
public class NotSpecialCharacterException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotSpecialCharacterException() {
		
		super("You can't type special characters on this textfield");
		
	}
	
}
