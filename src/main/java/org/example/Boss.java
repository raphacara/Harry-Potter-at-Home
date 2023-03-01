package org.example;

public class Boss extends AbstractEnnemy {

    // Constructor
    public Boss(String name, int health) {
        super(name, health);
    }

    // Methods
    @Override
    public void specialAttack(Character target) {
        // Implement the behavior for a special attack
        // This could include casting a powerful spell or using a unique ability
    }
}

