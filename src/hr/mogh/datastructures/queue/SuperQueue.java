package hr.mogh.datastructures.queue;

import java.util.List;

/**
 * A SuperQueue. What? You don't know what a SuperQueue is? No problem, let me enlighten your high-abstraction
 * existence. This stack implementation is seriously advance. Real talk: this is some serious shit. I wouldn't even
 * bother looking into the innards of the implementation if I were you. There's no use.<p/>
 * Implemented using a fixed capacity array and first/last item indices.<p/>
 * Created by vlado on 24.8.2016.
 */
public class SuperQueue {

    private int size;
    private Object[] storage;
    private int lastItemIndex;
    private int firstItemIndex;

    public SuperQueue(int capacity) {
        storage = new Object[capacity];
        firstItemIndex = 0;
        lastItemIndex = 0;
    }

    public SuperQueue(List<Object> elements) {
        firstItemIndex = 0;
        lastItemIndex = 0;
        storage = new Object[elements.size()];
        for (Object item : elements) {
            enqueue(item);
        }
    }

    public boolean enqueue(Object value) {
        if (size >= storage.length) {
            return false;
        }
        firstItemIndex = (firstItemIndex + 1) % storage.length;
        storage[firstItemIndex] = value;
        size++;
        return true;
    }

    public Object dequeue() {
        Object value = null;
        if (size > 0) {
            lastItemIndex = (lastItemIndex + 1) % storage.length;
            value = storage[lastItemIndex];
            size--;
        }
        return value;
    }

    public int getSize() {
        return size;
    }
}
