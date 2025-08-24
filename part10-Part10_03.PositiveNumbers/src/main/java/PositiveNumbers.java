
import java.util.*;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Integer> positive(List<Integer> numbers){


        return numbers.stream()
                .filter(num -> num >= 0)
                .collect(Collectors.toCollection(ArrayList::new));

    }

}
