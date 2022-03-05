package immutable;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductIsImmutable() {
        // Immutability applies to the object, not the variable
        // The object can't be changed but the variable can
        var categories = new String[] {"Sports", "Toys"};
        var product = new Product("Bat", BigDecimal.TEN, categories);
        product.getCategories()[0] = "Kitchenware";
        categories[0] = "Kitchenware";
        assertEquals("Sports", product.getCategories()[0]);
        assertEquals("Toys", product.getCategories()[1]);
        product = null;

        // The final keyword marks the variable as being constant
        // That is, the variable cannot be reassigned
        final var constantProduct = new Product("Ball", BigDecimal.ONE, categories);
        // constantProduct = null;
    }
}
