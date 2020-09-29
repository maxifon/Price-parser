package monakhov.maxim.core.base;

import collection.HashMapStrictKey;
import monakhov.maxim.core.exceptions.InvalidCellRangeException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code CellRange} class represent the range consisting of
 * {@code Cell} cellStart - start of the range
 * {@code Cell} cellEnd - end of the range
 */
public class CellRange implements Iterable<Cell> {

    private Cell cellStart;
    private Cell cellEnd;
    private CellRangeDirection cellRangeDirection;

    private static boolean autoSwapCellRangeEndings;

    private static final HashMapStrictKey<CellRangeField, String> FIELDS_DESCRIPTION
            = new HashMapStrictKey<>();



    static {
        autoSwapCellRangeEndings = false;


        FIELDS_DESCRIPTION.put(
                CellRangeField.cellRangeDirection,
                "cellStart and cellEnd must have either the same row (horizontal CellRange) or column (vertical CellRange) number."
        );
        FIELDS_DESCRIPTION.put(
                CellRangeField.cellRange,
                "cellStart row number must be <= cellEnd row number and cellStart column number must be <= cellEnd column number."
        );
    }


    /**
     * Constructs {@code CellRange} from {@code Cell} - start of the range and {@code Cell} - end of the range
     *
     * @param cellStart {@code Cell} - start of the range
     * @param cellEnd {@code Cell} - end of the range
     * @throws InvalidCellRangeException If the cellStart row number not <= cellEnd row number
     * <br>or cellStart columnNumber not <= cellEnd columnNumber
     */
    public CellRange(Cell cellStart, Cell cellEnd) {

        setCellStart(cellStart);
        setCellEnd(cellEnd);
        validateCellRange();
        setCellRangeDirection();
    }


    /**
     * Returns size (length) of the {@code CellRange}.
     * <br>If {@code CellRange} is horizontal, difference (+ 1) of cellEnd and cellStart column numbers is returned
     * <br>If {@code CellRange} is vertical, difference (+ 1) of cellEnd and cellStart row numbers is returned
     *
     * @return size of the {@code CellRange}
     * @throws InvalidCellRangeException If the range is neither horizontal nor vertical
     */
    public int size() {
        if (cellRangeDirection == CellRangeDirection.HORIZONTAL) {
            return cellEnd.getColNum() - cellStart.getColNum() + 1;
        } else if (cellRangeDirection == CellRangeDirection.VERTICAL) {
            return cellEnd.getRowNum() - cellStart.getRowNum() + 1;
        } else throw new InvalidCellRangeException(FIELDS_DESCRIPTION.get(CellRangeField.cellRangeDirection));
    }


    /**
     * Allows to iterate over {@code CellRange}, iterating element is {@code Cell}
     *
     * @return {@code CellRange} Iterator
     */
    @Override
    public Iterator<Cell> iterator() {

        return new Iterator<Cell>() {

            Cell cellIterating = cellStart.copy();

            @Override
            public boolean hasNext() { // Change this Method. Cells are not changing now !!!
                return     cellRangeDirection == CellRangeDirection.HORIZONTAL
                        && cellIterating.getColNum() < cellEnd.getColNum()
                        || cellRangeDirection == CellRangeDirection.VERTICAL
                        && cellIterating.getRowNum() < cellEnd.getRowNum();
            }

            /**
             * Returns a next {@code Cell} in the {@code CellRange}
             *
             * @return Next {@code Cell} in the {@code CellRange}
             * @throws NoSuchElementException If CellRange iteration cursor is already pointing to the end
             */
            @Override
            public Cell next() {

                if ( ! hasNext()) throw new NoSuchElementException("CellRange iteration cursor is already pointing to the end.");

                if (cellRangeDirection == CellRangeDirection.HORIZONTAL) {
                    cellIterating.incColNum();
                } else if (cellRangeDirection == CellRangeDirection.VERTICAL) {
                    cellIterating.incRowNum();
                }

                return cellIterating;
            }
        };
    }


