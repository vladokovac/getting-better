package hr.mogh.tests;

import hr.mogh.problems.intercom.customerlocator.Customer;
import hr.mogh.problems.intercom.customerlocator.CustomerLocator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains tests written to ensure CustomerLocator works as intended.
 * Created by vlado on 29.10.2015.
 */
public class CustomerLocatorTests {

    private CustomerLocator customerLocator;
    private List<Customer> customerList;
    private static final double INTERCOM_LATITUDE = 53.3381985;
    private static final double INTERCOM_LONGITUDE = -6.2592576;
    private static final double RANGE = 100;

    @Test
    public void testLocateCustomers_customerOutOfRange() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(99, "Test Customer", 89.9997, 0.0));
        customerLocator = new CustomerLocator(INTERCOM_LATITUDE, INTERCOM_LONGITUDE, customerList);
        String customerInfo = customerLocator.getCustomersInRange(RANGE);
        Assert.assertTrue(customerInfo.isEmpty());
    }

    @Test
    public void testLocateCustomers_customerInRange() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(12, "Christina McArdle", 52.986375, -6.043701));
        customerLocator = new CustomerLocator(INTERCOM_LATITUDE, INTERCOM_LONGITUDE, customerList);
        String customerInfo = customerLocator.getCustomersInRange(RANGE);
        Assert.assertFalse(customerInfo.isEmpty());
    }

    @Test
    public void testLocateCustomers_noCustomers() {
        customerList = new ArrayList<>();
        customerLocator = new CustomerLocator(INTERCOM_LATITUDE, INTERCOM_LONGITUDE, customerList);
        String customerInfo = customerLocator.getCustomersInRange(RANGE);
        Assert.assertTrue(customerInfo.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLocatorInitialization_nullList() {
        customerLocator = new CustomerLocator(INTERCOM_LATITUDE, INTERCOM_LONGITUDE, null);
    }
}
