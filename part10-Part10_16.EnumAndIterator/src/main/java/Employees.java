import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees() {

    this.employees = new ArrayList<>();

    }

    public void add(Person personToAdd) {

        this.employees.add(personToAdd);

    }

    public void add(List<Person> peopleToAdd) {

        this.employees.addAll(peopleToAdd);

    }

    public void print() {

        for(Person employee : this.employees){

            System.out.println(employee);
        }

    }

    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()) {

            Person currentEmployee = iterator.next();

            if (currentEmployee.getEducation() == education) {
                System.out.println(currentEmployee);
            }

        }
    }

    public void fire(Education education) {

        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()) {

            Person currentEmployee = iterator.next();

            if (currentEmployee.getEducation() == education) {

                iterator.remove();
            }

        }

    }

}
