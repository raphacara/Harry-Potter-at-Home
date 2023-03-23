package org.game.spells;
import org.game.character.Character;
import org.game.character.Wizard;

import java.util.Objects;

public class Spell extends AbstractSpell {
    // Constructor
    public Spell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, Character target) {
        int randomNum = (int)(Math.random() * 4); //for critical hits
        int accuracyRoll = (int) (Math.random() * 101); // Generate a random number between 0 and 100 (inclusive)
        if (accuracyRoll <= (this.getAccuracy() + wizard.getAccuracy() + wizard.getLuck())) { // Check if the spell hits its target
            if (Objects.equals(this.getName(), "Protego") || Objects.equals(this.getName(), "Expelliarmus") || Objects.equals(this.getName(), "Stupefy")) {
                target.stopAttack(this); //in Character class -> isAttacking = false.
            } else if (Objects.equals(this.getName(), "Incendio") || Objects.equals(this.getName(), "Sectumsempra")) {
                target.setCondition(this.getName());
            }
            int damage = 0;
            if (this.getPowerLevel() != 0) {
                damage = this.getPowerLevel() + wizard.getPower();
                if (randomNum == 3) {
                    System.out.println("Critical hit!");
                    damage += (damage / 2);
                }
            }
            System.out.println(this.getDescription());
            System.out.println(this.getName() + " deals " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(this.getName() + " missed!");
            wizard.setCondition("Normal");
        }
    }
}