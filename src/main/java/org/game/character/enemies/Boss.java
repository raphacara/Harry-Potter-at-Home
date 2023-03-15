package org.game.character.enemies;

public class Boss extends AbstractEnemy {
    //Instances of Boss
    public static final Boss basilisk = new Boss("Basilisk", 500, 45); //Creating a Troll
    public static final Boss dragon = new Boss("Dragon",200,40); //Creating a Dragon
    public static final Boss umbridge = new Boss("Umbridge",9999,1); //Creating a Dragon

    // Constructor
    public Boss(String name, int health, int power) {
        super(name, health, power);
    }
}