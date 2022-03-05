package classdesign.composition.orders;

import classdesign.composition.Product;

import java.math.BigDecimal;

public class OrderLine {
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
