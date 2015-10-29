package hr.mogh.problems.intercom.customerlocator;

/**
 * Customer with location data.
 * Created by vlado on 22.10.2015.
 */
public class Customer implements Comparable<Customer> {
    private int id;
    private String name;
    private double latitude;
    private double longitude;

    public Customer(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int compareTo(Customer that) {
        int comparisonResult = 0;
        if (this.getId() < that.getId()) {
            comparisonResult = -1;
        } else if (this.getId() > that.getId()) {
            comparisonResult = 1;
        }
        return comparisonResult;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
