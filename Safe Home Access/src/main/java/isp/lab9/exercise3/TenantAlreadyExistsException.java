package isp.lab9.exercise3;

public class TenantAlreadyExistsException extends  Exception{
    public TenantAlreadyExistsException() {
    }

    public TenantAlreadyExistsException(String message) {
        super(message);
    }

    public TenantAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TenantAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}

