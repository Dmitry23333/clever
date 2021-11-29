package by.gomel.clevertec.exceptions;

public class WrongIDException extends Exception {
    public WrongIDException() {
        super();
    }

    public WrongIDException(String message) {
        super(message);
    }

    public WrongIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongIDException(Throwable cause) {
        super(cause);
    }

    protected WrongIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
