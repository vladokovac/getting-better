package hr.mogh.tests;

import hr.mogh.problems.intercom.ArrayFlattener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests designed to prove ArrayFlattener works as intended.
 * Created by vlado on 21.10.2015.
 */
public class ArrayFlattenerTests {

    Object[] inputArray;

    @Before
    public void setup() {
        inputArray = new Object[5];
        Object[] subarray1 = {3, 4, 5};
        Object[] subarray2 = {8};
        Object[] subarray3 = {9, 11, subarray2};
        Object[] subarray4 = {7, subarray3};
        Object[] array = {1, 2, subarray1, 6, subarray4};
        inputArray = array;
    }

    @After
    public void tearDown(){
        inputArray = null;
    }

    @Test
    public void flattenArrayTest() {
        Integer[] flattenedArray = ArrayFlattener.flattenArray(inputArray);
        Assert.assertEquals(10, flattenedArray.length);
    }
}
