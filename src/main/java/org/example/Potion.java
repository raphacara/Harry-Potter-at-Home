package org.example;

public class Potion {

    // Properties
    private String name;
    private int healthPoints;
    private final String description;

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

    public void usePotion(Wizard wizard) {
        int heal = (this.getHealthPoints() + wizard.getBotanist());
        wizard.healing(heal);
        System.out.println("You heal " + heal + "hp.");

    }
}