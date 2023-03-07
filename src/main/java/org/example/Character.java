package org.example;

public abstract class Character {

    // Properties
    private String name;
    private int health;
    private int maxHealth;
    private int power;
    private int accuracy;

    // Constructor
    public Character(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.power = power;
        this.accuracy = 0;
    }

    // Methods
    public abstract void attack(Character target) throws InterruptedException;

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
        this.health = Math.min(health, this.getMaxHealth());
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    // Method when a Character take damage from an enemy
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    // Method when a Character is healing himself
    public void healing(int heal) {
        health += heal;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
}