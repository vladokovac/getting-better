package hr.mogh.tests;

import hr.mogh.problems.reversepositiveintegers.ReversePositivesSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Contains tests designed to check if ReversePositivesSolver works as intended.<p/>
 * Created by vlado on 17.11.2015.
 * @see ReversePositivesSolver ReversePositivesSolver
 */
public class ReversePositivesTests {

    @Test
    public void reversePositiveIntegersTest() {
        Integer[] integers = (Integer[]) Arrays.asList(4, 3, 8, 9, -2, 6, 10, 13, -1, 2, 3).toArray();
        Integer[] reversedIntegers = ReversePositivesSolver.reversePositiveIntegers(integers);
        Assert.assertNotNull(reversedIntegers);
        Assert.assertEquals(integers.length, reversedIntegers.length);
        Assert.assertEquals(9, (int) reversedIntegers[0]);
        Assert.assertEquals(8, (int) reversedIntegers[1]);
        Assert.assertEquals(3, (int) reversedIntegers[2]);
        Assert.assertEquals(4, (int) reversedIntegers[3]);
        Assert.assertEquals(-2, (int) reversedIntegers[4]);
    }

    @Test
    public void reversePositiveIntegersTest_nullInput() {
        Integer[] reversedIntegers = ReversePositivesSolver.reversePositiveIntegers(null);
        Assert.assertNull(reversedIntegers);
    }

    @Test
    public void reversePositiveIntegersTest_emptyInput() {
        Integer[] reversedIntegers = ReversePositivesSolver.reversePositiveIntegers(new Integer[0]);
        Assert.assertNotNull(reversedIntegers);
        Assert.assertEquals(0, reversedIntegers.length);
    }
}
