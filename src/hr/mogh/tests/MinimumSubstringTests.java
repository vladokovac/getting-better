package hr.mogh.tests;

import hr.mogh.problems.minimumsubstring.MinimumSubstringSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests designed to check if MinimumSubstringSolver works as intended.<p/>
 * Created by vlado on 5.11.2015.
 * @see MinimumSubstringSolver MinimumSubstringSolver
 */
public class MinimumSubstringTests {

    @Test
    public void findMinimumSubstringTest() {
        String input = "adobecodebanc";
        String substringElements = "abc";
        String minString = MinimumSubstringSolver.findMinumumSubstring(input, substringElements);
        Assert.assertTrue(minString.length() > 0);
        Assert.assertEquals("banc", minString);
    }
}
