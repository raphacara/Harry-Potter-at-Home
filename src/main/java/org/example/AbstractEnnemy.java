package org.example;

public abstract class AbstractEnnemy extends Character {

    // Constructor
    public AbstractEnnemy(String name, int health) {
        super(name, health);
    }

    // Methods
    @Override
    public void attack(Character target) {
        // Implement the behavior for attacking a target
        // This could include casting a spell or using a weapon
    }

    public abstract void specialAttack(Character target);

}


