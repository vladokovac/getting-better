package hr.mogh.tests;

import hr.mogh.problems.crossingstreams.SortedListMergeSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains tests designed to check if SortedListMergeSolver works as intended.<p/>
 * Created by vlado on 18.11.2015.
 *
 * @see SortedListMergeSolver SortedListMergeSolver
 */
public class SortedListMergeTests {

    @Test
    public void mergeTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 9, 14, 19, 20, 20, 50));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(0, 2, 3, 4, 5, 8, 11, 17, 23, 29, 51, 52, 53, 54, 55));
        List<Integer> mergedList = SortedListMergeSolver.mergeSortedLists(firstList, secondList);
        Assert.assertNotNull(mergedList);
        Assert.assertEquals(firstList.size() + secondList.size(), mergedList.size());
        Assert.assertEquals(0, mergedList.get(0).intValue());
        Assert.assertEquals(1, mergedList.get(1).intValue());
        Assert.assertEquals(2, mergedList.get(2).intValue());
        Assert.assertEquals(3, mergedList.get(3).intValue());
    }

    @Test
    public void firstInputNullTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 9, 14, 19, 20, 20, 50));
        List<Integer> mergedList = SortedListMergeSolver.mergeSortedLists(null, list);
        Assert.assertNotNull(mergedList);
        Assert.assertEquals(list.size(), mergedList.size());
        Assert.assertEquals(list.get(0).intValue(), mergedList.get(0).intValue());
        Assert.assertEquals(list.get(1).intValue(), mergedList.get(1).intValue());
        Assert.assertEquals(list.get(2).intValue(), mergedList.get(2).intValue());
        Assert.assertEquals(list.get(3).intValue(), mergedList.get(3).intValue());
    }

    @Test
    public void secondInputNullTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 9, 14, 19, 20, 20, 50));
        List<Integer> mergedList = SortedListMergeSolver.mergeSortedLists(list, null);
        Assert.assertNotNull(mergedList);
        Assert.assertEquals(list.size(), mergedList.size());
        Assert.assertEquals(list.get(0).intValue(), mergedList.get(0).intValue());
        Assert.assertEquals(list.get(1).intValue(), mergedList.get(1).intValue());
        Assert.assertEquals(list.get(2).intValue(), mergedList.get(2).intValue());
        Assert.assertEquals(list.get(3).intValue(), mergedList.get(3).intValue());
    }
}
