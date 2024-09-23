package essentials.ch01;

import java.util.function.Function;

public class Report {
    public static Function<Integer, RuntimeException> listTooShort =
        n -> new IllegalArgumentException("List too short by %s elements".formatted(n));
}
