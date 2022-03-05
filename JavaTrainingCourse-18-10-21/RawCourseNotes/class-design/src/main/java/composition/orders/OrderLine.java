package composition.orders;

import composition.Product;

import java.math.BigDecimal;

// ACCESS MODIFIERS
// 1. private - member is accessible only within the class; private members are NOT inherited
// 2. <none> - member is accessible by any class in the same package (see OrderLine constructor)
// 3. protected - member is accessible by any class in the same package and subclasses in any package
// 4. public - member is accessible anywhere

public class OrderLine {

    private Product product;
    private int qty;

    // The constructor is package private so that instances cannot be created outside of the package
    // Given Order and OrderLine exist in a package together then only Orders can create OrderLines
    OrderLine(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public BigDecimal subtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(qty));
    }

    public Product getProduct() {
        return product;
    }

    public OrderLine setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getQty() {
        return qty;
    }

    public OrderLine setQty(int qty) {
        this.qty = qty;
        return this;
    }
}
