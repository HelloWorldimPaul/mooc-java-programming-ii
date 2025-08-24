
import java.util.*;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        System.out.println("Input numbers, type end to stop.");
        while (true) {

            String input = scanner.nextLine();
            if (input.equals("end")) {

                break;
            }

            inputs.add(input);

        }
        // Write your program here





        OptionalDouble optionalDouble = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average();

        double avg = optionalDouble.orElse(0.0);
        System.out.println("average of the numbers: " + avg);

    }
}
