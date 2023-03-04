package isp.lab9.exercise3;


public class TooManyAttemptsException extends Exception{
    public TooManyAttemptsException() {
    }

    public TooManyAttemptsException(String message) {
        super(message);
    }

    public TooManyAttemptsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyAttemptsException(Throwable cause) {
        super(cause);
    }
}