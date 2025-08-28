package application;


public class TemperatureSensor implements Sensor {


    private boolean status;

    public TemperatureSensor() {

        this.status = false;
    }


    public boolean isOn() {
        return this.status;
    }

    public void setOn() {

        this.status = true;
    }

    public void setOff() {
        this.status = false;
    }

    public int read() {

        if (isOn()) {

            return (int) (Math.random() * 61) - 30;

        } else {

            throw new IllegalStateException("TemperatureSensor is turned OFF");
        }
    }

}
