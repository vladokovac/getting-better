package hr.mogh.tests;

import hr.mogh.problems.primeexpressible.PrimeExpressibleSolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlado on 1.11.2015.
 */
public class PrimeExpressibleTests {

    private Set<Double> primeNumbersSet;

    @Before
    public void setup() {
        primeNumbersSet = new HashSet<>();
        primeNumbersSet.add(2.0);
        primeNumbersSet.add(3.0);
    }

    @Test
    public void getNthExpressibleNumberTest() {
        double result = PrimeExpressibleSolver.getNthExpressibleNumber(primeNumbersSet, 6);
        Assert.assertEquals(8.0, result, 0.000001);
    }
}
