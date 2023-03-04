package isp.lab9.exercise2;

import java.util.Random;

public class Temperature extends Observable implements ReadSensor{
   @Override
    public void readSensor(){
       Random random = new Random();
       Integer data = random.nextInt();
       this.changeState(new Operation(Type.TEMPERATURE,data));
    }
}
