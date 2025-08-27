package FlightControl.Assests;

public class Flight {

    Plane plane;
    String departureID;
    String destinationID;


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
