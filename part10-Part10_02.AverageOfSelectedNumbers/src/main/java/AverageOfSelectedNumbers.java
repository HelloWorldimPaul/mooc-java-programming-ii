
import java.util.*;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();
        // toteuta ohjelmasi tänne

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) {

                break;
            }

            try {
                inputs.add(Integer.valueOf(input));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number or 'end' to stop.");
            }

        }

        if (!(inputs.isEmpty())) {

            System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("n")) {

                OptionalDouble opt = inputs.stream()
                        .filter(number -> number < 0)
                        .mapToInt(i -> i)
                        .average();

                double avg = opt.orElse(0.0);
                System.out.println("Average of the negative numbers: " + avg);

            } else if (choice.equals("p")) {

                OptionalDouble opt = inputs.stream()
                        .mapToInt(i -> i)
                        .filter(number -> number > 0)
                        .average();

                double avg = opt.orElse(0.0);
                System.out.println("Average of the positive numbers: " + avg);

            }
        } else {

            System.out.println("Nothing to compute");
        }

    }
}
