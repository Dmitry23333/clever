package by.gomel.clevertec.beans;

import static by.gomel.clevertec.utils.Constants.DELIMITER;

public class PromotionProduct extends Product {
    private double promoPercent;

    public PromotionProduct() {

    }

    public PromotionProduct(String name, Byn price, double promoPercent) {
        super(name, price);
        this.promoPercent = promoPercent;
    }


    @Override
    public Byn getPrice() {
        return super.getPrice().sub(getPromoValue());
    }

    private Byn getPromoValue() {
        return super.getPrice().mul(promoPercent / 100, RoundMethod.FLOOR, 0);
    }

    public String toString() {
        return super.toString() + DELIMITER + getPrice();
    }
}
