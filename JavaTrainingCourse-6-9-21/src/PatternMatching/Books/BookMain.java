package PatternMatching.Books;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {
    static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ArrayList<Book> books = new ArrayList<Book>();
        String fileContents = Files.readString(Path.of("src/PatternMatching/Books/books.csv"));
        String[] lines = fileContents.split("\n");
        for (String line : lines){
            String[] cols = line.split(",");
            Book book = new Book();
            book.title = cols[1];
            book.authors = cols[2].replace("-", " and ");
            book.avgRating = Double.parseDouble(cols[3]);
            book.numPages = Integer.parseInt(cols[7]);
            books.add(book);
        }

        System.out.println("What book title would you like to search: ");
        String bookTitleSearch = stdin.nextLine();
        for ( Book book : books){
            if (book.title.contains(bookTitleSearch)){
                System.out.println(book.asTableRow());
            }
        }
    }
}
