package by.gomel.clevertec.factory;

import by.gomel.clevertec.beans.DiscountCard;
import by.gomel.clevertec.beans.DiscountReceipt;
import by.gomel.clevertec.beans.Receipt;

public class ReceiptFactory {
    public static Receipt getReceiptFromFactory(DiscountCard discountCard) {
        if (discountCard == null) {
            return new Receipt();
        } else {
            return new DiscountReceipt(discountCard);
        }
    }
}
