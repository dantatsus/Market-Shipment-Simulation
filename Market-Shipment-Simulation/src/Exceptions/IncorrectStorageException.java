package Exceptions;

@SuppressWarnings("serial")
public class IncorrectStorageException extends Exception {
	
	public IncorrectStorageException() {
		super("EX: Incorrect storage unit.");
	}
	
	public IncorrectStorageException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
}
