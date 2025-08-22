import java.util.ArrayList;

public class OneItemBox extends Box{


    private ArrayList<Item> box;

    public OneItemBox(){

        this.box = new ArrayList<>();

    }



    public void add(Item item){

        if(this.box.isEmpty()){
            this.box.add(item);
        }

    }

    public  boolean isInBox(Item item){

        return this.box.contains(item);

    }
}
