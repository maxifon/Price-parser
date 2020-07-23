package monakhov.maxim.core.customExceptions;

public class FileDoesntExistException extends FileException {

    public FileDoesntExistException(String message) {
        super(message);
    }
}
