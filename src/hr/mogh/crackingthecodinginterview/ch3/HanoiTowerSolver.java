package hr.mogh.crackingthecodinginterview.ch3;

import java.util.Stack;

/**
 * Solves the following problem: <p/>
 * <code>In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide
 * onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk
 * sits on top of an even larger one). You have the following constraints:
 * 1. Only one disk can be moved at a time.
 * 2. A disk is slid off the top of one tower onto the next tower.
 * 3. A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 * </code>
 * <p/>
 * Created by vlado on 26.9.2016.
 */
public class HanoiTowerSolver {

    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;
    private static Stack<Integer> stack3;

    /**
     * Solves the problem of Hanoi Towers with the set number of disks.
     *
     * @param totalDisks Total number of disks on the first tower.
     * @return The state of the destination stack if all the disks are on it. Null otherwise.
     */
    public static Stack solve(int totalDisks) {
        prepareStacks(totalDisks);
        solveHanoi(totalDisks, stack1, stack3, stack2);
        return stack3.size() > 0 && stack3.size() == totalDisks ? stack3 : null;
    }

    /**
     * Solves The Hanoi Tower problem.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(2^totalDisks - 1)</code>.
     *
     * @param disk   The current disk size.
     * @param source The source tower.
     * @param dest   The destination tower.
     * @param aux    The auxiliary tower.
     */
    private static void solveHanoi(int disk, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> aux) {
        if (disk == 0) {
            moveDisk(source, dest);
        } else {
            solveHanoi(disk - 1, source, aux, dest);
            moveDisk(source, dest);
            solveHanoi(disk - 1, aux, dest, source);
        }
    }

    private static void prepareStacks(int n) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack3 = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            stack1.push(i);
        }
    }

    private static boolean moveDisk(Stack<Integer> from, Stack<Integer> to) {
        boolean isSuccessful = false;

        if (from.size() > 0 && (to.size() == 0 || (from.peek() < to.peek()))) {
            to.push(from.pop());
            isSuccessful = true;
        }
        return isSuccessful;
    }
}
