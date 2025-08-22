import java.util.Objects;

public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){

            return true;
        }

        if(obj == null){

            return false;
        }

        if(!(obj.getClass() == this.getClass())){

            return false;
        }

        Item objComapred = (Item) obj;

        return Objects.equals(this.name, objComapred.name);
    }

    @Override
    public int hashCode(){

        int hash = 9;

        hash = 31 * hash + Objects.hashCode(this.name);

        return hash;

    }

}
