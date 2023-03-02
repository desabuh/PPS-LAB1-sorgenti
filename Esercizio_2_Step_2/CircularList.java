package lab01.tdd_step2;

import java.util.Iterator;

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
     *
     * @return a new forward circular iterator
     */
    Iterator<X> forwardIterator();

    /**
     *
     * @return a new backward circular iterator
     */
    Iterator<X> backwardIterator();

}
