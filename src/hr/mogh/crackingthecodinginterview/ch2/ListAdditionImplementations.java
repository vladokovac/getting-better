package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem:
 * <p/>
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 * <p/>
 * EXAMPLE:<br/> <code>
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: (2 -> 1 -> 9). That is, 912.
 * </code><p/>
 * FOLLOW UP:
 * Suppose the digits are stored in forward order. Repeat the above problem.<p/>
 * <p/>
 * EXAMPLE:<br/><code>
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: (9 -> 1 -> 2). That is, 912.
 * </code>
 * <p/>
 * Created by vlado on 5.6.2016.
 */
public class ListAdditionImplementations {

    /**
     * Adds the values of two linked lists where the numbers are stored in reverse (example 120 is stored as 0->2->1)
     * .<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return Linked list with summed values in reverse.
     */
    public static DoublyLinkedList sumReverse(DoublyLinkedList list1, DoublyLinkedList list2) {
        ListNode listSum = null;
        ListNode firstSumNode = null;
        int carryOver = 0;
        ListNode node1 = list1.getFirstNode();
        ListNode node2 = list2.getFirstNode();

        while (node1 != null || node2 != null) {
            ListNode parentNode = listSum;
            listSum = new ListNode(0);
            int nodeSum = 0;
            if (node1 != null) {
                nodeSum += (int) node1.getValue();
                node1 = node1.getNodeAfter();
            }
            if (node2 != null) {
                nodeSum += (int) node2.getValue();
                node2 = node2.getNodeAfter();
            }

            nodeSum += carryOver;

            if (nodeSum >= 10) {
                carryOver = nodeSum / 10;
            } else {
                carryOver = 0;
            }

            listSum.setValue(nodeSum % 10);
            listSum.setNodeBefore(parentNode);
            if (parentNode != null) {
                parentNode.setNodeAfter(listSum);
            }
            if (firstSumNode == null) {
                firstSumNode = listSum;
            }
        }

        if (carryOver > 0) {
            listSum.setNodeAfter(new ListNode(carryOver));
        }

        return new DoublyLinkedList(firstSumNode);
    }

    /**
     * Adds the values of two linked lists of integers.<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code><br/>
     * @param list1 The first list.
     * @param list2 The second list.
     * @return Linked list with summed values.
     */
    public static DoublyLinkedList sum(DoublyLinkedList list1, DoublyLinkedList list2) {
        List<Integer> sumList = new ArrayList<>();
        ListNode node1 = list1.getFirstNode();
        ListNode node2 = list2.getFirstNode();
        int numberPosition = 0;
        while (node1 != null || node2 != null) {
            int nodeSum = 0;
            if (node1 != null && list1.getSize() - list2.getSize() + numberPosition >= 0) {
                nodeSum += (int) node1.getValue();
                node1 = node1.getNodeAfter();
            }
            if (node2 != null && list2.getSize() - list1.getSize() + numberPosition >= 0) {
                nodeSum += (int) node2.getValue();
                node2 = node2.getNodeAfter();
            }

            if (nodeSum >= 10) {
                addCarryOverValue(sumList, sumList.size() - 1, nodeSum / 10);
                nodeSum = nodeSum % 10;
            }

            sumList.add(nodeSum);
            numberPosition++;
        }

        return new DoublyLinkedList((List) sumList);
    }

    public static void addCarryOverValue(List<Integer> sumList, int index, int value) {
        if (index < 0) {
            sumList.add(0, value);
        } else {
            int newValue = sumList.get(index) + value;
            if (newValue >= 10) {
                sumList.set(index, newValue % 10);
                addCarryOverValue(sumList, index - 1, newValue / 10);
            } else {
                sumList.set(index, newValue);
            }
        }
    }
}
