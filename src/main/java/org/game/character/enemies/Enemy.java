package org.game.character.enemies;
import org.game.character.Character;

public class Enemy extends AbstractEnemy {

    // Constructor
    public Enemy(String name, int health, int power) {
        super(name, health, power);
    }

    // Methods
    @Override
    public void specialAttack(Character target) {
        // Implement the behavior for a special attack
    }
}