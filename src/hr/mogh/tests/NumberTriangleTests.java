package hr.mogh.tests;

import com.sun.javaws.exceptions.InvalidArgumentException;
import hr.mogh.problems.numbertriangle.NumberTriangleSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests written to ensure NumberTriangleSolver works as intended
 * Created by vlado on 16.12.2015.
 * @see NumberTriangleSolver NumberTriangleSolver
 */
public class NumberTriangleTests {

    @Test
    public void getMaximumTotalTest() {
        String input = "5#9#6#4#6#8#0#7#1#5";
        double total = NumberTriangleSolver.getMaximumTotal(input);
        Assert.assertEquals(29, total, 0.000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInput_notATriangle() {
        String input = "5#9#6#4#6#8#0#7#1";
        double total = NumberTriangleSolver.getMaximumTotal(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInput_illegalFormat(){
        String input = "5#9##4#6#8#0#7#";
        double total = NumberTriangleSolver.getMaximumTotal(input);
    }
}
