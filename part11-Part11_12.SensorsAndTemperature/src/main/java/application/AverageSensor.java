package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {


    private final List<Sensor> sensors;
    private final List<Integer> readings;


    public AverageSensor() {

        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }


    public boolean isOn() {

        boolean status = false;

        for (Sensor sensor : this.sensors) {

            if (sensor.isOn()) {
                status = true;
                break;
            }
        }
        return status;

    }

    public void setOn() {
        this.sensors.forEach(Sensor::setOn);

    }

    public void setOff() {
        this.sensors.forEach(Sensor::setOff);

    }

    public int read() {

        if (isOn()) {
            double avg = this.sensors.stream().mapToInt(Sensor::read).average().orElseThrow(() -> new IllegalStateException("No sensors available"));

            int intAvg = (int) avg;
            this.readings.add(intAvg);

            return intAvg;

        } else {

            throw new IllegalStateException("AverageSensor is turned OFF");
        }
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {

        return this.readings;
    }
}
