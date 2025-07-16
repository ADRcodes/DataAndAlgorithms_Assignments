package com.example.assignment5;

public class Animal {
    private String name;
    private String species;     // “dog” or “cat”
    private String subspecies;
    private int age;
    private int arrivalOrder;   // stamp for FIFO

    public Animal(String name, String species, String subspecies, int age) {
        this.name       = name;
        this.species    = species.toLowerCase();
        this.subspecies = subspecies;
        this.age        = age;
    }

    // Getters
    public String getName()        { return name; }
    public String getSpecies()     { return species; }
    public String getSubspecies()  { return subspecies; }
    public int    getAge()         { return age; }
    public int    getArrivalOrder(){ return arrivalOrder; }

    // Setters
    public void setName(String name)              { this.name = name; }
    public void setSpecies(String species)        { this.species = species.toLowerCase(); }
    public void setSubspecies(String subspecies)  { this.subspecies = subspecies; }
    public void setAge(int age)                   { this.age = age; }

    void setArrivalOrder(int order) { this.arrivalOrder = order; }
}
