package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        if (name != null && name.matches("^(?=\\S)(?!\\s*$).{1,40}$")) {

            if(age >= 0 && age <= 120){

                this.name = name;
                this.age = age;

            }
        } else {
           throw new IllegalArgumentException("Invalid input");
        }


    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
