package hr.mogh.datastructures.hashtable;

import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A hash table implementation.
 * Created by vlado on 19.10.2015.
 */
public class SuperHashTable<K, V> implements Map<K, V> {
    ListNode[] dataTable;
    int size;
    int count;

    public SuperHashTable(int size) {
        this.size = size;
        this.count = 0;
        this.dataTable = new ListNode[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return this.count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = this.calculateIndex(key.toString());
        ListNode node = dataTable[index];
        ListNode newNode = new ListNode(value);

        if (node != null) {
            while (node.getNodeAfter() != null) {
                node = node.getNodeAfter();
            }
            node.setNodeAfter(newNode);
        } else {
            dataTable[index] = newNode;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = this.calculateIndex(key.toString());
        ListNode node = dataTable[index];
        V returnValue = null;

        if (node != null) {
            while(node.getNodeAfter() != null) {
                node = node.getNodeAfter();
            }
            ListNode parentNode = node.getNodeBefore();
            if (parentNode != null) {
                parentNode.setNodeAfter(null);
            }
            returnValue = (V)node.getValue();
        }

        return returnValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private int calculateIndex(String key) {
        long sum = 0;
        for(char letter : key.toCharArray()) {
            sum += letter;
        }
        return (int)(sum % this.size);
    }
}
