package immutable;

import java.math.BigDecimal;
import java.util.Arrays;

// The immutable pattern is a behavioural pattern
// It is used when you want instances of a class to be non-modifiable
// Immutable instances are thread-safe
// Immutability is a key concept in functional programming
// Immutability is a key concept in big data also
// At a basic level an immutable class is one with no setter methods
// All of the fields must be immutable or must be made to be so
public class Product {

    private String name;
    private BigDecimal price;
    private String[] categories; // <!-- String[] is mutable

    public Product(String name, BigDecimal price, String[] categories) {
        this.name = name;
        this.price = price;
        this.categories = categories.clone();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String[] getCategories() {
        // We must return a copy (a deep copy) of the array
        return categories.clone();
    }
}
