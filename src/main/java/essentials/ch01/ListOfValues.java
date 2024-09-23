package essentials.ch01;

import java.util.Collection;

public final class ListOfValues<T> extends AbstractList<T> {

    public ListOfValues(final Collection<T> list) {
        super(list);
    }

    public ListOfValues<T> cdr() {
        return new ListOfValues<>(this.list.stream().skip(1).toList());
    }

    public T car() {
        return this.list.stream().findFirst().orElseThrow();
    }
}
