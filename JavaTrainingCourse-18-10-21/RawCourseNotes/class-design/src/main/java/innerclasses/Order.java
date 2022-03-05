package innerclasses;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private String clientName;
    private LocalDate date;
    private ArrayList<OrderLine> lines;

    public Order(String clientName) {
        this.clientName = clientName;
        this.date = LocalDate.now();
        this.lines = new ArrayList<>();
    }

    // private inner classes are a good solution to the problem of composite HAS-A associations
    // OrderLine instances can only be created inside the Order class provided the inner class is private
    // Doing this means we don't have to worry about mocking the dependency when it comes to unit testing
    private class OrderLine {

        private Product product;
        private int qty;

        // The constructor is package private so that instances cannot be created outside of the package
        // Given Order and OrderLine exist in a package together then only Orders can create OrderLines
        public OrderLine(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }

        public BigDecimal subtotal() {
            return product.getPrice().multiply(BigDecimal.valueOf(qty));
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
    }

    // OrderLines cannot exist independently of Orders
    // Therefore the assoc. between Order and OrderLine is composition, not aggregation
    // Composition associations are hard to test as is inheritance
    public void addLine(Product product, int qty) {
        lines.add(new OrderLine(product, qty));
    }

    public BigDecimal grandTotal() {
        var grandTotal = BigDecimal.ZERO;
        for (var line : lines) {
            grandTotal = grandTotal.add(line.subtotal());
        }
        return grandTotal;
    }

    public String getClientName() {
        return clientName;
    }

    public Order setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Order setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public ArrayList<OrderLine> getLines() {
        return lines;
    }

    public Order setLines(ArrayList<OrderLine> lines) {
        this.lines = lines;
        return this;
    }
}
