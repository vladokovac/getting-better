package hr.mogh.crackingthecodinginterview.ch3;

/**
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
