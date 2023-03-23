package org.game;

import lombok.Getter;
import lombok.Setter;
import org.game.attributes.Potion;
import org.game.character.enemies.AbstractEnemy;
import org.game.character.enemies.Boss;
import org.game.character.enemies.Enemy;
import org.game.spells.AbstractSpell;
import org.game.spells.ForbiddenSpell;
import org.game.spells.Spell;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameContent {
    private final List<AbstractSpell> spells;
    private final List<Potion> potions;
    private final List<AbstractEnemy> enemies;

    public GameContent() {
        this.spells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.initializeAll();
    }

    private void initializeAll() {
        //Spells
        spells.add(new Spell("Accio", 1, 67, "It weakly attracts the enemy."));
        spells.add(new Spell("Aguamenti", 15, 90, "It makes a water jet."));
        spells.add(new Spell("Bubble-Head", 0, 100, "It  creates a bubble of air around your head."));
        spells.add(new Spell("Diffindo", 25, 67, "It cuts the enemy."));
        spells.add(new Spell("Disilluminatus", 0, 75, "it allows you to be invisible, but the enemy knows where you are."));
        spells.add(new Spell("Expecto Patronum", 1, 50, "It creates a intense light with your patronus!"));
        spells.add(new Spell("Expelliarmus", 30, 75, "It makes some damage and try to disarm the enemy's weapon."));
        spells.add(new Spell("Incendio", 20, 85, "It makes some fire."));
        spells.add(new Spell("Lumos", 0, 100, "It makes light!"));
        spells.add(new Spell("Protego", 0, 67, "It will protect you."));
        spells.add(new Spell("Reducto", 25, 80, "It makes a little explosion."));
        spells.add(new Spell("Stupefy", 20, 50, "It damages the enemy, and trying to stun it."));
        spells.add(new Spell("Sectumsempra", 50, 67, "It causes deep, bleeding cuts on the victim's body."));
        spells.add(new Spell("Wingardium Leviosa", 0, 80, "It makes objects to levitate, but it does not work on the enemy."));
        //Forbidden Spells
        spells.add(new ForbiddenSpell("Avada Kedavra", 999999, 50, "killing curse."));
        spells.add(new ForbiddenSpell("Crucio", 0, 50, "Cruciatus curse."));
        spells.add(new ForbiddenSpell("Imperio", 0, 50, "Imperius curse."));
        //Potions
        potions.add(new Potion("Felix Felicis", 0, "It makes you lucky for the battle."));
        potions.add(new Potion("Gillyweed", 0, "it allows you to breath underwater for a limited time."));
        potions.add(new Potion("Invisibility", 0, "it allows you to be invisible for a limited time."));
        potions.add(new Potion("Wiggenweld", 40, "It instantly heals by restoring some health."));
        //Enemies
        enemies.add(new Enemy("Death Eater", 130, 35)); //Creating a DeathEater
        enemies.add(new Enemy("Dementors", 9999, 10)); //Creating a Dementor
        enemies.add(new Enemy("Spider", 70, 25)); //Creating a Spider
        enemies.add(new Enemy("Slytherin Student", 120, 25)); //Creating a Student
        enemies.add(new Enemy("Tournament Champion", 100, 28)); //Creating a Student
        enemies.add(new Enemy("Troll", 150, 30)); //Creating a Troll
        //Bosses
        enemies.add(new Boss("Basilisk", 500, 45)); //Creating a Troll
        enemies.add(new Boss("Dragon",200,40)); //Creating a Dragon
        enemies.add(new Boss("Umbridge",9999,1)); //Creating a Dragon
    }

    //To get a spell
    public AbstractSpell spell(String name) {
        for (AbstractSpell spell : this.getSpells()) {
            if (spell.getName().equalsIgnoreCase(name)) {
                return spell;
            }
        }
        return null;
    }

    //To get a potion
    public Potion potion(String name) {
        for (Potion potion : this.getPotions()) {
            if (potion.getName().equalsIgnoreCase(name)) {
                return potion;
            }
        }
        return null;
    }

    //To get an enemy
    public AbstractEnemy enemy(String name) {
        for (AbstractEnemy enemy : this.getEnemies()) {
            if (enemy.getName().equalsIgnoreCase(name)) {
                return enemy;
            }
        }
        return null;
    }
}
