package hr.mogh.crackingthecodinginterview.ch3.AnimalShelter;

import java.util.List;

/**
 * Represents an animal with a defined type.
 * Created by vlado on 18/10/2016.
 */
public class Animal {

    private AnimalType type;
    private long timeArrived;

    public Animal (AnimalType type, long timeArrived) {
        this.type = type;
        this.timeArrived = timeArrived;
    }

    public AnimalType getType() {
        return type;
    }

    public long getTimeArrived() {
        return timeArrived;
    }
}
