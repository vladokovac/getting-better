package hr.mogh.hackerrank;

/**
 * Small problems found on HackerRank.com.
 * Created by vlado on 7.12.2015.
 */
public class Shorties {

    /**
     * Sums big integers in an array.<br/>
     * Space complexity : <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param numbers Numbers to be summed.
     * @return A big sum.
     */
    public static long sumBigNumbers(int[] numbers) {
        long sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * Draws a staircase made out of hash tags.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     *
     * @param height The height of the staircase.
     * @return The ASCII staircase.
     */
    public static String drawStaircase(int height) {
        String staircase;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (j < height - i - 1) {
                    stringBuilder.append(' ');
                } else {
                    stringBuilder.append('#');
                }
            }
            stringBuilder.append('\n');
        }
        staircase = stringBuilder.toString();
        staircase = staircase.substring(0, staircase.length() - 1);

        System.out.println(staircase);
        return staircase;
    }

    /**
     * Calculate the absolute difference between the sums of integers on the two diagonals of a square matrix of
     * numbers.
     *
     * @param n      The size (width or height) of the matrix.
     * @param matrix The integer matrix.
     * @return Absolute difference between the diagonal sums.
     */
    public static int calculateDiagonalDifference(int n, int[][] matrix) {
        int sumDiagTopLeft = 0;
        int sumDiagBotLeft = 0;

        for (int i = 0; i < n; i++) {
            sumDiagBotLeft += matrix[i][n - 1 - i];
            sumDiagTopLeft += matrix[i][i];
        }

        return Math.abs(sumDiagBotLeft - sumDiagTopLeft);
    }

    /**
     * Calculates the size of The Utopian Tree. The tree grows according to the following rules:<br/>
     * <code>The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each
     * summer, its height increases by 1 meter.</code>
     *
     * @param growthCycles The number of growth cycles the tree goes through.
     * @return Size of the tree after <code>growthCycles</code> cycles.
     */
    public static int getUtopianTreeSize(int growthCycles) {
        int size = 1;

        for (int i = 0; i < growthCycles; i++) {
            if (i % 2 == 0) {
                size *= 2;
            } else {
                size += 1;
            }
        }

        return size;
    }

    /**
     * Finds the number of digits in a number that divide the number evenly.
     *
     * @param number Input number.
     * @return The number of evenly-dividing digits.
     */
    public static int findDivisibleDigits(int number) {
        int divisibleDigits = 0;
        int mod = 10;
        int div = 1;
        while (div <= number) {
            int digit = number % mod;
            digit /= div;
            if (digit != 0 && number % digit == 0) {
                divisibleDigits++;
            }

            mod *= 10;
            div *= 10;
        }
        return divisibleDigits;
    }

    /**
     * Finds all the "square integers" within a range of integers. Square integers are integers that are the result
     * of a square of any integer. Range boundaries are included in the search.<br/>
     * Space complexity: <code>O(1)</code>.<br/>
     * Time complexity: <code>O(sqrt(n))</code>.
     *
     * @param lowLimit  Low limit of the range.
     * @param highLimit High limit of the range.
     * @return The number of square integers.
     */
    public static int countSquareIntegers(long lowLimit, long highLimit) {
        int squareIntCount = 0;
        double epsilon = 0.000001;

        if (lowLimit > highLimit) {
            return 0;
        }

        int i = 1;
        long square = 1;
        while (square <= highLimit) {
            if (square >= lowLimit && square <= highLimit) {
                squareIntCount++;
            }
            i++;
            square = i * i;
        }

        return squareIntCount;
    }
}
