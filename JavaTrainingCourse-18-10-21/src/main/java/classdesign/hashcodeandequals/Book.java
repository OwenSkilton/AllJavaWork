package classdesign.hashcodeandequals;

import java.util.Objects;

// Every class inherits from Object unless specified otherwise (Same as writing "extends Object" on the end)
// Default implementation of equals is to test for equality using ==
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
