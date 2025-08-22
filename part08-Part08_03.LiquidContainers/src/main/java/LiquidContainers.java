
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        UserInterface ui = new UserInterface(scan);
        ui.start();
        scan.close();
    }
}
