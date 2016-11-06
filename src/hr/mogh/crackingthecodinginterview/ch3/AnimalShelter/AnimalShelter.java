package hr.mogh.crackingthecodinginterview.ch3.AnimalShelter;

import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Solve the following problem:
 * <p/>
 * <code>An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People must
 * adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.</code>
 * <p/>
 * Created by vlado on 18/10/2016.
 */
public class AnimalShelter {

    private LinkedList<Animal> cats;
    private LinkedList<Animal> dogs;

    public AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    private LinkedList<Animal> getAnimalList(AnimalType type) {
        LinkedList<Animal> animalList = null;
        switch (type) {
            case CAT:
                animalList = cats;
                break;
            case DOG:
                animalList = dogs;
                break;
            default:
                break;
        }
        return animalList;
    }

    /**
     * Enqueues an animal. <br/>
     * Space complexity: <code>O(1)</code><br/>
     * Time complexity: <code>O(1)</code>
     *
     * @param type The type of animal being enqueued.
     */
    public void enqueue(AnimalType type) {
        Animal newAnimal = new Animal(type, new Date().getTime());
        this.getAnimalList(type).add(newAnimal);
    }

    /**
     * Dequeues the oldest animal regardless of type.<br/>
     * Space complexity: <code>O(1)</code><br/>
     * Time complexity: <code>O(1)</code>
     *
     * @return Oldest animal in the shelter. Null if the shelter is empty.
     */
    public Animal dequeueAny() {
        Animal foundAnimal = null;

        long catArrivalTime = Long.MAX_VALUE;
        long dogArrivalTime = Long.MAX_VALUE;

        if (cats != null && cats.size() > 0) {
            catArrivalTime = cats.getFirst().getTimeArrived();
        }
        if (dogs != null && dogs.size() > 0) {
            dogArrivalTime = dogs.getFirst().getTimeArrived();
        }

        try {
            if (catArrivalTime > dogArrivalTime) {
                foundAnimal = dogs.remove(0);
            } else {
                foundAnimal = cats.remove(0);
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException exc) {
            // do nothing
        }

        return foundAnimal;
    }

    public Animal dequeueDog() {
        return this.dequeueType(AnimalType.DOG);
    }

    public Animal dequeueCat() {
        return this.dequeueType(AnimalType.CAT);
    }

    /**
     * Dequeues a specific type of animal.<br/>
     * Space complexity: <code>O(1)</code><br/>
     * Time complexity: <code>O(1)</code>
     *
     * @param type Animal type.
     * @return Dequeued animal. Null if no animal of that type exists.
     */
    private Animal dequeueType(AnimalType type) {
        Animal foundAnimal = null;
        try {
            LinkedList<Animal> animalList = this.getAnimalList(type);
            foundAnimal = animalList.remove(0);
        } catch (UnsupportedOperationException uoe) {
            // list is empty, do nothing
        }
        return foundAnimal;
    }
}
