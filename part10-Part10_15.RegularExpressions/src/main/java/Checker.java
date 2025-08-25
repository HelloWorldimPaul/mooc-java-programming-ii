import java.util.Objects;

public class Checker {


    public boolean isDayOfWeek(String string) {

        return string.matches("(?i)mon|tue|wed|thu|fri|sat|sun");
    }

    public boolean allVowels(String string) {

        return string.matches("(?i)[aeiou]+");
    }

    public boolean timeOfDay(String string) {

        return string.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$");
    }
}
