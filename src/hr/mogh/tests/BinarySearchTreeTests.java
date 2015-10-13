package hr.mogh.tests;

import hr.mogh.datastructures.trees.BinaryTreeNode;
import hr.mogh.datastructures.trees.binary.BinarySearchTreeSolver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

/**
 * Contains tests written to ensure BST algorithms work as intended.
 * Created by vlado on 12.10.2015.
 */
public class BinarySearchTreeTests {

    private List<Integer> treeData = new ArrayList<>(Arrays.asList(10, 1, 4, 5, 18, 22, 65, 98, 55, 33, 42, 41, 14,
            3, 19, 20, 37, 81, 40, 27, 16, 11, 19, 32, 66, 69));
    private BinaryTreeNode root;

    @Before
    public void setup() {
        root = BinarySearchTreeSolver.generateBinaryTree(treeData);
    }

    @After
    public void cleanup() {
        root = null;
    }

    @Test
    public void treeGenerationTest() {
        Assert.assertNotNull(this.root);
    }

    @Test
    public void findMinNodeTest() {
        BinaryTreeNode minNode = BinarySearchTreeSolver.findMin(this.root);
        Assert.assertNotNull(minNode);
        Assert.assertEquals(1, minNode.getValue());
    }

    @Test
    public void findMaxNodeTest() {
        BinaryTreeNode minNode = BinarySearchTreeSolver.findMax(this.root);
        Assert.assertNotNull(minNode);
        Assert.assertEquals(98, minNode.getValue());
    }

    @Test
    public void findNodeTest_shouldSucceed() {
        BinaryTreeNode node = BinarySearchTreeSolver.find(this.root, 55);
        Assert.assertNotNull(node);
        Assert.assertEquals(55, node.getValue());
    }

    @Test
    public void findNodeTest_shouldFail() {
        BinaryTreeNode node = BinarySearchTreeSolver.find(this.root, 56);
        Assert.assertNull(node);
    }

    @Test
    public void insertNodeTest() {
        BinarySearchTreeSolver.insert(this.root, 56);
        BinaryTreeNode node = BinarySearchTreeSolver.find(this.root, 56);
        Assert.assertNotNull(node);
        if (node.getParent().getLeftChild() == node) {
            Assert.assertTrue(node.getParent().getValue() >= 56);
        } else {
            Assert.assertTrue(node.getParent().getValue() < 56);
        }
    }

    @Test
    public void deleteNodeTest() {
        BinarySearchTreeSolver.delete(this.root, 42);
        BinaryTreeNode node = BinarySearchTreeSolver.find(this.root, 42);
        Assert.assertNull(node);
    }
}
