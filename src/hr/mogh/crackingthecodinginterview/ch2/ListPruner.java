package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solves the following problem:
 * <p/>
 * Write code to remove duplicates from an unsorted linked list.
 * <p/>
 * How would you solve this problem if a temporary buffer is not allowed?</code><br/>
 * <p/>
 * Created by vlado on 31.3.2016.
 */
public class ListPruner {

    /**
     * Removes duplicate values from a linked list. Uses a set to keep track of unique values.<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     *
     * @param rootNode The root of the list.
     */
    public static void pruneLinkedListWithBuffer(ListNode rootNode) {
        Set<Object> valuesInList = new HashSet<>();
        ListNode node = rootNode;
        while (node != null) {
            if (!valuesInList.contains(node.getValue())) {
                valuesInList.add(node.getValue());
            } else {
                removeNode(node);
            }
            node = node.getNodeAfter();
        }
    }

    /**
     * Removes duplicate values from a linked list. Uses a forward pointer to check for repeating values.<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n^2)</code><br/>
     * @param rootNode The root of the list.
     */
    public static void pruneLinkedList(ListNode rootNode) {
        ListNode node = rootNode;
        while (node != null) {
            ListNode forwardNode = node.getNodeAfter();
            while (forwardNode != null) {
                if (forwardNode.getValue().equals(node.getValue())) {
                    removeNode(forwardNode);
                }
                forwardNode = forwardNode.getNodeAfter();
            }
            node = node.getNodeAfter();
        }
    }

    private static void removeNode(ListNode node) {
        ListNode nodeBefore = node.getNodeBefore();
        if (nodeBefore != null) {
            nodeBefore.setNodeAfter(node.getNodeAfter());
        }
        ListNode nodeAfter = node.getNodeAfter();
        if (nodeAfter != null) {
            nodeAfter.setNodeBefore(nodeBefore);
        }
    }
}
