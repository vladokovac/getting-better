package hr.mogh.datastructures.hashtable;

/**
 * A singly-linked list with <code>key</code> and <code>value</code> properties.
 * Created by vlado on 20.10.2015.
 */
public class HashNode<K, V> {
    K key;
    V value;
    HashNode nextNode;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public HashNode(K key, V value, HashNode nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(HashNode nextNode) {
        this.nextNode = nextNode;
    }
}
