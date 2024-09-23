package essentials.ch01;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

final class ListOfValuesTest {
    public static final ListOfValues<String> EMPTY_LIST = new ListOfValues<>(List.of());

    @Test
    void whenListIsEmpty_thenLengthReturnsZero() {
        MatcherAssert.assertThat(
            "Should return 0 for an empty list",
            Procedures.listLength.apply(EMPTY_LIST),
            Matchers.is(0)
        );
    }

    @Test
    void whenListHasOneElement_thenLengthShouldBeOne() {
        ListOfValues<String> strings = new ListOfValues<>(List.of("a"));
        MatcherAssert.assertThat(
            "Should return 1 for a list with one element",
            Procedures.listLength.apply(strings),
            Matchers.is(1)
        );
    }

    @Test
    void whenListIsEmpty_thenNthElementShouldThrow() {
        ListIntegerCouple couple = new ListIntegerCouple(EMPTY_LIST, 0);
        assertThatThrownBy(
            () -> Procedures.nthElement.apply(couple)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenListIsNotEmptyAndIndexIsZero_thenShouldReturnTheFirstElement() {
        final ListIntegerCouple couple = new ListIntegerCouple(
            new ListOfValues<>(List.of("a", "b", "c")),
            0
        );
        MatcherAssert.assertThat(
            "Should return the first element of the list",
            Procedures.nthElement.apply(couple),
            Matchers.is("a")
        );
    }

    @Test
    void whenListIsNotEmptyAndIndexIsGreaterThanZero_thenShouldReturnNthElement() {
        final ListIntegerCouple couple = new ListIntegerCouple(
            new ListOfValues<>(List.of("a", "b", "c")),
            2
        );
        MatcherAssert.assertThat(
            "Should return the third element of the list",
            Procedures.nthElement.apply(couple),
            Matchers.is("c")
        );
    }

    @Test
    void whenListHasManyElements_thenLengthShouldBeComputedCorrectly() {
        ListOfValues<String> strings = new ListOfValues<>(List.of("a", "b", "c"));
        MatcherAssert.assertThat(
            "Should return the correct length for a list with many elements",
            Procedures.listLength.apply(strings),
            Matchers.is(3)
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
