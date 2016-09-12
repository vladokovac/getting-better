package hr.mogh.crackingthecodinginterview.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve the following problem:
 * <p/>
 * <code>Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
 * we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
 * stack (that is, pop() should return the same values as it would if there were just a single stack).</code>
 * <p/>
 * Created by vlado on 12.9.2016.
 */
public class SetOfStacks {

    private int totalStacks;
    private int singleStackSize;
    private List<Object[]> stacks;
    private int topStackCount;

    public SetOfStacks(int individualStackSize) {
        singleStackSize = individualStackSize;
        stacks = new ArrayList<>();
        stacks.add(new Object[individualStackSize]);
        totalStacks = 1;
        topStackCount = 0;
    }

    /**
     * A push operation.<br/>
     * Time complexity: <code>O(1)</code>.
     *
     * @param value The new value.
     */
    public void push(Object value) {
        if (topStackCount == singleStackSize) {
            // add a new top stack
            stacks.add(new Object[singleStackSize]);
            topStackCount = 0;
            totalStacks++;
        }

        // push to the top stack
        Object[] topStack = stacks.get(totalStacks - 1);
        topStack[topStackCount++] = value;
    }

    /**
     * The pop operation.<br/>
     * Time complexity:<code>O(1)</code>.
     *
     * @return The popped value.
     */
    public Object pop() {
        if (topStackCount == 0) {
            // remove the top stack (it's empty)
            stacks.remove(--totalStacks);
            topStackCount = singleStackSize;
        }

        // pop the value
        Object value = null;
        if (topStackCount > 0 && totalStacks > 0) {
            Object[] topStack = stacks.get(totalStacks - 1);
            value = topStack[--topStackCount];
        } else {
            topStackCount = 0;
        }
        return value;
    }
}
