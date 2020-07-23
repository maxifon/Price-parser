package monakhov.maxim.core;


import com.thoughtworks.xstream.XStream;

public class XMLConverter implements FormatConverter {

    XStream xs;

    public XMLConverter() {
        xs = new XStream();
    }


    @Override
    public String convert(Object objectToConvert) {
        return xs.toXML(objectToConvert);
    }

    @Override
    public Object reconvert(String objectString) {
        return xs.toXML(objectString);
    }
}
