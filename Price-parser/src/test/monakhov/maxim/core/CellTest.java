//package monakhov.maxim.core;
//
//
//import monakhov.maxim.core.exceptions.InvalidCellPropertiesException;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//
//public class CellTest {
//
//
//    @Test
//    public void constructCell() {
//        Cell cell = new Cell(2, 4);
//        int actualRowNum = cell.getRowNum();
//        int expectedRowNum = 2;
//        System.out.println((((()))));
//
//        assertEquals(actualRowNum, expectedRowNum);
//
//        int actualColumnNum = cell.getColNum();
//        int expectedColumnNum = 4;
//
//        assertEquals(actualColumnNum, expectedColumnNum);
//
//    }
//
//
//    @Test
//    public void constructCellInvalidParams() {
//        assertThrows(
//                InvalidCellPropertiesException.class,
//
//                () -> new Cell(0, -1)
//        );
//
//    }
//
//
//    @Test
//    public void incRowNum() {
//        Cell cell = new Cell(1, 3);
//
//        int actual = cell.incRowNum();
//        int expected = 2;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void incColumnNum() {
//        Cell cell = new Cell(1, 3);
//
//        int actual = cell.incColumnNum();
//        int expected = 4;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void getRowNum() {
//        Cell cell = new Cell(1, 3);
//
//        int actual = cell.getRowNum();
//        int expected = 1;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void setRowNum() {
//        Cell cell = new Cell(1, 3);
//
//        int actual = cell.getRowNum();
//        int expected = 3;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void setRowNumInvalid() {
//        Cell cell = new Cell(1, 3);
//
//        assertThrows(
//                InvalidCellPropertiesException.class,
//
//                () -> cell.setRowNum(-1)
//        );
//
//    }
//
//
//    @Test
//    public void getColumnNum() {
//        Cell cell = new Cell(1, 3);
//
//        int actual = cell.getColNum();
//        int expected = 3;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void setColumnNum() {
//        Cell cell = new Cell(1, 3);
//
//        cell.setColumnNum(3);
//        int actual = cell.getColNum();
//        int expected = 3;
//        assertEquals(actual, expected);
//
//    }
//
//
//    @Test
//    public void setInvalidColumnNum() {
//        Cell cell = new Cell(1, 3);
//
//        assertThrows(
//                InvalidCellPropertiesException.class,
//                () -> cell.setColumnNum(-1)
//        );
//
//    }
//}