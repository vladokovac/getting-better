package hr.mogh.crackingthecodinginterview.ch4;

import hr.mogh.datastructures.trees.BinaryTreeNode;

/**
 * Solve the following problem:
 * <p><code>
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
 * defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 * </code><p>
 * Created by vlado on 13/11/2016.
 */
public class BinaryTreeBalanceDetector {

    /**
     * Returns whether the tree is balanced or not. Balanced means that the height of the two subtrees does not
     * differ by more than 1.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     *
     * @param node The tree root.
     * @return True if tree is "balanced".
     */
    public static boolean isTreeBalanced(BinaryTreeNode node) {
        // Better: Can be improved by checking if the tree is balanced within the getTreeHeight recursive call and
        // returning -1 if the tree is not balanced. Time complexity: O(n). Returning -1 to indicate an imbalanced
        // tree seems like bad practice (doing two things in one method).

        // Best: Can be improved by saving subtree heights in the nodes themselves. Finding out if a tree is balanced
        // would then be achieved by visiting all nodes and checking their subtree heights. Time complexity: O(n).
        // (Insertion would be affected, it would require all nodes to be updated. Time complexity: O(log n)).

        if (node == null) {
            return true;
        }

        boolean isBalanced = Math.abs(getTreeHeight(node.getLeftChild()) - getTreeHeight(node.getRightChild())) <= 1;

        return isBalanced && isTreeBalanced(node.getLeftChild()) && isTreeBalanced(node.getRightChild());
    }

    /**
     * Returns tree height for a binary tree node.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param node The tree node.
     * @return The max height in the tree.
     */
    private static int getTreeHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int treeHeight = 1 + Math.max(getTreeHeight(node.getLeftChild()), getTreeHeight(node.getRightChild()));

        return treeHeight;
    }

}
