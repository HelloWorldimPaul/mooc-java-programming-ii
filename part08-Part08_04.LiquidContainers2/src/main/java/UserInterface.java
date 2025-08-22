import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private ContainerManager containerManager;
    private Container first;
    private Container second;

    public UserInterface(Scanner scanner) {

        this.scanner = scanner;
    }

    public void start() {

        this.first = new Container();
        this.second = new Container();
        this.containerManager = new ContainerManager(this.first, this.second);

        while (true) {


            printContainerAmount();
            String input = userInput();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length < 2) {
                System.out.println("Unknown Command");
                continue;
            }

            String command = parts[0].toLowerCase();

            int amount;
            try {
                amount = Integer.parseInt(parts[1]);
            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                continue;
            }

            if (userInputCheck(amount)) {

                if (command.equals("add")) {

                    add(amount);

                } else if (command.equals("move")) {

                    move(amount);


                } else if (command.equals("remove")) {


                    remove(amount);


                } else {

                    System.out.println("Unknown Command");
                }

            } else {

                System.out.println("input only positive amount");

            }
        }
    }

    public String userInput() {

        return scanner.nextLine();

    }

    public boolean userInputCheck(int input) {

        return input > 0;
    }

    public void printContainerAmount() {

        System.out.println("First: " + this.first.toString());
        System.out.println("Second: " + this.second.toString());

    }

    public void add(int amount) {


        containerManager.addLiquid(amount);


    }

    public void move(int amount) {


        containerManager.moveLiquid(amount);


    }

    public void remove(int amount) {


        containerManager.removeLiquid(amount);


    }


}



