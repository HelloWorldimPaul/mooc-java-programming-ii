package FlightControl.Assests;

public class Flight {

    private final Plane plane;
    private final String departureID;
    private final String destinationID;


    public Flight(Plane plane, String departureId, String destinationID){

        this.plane = plane;
        this.departureID = departureId;
        this.destinationID = destinationID;

    }

    @Override
    public String toString(){

        return this.plane + " (" + this.departureID + "-" + this.destinationID + ")";
    }




}
