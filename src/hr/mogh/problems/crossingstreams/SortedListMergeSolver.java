package hr.mogh.problems.crossingstreams;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem:<br/>
 * <code>Given an active stream of sorted arrays, how would you merge them efficiently?</code><br/>
 * Created by vlado on 18.11.2015.
 */
public class SortedListMergeSolver {

    /**
     * Merges two sorted lists.<br/>
     * Space complexity: <code>O(n)</code><br/>
     * Time complexity: <code>O(n)</code>
     *
     * @param firstList  First list in the merge.
     * @param secondList Second list in the merge.
     * @return A sorted list containing elements from both input lists.
     */
    public static List<Integer> mergeSortedLists(List<Integer> firstList, List<Integer> secondList) {
        if (firstList == null || firstList.size() == 0) {
            return secondList;
        }
        if (secondList == null || secondList.size() == 0) {
            return firstList;
        }

        int i = 0;
        int j = 0;
        List<Integer> mergedList = new ArrayList<>();
        while (i < firstList.size() || j < secondList.size()) {

            if (i >= firstList.size()) {
                mergedList.addAll(secondList.subList(j, secondList.size()));
                break;
            }

            if (j >= secondList.size()) {
                mergedList.addAll(firstList.subList(i, firstList.size()));
                break;
            }

            if (firstList.get(i) < secondList.get(j)) {
                mergedList.add(firstList.get(i));
                i++;
            } else {
                mergedList.add(secondList.get(j));
                j++;
            }
        }

        return mergedList;
    }
}
