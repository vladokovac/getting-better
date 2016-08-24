package hr.mogh.datastructures.sorting;

/**
 * Has sorting algorithm implementations
 * Created by vlado on 6.1.2016.
 */
public class SortingAlgorithms {

    /**
     * Standard quicksort implementation.<br/>
     * Space complexity:<code>O(log n).</code><br/>
     * Time complexity:<code>O(n log n).</code>
     *
     * @param string String to be sorted.
     * @return Sorted string.
     */
    public static String quicksort(String string) {
        if (string == null) {
            return "";
        }
        if (string.length() <= 1) {
            return string;
        }

        int midIndex = string.length() / 2;
        char midPoint = string.charAt(midIndex);
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i == midIndex) {
                continue;
            }
            char character = string.charAt(i);
            if (midPoint > character) {
                sbLeft.append(character);
            } else {
                sbRight.append(character);
            }
        }
        return quicksort(sbLeft.toString()) + midPoint + quicksort(sbRight.toString());
    }
}
