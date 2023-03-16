package org.game.character;
import lombok.Getter;
import lombok.Setter;
import org.game.*;
import org.game.attributes.*;
import org.game.spells.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Wizard extends Character {
    // Properties
    private static final String GREEN_BOLD = "\033[1;32m"; //fun
    private static final String YELLOW_BOLD = "\033[1;33m"; //fun
    private static final String RESET = "\u001B[0m"; //fun
    private Pet pet;
    private Wand wand;
    private House house;
    private final List<Spell> knownSpells;
    private final List<Potion> potions;
    private int botanist;
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
        this.patronus = "???";
    }

    //method to attack an enemy
    @Override //I switched the name of defend() method in the subject by an attack() method. (easier because of the @Override)
    public void attack(Character target) throws InterruptedException {
        Fight fight = new Fight(this, target); //Creating the fight
        fight.run(); //Running the fight
        Thread.sleep(2000);
    }

    @Override
    public void specialAttack(Wizard wizard, String spell) {
        System.out.println("Lorem Ipsum Dolor");
    }

    //method to learn a spell
    public void learnSpell(Spell spell) {
        // Check if the spell is already known
        if (knownSpells.contains(spell)) {
            System.out.println("** You already know this spell. **");
            System.out.println("** So you get +1 damage bonus. **");
            this.setPower(this.getPower() + 1); //Compensation
        } else {
            // Learn the new spell
            knownSpells.add(spell);
            System.out.println(GREEN_BOLD + "** You have learned the spell " + spell.getName() + "! **" + RESET);
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
            System.out.println(GREEN_BOLD + "** You have learned the potion " + potion.getName() + "! **" + RESET);
        }
    }

    //Wonderful method to check the attributes of the player.
    public void checkWizard(Wizard wizard) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(YELLOW_BOLD + "----- You ----- " +
                "\nNAME: " + wizard.getName() +
                "\nHEALTH: " + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp" +
                "\nPET: " + wizard.getPet() +
                "\nWAND: " + wizard.getWand().getCore() + " (" + wizard.getWand().getSize() + "cm) " +
                "\nHOUSE: " + wizard.getHouse() +
                "\nPATRONUS: " + wizard.getPatronus() +
                "\nSPELLS: ");
        for (Spell spell : knownSpells) {
            System.out.println("* "+spell.getName()+" *");
        }
        System.out.println("POTIONS: ");
        for (Potion potion : potions) {
            System.out.println("* "+potion.getName()+" *");
        }
        System.out.println("---------------\nPOWER bonus: " + wizard.getPower() +
                "\nACCURACY bonus: " + wizard.getAccuracy() +
                "\nBOTANIST bonus: " + wizard.getBotanist() + RESET);
    }

    //To apply the bonus of each house on the wizard (huge bonus)
    public void bonusHouses(Wizard wizard) {
        switch (wizard.getHouse()) {
            case Hufflepuff -> {
                // Increase the effectiveness of potions for Hufflepuff members
                int newBotanist = wizard.getBotanist()+ 5;
                wizard.setBotanist(newBotanist);
                System.out.println(GREEN_BOLD + "Hufflepuff bonus: +5 Botanist points" + RESET);
            }
            case Slytherin -> {
                // Increase spell damage for Slytherin members
                int newPower = wizard.getPower() + 5;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "Slytherin bonus: +5 damage" + RESET);
            }
            case Gryffindor -> {
                // Increase the wizard's health for Gryffindor members
                int newHealth = wizard.getHealth() + 10;
                wizard.setMaxHealth(newHealth);
                System.out.println(GREEN_BOLD + "Gryffindor bonus: +10 hp" + RESET);
            }
            case Ravenclaw -> {
                // Increase the accuracy of spells for Ravenclaw members
                int newAccuracy = wizard.getAccuracy() + 5;
                wizard.setAccuracy(newAccuracy);
                System.out.println(GREEN_BOLD + "Ravenclaw bonus: +5 accuracy" + RESET);
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
                System.out.println(GREEN_BOLD + "Dragon heartstring Core bonus: +2 accuracy" + RESET);
            }
            case UNICORN_HAIR -> {
                // Increase spell damage
                int newHealth = wizard.getHealth() + 5;
                wizard.setMaxHealth(newHealth);
                System.out.println(GREEN_BOLD + "Unicorn hair Core bonus: +5hp" + RESET);
            }
            case PHOENIX_FEATHER -> {
                // Increase the wizard's power
                int newPower = wizard.getPower() + 2;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "Phoenix Feather Core bonus: +2 damage" + RESET);
            }
        }
    }

    //To apply the bonus of the wizard's Pet (little bonus)
    public void bonusPet(Wizard wizard) {
        switch (wizard.getPet()) {
            case TOAD -> {
                // Increase the effectiveness of potions for Hufflepuff members
                wizard.setBotanist(wizard.getBotanist()+ 1);
                System.out.println(GREEN_BOLD + "TOAD bonus: +1 Botanist points" + RESET);
            }
            case RAT, SNAKE -> {
                // Increase spell damage for Slytherin members
                wizard.setPower(wizard.getPower() + 1);
                System.out.println(GREEN_BOLD + wizard.getPet() + " bonus: +1 damage" + RESET);
            }
            case CAT -> {
                // Increase the wizard's health for Gryffindor members
                wizard.setMaxHealth(wizard.getHealth() + 2);
                System.out.println(GREEN_BOLD + "CAT bonus: +2 hp" + RESET);
            }
            case OWL -> {
                // Increase the accuracy of spells for Ravenclaw members
                wizard.setAccuracy(wizard.getAccuracy() + 1);
                System.out.println(GREEN_BOLD + "OWL bonus: +1 accuracy" + RESET);
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