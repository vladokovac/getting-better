package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.ListNode;

/**
 * Solves the following problem:
 * <p/>
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * <p/>
 * Created by vlado on 18.4.2016.
 */
public class ListNodeFinder {

    /**
     * Finds the kth to last node in a singly linked list.<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     * @param k The offset from the end of the list.
     * @param root The root element of the list.
     * @return The kth to last node.
     * @throws IllegalArgumentException Thrown if list has fewer than k elements.
     */
    public static ListNode findKthToLastElement(int k, ListNode root) throws IllegalArgumentException {
        ListNode node = root;
        ListNode forwardNode = root;
        int i = 0;
        while (forwardNode != null && i < k) {
            forwardNode = forwardNode.getNodeAfter();
            i++;
        }

        if (i < k) {
            throw new IllegalArgumentException("List does not contain k or more elements.");
        }

        while (forwardNode != null) {
            forwardNode = forwardNode.getNodeAfter();
            node = node.getNodeAfter();
        }

        return node;
    }
}
