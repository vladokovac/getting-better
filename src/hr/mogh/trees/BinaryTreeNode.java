package hr.mogh.trees;

/**
 * A binary tree node. Also has a reference to its parent.
 * Created by vlado on 11.10.2015.
 */
public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode parent;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value, BinaryTreeNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
