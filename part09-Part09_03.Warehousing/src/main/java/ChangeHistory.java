import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ChangeHistory {


    private final ArrayList<Double> history;

    public ChangeHistory() {

        this.history = new ArrayList<>();

    }

    public void add(double status) {

        this.history.add(status);
    }

    public void clear() {

        this.history.clear();

    }

    @Override
    public String toString() {

        return this.history.toString();

    }

    public double maxValue(){

        return Collections.max(this.history);

    }

    public double minValue(){

        return Collections.min(this.history);

    }

    public double average(){

        return this.history.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        /*


         if(this.history.isEmpty()){
            return 0;

        }

        double avgValue = 0;

        for(Double history : this.history){

            avgValue += history;

        }
        return avgValue/this.history.size();


         */




    }
}
