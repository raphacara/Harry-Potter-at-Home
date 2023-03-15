package org.game.character.enemies;
public class Enemy extends AbstractEnemy {
    //Instances are public because that's not attributes
    public static final Enemy troll = new Enemy("Troll", 150, 30); //Creating a Troll
    public static final Enemy spider = new Enemy("Spider", 70, 25); //Creating a Spider
    public static final Enemy student = new Enemy("Slytherin Student", 120, 30); //Creating a Student
    public static final Enemy tournamentChampion = new Enemy("Tournament Champion", 140, 40); //Creating a Student

    public static final Enemy dementors = new Enemy("Dementors", 9999, 10); //Creating a Dementor

    // Constructor
    public Enemy(String name, int health, int power) {
        super(name, health, power);
    }
}