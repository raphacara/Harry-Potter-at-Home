package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fight implements StoryStep {

    private final Wizard wizard;
    private Enemy troll;
    private boolean isFinished;
    private final int playerMaxHealth;
    private float playerHealth;
    private final int trollHealth;
    private final Scanner scanner;

    public Fight(Wizard wizard, Enemy troll) {
        this.wizard = wizard;
        this.troll = troll;
        this.isFinished = false;
        this.playerMaxHealth = wizard.getMaxHealth();
        this.playerHealth = wizard.getHealth();
        int trollMaxHealth = troll.getMaxHealth();
        this.trollHealth = troll.getHealth();
        float playerPower = wizard.getPower();
        List<Spell> playerSpells = new ArrayList<>(wizard.getKnownSpells());
        List<Potion> playerPotions = new ArrayList<>(wizard.getPotions());
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("You find yourself in a dark and damp toilet, next to the dungeon. Suddenly, you hear loud footsteps approaching. As you turn around, you see a huge troll blocking the exit. You have no choice but to fight for your life!");
        System.out.println("Troll: Raaargh!");
        System.out.println("Your current health: " + playerHealth);
        System.out.println("Troll's current health: " + trollHealth);
        System.out.println();

        while (!isFinished) {
            // Player's turn
            System.out.println("It's your turn!");
            System.out.println("Choose an action:");
            System.out.println("1. Cast a spell");
            System.out.println("2. Use a potion");
            System.out.println("3. Quit the fight");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    castSpell();
                    break;
                case 2:
                    usePotion();
                    break;
                case 3:
                    System.out.println("You decide to flee the fight. But as you turn around to run away, the troll catches you and hits you hard. You die instantly.");
                    isFinished = true;
                    wizard.setHealth(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

            if (!isFinished) {
                // Troll's turn
                float trollDamage = troll.attack(wizard);
                playerHealth -= trollDamage;
                System.out.println("The troll attacks you with all its might and deals " + trollDamage + " damage.");
                System.out.println("Your current health: " + playerHealth);
                System.out.println("Troll's current health: " + trollHealth);
                System.out.println();

                // Check if the fight is over
                if (playerHealth <= 0) {
                    System.out.println("You've been defeated by the troll. Game over!");
                    isFinished = true;
                } else if (trollHealth <= 0) {
                    System.out.println("You've defeated the troll! Congratulations!");
                    wizard.setHealth(playerMaxHealth);
                    upgrade(wizard);
                    isFinished = true;
                }
            }
        }
    }

    private void castSpell() {
        // display spells and get user input
        System.out.println("\n-- Spells --");
        for (Spell spell : wizard.getKnownSpells()) {
            System.out.println(spell.getName());
        }
        System.out.println("-------------");
        String input = scanner.nextLine();

        // find the selected spell
        Spell selectedSpell = null;
        for (Spell spell : wizard.getKnownSpells()) {
            if (input.equalsIgnoreCase(spell.getName())) {
                selectedSpell = spell;
                break;
            }
        }

        // handle invalid input
        if (selectedSpell == null) {
            System.out.println("Invalid spell. Please try again.");
            castSpell();
            return;
        }

        // display spell description and prompt for confirmation
        System.out.println("\n" + selectedSpell.getDescription());
        System.out.println("Do you want to cast " + selectedSpell.getName() + "? (Y/N)");
        String confirm = scanner.nextLine();

        // handle user confirmation
        if (confirm.equalsIgnoreCase("Y")) {
            int damage = selectedSpell.getPowerLevel();
            System.out.println("You cast " + selectedSpell.getName() + " for " + damage + " damage.");
            troll.setHealth(trollHealth - damage);
        } else {
            castSpell();
        }
    }

    private void usePotion() {
        // display potions and get user input
        System.out.println("\n-- Potions --");
        for (Potion potion : wizard.getPotions()) {
            System.out.println(potion.getName());
        }
        System.out.println("-------------");
        String input = scanner.nextLine();

        // find the selected potion
        Potion selectedPotion = null;
        for (Potion potion : wizard.getPotions()) {
            if (input.equalsIgnoreCase(potion.getName())) {
                selectedPotion = potion;
                break;
            }
        }

        // handle invalid input
        if (selectedPotion == null) {
            System.out.println("Invalid potion. Please try again.");
            usePotion();
            return;
        }

        // display potion description and prompt for confirmation
        System.out.println("\n" + selectedPotion.getDescription());
        System.out.println("Do you want to use " + selectedPotion.getName() + "? (Y/N)");
        String confirm = scanner.nextLine();

        // handle user confirmation
        if (confirm.equalsIgnoreCase("Y")) {
            int healing = selectedPotion.getHealthPoints();
            System.out.println("You use " + selectedPotion.getName() + " for " + healing + " healing.");
            wizard.setHealth(wizard.getHealth() + healing);
        } else {
            usePotion();
        }
    }

    private void fight() {
        System.out.println("\n-- Fight --");

        // create a new Troll instance as the boss enemy
        troll = new Enemy("Troll", 100, 20);

        // fight loop
        while (true) {
            // display wizard and troll health
            System.out.println("\n" + wizard.getName() + ": " + wizard.getHealth() + "/" + wizard.getMaxHealth());
            System.out.println(troll.getName() + ": " + troll.getHealth());

            // prompt for player action
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Use a potion");
            String action = scanner.nextLine();

            // handle player action
            if (action.equals("1")) {
                castSpell();
            } else if (action.equals("2")) {
                usePotion();
            } else {
                System.out.println("Invalid action. Please try again.");
            }

            // check if troll is defeated

        }
    }

    public void upgrade(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to upgrade your maxHealth (type '1') or your power multiplier (type '2')?");
        int choice = scanner.nextInt();
        if (choice == 1) {
            int newMaxHealth = wizard.getMaxHealth() + 10;
            wizard.setMaxHealth(newMaxHealth);
            System.out.println("Your max health has been increased to " + newMaxHealth + "!");
        } else if (choice == 2) {
            int newPowerMultiplier = (int) (wizard.getPower() + 1);
            wizard.setPower(newPowerMultiplier);
            System.out.println("Your power multiplier has been increased to " + newPowerMultiplier + "!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}