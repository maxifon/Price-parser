package monakhov.maxim.core.customExceptions;



public abstract class ExcelException extends RuntimeException {


    public ExcelException() {
        super();
    }


    public ExcelException(String message) {
        super(message);
    }

}
