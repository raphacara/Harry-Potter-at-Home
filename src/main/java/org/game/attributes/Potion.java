package org.game.attributes;
import lombok.Getter;
import org.game.character.Wizard;

@Getter
public class Potion {
    private final String name;
    private final int healthPoints;
    private final String description;
    // Create Potions (protected because there are instance, more than attributes, that I might need everywhere without creating a new Potion).
    public static final Potion wiggenweld = new Potion("Wiggenweld", 40, "A potion that instantly heals by restoring some health.");

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