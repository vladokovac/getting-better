package hr.mogh.tests;

import hr.mogh.problems.rotatingnumbers.RotatingNumbersSolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests designed to check if RotatingNumbersSolver works as intended.<p/>
 * Created by vlado on 10.11.2015.<br/>
 *
 * @see RotatingNumbersSolver RotatingNumbersSolver
 */
public class RotatingNumbersTests {

    private RotatingNumbersSolver solver;

    @Before
    public void setup() {
        solver = new RotatingNumbersSolver();
    }

    @Test
    public void rotateTest_isEqual() {
        boolean isEqual = solver.isEqualAfterRotation(619);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void rotateTest_isntEqual() {
        boolean isEqual = solver.isEqualAfterRotation(66);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void rotateTest_isntRotatable() {
        boolean isEqual = solver.isEqualAfterRotation(123);
        Assert.assertFalse(isEqual);
    }
}
