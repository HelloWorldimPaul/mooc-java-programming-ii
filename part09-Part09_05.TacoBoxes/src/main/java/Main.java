import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Test your code here!

        TripleTacoBox triple = new TripleTacoBox();
        CustomTacoBox custom = new CustomTacoBox(5);

        ArrayList<TacoBox> boxes = new ArrayList<>();

        boxes.add(triple);
        boxes.add(custom);

        for(TacoBox box : boxes){

            box.eat();
            System.out.println(box.tacosRemaining());
        }
    }
}
