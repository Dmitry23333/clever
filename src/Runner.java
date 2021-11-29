import by.gomel.clevertec.exceptions.WrongIDException;
import by.gomel.clevertec.beans.Purchase;
import by.gomel.clevertec.beans.Receipt;
import by.gomel.clevertec.factory.ReceiptFactory;
import by.gomel.clevertec.implDao.CSVDiscountImplDAO;
import by.gomel.clevertec.implDao.CSVProductImplDAO;

import static by.gomel.clevertec.utils.Constants.CARD;
import static by.gomel.clevertec.utils.Constants.REGEX;

public class Runner {
    public static void main(String[] args) {
        CSVProductImplDAO csvImplDAO = new CSVProductImplDAO();
        int idCard = 0;
        int quantity;
        int idProduct;
        int j;
        String[] discount = args[args.length - 1].split(REGEX);
        Receipt receipt;
        if (discount[0].equals(CARD)) {
            try {
                idCard = Integer.parseInt(discount[1]);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
            j = args.length - 1;
        } else {
            j = args.length;
        }
        receipt = ReceiptFactory.getReceiptFromFactory(new CSVDiscountImplDAO().getDiscountCardById(idCard, args[1]));
        for (int i = 2; i < j; i++) {
            String[] args1 = args[i].split(REGEX);
            try {
                idProduct = Integer.parseInt(args1[0]);
                quantity = Integer.parseInt(args1[1]);
                receipt.addPurchase(new Purchase(csvImplDAO.getProductById(idProduct, args[0]), quantity));
            } catch (NumberFormatException | NullPointerException | WrongIDException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(receipt.toTable());
    }
}


