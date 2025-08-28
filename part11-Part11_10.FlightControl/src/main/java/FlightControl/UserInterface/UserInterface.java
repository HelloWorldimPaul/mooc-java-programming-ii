package FlightControl.UserInterface;

import FlightControl.Logic.FlightControl;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final FlightControl flightControl;

    public UserInterface() {

        this.scanner = new Scanner(System.in);
        this.flightControl = new FlightControl();

    }


    public void start() {

        startAssestControl();

        startFlightControl();

    }


    private void startAssestControl() {

        while (true) {

            System.out.println("Airport Asset Control");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String actionInput = scanner.nextLine();

            if (actionInput.equals("1")) {

                addPlane();

            } else if (actionInput.equals("2")) {

                addFlight();

            } else if (actionInput.equalsIgnoreCase("x")) {

                break;
            } else {

                System.out.println("invalid");

            }

        }

    }

    private void startFlightControl() {

        while (true) {

            System.out.println("Flight Control");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String actionInput2 = scanner.nextLine();

            if (actionInput2.equals("1")) {

                this.flightControl.printPlanes();

            } else if (actionInput2.equals("2")) {

                this.flightControl.printFlights();

            } else if (actionInput2.equals("3")) {

                System.out.print("Give the airplane id: ");
                String planeID = scanner.nextLine();

                this.flightControl.printPlane(planeID.toUpperCase());

            } else if (actionInput2.equalsIgnoreCase("x")) {

                break;

            } else {

                System.out.println("Invalid");

            }

        }

    }

    private void addPlane() {

        System.out.print("Give the airplane id: ");

        String planeID = this.scanner.nextLine();

        System.out.print("Give the airplane capacity: ");

        String capacityInput = this.scanner.nextLine();

        if (planeID.isEmpty() || capacityInput.isEmpty()) {

            System.out.println("invalid input");
            return;
        }

        try {
            int capacity = Integer.parseInt(capacityInput);
            this.flightControl.addPlane(planeID.toUpperCase(), capacity);
        } catch (NumberFormatException e) {
            System.out.println("Capacity must be a number.");
        }

    }


    private void addFlight() {

        System.out.print("Give the airplane id: ");
        String planeID = this.scanner.nextLine();

        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();

        System.out.print("Give the target airport id: ");
        String destinationId = scanner.nextLine();

        if (planeID.isEmpty() || departureID.isEmpty() || destinationId.isEmpty()) {
            System.out.println("invalid inputs");
            return;
        }

        this.flightControl.addFlight(planeID.toUpperCase(), departureID.toUpperCase(), destinationId.toUpperCase());

    }

}
