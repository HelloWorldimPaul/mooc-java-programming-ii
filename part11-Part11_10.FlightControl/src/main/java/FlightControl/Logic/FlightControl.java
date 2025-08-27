package FlightControl.Logic;

import FlightControl.Assests.Flight;
import FlightControl.Assests.Place;
import FlightControl.Assests.Plane;

import java.util.HashMap;
import java.util.Map;

public class FlightControl {

    Map<String, Plane> planes;
    Map<String, Flight> flights;
    Map<String, Place> places;


    public FlightControl(){

        this.planes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();

    }

    public void addPlane(String id, int capacity){

        this.planes.putIfAbsent(id, new Plane(id, capacity));

    }

    public void addFlight(Plane plane, String departureID, String destinationID){

        Flight flight = new Flight(plane, departureID, destinationID);
        this.flights.putIfAbsent(flight.toString(), flight);


    }


}
