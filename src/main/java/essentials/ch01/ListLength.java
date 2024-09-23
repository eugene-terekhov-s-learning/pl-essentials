package essentials.ch01;

import java.util.Collection;

public class ListLength<T> {
    private final Collection<T> list;

    public ListLength(Collection<T> list) {
        this.list = list;
    }

    public int length() {
        return Integer.MIN_VALUE;
    }
}
