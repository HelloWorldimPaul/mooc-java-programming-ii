import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorageFacility {

    private final HashMap<String, ArrayList<String>> storageFacility;

    public StorageFacility() {

        this.storageFacility = new HashMap<>();
    }


    public void add(String unit, String item) {

        this.storageFacility.putIfAbsent(unit, new ArrayList<>());

        this.storageFacility.get(unit).add(item);

    }

    public ArrayList<String> contents(String storageUnit) {

        return this.storageFacility.getOrDefault(storageUnit, new ArrayList<>());
    }


    public void remove(String storageUnit, String item){

        List<String> items = storageFacility.get(storageUnit);

        if (items == null) {
            return; // No such storage unit, nothing to remove
        }

        items.remove(item);

        if (items.isEmpty()) {
            storageFacility.remove(storageUnit);
        }

    }

    public ArrayList<String> storageUnits(){

        return new ArrayList<>(this.storageFacility.keySet());
    }
}
