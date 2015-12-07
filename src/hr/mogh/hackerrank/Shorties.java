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
}
