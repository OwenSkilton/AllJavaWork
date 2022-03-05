package hashcodeandequals;

import java.util.Objects;

// Every class inherits from Object unless specified otherwise
// Our Book class inherits methods from Object incl. hashCode and equals
// The default impl. of equals is to test for equality using ==
// hashCode and equals MUST be overridden together as they are used together by hashing collections, e.g. HashMap, HashSet
// Technically map keys and set values should be immutable to prevent buggy behaviour
// The fields you choose for hashCode and equals should be those fields that determine uniqueness from a business logic perspective
// It is never appropriate to use a DB generated ID for hashCode and equals - every object will be unique
public class Book {

    private String title;
    private String author;
    private String category;
    private int numPages;

    public Book(String title, String author, String category, int numPages) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.numPages = numPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor());
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Book setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getNumPages() {
        return numPages;
    }

    public Book setNumPages(int numPages) {
        this.numPages = numPages;
        return this;
    }
}
