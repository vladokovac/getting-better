package hr.mogh.crackingthecodinginterview.ch3;

import java.util.ArrayList;
import java.util.List;

/**
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
