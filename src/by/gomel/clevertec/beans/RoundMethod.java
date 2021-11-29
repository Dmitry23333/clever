package by.gomel.clevertec.beans;

public enum RoundMethod {

    FLOOR {
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    CEIL {
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    },
    ROUND {
        double roundFunction(double d) {
            return Math.round(d);
        }
    };

    abstract double roundFunction(double value);

    int round(double roundedValue, int d) {
        int tenPow = pow(d);
        return (int) roundFunction(roundedValue / tenPow) * tenPow;
    }

    private static int pow(int d) {
        int result = 1;
        for (int i = 1; i <= d; i++) {
            result *= 10;
        }
        return result;
    }
}
