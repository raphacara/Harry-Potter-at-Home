package org.game.spells;
import org.game.character.Character;
import org.game.character.Wizard;

import java.util.Objects;

public class Spell extends AbstractSpell {
    // Create Sells (public because there are instance, more than attributes, that I might need everywhere without creating a new Spell).
    public static final Spell accio = new Spell("Accio", 0, 67, "It weakly attracts the enemy.");
    public static final Spell aguamenti = new Spell("Aguamenti", 20, 90, "It makes a water jet.");
    public static final Spell diffindo = new Spell("Diffindo", 50, 67, "It cuts the enemy.");

    public static final Spell expectoPatronum = new Spell("Expecto Patronum", 0, 50, "It creates a intense light with your patronus!");
    public static final Spell expelliarmus = new Spell("Expelliarmus", 60, 75, "It makes some damage and try to disarm the enemy's weapon.");
    public static final Spell incendio = new Spell("Incendio", 40, 80, "It makes some fire.");
    public static final Spell lumos = new Spell("Lumos", 0, 100, "It makes light!");
    public static final Spell protego = new Spell("Protego", 0, 75, "It will protect you.");
    public static final Spell reducto = new Spell("Reducto", 30, 85, "It makes a little explosion.");
    public static final Spell sectumsempra = new Spell("Sectumsempra", 80, 67, "It causes deep, bleeding cuts on the victim's body.");
    public static final Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 0, 80, "It makes objects to levitate, but it does not work on the enemy.");
    public String effect; //to check the effect of each spell in the Fight class.

    // Constructor
    public Spell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, Character target) {
        int randomNum = (int)(Math.random() * 5); //For the critical hit
        int accuracyRoll = (int) (Math.random() * 101); // Generate a random number between 0 and 100 (inclusive)
        if (accuracyRoll <= (this.getAccuracy() + wizard.getAccuracy())) { // Check if the spell hits its target
            if (Objects.equals(this.getName(), "Protego") || Objects.equals(this.getName(), "Expelliarmus") || Objects.equals(this.getName(), "Incendio")) {
                target.stopAttack(this); //in Character class -> isAttacking = false.
            }
            int damage = this.getPowerLevel() + wizard.getPower();
            if (randomNum == 5) {
                System.out.println("Critical hit!");
                damage += (damage / 2);
            }
            System.out.println(this.getName() + " deals " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(this.getName() + " missed!");
        }
    }
}