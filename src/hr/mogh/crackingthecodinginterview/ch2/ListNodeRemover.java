package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.List;

/**
 * Solves the following problem:
 * <p/>
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * <p/>
 * Created by vlado on 18.4.2016.
 */
public class ListNodeRemover {

    /**
     * Removes the node from a singly linked list. Copies values from subsequent nodes and removes the last node in the list.<br/>
     * Space complexity: <code>O(1)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     * @param node The node to be removed.
     */
    public static void removeNode(ListNode node) { // 1st attempt
        if (node == null || node.getNodeAfter() == null) {
            throw new IllegalArgumentException("Invalid state.");
        }
        node.setValue(node.getNodeAfter().getValue());
        if (node.getNodeAfter().getNodeAfter() == null) {
            node.setNodeAfter(null);
        } else {
            removeNode(node.getNodeAfter());
        }
    }

    public static void removeNodeCorrectly(ListNode node) { // 2nd attempt
        if (node == null || node.getNodeAfter() == null) {
            throw new IllegalArgumentException("Invalid state.");
        }
        node.setValue(node.getNodeAfter().getValue());
        node.setNodeAfter(node.getNodeAfter().getNodeAfter());
    }
}
