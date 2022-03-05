package classdesign.innerclasses;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void addingOrderLineInnerClass(){
        Order order = new Order("John");

        order.addLine(new Product("Johns Knob", BigDecimal.valueOf(420.69)), 69);
        // System.out.println(order.getLines().get(0).subtotal());
        // Need to make methods within order line accessable via proxy methods
    }
}
