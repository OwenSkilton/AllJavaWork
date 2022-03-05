package innerclasses;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void testOrderLineInnerClass() {

        var order = new Order("Smith");

        // If OrderLine were public inside Order then we could do this...
        // var orderLine = order.new OrderLine(new Product("Bat", BigDecimal.TEN), 1);

        order.addLine(new Product("Bat", BigDecimal.TEN), 3);
        assertEquals(BigDecimal.valueOf(30), order.grandTotal());
    }
}
