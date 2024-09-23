package essentials.ch01;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

final class ListLengthTest {
    public static final ListLength<String> EMPTY_LIST = new ListLength<>(List.of());

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
            "",
            EMPTY_LIST.cdr().isEmpty(),
            Matchers.is(true)
        );
    }
}
