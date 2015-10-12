package hr.mogh.trees.binary;

import hr.mogh.trees.BinaryTreeNode;

import java.util.List;

/**
 * Contains basic tree algorithms: BFS, DFS, In-Order, Pre-Order, and Post-Order traversals.
 * Created by vlado on 11.10.2015.
 */
public class BinarySearchTreeSolver {

    public static BinaryTreeNode generateBinaryTree(List<Comparable> treeData) throws IllegalArgumentException {
        if (treeData == null || treeData.size() == 0) {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode root = new BinaryTreeNode(treeData.get(0), null);
        List<Comparable> childrenData = treeData.subList(1, treeData.size());
        for (Comparable data : childrenData) {
            insert(root, data);
        }

        return root;
    }

    public static void insert(BinaryTreeNode node, Comparable data) throws NullPointerException, ClassCastException {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        if (node.getValue().compareTo(data) < 0) {
            if (node.getLeftChild() == null) {
                BinaryTreeNode child = new BinaryTreeNode(data, node);
                node.setLeftChild(child);
            } else {
                insert(node.getLeftChild(), data);
            }
        } else {
            if (node.getRightChild() == null) {
                BinaryTreeNode child = new BinaryTreeNode(data, node);
                node.setRightChild(child);
            } else {
                insert(node.getRightChild(), data);
            }
        }
    }

    public static void delete(BinaryTreeNode node, Comparable data) throws NullPointerException, ClassCastException,
            IllegalArgumentException {
        if (node == null || data == null) {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode deletedNode = find(node, data);
        if (deletedNode != null) {
            BinaryTreeNode parent = deletedNode.getParent();
            if (parent != null) {
                if (deletedNode.getLeftChild() == null && deletedNode.getRightChild() == null) {
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(null);
                    } else {
                        parent.setLeftChild(null);
                    }
                }

                if (deletedNode.getLeftChild() == null && deletedNode.getRightChild() != null) {
                    if (parent.getRightChild() == node) {
                        parent.setRightChild(node.getRightChild());
                    } else {
                        parent.setLeftChild(node.getRightChild());
                    }
                } else if (deletedNode.getLeftChild() != null && deletedNode.getRightChild() != null) {
                    BinaryTreeNode successorNode = findMin(deletedNode.getLeftChild());
                    parent.setValue(successorNode.getValue());
                    successorNode.getParent().setLeftChild(null);
                }
            }
        }
    }

    public static BinaryTreeNode find(BinaryTreeNode node, Comparable data) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode foundNode = null;
        int comparisonResult = node.getValue().compareTo(data);
        if (comparisonResult == 0) {
            foundNode = node;
        } else if (comparisonResult < 0) {
            foundNode = find(node.getLeftChild(), data);
        } else {
            foundNode = find(node.getRightChild(), data);
        }

        return foundNode;
    }

    public static BinaryTreeNode findMin(BinaryTreeNode node) throws IllegalArgumentException {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        return node.getLeftChild() != null ? findMin(node.getLeftChild()) : node;
    }

    public static BinaryTreeNode findMax(BinaryTreeNode node) throws IllegalArgumentException {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        return node.getRightChild() != null ? findMax(node.getRightChild()) : node;
    }


}
