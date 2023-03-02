package lab01.tdd_step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    CircularList<Integer> list;

    @BeforeEach
    void beforeEach() {
        this.list = new CircularListImpl<>();
    }



    @Test
    void testNextEmpty() {
        assertEquals(this.list.next(), Optional.empty());
    }

    @Test
    void testPreviousEmpty() {
        assertEquals(this.list.previous(), Optional.empty());
    }

    @Test
    void testNextCircular() {

        this.list.add(4);
        this.list.add(2);
        this.list.add(8);


        this.list.next();
        this.list.next();
        this.list.next();
        this.list.next();


        assertEquals(this.list.next(), Optional.of(2));
    }

    @Test
    void testPreviousCircular() {

        this.list.add(4);
        this.list.add(2);
        this.list.add(8);

        this.list.previous();


        assertEquals(this.list.previous(), Optional.of(2));
    }

    @Test
    void testNextWithPredicate() {

        this.list.add(0);
        this.list.add(1);
        this.list.add(2);


        this.list.next();
        this.list.next();
        this.list.next();

        assertEquals(this.list.next(), Optional.of(0));

        assertEquals(this.list.filteredNext(x -> x == 2), Optional.of(2));

        assertEquals(this.list.next(), Optional.of(0));

    }


    @Test
    void TestNextWithPredicateIsEmpty() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);

        assertEquals(this.list.filteredNext(x -> x > 2), Optional.empty());

        assertEquals(this.list.next(), Optional.of(0));
    }

    @Test
    void TestMultipleNextWithPredicate() {
        this.list.add(4);
        this.list.add(8);
        this.list.add(3);

        assertEquals(this.list.filteredNext(x -> x > 3), Optional.of(4));
        assertEquals(this.list.filteredNext(x -> x < 8), Optional.of(3));
        assertEquals(this.list.filteredNext(x -> x > 5), Optional.of(8));
        assertEquals(this.list.filteredNext(x -> x < 3 || x > 8), Optional.empty());
    }

}