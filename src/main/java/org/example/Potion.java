package org.example;

public class Potion {

    // Properties
    private String name;
    private int healthPoints;

    // Constructor
    public Potion(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}


