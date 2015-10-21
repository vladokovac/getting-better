package hr.mogh.datastructures.hashtable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A hash table implementation.
 * Created by vlado on 19.10.2015.
 */
public class SuperHashTable<K, V> implements Map<K, V> {
    HashNode<K, V>[] dataTable;
    int tableSize;
    int count;

    public SuperHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.count = 0;
        this.dataTable = new HashNode[tableSize];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {

        return this.count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return this.get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean isValueFound = false;
        for (int i = 0; i < tableSize; i++) {
            HashNode<K, V> node = dataTable[i];
            if (node != null) {
                do {
                    if (node.getValue().equals(value)){
                        isValueFound = true;
                        break;
                    }else {
                        node = node.getNextNode();
                    }
                } while (node != null);
            }
            if (isValueFound) {
                break;
            }
        }
        return isValueFound;
    }

    @Override
    public V get(Object key) {
        int index = this.calculateHash(key.toString());
        HashNode<K, V> node = dataTable[index];
        V value = null;
        if (node != null) {
            do {
                if (node.getKey().equals(key)) {
                    value = node.getValue();
                    break;
                } else {
                    node = node.getNextNode();
                }
            } while (node != null);
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        int index = this.calculateHash(key.toString());
        HashNode<K, V> node = dataTable[index];
        HashNode<K, V> prevNode = null;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        V replacedValue = null;
        boolean isValueInserted = false;

        if (node != null) {
            do {
                if (node.key.equals(key)) {
                    // update value
                    replacedValue = node.getValue();
                    node.setValue(value);
                    isValueInserted = true;
                    break;
                } else {
                    prevNode = node;
                    node = node.getNextNode();
                }
            } while (node != null);
            if (!isValueInserted) {
                prevNode.setNextNode(newNode);
                isValueInserted = true;
            }
        } else {
            dataTable[index] = newNode;
            isValueInserted = true;
        }
        if (isValueInserted) {
            this.count++;
        }
        return replacedValue;
    }

    @Override
    public V remove(Object key) {
        int index = this.calculateHash(key.toString());
        HashNode<K, V> node = dataTable[index];
        HashNode<K, V> prevNode = null;
        V removedNodeValue = null;

        if (node != null) {
            do {
                if (node.getKey().equals(key)) {
                    // delete the node
                    removedNodeValue = node.getValue();
                    if (prevNode != null) {
                        prevNode.setNextNode(node.getNextNode());
                    } else {
                        dataTable[index] = node.getNextNode();
                    }
                    this.count--;
                    break;
                } else {
                    prevNode = node;
                    node = node.getNextNode();
                }
            } while (node != null);
        }

        return removedNodeValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        dataTable = new HashNode[this.tableSize];
        this.count = 0;
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

    private int calculateHash(String key) {
        long sum = 0;
        for (char letter : key.toCharArray()) {
            sum += letter;
        }
        return (int) (sum % this.tableSize);
    }
}
