import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


class Operator {

    public static UnaryOperator<List<String>> unaryOperator = x -> {
        List<String> list = new ArrayList<String>();
        for (String item : x) {
            if (!list.contains(item)) {
                list.add(item);
            }
        }

        return list;
    };

}