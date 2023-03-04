package org.example;

public class Enemy extends AbstractEnnemy {

    // Constructor
    public Enemy(String name, int health) {
        super(name, health);
    }

    // Methods
    @Override
    public void specialAttack(Character target) {
        // Implement the behavior for a special attack
        // This could include casting a powerful spell or using a unique ability
    }

    @Override
    public void setHealth(int health) {

    }
}


