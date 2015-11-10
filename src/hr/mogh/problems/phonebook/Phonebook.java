package hr.mogh.problems.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Phonebook implementation. Solves the following problem:<br/>
 * <code>Given the two objects below, implement the methods defined in the Phonebook class. This is a simulated
 * phonebook. You should expect LookupByName and LookupByPhoneNumber to be called much more often than AddPerson.
 * Also, this is a multi-threaded simulation so your implementations of the functions other than the constructor
 * should be threadsafe.</code>
 * <br/>
 * Created by vlado on 10.11.2015.
 */
public class Phonebook {

    private List<Person> entries;
    private HashMap<String, Integer> nameMap;
    private HashMap<String, Integer> phoneNumberMap;
    private boolean isWriting;

    public Phonebook(List<Person> people) {
        entries = new ArrayList<>();
        nameMap = new HashMap<>();
        phoneNumberMap = new HashMap<>();

        for (int i = 0; i < people.size(); i++) {
            entries.add(people.get(i));
            Person person = people.get(i);
            nameMap.put(person.getName(), i);
            phoneNumberMap.put(person.getPhoneNumber(), i);
        }
    }

    public Person lookupByName(String name) {
        Person foundPerson = null;
        Integer personIndex = nameMap.get(name);
        if (personIndex != null) {
            foundPerson = entries.get(personIndex);
        }
        return foundPerson;
    }

    public Person lookupByPhoneNumber(String phoneNumber) {
        Person foundPerson = null;
        Integer personIndex = phoneNumberMap.get(phoneNumber);
        if (personIndex != null) {
            foundPerson = entries.get(personIndex);
        }
        return foundPerson;
    }

    public boolean addPerson(Person person) {
        if (person == null || person.getName() == null || person.getName().trim().length() == 0 ||
                person.getPhoneNumber() == null || person.getPhoneNumber().trim().length() == 0) {
            return false;
        }

        boolean isSuccessful = false;

        if (!isWriting) {
            isWriting = true;
            entries.add(person);
            int personIndex = entries.size() - 1;
            nameMap.put(person.getName(), personIndex);
            phoneNumberMap.put(person.getPhoneNumber(), personIndex);
            isWriting = false;
            isSuccessful = true;
        }
        return isSuccessful;
    }
}
