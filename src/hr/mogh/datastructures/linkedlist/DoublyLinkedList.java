package hr.mogh.datastructures.linkedlist;

import java.util.List;

/**
 * An implementation of a doubly linked list.
 * Created by vlado on 13.10.2015.
 */
public class DoublyLinkedList {
    private ListNode firstNode;
    private ListNode lastNode;
    private int size;

    public DoublyLinkedList(Object rootValue) {
        this.add(rootValue);
    }

    public DoublyLinkedList(List<Object> listData) {
        for (Object data : listData) {
            this.add(data);
        }
    }

    public DoublyLinkedList(ListNode firstNode) {
        this.firstNode = firstNode;
        this.firstNode.setNodeBefore(null);

        ListNode node = firstNode;
        int i = 1;
        while (node.getNodeAfter() != null) {
            node = node.getNodeAfter();
            i++;
        }
        this.lastNode = node;
        this.lastNode.setNodeAfter(null);
        this.size = i;
    }

    public int getSize() {
        return size;
    }

    public void add(Object data) {
        ListNode node = new ListNode(data);
        if (firstNode == null) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.setNodeAfter(node);
            node.setNodeBefore(lastNode);
            lastNode = node;
        }
        this.size++;
    }

    public ListNode find(Object data) {
        ListNode node = firstNode;
        ListNode result = null;
        while (node != null) {
            if (node.getValue().equals(data)) {
                result = node;
                break;
            } else {
                node = node.getNodeAfter();
            }
        }
        return result;
    }

    public ListNode findReverse(Object data) {
        ListNode node = lastNode;
        ListNode result = null;
        while (node != null) {
            if (node.getValue().equals(data)) {
                result = node;
                break;
            } else {
                node = node.getNodeBefore();
            }
        }
        return result;
    }

    public void insertAfter(ListNode node, Object newData) {
        if (node != null) {
            ListNode newNode = new ListNode(newData);
            newNode.setNodeBefore(node);
            newNode.setNodeAfter(node.getNodeAfter());
            ListNode nodeAfter = node.getNodeAfter();
            nodeAfter.setNodeBefore(newNode);
            node.setNodeAfter(newNode);
            this.size++;
        } else {
            this.add(newData);
        }
    }

    public void insertBefore(ListNode node, Object newData) {
        if (node != null) {
            ListNode newNode = new ListNode(newData);
            newNode.setNodeAfter(node);
            newNode.setNodeBefore(node.getNodeBefore());
            ListNode nodeBefore = node.getNodeBefore();
            nodeBefore.setNodeAfter(newNode);
            node.setNodeBefore(newNode);
            this.size++;
        } else {
            this.add(newData);
        }
    }

    public void delete(Object data) {
        ListNode node = this.find(data);
        if (node != null) {
            node.getNodeBefore().setNodeAfter(node.getNodeAfter());
            this.size--;
        }
    }

    public ListNode getFirstNode() {
        return firstNode;
    }

    public ListNode getLastNode() {
        return lastNode;
    }

    @Override
    public String toString() {
        ListNode node = this.firstNode;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.getValue().toString()).append(" <-> ");
            node = node.getNodeAfter();
        }
        String output = stringBuilder.toString();
        return output.substring(0, output.length() - 5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        DoublyLinkedList that = (DoublyLinkedList) o;

        if (size != that.size) {
            return false;
        }

        boolean isEqual = true;

        ListNode thisNode = firstNode;
        ListNode thatNode = that.firstNode;

        while(thisNode != null && thatNode != null) {
            if (!(thisNode.getValue() == thatNode.getValue())){
                isEqual = false;
                break;
            }
            thisNode = thisNode.getNodeAfter();
            thatNode = thatNode.getNodeAfter();
        }

        return isEqual;

    }

    @Override
    public int hashCode() {
        int result = firstNode != null ? firstNode.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}
