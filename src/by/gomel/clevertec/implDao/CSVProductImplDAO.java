package by.gomel.clevertec.implDao;

import by.gomel.clevertec.DAO.ProductDAO;
import by.gomel.clevertec.exceptions.WrongIDException;
import by.gomel.clevertec.beans.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gomel.clevertec.utils.Constants.*;

public class CSVProductImplDAO implements ProductDAO {
    @Override
    public Product getProductById(int id, String filePath) throws WrongIDException {
        Product product = null;
        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            sc.useLocale(Locale.ENGLISH);
            while (sc.hasNextLine()) {
                Product productFromFile = new Product(sc.nextLine().split(DELIMITER));
                if (id == productFromFile.getId()) {
                    product = productFromFile;
                }
            }
            if (product == null) {
                throw new WrongIDException(WRONG_PRODUCTS_ID + id);
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
        return product;
    }
}
