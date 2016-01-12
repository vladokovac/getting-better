package hr.mogh.crackingthecodinginterview.ch1;

/**
 * Solve the following problem:<br/>
 * <p/>
 * <code>Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end of the string to hold the additional characters, and that you are given the "true" length of the
 * string. (Not: if implementing in Java, please use a character array so that you can perform this operation in
 * place.)<br/>
 * Example:<br/>
 * Input:  "Mr John Smith    "<br/>
 * Output: "Mr%20John%20Smith"</code><br/>
 * Created by vlado on 8.1.2016.
 */
public class SpaceReplacer {

    /**
     * Expands string with spaces. ' ' is expanded to '%20'.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.<br/>
     *
     * @param input Input string.
     * @return Expanded string.
     */
    public static char[] replaceSpaces(char[] input) {

        if (input == null || input.length == 0) {
            return input;
        }

        char[] output = input;
        int i = 0;
        while (output[input.length - i - 1] == ' ') {
            i++;
        }
        int extraSpaces = i;

        int wordEndIndex = input.length - i - 1;
        int expandedStringIndex = input.length - 1;
        while (extraSpaces > 0) {
            // find the start of a word
            int wordStartIndex = wordEndIndex - 1;
            while (output[wordStartIndex] != ' ') {
                wordStartIndex--;
            }

            // move word to beginning of expanded string and move expanded string index (so we know which part of the
            // string is resolved)
            for (int j = wordEndIndex; j > wordStartIndex; j--) {
                char temp = output[j];
                output[j] = output[expandedStringIndex];
                output[expandedStringIndex] = temp;
                expandedStringIndex--;
            }

            // expand one space char with '%20'
            output[expandedStringIndex--] = '0';
            output[expandedStringIndex--] = '2';
            output[expandedStringIndex--] = '%';
            extraSpaces -= 2;

            if (extraSpaces <= 0) {
                break;
            }

            // find the end of the next word
            wordEndIndex = expandedStringIndex;
            while (output[wordEndIndex] == ' ') {
                wordEndIndex--;
            }
        }
        return output;
    }
}
