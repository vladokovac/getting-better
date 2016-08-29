package hr.mogh.crackingthecodinginterview.ch3;

/**
 * Solves the following problem:<p/>
 * <code>Describe how you could use a single array to implement three stacks.</code><p/>
 * Created by vlado on 29.8.2016.
 */
public class TriStack {

    private Object[] storage;
    private int stack1MaxIndex;
    private int stack2MaxIndex;
    private int stack3MaxIndex;

    private Integer stack1Top;
    private Integer stack2Top;
    private Integer stack3Top;

    /**
     * A class with three stacks. Implemented using one array and indices.
     * @param capacity Total combined capacity of the stacks.
     * @throws IllegalArgumentException Thrown when stacks indices other than 1, 2 or 3 are used.
     */
    public TriStack(int capacity) throws IllegalArgumentException {

        if (capacity < 3) {
            throw new IllegalArgumentException("Capacity must be higher than 3 to allow for 3 stacks.");
        }
        storage = new Object[capacity];

        stack3MaxIndex = capacity;
        stack2MaxIndex = capacity - capacity / 3;
        stack1MaxIndex = stack2MaxIndex - capacity / 3;

        stack1Top = 0;
        stack2Top = stack1MaxIndex;
        stack3Top = stack2MaxIndex;
    }

    /**
     * A push implementation for the TriStack.
     * @param value The value to be stored.
     * @param stackIndex The index of the stack that will store the value.
     * @return True if storing succeeded.
     * @throws IllegalArgumentException
     */
    public boolean push(Object value, int stackIndex) throws IllegalArgumentException {
        boolean isSuccessful = false;
        switch (stackIndex) {
            case 1:
                if (stack1Top < stack1MaxIndex) {
                    storage[stack1Top++] = value;
                    isSuccessful = true;
                }
                break;
            case 2:
                if (stack2Top < stack2MaxIndex) {
                    storage[stack2Top++] = value;
                    isSuccessful = true;
                }
                break;
            case 3:
                if (stack3Top < stack3MaxIndex) {
                    storage[stack3Top++] = value;
                    isSuccessful = true;
                }
                break;
            default:
                throw new IllegalArgumentException("Index must be between 1 and 3.");
        }

        return isSuccessful;
    }

    /**
     * A push implementation for the TriStack.
     * @param stackIndex The index of the stack that the value is popped from.
     * @return The popped value, null if stack is empty.
     */
    public Object pop(int stackIndex) {
        Object value = null;

        switch (stackIndex) {
            case 1:
                if (stack1Top > 0) {
                    stack1Top--;
                    value = storage[stack1Top];
                    storage[stack1Top] = null;
                }
                break;
            case 2:
                if (stack2Top > stack1MaxIndex) {
                    stack2Top--;
                    value = storage[stack2Top];
                    storage[stack2Top] = null;
                }
                break;
            case 3:
                if (stack3Top > stack2MaxIndex) {
                    stack3Top--;
                    value = storage[stack3Top];
                    storage[stack3Top--] = null;
                }
                break;
            default:
                throw new IllegalArgumentException("Index must be between 1 and 3.");
        }

        return value;
    }
}
