package org.example;

public abstract class Character {

    // Properties
    private String name;
    protected int health;
    protected int maxHealth;
    protected float power;

    // Constructor
    public Character(String name, int health, float power) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.power = power;
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

    public abstract void setHealth(int health);

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
}