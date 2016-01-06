package hr.mogh.crackingthecodinginterview.ch1;

import hr.mogh.datastructures.sorting.SortingAlgorithms;

/**
 * Solves the following problem:<br/>
 * <code>Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional
 * data structures?</code><br/>
 * Created by vlado on 6.1.2016.
 */
public class UniqueCharacterStringSolver {

    /**
     * Checks if a string is comprised entirely of unique characters.<br/>
     * Space complexity:<code>O(1)</code>.<br/>
     * Time complexity:<code>O(n)</code>.
     *
     * @param string The input string.
     * @return True if all the strings characters are unique.
     */
    public static boolean hasAllUniqueCharacters(String string) {
        boolean hasUniqueCharacters = true;
        boolean[] characterAppearances = new boolean[512];

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (characterAppearances[character]) {
                hasUniqueCharacters = false;
                break;
            } else {
                characterAppearances[character] = true;
            }
        }

        return hasUniqueCharacters;
    }

    /**
     * Checks if a string is comprised entirely of unique characters. Doesn't use any additional data structures.<br/>
     * Space complexity:<code>O(log n)</code>.
     * Time complexity:<code>O(n log n)</code>.
     *
     * @param string The input string.
     * @return True if all the strings characters are unique.
     */
    public static boolean hasAllUniqueCharactersNoExtraDataStructures(String string) {
        boolean hasUniqueCharacters = true;

        if (string == null || string.length() == 0) {
            return true;
        }

        String sortedString = SortingAlgorithms.quicksort(string);
        for (int i = 0; i < sortedString.length() - 1; i++) {
            if (sortedString.charAt(i) == sortedString.charAt(i + 1)) {
                hasUniqueCharacters = false;
                break;
            }
        }

        return hasUniqueCharacters;
    }


}
