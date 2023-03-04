package isp.lab9.exercise3;

public class TenantNotFoundException extends Exception{
    public TenantNotFoundException() {
    }

    public TenantNotFoundException(String message) {
        super(message);
    }

    public TenantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TenantNotFoundException(Throwable cause) {
        super(cause);
    }
}