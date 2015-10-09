package hr.mogh.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlado on 9.10.2015..
 */
public class Node {
    Object payload;
    List<Node> children;

    public Node() {
        payload = null;
        children = new ArrayList<>();
    }

    public Node(Object payload, List<Node> children) {
        this.payload = payload;
        this.children = children;
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

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
