package hr.mogh.crackingthecodinginterview.ch3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Solve the following problem:
 * <p/>
 * <code>Implement a MyQueue class which implements a queue using two stacks.</code><p/>
 * Created by vlado on 2.10.2016.
 */
public class MyQueue {

    private Stack<Object> frontStack;
    private Stack<Object> backStack;

    public MyQueue() {
        frontStack = new Stack<>();
        backStack = new Stack<>();
    }

    /**
     * Enqueues the object.<br/>
     * Time complexity:<code>O(n)</code>.
     *
     * @param value The object.
     */
    public void enqueue(Object value) {
        if (backStack.size() == 0) {
            transferStacks();
        }
        backStack.push(value);
    }

    /**
     * Enqueues an array of objects.
     * Time complexity:<code>O(n)</code>.
     *
     * @param values The array of objects.
     */
    public void enqueue(Object[] values) {
        for (Object value : values) {
            enqueue(value);
        }
    }

    /**
     * Dequeues one element from the queue.
     * Time complexity:<code>O(n)</code>.
     *
     * @return The dequeued value. Null if empty.
     */
    public Object dequeue() {
        Object value;

        if (frontStack.size() == 0) {
            transferStacks();
        }
        try {
            value = frontStack.pop();
        } catch (EmptyStackException ese) {
            value = null;
        }

        return value;
    }

    /**
     * Transfers all stored elements between from the currently full stack to the currently empty one.<br/>
     * Time complexity:<code>O(n)</code>.
     */
    private void transferStacks() {
        int frontStackSize = frontStack.size();
        int backStackSize = backStack.size();

        if (frontStackSize == 0 && backStackSize == 0) {
            return;
        }

        if (frontStackSize == 0) {
            while (backStack.size() > 0) {
                frontStack.push(backStack.pop());
            }
        } else {
            while (frontStack.size() > 0) {
                backStack.push(frontStack.pop());
            }
        }
    }
}
