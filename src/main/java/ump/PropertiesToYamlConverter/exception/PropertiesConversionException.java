package ump.PropertiesToYamlConverter.exception;


public class PropertiesConversionException extends Exception {
    private static final long serialVersionUID = 1L;

    public PropertiesConversionException(String message) {
        super(message);
    }

    public PropertiesConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesConversionException(Throwable cause) {
        super(cause);
    }
}
