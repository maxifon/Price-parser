package monakhov.maxim.core.base;

import collection.HashMapStrictKey;
import monakhov.maxim.core.exceptions.InvalidCellPropertiesException;


/**
 * The class represents the Excel Cell consisting of row and column numbers.
 *
 * @author Maxim Monakhov
 * @version 1.0
 *
 */
public class Cell {

    /**
     * Row number.
     * <br> Must be >= 1.
     */
    private int rowNum;
    /**
     * Column number.
     * <br> Must be >= 1.
     */
    private int colNum;


    private static final HashMapStrictKey<CellField, String> FIELDS_DESCRIPTION
            = new HashMapStrictKey<>();


     static {

        FIELDS_DESCRIPTION.put(
                CellField.rowNum,
                "Row number must be zero or greater."
        );
        FIELDS_DESCRIPTION.put(
                CellField.colNum,
                "Column number must be zero or greater."
        );
    }


    /**
     * Constructs new {@code Cell} with the specified row and column numbers.
     *
     * @param rowNum row number.
     * @param colNum column number.
     * @throws InvalidCellPropertiesException If {@link Cell#rowNum} or {@link Cell#colNum} are not valid.
     */
    public Cell(int rowNum, int colNum) {
        setRowNum(rowNum);
        setColNum(colNum);
    }




    /**
     * Increments the row number ({@link Cell#rowNum}).
     * @return incremented row number.
     * @throws InvalidCellPropertiesException if incremented row number is not valid.
     */
    public int incRowNum() {
        setRowNum(++rowNum);
        return rowNum;
    }


    /**
     * Increments the column number ({@link Cell#colNum}).
     * @return incremented column number.
     * @throws InvalidCellPropertiesException if incremented column number is not valid.
     */
    public int incColNum() {
        setColNum(++colNum);
        return colNum;
    }

    /**
     * Returns a copy of the cell.
     * @return a copy of the cell.
     */
    public Cell copy() {
        return new Cell(rowNum, colNum);
    }


//----------------------------------------------------------------------------------------------------------------------


    // Getters and setters section


    /**
     * Returns the row number ({@link Cell#rowNum}).
     *
     * @return row number.
     */
    public int getRowNum() {
        return rowNum;
    }


    /**
     * Sets the row number ({@link Cell#rowNum}).
     *
     * @param rowNum row number.
     * @throws InvalidCellPropertiesException if row number is not valid.
     */
    private void setRowNum(int rowNum) {

        if (! (rowNum >= 0) ) throw new InvalidCellPropertiesException(FIELDS_DESCRIPTION.get(CellField.rowNum));

        this.rowNum = rowNum;

    }


    /**
     * Returns the column number ({@link Cell#colNum}).
     *
     * @return column number.
     */
    public int getColNum() {
        return colNum;
    }


    /**
     * Sets the column number ({@link Cell#colNum}).
     *
     * @param colNum column number.
     * @throws InvalidCellPropertiesException If column number is not valid.
     */
    private void setColNum(int colNum) {

        if (! (colNum >= 0) ) throw new InvalidCellPropertiesException(FIELDS_DESCRIPTION.get(CellField.colNum));

        this.colNum = colNum;

    }


    /**
     * Returns a {@code Cell} row and column numbers valid values description.
     * @return a {@code Cell} row and column numbers valid values description
     */
    public static String getFieldDescription() {
        return FIELDS_DESCRIPTION.toString();
    }



}




//----------------------------------------------------------------------------------------------------------------------


    // Local classes


enum CellField {

    rowNum,
    colNum
}
