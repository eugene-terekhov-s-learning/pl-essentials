package essentials.ch01;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ListOfValues<T> implements Collection<T> {
    private final Collection<T> list;

    public ListOfValues(final Collection<T> list) {
        this.list = List.copyOf(list);
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
        final ListOfValues<T> result;
        if (this.list.isEmpty()) {
            result = new ListOfValues<>(this.list);
        } else {
            result = new ListOfValues<>(this.list.stream().skip(1).toList());
        }
        return result;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        // do nothing
    }
}
