package hr.mogh.crackingthecodinginterview.ch4;

import hr.mogh.datastructures.trees.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solves the following problem:
 * <p>
 * <code>Given a directed graph, design an algorithm to find out whether there is a route between two nodes.</code>
 * <p>
 * Created by vlado on 17/11/2016.
 */
public class RouteFinder {

    /**
     * Finds the route between two nodes of a directed graph.
     *
     * @param from The starting node.
     * @param to   The end node.
     * @return The route between two nodes. Null if no such route exists.
     */
    public static List<Node> findRoute(Node from, Node to) {
        return findNodeDfs(from, to);
    }

    /**
     * Finds a route between two nodes using DFS.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param from The starting node.
     * @param to   The end node.
     * @return The list of nodes in the route between two nodes. Null if no such route exists.
     */
    private static List<Node> findNodeDfs(Node from, Node to) {
        if (from == null || to == null) {
            return null;
        }
        if (from.equals(to)) {
            return Arrays.asList(from);
        }

        List<Node> route = null;
        for (Node child : from.getChildren()) {
            route = findNodeDfs(child, to);
            if (route != null) {
                break;
            }
        }

        if (route != null) {
            List<Node> expandedList = new ArrayList<>();
            expandedList.add(from);
            expandedList.addAll(route);
            route = expandedList;
        }

        return route;
    }
}
