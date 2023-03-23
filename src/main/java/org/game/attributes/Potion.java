package org.game.attributes;
import lombok.Getter;
import org.game.character.Wizard;

@Getter
public class Potion {
    private final String name;
    private final int healthPoints;
    private final String description;

    // Constructor
    public Potion(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
    }

    public void usePotion(Wizard wizard) {
        int heal = (this.getHealthPoints() + wizard.getBotanist());
        wizard.healing(heal);
        System.out.println("You heal " + heal + "hp.");
    }
}