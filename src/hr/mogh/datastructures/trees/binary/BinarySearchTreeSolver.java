package hr.mogh.datastructures.trees.binary;

import hr.mogh.datastructures.trees.BinaryTreeNode;

import java.util.List;

/**
 * Contains basic tree algorithms: BFS, DFS, In-Order, Pre-Order, and Post-Order traversals.
 * Created by vlado on 11.10.2015.
 */
public class BinarySearchTreeSolver {

    public static BinaryTreeNode generateBinaryTree(List<Integer> treeData) throws IllegalArgumentException {
        if (treeData == null || treeData.size() == 0) {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode root = new BinaryTreeNode(treeData.get(0), null);
        List<Integer> childrenData = treeData.subList(1, treeData.size());
        for (Integer data : childrenData) {
            insert(root, data);
        }

        return root;
    }

    public static void insert(BinaryTreeNode node, int data) throws NullPointerException, ClassCastException {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (node.getValue() >= data) {
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

    public static void delete(BinaryTreeNode node, int data) throws NullPointerException, ClassCastException,
            IllegalArgumentException {
        if (node == null) {
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
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(deletedNode.getRightChild());
                    } else {
                        parent.setLeftChild(deletedNode.getRightChild());
                    }
                } else if (deletedNode.getLeftChild() != null && deletedNode.getRightChild() == null) {
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(deletedNode.getLeftChild());
                    } else {
                        parent.setLeftChild(deletedNode.getLeftChild());
                    }
                } else if (deletedNode.getLeftChild() != null && deletedNode.getRightChild() != null) {
                    BinaryTreeNode successorNode = findMin(deletedNode.getLeftChild());
                    parent.setValue(successorNode.getValue());
                    successorNode.getParent().setLeftChild(null);
                }
            }
        }
    }

    public static BinaryTreeNode find(BinaryTreeNode node, int data) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode foundNode;
        if (node.getValue() == data) {
            foundNode = node;
        } else if (node.getValue() > data) {
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
