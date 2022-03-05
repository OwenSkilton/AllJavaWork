package designpatterns.immutable;

import java.math.BigDecimal;

// The designpatterns.immutable pattern is a behavioural pattern
// It is used when you want instance of a class to be non modifiable
// Immutable instances are thread-safe
// Key concept in functional programing and big data
// All the fields must be designpatterns.immutable or must be made to be so
public class Product {
    private String name;
    private BigDecimal price;
    private String[] catergory;

    public Product(String name, BigDecimal price, String[] catergory) {
        this.name = name;
        this.price = price;
        // Also want a clone here as it means that the reference to the original array once change will not change the contents of the object
        this.catergory = catergory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String[] getCatergory() {
        // Ideally return a clone:
        // return catergory.clone()
        return catergory;
    }

    public void setCatergory(String[] catergory) {
        this.catergory = catergory;
    }
}
