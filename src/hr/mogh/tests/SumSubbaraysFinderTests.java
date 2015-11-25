package hr.mogh.tests;

import hr.mogh.problems.subarrayswithinrange.SumSubarraysFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Contains tests designed to check if SumSubarraysFinder works as intended.<p/>
 * Created by vlado on 25.11.2015.<br/>
 * @see SumSubarraysFinder SumSubarraysFinder
 */
public class SumSubbaraysFinderTests {

    private static Integer[] integers = new Integer[]{-3, 9, 1, 1, 8, 6, -1, -5};

    @Test
    public void findSubarraysTest() {
        int lo = 5;
        int hi = 9;
        List<Integer[]> subarrays = SumSubarraysFinder.findSubarrays(integers, lo, hi);
        Assert.assertNotNull(subarrays);
        Assert.assertEquals(8, subarrays.size());
        for (int i = 0; i < subarrays.size(); i++) {
            int sum = calculateArraySum(subarrays.get(i));
            Assert.assertTrue(sum >= lo);
            Assert.assertTrue(sum <= hi);
        }
    }

    private int calculateArraySum(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            sum += integers[i];
        }
        return sum;
    }
}
