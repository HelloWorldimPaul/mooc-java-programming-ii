
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();

        while (true) {

            int input = scanner.nextInt();

            if (input == 0) {

                break;
            } else if (input > 0) {

                inputs.add(input);

            }


        }

        if(inputs.isEmpty()){

            System.out.println("Cannot calculate the average");

        }else{
            int total = 0;
            for(int num : inputs){

                total += num;

            }
            System.out.println((double) total / inputs.size());

        }

    }
}
