package monakhov.maxim.core.customExceptions;


public abstract class FileException extends RuntimeException {

    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }
}
