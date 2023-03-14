package org.game.character.enemies;

public class Boss extends AbstractEnemy {
    //Instances of Boss
    public static final Boss Basilisk = new Boss("Basilisk", 500, 45); //Creating a Troll
    public static final Enemy dragon = new Enemy("Dragon",200,40); //Creating a Dragon

    // Constructor
    public Boss(String name, int health, int power) {
        super(name, health, power);
    }
}