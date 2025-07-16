package com.example.assignment5;

import java.util.NoSuchElementException;
import java.util.Queue;

public class AnimalShelter {
    // Wanted to remind myself that things can be imported this way
    private final Queue<Animal> dogs = new java.util.LinkedList<>();
    private final Queue<Animal> cats = new java.util.LinkedList<>();
    private int arrivalOrder = 0;

    public void enqueue(Animal animal) {
        animal.setArrivalOrder(arrivalOrder++);
        switch (animal.getSpecies()){
            case "dog":
                dogs.offer(animal);
                break;
            case "cat":
                cats.offer(animal);
                break;
            default:
                throw new IllegalArgumentException("Only dogs or cats allowed 🐶🐱");
        }
    }
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null; // No animals available
        }
        if (dogs.isEmpty()) {
            return cats.poll(); // Only cats available
        }
        if (cats.isEmpty()) {
            return dogs.poll(); // Only dogs available
        }
        // Both dogs and cats are available, return the one with the earliest arrival order
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        return (dog.getArrivalOrder() < cat.getArrivalOrder()) ? dogs.poll() : cats.poll();
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty())
            throw new NoSuchElementException("No dogs available!");
        return dogs.poll();
    }

    public Animal dequeueCat() {
        if (cats.isEmpty())
            throw new NoSuchElementException("No cats available!");
        return cats.poll();
    }

    public void printAll() {
        System.out.println("\n=== Animals in shelter ===");
        System.out.println("Dogs:");
        if (dogs.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Animal d : dogs) {
                System.out.printf("  • %s | age=%d | order=%d%n",
                        d.getName(), d.getAge(), d.getArrivalOrder());
            }
        }
        System.out.println("Cats:");
        if (cats.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Animal c : cats) {
                System.out.printf("  • %s | age=%d | order=%d%n",
                        c.getName(), c.getAge(), c.getArrivalOrder());
            }
        }
        System.out.println("===========================");
    }
}
