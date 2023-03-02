package lab01.tdd_step2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;


public class CircularListImpl<X> implements CircularList<X> {

    private List<X> list;

    public CircularListImpl() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(final X element) {
        this.list.add(element);
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
    public Iterator<X> forwardIterator() {
        return this.generateIteratorFromList(0, x -> x == this.size() - 1 ? 0 : x + 1);
    }

    @Override
    public Iterator<X> backwardIterator() {
        return this.generateIteratorFromList(this.size() - 1, x -> x == 0 ? this.size() - 1 : x - 1);
    }

    private Iterator<X> generateIteratorFromList(final int startIndex, final IntUnaryOperator indexOperation) {
        return IntStream.iterate(startIndex, indexOperation)
                .mapToObj(this.list::get)
                .iterator();
    }

}
