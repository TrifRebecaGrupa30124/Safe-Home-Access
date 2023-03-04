package isp.lab9.exercise3;


public class InvalidPinException extends Exception {
    public InvalidPinException() {
    }

    public InvalidPinException(String message) {
        super(message);
    }

    public InvalidPinException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPinException(Throwable cause) {
        super(cause);
    }
}
