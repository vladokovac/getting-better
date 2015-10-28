package hr.mogh.tests;

import hr.mogh.problems.intercom.customerlocator.Customer;
import hr.mogh.problems.intercom.customerlocator.CustomerLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Contains tests written to ensure CustomerLoader works as intended.
 * Created by vlado on 22.10.2015.
 */
public class CustomerLoaderTests {
    @Test
    public void testLoadCustomers() {
        try {
            List<Customer> customerList = CustomerLoader.loadCustomersFromFile("customers.txt");
            Assert.assertNotNull(customerList);
            Assert.assertEquals(32, customerList.size());
            Assert.assertTrue(customerList.get(0).getName().length() > 0);
            Assert.assertTrue(customerList.get(0).getId() > 0);
            Assert.assertTrue(customerList.get(0).getLatitude() != 0);
            Assert.assertTrue(customerList.get(0).getLongitude() != 0);
        } catch (Exception exc) {
            Assert.assertTrue(false);
        }
    }
}
