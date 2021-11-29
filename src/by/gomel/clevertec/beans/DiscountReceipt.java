package by.gomel.clevertec.beans;

import java.util.List;

import static by.gomel.clevertec.utils.Constants.DISCOUNT;
import static by.gomel.clevertec.utils.Constants.DISCOUNT_CARD;

public class DiscountReceipt extends Receipt {
    private DiscountCard discountCard;
    private double discountPercent;

    public DiscountReceipt(DiscountCard discountCard) {
        super();
        this.discountCard = discountCard;
    }

    public DiscountReceipt(List<Purchase> purchasesList, DiscountCard discountCard) {
        super(purchasesList);
        this.discountCard = discountCard;
    }

    @Override
    public Byn getTotalCost() {
        return super.getTotalCost().mul(1 - discountCard.getDiscountPercent() / 100, RoundMethod.FLOOR, 0);
    }

    private Byn getDiscount() {
        return super.getTotalCost().sub(getTotalCost());
    }

    @Override
    public String toTable() {
        return super.toTable() + DISCOUNT_CARD + discountCard.toString() + "\n" + DISCOUNT + getDiscount();
    }
}
