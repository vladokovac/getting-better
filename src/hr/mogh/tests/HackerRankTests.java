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

    @Test
    public void calculateDiagonalDiffTest() {
        int n = 3;
        int[][] matrix = new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};
        int sum = Shorties.calculateDiagonalDifference(n, matrix);
        Assert.assertEquals(15, sum);
    }

    @Test
    public void getUtopianTreeSizeTest() {
        int[] cycles = new int[]{0, 1, 4};
        int[] expectedResults = new int[]{1, 2, 7};

        for (int i = 0; i < cycles.length; i++) {
            int treeSize = Shorties.getUtopianTreeSize(cycles[i]);
            Assert.assertEquals(expectedResults[i], treeSize);
        }
    }

    @Test
    public void findDivisibleDigitsTest() {
        int[] digits = new int[]{1, 12, 1234, 2222, 20};
        int[] expectedResults = new int[]{1, 2, 2, 4, 1};
        for (int i = 0; i < digits.length; i++) {
            int digitCount = Shorties.findDivisibleDigits(digits[i]);
            Assert.assertEquals(expectedResults[i], digitCount);
        }
    }
}
