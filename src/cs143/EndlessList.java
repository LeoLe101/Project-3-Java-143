package cs143;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This data class represents an ordered collection in an endless circular list.
 *
 * @param <E> the type of values stored in the list
 * @author Phuc Hong Le
 * @author
 * @author
 * @author
 * @version 5/5/2017
 */
public class EndlessList<E> implements Iterable<E> {

    //fields
    private Node cursor; //this is the current Node

    /**
     * default constructor
     */
    public EndlessList() {
    }

    /**
     * Adds a value before the current one and moves the cursor to the new
     * value. If the list is empty the value is simply added and becomes the
     * current one.
     *
     * @param value the value to add to the list
     */
    public void addPrev(E value) {
        //set the value as newNode
        Node newNode = new Node(value);
        //cursor Node is the first Node in the list
        if (cursor == null) {
            cursor = newNode;
            cursor.setNext(cursor);
            cursor.setPrev(cursor);
            return;
        }
        //previous Node of the cursor has a value
        Node prevNode = cursor.getPrev();
        //connecting newNode with cursor
        cursor.setPrev(newNode);
        newNode.setNext(cursor);
        //connecting newNode with prevNode
        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);
        //move to the new Node
        cursor = newNode;

    }

    /**
     * Adds a value after the current one and moves the cursor to the new value.
     * If the list is empty the value is simply added and becomes the current
     * one.
     *
     * @param value the value to add to the list
     */
    public void addNext(E value) {
        //set the value as newNode
        Node newNode = new Node(value);
        //cursor Node is the first Node in the list
        if (cursor == null) {
            cursor = newNode;
            cursor.setNext(cursor);
            cursor.setPrev(cursor);
            return;
        }
        //next Node of the cursor has a value
        Node nextNode = cursor.getNext();
        //connecting newNode with cursor
        cursor.setNext(newNode);
        newNode.setPrev(cursor);
        //connecting newNode with nextNode
        nextNode.setPrev(newNode);
        newNode.setNext(nextNode);
        //move to the new Node 
        cursor = newNode;
    }

    /**
     * Removes the current value from the list and moves the cursor to the next
     * value, returning the removed value. Returns a null if the list is empty.
     * If this is the last value in the list the cursor becomes null.
     *
     * @return the value removed
     */
    public E remove() {
        //case for empty list
        if (cursor == null) {
            return null;
        }
        //case for the last value in the list
        E removedNode = (E) cursor.getValue();
        if (cursor.getNext() == cursor && cursor.getPrev() == cursor) {
            cursor = null;
            return removedNode;
        }
        //normal case
        Node prevNode = cursor.getPrev();
        Node nextNode = cursor.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        cursor = nextNode;
        return removedNode;
    }

    /**
     * Returns the value at the current cursor position. Returns a null if the
     * list is empty.
     *
     * @return the value
     */
    public E getValue() {
        //condition to check if the list is empty or not
        if (cursor != null) {
            return (E) cursor.getValue();
        }
        return null;
    }

    /**
     * Changes the current value at the current cursor position. Returns false
     * if the list is empty and true if the change is made.
     *
     * @param value the new value
     * @return true if successful, false if not
     */
    public boolean setValue(E value) {
        boolean done = false;
        //condition to check if the list is empty or not
        if (cursor != null) {
            cursor.setValue(value);
            done = true;
        }
        return done;
    }

    /**
     * Moves the cursor to the previous value in the list and returns that
     * value. Returns a null if the list is empty.
     *
     * @return the value
     */
    public E getPrev() {
        //condition to check if the list is empty or not
        if (cursor != null) {
            cursor = cursor.getPrev();
            return (E) cursor.getValue();
        }
        return null;
    }

    /**
     * Moves the cursor to the next value in the list and returns that value.
     * Returns null if the list is empty.
     *
     * @return the value
     */
    public E getNext() {
        //condition to check if the list is empty or not
        if (cursor != null) {
            cursor = cursor.getNext();
            return (E) cursor.getValue();
        }
        return null;
    }

    /**
     * Moves the cursor to the next occurrence of the given value, moving
     * forward in the list. If the value is not found the cursor remains at the
     * same position in the list.
     *
     * @param value the value to search for
     * @return true if the value is found, false if not
     */
    public boolean moveToNext(E value) {
        boolean done = false;
        Node currentNode = cursor;
        while (!done) {
            cursor = cursor.getNext();
            if (cursor.getValue().equals(value)) {
                done = true;
            }
            if (cursor == currentNode) {
                return done;
            }
        }
        return done;
    }

    /**
     * Moves the cursor to the next occurrence of the given value, moving
     * backwards in the list. If the value is not found the cursor remains at
     * the same position in the list.
     *
     * @param value the value to search for
     * @return true if the value is found, false if not
     */
    public boolean moveToPrev(E value) {
        boolean done = false;
        Node currentNode = cursor;
        while (!done) {
            cursor = cursor.getPrev();
            if (cursor.getValue().equals(value)) {
                done = true;
            }
            if (cursor == currentNode) {
                return done;
            }
        }
        return done;
    }

    /**
     * Provides and EndlessList iterator.
     *
     * @return the iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new EndlessListIterator();
    }

    /**
     * Private class used to create an EndlessList iterator.
     */
    private class EndlessListIterator implements Iterator<E> {

        //fields
        private final Node START = cursor;
        private boolean handledStart = false;

        /**
         * Reports if the current node has not been reported yet by calling
         * next(). Returns false if the list is empty.
         *
         * @return true if the current node has not been reported, false if it
         * has
         */
        @Override
        public boolean hasNext() {
            //case if the list is empty
            if (cursor == null) {
                return handledStart;
            }
            //case that Node has yet been reported
            if (cursor.getValue() != next() && cursor == START) {
                handledStart = true;
                return handledStart;
            }

            //case that it has been reported
            return handledStart;
        }

        /**
         * Returns the current value in the list and moves to the next.
         *
         * @return the current value, or null if the list is empty
         */
        @Override
        public E next() {
            //case if the list is empty
            if (cursor == null) {
                return null;
            }
            Node currentNode = cursor;
            cursor = cursor.getNext();
            return (E) currentNode.getValue();
        }

        /**
         * Removes the last value returned from next(). This assumes that next
         * is called before each remove. If this is the only value in the list
         * the cursor becomes null.
         */
        @Override
        public void remove() {
            //case if the list only has this value
            if (cursor.getNext() == cursor && cursor.getPrev() == cursor) {
                cursor = null;
            } else {
                Node prev = cursor.getPrev().getPrev();
                //remove the last returned value from next()
                prev.setNext(cursor);
                cursor.setPrev(prev);
            }
        }
    }
}
