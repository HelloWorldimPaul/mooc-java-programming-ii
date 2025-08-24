import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BookManager {

    List<Book> bookManager;

    public BookManager() {

        this.bookManager = new ArrayList<>();
    }

    public void addBook(Book book) {

        this.bookManager.add(book);
    }

    public void printBooks() {

        this.bookManager.forEach(System.out::println);
    }

    public void sortByAgeAndName() {

        this.bookManager.stream().sorted().forEach(System.out::println);

    }

    public int getNumberOfBooks(){

        return this.bookManager.size();
    }
}
