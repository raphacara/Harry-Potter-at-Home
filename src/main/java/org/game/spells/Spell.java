package org.game.spells;
import org.game.character.Character;
import org.game.character.Wizard;

import java.util.Objects;

public class Spell extends AbstractSpell {
    // Create Sells (public because there are instance, more than attributes, that I might need everywhere without creating a new Spell).
    public static final Spell accio = new Spell("Accio", 1, 67, "It weakly attracts the enemy.");
    public static final Spell aguamenti = new Spell("Aguamenti", 15, 90, "It makes a water jet.");
    public static final Spell bubbleHead = new Spell("Bubble-Head", 0, 100, "It  creates a bubble of air around your head.");
    public static final Spell diffindo = new Spell("Diffindo", 25, 67, "It cuts the enemy.");
    public static final Spell disilluminatus = new Spell("Disilluminatus", 0, 75, "it allows you to be invisible, but the enemy knows where you are.");
    public static final Spell expectoPatronum = new Spell("Expecto Patronum", 1, 50, "It creates a intense light with your patronus!");
    public static final Spell expelliarmus = new Spell("Expelliarmus", 30, 75, "It makes some damage and try to disarm the enemy's weapon.");
    public static final Spell incendio = new Spell("Incendio", 20, 85, "It makes some fire.");
    public static final Spell lumos = new Spell("Lumos", 0, 100, "It makes light!");
    public static final Spell protego = new Spell("Protego", 0, 67, "It will protect you.");
    public static final Spell reducto = new Spell("Reducto", 25, 80, "It makes a little explosion.");
    public static final Spell stupefy = new Spell("Stupefy", 20, 50, "It damages the enemy, and trying to stun it.");
    public static final Spell sectumsempra = new Spell("Sectumsempra", 50, 67, "It causes deep, bleeding cuts on the victim's body.");
    public static final Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 0, 80, "It makes objects to levitate, but it does not work on the enemy.");

    // Constructor
    public Spell(String name, int powerLevel, int accuracy, String description) {
        super(name, powerLevel, accuracy, description);
    }

    // Methods
    @Override
    public void cast(Wizard wizard, Character target) {
        int randomNum = (int)(Math.random() * 4); //for critical hits
        int accuracyRoll = (int) (Math.random() * 101); // Generate a random number between 0 and 100 (inclusive)
        if (accuracyRoll <= (this.getAccuracy() + wizard.getAccuracy())) { // Check if the spell hits its target
            if (Objects.equals(this.getName(), "Protego") || Objects.equals(this.getName(), "Expelliarmus") || Objects.equals(this.getName(), "Stupefy")) {
                target.stopAttack(this); //in Character class -> isAttacking = false.
            } else if (Objects.equals(this.getName(), "Incendio")) {
                target.setCondition("Incendio");
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