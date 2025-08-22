import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> vehicleRegistry;

    public VehicleRegistry() {

        this.vehicleRegistry = new HashMap<>();

    }


    public boolean add(LicensePlate licensePlate, String owner) {

        String plateOwner = vehicleRegistry.get(licensePlate);

        if (plateOwner == null) {

            vehicleRegistry.put(licensePlate, owner);
            return true;

        } else {
            return false;
        }


    }

    public String get(LicensePlate licensePlate) {

        return vehicleRegistry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {


        if (vehicleRegistry.containsKey(licensePlate)) {

            vehicleRegistry.remove(licensePlate);
            return true;
        } else {
            return false;
        }


    }

    public void printLicensePlates() {

        for (LicensePlate licensePlate : vehicleRegistry.keySet()) {

            System.out.println(licensePlate);

        }

    }

    public void printOwners() {

        HashSet<String> owners = new HashSet<>();

        for (String owner : vehicleRegistry.values()) {

            if (owners.add(owner)) {
                System.out.println(owner);
            }
        }
    }


}
