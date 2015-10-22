package hr.mogh.tests;

import hr.mogh.problems.intercom.customerlocator.CustomerLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by vlado on 22.10.2015.
 */
public class CustomerLocatorTests {
    @Test
    public void testLoadCustomers() {
        try {
            CustomerLoader.loadCustomersFromFile("customers.txt");
        }catch (FileNotFoundException fnfe) {
            Assert.assertTrue(false);
        } catch (IOException ioe) {
            Assert.assertTrue(false);
        }
    }
}
