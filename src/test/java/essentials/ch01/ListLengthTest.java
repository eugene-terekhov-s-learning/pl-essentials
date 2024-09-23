package essentials.ch01;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

final class ListLengthTest {
    @Test
    void whenListIsEmpty_thenReturnsZero() {
        final ListLength<String> target = new ListLength<>(List.of());
        MatcherAssert.assertThat(
            "Should return 0 for an empty list",
            target.length(),
            Matchers.is(0)
        );
    }
}