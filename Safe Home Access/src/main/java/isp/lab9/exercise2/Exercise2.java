/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.lab9.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Admin
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("It works!");

        SensorController sensorController = new SensorController();
        List<Observable> sensorTypes = Arrays.asList(new Humidity(), new Pressure(), new Temperature());
        sensorTypes.forEach(sensor -> sensor.register(sensorController));
        sensorTypes.forEach(sensor -> ((ReadSensor) sensor).readSensor());


//           It works!
//
//         The type and data of the sensor: HUMIDITY-917590191
//         The type and data of the sensor: PRESSURE1440917367
//         The type and data of the sensor: TEMPERATURE-229459822

//         It works!
//                 The type and data of the sensor: HUMIDITY286980595
//         The type and data of the sensor: PRESSURE1167240994
//         The type and data of the sensor: TEMPERATURE2126210035

    }
}
