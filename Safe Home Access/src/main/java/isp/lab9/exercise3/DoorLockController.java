package isp.lab9.exercise3;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DoorLockController implements ControllerInterface {

    private List<AccessLog> accessLogs;
    private Door door;
    private Map<Tenant, AccessKey> validAccess = new HashMap<>();

    private int contor = 0;

    public DoorLockController() {
    }

    public DoorLockController(Map<Tenant, AccessKey> validAccess) {
        this.validAccess = validAccess;
    }

    public DoorLockController(Door door, List<AccessLog> accessLogs) {
        this.door = door;
        this.accessLogs = accessLogs;
        this.validAccess = new HashMap<>();
        this.validAccess.put(new Tenant(ControllerInterface.MASTER_TENANT_NAME), new AccessKey(ControllerInterface.MASTER_KEY));
    }

    private AccessLog accessLog(String tenant, String operation, String message) {
        return new AccessLog(tenant, LocalDateTime.now(), operation, this.door.getStatus(), message);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DoorLockController that = (DoorLockController) o;
//        return contor == that.contor && Objects.equals(accessLogs, that.accessLogs) && Objects.equals(door, that.door) && Objects.equals(validAccess, that.validAccess);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accessLogs, door, validAccess, contor);
//    }

    @Override
    public DoorStatus enterPin(String pin) throws TooManyAttemptsException, InvalidPinException {
        //Or
        // public DoorStatus enterPin(String pin) throws Exception
        final Map.Entry<Tenant, AccessKey> accessKeyEntry = this.validAccess
                .entrySet()
                .stream()
                .filter(tenantAccessKeyEntry -> tenantAccessKeyEntry.getValue().getPin().equals(pin))
                .findFirst().orElse(null);

        if (door.getStatus() == DoorStatus.OPEN) {
            door.lockDoor();
        } else {
            door.unlockDoor();
        }

        if (Objects.isNull(accessKeyEntry)) {
            contor++;  //if we insert the wrong pin, contor grows
            if (contor >= 3) {
                this.contor = 3;
                this.accessLogs.add(this.accessLog("", "Enter your Pin", "TooManyAttemptsException"));
                throw new TooManyAttemptsException("Too many attempts exception");
            } else {
                this.accessLogs.add(this.accessLog("", "enterPin", "InvalidPinException"));
                throw new InvalidPinException("Invalid Pin");
            }
        } else {
            if (accessKeyEntry.getKey().getName().equals(ControllerInterface.MASTER_TENANT_NAME)) {
                this.contor = 0;
            }

            this.accessLogs.add(this.accessLog("", "enter Pin", ""));
            return door.getStatus();
        }

    }

    @Override
    public void addTenant(String pin, String tenantName) throws TenantAlreadyExistsException {
        Tenant tenant = new Tenant(tenantName);
        AccessKey accessKey = new AccessKey(pin);
//        this.accessLogs.add(this.accessLog(tenantName, "add", ""));
//        this.validAccess.put(tenant, accessKey);

        for (Map.Entry<Tenant, AccessKey> contor : this.validAccess.entrySet()) {
            if (contor.getKey().getName().equals(tenantName)) {
                this.accessLogs.add((this.accessLog(tenantName, "Can't add", "")));
                throw new TenantAlreadyExistsException();
            }else
            {
                this.accessLogs.add(accessLog(tenant.getName(), "addTenant", ""));
                this.validAccess.put(tenant, new AccessKey(pin));
            }
        }

    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        Tenant tenant = new Tenant(name);
        if (validAccess.containsKey(tenant)) {
            accessLogs.add(accessLog(tenant.getName(), "remove", ""));
            validAccess.remove(tenant);
        } else {
            accessLogs.add(accessLog(tenant.getName(), "Can't remove", ""));
            throw new TenantNotFoundException("Didn't find the tenant");
        }

    }
    public Door getDoor() {
        return door;
    }

    public List<AccessLog> getAccessLogs() {
        return this.accessLogs;
    }


}