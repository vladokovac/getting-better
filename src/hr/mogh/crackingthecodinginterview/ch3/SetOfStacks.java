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
 * stack (that is, pop() should return the same values as it would if there were just a single stack).<p/>
 * FOLLOW UP<br/>
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.</code>
 * <p/>
 * Created by vlado on 12.9.2016.
 */
public class SetOfStacks {

    private int totalStacks;
    private int singleStackSize;
    private List<Object[]> stacks;
    private List<Integer> stackCounts;

    public SetOfStacks(int individualStackSize) {
        singleStackSize = individualStackSize;
        stacks = new ArrayList<>();
        stacks.add(new Object[individualStackSize]);
        totalStacks = 1;
        stackCounts = new ArrayList<>();
        stackCounts.add(0);
    }

    /**
     * A push operation.<br/>
     * Time complexity: <code>O(1)</code>.
     *
     * @param value The new value.
     */
    public void push(Object value) {
        if (stackCounts.get(totalStacks - 1) == singleStackSize) {
            // add a new top stack
            stacks.add(new Object[singleStackSize]);
            stackCounts.add(0);
            totalStacks++;
        }

        // push to the top stack
        Object[] topStack = stacks.get(totalStacks - 1);
        int topStackCount = stackCounts.get(totalStacks - 1);
        topStack[topStackCount] = value;
        stackCounts.set(totalStacks - 1, topStackCount + 1);
    }

    /**
     * The pop operation.<br/>
     * Time complexity:<code>O(1)</code>.
     *
     * @return The popped value.
     */
    public Object pop() {
        int topStackCount = stackCounts.get(totalStacks - 1);
        if (topStackCount == 0 && totalStacks > 1) {
            // remove the top stack (it's empty)
            totalStacks--;
            stacks.remove(totalStacks);
            stackCounts.remove(totalStacks);
        }

        // pop the value
        Object value = null;
        topStackCount = stackCounts.get(totalStacks - 1);
        if (topStackCount > 0 && totalStacks > 0) {
            Object[] topStack = stacks.get(totalStacks - 1);
            stackCounts.set(totalStacks - 1, topStackCount - 1);
            value = topStack[topStackCount - 1];
        } else {
            stackCounts.set(0, 0);
        }
        return value;
    }

    /**
     * A pop operation where the user can choose the stack from which a value will be popped.
     *
     * @param index The index of the stack
     * @return The popped value.
     */
    public Object popAt(int index) {
        if (index < 0 || index >= totalStacks) {
            throw new IndexOutOfBoundsException("No stack at index " + index);
        }

        Object value = null;
        int stackCount = stackCounts.get(index);
        if (stackCount > 0) {
            stackCount--;
            stackCounts.set(index, stackCount);
            value = stacks.get(index)[stackCount];
        }

        if (stackCount == 0 && totalStacks > 1) {
            // remove the empty stack
            totalStacks--;
            stacks.remove(index);
            stackCounts.remove(index);
        }

        return value;
    }
}
