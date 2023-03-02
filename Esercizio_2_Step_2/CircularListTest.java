package lab01.tdd_step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    CircularList<Integer> list;

    @BeforeEach
    void beforeEach() {
        this.list = new CircularListImpl<>();
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
    void testForwardCircularIterate() {
        list.add(4);
        list.add(3);
        list.add(8);

        Iterator<Integer> iterator = list.forwardIterator();
        iterator.next();
        iterator.next();
        iterator.next();


        assertEquals(iterator.next(), 4);
    }

    @Test
    void testBackWardCircularIterate() {
        list.add(4);
        list.add(3);
        list.add(8);

        Iterator<Integer> iterator = list.backwardIterator();
        iterator.next();


        assertEquals(iterator.next(), 3);
    }



}