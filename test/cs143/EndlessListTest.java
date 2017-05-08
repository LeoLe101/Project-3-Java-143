package cs143;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * J-unit for testing the EndlessList methods
 *
 * @author Phuc Hong Le
 * @version 5/5/2017
 */
public class EndlessListTest {

    //fields
    EndlessList<Integer> numList;

    public EndlessListTest() {
    }

    @Before
    public void setUp() {
        numList = new EndlessList<>();
        numList.addPrev(19);
        numList.addNext(10);
        numList.addPrev(15);
        numList.addNext(13);
    }

    /**
     * Test of addPrev method, of class EndlessList.
     */
    @Test
    public void testAddPrev() {
        numList.addPrev(1);
        numList.addPrev(2);
        assertSame(2, numList.getValue());
    }

    /**
     * Test of addNext method, of class EndlessList.
     */
    @Test
    public void testAddNext() {
        numList.addNext(1);
        numList.addNext(2);
        assertSame(2, numList.getValue());
    }

    /**
     * Test of remove method, of class EndlessList.
     */
    @Test
    public void testRemove() {
    }

    /**
     * Test of getValue method, of class EndlessList.
     */
    @Test
    public void testGetValue() {
        numList.addPrev(9);
        numList.addPrev(7);
        numList.addPrev(5);
        numList.addPrev(3);
        assertSame(9, numList.getValue());
    }

    /**
     * Test of setValue method, of class EndlessList.
     */
    @Test
    public void testSetValue() {
        numList.setValue(6);
        assertSame(6, numList.getValue());
        numList.moveToNext(7);
        numList.setValue(88);
        assertSame(88, numList.getValue());
    }

    /**
     * Test of getPrev method, of class EndlessList.
     */
    @Test
    public void testGetPrev() {
        Integer prev = numList.getPrev();
        assertSame(prev, numList.getPrev());
        Integer prev1 = numList.getPrev();
        assertSame(prev1, numList.getPrev());
    }

    /**
     * Test of getNext method, of class EndlessList.
     */
    @Test
    public void testGetNext() {
        Integer next = numList.getNext();
        assertSame(next, numList.getNext());
        Integer next1 = numList.getNext();
        assertSame(next1, numList.getNext());
    }

    /**
     * Test of moveToNext method, of class EndlessList.
     */
    @Test
    public void testMoveToNext() {
        assertSame(true, numList.moveToNext(15));
        assertSame(false, numList.moveToPrev(99));
    }

    /**
     * Test of moveToPrev method, of class EndlessList.
     */
    @Test
    public void testMoveToPrev() {
        assertSame(true, numList.moveToPrev(19));
        assertSame(false, numList.moveToPrev(99));
    }

    /**
     * Test of iterator method, of class EndlessList.
     */
    @Test
    public void testIterator() {
        
    }
}
