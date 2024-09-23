package essentials.ch01;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

final class ListOfValuesTest {
    public static final ListOfValues<String> EMPTY_LIST = new ListOfValues<>(List.of());

    @Test
    void whenListIsEmpty_thenReturnsZero() {
        MatcherAssert.assertThat(
            "Should return 0 for an empty list",
            EMPTY_LIST.length(),
            Matchers.is(0)
        );
    }

    @Test
    void whenListIsEmpty_thenItsCdrIsEmpty() {
        MatcherAssert.assertThat(
            "Should return an empty list for cdr of an empty list",
            EMPTY_LIST.cdr().isEmpty(),
            Matchers.is(true)
        );
    }

    @Test
    void whenListIsNotEmpty_thenItsCdrContainsAllElementsExceptTheFirst() {
        final ListOfValues<String> list = new ListOfValues<>(List.of("a", "b", "c"));
        MatcherAssert.assertThat(
            "Should return a list without the first element",
            list.cdr(),
            Matchers.contains("b", "c")
        );
    }
}
