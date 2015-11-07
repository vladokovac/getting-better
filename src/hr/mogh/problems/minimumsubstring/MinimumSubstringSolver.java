package hr.mogh.problems.minimumsubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Solves the following problem:
 * Given a random string S and another string T with unique elements, find the minimum consecutive sub-string of S
 * such that it contains all the elements in T. <p/>
 * example: <br/>
 * S='adobecodebanc' <br/>
 * T='abc' <br/>
 * answer='banc'
 *
 * Created by vlado on 5.11.2015.
 */
public class MinimumSubstringSolver {

    /**
     * Finds the minimum substring that contains all search elements.<br/>
     * Space complexity: O(n)<br/>
     * Time complexity: O(n^2)
     * @param input The string in which the substring is to be found.
     * @param searchElements The list of unique characters that need to be found in the input.
     * @return The minimum substring. <code>null</code> if no such substring exists.
     */
    public static String findMinumumSubstring(String input, String searchElements) {
        String minimumSubstring = "";

        if (input == null || input.length() == 0) {
            return null;
        }
        if (searchElements == null || searchElements.length() == 0) {
            return null;
        }
        if (input.length() < searchElements.length()) {
            return null;
        }
        Set<Character> allElementsSet = new HashSet<>();
        for (int i = 0; i < searchElements.length(); i++) {
            allElementsSet.add(searchElements.charAt(i));
        }

        int minSize = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (allElementsSet.contains(currentChar)) {
                Set<Character> foundCharacters = new HashSet<>();
                foundCharacters.add(currentChar);
                int j = i;
                while (j < input.length() - 1 && foundCharacters.size() < allElementsSet.size()) {
                    j++;
                    Character subChar = input.charAt(j);
                    if (!foundCharacters.contains(subChar) && allElementsSet.contains(subChar)) {
                        foundCharacters.add(subChar);
                    }
                }
                if (foundCharacters.size() == allElementsSet.size()) {
                    int foundSize = j - i;
                    if (foundSize < minSize) {
                        minSize = foundSize;
                        minIndex = i;
                    }
                }
            }
        }

        if (minSize < Integer.MAX_VALUE) {
            minimumSubstring = input.substring(minIndex, minIndex + minSize + 1);
        }

        return minimumSubstring;
    }

    /**
     * Finds the minimum substring that contains all search elements. Uses resizing rolling window.<br/>
     * Space complexity: O(n)<br/>
     * Time complexity: O(n)
     * @param input The string in which the substring is to be found.
     * @param searchElements The list of unique characters that need to be found in the input.
     * @return The minimum substring. <code>null</code> if no such substring exists.
     */
    public static String findMinimumSubstringWindow(String input, String searchElements) {
        if (input == null || input.length() == 0) {
            return null;
        }
        if (searchElements == null || searchElements.length() == 0) {
            return null;
        }
        if (input.length() < searchElements.length()) {
            return null;
        }

        int[] foundCharactersCount = new int[256];
        Set<Character> foundCharacters = new HashSet<>();
        Set<Character> allSearchElements = new HashSet<>();
        for (int i = 0; i < searchElements.length(); i++) {
            allSearchElements.add(searchElements.charAt(i));
        }

        int j = 0;
        int i = 0;

        int minSize = Integer.MAX_VALUE;
        int minIndex = 0;

        while (j < input.length()) {
            Character currentCharacter = input.charAt(j);
            if (allSearchElements.contains(currentCharacter)) {
                foundCharactersCount[currentCharacter]++;
                if (!foundCharacters.contains(currentCharacter)) {
                    foundCharacters.add(currentCharacter);
                }
            }

            if (foundCharacters.size() == allSearchElements.size()) {
                while (i < j) {
                    Character charInFront = input.charAt(i);
                    if (allSearchElements.contains(charInFront)) {
                        if (foundCharactersCount[currentCharacter] > 1) {
                            foundCharactersCount[currentCharacter]--;
                        } else {
                            break;
                        }
                    }
                    i++;
                }

                if (j - i < minSize) {
                    minSize = j - i;
                    minIndex = i;
                }
            }

            j++;
        }

        return input.substring(minIndex, minIndex + minSize + 1);
    }
}
