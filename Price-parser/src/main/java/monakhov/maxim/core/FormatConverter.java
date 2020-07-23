package monakhov.maxim.core;

public interface FormatConverter {
    String convert(Object formattedText);
    Object reconvert(String plainText);
}
