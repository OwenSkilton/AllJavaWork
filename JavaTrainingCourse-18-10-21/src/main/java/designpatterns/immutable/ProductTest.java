package designpatterns.immutable;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductImmutable() {
        // Immutability applies to the object, not the variable
        // The object (right-hand side) can't be changes but the variable (left-hand side) can be changed

        String[] catergories = {"Sports","Toys"};
        var product = new Product("Bat", BigDecimal.TEN, catergories);
        product.getCatergory()[0] = "Kitchen";
        // Because String[] is not designpatterns.immutable, the contents is accessible just by using a getter
        assertEquals("Sports", product.getCatergory()[0]);
        product = null;

        // The final keyword marks the variable as being constant
        // That is, the variable cannot be reassigned. The contants of the object referenced
        final var constantProduct = new Product("Ball", BigDecimal.ONE, catergories);
        constantProduct.setName("Large ball");
        assertEquals("Large ball", constantProduct.getName());

    }

    @Test
    public void testReasonForCloningWithinConstructor(){
        String[] catergories = {"Sports","Toys"};
        var product = new Product("Bat", BigDecimal.TEN, catergories);
        catergories[0] = "kitchen";
        assertEquals("Sports", product.getCatergory()[0]);
    }
}
