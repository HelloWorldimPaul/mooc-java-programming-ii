package FlightControl.Assests;

public class Plane {

    private final String id;
    private final int capacity;


    public Plane(String id, int capacity){

        this.id = id;
        this.capacity = capacity;

    }

    public int getCapacity(){

        return this.capacity;
    }

    @Override
    public String toString(){

        return this.id  + " (" + this.capacity + " capacity)";
    }


}
