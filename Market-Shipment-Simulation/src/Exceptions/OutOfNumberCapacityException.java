package Exceptions;

@SuppressWarnings("serial")
public class OutOfNumberCapacityException extends Exception {
	
	public OutOfNumberCapacityException() {
		super("EX: Out of number capacity.");
	}
	
	public OutOfNumberCapacityException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
