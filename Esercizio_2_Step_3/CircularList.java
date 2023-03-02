package lab01.tdd_step3;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

public interface CircularList<X> {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final X element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides the next element of the list, as given by the built-in iterator.
     * @return the next element of the list, or an empty optional if the list is empty
     */
    Optional<X> next();

    /**
     * Provides the previous element of the list. Its behaviour is dual of the next() method.
     * @return the previous element into the list
     */
    Optional<X> previous();

    /**
     * Reset the position of current element back to the first one of the list.
     * Note the first one is the first added to the list.
     */
    void reset();

    /**
     * A function to decorate the built-in circular Iterator to provide a filtered iteration.
     * It calls internally the <code>{@link CircularList#next()}</code> method till an acceptable element is found.
     * If no predicate-matching element is found an empty Optional is returned (the iterator cursor will eventually return to the start element)
     *
     * @param predicate  a predicate to filter the iterator values
     * @return an empty Optional if no element respect the predicate or an Optional<X> otherwise
     */
    Optional<X> filteredNext(Predicate<X> predicate);

}
