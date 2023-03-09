package org.example;

import java.util.Objects;

public class Spell extends AbstractSpell {

    // Constructor
    public Spell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, AbstractEnemy target) {
        int accuracyRoll = (int) (Math.random() * 101); // Generate a random number between 0 and 100 (inclusive)
        if (accuracyRoll <= (this.getAccuracy() + wizard.getAccuracy())) { // Check if the spell hits its target
            if (this.getPowerLevel() == 0) {
                System.out.println(this.getDescription());
                if (Objects.equals(this.getName(), "Protego")) {
                    target.stopAttack(); //in AbstractEnemy class -> isAttacking = false.
                }
            }
            int damage = this.getPowerLevel() + wizard.getPower();
            System.out.println(this.getName() + " deals " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(this.getName() + " missed!");
        }
    }
}