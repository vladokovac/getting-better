package hr.mogh.crackingthecodinginterview.ch2;

import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;

/**
 * Solves the following problem:<p/>
 * <code>Implement a function to check if a linked list is a palindrome.</code><p/>
 * Created by vlado on 24.8.2016.
 */
public class PalindromeListDetector {

    /**
     * Detects whether a linked list is a palindrome by checking from the front and back simultaneously.<br/>
     * Space complexity:<code>O(n)</code><br/>
     * Time complexity:<code>O(n)</code>
     *
     * @param linkedList The potential palindrome list.
     * @return Yes if the list is a palindrome.
     */
    public static boolean isPalindrome(DoublyLinkedList linkedList) {
        boolean isPalindrome = true;
        ListNode frontNode = linkedList.getFirstNode();
        ListNode backNode = linkedList.getLastNode();

        for (int i = 0; i < linkedList.getSize() / 2; i++) {
            if (frontNode.getValue() != backNode.getValue()) {
                isPalindrome = false;
                break;
            }
            frontNode = frontNode.getNodeAfter();
            backNode = backNode.getNodeBefore();
        }
        return isPalindrome;
    }
}
