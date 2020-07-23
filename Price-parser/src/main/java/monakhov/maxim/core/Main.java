package monakhov.maxim.core;

import monakhov.maxim.core.customExceptions.FileDoesntExistException;
import monakhov.maxim.core.customExceptions.NotAFileException;
import monakhov.maxim.core.customExceptions.NotEnoughRootsException;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.LinkedList;


public class Main {

    LinkedList<Diapason> diapasons;
    String excelDocument;

    XSSFWorkbook wb;

    private static final String[] schemes
            = {"http","https"}; // DEFAULT schemes = "http", "https", "ftp"
    private static final UrlValidator urlValidator
            = new UrlValidator(schemes);



    public void checkFileAccessibility(File file) {

        if (! file.canRead() && file.canWrite()) throw  new NotEnoughRootsException("Can't read or write to file. Not enough roots. ");

        if (! file.exists()) throw new FileDoesntExistException("The file doesn't exist.");

        if (! file.isFile()) throw new NotAFileException("The specified path doesn't lead to the file (directory ot etc).");

    }

    public void checkFileAccessibility(String  filePath) {
        checkFileAccessibility(new File(filePath));
    }

}
