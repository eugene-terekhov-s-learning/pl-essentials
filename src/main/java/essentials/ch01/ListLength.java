package essentials.ch01;

import java.util.Collection;

public final class ListLength<T> {
    private final Collection<T> list;

    public ListLength(final Collection<T> list) {
        this.list = list;
    }

    public int length() {
        final int result;
        if (this.list.isEmpty()) {
            result = 0;
        } else {
            result = Integer.MIN_VALUE;
        }
        return result;
    }
}
