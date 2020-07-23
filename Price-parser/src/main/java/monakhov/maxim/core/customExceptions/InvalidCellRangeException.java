package monakhov.maxim.core.customExceptions;



public class InvalidCellRangeException extends ExcelException {


    public InvalidCellRangeException() {
        super();
    }

    public InvalidCellRangeException(String message) {
        super(message);
    }

}
