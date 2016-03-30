package hr.mogh.crackingthecodinginterview.ch1;

/**
 * Solves the following problem:
 * <p/>
 * <code>Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
 * s1 and s2, write code to check if s2 is a rotation of s1using only one call to isSubstring (e.g., "watterbottle"
 * is a rotation of "erbottlewat").</code><br/>
 * <p/>
 * Created by vlado on 30.3.2016.
 */
public class RotatedStringDetector {

    /**
     * Determines if a string is a rotated version of another string.
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param string   The rotated string candidate.
     * @param original The original string.
     * @return True if the candidate is a rotated version of the original.
     */
    public static boolean isRotatedString(String string, String original) {
        if (string.length() != original.length()) {
            return false;
        }
        
        String doubleInput = string + string;
        return doubleInput.contains(original);
    }
}
