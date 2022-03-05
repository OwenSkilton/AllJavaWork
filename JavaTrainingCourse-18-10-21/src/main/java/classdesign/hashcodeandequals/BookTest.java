package classdesign.hashcodeandequals;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    private Book b1 = new Book("Robin Hood", "Me", "Children's", 200);
    private Book b2 = new Book("Lord of the Rings", "J.R.R.Fucking Jaw Spinner", "Legends", 6969);
    private Book b3 = new Book("Smite manual", "Karl Marx", "Nonces", 420);

    @Test
    // Assert equals compares if the objects point to the same object reference
    // assertEquals SHOULD test for equality of content, not reference
    public void testBookEquality(){
        var book = new Book("Robin Hood", "Me", "Children's", 200);
        assertEquals(book, b1);
    }

    @Test
    public void testListOfBooksContains(){
        var books = List.of(b1,b2,b3);
        var book = new Book("Robin Hood", "Me", "Children's", 200);
        assertTrue(books.contains(book));
    }



}
