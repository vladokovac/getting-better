package hr.mogh.tests;
/*
 * Contains tests designed to check if UniqueCharactersSolver works as intended.<p/>
 * Created by vlado on 11.11.2015.
 * @see UniqueCharactersSolver UniqueCharactersSolver
 */

import hr.mogh.problems.nonrepeatingcharacters.NonRepeatingCharactersSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests designed to check if NonRepeatingCharactersSolver works as intended.<p/>
 * Created by vlado on 16.11.2015.
 * @see NonRepeatingCharactersSolver NonRepeatingCharactersSolver
 */
public class NonRepeatingCharactersTests {

    @Test
    public void rearrangeNonRepeatingTest_shouldPass() {
        String input = "aaabc";
        String output = NonRepeatingCharactersSolver.rearrangeNonRepeating(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(input.length(), output.length());
        Assert.assertEquals(3, countCharactersInString(output, 'a'));
        Assert.assertEquals(1, countCharactersInString(output, 'b'));
        Assert.assertEquals(1, countCharactersInString(output, 'c'));
    }

    @Test
    public void rearrangeNonRepeatingTest_shouldFail() {
        String input = "aaaabc";
        String output = NonRepeatingCharactersSolver.rearrangeNonRepeating(input);
        Assert.assertNull(output);
    }

    @Test
    public void rearrangeNonRepeatingTest_nullInput() {
        String output = NonRepeatingCharactersSolver.rearrangeNonRepeating(null);
        Assert.assertNull(output);
    }

    @Test
    public void rearrangeNonRepeatingTest_emptyInput() {
        String output = NonRepeatingCharactersSolver.rearrangeNonRepeating(null);
        Assert.assertNull(output);
    }

    @Test
    public void rearrangeNonRepeatingTest_repeatingInput() {
        String output = NonRepeatingCharactersSolver.rearrangeNonRepeating("aa");
        Assert.assertNull(output);
    }

    private int countCharactersInString(String string, Character character) {
        return string.length() - string.replace(character.toString(), "").length();
    }
}
