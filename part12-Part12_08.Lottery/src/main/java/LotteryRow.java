
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random random;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.random = new Random();
        this.randomizeNumbers();

    }

    public ArrayList<Integer> numbers() {
        return new ArrayList<>(this.numbers);
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        // Implement the random number generation here
        // the method containsNumber is probably useful

        this.numbers = new ArrayList<>();

        while (this.numbers.size() < 7) {

            int randomNum = this.random.nextInt(40) + 1;

            if (!containsNumber(randomNum)) {
                this.numbers.add(randomNum);

            }

        }

    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers

        return this.numbers.contains(number);

    }
}

