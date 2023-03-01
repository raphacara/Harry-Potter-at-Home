package org.example;

public abstract class Character {

    // Properties
    private String name;
    private int health;

    // Constructor
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Methods
    public abstract void attack(Character target);

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}


