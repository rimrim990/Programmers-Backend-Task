package project.utils.exception;

public class ConversionException extends RuntimeException {

    public ConversionException() {
    }

    public ConversionException(String arg0) {
        super(arg0);
    }

    public ConversionException(Throwable arg0) {
        super(arg0);
    }

    public ConversionException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
