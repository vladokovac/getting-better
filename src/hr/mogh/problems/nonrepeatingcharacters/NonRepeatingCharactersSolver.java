package hr.mogh.problems.nonrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Solves the following problem:<br/>
 * <code>Rearrange characters in a string so that no character repeats twice.<br/><br/>
 * <p/>
 * Input: aaabc <br/>
 * Output: abaca<br/><br/>
 * Input: aa <br/>
 * Output: No valid output<br/><br/>
 * Input: aaaabc <br/>
 * Output: No valid output</code><br/>
 * Created by vlado on 16.11.2015.
 */
public class NonRepeatingCharactersSolver {

    /**
     * Rearranges characters in the input string in such a way that two same characters repeat.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     * @param input Input string to be rearranged.
     * @return Non-repeating string. Null if such an arrangement is impossible.
     */
    public static String rearrangeNonRepeating(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        Map<Character, Integer> characterAppearances = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            int count = 0;
            if (characterAppearances.containsKey(character)) {
                count = characterAppearances.get(character);
            }
            characterAppearances.put(character, count + 1);
        }

        String nonRepeatingString;
        try {
            char[] nonRepeatingArray = new char[input.length()];
            while (characterAppearances.size() > 0) {
                // find maximum appearing character
                int maxAppearances = 0;
                Character maxCharacter = null;
                for (Character character : characterAppearances.keySet()) {
                    int value = characterAppearances.get(character);
                    if (value > maxAppearances) {
                        maxAppearances = value;
                        maxCharacter = character;
                    }
                }
                characterAppearances.remove(maxCharacter);

                // insert found character into the new string
                for (int i = 0; i < nonRepeatingArray.length; i++) {
                    if (nonRepeatingArray[i] == '\0') {
                        if ((i + (maxAppearances - 1) * 2) >= nonRepeatingArray.length) {
                            throw new IllegalArgumentException("Not enough space to rearrange characters without them" +
                                    " repeating.");
                        }
                        for (int j = 0; j < maxAppearances; j++) {
                            nonRepeatingArray[i + j * 2] = maxCharacter;
                        }
                        break;
                    }
                }
            }

            nonRepeatingString = String.valueOf(nonRepeatingArray);
        } catch (IllegalArgumentException iae) {
            nonRepeatingString = null;
        }

        return nonRepeatingString;
    }
}
