package by.gomel.clevertec.beans;

import by.gomel.clevertec.utils.Constants;

import java.util.Objects;

import static by.gomel.clevertec.utils.Constants.*;

public class DiscountCard {
    private int id;
    private double discountPercent;

    public DiscountCard() {
    }

    public DiscountCard(int id) {
        this.id = id;
    }

    public DiscountCard(String[] line) {
        id = Integer.parseInt(line[0]);
        discountPercent = Double.parseDouble(line[1]);
    }

    public DiscountCard(int id, int discountPercent) {
        this.id = id;
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public String toString() {
        return ID + id + DELIMITER + DISCOUNT + discountPercent + PERCENT;
    }
}
