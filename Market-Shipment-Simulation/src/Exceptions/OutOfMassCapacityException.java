package Exceptions;

@SuppressWarnings("serial")
public class OutOfMassCapacityException extends Exception {
	
	public OutOfMassCapacityException() {
		super("EX: Out of mass capacity.");
	}
	
	public OutOfMassCapacityException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
