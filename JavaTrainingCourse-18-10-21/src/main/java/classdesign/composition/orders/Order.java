package classdesign.composition.orders;

import classdesign.composition.Product;

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

    public void setLines(ArrayList<OrderLine> lines) {
        this.lines = lines;
    }
}
