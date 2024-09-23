package essentials.ch01;

import java.util.function.Function;

public class Procedures {
    public static Function<ListOfValues<?>, Integer> listLength = list -> {
        if (list.isEmpty()) {
            return 0;
        } else {
            return Procedures.listLength.apply(list.cdr()) + 1;
        }
    };

    public static Function<ListIntegerCouple, ?> nthElement = couple -> {
        final ListOfValues<?> lst = couple.list();
        final Integer n = couple.integer();

        if (Procedures.listLength.apply(lst) <= n) {
            throw Report.listTooShort.apply(n);
        } else {
            if (n == 0) {
                return lst.car();
            } else {
                return Procedures.nthElement.apply(
                    new ListIntegerCouple(
                        lst.cdr(),
                        n - 1
                    )
                );
            }
        }
    };
}
