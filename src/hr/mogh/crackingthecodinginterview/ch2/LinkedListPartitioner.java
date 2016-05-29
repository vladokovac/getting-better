package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem:
 * <p/>
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
 * greater than or equal to x.
 * <p/>
 * Created by vlado on 29.5.2016.
 */
public class LinkedListPartitioner {

    /**
     * Partitions a doubly linked list around a pivot value. After partitioning, all smaller and equal nodes are to
     * the left of the node with the pivot value and all greater nodes are to the right of the pivot node.
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     *
     * @param list  The argument linked list.
     * @param value The value around which the list will be partitioned.
     * @return The partitioned list.
     * @throws IllegalArgumentException Thrown when no such pivot value is found in the list.
     */
    public static DoublyLinkedList partitionList(DoublyLinkedList list, int value) throws IllegalArgumentException {
        ListNode pivotNode = null;
        List<ListNode> smallerNodes = new ArrayList<>();
        List<ListNode> greaterNodes = new ArrayList<>();

        ListNode currentNode = list.getFirstNode();
        do {
            int currentValue = (int) currentNode.getValue();
            if (currentValue == value && pivotNode == null) {
                pivotNode = currentNode;
            } else if (currentValue <= value) {
                smallerNodes.add(currentNode);
            } else if (currentValue > value) {
                greaterNodes.add(currentNode);
            }
            currentNode = currentNode.getNodeAfter();
        } while (currentNode != null);

        if (pivotNode == null) {
            throw new IllegalArgumentException("Pivot value not present in argument list.");
        }

        DoublyLinkedList newList = null;
        if (smallerNodes.size() > 0) {
            newList = new DoublyLinkedList(smallerNodes.get(0).getValue());
            for (int i = 1; i < smallerNodes.size(); i++) {
                ListNode nextNode = smallerNodes.get(i);
                newList.add(nextNode.getValue());
            }
        }

        if (newList == null) {
            newList = new DoublyLinkedList(pivotNode);
        } else {
            newList.add(pivotNode.getValue());
        }

        if (greaterNodes.size() > 0) {
            for (int i = 0; i < greaterNodes.size(); i++) {
                ListNode nextNode = greaterNodes.get(i);
                newList.add(nextNode.getValue());
            }
        }

        return newList;
    }
}
