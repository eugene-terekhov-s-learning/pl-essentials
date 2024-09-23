package essentials.ch01;

import java.util.function.Function;

public class Report {
    public static Function<Integer, RuntimeException> listTooShort =
        n -> new IllegalArgumentException("List doesn't have %s elements".formatted(n));
}
