package by.gomel.clevertec.beans;

import static by.gomel.clevertec.utils.Constants.DELIMITER;

public class Purchase {
    private Product product;
    private int quantity;

    public Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Byn getCost() {
        return product.getPrice().mul(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product.toString() + DELIMITER + quantity + DELIMITER + getCost();
    }
}
