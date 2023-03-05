package org.example;

public abstract class AbstractEnemy extends Character {

    // Constructor
    public AbstractEnemy(String name, int health, float power) {
        super(name, health, power);
    }

    // Methods
    @Override
    public void attack(Character target) {
        // Implement the behavior for attacking a target
        // This could include casting a spell or using a weapon
    }

    public abstract void specialAttack(Character target);

}