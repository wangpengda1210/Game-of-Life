import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        long result = 1;

        if (x == y) {
            return x;
        }

        for (long i = x; i <= y; i++) {
            result *= i;
        }

        return result;
    };

}