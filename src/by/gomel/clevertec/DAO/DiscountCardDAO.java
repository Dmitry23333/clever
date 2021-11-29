package by.gomel.clevertec.DAO;

import by.gomel.clevertec.exceptions.WrongIDException;
import by.gomel.clevertec.beans.DiscountCard;

public interface DiscountCardDAO {
    public DiscountCard getDiscountCardById(int id, String fileName);
}
