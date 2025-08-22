public class Organism implements Movable{

    private int dx;
    private int dy;

    public Organism(int x, int y){
        this.dx = x;
        this.dy = y;

    }

    public void move(int dx, int dy){

        this.dx += dx;
        this.dy += dy;

    }

    @Override
    public String toString(){

        return "x: " + this.dx + "; " + "y: " + this.dy;

    }

}
