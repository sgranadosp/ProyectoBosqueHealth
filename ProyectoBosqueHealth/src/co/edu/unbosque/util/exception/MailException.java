package co.edu.unbosque.util.exception;

/**
 * La clase {@code MailException} es una excepción personalizada que se lanza 
 * cuando se detecta un correo electrónico no válido.
 * 
 * Esta excepción se utiliza para validar la entrada de correos electrónicos 
 * en la aplicación, asegurando que el formato sea correcto antes de proceder.
 * 
 * Extiende la clase {@link Exception}, lo que permite capturar y manejar 
 * errores relacionados con la validación de correos electrónicos.
 * 
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 * @since 2024-11-10
 */
public class MailException extends Exception{
		
	public MailException() {
			super("Not valid mail");
	}
	
}
