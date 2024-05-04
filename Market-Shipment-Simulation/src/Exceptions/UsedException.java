package Exceptions;

@SuppressWarnings("serial")
public class UsedException extends Exception{
	
	public UsedException() {
		super("EX: This box/container is already shipped.");
	}
	
	public UsedException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
