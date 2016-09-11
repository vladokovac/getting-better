package hr.mogh.crackingthecodinginterview.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem: <p/>
 * <code>How would you design a stack which, in addition to push and pop, also has a function min which returns the
 * minimum element? Push, pop and min should all operate in O(1) time.</code><p/>
 * Created by vlado on 11.9.2016.
 */
public class FasterMinStack {

    private List<Integer> storage;
    private List<Integer> minValues;
    private int size;

    public FasterMinStack() {
        storage = new ArrayList<>();
        minValues = new ArrayList<>();
        size = 0;
    }

    /**
     * A push operation. <br/>
     * Time complexity: <code>O(1)</code>
     *
     * @param value The new value.
     */
    public void push(int value) {
        storage.add(value);
        int newMinimum = value;
        if (size > 0) {
            int minValue = minValues.get(this.size - 1);
            if (minValue < value) {
                newMinimum = minValue;
            }
        }
        minValues.add(newMinimum);
        size++;
    }

    /**
     * A pop operation. <br/>
     * Time complexity: <code>O(1)</code>
     *
     * @return The popped value.
     */
    public int pop() {
        size--;
        int value = storage.get(this.size);
        storage.remove(this.size);
        minValues.remove(this.size);
        return value;
    }

    /**
     * Returnes the smallest value in the stack. <br/>
     * Time complexity: <code>O(1)</code>.
     *
     * @return The smallest value in the stack.
     */
    public int getMin() {
        return minValues.get(this.size - 1);
    }
}
