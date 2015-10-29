package hr.mogh.problems.intercom.customerlocator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implements a locator for customers who are within a certain range of the locator.
 * Created by vlado on 29.10.2015.
 */
public class CustomerLocator {

    private double latitude;
    private double longitude;
    private List<Customer> customerList;
    private static final double earthRadius = 6371;

    public CustomerLocator(double latitude, double longitude, List<Customer> customerList) throws
            IllegalArgumentException {
        this.longitude = longitude;
        this.latitude = latitude;
        if (customerList != null) {
            this.customerList = customerList;
        } else {
            throw new IllegalArgumentException("Customer list must be a non-null value.");
        }
    }

    /**
     * Calculate shortest distance between customer and locator on Earth measured along the surface. Uses
     * great-circle distance. (@see <a href="https://en.wikipedia.org/wiki/Great-circle_distance">https://en
     * .wikipedia.org/wiki/Great-circle_distance</a>).
     *
     * @param customer Customer to which distance will be calculated.
     * @return Distance from locator to customer.
     */
    private double calculateDistance(Customer customer) {
        double longitudeDiff = Math.abs(customer.getLongitude() - this.longitude);
        double longitudeDiffInRadians = Math.toRadians(longitudeDiff);
        double customerLatInRadians = Math.toRadians(customer.getLatitude());
        double baseLatInRadians = Math.toRadians(latitude);

        double centralAngle = Math.acos(Math.sin(baseLatInRadians) * Math.sin(customerLatInRadians) + Math.cos
                (baseLatInRadians) * Math.cos(customerLatInRadians) * Math.cos(longitudeDiffInRadians));
        double distance = centralAngle * earthRadius;
        return distance;
    }

    /**
     * Gets customer info (ID + name) for all customers in range of the locator.
     *
     * @param range Customer search range. In kilometers.
     * @return Information for all customers (ID + name).
     */
    public String getCustomersInRange(double range) {
        List<Customer> customersWithinRange = new ArrayList<>();
        for (Customer customer : this.customerList) {
            double distance = this.calculateDistance(customer);
            if (distance <= range) {
                customersWithinRange.add(customer);
            }
        }
        Collections.sort(customersWithinRange);
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customersWithinRange) {
            stringBuilder.append(customer.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
