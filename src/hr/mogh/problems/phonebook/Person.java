package hr.mogh.problems.phonebook;

/**
 * Phonebook entry.
 * Created by vlado on 10.11.2015.
 */
public class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
