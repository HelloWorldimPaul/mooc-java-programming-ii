package application;

public class StandardSensor implements Sensor {

    private int input;

    public StandardSensor(int input) {

        this.input = input;
    }


    public boolean isOn() {
        return true;
    }

    public void setOn() {

    }

    public void setOff() {

    }

    public int read() {
        return this.input;
    }

}
