import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Enter a string: ");
        //String day = scanner.nextLine();

        String day = "tue";
        System.out.println(checker.isDayOfWeek(day));

        String vowel = "oi";
        System.out.println(checker.allVowels(vowel));

        String time = "17:23:05";
        String time2 = "24:41:16";

        System.out.println(checker.timeOfDay(time));
        System.out.println(checker.timeOfDay(time2));


        /*

        if(checker.isDayOfWeek(day)){

            System.out.println("The form is correct.");
        }else{

            System.out.println("The form is incorrect.");
        }

         */

    }

}
