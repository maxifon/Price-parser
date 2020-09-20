package monakhov.maxim.core.util;

import monakhov.maxim.core.base.Cell;

import java.util.HashMap;


public class CellUtil {


    private static final HashMap<Integer, String> decimalToExcelFormat
            = new HashMap<>();

//    private static final HashMap<String, Integer> excelFormatToDecimal
//            = new HashMap<>();

    private static final byte base
            = 26;

    static {
        decimalToExcelFormat.put(1, "A");
        decimalToExcelFormat.put(2, "B");
        decimalToExcelFormat.put(3, "C");
        decimalToExcelFormat.put(4, "D");
        decimalToExcelFormat.put(5, "E");
        decimalToExcelFormat.put(6, "F");
        decimalToExcelFormat.put(7, "G");
        decimalToExcelFormat.put(8, "H");
        decimalToExcelFormat.put(9, "I");
        decimalToExcelFormat.put(10, "J");
        decimalToExcelFormat.put(11, "K");
        decimalToExcelFormat.put(12, "L");
        decimalToExcelFormat.put(13, "M");
        decimalToExcelFormat.put(14, "N");
        decimalToExcelFormat.put(15, "O");
        decimalToExcelFormat.put(16, "P");
        decimalToExcelFormat.put(17, "Q");
        decimalToExcelFormat.put(18, "R");
        decimalToExcelFormat.put(19, "S");
        decimalToExcelFormat.put(20, "T");
        decimalToExcelFormat.put(21, "U");
        decimalToExcelFormat.put(22, "V");
        decimalToExcelFormat.put(23, "W");
        decimalToExcelFormat.put(24, "X");
        decimalToExcelFormat.put(25, "Y");
        decimalToExcelFormat.put(26, "Z");

//        for (Map.Entry entry: decimalToExcelFormat.entrySet()) {
//            excelFormatToDecimal.put(entry.getValue().toString(), Integer.parseInt(entry.getKey().toString()));
//        }

    }

    public static String cellToExcelFormat(Cell cell) {
        return cellColNumToExcelFormat(cell.getColNum()) + cell.getRowNum();

    }

    public static String cellColNumToExcelFormat(int colNum) {

        Cell cell = new Cell(1, colNum); // is used to check whether the column number is valid

        if (colNum <= base) {
            return decimalToExcelFormat.get(colNum);
        } else
            return cellColNumToExcelFormat(colNum / base) + decimalToExcelFormat.get(colNum % base);
    }

}
