package monakhov.maxim.core;


import monakhov.maxim.core.customExceptions.InvalidCellPropertiesException;

import java.util.HashMap;


public class Cell {


    private int rowNum;
    private int columnNum;

    private static final HashMap<String, String> fieldsDescription;


    static {
        fieldsDescription = new HashMap<>();

        fieldsDescription.put(
                "rowNum",
                "rowNum must be zero or greater."
        );
        fieldsDescription.put(
                "columnNum",
                "columnNum must be zero or greater."
        );
    }


    /**
     * Constructs new {@code Cell} with the specified row and column numbers.
     *
     * @param rowNum row number
     * @param columnNum column number
     * @throws InvalidCellPropertiesException If row or column number is not valid
     */
    public Cell(int rowNum, int columnNum) {
        setRowNum(rowNum);
        setColumnNum(columnNum);
    }


    /**
     * Checks whether the row number is valid
     *
     * @param rowNum Row number to validate
     * @return Returns true if the row number is valid
     */
    private boolean isValidRowNum(int rowNum) {
        return
                rowNum >= 0;
    }


    /**
     * Checks whether the column number is valid
     *
     * @param columnNum Column number to validate
     * @return Returns true if the column number is valid
     */
    private boolean isValidColumnNum(int columnNum) {
        return
                columnNum >= 0;
    }


    /**
     * Increments the row number
     * @throws InvalidCellPropertiesException If incremented row number is not valid
     */
    public void incRowNum() {
        setRowNum(++rowNum);
    }


    /**
     * Increments the column number
     * @throws InvalidCellPropertiesException If incremented column number is not valid
     */
    public void incColumnNum() {
        setColumnNum(++columnNum);
    }


    /**
     * Returns the row number
     *
     * @return row number
     */
    public int getRowNum() {
        return rowNum;
    }


    /**
     * Sets the row number
     *
     * @param rowNum row number
     * @throws InvalidCellPropertiesException If row number is not valid
     */
    public void setRowNum(int rowNum) {

        if (! isValidRowNum(rowNum)) throw new InvalidCellPropertiesException(fieldsDescription.get("rowNum"));

        this.rowNum = rowNum;
    }


    /**
     * Returns the column number
     *
     * @return column number
     */
    public int getColumnNum() {
        return columnNum;
    }


    /**
     * Sets the column number
     *
     * @param columnNum column number
     * @throws InvalidCellPropertiesException If column number is not valid
     */
    public void setColumnNum(int columnNum) {

        if (! isValidColumnNum(columnNum)) throw new InvalidCellPropertiesException(fieldsDescription.get("columnNum"));

        this.columnNum = columnNum;
    }
}
