package org.example;

import java.util.List;

public class Wizard extends Character {

    // Properties
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    // Constructor
    public Wizard(String name, int health, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<Potion> potions) {
        super(name, health);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
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
}
