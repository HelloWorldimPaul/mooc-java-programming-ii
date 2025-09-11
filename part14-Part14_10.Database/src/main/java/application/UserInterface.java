package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();

            if (command.equals("1")) {
                System.out.println("Listing the database contents");
                for(Todo list : this.database.list()){

                    System.out.println(list);

                }

            } else if (command.equals("2")) {
                System.out.println("Adding a new todo");
                System.out.println("Enter name");
                String name = scanner.nextLine();
                System.out.println("Enter description");
                String desc = scanner.nextLine();

                boolean done = false;
                Todo newTodo = new Todo(name, desc, done);

                this.database.add(newTodo);


            } else if (command.equals("3")) {

                System.out.println("Which todo should be marked as done (give the id)?");
                int todoId = Integer.parseInt(scanner.nextLine());

                this.database.markAsDone(todoId);

            } else if (command.equals("4")) {

                System.out.println("Which todo should be removed (give the id)?");
                int todoId = Integer.parseInt(scanner.nextLine());
                this.database.remove(todoId);

            } else if (command.equals("x")) {
                break;
            }

            // implement the functionality here
        }

        System.out.println("Thank you!");
    }

}
