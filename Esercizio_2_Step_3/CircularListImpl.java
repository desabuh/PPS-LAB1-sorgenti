package lab01.tdd_step3;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CircularListImpl<X> implements CircularList<X> {

    private List<X> list;
    private ListIterator<X> iterator;


    public CircularListImpl() {
        this.list = new LinkedList<>();
        this.iterator = list.listIterator();
    }

    @Override
    public void add(final X element) {
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
    public Optional<X> next() {
        if(this.isEmpty()) {
            return Optional.empty();
        }
        if(!this.iterator.hasNext()) {
            this.reset();
        }
        return Optional.of(this.iterator.next());
    }

    @Override
    public Optional<X> previous() {
        if(this.isEmpty()) {
            return Optional.empty();
        }
        if(!this.iterator.hasPrevious()) {
            this.iterator = this.list.listIterator(this.size());
        }
        return Optional.of(this.iterator.previous());
    }

    @Override
    public void reset() {
        this.iterator = this.list.listIterator();
    }

    @Override
    public Optional<X> filteredNext(final Predicate<X> predicate) {
        return Stream.generate(this::next)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .limit(this.size())
                .filter(predicate)
                .findFirst();
    }


}
