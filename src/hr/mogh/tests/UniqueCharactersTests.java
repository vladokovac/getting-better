package hr.mogh.tests;

import hr.mogh.problems.uniquecharacters.UniqueCharactersSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests designed to check if UniqueCharactersSolver works as intended.<p/>
 * Created by vlado on 11.11.2015.
 * @see UniqueCharactersSolver UniqueCharactersSolver
 */
public class UniqueCharactersTests {

    @Test
    public void findUniqueCharactersTest() {
        String uniqueCharacters = UniqueCharactersSolver.findUniqueCharacters("apple", "aeroplane");
        Assert.assertEquals(3, uniqueCharacters.length());
        Assert.assertTrue(uniqueCharacters.contains("r"));
        Assert.assertTrue(uniqueCharacters.contains("o"));
        Assert.assertTrue(uniqueCharacters.contains("n"));
    }

    @Test
    public void findUniqueCharactersTest_nullFirstString() {
        String uniqueCharacters = UniqueCharactersSolver.findUniqueCharacters(null, "apple");
        Assert.assertNotNull(uniqueCharacters);
        Assert.assertEquals(4, uniqueCharacters.length());
        Assert.assertTrue(uniqueCharacters.contains("a"));
        Assert.assertTrue(uniqueCharacters.contains("p"));
        Assert.assertTrue(uniqueCharacters.contains("l"));
        Assert.assertTrue(uniqueCharacters.contains("e"));
    }

    @Test
    public void findUniqueCharactersTest_nullSecondString() {
        String uniqueCharacters = UniqueCharactersSolver.findUniqueCharacters("apple", null);
        Assert.assertNotNull(uniqueCharacters);
        Assert.assertEquals(0, uniqueCharacters.length());
    }
}
