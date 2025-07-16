package com.example.assignment5;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Animal("Bob",      "dog", "Beagle",     3));
        shelter.enqueue(new Animal("Doggy","cat", "Siamese",    2));
        shelter.enqueue(new Animal("Butters",    "dog", "Labrador",   5));
        shelter.enqueue(new Animal("Luna",     "cat", "Maine Coon", 1));
        shelter.enqueue(new Animal("Josh",     "dog", "Golden Retriever", 40));

        shelter.printAll();

        System.out.println("dequeueAny():   " + shelter.dequeueAny().getName());
        System.out.println("dequeueDog():   " + shelter.dequeueDog().getName());
        System.out.println("dequeueCat():   " + shelter.dequeueCat().getName());
        System.out.println("dequeueAny():   " + shelter.dequeueAny().getName());

        System.out.println("Animals left in shelter:");
        shelter.printAll();
    }
}
