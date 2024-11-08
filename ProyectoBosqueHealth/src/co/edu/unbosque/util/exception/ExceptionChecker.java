package co.edu.unbosque.util.exception;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {
	
	public static void notSpecialCharacter(String character) throws NotSpecialCharacterException {
		
		Pattern p = Pattern.compile("[^a-zA-ZñÑÀàÁáÂâÃãÆæÇçÉéÈèÊêËëÎîÏïÍíìÔôÓóÕõòŒœÙùÚúÛûÜüŸÿ ]");
		Matcher m = p.matcher(character);
		
		if (m.find()) {
			throw new NotSpecialCharacterException();
		}
	}
	
	public static void mail(String mail) throws MailException {
		
		Pattern p = Pattern.compile("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		Matcher m = p.matcher(mail);
		
		if (m.find()) {
			throw new MailException();
		}
	}
	
	public static void notValidNumberException(int numero) throws PositiveIntegerException {
		
		if(numero<0) {
			throw new PositiveIntegerException();
		}
	}
	
	public static void notValidInputException(String txt) throws NotValidInputException {
		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(txt);

		if (m.find()) {
			throw new NotValidInputException();
		}
	}
	
	public static void verifySpecialCharacterWhitSpaceAndNumbers(String a) throws NotValidInputException{
		Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
		Matcher m = p.matcher(a);
		if(m.find()) {
			throw new NotValidInputException();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void notValidBirthdateException(Date a) throws InvalidDateException {
		
		
		if(a.getYear() < 1904) {
			throw new InvalidDateException();
		}
	}
		
}
