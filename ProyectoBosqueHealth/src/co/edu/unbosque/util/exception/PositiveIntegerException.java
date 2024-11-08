package co.edu.unbosque.util.exception;

public class PositiveIntegerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PositiveIntegerException() {
		super("The number can't be negative");
	}

}
