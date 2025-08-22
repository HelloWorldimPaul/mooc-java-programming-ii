import java.util.ArrayList;

public class BoxWithMaxWeight extends  Box{

    private int capacity;
    private ArrayList<Item> box;


    public BoxWithMaxWeight(int capacity){

        this.capacity = capacity;
        this.box = new ArrayList<>();
    }



    public void add(Item item){

        int totalWeight = 0;
        for(Item itemWeight : this.box){

            totalWeight += itemWeight.getWeight();

        }

        if((totalWeight + item.getWeight()) <= this.capacity){

            this.box.add(item);
        }

    }


    public  boolean isInBox(Item item){

        return this.box.contains(item);

    }
}
