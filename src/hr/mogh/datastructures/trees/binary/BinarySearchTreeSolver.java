package hr.mogh.datastructures.trees.binary;

import hr.mogh.datastructures.trees.BinaryTreeNode;

import java.util.ArrayList;
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

            // No children
            if (deletedNode.getLeftChild() == null && deletedNode.getRightChild() == null) {
                if (parent != null) {
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(null);
                    } else {
                        parent.setLeftChild(null);
                    }
                }
            }

            // Single child
            if (deletedNode.getLeftChild() == null && deletedNode.getRightChild() != null) {
                if (parent != null) {
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(deletedNode.getRightChild());
                    } else {
                        parent.setLeftChild(deletedNode.getRightChild());
                    }
                }
            } else if (deletedNode.getLeftChild() != null && deletedNode.getRightChild() == null) {
                if (parent != null) {
                    if (parent.getRightChild() == deletedNode) {
                        parent.setRightChild(deletedNode.getLeftChild());
                    } else {
                        parent.setLeftChild(deletedNode.getLeftChild());
                    }
                }
            }

            // Both children
            if (deletedNode.getLeftChild() != null && deletedNode.getRightChild() != null) {
                BinaryTreeNode successorNode = findMin(deletedNode.getRightChild());
                deletedNode.setValue(successorNode.getValue());
                successorNode.getParent().setLeftChild(null);
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

    public static List<Integer> getValuesPreOrder(BinaryTreeNode node) {
        List<Integer> resultList = new ArrayList<>();
        if (node != null) {
            resultList.add(node.getValue());
            resultList.addAll(getValuesPreOrder(node.getLeftChild()));
            resultList.addAll(getValuesPreOrder(node.getRightChild()));
        }
        return resultList;
    }

    public static List<Integer> getValuesInOrder(BinaryTreeNode node) {
        List<Integer> resultList = new ArrayList<>();
        if (node != null) {
            resultList.addAll(getValuesInOrder(node.getLeftChild()));
            resultList.add(node.getValue());
            resultList.addAll(getValuesInOrder(node.getRightChild()));
        }
        return resultList;
    }

    public static List<Integer> getValuesPostOrder(BinaryTreeNode node) {
        List<Integer> resultList = new ArrayList<>();
        if (node != null) {
            resultList.addAll(getValuesPostOrder(node.getLeftChild()));
            resultList.addAll(getValuesPostOrder(node.getRightChild()));
            resultList.add(node.getValue());
        }
        return resultList;
    }
}
