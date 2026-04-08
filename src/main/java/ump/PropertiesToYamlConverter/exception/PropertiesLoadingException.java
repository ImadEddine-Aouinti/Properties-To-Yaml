package ump.PropertiesToYamlConverter.exception;



public class PropertiesLoadingException extends Exception {

    private static final long serialVersionUID = 1L;

    public PropertiesLoadingException(String message) {
        super(message);
    }

    public PropertiesLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesLoadingException(Throwable cause) {
        super(cause);
    }
}
