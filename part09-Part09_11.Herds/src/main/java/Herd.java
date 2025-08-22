import java.util.ArrayList;

public class Herd implements Movable{

    private ArrayList<Movable> herd;

    public Herd(){

        this.herd = new ArrayList<>();

    }


    public void move(int dx, int dy){

       for(Movable movable : this.herd){

           movable.move(dx, dy);

       }

    }

    public void addToHerd(Movable movable){

        this.herd.add(movable);

    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        for(Movable movable : this.herd){

            sb.append(movable);
            sb.append("\n");
        }

        return sb.toString();
    }

}
