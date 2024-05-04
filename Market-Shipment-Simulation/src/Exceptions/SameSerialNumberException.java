package Exceptions;

@SuppressWarnings("serial")
public class SameSerialNumberException extends Exception {
	
	public SameSerialNumberException() {
		super("EX: Existing serial number.");
	}
	
	public SameSerialNumberException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
