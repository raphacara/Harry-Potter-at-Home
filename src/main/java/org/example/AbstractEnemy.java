package org.example;

public abstract class AbstractEnemy extends Character {

    // Constructor
    public AbstractEnemy(String name, int health, int power) {
        super(name, health, power);
    }

    // Attack methods
    @Override
    public void attack(Character target) throws InterruptedException {
        // Basic attack implementation
        int randomNum = (int)(Math.random() * 10); // Generate a random number between 0 and 10
        int damage;
        if (randomNum == 0) {
            damage = 0; // Missed
            System.out.println("You dodge the attack!");
        } else if (randomNum == 1) {
            damage = this.getPower() / 2; // Weak hit
            System.out.println("Weak hit.");
        } else if (randomNum == 8 || randomNum == 9) {
            damage = this.getPower() * 2; // Critical hit
            System.out.println("Critical hit.");
        } else {
            damage = this.getPower(); // Normal hit
            System.out.println("The " + this.getName() + " attack you.");
        }
        Thread.sleep(2000);
        System.out.println("You take " + damage + " damage!");
        target.takeDamage(damage); //This method is in Character
        Thread.sleep(1000);
    }

    public abstract void specialAttack(Character target);
}