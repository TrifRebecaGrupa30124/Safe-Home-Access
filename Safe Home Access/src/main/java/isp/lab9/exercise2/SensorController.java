package isp.lab9.exercise2;

public class SensorController implements Observer{
    @Override
    public void update(Object event) {
        //Each time a sensor change it's value controller is notified and will print sensor value and sensor type.

        if(!(event instanceof Operation)){
            System.out.println(" ");
        }
        Operation operation = (Operation) event;
        System.out.println("The type and data of the sensor: " + operation.getType() + operation.getValue());
    }
}
