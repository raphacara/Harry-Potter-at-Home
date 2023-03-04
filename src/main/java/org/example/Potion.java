package org.example;

public class Potion {

    // Properties
    private String name;
    private int healthPoints;
    private String description;

    // Constructor
    public Potion(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void usePotion(Wizard wizard) {
        //effect of the potion
    }
}


