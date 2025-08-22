
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        UserInterface ui = new UserInterface(scan);
        ui.start();
        scan.close();
    }
}
