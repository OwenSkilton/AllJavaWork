package hashcodeandequals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    private Book b1 = new Book("Robin Hood", "Unknown", "Children's", 200);
    private Book b2 = new Book("Aesop's Fables", "Aesop", "Children's", 200);
    private Book b3 = new Book("Wind in the Willows", "Kenneth Grahame", "Children's", 200);

    @Test
    public void testBookEquality() {
        var book = new Book("Robin Hood", "Unknown", "Children's", 200);
        // assertEquals SHOULD test for equality of content, not of ref
        // The default impl. of equals as inherited from Object uses == and is therefore of no value
        assertEquals(book, b1);
    }

    @Test
    public void testListOfBooksContains() {
        var books = List.of(b1, b2, b3);
        var book = new Book("Robin Hood", "Unknown", "Children's", 200);
        assertTrue(books.contains(book));
    }

    @Test
    public void testSetOfBooks() {
        var book = new Book("Robin Hood", "Unknown", "Children's", 200);
        var uniqueBooks = new HashSet<Book>();
        uniqueBooks.add(b1);
        uniqueBooks.add(b2);
        uniqueBooks.add(b3);
        uniqueBooks.add(book);
        assertEquals(3, uniqueBooks.size());
    }

    @Test
    public void testMapOfBooks() {
        var book = new Book("Robin Hood", "Unknown", "Children's", 200);
        var bookMap = new HashMap<Book, Integer>();
        bookMap.put(b1, b1.getNumPages());
        bookMap.put(b2, b2.getNumPages());
        bookMap.put(b3, b3.getNumPages());
        assertEquals(200, bookMap.get(book));
    }
}
