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
            System.out.println("You dodge the attack!"); // Missed
            damage = 0; // 0% damage
        } else if (randomNum == 1) {
            System.out.println("Weak hit."); // Weak hit
            damage = this.getPower() / 2; // 50% damage
        } else if (randomNum == 8) {
            System.out.println("Critical hit."); // Critical hit
            damage = this.getPower() + (this.getPower() / 2) ; // 150% damage
        }else if (randomNum == 9) {
            System.out.println("Ultra-Critical hit."); // Ultra-Critical hit
            damage = this.getPower() * 2; // 200% damage
        } else {
            System.out.println("The " + this.getName() + " attack you."); // Normal hit
            damage = this.getPower(); // 100% damage
        }
        Thread.sleep(2000);
        System.out.println("You take " + damage + " damage!");
        target.takeDamage(damage); //This method is in Character
        Thread.sleep(1000);
    }

    public abstract void specialAttack(Character target);
}