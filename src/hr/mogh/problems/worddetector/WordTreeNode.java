package hr.mogh.problems.worddetector;

import java.util.ArrayList;
import java.util.List;

/**
 * A "word tree node" where each node is a letter in a word. The children are all letters that create longer words
 * that begin with all the characters from the parent up to that node.
 * Created by vlado on 23.11.2015.
 */
public class WordTreeNode {

    private List<WordTreeNode> children;
    private WordTreeNode parent;
    private Character value;
    private boolean isLastCharInWord;

    public WordTreeNode(WordTreeNode parent, Character value, boolean isLastCharInWord) {
        this.children = new ArrayList<>();
        this.parent = parent;
        this.value = value == null ? null : Character.toLowerCase(value);
        this.isLastCharInWord = isLastCharInWord;
    }

    public List<WordTreeNode> getChildren() {
        return children;
    }

    public void addChild(WordTreeNode child) {
        boolean isChildAdded = false;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getValue().equals(child.getValue())) {
                children.remove(i);
                children.add(child);
                isChildAdded = true;
            }
        }
        if (!isChildAdded) {
            children.add(child);
        }
    }

    public WordTreeNode getParent() {
        return parent;
    }

    public Character getValue() {
        return value;
    }

    public boolean isLastCharInWord() {
        return isLastCharInWord;
    }

    public String getParentToNodeString() {
        if (this.parent == null) {
            return "";
        } else {
            return this.parent.getParentToNodeString() + this.value;
        }
    }
}
