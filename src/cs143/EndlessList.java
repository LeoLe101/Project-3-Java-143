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
            cursor.setValue(value);
            cursor.setNext(cursor);
            cursor.setPrev(cursor);
            return;
        }
        //previous Node of the cursor is null 
        if (cursor.getPrev() == null) {
            //connecting newNode with cursor
            newNode.setNext(cursor.getPrev());
            cursor.setPrev(newNode.getNext());
            //move to next Node if it is not null
            if (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            return;
        }
        //previous Node of the cursor has a value
        if (cursor.getPrev() != null) {
            Node prevNode = cursor.getPrev();
            //connecting newNode with cursor
            cursor.setPrev(newNode.getNext());
            newNode.setNext(cursor.getPrev());
            //connecting newNode with prevNode
            prevNode.setNext(newNode.getPrev());
            newNode.setPrev(prevNode.getNext());
            //move to next Node if it is not null
            if (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
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
        //set the value as newNode
        Node newNode = new Node(value);
        //cursor Node is the first Node in the list
        if (cursor == null) {
            cursor.setValue(value);
            cursor.setNext(cursor);
            cursor.setPrev(cursor);
            return;
        }
        //next Node of the cursor is null 
        if (cursor.getNext() == null) {
            //connecting newNode with cursor
            newNode.setPrev(cursor.getNext());
            cursor.setNext(newNode.getPrev());
            //move to next Node if it is not null
            if (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            return;
        }
        //next Node of the cursor has a value
        if (cursor.getNext() != null) {
            Node nextNode = cursor.getNext();
            //connecting newNode with cursor
            cursor.setNext(newNode.getPrev());
            newNode.setPrev(cursor.getNext());
            //connecting newNode with nextNode
            nextNode.setPrev(newNode.getNext());
            newNode.setNext(nextNode.getPrev());
            //move to next Node if it is not null
            if (cursor.getNext() != null) {
                cursor = cursor.getNext();
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
        E removedValue = (E) cursor.getValue();
        //case for empty list
        if (cursor == null) {
            return null;
        }
        //case for the last value in the list
        if (cursor.getValue() != null && cursor.getNext() == null && 
                cursor.getNext() == null) {
            cursor = null;
            return removedValue;
        }
        //normal case
        Node prevNode = cursor.getPrev();
        Node nextNode = cursor.getNext();
        prevNode.setNext(nextNode.getPrev());
        nextNode.setPrev(prevNode.getNext());
        cursor = cursor.getNext();
        return removedValue;
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
        while(cursor.getValue() != value) {
            cursor = cursor.getNext();
        }
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
