package by.gomel.clevertec.beans;

import by.gomel.clevertec.utils.Column;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.gomel.clevertec.utils.Constants.SAVE_MSG;

public class Receipt {
    private List<Purchase> purchasesList;
    private static final Double PROMO_PERCENT = 10.0;
    private static final int QUANTITY_TO_PROMO = 5;

    public Receipt() {
        purchasesList = new ArrayList<>();
    }

    public Receipt(List<Purchase> purchasesList) {
        this.purchasesList = purchasesList;
    }

    public void addPurchase(Purchase purchase) throws NullPointerException {
        if (purchase == null) {
            throw new NullPointerException();
        }
        purchasesList.add(purchase);
    }

    private void checkPromo() throws NullPointerException {
        for (int i = 0; i < purchasesList.size(); i++) {
            if (purchasesList.get(i).getProduct().isPromo() && purchasesList.get(i).getQuantity() > QUANTITY_TO_PROMO) {
                PromotionProduct product = new PromotionProduct(purchasesList.get(i).getProduct().getName(), purchasesList.get(i).getProduct().getPrice(), PROMO_PERCENT);
                int quantity = purchasesList.get(i).getQuantity();
                purchasesList.remove(i);
                purchasesList.add(i, new Purchase(product, quantity));
            }
        }
    }

    public Byn getTotalCost() {
        Byn cost = new Byn(0);
        for (Purchase purchase : purchasesList) {
            cost = cost.add(purchase.getCost());
        }
        return cost;
    }

    public void saveReceipt(String receipt, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(receipt + "\n");
            System.out.println(SAVE_MSG);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toTable() {
        checkPromo();
        StringBuilder table = new StringBuilder();
        table.append(Column.getHeader()).append('\n');
        table.append(Column.HORIZONTAL_LINE).append('\n');
        for (Purchase purchase : purchasesList) {
            table.append(Column.getRow(purchase.toString())).append('\n');
        }
        table.append(Column.HORIZONTAL_LINE).append('\n');
        table.append(Column.getFooter(getTotalCost())).append('\n');
        return table.toString();
    }
}
