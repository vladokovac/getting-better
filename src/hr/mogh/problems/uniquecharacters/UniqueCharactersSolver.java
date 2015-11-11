package hr.mogh.problems.uniquecharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Solve the following problem:<br/>
 * <code>C program to accept two strings and print characters which are not present in first string. <br/>
 * Example: 1 string: apple <br/>
 * 2 string: aeroplane <br/>
 * output: ro</code><br/>
 * Created by vlado on 11.11.2015.
 */
public class UniqueCharactersSolver {

    /**
     * Finds characters that appear in the second string and don't appear in the first.<br/>
     * Space complexity: <code>O(N)</code><br/>
     * Time complexity: <code>O(N+M)</code
     *
     * @param firstString  The first string. Used as a list of used characters.
     * @param secondString Second string. Used to find characters that don't exist in the first string.
     * @return Characters found in secondString but not firstString.
     */
    public static String findUniqueCharacters(String firstString, String secondString) {
        String nonRepeatingCharacters;

        if (secondString == null || secondString.length() == 0) {
            return "";
        }

        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < secondString.length(); i++) {
            characterSet.add(secondString.charAt(i));
        }

        if (firstString != null && firstString.length() > 0) {
            for (int i = 0; i < firstString.length(); i++) {
                Character character = firstString.charAt(i);
                if (characterSet.contains(character)) {
                    characterSet.remove(character);
                }
            }
        }

        Object[] uniqueCharacters = characterSet.toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object uniqueCharacter : uniqueCharacters) {
            stringBuilder.append(uniqueCharacter.toString());
        }
        nonRepeatingCharacters = stringBuilder.toString();

        return nonRepeatingCharacters;
    }
}
