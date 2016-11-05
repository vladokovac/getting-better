package hr.mogh.crackingthecodinginterview.ch3.AnimalShelter;

import java.util.List;

/**
 * Represents an animal with a defined type.
 * Created by vlado on 18/10/2016.
 */
public class Animal {

    private AnimalType type;

    public Animal (AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }
}
