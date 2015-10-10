package hr.mogh.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic tree node. Contains <code>Object</code> payload, parent pointer and list of children.
 */
public class Node {
    Object payload;
    Node parent;
    List<Node> children;

    public Node() {
        payload = null;
        children = new ArrayList<>();
        parent = null;
    }

    public Node(Object payload, Node parent, List<Node> children) {
        this.payload = payload;
        this.parent = parent;
        this.setChildren(children);
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setChildren(List<Node> children) {
        for (Node child : children) {
            child.setParent(this);
        }
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "payload=" + payload +
                ", children=" + children +
                '}';
    }
}
