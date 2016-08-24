package hr.mogh.datastructures.queue;

import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.List;

/**
 * Created by vlado on 24.8.2016.
 */
public class SuperStack {

    private int size;
    private ListNode storageFirst;
    private ListNode storageLast;

    public SuperStack() {
    }

    public SuperStack(List<Object> elements) {
        for (Object item : elements) {
            enqueue(item);
        }
    }

    public void enqueue(Object value) {
        ListNode newValue = new ListNode(value);
        if (storageFirst == null) {
            storageFirst = newValue;
            storageLast = newValue;
        } else {
            storageFirst = 
        }
        size++;
    }

    public Object dequeue() {
        Object value = storage[size - 1];
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }
}