    /**
     * Checks whether the {@code CellRange} is valid
     *
     * @return true if the {@code CellRange} is valid
     */
    private void validateCellRange() {

        class Local {
            boolean isValidRange(Cell cellStart, Cell cellEnd) {
                return     cellStart.getRowNum() == cellEnd.getRowNum()
                        && cellStart.getColNum() <= cellEnd.getColNum()
                        || cellStart.getRowNum() <= cellEnd.getRowNum()
                        && cellStart.getColNum() == cellEnd.getColNum();
            }
        }

        Local local = new Local();

        if (autoSwapCellRangeEndings) {
            if ( !
                    (
                        local.isValidRange(cellStart, cellEnd)
                            || local.isValidRange(cellEnd, cellStart)
                    )

            ) throw new InvalidCellRangeException(FIELDS_DESCRIPTION.get(CellRangeField.cellRange));

        } else {
            if ( !
                    local.isValidRange(this.cellStart, this.cellEnd)

            ) throw new InvalidCellRangeException(FIELDS_DESCRIPTION.get(CellRangeField.cellRange));

        }

    }


    /**
     * Sets the {@code CellRangeDirection}
     *
     * @param cellStart {@code Cell} - start of the range
     * @param cellEnd {@code Cell} - end of the range
     * @throws InvalidCellRangeException If the range is neither horizontal nor vertical
     */
    private void setCellRangeDirection(Cell cellStart, Cell cellEnd) {
        if (cellStart.getRowNum() == cellEnd.getRowNum()) {
            cellRangeDirection = CellRangeDirection.HORIZONTAL;
        } else if (cellStart.getColNum() == cellEnd.getColNum()) {
            cellRangeDirection = CellRangeDirection.VERTICAL;
        } else throw new InvalidCellRangeException(FIELDS_DESCRIPTION.get(CellRangeField.cellRangeDirection));
    }


    /**
     * Sets the {@code CellRangeDirection} based on existing {@code Cell} - start of the range and {@code Cell} - end of the range
     * @throws InvalidCellRangeException If the range is neither horizontal nor vertical
     */
    private void setCellRangeDirection() {
        setCellRangeDirection(this.cellStart, this.cellEnd); //May throw NullPointerException
    }


    /**
     * Returns {@code Cell} - start of the range
     *
     * @return {@code Cell} - start of the range
     */
    public Cell getCellStart() {
        return cellStart;
    }


    /**
     * Sets the {@code Cell} - start of the range
     *
     * @param cellStart {@code Cell} - start of the range
     */
    private void setCellStart(Cell cellStart) {
        this.cellStart = cellStart;
    }


    /**
     * Returns {@code Cell} - end of the range
     *
     * @return {@code Cell} - end of the range
     */
    public Cell getCellEnd() {
        return cellEnd;
    }


    /**
     * Sets the {@code Cell} - end of the range
     *
     * @param cellEnd {@code Cell} - end of the range
     */
    private void setCellEnd(Cell cellEnd) {
        this.cellEnd = cellEnd;
    }


    /**
     * If {@code AutoValidateCellRange} option is true, the {@code CellRange} will try to be created from both CellRange(cellStart, cellEnd) and CellRange(cellEnd, cellStart)
     *
     * @return true if auto validation of the {@code CellRange} option is activated
     */
    public static boolean isAutoSwapCellRangeEndings() {
        return autoSwapCellRangeEndings;
    }


    /**
     * Sets the AutoValidateCellRange option
     *
     * @param autoSwapCellRangeEndings autoValidateCellRange option value
     */
    public static void setAutoSwapCellRangeEndings(boolean autoSwapCellRangeEndings) {
        CellRange.autoSwapCellRangeEndings = autoSwapCellRangeEndings;
    }



}




enum CellRangeField {
    cellRangeDirection,
    cellRange
}




enum CellRangeDirection {

    VERTICAL,
    HORIZONTAL

}
