package title;


import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Title: ");
        String inputTitle = scanner.nextLine();
        scanner.close();
        Application.launch(UserTitle.class, "--title=" + inputTitle);





    }

}
