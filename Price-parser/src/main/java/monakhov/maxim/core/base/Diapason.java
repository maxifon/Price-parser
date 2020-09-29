package monakhov.maxim.core.base;

import collection.HashMapStrictKey;
import monakhov.maxim.core.Company;
import monakhov.maxim.core.exceptions.InvalidCompanyNameException;
import monakhov.maxim.core.exceptions.InvalidParseKeyException;


public class Diapason {


    CellRange cellRangeLinks;
    CellRange cellRangePrices;

    Company company; // TODO: 20.09.2020

    private static final HashMapStrictKey<, String> FIELDS_DESCRIPTION // todo
            = new HashMapStrictKey();

    {
        FIELDS_DESCRIPTION = new HashMapStrictKey<>();
        FIELDS_DESCRIPTION.put(
                "companyName",
                "companyName may only contain letters and symbols : '-'");
        FIELDS_DESCRIPTION.put(
                "parseKey",
                "parseKey may only contain attributes 'class' or 'id', letters and symbols : [' ']");
    }



    public Diapason(
                Cell cellStart,
                Cell cellEnd,
                String parseKey,
                String companyName) {

        setCellStart(cellStart);
        setCellEnd(cellEnd);
        setParseKey(parseKey);
        setCompanyName(companyName);
    }



    private static boolean isValidCompanyName(String companyName) {

        return
                ! (companyName == null)
                && companyName.length() > 1
                && companyName.matches("[a-zA-Z-]+");
    }


    private static boolean isValidParseKey(String parseKey) {

        return
                ! (parseKey == null)
                && (
                    parseKey.contains("class")
                    || parseKey.contains("id"));
    }


    public Cell getCellStart() {
        return cellStart;
    }

    public void setCellStart(Cell diapasonCellStart) {
        this.cellStart = diapasonCellStart;
    }

    public Cell getCellEnd() {
        return cellEnd;
    }

    public void setCellEnd(Cell diapasonCellEnd) {
        this.cellEnd = diapasonCellEnd;
    }

    public String getParseKey() {
        return parseKey;
    }

    public void setParseKey(String parseKey) {

        if (! isValidParseKey(parseKey)) throw new InvalidParseKeyException(FIELDS_DESCRIPTION.get("parseKey"));
        this.parseKey = parseKey;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (! isValidCompanyName(companyName)) throw new InvalidCompanyNameException(FIELDS_DESCRIPTION.get("companyName"));
        this.companyName = companyName;
    }

//    public static void main(String[] args) {
//        String s = "id";
//        System.out.println(Diapason.isValidParseKey(s));
//        throw new InvalidCompanyNameException();
//    }
}
