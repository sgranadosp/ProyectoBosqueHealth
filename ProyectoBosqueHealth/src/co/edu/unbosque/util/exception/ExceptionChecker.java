package co.edu.unbosque.util.exception;

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

}
