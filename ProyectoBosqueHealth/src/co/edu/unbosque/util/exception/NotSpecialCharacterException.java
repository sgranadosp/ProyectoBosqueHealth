package co.edu.unbosque.util.exception;

public class NotSpecialCharacterException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotSpecialCharacterException() {
		
		super("You can't type special characters on this textfield");
		
	}
	
}
