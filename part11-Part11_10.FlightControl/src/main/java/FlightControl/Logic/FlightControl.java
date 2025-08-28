package FlightControl.Logic;

import FlightControl.Assests.Flight;
import FlightControl.Assests.Place;
import FlightControl.Assests.Plane;

import java.util.HashMap;
import java.util.Map;

public class FlightControl {

    private final Map<String, Plane> planes;
    private final Map<String, Flight> flights;
    private final Map<String, Place> places;


    public FlightControl() {

        this.planes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();

    }

    public void addPlane(String id, int capacity) {

        this.planes.putIfAbsent(id, new Plane(id, capacity));

    }

    public void addFlight(String planeId, String departureID, String destinationID) {

        if((!planeChecker(planeId))){

            return;
        }

        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));

        Flight flight = new Flight(this.planes.get(planeId), this.places.get(departureID).getID(), this.places.get(destinationID).getID());
        this.flights.putIfAbsent(flight.toString(), flight);

    }

    public void printPlanes() {

        this.planes.values().forEach(System.out::println);

    }

    public void printFlights() {

        this.flights.values().forEach(System.out::println);
    }

    public void printPlane(String planeId) {

        if (planeChecker(planeId)) {

            System.out.println(this.planes.get(planeId));

        } else {

            System.out.println("No " + planeId + " Found");
        }

    }

    public boolean planeChecker(String planeId) {

        return this.planes.containsKey(planeId);

    }

}
