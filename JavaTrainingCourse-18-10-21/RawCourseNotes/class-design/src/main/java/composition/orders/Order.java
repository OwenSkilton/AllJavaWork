package composition.orders;

import composition.Product;

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
