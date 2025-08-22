import java.util.ArrayList;

public class ChangeHistory {


    private final ArrayList<Double> history;

    public ChangeHistory() {

        this.history = new ArrayList<>();

    }

    public void add(double status) {

        history.add(status);
    }

    public void clear() {

        history.clear();

    }

    @Override
    public String toString() {

        return this.history.toString();

    }

    public double maxValue(){

        if (this.history.isEmpty()) return 0;

        double largestValue = this.history.get(0);

        for(Double history : this.history){

            if(history > largestValue){

                largestValue = history;

            }

        }

        return largestValue;

    }

    public double minValue(){

        if (this.history.isEmpty()) return 0;
        double smallestValue = this.history.get(0);

        for(Double value : this.history) if(value < smallestValue) smallestValue = value;
        return smallestValue;

    }

    public double average(){

        if(this.history.isEmpty()){
            return 0;

        }

        double avgValue = 0;

        for(Double history : this.history){

            avgValue += history;

        }
        return avgValue/this.history.size();

    }
}
