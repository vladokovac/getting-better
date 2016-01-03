package hr.mogh.tests;

import hr.mogh.hackerrank.Shorties;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void countSquareIntegersTest() {
        int[][] ranges = new int[][]{{1, 1}, {3, 9}, {17, 24}, {465868129, 988379794}};
        int[] expectedCounts = new int[]{1, 2, 0, 9855};
        for (int i = 0; i < ranges.length; i++) {
            int count = Shorties.countSquareIntegers(ranges[i][0], ranges[i][1]);
            Assert.assertEquals(expectedCounts[i], count);
        }
    }

    @Test
    public void countSquareIntegersTest_invalidInput() {
        int count = Shorties.countSquareIntegers(4, 2);
        Assert.assertEquals(0, count);
    }

    @Test
    public void countCutSticksTest_1() {
        List<Integer> stickLengths = Arrays.asList(5, 4, 4, 2, 2, 8);
        int[] expectedStickCounts = new int[]{6, 4, 2, 1};
        List<Integer> countedCutSticks = Shorties.countCutSticks(stickLengths);
        for (int i = 0; i < expectedStickCounts.length; i++) {
            Assert.assertEquals(expectedStickCounts[i], countedCutSticks.get(i).intValue());
        }
    }

    @Test
    public void countCutSticksTest_2() {
        List<Integer> stickLengths = Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1);
        int[] expectedStickCounts = new int[]{8, 6, 4, 1};
        List<Integer> countedCutSticks = Shorties.countCutSticks(stickLengths);
        for (int i = 0; i < expectedStickCounts.length; i++) {
            Assert.assertEquals(expectedStickCounts[i], countedCutSticks.get(i).intValue());
        }
    }

    @Test
    public void containsSubmatrixTest() {
        int[][] matrix = new int[][]{{1, 3, 2}, {4, 1, 1}, {5, 2, 5}, {1, 3, 4}};
        int[][] submatrix = new int[][]{{3}, {1}, {2}};
        Assert.assertTrue(Shorties.containsSubmatrixMappedSearch(matrix, submatrix));
        Assert.assertTrue(Shorties.containsSubmatrix(matrix, submatrix));
    }

    @Test
    public void containsSubmatrixTest_biggerMatrix() {
        int[][] matrix = new int[][]{{7, 2, 8, 3, 4, 5, 5, 8, 6, 4}, {6, 7, 3, 1, 1, 5, 8, 6, 1, 9}, {8, 9, 8, 8, 2,
                4, 2, 6, 4, 3}, {3, 8, 3, 0, 5, 8, 9, 3, 2, 4}, {2, 2, 2, 9, 5, 0, 5, 8, 1, 3}, {5, 6, 3, 3, 8, 4, 5,
                3, 7, 4}, {6, 4, 7, 3, 5, 3, 0, 2, 9, 3}, {7, 0, 5, 3, 1, 0, 6, 6, 0, 1}, {0, 8, 3, 4, 2, 8, 2, 9, 5,
                6}, {4, 6, 0, 7, 9, 2, 4, 1, 3, 7}};
        int[][] submatrix = new int[][]{{9, 5, 0, 5}, {3, 8, 4, 5}, {3, 5, 3, 0}};
        Assert.assertTrue(Shorties.containsSubmatrixMappedSearch(matrix, submatrix));
        Assert.assertTrue(Shorties.containsSubmatrix(matrix, submatrix));
    }

    @Test
    public void containsSubmatrixTest_doesNotContain() {
        int[][] matrix = new int[][]{{4, 0, 0, 4, 5, 3, 5, 9, 2, 1, 2, 6, 5, 6, 0}, {1, 1, 4, 2, 1, 3, 1, 3, 3, 0, 9,
                8, 6, 9, 2}, {4, 7, 4, 3, 8, 6, 0, 8, 2, 8, 7, 9, 6, 4, 8}, {5, 2, 2, 3, 5, 6, 9, 5, 1, 1, 8, 9, 1,
                6, 9}, {8, 8, 7, 1, 0, 9, 4, 5, 0, 4, 8, 7, 4, 9, 6}, {2, 5, 2, 8, 0, 2, 6, 3, 3, 3, 8, 8, 7, 8, 2},
                {5, 0, 2, 7, 7, 1, 4, 8, 4, 9, 6, 6, 7, 4, 8}, {0, 7, 5, 9, 7, 5, 2, 0, 7, 6, 9, 3, 7, 8, 0}, {5, 1,
                1, 7, 9, 9, 7, 8, 9, 5, 6, 2, 8, 0, 6}, {4, 0, 4, 0, 0, 7, 4, 5, 4, 2, 7, 2, 5, 0, 4}, {5, 4, 9, 0,
                4, 3, 8, 0, 9, 9, 1, 6, 0, 8, 0}, {9, 6, 2, 4, 1, 0, 8, 0, 9, 5, 3, 4, 8, 1, 1}, {4, 4, 5, 8, 9, 3,
                5, 2, 3, 7, 3, 3, 4, 7, 5}, {7, 6, 8, 7, 0, 5, 3, 0, 3, 2, 1, 4, 1, 7, 4}, {6, 5, 0, 6, 2, 9, 2, 7,
                0, 8, 8, 7, 1, 6, 0}};
        int[][] submatrix = new int[][]{{9, 9}, {9, 9}};
        Assert.assertFalse(Shorties.containsSubmatrixMappedSearch(matrix, submatrix));
        Assert.assertFalse(Shorties.containsSubmatrix(matrix, submatrix));
    }
}
