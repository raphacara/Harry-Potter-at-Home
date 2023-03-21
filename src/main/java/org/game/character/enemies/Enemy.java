package org.game.character.enemies;
public class Enemy extends AbstractEnemy {
    //Instances are public because that's not attributes
    public static final Enemy deathEater = new Enemy("Death Eater", 120, 40); //Creating a DeathEater
    public static final Enemy dementors = new Enemy("Dementors", 9999, 10); //Creating a Dementor
    public static final Enemy spider = new Enemy("Spider", 70, 25); //Creating a Spider
    public static final Enemy student = new Enemy("Slytherin Student", 120, 25); //Creating a Student
    public static final Enemy tournamentChampion = new Enemy("Tournament Champion", 100, 28); //Creating a Student
    public static final Enemy troll = new Enemy("Troll", 150, 30); //Creating a Troll



    // Constructor
    public Enemy(String name, int health, int power) {
        super(name, health, power);
    }
}