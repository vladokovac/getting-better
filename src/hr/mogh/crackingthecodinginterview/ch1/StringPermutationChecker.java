package hr.mogh.crackingthecodinginterview.ch1;

import java.util.HashMap;
import java.util.Map;

/**
 * Solves the following problem:<br/>
 * <code>Given two strings, write a method to decide if one is a permutation of the other.</code><br/>
 * Created by vlado on 8.1.2016.
 */
public class StringPermutationChecker {

    /**
     * Checks if a string is a permutation of another string.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param firstString  String to be checked.
     * @param secondString String to be checked against.
     * @return True if a firstString is a permutation of secondString.
     */
    public static boolean isPermutation(String firstString, String secondString) {
        boolean isPermutation = false;

        if (firstString == null || secondString == null || firstString.length() != secondString.length()) {
            return false;
        }

        Map<Character, Integer> firstStringMap = mapCharacterOccurences(firstString);
        Map<Character, Integer> secondStringMap = mapCharacterOccurences(secondString);

        if (firstStringMap.size() == secondStringMap.size()) {
            isPermutation = true;
            for (Character key : firstStringMap.keySet()) {
                if (!secondStringMap.containsKey(key) || (!firstStringMap.get(key).equals(secondStringMap.get(key)))) {
                    isPermutation = false;
                    break;
                }
            }
        }

        return isPermutation;
    }

    /**
     * Maps character occurrences of a string.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n)</code>.
     *
     * @param string String to be mapped.
     * @return Map containing characters with numbers of times each of them appeared in the input string.
     */
    private static Map<Character, Integer> mapCharacterOccurences(String string) {
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            int characterAppearances = 0;
            if (stringMap.containsKey(character)) {
                characterAppearances = stringMap.get(character);
            }
            stringMap.put(character, characterAppearances + 1);
        }
        return stringMap;
    }
}
