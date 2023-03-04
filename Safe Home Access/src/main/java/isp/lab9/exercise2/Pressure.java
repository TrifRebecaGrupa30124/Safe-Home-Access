package isp.lab9.exercise2;

import java.util.Random;

public class Pressure extends Observable implements ReadSensor{
    @Override
    public void readSensor() {
        Random random = new Random();
        Integer data = random.nextInt();
        this.changeState(new Operation(Type.PRESSURE,data));
    }
}
