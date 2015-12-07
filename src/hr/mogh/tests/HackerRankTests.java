package hr.mogh.tests;

import hr.mogh.hackerrank.Shorties;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vlado on 7.12.2015.
 */
public class HackerRankTests {

    @Test
    public void sumBigNumbersTest() {
        long sum = Shorties.sumBigNumbers(new int[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005});
        Assert.assertTrue(5000000015L == sum);
    }

    @Test
    public void drawStaircaseTest() {
        String staircase = Shorties.drawStaircase(6);
        Assert.assertEquals(' ', staircase.charAt(4));
        Assert.assertEquals('#', staircase.charAt(5));
        Assert.assertEquals('#', staircase.charAt(11));
        Assert.assertEquals('#', staircase.charAt(12));
    }
}
