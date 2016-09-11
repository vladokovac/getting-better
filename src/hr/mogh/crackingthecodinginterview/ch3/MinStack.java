package hr.mogh.crackingthecodinginterview.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a min-stack that keeps track of the smallest element in the stack.
 * Created by vlado on 11.9.2016.
 */
public class MinStack {

    private List<Integer> storage;

    private int minIndex;

    public MinStack() {
        storage = new ArrayList<>();
        minIndex = -1;
    }

    /**
     * A 'push' method. <br/>
     * Time complexity: <code>O(1)</code>
     *
     * @param value The value that needs to be pushed to the stack.
     */
    public void push(Integer value) {
        if (minIndex < 0 || value < storage.get(minIndex)) {
            minIndex = storage.size();
        }
        storage.add(value);
    }

    /**
     * A 'pop' method. <br/>
     * Time complexity: <code>O(n)</code>
     *
     * @return The popped value.
     */
    public Integer pop() {
        Integer value = null;
        if (storage.size() > 0) {
            int lastElementIndex = storage.size() - 1;
            value = storage.get(lastElementIndex);
            storage.remove(lastElementIndex);
            if (storage.size() == minIndex) {
                minIndex = findNewMinIndex();
            }
        }
        return value;
    }

    /**
     * Returnes the smallest value in the stack. <br/>
     * Time complexity: <code>O(1)</code>.
     *
     * @return The smallest value in the stack.
     */
    public int getMin() {
        return storage.get(minIndex);
    }

    /**
     * Searches through the stack for the smallest value.
     *
     * @return The index of the smallest value in the stack.
     */
    private int findNewMinIndex() {
        int newMinIndex = -1;
        if (storage.size() > 0) {
            int minValue = storage.get(0);
            for (int i = 0; i < storage.size(); i++) {
                int value = storage.get(i);
                if (minValue > value) {
                    minValue = value;
                    newMinIndex = i;
                }
            }
        }
        return newMinIndex;
    }
}
