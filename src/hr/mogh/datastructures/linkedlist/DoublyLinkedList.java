package hr.mogh.datastructures.linkedlist;

import java.util.List;

/**
 * An implementation of a doubly linked list.
 * Created by vlado on 13.10.2015.
 */
public class DoublyLinkedList {
    private ListNode firstNode;
    private ListNode lastNode;

    public DoublyLinkedList(List<Object> listData) {
        for (Object data : listData) {
            this.add(data);
        }
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

    public void insertAfter(Object nodeData, Object newData) {
        ListNode nodeBefore = this.find(nodeData);
        if (nodeBefore != null) {
            ListNode newNode = new ListNode(newData);
            newNode.setNodeBefore(nodeBefore);
            newNode.setNodeAfter(nodeBefore.getNodeAfter());
            nodeBefore.setNodeAfter(newNode);
        } else {
            this.add(newData);
        }
    }

    public void insertBefore(Object nodeData, Object newData) {
        ListNode nodeAfter = this.find(nodeData);
        if (nodeAfter != null) {
            ListNode newNode = new ListNode(newData);
            newNode.setNodeAfter(nodeAfter);
            newNode.setNodeBefore(nodeAfter.getNodeBefore());
            nodeAfter.setNodeBefore(newNode);
        } else {
            this.add(newData);
        }
    }

    public void delete(Object data) {
        ListNode node = this.find(data);
        if (node != null) {
            node.getNodeBefore().setNodeAfter(node.getNodeAfter());
        }
    }
}
