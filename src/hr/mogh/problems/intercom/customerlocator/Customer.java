package hr.mogh.problems.intercom.customerlocator;

/**
 * Customer with location data.
 * Created by vlado on 22.10.2015.
 */
public class Customer {
    private int id;
    private String name;
    private double longitude;
    private double latitude;

    public Customer(int id, String name, double longitude, double latitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
