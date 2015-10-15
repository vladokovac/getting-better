package hr.mogh.tests;

import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains tests written to ensure LinkedList algorithms work as intended.
 * Created by vlado on 13.10.2015.
 */
public class LinkedListTests {

    private static List<Object> data = new ArrayList<>(Arrays.asList((Object) "book", "look", "crook", "nook",
            "nuts", "buck", "loot", "hoot", "horn", "turn", "run", "prune", "boom", "loom", "hunt", "poop", "punt",
            "treat", "greet", "null", "point", "runt", "lint", "burn", "lick", "luck", "lunch", "boon", "broom",
            "pole", "noon", "boot", "boat", "brook", "bunk", "trunk", "room", "tomb", "gloom", "foot", "font",
            "cool", "fool", "boil", "rune", "pool", "burn", "barn", "born", "bank", "pink", "coil", "moat", "most",
            "mist", "must", "dust", "tool", "wool", "will", "till", "want", "foil", "toil", "toll", "told", "mold",
            "teal", "tell", "real", "rear", "gear", "fear", "pear", "fears"));

    private DoublyLinkedList list;

    @Before
    public void setup() {
        list = new DoublyLinkedList(data);
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void listGenerationTest() {
        Assert.assertNotNull(list);
        Assert.assertEquals(data.size(), list.getSize());
    }

    @Test
    public void findNodeTest_shouldSucceed() {
        ListNode node = list.find("nuts");
        Assert.assertNotNull(node);
    }

    @Test
    public void findNodeTest_shouldFail() {
        ListNode node = list.find("nutz");
        Assert.assertNull(node);
    }

    @Test
    public void insertNodeAfterTest() {
        String insertedData = "brownfox";
        ListNode node = list.find("nuts");
        ListNode oldNodeBefore = node.getNodeBefore();
        ListNode oldNodeAfter = node.getNodeAfter();
        list.insertAfter(node, insertedData);
        ListNode insertedNode = list.find(insertedData);
        Assert.assertNotNull(insertedNode);
        Assert.assertEquals(node.getNodeAfter(), insertedNode);
        Assert.assertEquals(insertedNode.getNodeBefore(), node);
        Assert.assertEquals(oldNodeBefore, node.getNodeBefore());
        Assert.assertEquals(oldNodeAfter, insertedNode.getNodeAfter());
        // Check the insertion by looking for the node in reverse. This checks that the reverse links are correctly set.
        insertedNode = list.findReverse(insertedData);
        Assert.assertNotNull(insertedNode);
    }

    @Test
    public void insertNodeBeforeTest() {
        String insertedData = "brownfox";
        ListNode node = list.find("nuts");
        ListNode oldNodeBefore = node.getNodeBefore();
        ListNode oldNodeAfter = node.getNodeAfter();
        list.insertBefore(node, insertedData);
        ListNode insertedNode = list.find(insertedData);
        Assert.assertNotNull(insertedNode);
        Assert.assertEquals(node.getNodeBefore(), insertedNode);
        Assert.assertEquals(insertedNode.getNodeAfter(), node);
        Assert.assertEquals(oldNodeBefore, insertedNode.getNodeBefore());
        Assert.assertEquals(oldNodeAfter, node.getNodeAfter());
        // Check the insertion by looking for the node in reverse. This checks that the reverse links are correctly set.
        insertedNode = list.findReverse(insertedData);
        Assert.assertNotNull(insertedNode);
    }
}
