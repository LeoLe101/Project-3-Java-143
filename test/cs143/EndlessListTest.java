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
    EndlessList<String> strList;
    
    public EndlessListTest() {
    }
    
    @Before
    public void setUp() {
        numList = new EndlessList<>();
        strList = new EndlessList<>();
    }

    /**
     * Test of addPrev method, of class EndlessList.
     */
    @Test
    public void testAddPrev() {
        numList.addPrev(9);
        numList.addPrev(7);
        numList.addPrev(5);
        numList.addPrev(3);
        assertSame(numList.toString(), 7539);
    }

    /**
     * Test of addNext method, of class EndlessList.
     */
    @Test
    public void testAddNext() {
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
        strList.addNext("Hi");
        strList.addNext("Look!");
        strList.addNext("Goodnight");
        strList.addNext("Kool");
        assertSame(9, numList.getValue()); 
        assertSame("Kool", strList.getValue()); 
    }

    /**
     * Test of setValue method, of class EndlessList.
     */
    @Test
    public void testSetValue() {
    }

    /**
     * Test of getPrev method, of class EndlessList.
     */
    @Test
    public void testGetPrev() {
    }

    /**
     * Test of getNext method, of class EndlessList.
     */
    @Test
    public void testGetNext() {
    }

    /**
     * Test of moveToNext method, of class EndlessList.
     */
    @Test
    public void testMoveToNext() {
    }

    /**
     * Test of moveToPrev method, of class EndlessList.
     */
    @Test
    public void testMoveToPrev() {
    }

    /**
     * Test of iterator method, of class EndlessList.
     */
    @Test
    public void testIterator() {
    }
    
}
