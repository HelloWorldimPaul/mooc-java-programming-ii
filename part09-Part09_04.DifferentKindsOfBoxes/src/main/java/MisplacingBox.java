import java.util.ArrayList;

public class MisplacingBox extends Box{


    private ArrayList<Item> box;

    public MisplacingBox(){

        this.box = new ArrayList<>();

    }


    @Override
    public void add(Item item){


            this.box.add(item);


    }

    @Override
    public  boolean isInBox(Item item){

        return false;

    }
}
