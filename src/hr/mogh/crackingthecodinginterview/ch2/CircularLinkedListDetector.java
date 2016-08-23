package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;

/**
 * Solves the following problem:
 * <p/>
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * <p/>
 * DEFINITION: Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
 * node, so as to make a loop in the linked list.
 * <p/>
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * <p/>
 * Created by vlado on 31.7.2016.
 */
public class CircularLinkedListDetector {

    /**
     * Finds the starting node of a loop in a circular linked list. First there is a check if there is even a loop in the list, then the first node of the loop is located.
     * @param linkedList The input list.
     * @return First node of the loop. Null if there is no loop in the list.
     */
    public static ListNode findStartOfLoop(DoublyLinkedList linkedList) {
        ListNode detectedLoopNode = null;

        ListNode fastNode = linkedList.getFirstNode();
        ListNode slowNode = linkedList.getFirstNode();

        while (fastNode.getNodeAfter() != null && fastNode.getNodeAfter().getNodeAfter() != null) {
            slowNode = slowNode.getNodeAfter();
            fastNode = fastNode.getNodeAfter().getNodeAfter();

            if (slowNode == fastNode) {
                detectedLoopNode = getFirstNodeOfLoop(linkedList.getFirstNode(), fastNode);
                break;
            }
        }

        return detectedLoopNode;
    }

    /**
     * Finds the first node in a circular linked list.
     * @param firstNode The first node of the list.
     * @param meetingPointNode The node where two "runners" met in the loop.
     * @return The first node of the loop.
     */
    private static ListNode getFirstNodeOfLoop(ListNode firstNode, ListNode meetingPointNode) {

        while (firstNode != meetingPointNode) {
            firstNode = firstNode.getNodeAfter();
            meetingPointNode = meetingPointNode.getNodeAfter();
        }

        return firstNode;
    }
}
