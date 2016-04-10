package hr.mogh.datastructures.linkedlist;

/**
 * A basic linked list node. Has references to its predecessor and successor.
 * Created by vlado on 13.10.2015.
 */
public class ListNode {
    private Object value;
    private ListNode nodeBefore;
    private ListNode nodeAfter;

    public ListNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ListNode getNodeBefore() {
        return nodeBefore;
    }

    public void setNodeBefore(ListNode nodeBefore) {
        this.nodeBefore = nodeBefore;
    }

    public ListNode getNodeAfter() {
        return nodeAfter;
    }

    public void setNodeAfter(ListNode nodeAfter) {
        this.nodeAfter = nodeAfter;
    }

    public int size() {
        int size = 1;

        ListNode currentNode = this;
        while (currentNode.nodeAfter != null) {
            size++;
            currentNode = currentNode.getNodeAfter();
        }
        return size;
    }
}
