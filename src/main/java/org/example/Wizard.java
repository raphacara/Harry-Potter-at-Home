package org.example;
import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    // Fun property
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    public static final String YELLOW_BOLD = "\033[1;33m"; //fun
    public static final String RESET = "\u001B[0m"; //fun

    // Properties
    private Pet pet;
    private Wand wand;
    private String house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    // Constructor
    public Wizard() {
        super("unknown",100);
        this.pet = null;
        this.wand = null;
        this.house = null;
        this.knownSpells = new ArrayList<Spell>();
        this.potions = new ArrayList<Potion>();
    }

    // Methods
    public void defend() {
        // Implement the behavior for defending against an attack
        // This could include casting a spell or using a potion
    }

    // Getters and setters
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownSpells = knownSpells;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    @Override
    public void attack(Character target) {
    }

    //method to learn a spell
    public void learnSpell(Spell spell) {
        // Check if the spell is already known
        if (knownSpells.contains(spell)) {
            System.out.println("You already know this spell.");
        } else {
            // Learn the new spell
            knownSpells.add(spell);
            System.out.println(GREEN_BOLD + "** You have learned the spell " + spell.getName() + "! **" + RESET);
        }
    }

    public void checkWizard(Wizard wizard) {
        System.out.println(YELLOW_BOLD + "\n----- You ----- " +
                "\nNAME: " + wizard.getName() +
                "\nPET: " + wizard.getPet() +
                "\nWAND: " + wizard.getWand().getCore() + " (" + wizard.getWand().getSize() + "cm) " +
                "\nHOUSE: " + wizard.getHouse() +
                "\nSPELLS: ");
        List<Spell> knownSpells = wizard.getKnownSpells();
        for (Spell spell : knownSpells) {
            System.out.println("* "+spell.getName()+" *");
        }
    }
}