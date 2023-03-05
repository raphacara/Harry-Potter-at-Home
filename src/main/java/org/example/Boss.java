package org.example;

public class Boss extends AbstractEnemy {

    // Constructor
    public Boss(String name, int health, float power) {
        super(name, health, power);
    }

    // Methods
    @Override
    public void specialAttack(Character target) {
        // Implement the behavior for a special attack
        // This could include casting a powerful spell or using a unique ability
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}