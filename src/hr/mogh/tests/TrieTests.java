package hr.mogh.tests;

import hr.mogh.datastructures.trees.trie.SuperTrie;
import hr.mogh.datastructures.trees.trie.TrieNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Tests for <code>SuperTrie</code> and <code>TrieNode</code> classes.<p/>
 * Created by vlado on 07/11/2016.
 */
public class TrieTests {

    @Test
    public void insertTest() {
        SuperTrie superTrie = new SuperTrie();
        String input = "alakhazam";
        superTrie.insert(input);
        Assert.assertTrue(isSingleBranchTrie(superTrie.getRoot()));
        Assert.assertEquals(input.length(), superTrie.size());
    }

    @Test
    public void insertRecursiveTest() {
        SuperTrie superTrie = new SuperTrie();
        String input = "abracadabra";
        superTrie.insertRecursive(input);
        Assert.assertTrue(isSingleBranchTrie(superTrie.getRoot()));
        Assert.assertEquals(input.length(), superTrie.size());
    }

    @Test
    public void insertTwoWordsTest() {
        SuperTrie superTrie = new SuperTrie();
        String input1 = "alakhazam";
        String input2 = "alladin";
        int expectedTrieSize = 14;
        superTrie.insert(input1);
        superTrie.insert(input2);
        Assert.assertFalse(isSingleBranchTrie(superTrie.getRoot()));
        Assert.assertEquals(expectedTrieSize, superTrie.size());
    }

    @Test
    public void insertTwoWordsRecursiveTest() {
        SuperTrie superTrie = new SuperTrie();
        String input1 = "alakhazam";
        String input2 = "alladin";
        int expectedTrieSize = 14;
        superTrie.insertRecursive(input1);
        superTrie.insertRecursive(input2);
        Assert.assertFalse(isSingleBranchTrie(superTrie.getRoot()));
        Assert.assertEquals(expectedTrieSize, superTrie.size());
    }

    @Test
    public void emptyTreeSizeTest() {
        SuperTrie superTrie = new SuperTrie();
        Assert.assertEquals(0, superTrie.size());
    }

    @Test
    public void emptyTreeLongestWordTest() {
        SuperTrie superTrie = new SuperTrie();
        Assert.assertEquals("", superTrie.getLongestWord());
    }

    @Test
    public void longestWordTest() {
        SuperTrie superTrie = new SuperTrie();
        String[] inputs = new String[]{"titillating", "aveiro", "nicaragua", "unreputed", "overzealous", "jalap",
                "calibrater", "untranscendent", "brutify", "frankfurter"};
        String longestWord = "untranscendent";
        for (String input : inputs) {
            superTrie.insertRecursive(input);
        }

        Assert.assertEquals(longestWord, superTrie.getLongestWord());
    }

    @Test
    public void getAllWordsTest() {
        SuperTrie superTrie = new SuperTrie();
        String[] inputs = new String[]{"titillating", "aveiro", "nicaragua", "unreputed", "overzealous", "jalap",
                "calibrater", "untranscendent", "brutify", "frankfurter"};
        String longestWord = "untranscendent";
        for (String input : inputs) {
            superTrie.insertRecursive(input);
        }

        List<String> allValues = superTrie.getValues();

        Assert.assertEquals(inputs.length, allValues.size());
        for (String input : inputs) {
            Assert.assertTrue(allValues.contains(input));
        }
    }

    private boolean isSingleBranchTrie(TrieNode node) {
        boolean hasOneBranch = true;
        while (node.getChildren() != null && node.getChildren().size() > 0) {
            if (node.getChildren().size() == 1) {
                node = node.getChildren().get(0);
            } else {
                hasOneBranch = false;
                break;
            }
        }
        return hasOneBranch;
    }
}
