package by.gomel.clevertec.implDao;

import by.gomel.clevertec.DAO.DiscountCardDAO;
import by.gomel.clevertec.exceptions.WrongIDException;
import by.gomel.clevertec.beans.DiscountCard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gomel.clevertec.utils.Constants.*;

public class CSVDiscountImplDAO implements DiscountCardDAO {
    @Override
    public DiscountCard getDiscountCardById(int id, String fileName)  {
        DiscountCard discountCard = null;
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            sc.useLocale(Locale.ENGLISH);
            while (sc.hasNextLine()) {
                DiscountCard discountCardFromFile = new DiscountCard(sc.nextLine().split(DELIMITER));
                if (id == discountCardFromFile.getId()) {
                    discountCard = discountCardFromFile;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
        return discountCard;
    }
}
