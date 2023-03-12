package org.example;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private boolean isAttacking = true; //to check if a Character is attacking

    // Properties
    private String name;
    private int health;
    private int maxHealth;
    private int power;
    private int accuracy;
    private String condition;

    // Constructor
    public Character(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.power = power;
        this.accuracy = 0;
        this.condition = "normal";
    }

    // Methods
    public abstract void attack(Character target) throws InterruptedException;

    // Specific setter
    public void setMaxHealth(int maxHealth) { //specific need for setting the max health
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void stopAttack(Spell spell) {
        isAttacking = false;
        condition = spell.getName();
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