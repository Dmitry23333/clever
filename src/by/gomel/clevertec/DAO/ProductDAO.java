package by.gomel.clevertec.DAO;

import by.gomel.clevertec.exceptions.WrongIDException;
import by.gomel.clevertec.beans.Product;

public interface ProductDAO  {
    public Product getProductById(int id, String filePath) throws WrongIDException;
}
