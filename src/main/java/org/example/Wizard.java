package org.example;
import lombok.Getter;
import lombok.Setter;
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
    private String house;
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

    //method to learn a spell
    public void learnSpell(Spell spell) {
        // Check if the spell is already known
        if (knownSpells.contains(spell)) {
            System.out.println("** You already know this spell. **\n");
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
            System.out.println("** You already know this potion. **\n");
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
        System.out.println(YELLOW_BOLD + "\n----- You ----- " +
                "\nNAME: " + wizard.getName() +
                "\nHEALTH: " + wizard.getHealth() + "/" + wizard.getMaxHealth() + "hp" +
                "\nPET: " + wizard.getPet() +
                "\nWAND: " + wizard.getWand().getCore() + " (" + wizard.getWand().getSize() + "cm) " +
                "\nHOUSE: " + wizard.getHouse() +
                "\nPATRONUS: " + wizard.getPatronus() +
                "\nSPELLS: ");
        //List<Spell> knownSpells = wizard.getKnownSpells();
        for (Spell spell : knownSpells) {
            System.out.println("* "+spell.getName()+" *");
        }
        System.out.println("POTIONS: ");
        for (Potion potion : potions) {
            System.out.println("* "+potion.getName()+" *");
        }
        System.out.println("---------------\nPOWER bonus: " + wizard.getPower() +
                "\nACCURACY bonus: " + wizard.getAccuracy() +
                "\nBOTANIST bonus: " + wizard.getBotanist() + "\n" + RESET);
        Thread.sleep(3000);
    }

    //To apply the bonus of each house on the wizard (huge bonus)
    public void bonusHouses(Wizard wizard) {
        System.out.println("test");
        switch (wizard.getHouse()) {
            case "Hufflepuff" -> {
                // Increase the effectiveness of potions for Hufflepuff members
                int newBotanist = wizard.getBotanist()+ 10;
                wizard.setBotanist(newBotanist);
                System.out.println(GREEN_BOLD + "Hufflepuff bonus: +10 Botanist points\n" + RESET);
            }
            case "Slytherin" -> {
                // Increase spell damage for Slytherin members
                int newPower = wizard.getPower() + 10;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "Slytherin bonus: +10 damage\n" + RESET);
            }
            case "Gryffindor" -> {
                // Increase the wizard's health for Gryffindor members
                int newHealth = wizard.getHealth() + 20;
                wizard.setMaxHealth(newHealth);
                System.out.println(GREEN_BOLD + "Gryffindor bonus: +20 hp\n" + RESET);
            }
            case "Ravenclaw" -> {
                // Increase the accuracy of spells for Ravenclaw members
                int newAccuracy = wizard.getAccuracy() + 10;
                wizard.setAccuracy(newAccuracy);
                System.out.println(GREEN_BOLD + "Ravenclaw bonus: +10 accuracy" + RESET);
            }
        }
    }

    //To apply the bonus of each Core's Wand (medium bonus)
    public void bonusWand(Wizard wizard) {
        switch (wizard.getWand().getCore()) {
            case DRAGON_HEARTSTRING -> {
                // Increase the effectiveness of accuracy
                int newAccuracy = wizard.getAccuracy() + 5;
                wizard.setAccuracy(newAccuracy);
                System.out.println(GREEN_BOLD + "Dragon heartstring core bonus: +5 accuracy\n" + RESET);
            }
            case UNICORN_HAIR -> {
                // Increase spell damage
                int newHealth = wizard.getHealth() + 10;
                wizard.setMaxHealth(newHealth);
                System.out.println(GREEN_BOLD + "Unicorn hair core bonus: +10hp\n" + RESET);
            }
            case PHOENIX_FEATHER -> {
                // Increase the wizard's power
                int newPower = wizard.getPower() + 5;
                wizard.setPower(newPower);
                System.out.println(GREEN_BOLD + "Phoenix Feather core bonus: +5 damage\n" + RESET);
            }
        }
    }

    //To apply the bonus of the wizard's Pet (little bonus)
    public void bonusPet(Wizard wizard) {
        switch (wizard.getPet()) {
            case TOAD -> {
                // Increase the effectiveness of potions for Hufflepuff members
                wizard.setBotanist(wizard.getBotanist()+ 1);
                System.out.println(GREEN_BOLD + "TOAD bonus: +1 Botanist points\n" + RESET);
            }
            case RAT, SNAKE -> {
                // Increase spell damage for Slytherin members
                wizard.setPower(wizard.getPower() + 1);
                System.out.println(GREEN_BOLD + wizard.getPet() + " bonus: +1 damage\n" + RESET);
            }
            case CAT -> {
                // Increase the wizard's health for Gryffindor members
                wizard.setMaxHealth(wizard.getHealth() + 2);
                System.out.println(GREEN_BOLD + "CAT bonus: +2 hp\n" + RESET);
            }
            case OWL -> {
                // Increase the accuracy of spells for Ravenclaw members
                wizard.setAccuracy(wizard.getAccuracy() + 1);
                System.out.println(GREEN_BOLD + "OWL bonus: +1 accuracy\n" + RESET);
            }
        }
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