package hr.mogh.problems.numbertriangle;

/**
 * Solves the following problem:<br/>
 * <code>Imagine you have a row of numbers like below(a traiangle). By starting at the top of the triangle find the
 * maximum number in each line and sum them up example below <br/>
 * 5 <br/>
 * 9 6 <br/>
 * 4 6 8 <br/>
 * 8 7 15<br/>
 * <br/>
 * Answer I.e. 5+9+8+7 = 29 <br/>
 * writw a code to find the maximum total from top to bottom. Assume triangle can have at most 100000 rows.<br/>
 * <br/>
 * Input Output specifications <br/>
 * Input Specification <br/>
 * A string of n numbers (where 0<=n<=10^10) <br/>
 * eg.5#9#6#4#6#8#0#7#1#5<br/>
 * <br/>
 * Output Specification <br/>
 * A sum of the max numbers in each line (as string ) or Output invalid in case of invalid input/triangle<br/>
 * <br/>
 * Examples <br/>
 * eg1. <br/>
 * Input :5#9#6#4#6#8#0#7#1#5 <br/>
 * Output:29<br/>
 * <br/>
 * eg 2 . <br/>
 * Input :5#9#6#4#6#8#0#7#1 <br/>
 * Output:invalid<br/>
 * <br/>
 * eg 2 . <br/>
 * Input :5#9##4#6#8#0#7#1 <br/>
 * Output:invalid</code><br/>
 * Created by vlado on 16.12.2015.
 */
public class NumberTriangleSolver {

    /**
     * Parses the input and finds local maximums in triangle rows. Sums the local maximums in a maximum total.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.<br/>
     * @param input The input containing numbers split with '#'.
     * @return The sum of maximum values in each triangle row.
     * @throws IllegalArgumentException
     */
    public static double getMaximumTotal(String input) throws IllegalArgumentException {
        double maximumTotal = 0;
        int localMax = 0;
        int triangleRowSize = 1;
        int currentIndex = 0;
        int triangleRowStart = 0;

        try {
            while (currentIndex < input.length()) {
                if ((triangleRowSize * 2 + triangleRowStart) - 1 > input.length()) { // triangle row size in index
                    // because last element is not '#'
                    throw new IllegalArgumentException("invalid");
                }

                Integer value = Integer.valueOf(input.substring(currentIndex, currentIndex + 1));
                if (localMax < value) {
                    localMax = value;
                }
                currentIndex += 2;

                if (currentIndex >= triangleRowStart + triangleRowSize * 2) {
                    maximumTotal += localMax;
                    localMax = 0;
                    triangleRowStart = currentIndex;
                    triangleRowSize++;
                }
            }
        } catch (ClassCastException cce) {
            throw new IllegalArgumentException("invalid");
        }

        return maximumTotal;
    }
}
