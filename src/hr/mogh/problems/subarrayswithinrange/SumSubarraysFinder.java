package hr.mogh.problems.subarrayswithinrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solves the following problem:<br/>
 * <code>Given an array int32 arr[] of size n, return the number of non-empty contiguous subarrays whose sum lies in
 * range [a, b]
 * <p/>
 * That is, implement the following naive algorithm faster than O(n^2)
 * <p/>
 * def naive_algorithm(lst, a, b):<br/>
 * result = 0<br/>
 * for i in xrange(len(lst)):<br/>
 * for j in xrange(i, len(lst)):<br/>
 * if a <= sum(lst[i:j + 1]) <= b:<br/>
 * result += 1<br/>
 * return result<br/>
 * <p/>
 * Examples:
 * <br/>
 * count([1,2,3], 0, 3) = 3 # [1], [2], [3], [1, 2], [3]
 * count([-2,5,-1], -2, 2) = 3 # [-2], [-1], [-2, 5, -1]
 * You may assume that there are no overflows, that is sum(|x_i|) <= MAX_INT - 1</code><br/>
 * Created by vlado on 25.11.2015.
 */
public class SumSubarraysFinder {

    /**
     * Finds subarrays whose elements are within a range when summed up.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     *
     * @param integers Array of integers.
     * @param sumLow   Lower limit of the range.
     * @param sumHigh  Higher limit of the range.
     * @return Found subarrays.
     */
    public static List<Integer[]> findSubarrays(Integer[] integers, int sumLow, int sumHigh) {
        if (integers == null || integers.length == 0 || sumHigh < sumLow) {
            return new ArrayList<>();
        }

        List<Integer[]> matchingArrays = new ArrayList<>();
        for (int windowSize = 1; windowSize < integers.length; windowSize++) {
            for (int i = 0; i < integers.length - windowSize; i++) {
                int subarraySum = 0;
                for (int j = 0; j < windowSize; j++) {
                    subarraySum += integers[i + j];
                }
                if (subarraySum >= sumLow && subarraySum <= sumHigh) {
                    matchingArrays.add(Arrays.copyOfRange(integers, i, i + windowSize));
                }
            }
        }
        return matchingArrays;
    }
}
