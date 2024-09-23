package essentials.ch01;

import java.util.function.Function;

public class Procedures {
    public static Function<ListOfValues<?>, Integer> listLength = list -> {
        final int result;
        if (list.isEmpty()) {
            result = 0;
        } else {
            ListOfValues<?> objects = list.cdr();
            result = Procedures.listLength.apply(objects) + 1;
        }
        return result;
    };
}
