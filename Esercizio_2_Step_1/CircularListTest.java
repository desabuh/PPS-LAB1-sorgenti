package lab01.tdd;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList list;


    @BeforeEach
    void beforeEach() {
        list = new CircularListImpl();
    }

    @Test
    void testAddElement() {
        list.add(0);

        assertFalse(list.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(0);

        assertFalse(list.isEmpty());
    }

    @Test
    void testSize() {
        list.add(0);
        list.add(1);

        assertTrue(list.size() == 2);
    }

    @Test
    void testNext() {
        list.add(0);
        list.add(1);
        list.next();

        assertEquals(list.next().get(), 1);
    }

    @Test
    void testPrevious() {
        list.add(0);
        list.add(1);
        list.next();

        assertEquals(list.previous().get(), 0);
    }

    @Test
    void testReset() {
        list.add(0);
        list.add(1);
        list.next();
        list.reset();

        assertEquals(list.next().get(), 0);
    }

    @Test
    void testCircularNext() {
        list.add(0);
        list.add(1);
        list.add(2);

        list.next();
        list.next();
        list.next();

        assertEquals(list.next().get(), 0);
    }

    @Test
    void testCircularPrevious() {

        list.add(0);
        list.add(1);
        list.add(2);

        list.previous();

        assertEquals(list.previous().get(), 1);

    }



}
