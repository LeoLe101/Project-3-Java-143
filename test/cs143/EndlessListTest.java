package cs143;

import java.util.Iterator;
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
    Node firstNode = new Node(1, null, null);

    public EndlessListTest() {
    }

    @Before
    public void setUp() {
        numList = new EndlessList<>();
    }

    /**
     * Test of addPrev method, of class EndlessList.
     */
    @Test
    public void testAddPrev() {
        //test the first value added
        numList.addPrev(10);
        assertEquals((Integer) 10, numList.getValue());
        assertEquals((Integer) 10, numList.getPrev());
        assertEquals((Integer) 10, numList.getNext());
        //test the list when adding previous position
        numList.addPrev(2);
        numList.addPrev(7);
        assertEquals((Integer) 10, numList.getPrev());
        numList.getNext();
        assertEquals((Integer) 7, numList.getValue());
        numList.addPrev(9);
        assertEquals((Integer) 9, numList.getValue());
        assertSame("Add Prev will be: ", 9, numList.getValue());
    }

    /**
     * Test of addNext method, of class EndlessList.
     */
    @Test
    public void testAddNext() {
        //test the first value added
        numList.addNext(1);
        assertEquals((Integer) 1, numList.getValue());
        assertEquals((Integer) 1, numList.getPrev());
        assertSame("first value prevNode will be it self: ",
                1, numList.getValue());
        assertEquals((Integer) 1, numList.getNext());
        assertSame("first value nextNode will be it self: ",
                1, numList.getValue());
        //test the list when adding next position
        numList.addNext(2);
        numList.addNext(7);
        assertEquals((Integer) 2, numList.getPrev());
        numList.getNext();
        assertEquals((Integer) 7, numList.getValue());
        numList.addNext(9);
        assertEquals((Integer) 9, numList.getValue());
        assertSame("Add Next will be: ", 9, numList.getValue());
    }

    /**
     * Test of remove method, of class EndlessList.
     */
    @Test
    public void testRemove() {
        //check if the list is empty
        assertTrue(numList.remove() == null);
        assertFalse(numList.remove() != null);
        //check for proper removal
        numList.addNext(1);
        assertTrue(numList.remove() == 1);
        numList.addNext(2);
        numList.addNext(3);
        numList.addNext(4);
        assertSame(4, numList.remove());
        //check the current Node
        assertTrue(numList.getValue() == 2);
        //check if removed
        assertFalse(numList.getPrev() == 4);
    }

    /**
     * Test of getValue method, of class EndlessList.
     */
    @Test
    public void testGetValue() {
        //check for null list
        assertNull(numList.getValue());
        //check if get the proper value
        numList.addPrev(9);
        numList.addPrev(7);
        assertEquals((Integer) 7, numList.getValue());
        numList.addPrev(5);
        assertFalse(numList.getValue() == 9);
        assertTrue(numList.getValue() == 5);
        numList.addPrev(3);
        assertSame(3, numList.getValue());
    }

    /**
     * Test of setValue method, of class EndlessList.
     */
    @Test
    public void testSetValue() {
        //check for empty list
        assertFalse(numList.setValue(5) == true);
        assertTrue(numList.setValue(5) == false);
        //check if set properly
        numList.addNext(1);
        numList.addNext(6);
        //before set value
        assertEquals((Integer) 6, numList.getValue());
        //check after set and check if succeed or not
        assertTrue(numList.setValue(55) == true);
        assertEquals((Integer) 55, numList.getValue());
        //check befor and after set a value
        numList.addNext(15);
        assertEquals((Integer) 15, numList.getValue());
        numList.setValue(65);
        assertSame(true, numList.setValue(65));
        assertEquals((Integer) 65, numList.getValue());
    }

    /**
     * Test of getPrev method, of class EndlessList.
     */
    @Test
    public void testGetPrev() {
        //check when the list is empty
        assertNull(numList.getPrev());
        //check if get previous value and move properly
        numList.addNext(1);
        assertEquals((Integer) 1, numList.getPrev());
        numList.addNext(5);
        assertEquals((Integer) 1, numList.getPrev());
        numList.addNext(9);
        numList.addNext(25);
        assertTrue(numList.getPrev() == 9);
        assertEquals((Integer) 1, numList.getPrev());
    }

    /**
     * Test of getNext method, of class EndlessList.
     */
    @Test
    public void testGetNext() {
        //check when the list is empty
        assertNull(numList.getNext());
        //check if get next value and move properly
        numList.addNext(1);
        assertEquals((Integer) 1, numList.getNext());
        numList.addNext(5);
        assertEquals((Integer) 1, numList.getNext());
        numList.addNext(9);
        numList.addNext(25);
        assertTrue(numList.getNext() == 5);
        assertEquals((Integer) 1, numList.getNext());
    }

    /**
     * Test of moveToNext method, of class EndlessList.
     */
    @Test
    public void testMoveToNext() {
        //check if the list move to next properly
        numList.addNext(5);
        numList.addNext(33);
        //check if 
        assertTrue(numList.moveToNext(5));
        assertTrue(numList.getValue() == 5);
        assertFalse(numList.getValue() != 5);
        numList.addNext(46);
        numList.addNext(59);
        assertTrue(numList.moveToNext(46));
        assertEquals((Integer) 46, numList.getValue());
        numList.addNext(45);
        numList.moveToNext(99);
        assertFalse(numList.moveToNext(99));
    }

    /**
     * Test of moveToPrev method, of class EndlessList.
     */
    @Test
    public void testMoveToPrev() {
        //check if the list move to next properly
        numList.addNext(5);
        numList.addNext(33);
        //check if 
        assertTrue(numList.moveToPrev(5));
        assertTrue(numList.getValue() == 5);
        assertFalse(numList.getValue() != 5);
        numList.addNext(46);
        numList.addNext(59);
        assertTrue(numList.moveToPrev(46));
        assertEquals((Integer) 46, numList.getValue());
        numList.addNext(45);
        numList.moveToPrev(99);
        assertFalse(numList.moveToPrev(99));
    }

    /**
     * Test of iterator method, of class EndlessList.
     */
    @Test
    public void testIterator() {
        Iterator itr = numList.iterator();
        assertFalse(itr.hasNext());
        assertNull(itr.next());
        numList.addNext(34);
        Iterator itr1 = numList.iterator();
        assertFalse(itr1.hasNext());
        itr1.remove();
        assertTrue(itr1.next() == null);
        numList.addNext(69);
        numList.addNext(53);
        numList.moveToPrev(69);
        Iterator itr2 = numList.iterator();
        itr2.next();
        if (itr2.hasNext()) {
            itr2.remove();
        }
        assertFalse(itr2.hasNext());
    }
}
