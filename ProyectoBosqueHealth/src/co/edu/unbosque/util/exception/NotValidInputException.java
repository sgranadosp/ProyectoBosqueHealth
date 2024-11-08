package co.edu.unbosque.util.exception;

public class NotValidInputException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotValidInputException() {
		super("don't enter special characters or numbers");
	}
}
