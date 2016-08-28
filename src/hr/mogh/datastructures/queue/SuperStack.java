package hr.mogh.datastructures.queue;

import java.util.List;

/**
 * An implementation of the stack. Based on pure genius and years of experience. Designed for maximum efficiency and
 * comfort. Satisfaction guaranteed or your money back.<p/>
 * Implemented using a resizing array. Shortens when capacity is over 25%, grows when capacity is under 50%.<p/>
 * Created by vlado on 24.8.2016.
 */
public class SuperStack {

    private int size;
    private Object[] storage;

    public SuperStack() {
        int size = 2;
        storage = new Object[size];
    }

    public SuperStack(List<Object> elements) {

        int size = 2;
        while (size < elements.size() * 2) {
            size *= 2;
        }

        storage = new Object[size];
        for (Object item : elements) {
            push(item);
        }
    }

    public void push(Object value) {
        storage[size] = value;
        size++;
        tryIncreaseStorage();
    }

    public Object pop() {
        Object value = storage[size - 1];
        size--;
        tryDecreaseStorage();
        return value;
    }

    private void tryIncreaseStorage() {
        if (storage.length / 2 <= size) {
            updateStorageObjectoSize(storage.length * 2);
        }
    }

    private void tryDecreaseStorage() {
        if (storage.length / 4 >= size) {
            updateStorageObjectoSize(storage.length / 2);
        }
    }

    private void updateStorageObjectoSize(int newSize) {
        Object[] newStorage = new Object[newSize];
        int i = 0;
        while (storage[i] != null) {
            newStorage[i] = storage[i];
            i++;
        }
        storage = newStorage;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return storage.length;
    }
}
