package hr.mogh.crackingthecodinginterview.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Solve the following problem:
 * <p>
 * <code>Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one
 * additional stack to hold items, but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek and isEmpty.</code>
 * <p>
 * Created by vlado on 16/10/2016.
 */
public class SortedStack<T extends Comparable> {

    private Stack<T> storage;
    private List<T> helperStorage;

    public SortedStack() {
        storage = new Stack<T>();
        helperStorage = new ArrayList<T>();
    }

    /**
     * Push operation.
     * Time complexity: <code>O(n)</code>.<br/>
     * Space complexity: <code>O(n)</code>.
     *
     * @param value The new value.
     */
    public void push(T value) {
        helperStorage = new ArrayList<T>();
        if (storage.size() > 0) {

            T poppedValue = null;
            while (storage.size() > 0 && storage.peek().compareTo(value) > 0) {
                poppedValue = storage.pop();
                helperStorage.add(poppedValue);
            }
        }

        storage.push(value);

        if (helperStorage.size() > 0) {
            for (int i = helperStorage.size() - 1; i >= 0; i--) {
                storage.push(helperStorage.get(i));
            }
        }
    }

    /**
     * A pop operation.
     * Time complexity:<code>O(1)</code>.<br/>
     *
     * @return The popped value.
     */
    public T pop() {
        return storage.size() > 0 ? storage.pop() : null;
    }

    /**
     * Check if stack is empty.
     *
     * @return True if size() == 0.
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public T peek() {
        return storage.size() > 0 ? storage.peek() : null;
    }
}
