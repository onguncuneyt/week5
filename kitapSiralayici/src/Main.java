import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Book> titleSet = new TreeSet<>();

        titleSet.add(new Book("Kitap 1", 400, "John", "2022-01-01"));
        titleSet.add(new Book("Kitap 2", 300, "Jane", "2022-02-15"));
        titleSet.add(new Book("Kitap 3", 350, "Bob ", "2021-12-10"));
        titleSet.add(new Book("Kitap 4", 500, "Alice", "2022-03-20"));
        titleSet.add(new Book("Kitap 5", 250, "David", "2022-04-05"));

        System.out.println("Books sorted by title (A-Z):");
        for (Book book : titleSet) {
            System.out.println(book);
        }

        // Set for sorting by page count
        Set<Book> pageCountSet = new TreeSet<>(Comparator.comparingInt(Book::getNumberOfPages).reversed());

        pageCountSet.addAll(titleSet); // Adding books from the titleSet to pageCountSet

        System.out.println("\nBooks sorted by page count:");
        for (Book book : pageCountSet) {
            System.out.println(book);
        }

    }
}