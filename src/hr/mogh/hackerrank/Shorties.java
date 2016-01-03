package hr.mogh.hackerrank;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Cuts sticks in rounds. Counts how many sticks were cut in each round. Sticks are cut until there are no more
     * sticks to cut. The length of the cut is determined by the shortest stick.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     *
     * @param initialStickLengths Initial stick lengths.
     * @return A list containing the number of sticks that were cut in each roung of cutting.
     */
    public static List<Integer> countCutSticks(List<Integer> initialStickLengths) {
        List<Integer> cutSticksList = new ArrayList<>();
        List<Integer> stickLengths = initialStickLengths;
        while (stickLengths.size() > 0) {
            int cutLength;
            int minLength = Integer.MAX_VALUE;

            // find shortest stick so we know how long the cut is
            for (int i = 0; i < stickLengths.size(); i++) {
                if (stickLengths.get(i) < minLength) {
                    minLength = stickLengths.get(i);
                }
            }
            cutLength = minLength;

            // cut the sticks
            List<Integer> nextStickLengths = new ArrayList<>();
            cutSticksList.add(stickLengths.size());
            for (int i = 0; i < stickLengths.size(); i++) {
                if (stickLengths.get(i) > cutLength) {
                    nextStickLengths.add(stickLengths.get(i) - cutLength);
                }
            }
            stickLengths = nextStickLengths;
        }

        return cutSticksList;
    }

    /**
     * Finds if a matrix contains a particular submatrix.<p/>
     * Calculates submatrix sums for matrix submatrices with the same dimensions as the input submatrix. Uses the
     * sums to find potential matches in the matrix. Then compares matrix elements to input submatrix elements to
     * determine if there is a match.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^4)</code>
     *
     * @param matrix    The matrix to be searched.
     * @param submatrix The submatrix to be found in the matrix.
     * @return True if a match has been found.
     */
    public static boolean containsSubmatrixMappedSearch(int[][] matrix, int[][] submatrix) {
        boolean isMatrixFound = false;

        // matrix.height > submatrix.height
        if (matrix.length == 0 || submatrix.length == 0 || matrix.length < submatrix.length) {
            return false;
        }
        // matrix.width > submatrix.width
        if (matrix[0].length == 0 || submatrix[0].length == 0 || matrix[0].length < submatrix[0].length) {
            return false;
        }

        int matrixWidth = matrix[0].length;
        int matrixHeight = matrix.length;

        int submatrixWidth = submatrix[0].length;
        int submatrixHeight = submatrix.length;

        int[][] submatrixSums = new int[matrixHeight][matrixWidth];

        // calculate submatrix sums for whole matrix
        for (int j = 0; j <= matrixHeight - submatrixHeight; j++) {
            for (int i = 0; i <= matrixWidth - submatrixWidth; i++) {
                int submatrixSum = 0;
                for (int y = 0; y < submatrixHeight; y++) {
                    for (int x = 0; x < submatrixWidth; x++) {
                        submatrixSum += matrix[y + j][x + i];
                    }
                }
                submatrixSums[j][i] = submatrixSum;
            }
        }

        // calculate submatrix sum for search submatrix
        int submatrixSum = 0;
        for (int j = 0; j < submatrixHeight; j++) {
            for (int i = 0; i < submatrixWidth; i++) {
                submatrixSum += submatrix[j][i];
            }
        }

        // check if any matrix sums equal the search submatrix sum
        for (int j = 0; j < matrixHeight; j++) {
            for (int i = 0; i < matrixWidth; i++) {
                if (submatrixSums[j][i] == submatrixSum) {
                    isMatrixFound = true;
                    for (int y = 0; y < submatrixHeight; y++) {
                        for (int x = 0; x < submatrixWidth; x++) {
                            if (submatrix[y][x] != matrix[y + j][x + i]) {
                                isMatrixFound = false;
                                break;
                            }
                        }
                        if (!isMatrixFound) {
                            break;
                        }
                    }
                }
                if (isMatrixFound) {
                    break;
                }
            }
            if (isMatrixFound) {
                break;
            }
        }

        return isMatrixFound;
    }

    /**
     * Finds if a matrix contains a particular submatrix.<br/>
     * Space complexity: <code>O(n^2)</code>.<br/>
     * Time complexity: <code>O(N^4)</code>.
     *
     * @param matrix    The matrix to be searched.
     * @param submatrix The submatrix to be found in the matrix.
     * @return
     */
    public static boolean containsSubmatrix(int[][] matrix, int[][] submatrix) {
        boolean containsSubmatrix = false;

        for (int i = 0; i <= matrix.length - submatrix.length; i++) {
            for (int j = 0; j <= matrix[0].length - submatrix[0].length; j++) {
                containsSubmatrix = true;
                for (int x = 0; x < submatrix.length; x++) {
                    for (int y = 0; y < submatrix[0].length; y++) {
                        if (submatrix[x][y] != matrix[i + x][j + y]) {
                            containsSubmatrix = false;
                            break;
                        }
                    }
                    if (!containsSubmatrix) {
                        break;
                    }
                }
                if (containsSubmatrix) {
                    break;
                }
            }
            if (containsSubmatrix) {
                break;
            }
        }

        return containsSubmatrix;
    }
}
