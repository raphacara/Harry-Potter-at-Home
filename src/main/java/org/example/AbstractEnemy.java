package org.example;

public abstract class AbstractEnemy extends Character {

    // Constructor
    public AbstractEnemy(String name, int health, int power) {
        super(name, health, power);
    }

    // Methods
    @Override
    public float attack(Character target) {
        // Basic attack implementation
        int damage = power * (int) (Math.random() * 3) + 1; // random damage between 1 and 3 * power
        System.out.println("You take " + damage + "damage!");
        target.takeDamage(damage); //This method is in Character
        return damage;
    }

    public abstract void specialAttack(Character target);

}