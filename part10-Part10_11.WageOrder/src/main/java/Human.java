
public class Human implements Comparable<Human> {

    private int wage;
    private String name;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }


    @Override
    public String toString() {
        return name + " " + wage;
    }

    @Override
    public int compareTo(Human other) {
        
        /*

        int result = this.wage - other.wage;

        if (result < 0) {
            return 1;
        } else if (result == 0) {

            return 0;
        } else {
            return -1;
        }
        */
        
        return other.getWage() - this.getWage();

    }
}
