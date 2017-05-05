package cs143;

import java.util.HashSet;
import java.util.Iterator;

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
     * Adds a value before the current one and moves the cursor to the new
     * value. If the list is empty the value is simply added and becomes the
     * current one.
     *
     * @param value the value to add to the list
     */
    public void addPrev(E value) {
        //current Node
        Node current = cursor; //NEEDED?
        Node newNode = new Node(value);

        if (cursor != null) {
            Node prevNode = current.getPrev(); //NEEDED?
            current.setPrev(newNode);
            if (prevNode != null) {
                prevNode.setNext(newNode);
            }
            cursor = cursor.getNext();
        }
        if (cursor == null) {
            cursor = current;
        }
    }

    /**
     * Adds a value after the current one and moves the cursor to the new value.
     * If the list is empty the value is simply added and becomes the current
     * one.
     *
     * @param value the value to add to the list
     */
    public void addNext(E value) {
        //current Node
        Node current = cursor; //NEEDED?
        Node newNode = new Node(value);
        if (cursor != null) {
            Node nextNode = current.getNext(); //NEEDED?
            current.setPrev(newNode);
            if (nextNode != null) {
                nextNode.setPrev(newNode);
            }
            cursor = cursor.getNext();
            if (cursor == null) {
                cursor = current;
            }
        }
    }

    /**
     * Removes the current value from the list and moves the cursor to the next
     * value, returning the removed value. Returns a null if the list is empty.
     * If this is the last value in the list the cursor becomes null.
     *
     * @return the value removed
     */
    public E remove() {
        // TODO write method body //
        return null;
    }

    /**
     * Returns the value at the current cursor position. Returns a null if the
     * list is empty.
     *
     * @return the value
     */
    public E getValue() {
        //condition to check if the list is empty or not
        if (cursor.getValue() != null
                || cursor.getNext() != null || cursor.getPrev() != null) {
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
        if (cursor.getValue() != null
                || cursor.getNext() != null || cursor.getPrev() != null) {
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
        if (cursor.getValue() != null
                || cursor.getNext() != null || cursor.getPrev() != null) {
            cursor.getPrev();
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
        if (cursor.getValue() != null
                || cursor.getNext() != null || cursor.getPrev() != null) {
            cursor.getNext();
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
        // TODO write method body //
        return false;
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
        // TODO write method body //
        return false;
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
            // TODO write method body //
            return false;
        }

        /**
         * Returns the current value in the list and moves to the next.
         *
         * @return the current value, or null if the list is empty
         */
        @Override
        public E next() {
            // TODO write method body //
            return null;
        }

        /**
         * Removes the last value returned from next(). This assumes that next
         * is called before each remove. If this is the only value in the list
         * the cursor becomes null.
         */
        @Override
        public void remove() {
            // TODO write method body //
        }

    }

}
