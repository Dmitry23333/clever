package by.gomel.clevertec.beans;

import static by.gomel.clevertec.utils.Constants.BYN_FORMAT;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn) {
        this.value = byn.value;
    }

    public int getRubs() {
        return value / 100;
    }

    public int getCoins() {
        return value % 100;
    }

    public Byn add(Byn x) {
        return new Byn(x.value + value);
    }

    public Byn sub(Byn x) {
        return new Byn(value - x.value);
    }

    public Byn mul(int x) {
        return new Byn(value * x);
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value, d));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Byn byn = (Byn) obj;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return String.format(BYN_FORMAT, getRubs(), getCoins());
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
