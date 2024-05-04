package Exceptions;

@SuppressWarnings("serial")
public class SerialNumberDoesntExistException extends Exception {
    public SerialNumberDoesntExistException(String message){
        super(message);
    }
    public SerialNumberDoesntExistException(){
        super("This serial number does not exist.");
    }
    public String getMessage() {
        return super.getMessage();
    }
}
