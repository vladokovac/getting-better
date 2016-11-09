package hr.mogh.datastructures.trees.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * A Trie implementation.
 * Created by vlado on 07/11/2016.
 */
public class SuperTrie {

    private TrieNode root;

    public SuperTrie() {
        this.root = new TrieNode('\0', false);
    }

    /**
     * Inserts a new word into the trie.<br/>
     * Space complexity: <code>O(m)</code>. (m is word length) <br/>
     * Time complexity: <code>O(n)</code>. (n is number of nodes in the trie)
     *
     * @param value The new word.
     */
    public void insert(String value) {
        TrieNode currentNode = root;
        char[] inputWord = value.toCharArray();
        for (int i = 0; i < inputWord.length; i++) {
            char character = inputWord[i];
            boolean containsCharacter = false;
            for (TrieNode child : currentNode.getChildren()) {
                if (child.getValue() == character) {
                    containsCharacter = true;
                    currentNode = child;
                    if (i == inputWord.length - 1) {
                        child.setWordEnd(true);
                    }
                    break;
                }
            }
            if (!containsCharacter) {
                TrieNode newChild = new TrieNode(character, i == inputWord.length - 1);
                currentNode.addChild(newChild);
                currentNode = newChild;
            }
        }
    }

    /**
     * Insert a new word into the trie using a recursive algorithm.<br/>
     * Space complexity: <code>O(m)</code>. (m is word length) <br/>
     * Time complexity: <code>O(n)</code>. (n is number of nodes in the trie)
     *
     * @param value The new word.
     */
    public void insertRecursive(String value) {
        insertWord(root, value);
    }

    /**
     * The internal implementation of the recursive insertion algorithm.
     *
     * @param node  The node to which the value is being added.
     * @param value The part of the word not inserted yet.
     */
    private void insertWord(TrieNode node, String value) {
        if (node == null || value == null || value.isEmpty()) {
            return;
        }

        char[] charArray = value.toCharArray();

        TrieNode nextChild = null;

        for (TrieNode child : node.getChildren()) {
            if (child.getValue() == charArray[0]) {
                nextChild = child;
                if (charArray.length == 1) {
                    child.setWordEnd(true);
                }
                break;
            }
        }

        if (nextChild == null) {
            nextChild = new TrieNode(charArray[0], charArray.length == 1);
            node.addChild(nextChild);
        }

        insertWord(nextChild, value.substring(1));
    }

    /**
     * Finds the longest word in the trie.<br/>
     * Space complexity: <code>O(1)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @return The longest word in the trie. Empty string if trie is empty.
     */
    public String getLongestWord() {
        return getLongestWordFromChildren(root).substring(1); // remove root value
    }

    /**
     * Internal implementation of the recursive longest word search algorithm.
     *
     * @param node A trie node. Searches it's children for the longest word.
     * @return The longest word found. Empty string if trie is empty.
     */
    private String getLongestWordFromChildren(TrieNode node) {
        String longestWord = "";
        if (node == null) {
            return longestWord;
        }

        for (TrieNode child : node.getChildren()) {
            String word = getLongestWordFromChildren(child);
            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }

        return node.getValue() + longestWord;
    }

    /**
     * Returns all the words stored in the trie.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @return All the words in the trie. Empty list if trie is empty.
     */
    public List<String> getValues() {
        return getAllWords(root);
    }

    /**
     * Recursive implementation of the word-searching algorithm. Searches for all word-ending nodes and reconstructs
     * words by backtracking.
     *
     * @param node A node whose value is added to all words from its children.
     * @return All stored words in the trie.
     */
    private List<String> getAllWords(TrieNode node) {
        List<String> foundWords = new ArrayList<>();

        for (TrieNode child : node.getChildren()) {
            List<String> childWords = getAllWords(child);

            for (String childWord : childWords) {
                foundWords.add(addNodeValue(node, childWord));
            }
        }

        if (node.isWordEnd()) {
            foundWords.add(String.valueOf(node.getValue()));
        }
        return foundWords;
    }

    /**
     * Adds the value of a node to a string if the node is not the trie root.<br/>
     * Space complexity: <code>O(m)</code>. (m is input string length).<br/>
     * Time complexity: <code>O(1)</code>.
     *
     * @param node  The node from which the value is added to the front of the value.
     * @param value The value that's being expanded with the node value.
     * @return A new string with the node value added in front of the argument string.
     */
    private String addNodeValue(TrieNode node, String value) {
        if (node == null || value == null || value.isEmpty()) {
            return "";
        }

        String returnString = value;
        if (node != root) {
            returnString = node.getValue() + value;
        }
        return returnString;
    }

    public TrieNode getRoot() {
        return root;
    }

    public int size() {
        return calculateSize(root);
    }

    /**
     * Returns number of nodes in a subtree of a trie node.<br/>
     * Space complexity: <code>O(1)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param node A trie node.
     * @return The number of nodes in the subtree of a trie node.
     */
    private int calculateSize(TrieNode node) {

        if (node == null) {
            return 0;
        }

        int count = node.getChildren().size();

        for (TrieNode child : node.getChildren()) {
            count += calculateSize(child);
        }

        return count;
    }
}
