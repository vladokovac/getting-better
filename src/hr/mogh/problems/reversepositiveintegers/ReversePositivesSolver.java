package hr.mogh.problems.reversepositiveintegers;

import java.util.Arrays;

/**
 * Solves the following problem:<br/>
 * <code>Given an array of integers of unknown size, how to reverse the order of the positive integers?<br/>
 * <br/>
 * Ex [4 3 8 9 -2 6 10 13 -1 2 3 .. ] => [ 9 8 3 4 -2 13 10 6 -1 3 2]
 * </code><br/>
 * Created by vlado on 17.11.2015.
 */
public class ReversePositivesSolver {

    /**
     * Reverses positive elements in subarrays of the input array that consist only of positive integers.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     * @param integers The input array whose elements are reversed.
     * @return Reversed-positives array. <code>null</code> if input is <code>null</code>.
     */
    public static Integer[] reversePositiveIntegers(Integer[] integers) {
        if (integers == null) {
            return null;
        }

        Integer[] reversedIntegers = Arrays.copyOf(integers, integers.length);

        int i = 0;
        int j = 0;
        while (i < integers.length) {
            // find limit of subarray (a negative integer)
            while (i < integers.length) {
                if (integers[i] < 0) {
                    break;
                }
                i++;
            }

            // reverse subarray members
            int k = i - 1;
            while (j < k) {
                int leftNumber = reversedIntegers[j];
                reversedIntegers[j] = reversedIntegers[k];
                reversedIntegers[k] = leftNumber;
                j++;
                k--;
            }

            i++;
            j = i;
        }

        return reversedIntegers;
    }
}
