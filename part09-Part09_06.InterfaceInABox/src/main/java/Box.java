import java.util.ArrayList;

public class Box implements Packable{

    private ArrayList<Packable> box;
    private double maxCapacity;

    public Box(double maxCapacity){

        this.maxCapacity = maxCapacity;
        this.box = new ArrayList<>();

    }

    public void add(Packable packable){

        if((weight() + packable.weight()) <= this.maxCapacity){

            this.box.add(packable);;
        }

    }

    public double weight(){

        double totalWeight = 0;
        for(Packable packable : box){

            totalWeight += packable.weight();

        }
        return totalWeight;

    }



    @Override
    public String toString(){

        return "Box: " + this.box.size() + " items, " + "total weight " + weight() + " kg";
    }


}
