package hr.mogh.crackingthecodinginterview.ch1;

/**
 * Solves the following problem:<br/>
 * <code>Implement a method to perform basic string compression using the counts of repeated characters. For example,
 * the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.</code><p/>
 * Created by vlado on 13.1.2016.
 */
public class StringCompressor {

    /**
     * Compresses a string to "char + number of occurrences format". Eg. "aabbc" -> "a2b2c1".<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param string Input string to be compressed.
     * @return Compressed string or original string if compressed string ends up being longer than the original string.
     */
    public static String compressString(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        StringBuilder sb = new StringBuilder();
        char currentChar = '\0';
        int charOccurrences = 0;
        for (int i = 0; i < string.length(); i++) {
            if (currentChar != string.charAt(i)) {
                if (charOccurrences > 0) {
                    sb.append(currentChar).append(charOccurrences);
                }
                currentChar = string.charAt(i);
                charOccurrences = 1;
            } else {
                charOccurrences++;
            }
        }
        sb.append(currentChar).append(charOccurrences);

        String compressedString = sb.toString();
        return compressedString.length() > string.length() ? string : compressedString;
    }
}
