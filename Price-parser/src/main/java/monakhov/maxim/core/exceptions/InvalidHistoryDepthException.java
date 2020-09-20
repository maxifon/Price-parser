package monakhov.maxim.core.exceptions;

public class InvalidHistoryDepthException extends RuntimeException {

    public InvalidHistoryDepthException() {
    }

    public InvalidHistoryDepthException(String message) {
        super(message);
    }
}
