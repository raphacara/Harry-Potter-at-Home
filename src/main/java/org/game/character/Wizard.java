package org.game.character;
import lombok.Getter;
import lombok.Setter;
import org.game.*;
import org.game.attributes.*;
import org.game.spells.AbstractSpell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Wizard extends Character {
    // Properties
    private Pet pet;
    private Wand wand;
    private House house;
    private final List<AbstractSpell> knownSpells;
    private final List<Potion> potions;
    private int botanist;
    private int luck;
    private String patronus;


    // Constructor
    public Wizard() {
        super("unknown",100, 0);
        this.pet = null;
        this.wand = null;
        this.house = null;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.botanist = 0;
        this.luck = 0;
        this.patronus = "???";
    }

    //method to attack an enemy
    @Override //I switched the name of defend() method in the subject by an attack() method. (easier because of the @Override)
    public void attack(Character target) throws InterruptedException {
        target.setHealth(target.getMaxHealth()); //To be sure that the enemy is full life when we attack it.
        Fight fight = new Fight(this, target); //Creating the fight
        fight.runStory(); //Running the fight
    }

    @Override
    public void specialAttack(Wizard wizard, String spell) {
        System.out.println("Lorem Ipsum Dolor");
    }

    //method to learn a spell
    public void learnSpell(AbstractSpell spell) {
        // Check if the spell is already known
        if (knownSpells.contains(spell)) {
            System.out.println("** You already know this spell. **");
            System.out.println("** So you get +1 damage bonus. **");
            this.setPower(this.getPower() + 1); //Compensation
        } else {
            // Learn the new spell
            knownSpells.add(spell);
            System.out.println(Color.GREEN + "** You have learned the spell " + spell.getName() + "! **" + Color.RESET);
        }
    }

    //method to learn a potion
    public void learnPotion(Potion potion) {
        // Check if the potion is already known
        if (potions.contains(potion)) {
            System.out.println("** You already know this potion. **");
            System.out.println("** So you get +1 botanist bonus. **");
            this.setBotanist(this.getBotanist() + 1); //Compensation
        } else {
            // Learn the new potion
            potions.add(potion);
            System.out.println(Color.GREEN + "** You have learned the potion " + potion.getName() + "! **" + Color.RESET);
        }
    }

    //Wonderful method to check the attributes of the player.
    public void infoWizard(Wizard wizard) {
        System.out.println(Color.YELLOW + "----------- You ----------- " +
                "\nNAME:     " + Color.RESET + wizard.getName() + Color.YELLOW +
                "\nHEALTH:   " + Color.RESET + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp" + Color.YELLOW +
                "\nPET:      " + Color.RESET + wizard.getPet() + Color.YELLOW +
                "\nWAND:     " + Color.RESET + wizard.getWand().getCore() + " (" + wizard.getWand().getSize() + "cm) " + Color.YELLOW +
                "\nHOUSE:    " + Color.RESET + wizard.getHouse() + Color.YELLOW +
                "\nPATRONUS: " + Color.RESET + wizard.getPatronus() + Color.YELLOW +
                "\nSPELLS:   "  + Color.RESET );
        for (AbstractSpell spell : knownSpells) {
            System.out.println("-- "+spell.getName()+" --");
        }
        System.out.println(Color.YELLOW + "POTIONS: " + Color.RESET );
        for (Potion potion : potions) {
            System.out.println("-- "+potion.getName()+" --");
        }
        System.out.println(Color.YELLOW + "---------------------------" +
                "\nPOWER bonus: " + Color.RESET  + "   " + wizard.getPower() + Color.YELLOW +
                "\nACCURACY bonus: " + Color.RESET  + wizard.getAccuracy() + Color.YELLOW +
                "\nBOTANIST bonus: " + Color.RESET  + wizard.getBotanist() + Color.YELLOW +
                "\n---------------------------" + Color.RESET);
    }

    //To apply the bonus of each house on the wizard (huge bonus)
    public void bonusHouses(Wizard wizard) {
        switch (wizard.getHouse()) {
            case Hufflepuff -> {
                // Increase the effectiveness of potions for Hufflepuff members
                int newBotanist = wizard.getBotanist()+ 10;
                wizard.setBotanist(newBotanist);
                System.out.println(Color.GREEN + "Hufflepuff bonus: +10 Botanist points" + Color.RESET);
            }
            case Slytherin -> {
                // Increase spell damage for Slytherin members
                int newPower = wizard.getPower() + 10;
                wizard.setPower(newPower);
                System.out.println(Color.GREEN + "Slytherin bonus: +10 damage" + Color.RESET);
            }
            case Gryffindor -> {
                // Increase the wizard's health for Gryffindor members
                int newHealth = wizard.getHealth() + 20;
                wizard.setMaxHealth(newHealth);
                System.out.println(Color.GREEN + "Gryffindor bonus: +20 hp" + Color.RESET);
            }
            case Ravenclaw -> {
                // Increase the accuracy of spells for Ravenclaw members
                int newAccuracy = wizard.getAccuracy() + 10;
                wizard.setAccuracy(newAccuracy);
                System.out.println(Color.GREEN + "Ravenclaw bonus: +10 accuracy" + Color.RESET);
            }
        }
    }

    //To apply the bonus of each Core's Wand (medium bonus)
    public void bonusWand(Wizard wizard) {
        switch (wizard.getWand().getCore()) {
            case DRAGON_HEARTSTRING -> {
                // Increase the effectiveness of accuracy
                int newAccuracy = wizard.getAccuracy() + 2;
                wizard.setAccuracy(newAccuracy);
                System.out.println(Color.GREEN + "Dragon heartstring Core bonus: +2 accuracy" + Color.RESET);
            }
            case UNICORN_HAIR -> {
                // Increase spell damage
                int newHealth = wizard.getHealth() + 5;
                wizard.setMaxHealth(newHealth);
                System.out.println(Color.GREEN + "Unicorn hair Core bonus: +5hp" + Color.RESET);
            }
            case PHOENIX_FEATHER -> {
                // Increase the wizard's power
                int newPower = wizard.getPower() + 2;
                wizard.setPower(newPower);
                System.out.println(Color.GREEN + "Phoenix Feather Core bonus: +2 damage" + Color.RESET);
            }
        }
    }

    //To apply the bonus of the wizard's Pet (little bonus)
    public void bonusPet(Wizard wizard) {
        switch (wizard.getPet()) {
            case TOAD -> {
                // Increase the effectiveness of potions for Hufflepuff members
                wizard.setBotanist(wizard.getBotanist()+ 1);
                System.out.println(Color.GREEN + "TOAD bonus: +1 Botanist points" + Color.RESET);
            }
            case RAT, SNAKE -> {
                // Increase spell damage for Slytherin members
                wizard.setPower(wizard.getPower() + 1);
                System.out.println(Color.GREEN + "" + wizard.getPet() + " bonus: +1 damage" + Color.RESET);
            }
            case CAT -> {
                // Increase the wizard's health for Gryffindor members
                wizard.setMaxHealth(wizard.getHealth() + 2);
                System.out.println(Color.GREEN + "CAT bonus: +2 hp" + Color.RESET);
            }
            case OWL -> {
                // Increase the accuracy of spells for Ravenclaw members
                wizard.setAccuracy(wizard.getAccuracy() + 1);
                System.out.println(Color.GREEN + "OWL bonus: +1 accuracy" + Color.RESET);
            }
        }
    }

    //A randomWizard to skip the intro
    public void randomWizard(Wizard wizard) {
        Random random = new Random();
        Wand wandTest = new Wand(Core.values()[random.nextInt(Core.values().length)], 30);
        wizard.setHouse(House.values()[random.nextInt(House.values().length)]);
        wizard.setName("Wizard");
        wizard.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
        wizard.setWand(wandTest);
    }
}