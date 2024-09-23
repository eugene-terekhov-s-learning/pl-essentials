package essentials.ch01;

import java.util.Collection;

public final class ListOfValues<T> extends AbstractList<T> {

    public ListOfValues(final Collection<T> list) {
        super(list);
    }

    public int length() {
        final int result;
        if (this.list.isEmpty()) {
            result = 0;
        } else {
            result = this.cdr().length() + 1;
        }
        return result;
    }

    public ListOfValues<T> cdr() {
        return new ListOfValues<>(this.list.stream().skip(1).toList());
    }

}
