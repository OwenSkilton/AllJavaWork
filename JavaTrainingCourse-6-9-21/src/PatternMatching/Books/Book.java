package PatternMatching.Books;

public class Book {
    public String title;
    public String authors;
    public double avgRating;
    public int numPages;

    public String asTableRow(){
        return String.format("%-50s %-50s %4.2f %4d", truncateTo50Char(title), truncateTo50Char(authors), avgRating, numPages);
    }

    public String truncateTo50Char(String truncate){
        if (truncate.length() < 50){
            return truncate;
        } else {
            return truncate.substring(0,47).concat("...");
        }
    }
}
