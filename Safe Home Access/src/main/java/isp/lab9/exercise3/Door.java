package isp.lab9.exercise3;

public class Door {
    private DoorStatus status;

    public Door() {
    }

    public void lockDoor(){
        this.status = DoorStatus.CLOSE;
    }
    public void unlockDoor(){
        this.status = DoorStatus.OPEN;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void setStatus(DoorStatus status) {
        this.status = status;
    }
}
