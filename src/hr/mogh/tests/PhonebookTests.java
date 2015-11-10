package hr.mogh.tests;

import hr.mogh.problems.phonebook.Person;
import hr.mogh.problems.phonebook.Phonebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlado on 10.11.2015.
 */
public class PhonebookTests {

    private Phonebook phonebook;

    @Before
    public void setup() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Wesley Guthrie", "0586035911"));
        people.add(new Person("Chaim Trevino", "0773575014"));
        people.add(new Person("Merritt Shepard", "0792323080"));
        people.add(new Person("Fitzgerald Mccarthy", "0225907929"));
        people.add(new Person("Keane Dudley", "0734882316"));
        people.add(new Person("Ali Odonnell", "0972908413"));
        phonebook = new Phonebook(people);
    }

    @Test
    public void findByNameTest_nameExists() {
        String name = "Fitzgerald Mccarthy";
        String number = "0225907929";
        Person person = phonebook.lookupByName(name);
        Assert.assertNotNull(person);
        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(number, person.getPhoneNumber());
    }

    @Test
    public void findByNameTest_noSuchName() {
        String name = "Caldwell Mcneil";
        Person person = phonebook.lookupByName(name);
        Assert.assertNull(person);
    }

    @Test
    public void findByNumber_numberExists() {
        String name = "Ali Odonnell";
        String number = "0972908413";
        Person person = phonebook.lookupByPhoneNumber(number);
        Assert.assertNotNull(person);
        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(number, person.getPhoneNumber());
    }

    @Test
    public void findByNumber_noSuchNumber() {
        String number = "0446000572";
        Person person = phonebook.lookupByPhoneNumber(number);
        Assert.assertNull(person);
    }

    @Test
    public void addPerson() {
        String name = "Jelani Jacobs";
        String number = "0773913295";
        Person person = new Person(name, number);
        boolean isAdded = phonebook.addPerson(person);
        Assert.assertTrue(isAdded);
        Person lookupResult = phonebook.lookupByName(name);
        Assert.assertNotNull(lookupResult);
        Assert.assertEquals(name, lookupResult.getName());
        Assert.assertEquals(number, lookupResult.getPhoneNumber());
    }

    @Test
    public void addPerson_invalidData() {
        boolean isAdded = phonebook.addPerson(null);
        Assert.assertFalse(isAdded);
        isAdded = phonebook.addPerson(new Person(null, "0773913295"));
        Assert.assertFalse(isAdded);
        isAdded = phonebook.addPerson(new Person("ABC", null));
        Assert.assertFalse(isAdded);
        isAdded = phonebook.addPerson(new Person("", "0773913295"));
        Assert.assertFalse(isAdded);
        isAdded = phonebook.addPerson(new Person("Jelani Jacobs", ""));
        Assert.assertFalse(isAdded);
    }
}
