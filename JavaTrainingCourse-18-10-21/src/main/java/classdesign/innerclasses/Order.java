package classdesign.innerclasses;

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

    // Because an orderline can not exist without an order
    // We write this association in the terms of the attributes of orderline rather than just passing in than an orderline object
    // This is a composite association and this is the way of writing a method
    // https://www.geeksforgeeks.org/association-composition-aggregation-java/
    public void addLine(Product product, int qty){
        lines.add(new OrderLine(product, qty));
    }

    public BigDecimal grandTotal(){
        var grandTotal = BigDecimal.ZERO;
        for (var order : lines){
            grandTotal = grandTotal.add(order.subtotal());
        }
        return grandTotal;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<OrderLine> getLines() {
        return lines;
    }

    // Private inner classes are a good solution to composite HAS-A associations
    // OrderLine instances can only be created within the order class

    private static class OrderLine {
        private Product product;
        private int quantity;

        // Not public as they should only be created within order (private to the package)
        // Reason why order and orderline are within their own package
        public OrderLine(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public BigDecimal subtotal(){
            return product.getPrice().multiply(BigDecimal.valueOf(quantity));
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
