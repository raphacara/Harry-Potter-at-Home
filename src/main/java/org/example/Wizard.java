package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wizard extends Character {
    // Fun property
    public static final String GREEN_BOLD = "\033[1;32m"; //fun
    public static final String YELLOW_BOLD = "\033[1;33m"; //fun
    public static final String RESET = "\u001B[0m"; //fun

    // Properties
    private Pet pet;
    private Wand wand;
    private String house;
    private final List<Spell> knownSpells;
    private final List<Potion> potions;

    // Constructor
    public Wizard() {
        super("unknown",100, 0);
        this.pet = null;
        this.wand = null;
        this.house = null;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    // Methods
    public void defend() {

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

    public List<Potion> getPotions() {
        return potions;
    }

    @Override
    public float attack(Character target) {
        return 0;
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

    //method to learn a potion
    public void learnPotion(Potion potion) {
        // Check if the potion is already known
        if (potions.contains(potion)) {
            System.out.println("You already know this potion.");
        } else {
            // Learn the new potion
            potions.add(potion);
            System.out.println(GREEN_BOLD + "** You have learned the potion " + potion.getName() + "! **" + RESET);
        }
    }

    //Wonderful method to check what the attributes of the player.
    public void checkWizard(Wizard wizard) throws InterruptedException {
        System.out.println(YELLOW_BOLD + "\n----- You ----- " +
                "\nNAME: " + wizard.getName() +
                "\nHEALTH: " + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp" +
                "\nPET: " + wizard.getPet() +
                "\nWAND: " + wizard.getWand().getCore() + " (" + wizard.getWand().getSize() + "cm) " +
                "\nHOUSE: " + wizard.getHouse() +
                "\nSPELLS: ");
        //List<Spell> knownSpells = wizard.getKnownSpells();
        for (Spell spell : knownSpells) {
            System.out.println("* "+spell.getName()+" *");
        }
        System.out.println("POTIONS: ");
        for (Potion potion : potions) {
            System.out.println("* "+potion.getName()+" *");
        }
        System.out.println(RESET);
        Thread.sleep(6000);
    }

    //To apply the bonus of each house on the wizard
    public void bonusHouses(Wizard wizard) throws InterruptedException {
        switch (wizard.getHouse()) {
            case "Hufflepuff" -> {
                // Increase the effectiveness of potions for Hufflepuff members
                for (Potion potion : wizard.getPotions()) {
                    int newPower = potion.getHealthPoints() + 10;
                    potion.setHealthPoints(newPower);
                }
                System.out.println("Hufflepuff bonus: Your potions will be stronger! ");
            }
            case "Slytherin" -> {
                // Increase spell damage for Slytherin members
                int newPower = (int) (wizard.getPower() + 10);
                wizard.setPower(newPower);
                System.out.println("Slytherin bonus:\nPOWER: " + wizard.getPower());
            }
            case "Gryffindor" -> {
                // Increase the wizard's health for Gryffindor members
                int newHealth = wizard.getHealth() + 20;
                wizard.setMaxHealth(newHealth);
                System.out.println("Gryffindor bonus:\nNEW HEALTH: " + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp");
            }
            case "Ravenclaw" -> {
                // Increase the accuracy of spells for Ravenclaw members
                for (Spell spell : wizard.getKnownSpells()) {
                    int newAccuracy = spell.getAccuracy() + 10;
                    spell.setAccuracy(newAccuracy);
                }
                System.out.println("Ravenclaw bonus: Your spells will be more precise!");
            }
        }
        Thread.sleep(2000);
    }

    //A randomWizard to skip the intro
    public void randomWizard(Wizard wizard) {
        Random random = new Random();
        Wand wandTest = new Wand(Core.values()[random.nextInt(Core.values().length)], 30);
        String randomHouseName = org.example.House.houseNames.get(new Random().nextInt(org.example.House.houseNames.size()));
        wizard.setName("Wizard");
        wizard.setPet(Pet.values()[random.nextInt(Pet.values().length)]);
        wizard.setWand(wandTest);
        wizard.setHouse(randomHouseName);
    }
}