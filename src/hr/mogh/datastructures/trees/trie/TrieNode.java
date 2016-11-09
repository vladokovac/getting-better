package hr.mogh.datastructures.trees.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * A node of a SuperTrie tree structure.
 * Created by vlado on 07/11/2016.
 */
public class TrieNode {

    private char value;
    private List<TrieNode> children;
    private boolean isWordEnd;

    public TrieNode(char value, boolean isWordEnd) {
        this.children = new ArrayList<>();
        this.value = value;
        this.isWordEnd = isWordEnd;
    }

    public char getValue() {
        return value;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public void addChild(TrieNode child) {
        this.children.add(child);
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }
}
