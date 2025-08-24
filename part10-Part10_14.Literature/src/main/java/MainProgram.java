
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        while (true) {

            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");

            int ageRecommendation = 0;
            try {
                ageRecommendation = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: make sure to input a number");
                ;
            }

            if (ageRecommendation < 0) {
                ageRecommendation = 0;
            }





            bookManager.addBook(new Book(name, ageRecommendation));

        }



        Book book1 = new Book("The Ringing Lullaby Book", 0);
        Book book2 = new Book("The Exiting Transpotation Vehicles", 0);
        Book book3 = new Book("The Snowy Forest Calls", 12);
        Book book4 = new Book("Litmanen 10", 10);
        Book book5 = new Book("Adventures in Coding", 8);
        Book book6 = new Book("Zen and the Art of Programming", 12);
        Book book7 = new Book("Basics of Java", 8);
        Book book8 = new Book("A Tale of Two Cities", 10);
        Book book9 = new Book("The Hidden Forest", 0);
        Book book10 = new Book("Creative Thinking", 8);

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);
        bookManager.addBook(book4);
        bookManager.addBook(book5);
        bookManager.addBook(book6);
        bookManager.addBook(book7);
        bookManager.addBook(book8);
        bookManager.addBook(book9);
        bookManager.addBook(book10);



        System.out.println("\n" + bookManager.getNumberOfBooks() + " books in total.\n");

        System.out.println("Books:");
        bookManager.sortByAgeAndName();

    }

}
