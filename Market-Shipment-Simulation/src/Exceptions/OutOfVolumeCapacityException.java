package Exceptions;

@SuppressWarnings("serial")
public class OutOfVolumeCapacityException extends Exception{
	
	public OutOfVolumeCapacityException() {
		super("EX: Out of volume capacity.");
	}
	
	public OutOfVolumeCapacityException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
