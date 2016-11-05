package hr.mogh.crackingthecodinginterview.ch3.AnimalShelter;

import java.util.LinkedList;
import java.util.List;

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

    private LinkedList<Animal> animals;

    public AnimalShelter() {
        animals = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        animals.add(animal);
    }

    public Animal dequeueAny() {
        Animal foundAnimal;
        try {
            foundAnimal = animals.removeFirst();
        } catch (Exception exc) {
            foundAnimal = null;
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
     * Time complexity: <code>O(n)</code>
     *
     * @param type Animal type.
     * @return Dequeued animal. Null if no animal of that type exists.
     */
    public Animal dequeueType(AnimalType type) {
        Animal foundAnimal = null;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getType() == type) {
                foundAnimal = animals.remove(i);
            }
        }
        return foundAnimal;
    }
}
