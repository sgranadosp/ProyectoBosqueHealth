package co.edu.unbosque.util.exception;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code ExceptionChecker} proporciona métodos estáticos para validar
 * diferentes entradas y lanzar excepciones personalizadas cuando se encuentran
 * errores en los datos proporcionados.
 * 
 * Esta clase incluye métodos para validar caracteres especiales, correos electrónicos, 
 * números positivos, entradas válidas y fechas de nacimiento.
 * 
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 * @since 2024-11-10
 */
public class ExceptionChecker {
	
	/**
     * Verifica si una cadena contiene caracteres especiales. Si se encuentra un carácter especial,
     * se lanza una excepción {@link NotSpecialCharacterException}.
     * 
     * @param character La cadena a validar.
     * @throws NotSpecialCharacterException Si se encuentran caracteres especiales en la cadena.
     */
	public static void notSpecialCharacter(String character) throws NotSpecialCharacterException {
		
		Pattern p = Pattern.compile("[^a-zA-ZñÑÀàÁáÂâÃãÆæÇçÉéÈèÊêËëÎîÏïÍíìÔôÓóÕõòŒœÙùÚúÛûÜüŸÿ ]");
		Matcher m = p.matcher(character);
		
		if (m.find()) {
			throw new NotSpecialCharacterException();
		}
	}
	
	 /**
     * Verifica si una dirección de correo electrónico es válida. Si no es válida,
     * se lanza una excepción {@link MailException}.
     * 
     * @param mail El correo electrónico a validar.
     * @throws MailException Si el correo electrónico no es válido.
     */
	public static void mail(String mail) throws MailException {
		
		Pattern p = Pattern.compile("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		Matcher m = p.matcher(mail);
		
		if (m.find()) {
			throw new MailException();
		}
	}
	
	 /**
     * Verifica si un número es positivo. Si el número es negativo, se lanza
     * una excepción {@link PositiveIntegerException}.
     * 
     * @param numero El número a validar.
     * @throws PositiveIntegerException Si el número es negativo.
     */
	public static void notValidNumberException(int numero) throws PositiveIntegerException {
		
		if(numero<0) {
			throw new PositiveIntegerException();
		}
	}
	
	 /**
     * Verifica si una cadena contiene caracteres no válidos. Si se encuentran caracteres especiales
     * o números, se lanza una excepción {@link NotValidInputException}.
     * 
     * @param txt La cadena a validar.
     * @throws NotValidInputException Si se encuentran caracteres no válidos.
     */
	public static void notValidInputException(String txt) throws NotValidInputException {
		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(txt);

		if (m.find()) {
			throw new NotValidInputException();
		}
	}
	
	 /**
     * Verifica si una cadena contiene caracteres especiales, excepto letras, números y espacios.
     * Si se encuentran caracteres especiales, se lanza una excepción {@link NotValidInputException}.
     * 
     * @param a La cadena a validar.
     * @throws NotValidInputException Si se encuentran caracteres especiales.
     */
	public static void verifySpecialCharacterWhitSpaceAndNumbers(String a) throws NotValidInputException{
		Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
		Matcher m = p.matcher(a);
		if(m.find()) {
			throw new NotValidInputException();
		}
	}
	
	/**
     * Verifica si una fecha de nacimiento es válida. Si el año es anterior a 1904,
     * se lanza una excepción {@link InvalidDateException}.
     * 
     * @param a La fecha de nacimiento a validar.
     * @throws InvalidDateException Si la fecha ingresada no es válida.
     */
	public static void notValidBirthdateException(Date a) throws InvalidDateException {
		
		if(a.getDate() < 1904) {
			throw new InvalidDateException();
		}
	}
		
}
