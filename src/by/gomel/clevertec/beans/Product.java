package by.gomel.clevertec.beans;

import static by.gomel.clevertec.utils.Constants.*;

public class Product {
    private String name;
    private Byn price;
    private int id;
    private boolean promo;

    public Product() {
    }

    public Product(int id, String name, int price, boolean promo) {
        this.id = id;
        this.name = name;
        this.price = new Byn(price);
        this.promo = true;
    }

    public Product(String name, Byn price) {
        this.name = name;
        this.price = new Byn(price);
    }

    public Product(String[] line) {
        id = Integer.parseInt(line[0]);
        name = line[1];
        price = new Byn(Integer.parseInt(line[BYN_INDEX]));
        if (line.length == PROMO_LENGTH) {
            promo = true;
        }
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public boolean isPromo() {
        return promo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }

        Product product = (Product) obj;
        return price.equals(product.price) && (name.equals(product.name));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + price.hashCode();
        return result;
    }

    public String toString() {
        return name + DELIMITER + price;
    }

    public int getId() {
        return id;
    }
}
