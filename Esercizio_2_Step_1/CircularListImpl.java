package lab01.tdd;


import java.util.*;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private ListIterator<Integer> iterator;


    public CircularListImpl() {
        this.list = new LinkedList<>();
        this.iterator = list.listIterator();
    }

    @Override
    public void add(final int element) {
        this.list.add(element);
        this.iterator = list.listIterator(this.iterator.nextIndex());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(!this.iterator.hasNext()) {
            this.reset();
        }
        return Optional.of(this.iterator.next());
    }

    @Override
    public Optional<Integer> previous() {
        if(!this.iterator.hasPrevious()) {
            this.iterator = this.list.listIterator(this.size());
        }
        return Optional.of(this.iterator.previous());
    }

    @Override
    public void reset() {
        this.iterator = this.list.listIterator();
    }
}
