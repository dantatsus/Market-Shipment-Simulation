package Exceptions;

@SuppressWarnings("serial")
public class AlreadyBoxedException extends Exception {
	
	public AlreadyBoxedException() {
		super("EX: Item or box is already loaded.");
	}
	
	public AlreadyBoxedException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
