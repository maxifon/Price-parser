package monakhov.maxim.core.exceptions;



public class InvalidMaxSizeException extends FixedStackException {

    public InvalidMaxSizeException() {
    }

    public InvalidMaxSizeException(String message) {
        super(message);
    }
}
