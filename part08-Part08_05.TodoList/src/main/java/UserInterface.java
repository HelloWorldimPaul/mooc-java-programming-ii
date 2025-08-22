import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final TodoList list;

    public UserInterface(TodoList list, Scanner scanner) {

        this.scanner = scanner;
        this.list = list;

    }

    public void start() {

        while (true) {


            System.out.print("Command: ");
            String command = userInput();

            if (command.equalsIgnoreCase("stop")) {

                break;
            } else if (command.equalsIgnoreCase("add")) {

                add();

            } else if (command.equalsIgnoreCase("list")) {

                list();

            } else if (command.equalsIgnoreCase("remove")) {

                remove();

            }
        }

    }

    public String userInput() {

        return scanner.nextLine();

    }

    public void add() {

        System.out.print("To add: ");
        String task = userInput();
        this.list.add(task);


    }

    public void list() {

        this.list.print();

    }

    public void remove() {

        System.out.print("Which one is removed? ");
        int number = 0;
        try {
            number = Integer.parseInt(userInput());
        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
        this.list.remove(number);

    }


}
